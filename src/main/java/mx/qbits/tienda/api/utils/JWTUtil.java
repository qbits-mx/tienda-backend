/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.utils
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      JWTUtil
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:36:01
 */
package mx.qbits.tienda.api.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import mx.qbits.tienda.api.model.exceptions.CustomException;
import static mx.qbits.tienda.api.model.enumerations.EnumMessage.*;

/**
 * Clase JWTUtil.
 *
 * @author garellano
 * @version $Id: $Id
 */
public class JWTUtil {
    private static final Logger logger = LoggerFactory.getLogger(JWTUtil.class);
    private static JWTUtil instance = null;

    private JWTUtil() {
    }

    /**
     * <p>Getter for the field <code>instance</code>.</p>
     *
     * @return a {@link io.kebblar.petstore.api.utils.JWTUtil} object.
     */
    public static JWTUtil getInstance() {
        if(instance==null) {
            instance = new JWTUtil();
        }
        return instance;
    }

    /**
     * <p>digest.</p>
     *
     * @param source a {@link java.lang.String} object.
     * @param salt a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public String digest(String source, String salt) {
        try {
            return toHexString(getSHA256(source, salt));
        } catch (NoSuchAlgorithmException e) {
            // This Wouldn't ocurr never ever...
            return null;
        }
    }

    /**
     * Regresa un arreglo de bytes que es la digestión de un input dado y un 'salt' dado.
     * Generalmente, el 'salt' va a ser el usuario, para este caso de uso. (Auth)
     *
     * @param source Cadena a digestar (Generalmente el password)
     * @param salt Cadena a incluir como 'salt' (Generalmente el Usuaio)
     * @return Areeglo de bytes con la composición digestada
     * @throws java.security.NoSuchAlgorithmException No va a pasar nunca, ya que el SHA-256 siempre exste
     */
    public byte[] getSHA256(String source, String salt) throws NoSuchAlgorithmException {
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
     * @return Cadena asociada al arreglo dado
     */
    public String toHexString(byte[] hash) {
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
     * Verifica que un token sea válido y que le pertenezca al usuario
     * que le es pasado como parámetro.
     *
     * @param jwt a {@link java.lang.String} object.
     * @param user a {@link java.lang.String} object.
     * @param encryptKey a {@link java.lang.String} object.
     * @throws io.kebblar.petstore.api.model.exceptions.CustomException
     */
    public void verifyToken(String jwt, String user, String encryptKey) throws CustomException {
        try {
            Claims claims = Jwts.parser()
               .setSigningKey(encryptKey.getBytes())
               .parseClaimsJws(jwt).getBody();
            if(logger.isDebugEnabled()) {
                logger.info("ID: " + claims.getId());
                logger.info("Subject: " + claims.getSubject());
                logger.info("Issuer: " + claims.getIssuer());
                logger.info("Expiration: " + claims.getExpiration());
                logger.info("IssuedAt: " + claims.getIssuedAt());
            }
            if(!user.equals(claims.getId())) {
                throw new CustomException(ISSUER_NOT_VERIFIED);
            }
        } catch(Exception e) {
            throw new CustomException(e, WRONG_TOKEN);
        }
    }

    /**
     * Segunda versión de verifyToken que regresa el ID dentro del token o bien
     * dispara una excepción en caso de que el token o sea inválido.
     *
     * @param jwt a {@link java.lang.String} object.
     * @param encryptKey a {@link java.lang.String} object.
     * @param ahorita a long.
     * @return Cadena con el ID contenido en un Token válido
     * @throws io.kebblar.petstore.api.model.exceptions.CustomException
     */
    public String verifyToken(String jwt, String encryptKey, long ahorita) throws CustomException {
        try {
            Claims claims = Jwts.parser()
               .setSigningKey(encryptKey.getBytes())
               .parseClaimsJws(jwt).getBody();
            long expiration = claims.getExpiration().getTime();
            if(expiration < ahorita) throw new CustomException(TOKEN_EXPIRED);
            //showInfo(claims);
            return claims.getId();
        } catch(Exception e) {
        	throw new CustomException(e, WRONG_TOKEN);
        }
    }

    /**
     * <p>showInfo.</p>
     *
     * @param claims a {@link io.jsonwebtoken.Claims} object.
     */
    public void showInfo(Claims claims) {
        logger.info("ID: " + claims.getId());
        logger.info("Subject: " + claims.getSubject());
        logger.info("Issuer: " + claims.getIssuer());
        logger.info("Expiration: " + claims.getExpiration());
        logger.info("IssuedAt: " + claims.getIssuedAt());
    }

    /**
     * <p>valida.</p>
     *
     * @param token a {@link java.lang.String} object.
     * @param encryptKey a {@link java.lang.String} object.
     * @param currentTime a long.
     * @throws java.lang.Exception if any.
     */
    public void valida(String token, String encryptKey, long currentTime) throws Exception {
        if(token==null || token.trim().length()<1) return;
        // from: https://jwt.io/
        Base64.Decoder decoder = Base64.getDecoder();
        String[] chunks = token.split("\\.");
        if(chunks.length<2) throw new CustomException(TOKEN_INVALID_STRUCTURE, token);
        String payload = new String(decoder.decode(chunks[1]));

        if(!payload.contains("\"exp\":")) throw new CustomException(TOKEN_INVALID_STRUCTURE, token);
        Long inst = 0L;
        String instante = "";
        for(String parte : payload.split(",")) {
            if(parte.contains("\"exp\":")) {
                try {
                    instante = parte.substring(6, parte.length()-1)+"000";
                    inst = Long.parseLong(instante);
                } catch(Exception e) {
                    throw new CustomException(TOKEN_INVALID_STRUCTURE, token);
                }
                if (inst < currentTime) throw new CustomException(TOKEN_EXPIRED);
            }
        }
    }

//    public static void main(String...argv) {
//        String token="eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJjcnlwdG8tZXhlY3V0b3Itand0TWFuYWdlciIsImlhdCI6MTYyNTUyMTYyNiwic3ViIjoiQ29vbCBqd3QgVG9rZW4gb246IDE2MjU1MjE2MjYyMTIiLCJqdGkiOiJndXN0YXZvLWFyZWxsYW5vQGdtYWlsLmNvbSIsImV4cCI6MTYyNTUyMzQyNn0._Omitk0L5XDduhPGaWcmvWBArimQw4lE8qthXK6q1Ys";
//        boolean res = isExpired(token);
//        System.out.println(res);
//    }

    /**
     * <p>createToken.</p>
     *
     * @param username a {@link java.lang.String} object.
     * @param securityTokenLasts a int.
     * @param encryptKey a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public String createToken(final String username, int securityTokenLasts, String encryptKey) {
        byte[] key = encryptKey.getBytes();

        Calendar calendar = Calendar.getInstance();
        Date issued = calendar.getTime();

        calendar.add(Calendar.MINUTE, securityTokenLasts);
        Date expiration = calendar.getTime();

        final JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setIssuer("crypto-executor-jwtManager");
        jwtBuilder.setIssuedAt(issued);
        jwtBuilder.setSubject("Cool jwt Token on: " + System.currentTimeMillis());
        jwtBuilder.setId(username);
        jwtBuilder.setExpiration(expiration);
        String token = jwtBuilder.signWith(SignatureAlgorithm.HS256, key).compact();
        logger.debug("Token for '"+username+"' has been created: " + token);
        return token;
    }

    /**
     * <p>getMail.</p>
     *
     * @param jwt a {@link java.lang.String} object.
     * @param encryptKey a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     * @throws io.kebblar.petstore.api.model.exceptions.CustomException if any.
     */
    public String getMail(String jwt, String encryptKey) throws CustomException {
        Claims claim;
        try{
            claim = Jwts.parser().setSigningKey(encryptKey.getBytes()).parseClaimsJws(jwt).getBody();
        } catch (Exception e){
            throw new CustomException(e, TOKEN_INVALID_STRUCTURE, jwt);
        }
        return claim.getId();
    }

}
