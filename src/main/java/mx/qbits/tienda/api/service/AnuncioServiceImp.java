package mx.qbits.tienda.api.service;

import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.mapper.AnuncioMapper;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


@Service
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

	@Override
	public int crearCalificacion(int id, String comentario, int estrellas) throws BusinessException {
		try {
            mapper.crearCalificacion(id, comentario, estrellas);
            return 1;
        } catch(SQLException e) {
            throw new BusinessException(e);
        }
	}

	@Override
	public List<Anuncio> getConsulta(int idComprador) throws BusinessException {
		try {
            List <Anuncio> history = mapper.getHistorial(idComprador);
            return history;
        } catch(SQLException e) {
            throw new BusinessException(e);
        }
	}
	
	
	

}
