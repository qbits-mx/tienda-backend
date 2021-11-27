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

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
import mx.qbits.tienda.api.service.AccessService;

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

    private AccessService accessService;
    
    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param healthService Servicios de HealthService
     */
    public AccessController(AccessService accessService) {
        this.accessService = accessService;
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
    
    @PostMapping(path = "/acceso/login", produces = "application/json; charset=utf-8")
    public LoginResponse login(@RequestBody CredencialesRequest cred) throws ControllerException {
        return accessService.login(cred.getUsuario(), cred.getClave());
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
         return accessService.actualizaUsuarioDetalle(jwt, usuarioDetalle);
    }
    
    @PutMapping(
            path = "/cambia-clave.json",
            produces = "application/json; charset=utf-8")
    public Usuario cambiaClave(
            @RequestHeader("jwt") String jwt,
            @ApiParam(
                    name = "cred",
                    value = "Actualiza la clave empleando los atributos de autenticacion")
            @RequestBody CredencialesRequest cred
            ) throws ControllerException {
         return accessService.cambiaClave(jwt, cred.getUsuario(), cred.getClave());
    }
}

