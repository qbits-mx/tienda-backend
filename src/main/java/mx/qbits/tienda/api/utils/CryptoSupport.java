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
 * Nombre:      CryptoSupport
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:34:43
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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;

import org.apache.commons.io.IOUtils;
import org.apache.commons.ssl.PKCS8Key;

public class CryptoSupport {
    private static final Logger logger = LoggerFactory.getLogger(CryptoSupport.class);

    private static String rootPath = "/Users/garellano/emisor/";
    private static String privateKeyFile = rootPath + "ok.key";
    private static String certificateFile = rootPath + "ok.cer";
    private static String pass = "password";
    private static String cadenaOriginalParaFirma = "parangaricutirimicuaro";

    public static void main(String...argv) throws Exception {
        new CryptoSupport().ok();
    }

    public void ok() throws Exception {
        prn("Cadena original para firma:"+cadenaOriginalParaFirma);
        String cadenaFirmada = signWithPrivateKey(cadenaOriginalParaFirma, privateKeyFile, pass);
        prn("Cadena firmada:"+ cadenaFirmada);
        String data = verifySignature(cadenaFirmada, certificateFile); // Verificando con el certificado (que contiene la llave pública)
        prn("Verificación de cadena firmada: "+data);

        byte[] textoEncriptado = signWithCert(cadenaOriginalParaFirma, readFile(certificateFile));
        System.out.println(textoEncriptado.length);

        byte[] r = Base64.getEncoder().encode(textoEncriptado);
        System.out.println(convert(r));
        System.out.println(r.length);

        //byte[] res = cs.decodeWithPrivateKey(r, cs.getPrivateKeyFromFile(privateKeyFile, pass));
        //byte[] decriptado = cs.getTextoEncriptadoFromPrivateKeyFile(new String(textoEncriptado), privateKeyFile, pass);
        //System.out.println(cs.convert(decriptado));
    }

    // Usa el certificado para verifcar que cierto texto encriptado con una llave privada es válido.
    public String verifySignature(String textoEncriptado, String certificateFile) throws Exception {
        String certData = readFile(certificateFile);
        Certificate cer = getCertificateFromString(certData);//.substring(28, certData.length()-26));//"MIIC5DCCAk2gAwIBAgIJAJ9BmcbMq9pvMA0GCSqGSIb3DQEBCwUAMIGKMQswCQYDVQQGEwJNWDELMAkGA1UECAwCREYxDzANBgNVBAcMBm1leGljbzEVMBMGA1UECgwMRW1pc29yIER1bW15MRQwEgYDVQQLDAtkZXZlbG9wbWVudDERMA8GA1UEAwwIbXgucWJpdHMxHTAbBgkqhkiG9w0BCQEWDmFkbWluQHFiaXRzLm14MB4XDTE3MDIyNDIzMzc1N1oXDTE4MDIyNDIzMzc1N1owgYoxCzAJBgNVBAYTAk1YMQswCQYDVQQIDAJERjEPMA0GA1UEBwwGbWV4aWNvMRUwEwYDVQQKDAxFbWlzb3IgRHVtbXkxFDASBgNVBAsMC2RldmVsb3BtZW50MREwDwYDVQQDDAhteC5xYml0czEdMBsGCSqGSIb3DQEJARYOYWRtaW5AcWJpdHMubXgwgZ8wDQYJKoZIhvcNAQEBBQADgY0AMIGJAoGBAJ0iCj8XZ1dlL70OXZNgY0SxB3Bf2Hzi0yfVrhbpugy587Tt1T8lsNYi1mdQZ1qSKgMHmPGoWJrRgGAUrklz3waet7hh0YZQoz91ezjcS0F4o6GkvCoiz+Dw9dGC0ptCBdSZ7ZUuimMwg5UrR3ItQkcrMiJ9507hQz37/jbfkP9LAgMBAAGjUDBOMB0GA1UdDgQWBBQM6k95blp7spy9UOfEFYuJmvQ2LzAfBgNVHSMEGDAWgBQM6k95blp7spy9UOfEFYuJmvQ2LzAMBgNVHRMEBTADAQH/MA0GCSqGSIb3DQEBCwUAA4GBACqt091X7t4MbH6O6KUWbOXhxOFmv++wK6ue0Qhciz8HShPOfjDd2ZYsLu2pSfnWDQrkRoTBQ1ic+dMzWqxb1yV67fKNxdn5k4eH2WcJGmfxbDYx5olFvYeR+RrSFfdjkSBjtWo5Ywb63tSsQwW66wngBpmgt3CQhD+TCTKUVGgL");//CryptoSupport.readFile(certificateFile));
        return decrypt(textoEncriptado.getBytes(), cer);
    }

