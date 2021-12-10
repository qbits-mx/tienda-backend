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

import java.util.List;

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
     * Método que dado un tipoCatalogo, elimina dicho tipoCatalogo.
     * @param tipoCatalogo un String, con el tipoCatalogo a eliminar.
     * @return boolean, que nos indica si la operacion se realizo con exito.
     * @throws BusinessException en caso de que ocurra un problema con la eliminación.
     */
    boolean eliminarCatalogo(String tipoCatalogo) throws BusinessException;

    /**
     * Método que dado un id, elimina el catalogo maestro asociado a dicho tipoCatalogo. 
     * @param id un int, que indica el identificador del tipoCatalogo a ser eliminado.
     * @return boolean, que nos indica si la operacion se realizo con exito.
     * @throws BusinessException en caso de que ocurra un problema con la eliminación.
     */
    boolean eliminarCatalogo(int id) throws BusinessException;

    /**
     * Método que dado un id, busca el CatalogoMaestro asociado a ese id.
     * @param id un int, que indica el identificador del tipoCatalogo que se decea obtener.
     * @return CatalogoMaestro, asociado al id, pasado como parametro.
     * @throws BusinessException en caso de que ocurra un problema con la busqueda.
     */
    CatalogoMaestro buscarCatalogo(int id) throws BusinessException;

    /**
     * Método que dado un tipoCatalogo, regrega un CatalogoMaestro.
     * @param tipoCatalogo un String, que nos dira el tipoCatalogo a buscar.
     * @return CatalogoMaestro, asociado al tipoCatalogo, pasado como parametro.
     * @throws BusinessException en caso de que ocurra un problema con la busqueda.
     */
    CatalogoMaestro buscarCatalogo(String tipoCatalogo) throws BusinessException;

    /**
     * Método que dado un id y un nuevoTipoCatalogo, modifica el tipoCatalogo asociado 
     * al id pasado como parametro.
     * @param id un int, que nos indica el id, del CatalogoMaestro a modificar.
     * @param nuevoTipoCatalogo un String que contieme el nuevo tipoCatalogo asociado al id pasado 
     * como parametro.
     * @return boolean, si se pudo realizar dicha modificación.
     * @throws BusinessException en caso de que ocurra un problema con la modificación.
     */
    boolean modificarTipoCatalogo(int id, String nuevoTipoCatalogo) throws BusinessException;

    /**
     * Método que dado un id y un nuevoTipoCatalogo, modifica el tipoCatalogo asociado.
     * @param tipoCatalogo un String con el tipoCatalogo al cual le queremos cambiar el tipoCatalogo.
     * @param nuevoTipoCatalogo un String con el nuevo tipoCatalogo.
     * @return boolean, si se pudo realizar dicha modificación.
     * @throws BusinessException en caso de que ocurra un problema con la modificación.
     */
    boolean modificarTipoCatalogo(String tipoCatalogo, String nuevoTipoCatalogo) throws BusinessException;

    /**
     * Método que dado un tipoCatalogo, creq un CatalogoMaestro.
     * @param tipoCatalogo un String con el tipoCatalogo del CatalogoMaestro.
     * @return boolean, si se pudo realizar dicha creación.
     * @throws BusinessException en caso de que ocurra un problema con la inserción.
     */
    boolean crearCatalogo(String tipoCatalogo) throws BusinessException;

    /**
     * Método que obtiene todos los catalogos maestros en la base de datos.
     * @return List<CatalogoMaestro>, una lista con todos los catalogos maestro que hay en la base de datos.
     * @throws BusinessException en caso de que ocurra un problema con la inserción.
     */
    List<CatalogoMaestro> dameTodosLosCatalogosMaestros() throws BusinessException;
}
