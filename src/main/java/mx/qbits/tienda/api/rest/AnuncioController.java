package mx.qbits.tienda.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.service.AnuncioService;

@RestController
@RequestMapping(value = "/api")
public class AnuncioController{
	private Anuncio model;
	private AnuncioService service = new AnuncioService();
@GetMapping(path = "/salva-anuncio.json", produces = "application/json; charset=utf-8")
	public void salvaAnuncio(
	@RequestParam int id,
	@RequestParam int id_usuario,
	@RequestParam int id_catalogo_condicion,
	@RequestParam int id_catalogo_forma_pago,
	@RequestParam int id_catalogo_zona_entrega,
	@RequestParam String descripcion,
	@RequestParam Date vigencia,
	@RequestParam String datos_contacto) throws BusinessException{
		try{
			model = new Anuncio(id, id_usuario, id_catalogo_condicion, id_catalogo_forma_pago, id_catalogo_zona_entrega, descripcion, vigencia, datos_contacto);
			service.salvaAnuncio(model)
		} catch(Exception e){
			errorConexion();
		}
	}

	public void errorConexion(){
		System.out.print("error de conexión");
	}
}
