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
 * Nombre:      UploadServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:32:11
 */
package mx.qbits.tienda.api.support;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.apache.tika.Tika;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import mx.qbits.tienda.api.model.domain.UploadModel;
import mx.qbits.tienda.api.model.exceptions.UploadException;
import mx.qbits.tienda.api.utils.WaterMark;

/**
 * Clase encargada de gestionar los archivos que se suben desde el cliente web.
 *
 * @author garellano
 * @version $Id: $Id
 */
@Service
public class UploadServiceImpl implements UploadService {
    /** logger. */
    private Logger logger = LoggerFactory.getLogger(UploadServiceImpl.class);

    /** tika. */
    private Tika tika = new Tika();

    /** {@inheritDoc} */
    @Override
    public List<UploadModel> store(MultipartFile[] mpfArray, String destinationFolder, long max) throws UploadException {
        List<UploadModel> lista = new ArrayList<>();
        for (MultipartFile mpf : mpfArray) {
            lista.add(storeOne(mpf, destinationFolder, max));
        }
        return lista;
    }

    /**
     * Valida.
     *
     * @param mpf the mpf
     * @throws UploadException the upload exception
     */
    private void valida(MultipartFile mpf, long max) throws UploadException {
        long peso = mpf.getSize();
        if (peso>max) {
            UploadException ue = new UploadException(max, peso);
            throw ue;
        }

        String mimeType = "no-pude-detectar-el-tipo-mime";
        try {
            mimeType = this.tika.detect(mpf.getInputStream());
        } catch (IOException e) {
            throw new UploadException();
            // AQUI, ADEMÁS, VALIDAR QUE EL MIME TYPE ES DE UNA IMAGEN Y NO UNA COSA RARA, COMO UN VIRUS
            // SI SE DETECTA UN ARCHIVO RARO, LANZAR UNA EXCEPCIÓN Y GRABAR EN LA BITACORA UN INCIDENTE GRAVE
        }
        logger.info("{}<-------------- mime type", mimeType);
    }

    /**
     * {@inheritDoc}
     *
     * Store one.
     */
    public UploadModel storeOne(MultipartFile mpf, String destinationFolder, long max) throws UploadException {
        UUID uuid = UUID.randomUUID();
        String newName = uuid.toString() + "."+(FilenameUtils.getExtension(mpf.getOriginalFilename()));
        int autoIncremental = 0;
        valida(mpf, max);
        UploadModel uploadModel = new UploadModel(
                autoIncremental,
                mpf.getOriginalFilename(),
                newName,
                getMd5(mpf),
                new Date(),
                mpf.getSize(),
                true);
        String uploadModelString = uploadModel.toString();
        logger.info("Upload model: {}", uploadModelString);
        Path filepath = Paths.get(destinationFolder, newName);
        //Path filepath = Paths.get("/Users/garellano/Desktop/peliculas", newName);
        try {
            mpf.transferTo(filepath);
            WaterMark.getInstance().addWatermarkOnImage(destinationFolder, newName, "logo.png", "_"+newName);
            // AQUI EN ESTA LINEA HAY QUE GUARDAR EL OBJETO "uploadModel" en la base...
            // Algo asi como la siguiente linea:
            // poner: storageMapper.insert(uploadModel)
            return uploadModel;
        } catch (IllegalStateException | IOException e) {
            throw new UploadException(e);
        }
    }

    /**
     * Gets the md 5.
     *
     * @param mpf the mpf
     * @return the md 5
     * @throws UploadException the upload exception
     */
    private static String getMd5(MultipartFile mpf) throws UploadException {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(mpf.getBytes());
            BigInteger container = new BigInteger(1, messageDigest);
            String hashtext = container.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0".concat(hashtext);
            }
            return hashtext;
        } catch (NoSuchAlgorithmException | IOException e) {
            throw new UploadException(e);
        }
    }

}
