package mx.qbits.tienda.api.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.service.BuscarProductoService;
//import org.springframework.web.bind.annotation.PathVariable;

/**
 * Implementacion del controlador REST asociado a los endpoints
 * de gestión para BuscarProducto .
 *
 * @author Sunflower
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */

@RestController
@RequestMapping(value = "/api")
public class BuscarProductoController {

    private BuscarProductoService buscarProductoService;

    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     *
     * @param healthService Servicios de buscarProductoService
     */
    public BuscarProductoController(BuscarProductoService buscarProductoService) {
        this.buscarProductoService = buscarProductoService;
    }

    /**
     * Controlador principal para Buscar Producto
     * La entrada de
     * 
     * 
     *                               Entrada principal de Busqueda
     * @param idCatalogoDepartamento
     * @param idCatalogoZonaEntrega
     * @param idCatalogoFormaPago
     * @param idCatalogoCondicion
     * @param estrellas
     *                               Estos ultimos 5 parametros en dado caso que no
     *                               sean marcados seran dados por default como -1
     *                               para no usar ese tipo como parametro de filtro
     *                               de busqueda
     */
    
    @GetMapping(path = "/buscar-Producto.json", produces = "application/json; charset=utf-8")
    public List<Anuncio> dame(
    	@RequestParam String nombre,
        @RequestParam int idCatalogoDepartamento, 
        @RequestParam int idCatalogoZonaEntrega, 
        @RequestParam int idCatalogoFormaPago, 
        @RequestParam int idCatalogoCondicion, 
        @RequestParam int estrellas) throws BusinessException {
        return buscarProductoService.buscarProducto(nombre, idCatalogoDepartamento, idCatalogoZonaEntrega,
                idCatalogoFormaPago, idCatalogoCondicion, estrellas);
    }
}