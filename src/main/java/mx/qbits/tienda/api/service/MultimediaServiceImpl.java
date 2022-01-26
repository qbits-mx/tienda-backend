package mx.qbits.tienda.api.service;

import java.sql.SQLException;
import java.util.List;

import mx.qbits.tienda.api.model.domain.Multimedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.qbits.tienda.api.mapper.MultimediaMapper;

import mx.qbits.tienda.api.model.exceptions.BusinessException;
@Service
public class MultimediaServiceImpl implements MultimediaService{
	MultimediaMapper mapper;

	@Autowired
	public MultimediaServiceImpl(MultimediaMapper mapper){
		this.mapper = mapper;
	}
    
    @Override
	public List<Multimedia> getMultimedia(int idAnuncio) throws BusinessException {
		try {
			List<Multimedia> multi = mapper.getMultimedia(idAnuncio);
			return multi;
		}catch(SQLException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public int salvaMultimedia(List<Multimedia> multimedia) throws BusinessException{

		try{
			for(int i = 0; i < multimedia.size(); i++) {
				Multimedia actual = multimedia.get(i);
				mapper.insert(actual.getIdAnuncio(), actual.getTipo(), actual.getUrl());
			}
			return 1;
		} catch(SQLException e){
			throw new BusinessException(e);
		}
	}
}
