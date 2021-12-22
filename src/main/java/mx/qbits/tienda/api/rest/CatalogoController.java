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

    @GetMapping(path = "/eliminar-catalogo-porNombre.json", produces = "application/json; charset=utf-8")
    public boolean eliminarPorNombre(@RequestParam String nombre) throws BusinessException{
        return catalogoService.eliminarCatalogo(nombre);
    }
    
    @GetMapping(path = "/eliminar-catalogo-porId.json", produces = "application/json; charset=utf-8")
    public boolean eliminarPorId(@RequestParam int id) throws BusinessException{
        return catalogoService.eliminarCatalogo(id);
    }

    @GetMapping(path = "/eliminar-catalogo-porNombreYIdCatalogoCategoria.json", produces = "application/json; charset=utf-8")
    public boolean eliminarPorNombreYIdCatalogoCategoria(
            @RequestParam String nombre,
            @RequestParam int idCatalogoCategoria 
        ) throws BusinessException{
        return catalogoService.eliminarCatalogo(nombre, idCatalogoCategoria);
    }
    
    @GetMapping(path = "/eliminar-catalogo-porIdYIdCatalogoCategoria.json", produces = "application/json; charset=utf-8")
    public boolean eliminarPorIdYIdCatalogoCategoria(
            @RequestParam int id,
            @RequestParam int idCatalogoCategoria
        ) throws BusinessException{
        return catalogoService.eliminarCatalogo(id, idCatalogoCategoria);
    }

    @GetMapping(path = "/buscar-catalogo-porId.json", produces = "application/json; charset=utf-8")
    public Catalogo buscarCatalogoPorId(@RequestParam int id) throws BusinessException{
        return catalogoService.buscarCatalogo(id);
    }

    @GetMapping(path = "/buscar-catalogo-porNombre.json", produces = "application/json; charset=utf-8")
    public Catalogo buscarCatalogoPorNombre(@RequestParam String nombre) throws BusinessException{
        return catalogoService.buscarCatalogo(nombre);
    }

    @GetMapping(path = "/buscar-catalogo-porIdYIdCatalogoCategoria.json", produces = "application/json; charset=utf-8")
    public Catalogo buscarCatalogoPorIdYIdCatalogoCategoria(
            @RequestParam int id,
            @RequestParam int idCatalogoCategoria
        ) throws BusinessException{
        return catalogoService.buscarCatalogo(id, idCatalogoCategoria);
    }

    @GetMapping(path = "/buscar-catalogo-porNombreYIdCatalogoCategoria.json", produces = "application/json; charset=utf-8")
    public Catalogo buscarCatalogoPorNombreYIdCatalogoCategoria(
            @RequestParam String nombre,
            @RequestParam int idCatalogoCategoria
        ) throws BusinessException{
        return catalogoService.buscarCatalogo(nombre, idCatalogoCategoria);
    }

    @GetMapping(path = "/modificar-nombreDeCatalogo-porId.json", produces = "application/json; charset=utf-8")
    public boolean modificarNombrePorId(
            @RequestParam int id,
            @RequestParam String nuevoNombre
        ) throws BusinessException{
        return catalogoService.modificarNombre(id, nuevoNombre);
    }

    @GetMapping(path = "/modificar-nombreDeCatalogo-porNombre.json", produces = "application/json; charset=utf-8")
    public boolean modificarNombrePorNombre(
            @RequestParam String nombre,
            @RequestParam String nuevoNombre
        ) throws BusinessException{
        return catalogoService.modificarNombre(nombre, nuevoNombre);
    }

    @GetMapping(path = "/modificar-nombreDeCatalogo-porIdYIdCatalogoMaestro.json", produces = "application/json; charset=utf-8")
    public boolean modificarNombrePorIdYIdCatalogoCategoria(
            @RequestParam int id,
            @RequestParam int idCatalogoCategoria,
            @RequestParam String nuevoNombre
        ) throws BusinessException{
        return catalogoService.modificarNombreConIdEIdCatalogoCategoria(id, idCatalogoCategoria, nuevoNombre);
    }

    @GetMapping(path = "/modificar-nombreDeCatalogo-porNombreYIdCatalogoMaestro.json", produces = "application/json; charset=utf-8")
    public boolean modificarNombrePorNombreYIdCatalogoCategoria(
            @RequestParam String nombre,
            @RequestParam int idCatalogoCategoria,
            @RequestParam String nuevoNombre
        ) throws BusinessException{
        return catalogoService.modificarNombreConNombreEIdCatalogoCategoria(nombre, idCatalogoCategoria, nuevoNombre);
    }

    @GetMapping(path = "/modificar-activo-porId.json", produces = "application/json; charset=utf-8")
    public boolean modificarActivoPorId(
            @RequestParam int id,
            @RequestParam boolean nuevoActivo) throws BusinessException{
        return catalogoService.modificarActivo(id, nuevoActivo);
    }

    @GetMapping(path = "/modificar-activo-porNombre.json", produces = "application/json; charset=utf-8")
    public boolean modificarActivoPorNombre(
            @RequestParam String nombre,
            @RequestParam boolean nuevoActivo) throws BusinessException{
        return catalogoService.modificarActivo(nombre, nuevoActivo);
    }

    @GetMapping(path = "/modificar-activo-porIdYIdCatalogoCategoria.json", produces = "application/json; charset=utf-8")
    public boolean modificarActivoPorIdYIdCatalogoCategoria(
            @RequestParam int id,
            @RequestParam int idCatalogoCategoria,
            @RequestParam boolean nuevoActivo) throws BusinessException{
        return catalogoService.modificarActivoConIdEIdCatalogoCategoria(id, idCatalogoCategoria, nuevoActivo);
    }

    @GetMapping(path = "/modificar-activo-porNombreYIdCatalogoCategoria.json", produces = "application/json; charset=utf-8")
    public boolean modificarActivoPorNombreYIdCatalogoCategoria(
            @RequestParam String nombre,
            @RequestParam int idCatalogoCategoria,
            @RequestParam boolean nuevoActivo) throws BusinessException{
        return catalogoService.modificarActivoConNombreEIdCatalogoCategoria(nombre, idCatalogoCategoria, nuevoActivo);
    }

    @GetMapping(path = "/modificar-idCatalogoCategoria-porId.json", produces = "application/json; charset=utf-8")
    public boolean modificarIdCatalogoCategoriaId(
            @RequestParam int id,
            @RequestParam int nuevoIdCatalogoCategoria) throws BusinessException{
        return catalogoService.modificarIdCatalogoCategoria(id, nuevoIdCatalogoCategoria);
    }

    @GetMapping(path = "/modificar-idCatalogoCategoria-porNombre.json", produces = "application/json; charset=utf-8")
    public boolean modificarIdCatalogoCategoriaNombre(
            @RequestParam String nombre,
            @RequestParam int nuevoIdCatalogoCategoria) throws BusinessException{
        return catalogoService.modificarIdCatalogoCategoria(nombre, nuevoIdCatalogoCategoria);
    }

    @GetMapping(path = "/modificar-idCatalogoCategoria-porIdYIdCatalogoCategoria.json", produces = "application/json; charset=utf-8")
    public boolean modificarIdCatalogoCategoriaPorIdYIdCatalogoCategoria(
            @RequestParam int id,
            @RequestParam int idCatalogoCategoria,
            @RequestParam int nuevoIdCatalogoCategoria) throws BusinessException{
        return catalogoService.modificarIdCatalogoCategoriaConIdEIdCatalogoCategoria(id, idCatalogoCategoria, nuevoIdCatalogoCategoria);
    }

    @GetMapping(path = "/modificar-idCatalogoCategoria-porNombreYIdCatalogoCategoria.json", produces = "application/json; charset=utf-8")
    public boolean modificarIdCatalogoCategoriaPorNombreYIdCatalogoCateogoria(
            @RequestParam String nombre,
            @RequestParam int idCatalogoCategoria,
            @RequestParam int nuevoIdCatalogoCategoria) throws BusinessException{
        return catalogoService.modificarIdCatalogoCategoriaConNombreEIdCatalogoCategoria(nombre, idCatalogoCategoria, nuevoIdCatalogoCategoria);
    }

    @GetMapping(path = "/insertar-catalogo.json", produces = "application/json; charset=utf-8")
    public boolean crearCatalogo(
            @RequestParam int idCatalogoCategoria ,
            @RequestParam boolean activo ,
            @RequestParam String nombre) throws BusinessException {
        return catalogoService.crearCatalogo(idCatalogoCategoria, activo, nombre);
    }

    @GetMapping(path = "/obtener-todosLosCatalogos.json", produces = "application/json; charset=utf-8")
    public List<Catalogo> obtenerTodosLosCatalogos() throws BusinessException {
        return catalogoService.obtenerTodosLosCatalogos();
    }

    @GetMapping(path = "/obtener-catalogos-porIdCatalogoCategoria.json", produces = "application/json; charset=utf-8")
    public List<Catalogo> obtenerCatalogosPorIdCatalogoCategoria(
            @RequestParam int idCatalogoCategoria
        ) throws BusinessException {
        return catalogoService.obtenerCatalogosPorIdCatalogoCategoria(idCatalogoCategoria);
    }

    @GetMapping(path = "/obtener-catalogosPorCategoria.json", produces = "application/json; charset=utf-8")
    public List<List<Catalogo>> obtenerCatalogosPorCategoria() throws BusinessException {
        return catalogoService.obtenerCatalogosPorCategoria();
    }

}
