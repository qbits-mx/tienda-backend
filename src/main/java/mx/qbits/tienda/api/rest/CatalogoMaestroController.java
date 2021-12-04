package mx.qbits.tienda.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.qbits.tienda.api.model.domain.CatalogoMaestro;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.service.CatalogoMaestroService;

@RestController
@RequestMapping(value = "/api")
public class CatalogoMaestroController {
    
    private CatalogoMaestroService catalogoMaestroService;

    public CatalogoMaestroController(CatalogoMaestroService catalogoMaestroService) {
        this.catalogoMaestroService = catalogoMaestroService;
    }

    @GetMapping(path = "/eliminar-tipo.json", produces = "application/json; charset=utf-8")
    public boolean eliminarTipo(@RequestParam String tipoCatalogo) throws BusinessException {
        return catalogoMaestroService.eliminarCatalogo(tipoCatalogo);
    }
    
    @GetMapping(path = "/eliminar-id.json", produces = "application/json; charset=utf-8")
    public boolean eliminarId(@RequestParam int id) throws BusinessException {
        return catalogoMaestroService.eliminarCatalogo(id);
    }

    @GetMapping(path = "/buscar-catalogo-id.json", produces = "application/json; charset=utf-8")
    public CatalogoMaestro buscarCatalogoId(@RequestParam int id) throws BusinessException {
        return catalogoMaestroService.buscarCatalogo(id);
    }
    
    @GetMapping(path = "/buscar-catalogo-tipo-catalogo.json", produces = "application/json; charset=utf-8")
    public CatalogoMaestro buscarCatalogoTipoCatalogo(@RequestParam String tipoCatalogo) throws BusinessException {
        return catalogoMaestroService.buscarCatalogo(tipoCatalogo);
    }

    @GetMapping(path = "/modificar-tipo-catalogo-id.json", produces = "application/json; charset=utf-8")
    public boolean modificarTipoCatalogoId(
            @RequestParam int id,
            @RequestParam String nuevoTipoCatalogo) throws BusinessException {
        return catalogoMaestroService.modificarTipoCatalogo(id, nuevoTipoCatalogo);
    }
    
    @GetMapping(path = "/modificar-tipo-catalogo-tipo-catalogo.json", produces = "application/json; charset=utf-8")
    public boolean modificarTipoCatalogoTipoCatalogo(
            @RequestParam int tipoCatalogo,
            @RequestParam String nuevoTipoCatalogo) throws BusinessException {
        return catalogoMaestroService.modificarTipoCatalogo(tipoCatalogo, nuevoTipoCatalogo);
    }

    @GetMapping(path = "/crear-catalogo.json", produces = "application/json; charset=utf-8")
    public boolean crearCatalogo(@RequestParam String tipoCatalogo) throws BusinessException {
        return catalogoMaestroService.crearCatalogo(tipoCatalogo);
    }
}
