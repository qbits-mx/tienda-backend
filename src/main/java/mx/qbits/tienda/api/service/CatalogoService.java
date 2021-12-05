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
 * Nombre:      CatalogoService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 1 Dic 2021 @ 08:46:09
 */
package mx.qbits.tienda.api.service;

import mx.qbits.tienda.api.model.domain.Catalogo;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

/**
 * <p>Descripción:</p>
 * Interfaz 'CatalogoService' asociado a la entidad Catalogo.
 * @author Juan Carlos Bautista Sandoval
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see mx.qbits.tienda.api.model.domain.Catalogo
 */
public interface CatalogoService {

    /**
     * 
     * @param nombre
     * @return
     * @throws BusinessException
     */
    boolean eliminarCatalogo(String nombre) throws BusinessException;

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
    Catalogo buscarCatalogo(int id) throws BusinessException;

    /**
     * 
     * @param nombre
     * @return
     * @throws BusinessException
     */
    Catalogo buscarCatalogo(String nombre) throws BusinessException;

    /**
     * 
     * @param id
     * @param nuevoNombre
     * @return
     * @throws BusinessException
     */
    boolean modificarNombre(int id, String nuevoNombre) throws BusinessException;

    /**
     * 
     * @param nombre
     * @param nuevoNombre
     * @return
     * @throws BusinessException
     */
    boolean modificarNombre(String nombre, String nuevoNombre) throws BusinessException;

    /**
     * 
     * @param id
     * @param nuevoActivo
     * @return
     * @throws BusinessException
     */
    boolean modificarActivo(int id, boolean nuevoActivo) throws BusinessException;

    /**
     * 
     * @param nombre
     * @param nuevoActivo
     * @return
     * @throws BusinessException
     */
    boolean modificarActivo(String nombre, boolean nuevoActivo) throws BusinessException;

    /**
     * 
     * @param id
     * @param nuevoIdCatalogoCategoria
     * @return
     * @throws BusinessException
     */
    boolean modificarIdCatalogoCategoria(int id, int nuevoIdCatalogoCategoria) throws BusinessException;

    /**
     * 
     * @param nombre
     * @param nuevoIdCatalogoCategoria
     * @return
     * @throws BusinessException
     */
    boolean modificarIdCatalogoCategoria(String nombre, int nuevoIdCatalogoCategoria) throws BusinessException;

    /**
     * 
     * @param idCatalogoCategoria
     * @param activo
     * @param nombre
     * @return
     * @throws BusinessException
     */
    boolean crearCatalogo(int idCatalogoCategoria, boolean activo, String nombre) throws BusinessException;
}
