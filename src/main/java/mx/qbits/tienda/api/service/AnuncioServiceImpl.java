package mx.qbits.tienda.api.service;

import java.sql.Date;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import mx.qbits.tienda.api.mapper.AnuncioMapper;
import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.model.domain.CompraMultimedia;
import mx.qbits.tienda.api.model.enumerations.EnumMessage;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.model.exceptions.CustomException;
import mx.qbits.tienda.api.model.response.CompraAnuncioResponse;

@Service
public class AnuncioServiceImpl implements AnuncioService{
	private AnuncioMapper productoMapper;

	/**
     * Constructor de la clase.
     *
     * @param productoMapper
     */
    public AnuncioServiceImpl(AnuncioMapper productoMapper) {
        this.productoMapper = productoMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CompraAnuncioResponse dameAnuncio(int idAnuncio) throws BusinessException{
    	try{
            Anuncio anuncio = productoMapper.getById(idAnuncio);
            CompraMultimedia imagen = productoMapper.getImageByIdAnuncio(idAnuncio);
            
            if (anuncio == null)
        		throw new CustomException(EnumMessage.NOT_FOUND, idAnuncio);
            if (imagen == null)
            	throw new CustomException(EnumMessage.NOT_FOUND, idAnuncio);
            
            CompraAnuncioResponse anuncioResponse = new CompraAnuncioResponse(anuncio, imagen);
            return anuncioResponse;
        }catch(SQLException e) {
        	throw new CustomException(EnumMessage.DATABASE, "Error localizando el producto por id");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Anuncio actualizarCompra(int idAnuncio, int idComprador, int idCatalogoFormaPago)
    		throws BusinessException {
    	if (idComprador < 0 || idCatalogoFormaPago < 0)
    		throw new BusinessException("Argumento incorrecto", "Los id's de Comprador y Catálogo deben ser positivos");

    	Anuncio anuncio;
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
