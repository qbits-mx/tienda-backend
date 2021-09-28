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
 * Nombre:      UserAlreadyExistsException
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 07:58:50
 */
package mx.qbits.tienda.api.model.exceptions;

/**
 * <p>Descripción</p>
 * Excepción que se lanza cuando el sistema detecta que los datos de un usuario que desea registrarse ya existen.
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
public class UserAlreadyExistsException extends BusinessException{
    private static final long serialVersionUID = -7083159020205284484L;

    /**
     * Se lanza cuando el sistema detecta que el usuario ya fue registrado.
     */
    public UserAlreadyExistsException() {
        super(
            "Error de registro",
            "El correo proporcionado ya se encuentra registrado en la base de datos.",
            1021,
            "CVE_1021",
            HttpStatus.BAD_REQUEST);
    }

}
