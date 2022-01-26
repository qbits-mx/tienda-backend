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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins="*")
public class AnuncioController {
    
    private AnuncioService anuncioService;
        
    @Autowired
	public AnuncioController(AnuncioService anuncioService) {
		this.anuncioService = anuncioService;
	}
    
    /**
     * Devuelve los anuncios que se han calificado con un comentario que no se han auditado aún
     * @return lista de Anuncios 
     * @throws BusinessException
     */
    @GetMapping(path = "/revisar-comentarios.json", produces = "application/json; charset=utf-8")
    public List<Anuncio> revisar() throws BusinessException {
        return anuncioService.revisarComentarios();
    } 
    
    /**
     * Permite al administrador auditar el comentario seleccionado de un anuncio
     * @param id id del anuncio cuyo comentario auditar
     * @param aprobado 
     * @return
     * @throws ControllerException
     */
    @PutMapping(path = "/auditar-comentario.json", produces = "application/json; charset=utf-8")
    public int auditar(
    		 @RequestParam int id,
             @RequestParam byte aprobado) throws ControllerException {
         //this.verifica(jwt, "ADMIN"); // o sea: sólo un administrador puede actualizar el comentario
         return anuncioService.aprobarComentario(id, aprobado);//this.usuarioService.actualizaUsuario(usuario);
    }
    
    /**
     * Da una calificación de 1-5 estrellas a un anuncio 
     * @param id id del anuncio
     * @param estrellas entero de 1 a 5 representando la calificacion del anuncio 
     * @param comentario cadena opcional que da más detalle de la calificacion del anuncio
     * @return 1 si el anuncio fue calificado con éxito
     * @throws ControllerException
     */
    @PutMapping(path = "/crear-calificacion-anuncio.json", produces = "application/json; charset=utf-8")
    public int calificarAnuncio(
             @RequestParam int id,
             @RequestParam int estrellas,
             @RequestParam String comentario) throws ControllerException {
         return anuncioService.crearCalificacionAnuncio(id, comentario, estrellas);
    }
    
    /**
     * Da una calificación de 1-5 estrellas a un comprador 
     * @param id id del anuncio
     * @param estrellas entero de 1 a 5 representando la calificacion del comprador
     * @return 1 si el comprador fue calificado con éxito
     * @throws ControllerException
     */
    @PutMapping(path = "/crear-calificacion-comprador.json", produces = "application/json; charset=utf-8")
    public int calificarComprador(
             @RequestParam int id,
             @RequestParam int estrellas) throws ControllerException {
         return anuncioService.crearCalificacionComprador(id, estrellas);
    }   
    
    /**
     * Da la calificación promedio de un usuario en solicitudes como comprador
     * @param idUsuario id del comprador
     * @return calificación promediada de la experiencia que han tenido con el usuario como comprador
     * @throws BusinessException
     */
    @GetMapping(path = "/promedio-comprador.json", produces = "application/json; charset=utf-8")
    public double promedio(int idUsuario) throws BusinessException {
        return anuncioService.getCalificacionPromedio(idUsuario);
    }
    
    /**
     * Devuelve el historial de compras del usuario
     * @param idComprador id del usuario registrado
     * @return lista de anuncios comprados por dicho usuario
     * @throws BusinessException
     */
    @GetMapping(path = "/obtener-historial-comprados.json", produces = "application/json; charset=utf-8")
    public List<Anuncio> consultarHistorialComprados(int idComprador) throws BusinessException {
        return anuncioService.getHistComprados(idComprador);
    } 
    
    /**
     * Devuelve el historial de compras del usuario
     * @param idComprador id del usuario registrado
     * @return lista de anuncios comprados por dicho usuario
     * @throws BusinessException
     */
    @GetMapping(path = "/obtener-historial-vendidos.json", produces = "application/json; charset=utf-8")
    public List<Anuncio> consultarHistorialVendidos(int idUsuario) throws BusinessException {
        return anuncioService.getHistVendidos(idUsuario);
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
		return anuncioPublicado;
	}
}