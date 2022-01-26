package mx.qbits.tienda.api.service;

import java.util.List;

import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import java.time.LocalDate;

/**
 * @author  JoseRamirezRojas
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public interface AnuncioService {
	
	/**
	 * Devuelve información de comentarios de anuncios por auditar de parte del administrador
	 * 
	 */
	List <Anuncio> revisarComentarios() throws BusinessException;
	
	/**
	 * Regresa el historial de anuncios que el usuario registrado ha comprado
	 * @param idComprador
	 * @return lista de Anuncios donde el idComprador es el del usuario registrado
	 * @throws BusinessException
	 */
	List <Anuncio> getHistComprados(int idComprador) throws BusinessException;
	
	/**
	 * Regresa el historial de anuncios que el usuario registrado ha vendido
	 * @param idUsuario id del usuario registrado
	 * @return lista de Anuncios donde el idUsuario es el del usuario registrado
	 * @throws BusinessException
	 */
	List <Anuncio> getHistVendidos(int idUsuario) throws BusinessException;
	
	
	/**
	 * Modifica si el comentario dejado por un comprador fue aprobado para mostrarse al público
	 * 
	 * @param id id del anuncio a cambiar
	 * @param aprobado decisión tomada por el administrador acerca del comentario.
	 * </code> true <code> si fue aprobado y </code> false <code> en otro caso.
	 * @return 1 si tuvo éxito 0 en otro caso
	 * @throws BusinessException
	 */
	int aprobarComentario(int id, byte aprobado) throws BusinessException;
	
	/**
	 * Modifica una calificación de un anuncio
	 * @param id id de anuncio a modificar
	 * @param comentario comentario dado por el comprador
	 * @param estrellas calificacion de 1 - 5 estrellas
	 * @return 1 si tuvo éxito 0 en otro caso
	 * @throws BusinessException
	 */
	int crearCalificacionAnuncio(int id, String comentario, int estrellas) throws BusinessException;

	/**
	 * Modifica una calificación de un comprador
	 * @param id id de anuncio a modificar
	 * @param estrellas calificacion de 1 - 5 estrellas
	 * @return 1 si tuvo éxito 0 en otro caso
	 * @throws BusinessException
	 */
	int crearCalificacionComprador(int id, int estrellas) throws BusinessException;
	
	/**
	 * Permite saber la calificacion promedio que un comprador tiene en ese momento
	 * @param idUsuario
	 * @return Calificación promedio de todas las compras que ha hecho el usuario dado
	 * @throws BusinessException
	 */
	double getCalificacionPromedio(int idUsuario) throws BusinessException;
    
    /**
    * Metodo para salvar el anuncio en la base da datos
    * @param int idUsuario
    * @param int catalogoPago
    * @param int catalogoCondicion
    * @param int catalogoEntrega
    * @param int catalogoDepartamento
    * @param String descripcion
    * @param LocalDate vigencia
    * @param String datosContacto
    * @param String nombre
    * @param int precio
    */
    int salvaAnuncio(int idUsuario, int catalogoPago,
                         int catalogoCondicion, int catalogoEntrega, int catalogoDepartamento, String descripcion,
                         LocalDate vigencia, String datosContacto, String nombre, double precio)
            throws BusinessException;
}


