package mx.qbits.tienda.api.service;

import java.sql.Date;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import mx.qbits.tienda.api.mapper.AnuncioMapper;
import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.model.enumerations.EnumMessage;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.model.exceptions.CustomException;

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
    public Anuncio dameAnuncio(int idAnuncio) throws BusinessException {
    	try{
            Anuncio producto = productoMapper.getById(idAnuncio);
            return producto;
        }catch(SQLException e) {
            throw new BusinessException(e);
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Anuncio actualizarCompra(int idAnuncio, int idComprador, int idCatalogoFormaPago)
    		throws BusinessException {
    	Anuncio producto;
    	Date fechaCompra;
    	int regsActualizados;
        try {
        	producto = productoMapper.getById(idAnuncio);
        	if (producto == null)
        		throw new CustomException(EnumMessage.NOT_FOUND, idAnuncio);

        	producto.setIdComprador(idComprador);
        	producto.setActivo(false);
            producto.setComprado(true);
            producto.setIdCatalogoFormaPago(idCatalogoFormaPago);
            fechaCompra = new Date(System.currentTimeMillis());
        	producto.setFechaCompra(fechaCompra);

        	regsActualizados = productoMapper.updateDatosCompra(producto);
        	if (regsActualizados < 1)
        		throw new CustomException(EnumMessage.DATABASE, "Error al actualizar registro");
        } catch(SQLException e) {
        	throw new CustomException(EnumMessage.DATABASE, "Error localizando el producto por id");
        }
        return producto;
    }
}
