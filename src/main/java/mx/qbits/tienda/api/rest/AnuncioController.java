package mx.qbits.tienda.api.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.service.AnuncioService;

@RestController
@RequestMapping(value = "/api")
public class AnuncioController {
    
    private AnuncioService productoService;
    
    public AnuncioController(AnuncioService productoService) {
        this.productoService = productoService;
    }
     
    @GetMapping(path = "/actualiza-compra.json", produces = "application/json; charset=utf-8")
    public Anuncio actualizaCompra(
           @RequestParam int idProducto,
            @RequestParam int idComprador,
            @RequestParam int idCatalogoFormaPago) throws BusinessException {
        return productoService.actualizarCompra(idProducto, idComprador, idCatalogoFormaPago);
    }
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/dame-anuncio.json", produces = "application/json; charset=utf-8")
    public Anuncio dameAnuncio(
            @RequestParam int idAnuncio) throws BusinessException {
        return productoService.dameAnuncio(idAnuncio);
    }

    // http://localhost:9999/api/salva.json?id=4&correo=gus@aol.com&clave=hola
    // http://localhost:9999/api/dame-datos.json

}
