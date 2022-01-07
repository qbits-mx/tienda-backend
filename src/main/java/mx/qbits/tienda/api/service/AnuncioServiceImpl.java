package mx.qbits.tienda.api.service;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.stereotype.Service;

import mx.qbits.tienda.api.mapper.AnuncioMapper;

import mx.qbits.tienda.api.model.exceptions.BusinessException;
@Service
public class AnuncioServiceImpl implements AnuncioService{
	AnuncioMapper mapper;

	public AnuncioServiceImpl(AnuncioMapper mapper){
		this.mapper = mapper;
	}
	@Override
	public int salvaAnuncio(int idUsuario, int catalogoCondicion, int catalogoPago,  int catalogoEntrega,
							int catalogoDepartamento, String descripcion, Date vigencia, String datosContacto,
							String nombre, double precio) throws BusinessException{

		try{
			mapper.insert(idUsuario, catalogoCondicion, catalogoPago,  catalogoEntrega,
					catalogoDepartamento,descripcion, vigencia, datosContacto, nombre, precio);
			return 1;
		} catch(SQLException e){
			throw new BusinessException(e);
		}
	}
}