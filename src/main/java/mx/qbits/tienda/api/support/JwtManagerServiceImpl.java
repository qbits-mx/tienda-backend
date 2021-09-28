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
 * Nombre:      JwtManagerServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:30:28
 */
package mx.qbits.tienda.api.support;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.utils.JWTUtil;

/**
 * <p>JwtManagerServiceImpl class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 */
@Service
public class JwtManagerServiceImpl implements JwtManagerService {
    private Logger logger = LoggerFactory.getLogger(JwtManagerServiceImpl.class);

    private JWTUtil jwUtil = JWTUtil.getInstance();

    @Value("${security.token.lasts}")
    private String securityTokenLastsString;

    @Value("${jwt.encryptor.password}")
    private String ENCRYPT_KEY;
    private int securityTokenLasts;

    /**
     * <p>Constructor for JwtManagerServiceImpl.</p>
     */
    public JwtManagerServiceImpl() {
    }

    /**
     * <p>init.</p>
     */
    @PostConstruct
    public void init() {
        // es obvio que estos valores los tengo hasta después de
        // que se terminó de ejecutar el constrctor de la clase
        logger.info("securityTokenLastsString: " + this.securityTokenLastsString);
        try {
            this.securityTokenLasts =Integer.parseInt(securityTokenLastsString);
        } catch (Exception e) {
            logger.error(e.getMessage());
            this.securityTokenLasts = 27; // 27 minutos dura el jwt
        }
        logger.info("Duración de token de seguridad: "+securityTokenLasts);
        logger.info("Llave de encripción para el token JWT: >>>"+ENCRYPT_KEY+"<<<");
    }

    /** {@inheritDoc} */
    @Override
    public String createToken(final String username) {
        return jwUtil.createToken(username, securityTokenLasts, ENCRYPT_KEY);
    }

    /** {@inheritDoc} */
    @Override
    public void verifyToken(String jwt, String user) throws BusinessException {
        jwUtil.verifyToken(jwt, user, ENCRYPT_KEY);
    }

    /** {@inheritDoc} */
    @Override
    public String getMail(String jwt) throws BusinessException {
        return jwUtil.getMail(jwt, ENCRYPT_KEY);
    }

}
