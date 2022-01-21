package mx.qbits.tienda.api.service;

import mx.qbits.tienda.api.model.domain.Compra;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.model.response.CompraResponse;

/**
 * interface 'CompraService'.
 *
 * @author pum4Developer$
 * @version 0.1.1-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public interface CompraService {

	/**
	 * Devuelve los datos relacionados a un anuncio dado su id.
	 * @param idAnuncio Id del anuncio del que deseamos obtener los datos
	 * @return Objeto CompraResponse con los datos del anuncio obtenido
	 * @throws BusinessException
	 */
    CompraResponse dameAnuncio(int idAnuncio) throws BusinessException;
    
    
    /**
     * Actualiza la información de compra
     * @param idAnuncio Id del anuncio que se actualizará
     * @param idComprador Id del usuario de compra el producto
     * @param idCatalogoFormaPago Id que indica la forma de pago
     * @return Objeto Anuncio con los datos actualizados
     * @throws BusinessException
     */
    Compra actualizarCompra(int idAnuncio, int idComprador, int idCatalogoFormaPago) throws BusinessException;
}
