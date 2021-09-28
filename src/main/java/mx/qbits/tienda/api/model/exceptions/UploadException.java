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
 * Nombre:      UploadException
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 07:58:32
 */
package mx.qbits.tienda.api.model.exceptions;

/**
 * <p>Descripción</p>
 * Excepción que se lanza cuando hay un problema con la carga de un archivo.
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
public class UploadException extends BusinessException {

    private static final long serialVersionUID = -7083159020205284484L;
    private static final String CVE = "CVE_1020";

    /**
     * Toma la excepción que se lanzó originalmente y reutiliza su mensaje.
     *
     * @param e excepción atrapada por el constructor
     */
    public UploadException(Exception e) {
        super(
            "Error en el servicio de envío de carga de archivos",
            e.getMessage(),
            1020,
            CVE,
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Es lanzado cuando hay un problema con la talla del archivo.
     *
     * @param max máximo peso permitido
     * @param peso peso del archivo que se quiso cargar
     */
    public UploadException(long max, long peso) {
        super(
            "Error en el servicio de envio de carga de archivos",
            String.format("Limite excedido. Max: %d. Upload: %d", max, peso),
            1020,
            CVE,
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Constructor sin parámetros, lanza un mensaje default.
     */
    public UploadException() {
        super(
            "Error en el servicio de envío de carga de archivos",
            "Tipo mime desconocido",
            1020,
            CVE,
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
