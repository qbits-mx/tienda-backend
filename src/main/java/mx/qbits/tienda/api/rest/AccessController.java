/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     mx.qbits.tienda.api.rest
 * Proyecto:    tienda
 * Tipo:        Clase
 * Nombre:      AccessController
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:22:14
 */
package mx.qbits.tienda.api.rest;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import mx.qbits.tienda.api.model.domain.Usuario;
import mx.qbits.tienda.api.model.domain.UsuarioDetalle;
import mx.qbits.tienda.api.model.exceptions.ControllerException;
import mx.qbits.tienda.api.model.request.CredencialesRequest;
import mx.qbits.tienda.api.model.response.LoginResponse;
import mx.qbits.tienda.api.service.HealthService;
import mx.qbits.tienda.api.service.LoginService;

/**
 * Implementacion  del controlador REST asociado a los endpoints
 * de gestión por HealthService.
 *
 * <p>Todos los métodos de esta clase disparan {@link ControllerException}</p>
 *
 * <p>NOTA IMPORTANTE: Los  distntos métodos de este controlador no
 * llevan  javadoc  debido a que la  documentación  Swagger  API
 * cumple con ese objetivo.</p>
 *
 * @author  garellano
 * @see     mx.qbits.tienda.api.service.HealthService
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@RestController
@Api(value = "admin")
@RequestMapping(value = "/api")
public class AccessController {
    private static final Logger logger = LoggerFactory.getLogger(AccessController.class);
    private HealthService healthService;

    @Value("${app.profile.identifier}")
    private String appProfileIdentifier;

    @Value("${spring.datasource.url}")
    private String springDatasourceUrl;

    @Value("${app.backend.version}")
    private String version;

    @Value("${kebblar.profile}")
    private String kebblarProfile;

    @Autowired
    private RestTemplate restTemplate;
    
    
    private LoginService loginService;
    
    
    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param healthService Servicios de HealthService
     */
    public AccessController(HealthService healthService, LoginService loginService) {
        this.healthService = healthService;
        this.loginService = loginService;
    }

    @ApiOperation( value = "AccessController::UploadPictures")
    @PostMapping(path="/UploadPictures", produces = "application/json; charset=utf-8")
    public String upload(
        @ApiParam(name = "request", value = "MultipartFile del archivo")
        MultipartHttpServletRequest request,
        HttpServletResponse response){

        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String value = request.getParameter(name);
            logger.info("{} : {}", name, value);
        }

        Map<String, MultipartFile> fileMap = request.getFileMap();
        for (MultipartFile multipartFile : fileMap.values()) {
            logger.info(multipartFile.getOriginalFilename());
        }
        return "ok";
    }

    @ApiOperation(value = "AccessController::logout", notes = "Provoca un 'logout' del usuario firmado en el sistema")
    @GetMapping(path = "/logout.json", produces = "application/json; charset=utf-8")
    public String logout(HttpServletRequest request) throws ServletException {
        String name = "tavo";
        request.logout();
        String res = "{-" + name + "-:-you have been loged out-}";
        return res.replace('-', '"');
    }

    @ApiOperation(value = "AccessController::health", notes = "Entrega un informe a cerca de las variables del sistema")
    @GetMapping(path = "/health.json", produces = "application/json; charset=utf-8")
    public Map<String, String> health(
            @ApiParam(name = "inputData", value = "Los datos de entrada", defaultValue = "ls")
            @RequestParam String inputData, HttpServletRequest request
        ) throws IOException {
        logger.info("*** Application Profile Identifier: {}", appProfileIdentifier);
        Map<String, String> result = healthService.getInfo(inputData);
        result.put("app.profile.identifier", appProfileIdentifier);
        result.put("spring.datasource.url", springDatasourceUrl);
        result.put("app.backend.version", version);
        result.put("kebblar.profile", kebblarProfile);
        result.put("remote.add",request.getRemoteAddr()); 
        result.put("remote.add.2",request.getHeader("X-Forwarded-For"));
        return result;
    }

    @ApiOperation(value = "AccessController::health", notes = "Entrega el log del sistema")
    @GetMapping(path = "/log.json", produces = "application/json; charset=utf-8")
    public List<String> getLog(
            @ApiParam(name = "last", value = "Número de lineas", defaultValue = "1")
            @RequestParam Integer last) {
        return healthService.getLog(last);
    }

    @GetMapping(path = "/qa-stats.json", produces = "application/json; charset=utf-8")
    public String getQualityStats(
            @RequestParam int page, @RequestParam int len) {
        final String uri = "https://sonar.ci.ultrasist.net/api/issues/search?ps=" + len + "&p="
                + page
                + "&componentKeys=mx.gob.impi.chatbot.persistence:chatbot-persistence-layer";
        try {
            return restTemplate.getForObject(uri, String.class);
        } catch (RuntimeException e) {
            return "{'error':'" + e.getMessage() + "', 'uri':'" + uri + "'}".replace("'", "\"");
        }
    }
    
    @PostMapping(path = "/acceso/login", produces = "application/json; charset=utf-8")
    public LoginResponse login(@RequestBody CredencialesRequest cred) throws ControllerException {
        return loginService.login(cred.getUsuario(), cred.getClave());
    }
    
    @PutMapping(
            path = "/usuarios",
            produces = "application/json; charset=utf-8")
    public Usuario updateUsuario(
            @RequestHeader("jwt") String jwt,
            @ApiParam(
                    name = "usuario",
                    value = "Actualiza un Usuario empleando todos los atributos provistos")
            @RequestBody Usuario usuario
            ) throws ControllerException {
         //this.verifica(jwt, "ADMIN"); // o sea: sólo un administrador puede actualizar a un usuario cualquiera
         return usuario;//this.usuarioService.actualizaUsuario(usuario);
    }
    
    @PutMapping(
            path = "/usuario-detalles.json",
            produces = "application/json; charset=utf-8")
    public UsuarioDetalle updateUsuarioDetalles(
            @RequestHeader("jwt") String jwt,
            @ApiParam(
                    name = "usuarioDetalle",
                    value = "Actualiza un UsuarioDetalle empleando todos los atributos provistos")
            @RequestBody UsuarioDetalle usuarioDetalle
            ) throws ControllerException {
         return loginService.actualizaUsuarioDetalle(jwt, usuarioDetalle);
    }
}