    public byte[] calculaSha256(String text) throws NoSuchAlgorithmException {
        byte[] bytesFromText = text.getBytes(StandardCharsets.UTF_8);
        byte[] res = MessageDigest.getInstance("SHA-256").digest(bytesFromText);
        return Base64.getEncoder().encode(res);
    }

    /**   **/
    /**
     * Usando la llave privada y un pass, se encripta un texto que luego va a poder ser
     * desencriptado con el certificado o la llave púbkica que el certfcado tiene dentro.
     *
     * @param privateKeyFile Archivo del FileSystem con el contenido de una llave privada
     * @param textoParaEncripcion Texto que será encriptado
     * @param privateKeyFile1
     * @param password1
     * @param pass Clave secreta asociada a la llave privada
     *
     * @return Texto encriptado
     * @throws Exception Envolvente para IOSexception y SecurityException
     *
     * @see {@link #signWithPrivateKey2}
     */
    public String signWithPrivateKey(String textoParaEncripcion, String privateKeyFile, String password) throws Exception {
        byte[] textoEncriptadoEnBytes = getTextoEncriptadoFromPrivateKeyFile(
                textoParaEncripcion, privateKeyFile, password);
        return convert(textoEncriptadoEnBytes);
    }
    public String signWithPrivateKey(String textoParaEncripcion) throws Exception {
        return signWithPrivateKey(textoParaEncripcion, privateKeyFile, pass) ;
    }

    /**  **/




    // Usando un certificado, se encripta un texto que luego se va a poder desencriptar
    // con una llave privada y el pass de esa lave privada
    public byte[] signWithCert(String text, String certificateString) throws Exception {
        X509Certificate cert =  (X509Certificate)getCertificateFromString(certificateString);
        PublicKey publicKey = cert.getPublicKey();
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(text.getBytes());
    }

    // Usando la llave privada de desencripta lo que encripto una llave publica
    public byte[] decodeWithPrivateKey(byte[] text, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(text);
    }





    /** /
    private String addCertPaddings2(String source) {
        //return "-----BEGIN CERTIFICATE-----\n" + addBreaks(source) + "\n-----END CERTIFICATE-----";
        return source;
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
    private String convert(InputStream inputStream) throws IOException {
        // FROM http://stackoverflow.com/questions/309424/read-convert-an-inputstream-to-a-string
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        // StandardCharsets.UTF_8.name() > JDK 7
        return result.toString("UTF-8");
    }
    private X509Certificate getCertificateFromString(String certificateString) throws CertificateException, FileNotFoundException {
        //InputStream stream = new ByteArrayInputStream(add(certificateString).getBytes(StandardCharsets.UTF_8));
        //CertificateFactory cf = CertificateFactory.getInstance("X.509");
        return (X509Certificate)getCertificateFromString22(certificateString);
    }
    private byte[] signWithCert(String text, X509Certificate cert) throws Exception {
        PublicKey publicKey = cert.getPublicKey();
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(text.getBytes());
    }
    private byte[] decode(byte[] text, String certificateString) throws Exception {
        Certificate cert = getCertificateFromString22(certificateString);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, cert);
        return cipher.doFinal(text);
    }
    private byte[] decode(byte[] text, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(text);
    }
    private final void prn(Certificate cer) {
        X509Certificate x509 = (X509Certificate)cer;
        prn(x509.getIssuerDN().getName());
        prn(x509.getSigAlgName());
        prn(x509.getSubjectDN().getName());
        prn(getCommonName(x509));
        prn(x509.getNotAfter().toString());
        prn(x509.getNotBefore().toString());
    }
    private String getCommonName(X509Certificate certificate) {
        String name = certificate.getSubjectX500Principal().getName();
        int start = name.indexOf("CN=");
        int end = name.indexOf(",", start);
        if (end == -1) {
            end = name.length();
        }
        return name.substring(start + 3, end);
    }
/**/




