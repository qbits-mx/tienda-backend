package mx.qbits.tienda.api.service;

import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

public interface AnuncioService {

    Anuncio dameAnuncio(int idAnuncio) throws BusinessException;
    /**
     * Efectúa la actualización del comprador
     * @param jwt el token del usuario y sus detalles 
     * @return Producto actualizado
     * @throws BusinessException
     */
    Anuncio actualizarCompra(int idAnuncio, int idComprador, int idCatalogoFormaPago) throws BusinessException;

    //Producto errorServidor() throws new BussinesException;

    /**
     * Dado un Producto, se desactiva
     * @param producto a actualizar
     * @return producto actualizado
     * @throws BusinessException
     */
    

}
