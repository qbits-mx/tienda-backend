/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.support
 * Proyecto:    petstore-back
 * Tipo:        Interface
 * Nombre:      UploadService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:31:54
 */
package mx.qbits.tienda.api.support;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

import mx.qbits.tienda.api.model.domain.UploadModel;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

/**
 * Interface UploadService.
 *
 * @author garellano
 * @version $Id: $Id
 */
public interface UploadService {

    /**
     * Procesa un conjunto de archivos que le son enviados desde el front.
     *
     * @param mpfArray MultipartFile[] arreglo de archivos enviados desde el front
     * @param destinationFolder String path to file destination
     * @param max long max size allowed for the file
     * @return Lista de objetos de tipo UploadModel
     * @throws io.kebblar.petstore.api.model.exceptions.BusinessException Se dispara en caso de que el proceso de upload falle
     */
    public List<UploadModel> store(MultipartFile[] mpfArray, String destinationFolder, long max, int idUsuario) throws BusinessException;

    /**
     * Procesa un archivos que le es enviado desde el front.
     *
     * @param mpf MultipartFile archivo enviados desde el front
     * @param destinationFolder String path to file destination
     * @param max long max size allowed for the file
     * @return Objetos de tipo UploadModel
     * @throws io.kebblar.petstore.api.model.exceptions.BusinessException Se dispara en caso de que el proceso de upload falle
     */
    public UploadModel storeOne(MultipartFile mpf, String destinationFolder, long max , int idUsuario) throws BusinessException;
}
