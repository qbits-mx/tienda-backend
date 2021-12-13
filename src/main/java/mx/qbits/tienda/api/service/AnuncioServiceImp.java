package mx.qbits.tienda.api.service;

import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.mapper.AnuncioMapper;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

import java.sql.SQLException;
import java.util.List;



public class AnuncioServiceImp implements AnuncioService {

	private AnuncioMapper mapper;
	
	public AnuncioServiceImp(AnuncioMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List <Anuncio> revisarComentarios() throws BusinessException {
		try {
            List <Anuncio> pendingComments = mapper.getComentariosPendientes();
            return pendingComments;
        } catch(SQLException e) {
            throw new BusinessException(e);
        }
	}

	@Override
	public int aprobarComentario(int id, byte aprobado) throws BusinessException {
		try {
            mapper.auditarComentario(id, aprobado);
            return 1;
        } catch(SQLException e) {
            throw new BusinessException(e);
        }
	}

}
