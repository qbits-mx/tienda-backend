package mx.qbits.tienda.api.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import mx.qbits.tienda.api.mapper.MultimediaMapper;
import mx.qbits.tienda.api.model.domain.Multimedia;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

@Service
public class MultimediaServiceImpl implements MultimediaService {

	private MultimediaMapper multimediaMapper;
	
	public MultimediaServiceImpl(MultimediaMapper multimediaMapper) {
		this.multimediaMapper = multimediaMapper;
	}
	
	@Override
	public List<Multimedia> getMultimedia(int idAnuncio) throws BusinessException {
		try {
			List<Multimedia> multi = multimediaMapper.getMultimedia(idAnuncio);
			return multi;
		}catch(SQLException e) {
			throw new BusinessException(e);
		}
	}

}
