package mx.qbits.tienda.api.service;

import java.sql.SQLException;
import org.springframework.stereotype.Service;
import mx.qbits.tienda.api.mapper.AnuncioMapper;
import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

@Service
public class AnuncioServiceImpl implements AnuncioService{
	private AnuncioMapper productoMapper;

    // Constructor de la calse
    public AnuncioServiceImpl(AnuncioMapper productoMapper) {
        this.productoMapper = productoMapper;
    }

    // Cambiar
    public Anuncio dameAnuncio(int idAnuncio) throws BusinessException {
    	try{
            Anuncio producto = productoMapper.getById(idAnuncio);
            return producto;
        }catch(SQLException e) {
            throw new BusinessException(e);
        }  
 
    }


    
    public Anuncio actualizarCompra(int idAnuncio, int idComprador, int idCatalogoFormaPago) throws BusinessException {
      
        try {
        	Anuncio producto = productoMapper.getById(idAnuncio);
        	if (producto != null) {
        		producto.setIdComprador(idComprador);
        		producto.setActivo(false);
                producto.setComprado(true);
                producto.setIdCatalogoFormaPago(idCatalogoFormaPago);
        		
        		productoMapper.updateDatosCompra(producto);
        	}
        	return producto;
            // Obtiene el id del comprador y lo cambia en el producto
            // Cambia a true comprado y ¿desactiva producto?
            // Actualiza ID comprad	or y desactivar producto son iguales.

        } catch(SQLException e) {
            throw new BusinessException(e);
        }  
    }


}
