package mx.qbits.tienda.api.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.qbits.tienda.api.model.domain.Multimedia;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.service.MultimediaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class MultimediaController {

	private MultimediaService multimediaService;
   	private final Logger logger = LoggerFactory.getLogger(MultimediaController.class);


	/**
	* Constructor que recibe el servicio que será utilizado por este controller
	* @param MultimediaService multimediaService
	*/
	public MultimediaController(MultimediaService multimediaService) {
		this.multimediaService = multimediaService;
	}
	
	@GetMapping(path = "/conseguir-multimedia.json", produces = "application/json; charset=utf-8")
	public List<Multimedia> getMultimedia(int idAnuncio) throws BusinessException{
		return multimediaService.getMultimedia(idAnuncio);
	}
	

	@PostMapping(path = "/salva-multimedia.json", produces = "application/json; charset=utf-8")
	public int salvaMultimedia(@RequestBody List<Multimedia> multimedia) throws BusinessException{
		logger.info(multimedia.toString());
		return multimediaService.salvaMultimedia(multimedia);
	}
}
