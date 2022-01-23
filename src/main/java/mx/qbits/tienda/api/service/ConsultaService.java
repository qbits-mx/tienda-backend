package mx.qbits.tienda.api.service;

import mx.qbits.tienda.api.model.domain.InfoVenta;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.model.domain.InfoCompra;


public interface ConsultaService {
	
	/**
	 * Hace una consulta con informacion relevante a la hora de dar en algun producto del historial de ventas
	 * @param idAnuncio
	 * @return
	 * @throws BusinessException
	 */
	InfoVenta consultaAnuncioVendido (int idAnuncio) throws BusinessException;

}
