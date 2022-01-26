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
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import mx.qbits.tienda.api.model.domain.Usuario;
import mx.qbits.tienda.api.model.exceptions.ControllerException;
import mx.qbits.tienda.api.service.HealthService;

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
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
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
    
    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param healthService Servicios de HealthService
     */
    public AdminController(HealthService healthService) {
        this.healthService = healthService;
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
}