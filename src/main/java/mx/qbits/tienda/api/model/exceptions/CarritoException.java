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
 * Nombre:      CarritoException
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 07:56:04
 */
package mx.qbits.tienda.api.model.exceptions;

/**
 * <p>Descripción:</p>
 * Excepción que es lanzada cuando ocurre un problema al procesar la actualización
 * de un carrito de compras del aplicativo.
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
public class CarritoException extends BusinessException {
    private static final long serialVersionUID = -2374644132039662770L;
    private static final String DETAILED_MESSAGE = "No pudo actualizarse la orden compra del carrito del usuario %d";

    /**
     * Dado el id del usuario a quien corresponde el carrito, lanza una excepción informando que
     * determinada compra no pudo ser asociada a los items que este usuario agregó a su carrito.
     *
     * @param idUser id del usuario afectado
     */
    public CarritoException(int idUser) {
        super(
            "Error al asociar el carrito a una compra",
            String.format(DETAILED_MESSAGE, idUser),
            1004,
            "CVE-1004",
            HttpStatus.BAD_REQUEST);
    }
}
