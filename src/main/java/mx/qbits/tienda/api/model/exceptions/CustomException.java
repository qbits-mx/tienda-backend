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
 * Nombre:      BusinessException
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 07:54:37
 */
package mx.qbits.tienda.api.model.exceptions;

import mx.qbits.tienda.api.model.enumerations.EnumMessage;

/**
 * <p>Descripción:</p>
 * Excepción general que define que se ha violado una regla de la lógica de negocio.
 *
 * @author  fhernanda
 * @see     mx.CustomException.tienda.api.model.exceptions.NegocioException
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class CustomException extends BusinessException {
    private static final long serialVersionUID = -1218087669509474484L;
    
    public CustomException(EnumMessage message, Object... messageParams) {
        this(new Exception(), message, messageParams);
    }
    
    public CustomException(Throwable throwable, EnumMessage message, Object... messageParams) {
        super(throwable,
        String.format(message.getShortMessage(), messageParams),
        String.format(message.getDetailedMessage(), messageParams),
        message.getExceptionNumber(),
        message.toString(),
        message.getHttpStatus());
    }
    
}