/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     mx.qbits.tienda.api.utils
 * Proyecto:    tienda
 * Tipo:        Clase
 * Nombre:      DigestEncoder
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:35:48
 */
package mx.qbits.tienda.api.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase de soporte para generar el hash (SHA-256) de otra cadena pero con un 'salt' dado.
 *
 * @author GAA (20190926_14_16)
 * @version 1.0
 */
public class DigestEncoder  {
    private static final Logger logger = LoggerFactory.getLogger(DigestEncoder.class);

    private DigestEncoder() {
    }

    /**
     * <p>createChecksum.</p>
     *
     * @param filename a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public static String createChecksum(String filename) {
        try (InputStream fis =  new FileInputStream(filename)) {
            byte[] buffer = new byte[1024];
            MessageDigest complete = MessageDigest.getInstance("SHA-256");
            int numRead;
            do {
                numRead = fis.read(buffer);
                if (numRead > 0) {
                    complete.update(buffer, 0, numRead);
                }
            } while (numRead != -1);
            //fis.close();
            byte[] digestion = complete.digest();
            return toHexString(digestion);
        } catch(Exception e) {
            return "";
        }
    }

    /**
     * <p>digest.</p>
     *
     * @param source a {@link java.lang.String} object.
     * @param salt a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public static String digest(String source, String salt) {
        try {
            return toHexString(getSHA256(source, salt));
        } catch (NoSuchAlgorithmException e) {
            logger.error("This Wouldn't ocurr never ever...");
            logger.error(e.getMessage());
            return null;
        }
    }

    /**
     * Regresa un arreglo de bytes que es la digestión de un input dado y un 'salt' dado.
     * Generalmente, el 'salt' va a ser el usuario, para este caso de uso. (Auth)
     *
     * @param source Cadena a digestar (Generalmente el password)
     * @param salt Cadena a incluir como 'salt' (Generalmente el Usuaio)
     *
     * @return Areeglo de bytes con la composición digestada
     *
     * @throws NoSuchAlgorithmException No va a pasar nunca, ya que el SHA-256 siempre exste
     */
    private static byte[] getSHA256(String source, String salt) throws NoSuchAlgorithmException {
        // Create the 'input' String with a 'salt', generally,
        String input = source + salt;
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Convierte un arreglo de bytes en una cadena hexadecimal.
     *
     * @param hash Arreglo de bytes a ser convertido a cadena.
     *
     * @return Cadena asociada al arreglo dado
     */
    private static String toHexString(byte[] hash) {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }

        // Show me the result, baby
        return hexString.toString();
    }

    /**
     * Retorna una cadena de 'len' caracteres aleatoria
     *
     * @param len longitud de la cadena retornada
     * @return String aleatorio
     */
    public static String getRandomString(int len) {
        StringBuilder result = new StringBuilder();
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for(int i =0; i<len; i++) {
            double position = Math.random()*(base.length());
            result.append(base.charAt((int)position));
        }
        return result.toString();
    }
}
