package mx.qbits.tienda.api.service;

import java.sql.Date;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import mx.qbits.tienda.api.mapper.CompraMapper;
import mx.qbits.tienda.api.model.domain.Compra;
import mx.qbits.tienda.api.model.domain.CompraMultimedia;
import mx.qbits.tienda.api.model.enumerations.EnumMessage;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.model.exceptions.CustomException;
import mx.qbits.tienda.api.model.response.CompraResponse;

/**
 * <p>Descripción:</p>
 * class 'CompraServiceImpl'.
 * Clase utilitaria que efectua la compra de un producto.
 *
 * @author pum4Developer$
 * @version 0.1.1-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@Service
public class CompraServiceImpl implements CompraService{
	private CompraMapper productoMapper;

	/**
     * Constructor de la clase.
     *
     * @param productoMapper a CompraMapper mapper.
     */
    public CompraServiceImpl(CompraMapper productoMapper) {
        this.productoMapper = productoMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CompraResponse dameAnuncio(int idAnuncio) throws BusinessException{
    	try{
            Compra anuncio = productoMapper.getById(idAnuncio);
            CompraMultimedia imagen = productoMapper.getImageByIdAnuncio(idAnuncio);
            
            if (anuncio == null)
        		throw new CustomException(EnumMessage.NOT_FOUND, idAnuncio);
            if (imagen == null)
            	throw new CustomException(EnumMessage.NOT_FOUND, "'Imagen asociada al id'");
            
            CompraResponse anuncioResponse = new CompraResponse(anuncio, imagen);
            return anuncioResponse;
        }catch(SQLException e) {
        	throw new CustomException(EnumMessage.DATABASE, "Error localizando el producto por id");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Compra actualizarCompra(int idAnuncio, int idComprador, int idCatalogoFormaPago)
    		throws BusinessException {
    	if (idComprador < 0 || idCatalogoFormaPago < 0)
    		throw new BusinessException("Argumento incorrecto", "Los id's de Comprador y Catálogo deben ser positivos");

    	Compra anuncio;
    	Date fechaCompra;
    	int regsActualizados;
        try {
        	anuncio = productoMapper.getById(idAnuncio);
        	if (anuncio == null)
        		throw new CustomException(EnumMessage.NOT_FOUND, idAnuncio);

        	anuncio.setIdComprador(idComprador);
        	anuncio.setActivo(false);
            anuncio.setComprado(true);
            anuncio.setIdCatalogoFormaPago(idCatalogoFormaPago);
            fechaCompra = new Date(System.currentTimeMillis());
        	anuncio.setFechaCompra(fechaCompra);

        	regsActualizados = productoMapper.updateDatosCompra(anuncio);
        	if (regsActualizados < 1)
        		throw new CustomException(EnumMessage.DATABASE, "Error al actualizar registro");
        } catch(SQLException e) {
        	throw new CustomException(EnumMessage.DATABASE, "Error localizando el producto por id");
        }
        return anuncio;
    }
}
