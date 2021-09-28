/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     mx.qbits.tienda.api.model.exceptions
 * Proyecto:    tienda
 * Tipo:        Clase
 * Nombre:      TokenExpiredException
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 07:58:06
 */
package mx.qbits.tienda.api.model.exceptions;

/**
 * <p>Descripción</p>
 * Excepción que determina cuando el token proporcionado existe, pero ya expiró.
 *
 * <p>Tal y como ocurre en la mayoría de "custom exceptions", sólo contiene
 * constructores con la definición necesaria, que incluye en algunos caos el
 * código HTTP que será devuelto.
 *
 * @author  garellano
 * @see     mx.qbits.tienda.api.model.exceptions.BusinessException
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class TokenExpiredException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;

    /**
     * El token era válido, pero ya ha expirado.
     */
    public TokenExpiredException() {
        super(
            "Token expirado",
            "El token que se ha proporcionado no es válido, ya que ha expirado.",
            1017,
            "CVE_1017",
            HttpStatus.UNAUTHORIZED);
    }

}
