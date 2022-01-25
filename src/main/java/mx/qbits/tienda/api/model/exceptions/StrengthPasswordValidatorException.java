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
 * Nombre:      StrengthPasswordValidatorException
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 07:57:58
 */
package mx.qbits.tienda.api.model.exceptions;

import java.util.List;

import mx.qbits.tienda.api.model.enumerations.HttpStatus;

/**
 * <p>Descripción</p>
 * Excepción que determina cuando existe un problema con la fortaleza de una clave.
 *
 * <p>Tal y como ocurre en la mayoría de "custom exceptions", sólo contiene
 * constructores con la definición necesaria, que incluye en algunos caos el
 * código HTTP que será devuelto.
 *
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.exceptions.BusinessException
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class StrengthPasswordValidatorException extends BusinessException {

    private static final long serialVersionUID = -1222301152057974505L;
    private final List<String> messages;

    /**
     * Se lanza cuando existe una clave que no cumple con los lineamientos de seguridad
     *
     * @param messages lista de requisitos no cubiertos por la clave
     */
    public StrengthPasswordValidatorException(List<String> messages) {
        super(
            "Clave inválida",
            "La clave proporcionada es inválida.",
            1016,
            "CVE_1016",
            HttpStatus.BAD_REQUEST);
        this.messages = messages;
    }

    /**
     * Devuelve el atributo de la clase.
     *
     * @return atributo lista de mensajes
     */
    public List<String> getMessages() {
        return this.messages;
    }
}