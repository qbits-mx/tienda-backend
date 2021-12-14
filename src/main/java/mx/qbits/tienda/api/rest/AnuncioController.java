package mx.qbits.tienda.api.rest;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.model.exceptions.ControllerException;
import mx.qbits.tienda.api.service.AnuncioService;

@RestController
@RequestMapping(value = "/api")
//@Component
public class AnuncioController {
    
    private AnuncioService anuncioService;
    
    //public AnuncioController() {}
    
    public AnuncioController(AnuncioService anuncioService) {
        this.anuncioService = anuncioService;
    }
    
    /**
     * 
     * @param id
     * @param aprobado
     * @return
     * @throws ControllerException
     */
    @PutMapping(path = "/auditar-comentario.json", produces = "application/json; charset=utf-8")
    public int auditar(
    		 @RequestParam int id,
             @RequestParam byte aprobado) throws ControllerException {
         //this.verifica(jwt, "ADMIN"); // o sea: sólo un administrador puede actualizar a un usuario cualquiera
         return anuncioService.aprobarComentario(id, aprobado);//this.usuarioService.actualizaUsuario(usuario);
    }
    
    /**
     * 
     * @param id
     * @param estrellas
     * @param comentario
     * @return
     * @throws ControllerException
     */
    @PutMapping(path = "/crear-calificacion.json", produces = "application/json; charset=utf-8")
    public int calificar(
             @RequestParam int id,
             @RequestParam int estrellas,
             @RequestParam String comentario) throws ControllerException {
         return anuncioService.crearCalificacion(id, comentario, estrellas);//this.usuarioService.actualizaUsuario(usuario);
    }
    
    /**
     * 
     * @return
     * @throws BusinessException
     */
    @GetMapping(path = "/revisar-comentarios.json", produces = "application/json; charset=utf-8")
    public List<Anuncio> revisar() throws BusinessException {
        return anuncioService.revisarComentarios();
    } 
    
    /**
     * 
     * @param idComprador
     * @return
     * @throws BusinessException
     */
    @GetMapping(path = "/obtener-consulta.json", produces = "application/json; charset=utf-8")
    public List<Anuncio> consultar(int idComprador) throws BusinessException {
        return anuncioService.getConsulta(idComprador);
    } 
    // http://localhost:9999/api/salva.json?id=4&correo=gus@aol.com&clave=hola
    // http://localhost:9999/api/dame-datos.json

}
