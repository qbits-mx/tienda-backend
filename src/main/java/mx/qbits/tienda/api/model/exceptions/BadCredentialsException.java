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
 * Nombre:      BadCredentialsException
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 07:54:13
 */
package mx.qbits.tienda.api.model.exceptions;

/**
 * <p>Descripción:</p>
 * Excepción que modela la respuesta a una petición de autenticación
 * cuyas credenciales proporcionadas fueron incorrectas.
 *
 * <p>Tal y como ocurre en la mayoría de "custom exceptions",  sólo contiene
 * constructores con la definición necesaria, que incluye en algunos caos el
 * código HTTP que será devuelto.</p>
 *
 * @author  luz
 * @see     mx.qbits.tienda.api.model.exceptions.BusinessException
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class BadCredentialsException extends BusinessException {

    private static final long serialVersionUID = -7083159020205284484L;
    private static final String MENSAJE = "Las credenciales proporcionadas son inválidas. Usted tiene %d intentos mas antes de que su usuario quede bloqueado.";

    /**
     * Excepción que al ser lanzada, adicionalmente informa sobre el número de intentos
     * de inicio de sesión que aún tiene un usuario para ingresar sus claves de forma correcta
     * antes de quedar bloqueado por el sistema.
     *
     * @param counter Número de intento actual de inicio de sesión
     * @param maxAllowed Máximo número de intentos permitidos
     */
    public BadCredentialsException(int counter, int maxAllowed) {
        super(
            "Las credenciales proporcionadas son inválidas",
            String.format(MENSAJE, maxAllowed-counter),
            1001,
            "CVE_1001",
            HttpStatus.UNAUTHORIZED);
    }

    /**
     * Informa solamente que las credenciales proporcionadas son inválidas.
     */
    public BadCredentialsException() {
        super(
            "Las credenciales proporcionadas son inválidas",
            "Favor de capturar credenciales válidas",
            1003,
            "CVE_1003",
            HttpStatus.UNAUTHORIZED);
    }

}
