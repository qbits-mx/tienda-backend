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
 * Nombre:      WaitLoginException
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 07:59:18
 */
package mx.qbits.tienda.api.model.exceptions;

/**
 * <p>Descripción:</p>
 * Excepción que indica que un usuario bloqueado debe de esperar aún para poder acceder a su cuenta.
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
public class WaitLoginException extends BusinessException {

    private static final long serialVersionUID = 8948866486775990561L;
    private static final String DETAILED_MENSAJE = "El usuario ha sido bloqueado por los próximos %d minutos y %d segundos debido a que alcanzó el máximo numero de intentos fallidos de ingreso al sistema.";
    private static final String SHORT_MENSAJE = "Usuario bloqueado";

    /**
     * Indica cuánto tiempo debe de esperar antes de poder volver a intentar el ingreso al sistema.
     *
     * @param seconds segundos restantes
     */
    public WaitLoginException(long seconds) {
        super(
                SHORT_MENSAJE,
            calc(seconds),
            1024,
            "CVE_1024",
            HttpStatus.BAD_REQUEST);
    }

    /**
     * Método auxiliar generar un mensaje explicativo del tiempo de espera restante.
     * @param seconds segundos restantes
     * @return Cadena que informa al usuario en cuánto tiempo se desbloquea su cuenta
     */
    private static String calc(long seconds) {
        long minutes = seconds/60;
        long seg = seconds%60;
        return String.format(DETAILED_MENSAJE, minutes, seg);
    }

}
