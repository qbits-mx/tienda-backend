package mx.qbits.tienda.api.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.qbits.tienda.api.model.domain.Compra;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.model.response.CompraResponse;
import mx.qbits.tienda.api.service.CompraService;

@RestController
@RequestMapping(value = "/api")
public class CompraController {
    
    private CompraService productoService;
    
    public CompraController(CompraService productoService) {
        this.productoService = productoService;
    }
     
    @GetMapping(path = "/actualiza-compra.json", produces = "application/json; charset=utf-8")
    public Compra actualizaCompra(
           @RequestParam int idProducto,
            @RequestParam int idComprador,
            @RequestParam int idCatalogoFormaPago) throws BusinessException {
        return productoService.actualizarCompra(idProducto, idComprador, idCatalogoFormaPago);
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/dame-anuncio.json", produces = "application/json; charset=utf-8")
    public CompraResponse dameAnuncio(
            @RequestParam int idAnuncio) throws BusinessException {
        return productoService.dameAnuncio(idAnuncio);
    }
}
