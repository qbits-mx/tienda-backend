package mx.qbits.tienda.api.rest;

import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.service.AnuncioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class AnuncioController {
    private AnuncioService anuncioService;

    public AnuncioController(AnuncioService anuncioService) {
        this.anuncioService = anuncioService;
    }

    @GetMapping(path = "/salva-anuncio.json", produces = "application/json; charset=utf-8")
    public int salvaAnuncio(
            @RequestParam int id,
            @RequestParam String correo,
            @RequestParam String clave) throws BusinessException {
        return anuncioService.salvaAnuncio(id, correo, clave);
    }
}
