package mx.qbits.tienda.api.rest;

import mx.qbits.tienda.api.model.domain.Multimedia;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.service.MultimediaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class MultimediaController {
	private MultimediaService multimediaService;
	private final Logger logger = LoggerFactory.getLogger(MultimediaController.class);


	public MultimediaController(MultimediaService multimediaService) {
		this.multimediaService = multimediaService;
	}

	@PostMapping(path = "/salva-multimedia.json", produces = "application/json; charset=utf-8")
	public int salvaMultimedia(@RequestBody List<Multimedia> multimedia) throws BusinessException{
		logger.info(multimedia.toString());
		return multimediaService.salvaMultimedia(multimedia);
	}
}