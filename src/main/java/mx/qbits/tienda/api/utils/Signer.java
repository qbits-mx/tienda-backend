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
 * Nombre:      Signer
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:36:11
 */
package mx.qbits.tienda.api.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Base64;

import javax.crypto.Cipher;

import org.apache.commons.io.IOUtils;
import org.apache.commons.ssl.PKCS8Key;

/**
 * <p>Descripción:</p>
 * Clase que sirve para firmar archivos y verificar la firma de estos.
 *
 * @author Luis Mtz
 * @version 1.0-SNAPSHOT
 */
public class Signer {

    private String privateKeyFile;
    private String certificateFile;
    private String pass = "hwb4aet!$fser";
    private String file;

    /*
     * Constructor unico de la clase
     */
    /**
     * <p>Constructor for Signer.</p>
     *
     * @param privateKeyFile a {@link java.lang.String} object.
     * @param certFile a {@link java.lang.String} object.
     * @param file a {@link java.lang.String} object.
     */
    public Signer(String privateKeyFile, String certFile, String file) {
        this.privateKeyFile = privateKeyFile;
        this.certificateFile = certFile;
        this.file = file;
    }

    /**
     * Método utilizado para mandar a llamar a todos los metodos que
     * intervienen en el firmado de un archivo.
     *
     * @return un string que representa al pdf firmado.
     * @throws java.lang.Exception es disparada por un error de lectura escritura.
     */
    public String signPdf() throws Exception{
        String hash = createSum(this.file);
        String signedFile = signWithPrivateKey(hash);
        return signedFile;

    }

    /**
     * Método utilizado para obtener el hash de un archivo.
     * El hash utilizado es SHA-256.
     *
     * @return un string en hexadecimal que representa al hash del archivo.
     * @param fileName a {@link java.lang.String} object.
     */
    public String createSum(String fileName) {
        try (InputStream fis =  new FileInputStream(fileName)) {
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
          } catch(NoSuchAlgorithmException | IOException e) {
              return "";
          }
    }

    /**
     * Convierte un arreglo de bytes en una cadena hexadecimal.
     *
     * @param hash Arreglo de bytes a ser convertido a cadena.
     *
     * @return Cadena asociada al arreglo dado
     */
    private static String toHexString(byte[] hash) {
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }


    /**
     * Usa el certificado para verifcar que cierto texto encriptado con una
     * llave privada es válido.
     *
     * @return Cadena obtenida despues de desencriptar el texto recibido como
     * parametro.
     * @param textoEncriptado a {@link java.lang.String} object.
     * @throws java.lang.Exception if any.
     */
    public String verifySignature(String textoEncriptado) throws Exception {
        String certData = readFile(this.certificateFile);
        Certificate cer = getCertificateFromString(certData);
        return decrypt(textoEncriptado.getBytes(), cer.getPublicKey());
    }

    /**
     * Metodo que desencripta un texto en bytes usando una llave publica.
     *
     * @param arreglo de byte textoEncryptadoEnBytes contiene .
     * @param hash Arreglo de bytes a ser convertido a cadena.
     *
     * @return Cadena asociada al arreglo dado
     */
    private String decrypt(byte[] textoEncriptadoEnBytes, PublicKey publicKey) throws Exception {
        byte[] textoEncriptadoEnBytesDecodedBase64 = Base64.getDecoder().decode(textoEncriptadoEnBytes);
        byte[] decripted = decryptWithPublicKey(textoEncriptadoEnBytesDecodedBase64, publicKey);
        return new String(decripted);
    }

