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
 * Nombre:      UserNotExistsException
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 07:59:03
 */
package mx.qbits.tienda.api.model.exceptions;

/**
 * <p>Descripción</p>
 * Excepción que se lanza cuando un usuario intenta entrar al sistema con credenciales incorrectas.
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
public class UserNotExistsException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;

    private static final String DETAILED_MENSAJE = "El usuario %s no se encuentra reistrado.";
    private static final String SHORT_MENSAJE = "Usuario Inexistente";

    /**
     * Indica que el nombre de usuario introducido no existe en el sistema.
     *
     * @param user cadena del usuario introducido
     */
    public UserNotExistsException(String user) {
        super(
                SHORT_MENSAJE,
            mess(user),
            1022,
            "CVE_1022",
            HttpStatus.BAD_REQUEST);
    }

    /**
     * Brinda el mensaje detallado del problema.
     * @param user usuario introducido
     * @return Mensaje específico de la problemática
     */
    private static String mess(String user) {
        return String.format(DETAILED_MENSAJE, user);
    }

}
