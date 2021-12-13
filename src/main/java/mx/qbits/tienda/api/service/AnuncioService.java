package mx.qbits.tienda.api.service;

import java.util.List;

import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

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
	 * Modifica si el comentario dejado por un comprador fue aprobado para mostrarse al público
	 * 
	 * @param id id del anuncio a cambiar
	 * @param aprobado decisión tomada por el administrador acerca del comentario.
	 * </code> true <code> si fue aprobado y </code> false <code> en otro caso.
	 * @return 1 si tuvo éxito 0 en otro caso
	 * @throws BusinessException
	 */
	int aprobarComentario(int id, byte aprobado) throws BusinessException;
}
