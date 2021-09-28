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
 * Nombre:      DisabledUserException
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 07:56:14
 */
package mx.qbits.tienda.api.model.exceptions;

/**
 * <p>Descripción:</p>
 * Excepción que modela la respuesta a una petición de autenticación
 * cuyo usuario fue deshabilitado.
 *
 * <p>Tal y como ocurre en la mayoría de "custom exceptions", sólo contiene
 * constructores con la definición necesaria, que incluye en algunos casos el
 * código HTTP que será devuelto.</p>
 *
 * @author  garellano
 * @see     mx.qbits.tienda.api.model.exceptions.BusinessException
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class DisabledUserException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;

    /**
     * Se lanza cuando un usuario se encuentra bloqueado o deshabilitado del sistema.
     */
    public DisabledUserException() {
        super(
            "Error de ingreso",
            "El usuario ha sido deshabilitado.",
            1005,
            "CVE_1006",
            HttpStatus.BAD_REQUEST);
    }
}
