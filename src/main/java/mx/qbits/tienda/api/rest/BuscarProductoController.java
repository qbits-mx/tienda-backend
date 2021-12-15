package mx.qbits.tienda.api.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.service.BuscarProductoService;

@RestController
@RequestMapping(value = "/api")
public class BuscarProductoController {

    private BuscarProductoService buscarProductoService;

    public BuscarProductoController(BuscarProductoService buscarProductoService) {
        this.buscarProductoService = buscarProductoService;
    }

    @GetMapping(path = "/dame-datos.json", produces = "application/json; charset=utf-8")
    public List<Anuncio> dame() throws BusinessException {
        return buscarProductoService.buscarProducto(String descripcion,int idCatalogoDepartamento, int idCatalogoZonaEntrega, int idCatalogoFormaPago,int idCatalogoCondicion,int estrellas) ;
    }
}