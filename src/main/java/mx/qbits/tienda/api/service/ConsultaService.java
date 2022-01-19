package mx.qbits.tienda.api.service;

import mx.qbits.tienda.api.model.domain.InfoCompraVenta;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

public interface ConsultaService {
	
	/**
	 * Hace una consulta con informacion relevante a la hora de dar en algun producto del historial de ventas
	 * @param idAnuncio
	 * @return
	 * @throws BusinessException
	 */
	InfoCompraVenta consultaAnuncioVendido (int idAnuncio) throws BusinessException;

	/**
	 * Hace una consulta con informacion relevante a la hora de dar en algun producto del historial de compras
	 * @param idAnuncio
	 * @return
	 * @throws BusinessException
	 */
	InfoCompraVenta consultaAnuncioComprado (int idAnuncio) throws BusinessException;
}
