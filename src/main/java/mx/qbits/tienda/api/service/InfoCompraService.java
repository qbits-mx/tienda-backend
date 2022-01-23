package mx.qbits.tienda.api.service;

import mx.qbits.tienda.api.model.domain.InfoCompra;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

public interface InfoCompraService {
	
	/**
	 * Hace una consulta con informacion relevante a la hora de dar en algun producto del historial de compras
	 * @param idAnuncio
	 * @return
	 * @throws BusinessException
	 */
	InfoCompra consultaAnuncioComprado (int idAnuncio) throws BusinessException;
	
}
