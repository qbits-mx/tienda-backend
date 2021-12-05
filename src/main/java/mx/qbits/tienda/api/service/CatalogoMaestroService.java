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
 * Nombre:      CatalogoMaestroService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 1 Dic 2021 @ 08:46:09
 */
package mx.qbits.tienda.api.service;

import mx.qbits.tienda.api.model.domain.CatalogoMaestro;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

/**
 * <p>Descripción:</p>
 * Interfaz 'CatalogoMaestroService' asociado a la entidad CatalogoMaestro.
 * @author Juan Carlos Bautista Sandoval
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see mx.qbits.tienda.api.model.domain.CatalogoMaestro
 */
public interface CatalogoMaestroService {

    /**
     * 
     * @param tipoCatalogo
     * @return
     * @throws BusinessException
     */
    boolean eliminarCatalogo(String tipoCatalogo) throws BusinessException;

    /**
     * 
     * @param id
     * @return
     * @throws BusinessException
     */
    boolean eliminarCatalogo(int id) throws BusinessException;

    /**
     * 
     * @param id
     * @return
     * @throws BusinessException
     */
    CatalogoMaestro buscarCatalogo(int id) throws BusinessException;

    /**
     * 
     * @param tipoCatalogo
     * @return
     * @throws BusinessException
     */
    CatalogoMaestro buscarCatalogo(String tipoCatalogo) throws BusinessException;

    /**
     * 
     * @param id
     * @param nuevoTipoCatalogo
     * @return
     * @throws BusinessException
     */
    boolean modificarTipoCatalogo(int id, String nuevoTipoCatalogo) throws BusinessException;

    /**
     * 
     * @param tipoCatalogo
     * @param nuevoTipoCatalogo
     * @return
     * @throws BusinessException
     */
    boolean modificarTipoCatalogo(String tipoCatalogo, String nuevoTipoCatalogo) throws BusinessException;

    /**
     * 
     * @param tipoCatalogo
     * @return
     * @throws BusinessException
     */
    boolean crearCatalogo(String tipoCatalogo) throws BusinessException;
}
