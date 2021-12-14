package mx.qbits.tienda.api.service;


import java.util.List;

import mx.qbits.tienda.api.model.domain.Gente;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

public interface GenteService {
	/**
	 * Recibe un objete Gente, y averigua si está en la base, si está actualiza
	 * los datos. Si no, lo inserta.
	 * @param gente Clase con los datos para salvado
	 * @return 1 si tuvo éxito
	 * 		   0 en otro caso
	 * @throws BusinessException Se dispara en caso de que hubiera un problema interno
	 */
	int salvaDatos(int id, String correo, String clave)throws BusinessException;
	
	/**
	 * regresa todos los registros de la base de datos donde instante de bloqueo sea mayor a 0
	 * @return
	 * @throws BusinessException
	 */
	List<Gente> dameDatos() throws BusinessException;
	
}
