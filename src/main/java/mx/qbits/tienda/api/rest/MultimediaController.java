package mx.qbits.tienda.api.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.qbits.tienda.api.model.domain.Multimedia;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.service.MultimediaService;

@RestController
@RequestMapping(value = "/api")
public class MultimediaController {

	private MultimediaService multimediaService;

	public MultimediaController(MultimediaService multimediaService) {
		this.multimediaService = multimediaService;
	}
	
	@GetMapping(path = "/conseguir-multimedia.json", produces = "application/json; charset=utf-8")
	public List<Multimedia> getMultimedia(int idAnuncio) throws BusinessException{
		return multimediaService.getMultimedia(idAnuncio);
	}
}
