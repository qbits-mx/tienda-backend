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

import java.util.List;

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
     * Método que dado un nombre de un catalogo, lo elimina.
     * @param nombre un String, que nos indica el nombre del catalogo.
     * @return boolean, que nos indica si la operación fue ralizada con exito.
     * @throws BusinessException en caso de que ocurra un problema con la eliminación.
     */
    boolean eliminarCatalogo(String nombre) throws BusinessException;

    /**
     * Método que dado un id , elimina el catalogo asociado al mismo.
     * @param id un int, con el id del catalogo a eliminar.
     * @return boolean, que nos indica si la operacion fue realizada con exito.
     * @throws BusinessException en caso de que ocurra un problema con la eliminación.
     */
    boolean eliminarCatalogo(int id) throws BusinessException;

    /**
     * Método que dado el mombre e idCatalogoCategoria  de un catalogo lo elimina.
     * @param nombre un String, con el nombre del catalogo.
     * @param idCatalogoCategoria un int, con el idCatalogoCategoria del catalogo.
     * @return boolean, que nos indica si la operación fue realizada con exito.
     * @throws BusinessException en caso de que ocurra un problema con la eliminación.
     */
    boolean eliminarCatalogo(String nombre, int idCatalogoCategoria) throws BusinessException;
    
    /**
     * Método que dado el id e idCatalogoCategoria de un catalogo lo elimina.
     * @param id un int, con el id del catalogo a eliminar.
     * @param idCatalogoCategoria un int, con el idCatalogoCategoria del catalogo a eliminar.
     * @return boolean, que nos indica se la operación fue realizada con exito.
     * @throws BusinessException en caso de que ocurra un problema con la eliminación.
     */
    boolean eliminarCatalogo(int id, int idCatalogoCategoria) throws BusinessException;

    /**
     * Método que dado un id, busca el catalogo asociado a ese id.
     * @param id un int, que indica el identificador del catalogo a buscar.
     * @return Catalogo, asociado al id, pasado como parametro.
     * @throws BusinessException en caso de que ocurra un problema de busqueda.
     */
    Catalogo buscarCatalogo(int id) throws BusinessException;

    /**
     * Método que dado un nombre, regresa un Catalogo asociado a dicho nombre.
     * @param nombre un String, con el nombre del catalogo a buscar.
     * @return Catalogo, asociado al nomnbre pasado como parametro.
     * @throws BusinessException en caso de que ocurra un problema con la busquda.
     */
    Catalogo buscarCatalogo(String nombre) throws BusinessException;

    /**
     * Método que dado un nombre e idCatalogoCategoria, regresa un catalogo asociado a dichos parametros.
     * @param nombre un String con el nomnre del catalogo a buscar.
     * @param idCatalogoCategoria un int con el idCatalogoCategoria del catalogo a buscar.
     * @return Catalogo, asociado a los parametros dados.
     * @throws BusinessException en caso de que ocurra un problema con la busquda.
     */
    Catalogo buscarCatalogo(String nombre, int idCatalogoCategoria) throws BusinessException;

    /**
     * Método que dado un id e idCatalogoCategoria, regresa un catalogo asociado a dichos parametros.
     * @param id un int, que indica el identificador del catalogo a buscar.
     * @param idCatalogoCategoria un id, que indica el idCatalogoCategoria del catalogo a busacar.
     * @return Catalogo, asociado a los parametros dados.
     * @throws BusinessException en caso de que ocurra un problema con la busquda.
     */
    Catalogo buscarCatalogo(int id, int idCatalogoCategoria) throws BusinessException;

    /**
     * Método que dado un id y un nuevoNombre, modifica el nombre asociado al catalogo
     * @param id un int, que nos indica el id del catalogo.
     * @param nuevoNombre un String, el nuevo nombre del catalogo.
     * @return boolean, si se pudo realizar dicha operacion.
     * @throws BusinessException en caso de que ocurra un problema con la modificación.
     */
    boolean modificarNombre(int id, String nuevoNombre) throws BusinessException;

    /**
     * Metodo que dado un nombre y un nuevoNombre, modifica el nombre del catalogo asociado
     * al nombre pasado como parametro.
     * @param nombre un String, que indica el nombre del catalogo a modificar.
     * @param nuevoNombre un String, con el nuevo nombre del catalogo.
     * @return boolean, indicando si se pudo efectuar la operación.
     * @throws BusinessException en caso de que ocurra un problema con la modificación.
     */
    boolean modificarNombre(String nombre, String nuevoNombre) throws BusinessException;

    /**
     * Metodo que dado un id, idCatalogoCategoria y un nuevo nombre, modifica el nombre del catalogo.
     * @param id un int, que representa al id del catalogo
     * @param idCatalogoCategoria un int, que representa el idCatalogoCategoria del catalogo.
     * @param nuevoNombre un String, con el nuevo nombre del catalogo.
     * @return boolean, indicando si se pudo efectuar la operación.
     * @throws BusinessException n caso de que ocurra un problema con la modificación.
     */
    boolean modificarNombreConIdEIdCatalogoCategoria(int id, int idCatalogoCategoria, String nuevoNombre) throws BusinessException;

    /**
     * Método que dado un nombre, idCatalogoCategoria y un nuevo nombre, modifica el nombre del catalogo.
     * @param nombre un String, que indica el nombre del catalogo a modificar.
     * @param idCatalogCategoria un int, que representa el idCatalogoCategoria del catalogo.
     * @param nuevoNombre un String, con el nuevo nombre del catalogo.
     * @return boolean, indicando si se pudo efectuar la operación.
     * @throws BusinessException n caso de que ocurra un problema con la modificación.
     */
    boolean modificarNombreConNombreEIdCatalogoCategoria(String nombre, int idCatalogoCategoria, String nuevoNombre) throws BusinessException;

    /**
     * Método que dado un id y un nuevoActivo, modifica el activo asociado al catalogo.
     * @param id un int, que nos indica el id del catalogo.
     * @param nuevoActivo un boolean, el nuevo activo del catalogo.
     * @return boolean, indicando si se pudo efectuar la operación.
     * @throws BusinessException en caso de que ocurra un problema con la modificación.
     */
    boolean modificarActivo(int id, boolean nuevoActivo) throws BusinessException;

    /**
     * Método que dado un nombre y un nuevoActivo, modifica el activo asociado al catalogo.
     * @param nombre nombre un String, que indica el nombre del catalogo a modificar.
     * @param nuevoActivo un boolean, el nuevo activo del catalogo.
     * @return boolean, indicando si se pudo efectuar la operación.
     * @throws BusinessException en caso de que ocurra un problema con la modificación.
     */
    boolean modificarActivo(String nombre, boolean nuevoActivo) throws BusinessException;

    /**
     * Método que dado un id, idCatalogoCategoria y un nuevoActivo, modifica el activo asociado al catalogo.
     * @param id un int, que nos indica el id del catalogo.
     * @param idCatalogoCategoria un int, que representa el idCatalogoCategoria del catalogo.
     * @param nuevoActivo un boolean, el nuevo activo del catalogo.
     * @return boolean, indicando si se pudo efectuar la operación.
     * @throws BusinessException en caso de que ocurra un problema con la modificación.
     */
    boolean modificarActivoConIdEIdCatalogoCategoria(int id, int idCatalogoCategoria, boolean nuevoActivo) throws BusinessException;

    /**
     * Método que dado un nombre, idCatalogoCategoria y un nuevoActivo, modifica el activo asociado al catalogo.
     * @param nombre nombre un String, que indica el nombre del catalogo a modificar.
     * @param idCatalogoCategoria un int, que representa el idCatalogoCategoria del catalogo.
     * @param nuevoActivo un boolean, el nuevo activo del catalogo.
     * @return boolean, indicando si se pudo efectuar la operación.
     * @throws BusinessException en caso de que ocurra un problema con la modificación.
     */
    boolean modificarActivoConNombreEIdCatalogoCategoria(String nombre, int idCatalogoCategoria, boolean nuevoActivo) throws BusinessException;

    /**
     * Método que dado el id y un nuevoIdCatalogoCategoria, modifica su categoria.
     * @param id un int, que nos indica el id del catalogo.
     * @param nuevoIdCatalogoCategoria un int, con el nuevo idCatalogoCategoria del catalogo.
     * @return boolean, indicando si se pudo efectuar la operación.
     * @throws BusinessException en caso de que ocurra un problema con la modificación.
     */
    boolean modificarIdCatalogoCategoria(int id, int nuevoIdCatalogoCategoria) throws BusinessException;

    /**
     * Método que dado el nombre y un nuevoIdCatalogoCategoria, modifica su categoria.
     * @param nombre nombre un String, que indica el nombre del catalogo a modificar.
     * @param nuevoIdCatalogoCategoria un int, con el nuevo idCatalogoCategoria del catalogo.
     * @return boolean, indicando si se pudo efectuar la operación.
     * @throws BusinessException en caso de que ocurra un problema con la modificación.
     */
    boolean modificarIdCatalogoCategoria(String nombre, int nuevoIdCatalogoCategoria) throws BusinessException;

    /**
     * Método que dado el id, idCatalogoCategoria y  un nuevoIdCatalogoCategoria, modifica su categoria.
     * @param id un int, que nos indica el id del catalogo.
     * @param idCatalogoCategoria un int, que representa el idCatalogoCategoria del catalogo.
     * @param nuevoIdCatalogoCategoria un int, con el nuevo idCatalogoCategoria del catalogo.
     * @return boolean, indicando si se pudo efectuar la operación.
     * @throws BusinessException en caso de que ocurra un problema con la modificación.
     */
    boolean modificarIdCatalogoCategoriaConIdEIdCatalogoCategoria(int id, int idCatalogoCategoria, int nuevoIdCatalogoCategoria) throws BusinessException;

    /**
     * Método que dado el nombre,idCatalogoCategoria y un nuevoIdCatalogoCategoria, modifica su categoria.
     * @param nombre nombre un String, que indica el nombre del catalogo a modificar.
     * @param idCatalogoCategoria un int, que representa el idCatalogoCategoria del catalogo.
     * @param nuevoIdCatalogoCategoria un int, con el nuevo idCatalogoCategoria del catalogo.
     * @return boolean, indicando si se pudo efectuar la operación.
     * @throws BusinessException en caso de que ocurra un problema con la modificación.
     */
    boolean modificarIdCatalogoCategoriaConNombreEIdCatalogoCategoria(String nombre, int idCatalogoCategoria, int nuevoIdCatalogoCategoria) throws BusinessException;

    /**
     * Método para crear nuevos catalogos de alguna categoria dada.
     * @param idCatalogoCategoria un int, que indica la categoria a la que pertenece el catalogo.
     * @param activo un boolean, que nos indica si el catalogo esta activo.
     * @param nombre un String que nos indica el nombre del catalogo.
     * @return boolean, indicando si se pudo efectuar la operación.
     * @throws BusinessException en caso de que ocurra un problema con la inserción.
     */
    boolean crearCatalogo(int idCatalogoCategoria, boolean activo, String nombre) throws BusinessException;

    /**
     * Método para obtener todos los catalogos de la base de datos.
     * @return  List<Catalogo>, una lista con todos los catalogos de la base de datos.
     * @throws BusinessException en caso de que ocurra un problema con la busqueda.
     */
    List<Catalogo> obtenerTodosLosCatalogos() throws BusinessException;

    /**
     * Metodo para obtener una lista de catalogos, asociado a un unico catalogoCategoria(CatalogoMaestro).
     * @param idCatalogoCategoria el id de el catalogoCategoria sobre el que deceamos obtener todos sus catalogos asociados.
     * @return List<Catalogo>, una lista con todos los catalogos asosciados al idCatalogoCategoria.
     * @throws BusinessException en caso de que ocurra un problema con la busqueda.
     */
    List<Catalogo> obtenerCatalogosPorIdCatalogoCategoria(int idCatalogoCategoria) throws BusinessException;

    /**
     * Método para obtener listas, de catalogos, en donde cada lista, contiene los catalogos asociados a un unico
     * catalogoCategoria(CatalogoMaestro).
     * @return List<List<Catalogo>>, una lista de listas, la cuales contienen los catalogos, separados por el catalogo
     * categoria al que pertenecen.
     * @throws BusinessException en caso de que ocurra un problema con la busqueda.
     */
    List<List<Catalogo>> obtenerCatalogosPorCategoria() throws BusinessException;

}
