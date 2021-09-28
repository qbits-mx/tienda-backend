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
 * Nombre:      Crypt
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:34:32
 */
package mx.qbits.tienda.api.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
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
 * <p>Crypt class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 */
public class Crypt {
    String rootPath = "/Users/garellano/emisor/";
    String privateKeyFile = rootPath + "ok.key";
    String certificateFile = rootPath + "ok.cer";

    /**
     * <p>Constructor for Crypt.</p>
     *
     * @param rootPath a {@link java.lang.String} object.
     * @param certificateFile a {@link java.lang.String} object.
     * @param privateKeyFile a {@link java.lang.String} object.
     */
    public Crypt(String rootPath, String certificateFile, String privateKeyFile) {
        this.rootPath = rootPath;
        this.certificateFile = certificateFile;
        this.privateKeyFile = privateKeyFile;
    }

    /**
     * <p>firma.</p>
     *
     * @param textoParaEncripcion a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     * @throws java.lang.Exception if any.
     */
    public String firma(String textoParaEncripcion) throws Exception {
//        String certData = readFile(certificateFile);
//        certData = certData.substring(28, certData.length()-26);
//
//        String pkData = readFile(privateKeyFile);
//        pkData = pkData.substring(28, pkData.length()-26);
        return firma(this.certificateFile, this.privateKeyFile, textoParaEncripcion);
    }
    /**
     * <p>decrypt.</p>
     *
     * @param textoEncriptado a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     * @throws java.lang.Exception if any.
     */
    public String decrypt(String textoEncriptado) throws Exception {
        String certData = readFile(this.certificateFile);
        Certificate cer = getCertificateFromString22(certData.substring(28, certData.length()-26));//"MIIC5DCCAk2gAwIBAgIJAJ9BmcbMq9pvMA0GCSqGSIb3DQEBCwUAMIGKMQswCQYDVQQGEwJNWDELMAkGA1UECAwCREYxDzANBgNVBAcMBm1leGljbzEVMBMGA1UECgwMRW1pc29yIER1bW15MRQwEgYDVQQLDAtkZXZlbG9wbWVudDERMA8GA1UEAwwIbXgucWJpdHMxHTAbBgkqhkiG9w0BCQEWDmFkbWluQHFiaXRzLm14MB4XDTE3MDIyNDIzMzc1N1oXDTE4MDIyNDIzMzc1N1owgYoxCzAJBgNVBAYTAk1YMQswCQYDVQQIDAJERjEPMA0GA1UEBwwGbWV4aWNvMRUwEwYDVQQKDAxFbWlzb3IgRHVtbXkxFDASBgNVBAsMC2RldmVsb3BtZW50MREwDwYDVQQDDAhteC5xYml0czEdMBsGCSqGSIb3DQEJARYOYWRtaW5AcWJpdHMubXgwgZ8wDQYJKoZIhvcNAQEBBQADgY0AMIGJAoGBAJ0iCj8XZ1dlL70OXZNgY0SxB3Bf2Hzi0yfVrhbpugy587Tt1T8lsNYi1mdQZ1qSKgMHmPGoWJrRgGAUrklz3waet7hh0YZQoz91ezjcS0F4o6GkvCoiz+Dw9dGC0ptCBdSZ7ZUuimMwg5UrR3ItQkcrMiJ9507hQz37/jbfkP9LAgMBAAGjUDBOMB0GA1UdDgQWBBQM6k95blp7spy9UOfEFYuJmvQ2LzAfBgNVHSMEGDAWgBQM6k95blp7spy9UOfEFYuJmvQ2LzAMBgNVHRMEBTADAQH/MA0GCSqGSIb3DQEBCwUAA4GBACqt091X7t4MbH6O6KUWbOXhxOFmv++wK6ue0Qhciz8HShPOfjDd2ZYsLu2pSfnWDQrkRoTBQ1ic+dMzWqxb1yV67fKNxdn5k4eH2WcJGmfxbDYx5olFvYeR+RrSFfdjkSBjtWo5Ywb63tSsQwW66wngBpmgt3CQhD+TCTKUVGgL");//CryptoSupport.readFile(certificateFile));
        return decrypt(textoEncriptado.getBytes(), cer);
    }

    private String readFile(String path) throws IOException {
        Path ruta1 = Paths.get(path);
        byte[] encoded = Files.readAllBytes(ruta1);
        return new String(encoded, Charset.defaultCharset());
    }
    private String firma(String certificateFile, String privateKeyFile, String textoParaEncripcion) throws Exception {
        byte[] pk = getPrivateKeyBytes(privateKeyFile);
        byte[] textoEncriptadoEnBytes = getTextoEncriptadoFromPrivateKeyFile(textoParaEncripcion , pk, "password");
        String resultado = convert(textoEncriptadoEnBytes);
        return resultado;
    }
    private String convert(byte[] source) {
        return new String(source);
    }
    private Certificate getCertificateFromString22(String certificateString) throws CertificateException, FileNotFoundException {
        InputStream stream = new ByteArrayInputStream(addCertPaddings(certificateString).getBytes(StandardCharsets.UTF_8));
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        return cf.generateCertificate(stream);
    }
    private String addCertPaddings(String source) {
        return "-----BEGIN CERTIFICATE-----\n" + addBreaks(source) + "\n-----END CERTIFICATE-----";
    }
    private String addBreaks(String source) {
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<source.length()+1; i++) {
            sb.append(source.charAt(i-1));
            if(i%76==0) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private String decrypt(byte[] textoEncriptadoEnBytes, Certificate cer) throws Exception {
        byte[] textoEncriptadoEnBytesDecodedBase64 = Base64.getDecoder().decode(textoEncriptadoEnBytes);
        byte[] decripted = decryptWithPublicKey(textoEncriptadoEnBytesDecodedBase64, cer.getPublicKey());
        return convert(decripted);
    }
    private byte[] decryptWithPublicKey(byte[] text, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher.doFinal(text);
    }
    private byte[] getPrivateKeyBytes(String privateKeyFile) throws IOException {
        File initialFile = new File(privateKeyFile);
        InputStream privateKeyInputStream = new FileInputStream(initialFile);
        return IOUtils.toByteArray(privateKeyInputStream);
    }
    private byte[] getTextoEncriptadoFromPrivateKeyFile(String texto, byte[] clavePrivada, String password) throws GeneralSecurityException {
        PKCS8Key pkcs8 = new PKCS8Key(clavePrivada, password.toCharArray());
        PrivateKey pk = pkcs8.getPrivateKey();
        // http://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#Signature
        Signature firma = Signature.getInstance("NONEwithRSA"); // MD5withRSA,SHA256withRSA,NONEwithRSA
        firma.initSign(pk);
        // Aqui calculo el SHA-256 en vez de usar el que me da este algoritmo
        firma.update(texto.getBytes());
        return Base64.getEncoder().encode(firma.sign());
    }

}
