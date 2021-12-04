package mx.qbits.tienda.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.qbits.tienda.api.model.domain.Catalogo;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.service.CatalogoService;

@RestController
@RequestMapping(value = "/api")
public class CatalogoController {
    
    private CatalogoService catalogoService;

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
