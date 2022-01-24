/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.rest
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      FileUploadController
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:24:46
 */
package mx.qbits.tienda.api.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import mx.qbits.tienda.api.model.domain.UploadModel;
import mx.qbits.tienda.api.model.exceptions.ControllerException;
import mx.qbits.tienda.api.support.UploadService;

/**
 * Endpoint para subir archivos.
 */
@RestController
@Api(value = "negocio")
@RequestMapping(value = "/api")
public class FileUploadController {

    @Value("${app.destination-folder}")
    private String destinationFolder;

    @Value("${app.max-file-size}")
    private long max;

    private final UploadService uploadService;
    private final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    /**
     * Constructor para la inyeccion de dependencias.
     *
     * @param uploadService el servicio que ofrece almacenamiento
     */
    @Autowired
    public FileUploadController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    /**
     * Recibe un(os) archivo(s) del front y lo almacena en la carpeta y almacena una copia en
     * ${app.destination-folder}/kdm y otra copia en ${application.properties}/kdm.
     *
     * @param file archivo a almacenar
     * @return lista que contiene el modelo de donde se almaceno el archivo
     * @throws ControllerException si hay algun error
     */
    @PostMapping(
            path = "/upload.json",
            produces = "application/json; charset=utf-8"
            )
    public UploadModel handleFileUploadWithKDMCopy(
            @RequestHeader("jwt") String jwt,
            @RequestParam("uno") int uno,
            @RequestParam("dos") String dos,
            @RequestParam("file") MultipartFile file
            ) throws ControllerException {
        logger.info(jwt);
        String s = String.valueOf(uno);
        logger.info(s);
        logger.info(dos);
        return uploadService.storeOne(file, destinationFolder, max,1);
    }
    // https://stackoverflow.com/questions/54683075/how-to-implement-multiple-files-upload-with-extra-fields-per-each-file-in-spring
    // https://github.com/ozkanpakdil/spring-examples/tree/master/demoMultiFileUpload
    // https://github.com/ozkanpakdil/spring-examples/blob/master/demoMultiFileUpload/src/main/java/com/mascix/demoMultiFileUpload/Uploader.java

    @PutMapping(
            path = "/upload.json",
            produces = "application/json; charset=utf-8",
            consumes = { "multipart/*" }
            )
    public List<UploadModel> handleFileUploadWithKDMCopyPut(@RequestParam("files") MultipartFile[] files) throws ControllerException {
        return uploadService.store(files, destinationFolder, max,1);
    }
    // https://stackoverflow.com/questions/54683075/how-to-implement-multiple-files-upload-with-extra-fields-per-each-file-in-spring

    @PutMapping(
            path = "/upload2.json",
            produces = "application/json; charset=utf-8",
            consumes = { "multipart/*" }
            )
    public UploadModel upload2(@RequestParam("files") MultipartFile files) throws ControllerException {
        return uploadService.storeOne(files, destinationFolder, max,1);
    }

    @PostMapping(
        path = "/up/imagen.json",
        produces = "application/json; charset=utf-8")
    public UploadModel guardarImagen(
    @ApiParam(name = "idAnuncio", value = "Identificador del anuncio.")
    @RequestHeader("idAnuncio") int idAnuncio,
    @ApiParam(name = "file", value = "Imagen a guardar.")
    @RequestParam("file") MultipartFile file) throws ControllerException {
        return uploadService.storeOne(file, destinationFolder, max,1);
    }

    @PostMapping(
        path = "/up/imagen2.json",
        produces = "application/json; charset=utf-8")
    public List<UploadModel> guardarImagen2(
    @ApiParam(name = "idAnuncio", value = "Identificador del anuncio.")
    @RequestHeader("idAnuncio") int idAnuncio,
    @ApiParam(name = "file", value = "Imagen a guardar.")
    @RequestParam("file") MultipartFile[] files) throws ControllerException {
        return uploadService.store(files, destinationFolder, max,1);
    }
}
/*
curl http://localhost:9999/api/upload.json -X POST \
-F 'files=@/Users/garellano/Desktop/peliculas/01.jpg' \
-F 'files=@/Users/garellano/Desktop/peliculas/02.jpg'


image/png
application/pdf
application/x-tika-ooxml excel
image/jpeg

*/
