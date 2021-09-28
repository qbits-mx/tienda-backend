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
 * Nombre:      JwtManagerService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:30:12
 */
package mx.qbits.tienda.api.support;

import mx.qbits.tienda.api.model.exceptions.BusinessException;

/**
 * <p>Descripción:</p>
 * Interface asociado al servicio de JSON Web Tokens
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public interface JwtManagerService {
    /**
     * Crea el JWT para el usuario solicitado
     *
     * @param username Cadena con el nombre de usuario
     *                 para el que se le genera el JWT
     * @return Cadena con el JSON Web Token
     */
    String createToken(String username);

    /**
     * Verifica que el JWT que se recibe correnponde con
     * el usuario que se quiere autorizar
     *
     * @param jwt a {@link java.lang.String} object.
     * @param user a {@link java.lang.String} object.
     * @throws mx.qbits.tienda.api.model.exceptions.BusinessException if any.
     */
    void verifyToken(String jwt, String user) throws BusinessException;

    /**
     * Devuelve el correo electrónico de un usuario pasado una cadena jwt
     *
     * @param jwt a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     * @throws mx.qbits.tienda.api.model.exceptions.BusinessException if any.
     */
    String getMail(String jwt) throws BusinessException;
}
