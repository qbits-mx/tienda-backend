package mx.qbits.tienda.api.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiParam;
import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.model.exceptions.ControllerException;
import mx.qbits.tienda.api.service.AnuncioService;

@RestController
@RequestMapping(value = "/api")
public class AnuncioController {
    
    private AnuncioService anuncioService;
    
    public AnuncioController() {}
    
    public AnuncioController(AnuncioService anuncioService) {
        this.anuncioService = anuncioService;
    }
    
    
    @PutMapping(path = "/auditar-comentario.json", produces = "application/json; charset=utf-8")
    public int auditar(
    		 @RequestParam int id,
             @RequestParam byte aprobado) throws ControllerException {
         //this.verifica(jwt, "ADMIN"); // o sea: sólo un administrador puede actualizar a un usuario cualquiera
         return anuncioService.aprobarComentario(id, aprobado);//this.usuarioService.actualizaUsuario(usuario);
    }
    
    @GetMapping(path = "/revisar-comentarios.json", produces = "application/json; charset=utf-8")
    public List<Anuncio> revisar() throws BusinessException {
        return anuncioService.revisarComentarios();
    } 
    // http://localhost:9999/api/salva.json?id=4&correo=gus@aol.com&clave=hola
    // http://localhost:9999/api/dame-datos.json

}
