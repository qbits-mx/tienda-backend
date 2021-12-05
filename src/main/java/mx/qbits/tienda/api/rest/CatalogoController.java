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
 *
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

    @GetMapping(path = "/2eliminar-nombre.json", produces = "application/json; charset=utf-8")
    public boolean eliminarNombre(@RequestParam String nombre) throws BusinessException{
        return catalogoService.eliminarCatalogo(nombre);
    }
    
    @GetMapping(path = "/2eliminar-id.json", produces = "application/json; charset=utf-8")
    public boolean eliminarId(@RequestParam int id) throws BusinessException{
        return catalogoService.eliminarCatalogo(id);
    }

    @GetMapping(path = "/2buscar-id.json", produces = "application/json; charset=utf-8")
    public Catalogo buscarCatalogoId(@RequestParam int id) throws BusinessException{
        return catalogoService.buscarCatalogo(id);
    }

    @GetMapping(path = "/2buscar-nombre.json", produces = "application/json; charset=utf-8")
    public Catalogo buscarCatalogoNombre(@RequestParam String nombre) throws BusinessException{
        return catalogoService.buscarCatalogo(nombre);
    }

    @GetMapping(path = "/2modificar-nombre-id.json", produces = "application/json; charset=utf-8")
    public boolean modificarNombreId(
            @RequestParam int id,
            @RequestParam String nuevoNombre) throws BusinessException{
        return catalogoService.modificarNombre(id, nuevoNombre);
    }

    @GetMapping(path = "/2modificar-nombre-nombre.json", produces = "application/json; charset=utf-8")
    public boolean modificarNombreNombre(
            @RequestParam String nombre,
            @RequestParam String nuevoNombre) throws BusinessException{
        return catalogoService.modificarNombre(nombre, nuevoNombre);
    }

    @GetMapping(path = "/2modificar-activo-id.json", produces = "application/json; charset=utf-8")
    public boolean modificarActivoId(
            @RequestParam int id,
            @RequestParam boolean nuevoActivo) throws BusinessException{
        return catalogoService.modificarActivo(id, nuevoActivo);
    }

    @GetMapping(path = "/2modificar-activo-nombre.json", produces = "application/json; charset=utf-8")
    public boolean modificarActivoNombre(
            @RequestParam String nombre,
            @RequestParam boolean nuevoActivo) throws BusinessException{
        return catalogoService.modificarActivo(nombre, nuevoActivo);
    }

    @GetMapping(path = "/2modificar-idcatalogocategoria-id.json", produces = "application/json; charset=utf-8")
    public boolean modificarIdCatalogoCategoriaId(
            @RequestParam int id,
            @RequestParam int nuevoIdCatalogoCategoria) throws BusinessException{
        return catalogoService.modificarIdCatalogoCategoria(id, nuevoIdCatalogoCategoria);
    }

    @GetMapping(path = "/2modificar-idcatalogocategoria-nombre.json", produces = "application/json; charset=utf-8")
    public boolean modificarIdCatalogoCategoriaNombre(
            @RequestParam String nombre,
            @RequestParam int nuevoIdCatalogoCategoria) throws BusinessException{
        return catalogoService.modificarIdCatalogoCategoria(nombre, nuevoIdCatalogoCategoria);
    }

    @GetMapping(path = "/2crear-catalogo.json", produces = "application/json; charset=utf-8")
    public boolean crearCatalogo(
            @RequestParam int idCatalogoCategoria ,
            @RequestParam boolean activo ,
            @RequestParam String nombre) throws BusinessException {
        return catalogoService.crearCatalogo(idCatalogoCategoria, activo, nombre);
    }

}
