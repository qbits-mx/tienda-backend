/*
 * Licencia:    Usted  puede  utilizar  libremente  este  código
 *              para  copiarlo, distribuirlo o modificarlo total
 *              o  parcialmente  siempre y cuando  mantenga este
 *              aviso y reconozca la  autoría  del  código al no
 *              modificar los  datos  establecidos en la mención
 *              de: "AUTOR".
 *
 *              ------------------------------------------------
 * Artefacto:   DatabaseException.java
 * Tipo:        clase
 * AUTOR:       Gustavo A. Arellano (GAA)
 * Fecha:       Martes 4 de Mayo de 2021 (17_57)
 *
 * Historia:    .
 *              20210504_1757 Creación de esta Excepción
 *
 */
package mx.qbits.tienda.api.model.exceptions;

/**
 * <p>Descripción:</p>
 * Excepción que modela la respuesta a una petición cuyo token fue incorrecto.
 *
 * <p>Tal y como ocurre en la mayoría de "custom exceptions", solo contiene
 * constructores con la definición necesaria, que incluye en algunos caos el
 * código HTTP que será devuelto.</p>
 *
 * @author  garellano
 * @see     mx.qbits.tienda.api.model.exceptions.BusinessException
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class DatabaseException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;

    /**
     * Genera una excepción DatabaseException con el mensaje de la excepción que desencadenó
     * el lanzamiento de esta excepción.
     *
     * @param e Excepción que desencadena la excepción actual
     */
    public DatabaseException(Exception e) {
        super(
            "Error en el proceso de datos hacia o desde la Base de datos",
            e.getMessage(),
            1005,
            "CVE_1005",
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Genera una excepción DatabaseException con un mensaje específico.
     *
     * @param msg Mensaje que informa sobre el problema
     */
    public DatabaseException(String msg) {
        super(
            "Error en el proceso de datos hacia o desde la Base de datos",
            msg,
            1005,
            "CVE_1005",
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
