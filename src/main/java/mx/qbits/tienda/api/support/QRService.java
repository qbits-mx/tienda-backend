/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     mx.qbits.tienda.api.support
 * Proyecto:    tienda
 * Tipo:        Interface
 * Nombre:      QRService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:31:13
 */
package mx.qbits.tienda.api.support;

import java.awt.image.BufferedImage;

import mx.qbits.tienda.api.model.exceptions.BusinessException;

/**
 * <p>QRService interface.</p>
 *
 * @author garellano
 * @version $Id: $Id
 */
public interface QRService {
    /**
     * <p>generateQRCodeImage.</p>
     *
     * @param barcodeText a {@link java.lang.String} object.
     * @return a {@link java.awt.image.BufferedImage} object.
     * @throws mx.qbits.tienda.api.model.exceptions.BusinessException if any.
     */
    BufferedImage generateQRCodeImage(String barcodeText) throws BusinessException;
    /**
     * <p>getQRBytes.</p>
     *
     * @param text a {@link java.lang.String} object.
     * @return an array of {@link byte} objects.
     * @throws mx.qbits.tienda.api.model.exceptions.BusinessException if any.
     */
    byte[] getQRBytes(String text) throws BusinessException ;
    /**
     * <p>getQRBytesBase64.</p>
     *
     * @param textToEncode a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     * @throws mx.qbits.tienda.api.model.exceptions.BusinessException if any.
     */
    String getQRBytesBase64(String textToEncode) throws BusinessException;
}
