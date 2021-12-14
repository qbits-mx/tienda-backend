package mx.qbits.tienda.api.service;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import mx.qbits.tienda.api.mapper.MultimediaMapper;

import mx.qbits.tienda.api.model.exceptions.BusinessException;
@Service
public class MultimediaServiceImpl implements MultimediaService{
	MultimediaMapper mapper;

	public MultimediaServiceImpl(MultimediaMapper mapper){
		this.mapper = mapper;
	}
	@Override
	public int salvaMultimedia(int idAnuncio, String url, String tipo) throws BusinessException{

		try{
			mapper.insert(idAnuncio, url, tipo);
			return 1;
		} catch(SQLException e){
			throw new BusinessException(e);
		}
	}
}