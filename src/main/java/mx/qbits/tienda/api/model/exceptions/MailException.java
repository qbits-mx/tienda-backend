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
 * Nombre:      MailException
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 07:57:15
 */
package mx.qbits.tienda.api.model.exceptions;

/**
 * <p>Descripción:</p>
 * Excepción que modela la respuesta a una petición de envío de correos
 * cuya salida no tuvo éxito.
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
public class MailException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;

    /**
     * Se lanza al ocurrir un problema con el envío de correos.
     *
     * @param e excepción atrapada
     */
    public MailException(Exception e) {
        super(
            "Error en el servicio de envío de correos",
            e.getMessage(),
            1011,
            "CVE_1011",
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
