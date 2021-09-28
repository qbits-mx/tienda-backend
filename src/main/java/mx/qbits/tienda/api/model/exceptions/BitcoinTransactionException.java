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
 * Nombre:      BitcoinTransactionException
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 07:54:23
 */
package mx.qbits.tienda.api.model.exceptions;

/**
 * <p>Descripción:</p>
 * Excepción que es lanzada cuando ocurre un problema al procesar una orden de compra
 * pagada con bitcoin.
 *
 * <p>Tal y como ocurre en la mayoría de "custom exceptions", solo contiene
 * constructores con la definición necesaria, que incluye en algunos caos el
 * código HTTP que será devuelto.</p>
 *
 * @author  fhernanda
 * @see     mx.qbits.tienda.api.model.exceptions.BusinessException
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class BitcoinTransactionException extends BusinessException {
    private static final long serialVersionUID = -4440655023335060611L;

    /**
     * Define que ha ocurrido un error al momento de intentar pagar con bitcoin una compra.
     *
     * @param msg Mensaje que describe el problema
     */
    public BitcoinTransactionException(String msg) {
        super(
            "Error al procesar bitcoin como método de pago",
            msg,
            1002,
            "CVE-1002",
            HttpStatus.BAD_REQUEST);
    }
}
