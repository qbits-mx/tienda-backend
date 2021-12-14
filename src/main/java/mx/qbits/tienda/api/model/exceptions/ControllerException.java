/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   ControllerException.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Martes 4 de Mayo de 2021 (08_59)
 *
 * Historia:    .
 *              20210503_0859 Creación de esta Excepción
 *
 */
package mx.qbits.tienda.api.model.exceptions;

import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Descripción:</p>
 * Clase que define los componentes de los que una excepción puede estar formada.
 *
 * @author  fhernanda
 * @version 1.0-SNAPSHOT
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 * @see     mx.qbits.tienda.api.model.exceptions.BusinessException
 */
public class ControllerException extends Exception {

    private static final long serialVersionUID = -5047974256813565913L;
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerException.class);

    private final Exception rootException;
    private final String shortMessage;
    private final String detailedMessage;
    private final int localExceptionNumber;
    private final String localExceptionKey;
    private final HttpStatus httpStatus;

    /**
     * Genera una excepción por default con clave 1000, dada otra excepción pasada como parámetro.
     * Convierte la excepción recibida en una excepción ControllerException.
     *
     * @param rootException excepción recibida
     */
    public ControllerException(Exception rootException) {
        this.rootException = rootException;
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        this.localExceptionNumber = 1000;
        this.localExceptionKey = "cve_1000";
        this.shortMessage = rootException.getMessage();
        this.detailedMessage = rootException.getMessage();
    }

    /**
     * Constructor por parámetros de la clase.
     *
     * @param shortMessage Breve descripción del problema
     * @param detailedMessage Descripción detallada del problema
     * @param localExceptionNumber Clave que se le da a la excepción
     * @param localExceptionKey Código que incluye la clave de la excepción
     * @param httpStatus Código HTTP a lanzar
     */
    public ControllerException(
            String shortMessage,
            String detailedMessage,
            int localExceptionNumber,
            String localExceptionKey,
            HttpStatus httpStatus) {
        this.shortMessage = shortMessage;
        this.detailedMessage = detailedMessage;
        this.localExceptionNumber = localExceptionNumber;
        this.localExceptionKey = localExceptionKey;
        this.httpStatus = httpStatus;
        String str = this.toString();
        LOGGER.error(str);
        rootException = null;
    }

    /**
     * Se sirve del constructor por parámetros, salvo a que este método siempre devuelve HttpStatus=200
     *
     * @param shortMessage Breve descripción del problema
     * @param detailedMessage Descripción detallada del problema
     * @param localExceptionNumber Clave que se le da a la excepción
     * @param localExceptionKey Código que incluye la clave de la excepción
     */
    public ControllerException(
            String shortMessage,
            String detailedMessage,
            int localExceptionNumber,
            String localExceptionKey) {
        this(shortMessage, detailedMessage, localExceptionNumber, localExceptionKey, HttpStatus.ACCEPTED);
    }

    /*
     * Getter.
     */
    /**
     * <p>Getter for the field <code>shortMessage</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getShortMessage() {
        return shortMessage;
    }

    /**
     * <p>Getter for the field <code>detailedMessage</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getDetailedMessage() {
        return detailedMessage;
    }

    /**
     * <p>Getter for the field <code>localExceptionNumber</code>.</p>
     *
     * @return a int.
     */
    public int getLocalExceptionNumber() {
        return localExceptionNumber;
    }

    /**
     * <p>Getter for the field <code>localExceptionKey</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getLocalExceptionKey() {
        return localExceptionKey;
    }

    /**
     * <p>Getter for the field <code>httpStatus</code>.</p>
     *
     * @return a {@link mx.qbits.tienda.api.model.exceptions.HttpStatus} object.
     */
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    /**
     * <p>Getter for the field <code>rootException</code>.</p>
     *
     * @return a {@link java.lang.Exception} object.
     */
    public Exception getRootException() {
        return rootException;
    }

    /**
     * <p>getRootExceptionMessage.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getRootExceptionMessage() {
        return rootException.getMessage();
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "ControllerException [rootException=" + rootException + ", shortMessage=" + shortMessage
                + ", detailedMessage=" + detailedMessage + ", localExceptionNumber=" + localExceptionNumber
                + ", localExceptionKey=" + localExceptionKey + ", httpStatus=" + httpStatus + "]";
    }

    /**
     * Construye un mensaje genérico basado en un ID de rastreo para ocultar
     * el verdadero mensaje al usuario final y dejar huella para que lo busque
     * y gestione un administrador con acceso al log de transacciones.
     *
     * @param msg Cadena con un mensaje genérico.
     * @param desc Mensaje real a ocultar.
     * @return Cadena con el ID genérico
     */
    public static String buildMessage(String msg, String desc) {
        String uid = UUID.randomUUID().toString();
        LOGGER.error("UID: {} Description: {}", uid, desc);
        return String.format(msg,  uid);
    }
}
