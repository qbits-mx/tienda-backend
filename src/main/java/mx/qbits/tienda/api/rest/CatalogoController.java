/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     mx.qbits.tienda.api.rest
 * Proyecto:    tienda
 * Tipo:        Clase
 * Nombre:      CatalogoController
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 3 Dic 2021 @ 08:22:14
 */
package mx.qbits.tienda.api.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.qbits.tienda.api.model.domain.Catalogo;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.service.CatalogoService;

/**
 * Implementacion  del controlador REST asociado a los endpoints
 * de gestión por CatalogoService.
 * <p>NOTA IMPORTANTE: Los  distntos métodos de este controlador no
 * llevan  javadoc  debido a que la  documentación  Swagger  API
 * cumple con ese objetivo.</p>
 * @author  Juan Carlos Bautista Sandoval
 * @see     mx.qbits.tienda.api.service.CatalogoService
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@RestController
@RequestMapping(value = "/api")
public class CatalogoController {
    
    private CatalogoService catalogoService;


    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     * @param catalogoService Servicios de CatalogoService
     */
    public CatalogoController(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;
    }

    /**
     * Busca un catalogo por su id
     * @param id el id del catalogo a buscar
     * @return El catalogo cuyo id sea el buscado
     * @throws BusinessException Si hubo algun problema con la BD
     */
    @GetMapping(path = "/buscar-catalogo-porId.json", produces = "application/json; charset=utf-8")
    public Catalogo buscarCatalogoPorId(@RequestParam int id) throws BusinessException{
        return catalogoService.buscarCatalogo(id);
    }

    /**
     * Le cambia el nombre al catalogo que tenga el id solicitado
     * @param id el id del catalogo a cambiar
     * @param nuevoNombre El nuevo nombre del catalogo.
     * @return true en caso de que haya realizado el cambio.
     * @throws BusinessException Si hubo algun problema con la BD
     */
    @GetMapping(path = "/modificar-nombreDeCatalogo-porId.json", produces = "application/json; charset=utf-8")
    public boolean modificarNombrePorId(
            @RequestParam int id,
            @RequestParam String nuevoNombre
        ) throws BusinessException{
        return catalogoService.modificarNombre(id, nuevoNombre);
    }

    /**
     * Le cambia el status de activo al catalogo que tenga el id solicitado
     * @param id el id del catalogo a cambiar
     * @param nuevoActivo El nuevo activo del catalogo.
     * @return true en caso de que haya realizado el cambio.
     * @throws BusinessException Si hubo algun problema con la BD
     */

    @GetMapping(path = "/modificar-activo-porId.json", produces = "application/json; charset=utf-8")
    public boolean modificarActivoPorId(
            @RequestParam int id,
            @RequestParam boolean nuevoActivo) throws BusinessException{
        return catalogoService.modificarActivo(id, nuevoActivo);
    }


    /**
     * Crea un nuevo catalogo
     * @param idCatalogoCategoria el id del catalogo maestro al que va a pertenecer
     * @param activo El estado de activo que tendra al crearlo
     * @param nombre El nombre del catalogo a crear.
     * @return true en caso de que haya realizado el cambio.
     * @throws BusinessException Si hubo algun problema con la BD
     */

    @GetMapping(path = "/insertar-catalogo.json", produces = "application/json; charset=utf-8")
    public boolean crearCatalogo(
            @RequestParam int idCatalogoCategoria ,
            @RequestParam boolean activo ,
            @RequestParam String nombre) throws BusinessException {
        return catalogoService.crearCatalogo(idCatalogoCategoria, activo, nombre);
    }


    /**
     * Obtiene una lista de todos los catalogos
     * @return Una lista de todos los catalogos
     * @throws BusinessException Si hubo algun problema con la BD
     */

    @GetMapping(path = "/obtener-todosLosCatalogos.json", produces = "application/json; charset=utf-8")
    public List<Catalogo> obtenerTodosLosCatalogos() throws BusinessException {
        return catalogoService.obtenerTodosLosCatalogos();
    }

    /**
     * Elimina el catalogo que tenga el id solicitado
     * @param id El id del catalogo a eliminar
     * @return true en caso de que haya realizado el cambio.
     * @throws BusinessException Si hubo algun problema con la BD
     */

    @GetMapping(path = "/eliminar-catalogo-porId.json", produces = "application/json; charset=utf-8")
    public boolean eliminarPorId(@RequestParam int id) throws BusinessException{
        return catalogoService.modificarActivo(id, false);
    }

    /**
     * Obtiene una lista de todos los catalogos que sean de una categoria en especifico
     * @param idCatalogoCategoria El id del catalogo maestro que del cual se buscan catalogos
     * @return Una lista con catalogos con el mismo id catalogo maestro
     * @throws BusinessException Si hubo algun problema con la BD
     */

    @GetMapping(path = "/obtener-catalogos-porIdCatalogoCategoria.json", produces = "application/json; charset=utf-8")
    public List<Catalogo> obtenerCatalogosPorIdCatalogoCategoria(
            @RequestParam int idCatalogoCategoria
        ) throws BusinessException {
        return catalogoService.obtenerCatalogosPorIdCatalogoCategoria(idCatalogoCategoria);
    }



}