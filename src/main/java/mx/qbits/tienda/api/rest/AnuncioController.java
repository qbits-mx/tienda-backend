package mx.qbits.tienda.api.rest;

import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.service.AnuncioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping(value = "/api")
public class AnuncioController {
	private final Logger logger = LoggerFactory.getLogger(AnuncioController.class);
	private AnuncioService anuncioService;

	@Autowired
	public AnuncioController(AnuncioService anuncioService) {
		this.anuncioService = anuncioService;
	}

	@PostMapping(path = "/salva-anuncio.json", produces = "application/json; charset=utf-8")
	public int salvaAnuncio(@RequestBody Anuncio anuncio) throws BusinessException{
		int idUsuario = anuncio.getIdUsuario();
		int idCatalogoCondicion = anuncio.getIdCatalogoCondicion();
		int idCatalogoFormaPago = anuncio.getIdCatalogoFormaDePago();
		int idCatalogoZonaEntrega = anuncio.getIdCatalogoZonaDeEntrega();
		int idCatalogoDepartamento = anuncio.getIdCatalogoDepartamento();
		String descripcion = anuncio.getDescripcion();
		LocalDate vigencia = anuncio.getVigenciaAnuncio();
		String datosContacto = anuncio.getContacto();
		String nombre = anuncio.getNombre();
		double precio = anuncio.getPrecio();
		int anuncioPublicado = anuncioService.salvaAnuncio(idUsuario, idCatalogoCondicion,
				idCatalogoFormaPago, idCatalogoZonaEntrega,idCatalogoDepartamento,
				descripcion, vigencia, datosContacto, nombre, precio);
		logger.info("Se ha guardado un anuncio: {}", anuncio.toString());
		return anuncioPublicado;
	}
}