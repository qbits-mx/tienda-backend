package mx.qbits.tienda.api.service;

import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

public interface AnuncioService {

	/**
	 * Devuelve los datos relacionados a un anuncio dado su id.
	 * @param idAnuncio Id del anuncio del que deseamos obtener los datos
	 * @return Objeto Anuncio con los datos del anuncio obtenido
	 * @throws BusinessException
	 */
    Anuncio dameAnuncio(int idAnuncio) throws BusinessException;
    
    
    /**
     * Actualiza la información de compra
     * @param idAnuncio Id del anuncio que se actualizará
     * @param idComprador Id del usuario de compra el producto
     * @param idCatalogoFormaPago Id que indica la forma de pago
     * @return Objeto Anuncio con los datos actualizados
     * @throws BusinessException
     */
    Anuncio actualizarCompra(int idAnuncio, int idComprador, int idCatalogoFormaPago) throws BusinessException;
}
