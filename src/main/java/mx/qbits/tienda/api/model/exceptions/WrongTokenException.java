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
 * Nombre:      WrongTokenException
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 07:59:26
 */
package mx.qbits.tienda.api.model.exceptions;

/**
 * Excepción que modela la respuesta a una petición cuyo token fue incorrecto.
 *
 * <p>Tal y como ocurre en la mayoría de "custom exceptions", sólo contiene
 * constructores con la definición necesaria, que incluye en algunos caos el
 * código HTTP que será devuelto.</p>
 *
 * @author  garellano
 * @see     mx.qbits.tienda.api.model.exceptions.BusinessException
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class WrongTokenException extends BusinessException {

    private static final long serialVersionUID = -7083159020205284484L;

    /**
     * <p>Constructor for WrongTokenException.</p>
     *
     * @param e a {@link java.lang.Exception} object.
     */
    public WrongTokenException(Exception e) {
        super(e);
    }

    //Podría ser que esté duplicada esta custom exception @TokenNotExistException
    /**
     * <p>Constructor for WrongTokenException.</p>
     *
     * @param msg a {@link java.lang.String} object.
     */
    public WrongTokenException(String msg) {
        super(
            "El token que se ha proporcionado es incorrecto.",
            msg,
            1025,
            "CVE_1025",
            HttpStatus.FORBIDDEN);
    }
}
