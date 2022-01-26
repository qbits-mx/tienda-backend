package mx.qbits.tienda.api.utils;

import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
    
    public String decodeJwt(String jwt) {
        String[] chunks = jwt.split("\\.");
        if(chunks.length<3) throw new RuntimeException("Bad jwt");
        Base64.Decoder decoder = Base64.getDecoder();

        try {
            //String header = new String(decoder.decode(chunks[0]));
            //System.out.println(header);
            String payload = new String(decoder.decode(chunks[1]));
            
            //String signature = new String(chunks[2]);
            //System.out.println(signature);
            
            return payload;
        } catch(IllegalArgumentException e) {
            throw new RuntimeException("Bad jwt");
        }
    }
    
    public String getCorreo(String decodedJwt) {
        return getValueFromDecodedJwtString(decodedJwt, "jti");
    }
    
    public long getExpiration(String decodedJwt) {
        String expStr = getValueFromDecodedJwtString(decodedJwt, "exp");
        return new Long(expStr);
    }
    
    public String getValueFromDecodedJwtString(String decodedJwt, String field) {
        String[] partes = decodedJwt.substring(1, decodedJwt.length()-1).replaceAll("\"", "").split(",");
        Map<String, String> mapa = new HashMap<>();
        for(String parte : partes) {
            String[] d = parte.split(":");
            mapa.put(d[0], d[1]);
        }
        return mapa.get(field);
    }
    
    /**
     * Checa si un token dado (con estructira correcta) ha sido firmado adecuadamente.
     * En caso de que sea un token con una estructira inválida o no esté firmado de una 
     * manera adecuada, dispara una excepción. Si todo esta bien, retorna "true".
     * <p> Es interesante mencionar que si a cadena jwt es verificada exitosamente, entonces
     * es posible parsear (hacer decode) al jwt de manera simple y confiar en la decodificación.
     * Ver decodeJwt para un decode en forma de cadena json.
     * 
     * @param jwt Cadena jwt a verificar
     * @param encryptKey Clave de encripción
     * 
     * @return true, si la cadena jwt es correcta y se verifica la clave
     * @throws CustomException
     */
    public boolean revisaToken(String jwt, String encryptKey) throws CustomException {
        try {
            Jwts
               .parser()
               .setSigningKey(encryptKey.getBytes())
               .parseClaimsJws(jwt).getBody();
            return true;
        } catch(Exception e) {
            throw new CustomException(e, WRONG_TOKEN);
        }
    }
    
    public boolean revisaExpiracion(String decodedJwt) throws CustomException {
        long now = System.currentTimeMillis();
        long someFutureDay = this.getExpiration(decodedJwt);
        if(someFutureDay< now) throw new CustomException(TOKEN_EXPIRED);
        return true;
    }
    
    public boolean revisaSender(String decodedJwt, String sender) throws CustomException {
        String correo = this.getCorreo(decodedJwt);
        if(!sender.equals(correo)) throw new CustomException(TOKEN_INVALID);
        return true;
    }
    
}

/*
{
"iss":"crypto-executor-jwtManager",
"iat":1637609469,
"sub":"Cool jwt Token on: 1637609469452",
"jti":"gustavi",
"exp":1637615469
}
*/