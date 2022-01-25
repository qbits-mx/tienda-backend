/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.exceptions
 * Proyecto:    petstore-back
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

import mx.qbits.tienda.api.model.enumerations.HttpStatus;

/**
 * <p>Descripción:</p>
 * Excepción general que define que se ha violado una regla de la lógica de negocio.
 *
 * @author  fhernanda
 * @see     io.kebblar.petstore.api.model.exceptions.BusinessException
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class BusinessException extends ControllerException {
    private static final long serialVersionUID = -1218087669509474484L;

    /**
     * Constructor basado en una excepción.
     *
     * @param e excepción usada por el constructor
     */
    public BusinessException(Exception e) {
        super(e);
    }

    /**
     * <p>Constructor for BusinessException.</p>
     *
     * @param shortMessage a {@link java.lang.String} object.
     * @param detailedMessage a {@link java.lang.String} object.
     * @param localExceptionNumber a int.
     * @param localExceptionKey a {@link java.lang.String} object.
     * @param httpStatus a {@link io.kebblar.petstore.api.model.enumerations.HttpStatus} object.
     */
    public BusinessException(
            String shortMessage,
            String detailedMessage,
            int localExceptionNumber,
            String localExceptionKey,
            HttpStatus httpStatus) {
        super(shortMessage, detailedMessage, localExceptionNumber, localExceptionKey, httpStatus);
    }

    /**
     * <p>Constructor for BusinessException.</p>
     *
     * @param shortMessage a {@link java.lang.String} object.
     * @param detailedMessage a {@link java.lang.String} object.
     * @param localExceptionNumber a int.
     * @param localExceptionKey a {@link java.lang.String} object.
     */
    public BusinessException(
            String shortMessage,
            String detailedMessage,
            int localExceptionNumber,
            String localExceptionKey) {
        super(shortMessage, detailedMessage, localExceptionNumber, localExceptionKey);
    }

    /**
     * <p>Constructor for BusinessException.</p>
     *
     * @param shortMessage a {@link java.lang.String} object.
     * @param detailedMessage a {@link java.lang.String} object.
     */
    public BusinessException(
            String shortMessage,
            String detailedMessage) {
        super(shortMessage, detailedMessage, 0, "CVE_0000");
    }
    
    public BusinessException(
            Throwable throwable, 
            String shortMessage, 
            String detailedMessage, 
            int exceptionNumber, 
            String message, 
            HttpStatus httpStatus) {
        super(throwable,shortMessage,detailedMessage,exceptionNumber,message,httpStatus);
    }

}