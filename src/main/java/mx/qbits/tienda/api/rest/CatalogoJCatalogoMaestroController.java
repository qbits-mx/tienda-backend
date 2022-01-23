package mx.qbits.tienda.api.rest;

import java.util.List;

import mx.qbits.tienda.api.model.domain.CatalogoJCatalogoMaestro;
import mx.qbits.tienda.api.model.exceptions.BusinessException;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import mx.qbits.tienda.api.service.CatalogoJCatalogoMaestroService;

@RestController
@RequestMapping(value = "/api")
public class CatalogoJCatalogoMaestroController {
    private CatalogoJCatalogoMaestroService catalogoService;

    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     * @param catalogoService Servicios de CatalogoService
     */
    public CatalogoJCatalogoMaestroController(CatalogoJCatalogoMaestroService catalogoService) {
        this.catalogoService = catalogoService;
    }

    /**
     * Obtiene todos los catalogos con su join en su respectivo catalogo maestro
     * @return Una lista de los catalogos, donde aparece su catalogo maestro.
     * @throws BusinessException Si hubo algun problema con la BD
     */

    @GetMapping(path = "/obtener-catalogos-join.json", produces = "application/json; charset=utf-8")
    public List<CatalogoJCatalogoMaestro> obtenerCatalogos(
        ) throws BusinessException {
        return catalogoService.dameTodosLosCatalogos();
    }

}