    /**
     * Metodo que encripta un texto a partir de una llave privada y un pass.
     *
     * @return Cadena asociada al arreglo dado
     * @param texto a {@link java.lang.String} object.
     * @param privateKeyFile a {@link java.lang.String} object.
     * @param password a {@link java.lang.String} object.
     * @throws java.security.GeneralSecurityException if any.
     * @throws java.io.IOException if any.
     */
    public byte[] getTextoEncriptadoFromPrivateKeyFile(String texto, String privateKeyFile, String password) throws GeneralSecurityException, IOException {
        PrivateKey pk = getPrivateKeyFromFile(privateKeyFile, password);
        Signature firma = Signature.getInstance("NONEwithRSA"); // MD5withRSA,SHA256withRSA,NONEwithRSA
        firma.initSign(pk);
        // Aqui calculo el SHA-256 en vez de usar el que me da este algoritmo
        firma.update(texto.getBytes());
        return Base64.getEncoder().encode(firma.sign());
    }

    /**
     * Usando la llave privada y un pass, se encripta un texto que luego va a poder ser
     * desencriptado con el certificado o la llave púbkica que el certfcado tiene dentro.
     *
     * @param textoParaEncripcion Texto que será encriptado
     * @return Texto encriptado
     * @throws java.lang.Exception Envolvente para IOSexception y Securityjava.lang.Exception
     */
    public String signWithPrivateKey(String textoParaEncripcion) throws Exception {
        byte[] textoEncriptadoEnBytes = getTextoEncriptadoFromPrivateKeyFile(
                textoParaEncripcion, this.privateKeyFile, this.pass);
        return new String(textoEncriptadoEnBytes);
    }

    /**
     * Metodo privado que lee un archivo pdf y regresa un string que contiene el contenido
     * del archivo.
     *
     * @param String path la ruta del archivo pdf.
     *
     * @return Cadena asociada al contenido del archivo.
     */
    private String readFile(String path) throws IOException {
        Path ruta1 = Paths.get(path);
        byte[] encoded = Files.readAllBytes(ruta1);
        return new String(encoded, Charset.defaultCharset());
    }

    /**
     * Metodo privado que desencripta un texto recibido como bytes con ayuda
     * de una llave piblica.
     *
     * @param Arreglo de byte text, texto como arreglo de bytes que queremos
     * desencriptar.
     * @param llave publica con la que se va a desencriptar el texto.
     *
     * @return arreglo de byte que contiene el texto desencryptado.
     */
    private byte[] decryptWithPublicKey(byte[] text, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher.doFinal(text);
    }

    /**
     * Metodo privado que obtiene un objeto de tipo Certificate a partir de
     * un string que contiene el certificado.
     *
     * @param String certificateString, el certificado en forma de string.
     *
     * @return objeto de tipo string que representa al certificado recibido
     * como parametro.
     */
    private Certificate getCertificateFromString(String certificateString) throws CertificateException, FileNotFoundException {
        InputStream stream = new ByteArrayInputStream(certificateString.getBytes(StandardCharsets.UTF_8));
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        return cf.generateCertificate(stream);
    }

    /**
     * Metodo privado que obtiene un array de bites a partir de una llave privada recibida
     * como parametro.
     *
     * @param String certificateString, el certificado en forma de string.
     *
     * @return arreglo de byte que contiene los bytes de la llave privada
     * recibida como parametro.
     */
    private byte[] getPrivateKeyBytes(String privateKeyFile) throws IOException {
        File initialFile = new File(privateKeyFile);
        InputStream privateKeyInputStream = new FileInputStream(initialFile);
        return IOUtils.toByteArray(privateKeyInputStream);
    }

    /**
     * Metodo privado que obtiene una instancia de la clase PrivateKey.
     *
     * @param String privateKeyFile, string que contiene la llave privada.
     * @param String pass, el pass.
     *
     * @return instancia de la calse PrivateKey.
     */
    private PrivateKey getPrivateKeyFromFile(String privateKeyFile, String password) throws GeneralSecurityException, IOException {
        byte[] clavePrivada = getPrivateKeyBytes(privateKeyFile);
        PKCS8Key pkcs8 = new PKCS8Key(clavePrivada, password.toCharArray());
        return pkcs8.getPrivateKey();
    }
}
