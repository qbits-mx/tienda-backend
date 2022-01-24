package mx.qbits.tienda.api.service;

import java.util.List;

import mx.qbits.tienda.api.model.domain.InformacionAnuncio;
import mx.qbits.tienda.api.model.domain.InformacionMultimedia;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

public interface InformacionAnuncioService {

	/**
	 * Recibe un identificador de un anuncio y lo obtiene de la base de datos.
	 * 
	 * @param id a int
	 * @return un objeto de tipo InformacionAnuncio
	 * @throws BusinessException Se dispara en caso de que hubier un problema interno
     */
	InformacionAnuncio getAnuncio(int id) throws BusinessException;
	
	
	/**
	 * Recibe un identificador de un anuncio y un valor booleano, y actualiza el valor validado de un anuncio en la base de datos.
	 * 
	 * @param id a int
	 * @param validado a boolean
	 * @return 1 si tuvo éxito, 0 en otro caso
	 * @throws BusinessException Se dispara en caso de que hubier un problema interno
     */
	int actualizaValidado(int id, boolean validado) throws BusinessException;
	
	/**
	 * Recibe un identificador de un anuncio y un valor booleano, y actualiza el valor notificado de un anuncio en la base de datos,
	 * antes de todo esto se obtiene la informacion de un usuario y se le envia un correo para informarle que su anuncio no cumple las normas.
	 * 
	 * @param id a int
	 * @param notificado a boolean
	 * @param mensaje a String
	 * @return 1 si tuvo éxito, 0 en otro caso
	 * @throws BusinessException Se dispara en caso de que hubier un problema interno
     */
	int actualizaNotificado(int id, boolean notificado, String mensaje) throws BusinessException;
	
	/**
     * Regresa todas las multimedias de la base de datos de un anuncio.
     * @return
     * @throws BusinessException Se dispara en caso de que hubier un problema interno
     */
	List<InformacionMultimedia> dameMultimedias(int id) throws BusinessException;
	
}
