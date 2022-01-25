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
 * Nombre:      ChatException
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 07:54:37
 */
package mx.qbits.tienda.api.model.exceptions;

/**
 * <p>Descripción:</p>
 * Excepción general que define que se ha ocurrido un error con el majejo del chat.
 *
 * @author Juan Carlos Bautista Sandoval
 * @author Ricardo Rubén Gonzáles García
 * @author José Angel Correa García
 * @author León
 * @see     mx.qbits.tienda.api.model.exceptions.ChatException
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class ChatException extends Exception{

    /**
     * Constructor para ChatException.
     * @param mensaje el mensaje que indica y da información sobre la excepcion que hubo.
     */
    public ChatException(String mensaje,int idAnuncio){
        super(mensaje+idAnuncio+"");
    }

    /**
     * Constructor para ChatException.
     * @param String mensaje el mensaje que nos indica y da información sobre la excepcion que hubo.
     * @param idAnuncio a int, el cuan nos indica el id del anuncio sobre el cual el chat tubo la excepcion. 
     * @param idRemitente a int, el cual nos indica el id del remitente sobre el cual el chat tubo la exepcion.
     */
    public ChatException(String mensaje,int idAnuncio,int idRemitente){
        super(mensaje+" idAnuncio: " + idAnuncio + " idRemitente: " + idRemitente+"\n");
    }
}