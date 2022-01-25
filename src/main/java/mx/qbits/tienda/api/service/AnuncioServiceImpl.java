package mx.qbits.tienda.api.service;

import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.mapper.AnuncioMapper;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


@Service
public class AnuncioServiceImpl implements AnuncioService {

	private AnuncioMapper mapper;
	
	public AnuncioServiceImpl(AnuncioMapper mapper) {
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
	public List<Anuncio> getHistComprados(int idComprador) throws BusinessException {
		try {
            List <Anuncio> history = mapper.getComprados(idComprador);
            return history;
        } catch(SQLException e) {
            throw new BusinessException(e);
        }
	}

	@Override
	public List<Anuncio> getHistVendidos(int idUsuario) throws BusinessException {
		try {
            List <Anuncio> history = mapper.getVendidos(idUsuario);
            return history;
        } catch(SQLException e) {
            throw new BusinessException(e);
        }
	}

	@Override
	public int crearCalificacionAnuncio(int id, String comentario, int estrellas) throws BusinessException {
		try {
            mapper.crearCalificacionVendedor(id, comentario, estrellas);
            return 1;
        } catch(SQLException e) {
            throw new BusinessException(e);
        }
	}

	@Override
	public int crearCalificacionComprador(int id, int estrellas) throws BusinessException {
		try {
            mapper.crearCalificacionComprador(id, estrellas);
            return 1;
        } catch(SQLException e) {
            throw new BusinessException(e);
        }
	}

	@Override
	public double getCalificacionPromedio(int idUsuario) throws BusinessException {
		try {
            double averageRating = mapper.promedioComprador(idUsuario);
            return averageRating;
        } catch(SQLException e) {
            throw new BusinessException(e);
        }
	}

	
	
	
	

}