package mx.qbits.tienda.api.rest;

import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.service.AnuncioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/api")
public class AnuncioController {
    private AnuncioService anuncioService;

    public AnuncioController(AnuncioService anuncioService) {
        this.anuncioService = anuncioService;
    }

    @GetMapping(path = "/salva-anuncio.json", produces = "application/json; charset=utf-8")
	public int salvaAnuncio(
	@RequestParam int id_usuario,
	@RequestParam int id_catalogo_departamento,
	@RequestParam int id_catalogo_condicion,
	@RequestParam int id_catalogo_forma_pago,
	@RequestParam int id_catalogo_zona_entrega,
	@RequestParam String descripcion,
	@RequestParam Date vigencia,
	@RequestParam String datos_contacto) throws BusinessException{
			return anuncioService.salvaAnuncio(id_usuario, id_catalogo_departamento, id_catalogo_condicion, id_catalogo_forma_pago, id_catalogo_zona_entrega, descripcion, vigencia, datos_contacto);
	}
}
