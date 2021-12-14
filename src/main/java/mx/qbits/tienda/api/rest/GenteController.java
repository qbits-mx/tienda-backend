package mx.qbits.tienda.api.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import mx.qbits.tienda.api.model.domain.Gente;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.service.GenteService;

@RestController
@RequestMapping(value = "/api")
public class GenteController {
	
	private GenteService genteService;
	
	public GenteController(GenteService genteService) {
		this.genteService = genteService;
	}
	
    @GetMapping(path = "/salva-gente.json", produces = "application/json; charset=utf-8")
    public int salvaGente(
            @RequestParam int id, 
            @RequestParam String correo, 
            @RequestParam String clave ) throws BusinessException {
        return genteService.salvaDatos(id,correo,clave);
    } //http://localhost:9999/api/salva.json?id=
    
    @GetMapping(path = "/dame-datos.json", produces = "application/json; charset=utf-8")
    public List <Gente> dame() throws BusinessException {
        return genteService.dameDatos();
    } 
}
