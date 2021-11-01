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
 * Nombre:      MapperCallException
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 07:57:23
 */
package mx.qbits.tienda.api.model.exceptions;

import mx.qbits.tienda.api.model.enumerations.EnumMessage;

/**
 * <p>Descripción:</p>
 * Excepción que modela la respuesta a una petición de autenticación cuyas
 * credenciales proporcionadas fueron incorrectas.
 *
 * <p>Tal y como ocurre en la mayoría de "custom exceptions", sólo contiene
 * constructores con la definición necesaria, que incluye en algunos caos el
 * código HTTP que será devuelto.
 *
 * @author garellano
 * @see io.kebblar.petstore.api.model.exceptions.BusinessException
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class MapperCallException extends BusinessException {
    private static final long serialVersionUID = -7083159020205284484L;

    /**
     * Brinda la oportunidad de especificar una breve descripción y un mensaje detallado a la
     * problemática sucedida en un mapper.
     *
     * @param shortMessage Breve descripción del problema
     * @param technicalDescription Descripción específica
     */
    public MapperCallException(String shortMessage, String technicalDescription) {
        this(new Exception(""), shortMessage, technicalDescription);
    }
    
    public MapperCallException(Throwable throwable, String shortMessage, String technicalDescription) {
        super(
            throwable,
            shortMessage,
            technicalDescription,
            701,
            throwable.getMessage(),
            EnumMessage.DATABASE.getHttpStatus());
    }

}
