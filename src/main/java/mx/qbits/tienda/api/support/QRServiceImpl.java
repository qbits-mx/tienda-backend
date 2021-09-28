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
 * Tipo:        Clase
 * Nombre:      QRServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:31:36
 */
package mx.qbits.tienda.api.support;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import mx.qbits.tienda.api.model.exceptions.BusinessException;

/**
 * <p>QRServiceImpl class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 */
@Service
public class QRServiceImpl implements QRService {
    private Logger logger = LoggerFactory.getLogger(QRServiceImpl.class);

    /** {@inheritDoc} */
    @Override
    public BufferedImage generateQRCodeImage(String barcodeText) throws BusinessException {
        try {
            logger.info("Processing: " + barcodeText);
            QRCodeWriter barcodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = barcodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, 200, 200);
            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch(Exception e) {
            throw new BusinessException(e.toString(), e.toString());
        }
    }

    /** {@inheritDoc} */
    @Override
    public byte[] getQRBytes(String text) throws BusinessException {
        try {
            BufferedImage data = this.generateQRCodeImage(text);
            return toByteArray(data, "png");
        } catch(Exception e) {
            throw new BusinessException(e.toString(), e.toString());
        }
    }

    /** {@inheritDoc} */
    @Override
    public String getQRBytesBase64(String textToEncode) throws BusinessException {
        try {
            BufferedImage data = this.generateQRCodeImage(textToEncode);
            return Base64.getEncoder().encodeToString(toByteArray(data, "jpg"));
        } catch(Exception e) {
            throw new BusinessException(e.toString(), e.toString());
        }
    }

    private byte[] toByteArray(BufferedImage bi, String format) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bi, format, baos);
        return baos.toByteArray();
    }
}
