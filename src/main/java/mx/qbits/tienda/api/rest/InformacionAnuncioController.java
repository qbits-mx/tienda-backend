package mx.qbits.tienda.api.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.qbits.tienda.api.model.domain.InformacionAnuncio;
import mx.qbits.tienda.api.model.domain.InformacionMultimedia;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.service.InformacionAnuncioService;

@RestController
@RequestMapping(value = "/api")
public class InformacionAnuncioController {

	private InformacionAnuncioService inAService;
	
	public InformacionAnuncioController(InformacionAnuncioService inAService) {
		this.inAService = inAService;
	}
	
	@GetMapping(path = "/obten-anuncio.json", produces = "application/json; charset=utf-8")
	public InformacionAnuncio getAnuncio(@RequestParam int id) throws BusinessException {
		return inAService.getAnuncio(id);
	}
	
	@GetMapping(path = "/cambia-validado-anuncio.json", produces = "application/json; charset=utf-8")
	public int actualizaValidado(@RequestParam int id, @RequestParam boolean validado) throws BusinessException {
		return inAService.actualizaValidado(id, validado);
	}
	
	@GetMapping(path = "/cambia-notificado-anuncio.json", produces = "application/json; charset=utf-8")
	public int actualizaNotificado(@RequestParam int id, @RequestParam boolean notificado, @RequestParam String mensaje) throws BusinessException {
		return inAService.actualizaNotificado(id, notificado, mensaje);
	}
	
	@GetMapping(path = "/dame-multimedias.json", produces = "application/json; charset=utf-8")
	public List<InformacionMultimedia> getMultimedias(@RequestParam int id) throws BusinessException {
		return inAService.dameMultimedias(id);
	}
}
