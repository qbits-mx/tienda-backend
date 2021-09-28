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
 * Nombre:      ProcessPDFException
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 07:57:39
 */
package mx.qbits.tienda.api.model.exceptions;

/**
 * <p>Descripción</p>
 * Excepción que modela la respuesta a una petición de procesar archivo PDF.
 *
 * <p>Tal y como ocurre en la mayoría de "custom exceptions", sólo contiene
 * constructores con la definición necesaria, que incluye en algunos caos el
 * código HTTP que será devuelto.
 *
 * @author dalvarez
 * @see mx.qbits.tienda.api.model.exceptions.BusinessException
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class ProcessPDFException extends BusinessException {
    private static final long serialVersionUID = 1L;

    /**
     * Da la descripción del problema que ocurre con el procesamiento del pdf.
     *
     * @param technicalDescription mensaje específico del problema
     */
    public ProcessPDFException(Exception technicalDescription) {
        super(
            "Error al generar el documento PDF",
            technicalDescription.getMessage(),
            1014,
            "CVE_1014",
            HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