    private String convert(byte[] source) {
        return new String(source);
    }
    private String readFile(String path) throws IOException {
        Path ruta1 = Paths.get(path);
        //Path ruta2 = new File(path).toPath();
        //byte[] encoded = FileUtils.readFileToByteArray(new File(path));
        byte[] encoded = Files.readAllBytes(ruta1);
        return new String(encoded, Charset.defaultCharset());
    }
    private byte[] decryptWithPublicKey(byte[] text, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher.doFinal(text);
    }
    private Certificate getCertificateFromString(String certificateString) throws CertificateException, FileNotFoundException {
        InputStream stream = new ByteArrayInputStream(certificateString.getBytes(StandardCharsets.UTF_8));
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        return cf.generateCertificate(stream);
    }
    private byte[] getPrivateKeyBytes(String privateKeyFile) throws IOException {
        File initialFile = new File(privateKeyFile);
        InputStream privateKeyInputStream = new FileInputStream(initialFile);
        return IOUtils.toByteArray(privateKeyInputStream);
    }
    /*
    private byte[] getTextoEncriptadoFromPrivateKeyFileXXX(String texto, byte[] clavePrivada, String pass) throws GeneralSecurityException {
        PKCS8Key pkcs8 = new PKCS8Key(clavePrivada, pass.toCharArray());
        PrivateKey pk = pkcs8.getPrivateKey();
        // http://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#Signature
        Signature firma = Signature.getInstance("NONEwithRSA"); // MD5withRSA,SHA256withRSA,NONEwithRSA
        firma.initSign(pk);
        // Aqui calculo el SHA-256 en vez de usar el que me da este algoritmo
        firma.update(texto.getBytes());
        return Base64.getEncoder().encode(firma.sign());
    }
    */
    private PrivateKey getPrivateKeyFromFile(String privateKeyFile, String password) throws GeneralSecurityException, IOException {
        byte[] clavePrivada = getPrivateKeyBytes(privateKeyFile);
        PKCS8Key pkcs8 = new PKCS8Key(clavePrivada, password.toCharArray());
        return pkcs8.getPrivateKey();
    }
    public byte[] getTextoEncriptadoFromPrivateKeyFile(String texto, String privateKeyFile, String password) throws GeneralSecurityException, IOException {
        PrivateKey pk = getPrivateKeyFromFile(privateKeyFile, password);
        Signature firma = Signature.getInstance("NONEwithRSA"); // MD5withRSA,SHA256withRSA,NONEwithRSA
        firma.initSign(pk);
        // Aqui calculo el SHA-256 en vez de usar el que me da este algoritmo
        firma.update(texto.getBytes());
        return Base64.getEncoder().encode(firma.sign());
    }







    private static final void prn(String s) {
        logger.debug(s);
    }
    private String decrypt(byte[] textoEncriptadoEnBytes, Certificate cer) throws Exception {
        return decrypt(textoEncriptadoEnBytes, cer.getPublicKey());
    }
    private String decrypt(byte[] textoEncriptadoEnBytes, PublicKey publicKey) throws Exception {
        byte[] textoEncriptadoEnBytesDecodedBase64 = Base64.getDecoder().decode(textoEncriptadoEnBytes);
        byte[] decripted = decryptWithPublicKey(textoEncriptadoEnBytesDecodedBase64, publicKey);
        return convert(decripted);
    }

}

/*
openssl genrsa -out ok.key 1024
openssl req -new -x509 -key ok.key -out ok.cer -days 365
*/