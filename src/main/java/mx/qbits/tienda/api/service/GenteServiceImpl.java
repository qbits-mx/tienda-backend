package mx.qbits.tienda.api.service;

import java.awt.List;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import mx.qbits.tienda.api.mapper.GenteMapper;
import mx.qbits.tienda.api.model.domain.Gente;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

@Service
public class GenteServiceImpl implements GenteService{
	
	private GenteMapper mapper;
	
	public GenteServiceImpl(GenteMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public int salvaDatos(int id,String correo, String clave) throws BusinessException {
		try {
			Gente result = mapper.getById(id);
			if (result == null) {
				mapper.insert(correo,clave);
			} else {
				mapper.update(new Gente (id,correo,clave,0));
			}
			return 1;
		} catch (SQLException e) {
			throw new BusinessException(e);
		}
		
	}

	@Override
	public java.util.List<Gente> dameDatos() throws BusinessException {
		try {
			return mapper.getNonBlockedUsers();
		} catch (SQLException e ) {
			throw new BusinessException(e);
		}
	}

}
