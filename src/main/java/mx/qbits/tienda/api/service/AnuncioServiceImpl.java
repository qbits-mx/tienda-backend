package mx.qbits.tienda.api.service;

import java.sql.Date;
import java.sql.SQLException;

import mx.qbits.tienda.api.model.exceptions.BusinessException;
import org.springframework.stereotype.Service;
import mx.qbits.tienda.api.mapper.AnuncioMapper;
import mx.qbits.tienda.api.model.domain.Anuncio;

@Service
public class AnuncioServiceImpl implements AnuncioService{
	private AnuncioMapper mapper;

	public AnuncioServiceImpl(AnuncioMapper mapper){
		this.mapper = mapper;
	}
	@Override
	public int salvaAnuncio(int idUsuario, int catalogoDepartamento, int catalogoPago, int catalogoCondicion, int catalogoEntrega, String descripcion, Date vigencia, String datosContacto) throws BusinessException{

		try{
			return (mapper.insert(idUsuario, catalogoCondicion, catalogoDepartamento, catalogoPago, catalogoPago,  descripcion, vigencia, datosContacto));
		} catch(SQLException e){
			throw new BusinessException(e);
		}
	}
}
