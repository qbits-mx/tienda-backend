/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     mx.qbits.tienda.api.service
 * Proyecto:    tienda
 * Tipo:        Interface
 * Nombre:      HealthService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:46:09
 */
package mx.qbits.tienda.api.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Interface HealthService.
 */
public interface HealthService {

    /**
     * Retorna la resultante de la ejecición de un comando del sistema operativo.
     *
     * @param data String Comando del sistema operativo
     * @return Map estructira de tipo diccionario con la resultante de la ejecución
     * @throws IOException Signals that an I/O exception has occurred.
     */
    Map<String, String> getInfo(String data) throws IOException;

    /**
     * Retorna cierto numero de lineas del log especificado por el
     * parámetro que recibe el método.
     *
     * @param last int numero de lineas del log a retornar
     *
     * @return Lista de cadenas con el numero de lineas del log
     *         determinado por el parámetro dado
     */
    List<String> getLog(int last);
}
