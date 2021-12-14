package mx.qbits.tienda.api.rest;

import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.service.MultimediaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class MultimediaController {
	private MultimediaService multimediaService;

	public MultimediaController(MultimediaService multimediaService) {
		this.multimediaService = multimediaService;
	}

	@GetMapping(path = "/salva-multimedia.json", produces = "application/json; charset=utf-8")
	public int salvaMultimedia(
			@RequestParam int idAnuncio,
			@RequestParam String url,
			@RequestParam String tipo) throws BusinessException{
		return multimediaService.salvaMultimedia(idAnuncio, url, tipo);
	}
}