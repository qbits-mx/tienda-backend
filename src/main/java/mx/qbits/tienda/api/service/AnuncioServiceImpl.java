package mx.qbits.tienda.api.service;

import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.mapper.AnuncioMapper;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

import java.time.LocalDate;
import mx.qbits.tienda.api.rest.MultimediaController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
* Clase que implementa la interface AnuncioService
* @author 2 de Pastor
* @version 1
*/
@Service
public class AnuncioServiceImpl implements AnuncioService {

	private AnuncioMapper mapper;
    private final Logger logger = LoggerFactory.getLogger(AnuncioServiceImpl.class);

	
    /**
	* Constructor por parámetro
	* @param AnuncioMapper anuncioMapper
	*/
	@Autowired
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

	/**
    * Metodo para salvar el anuncio en la base da datos
    * @param int idUsuario
    * @param int catalogoPago
    * @param int catalogoCondicion
    * @param int catalogoEntrega
    * @param int catalogoDepartamento
    * @param String descripcion
    * @param LocalDate vigencia
    * @param String datosContacto
    * @param String nombre
    * @param int precio
    * @throws Bussines Exception
    */
	@Override
	public int salvaAnuncio(int idUsuario, int catalogoCondicion, int catalogoPago, int catalogoEntrega,
							int catalogoDepartamento, String descripcion, LocalDate vigencia, String datosContacto,
							String nombre, double precio) throws BusinessException {

		try{
			List<Anuncio> anuncioActivo = mapper.getAnuncioActivo(idUsuario);
			for(Anuncio anuncio : anuncioActivo) {
				if(anuncio.isActivo()) {
					return -1;
				}
			}
			
			if(vigencia == null) {
                		LocalDate fecha = LocalDate.now();
                		LocalDate vig = fecha.plusDays(30);
                		mapper.insert(idUsuario, catalogoCondicion, catalogoPago,  catalogoEntrega,
                        		catalogoDepartamento, descripcion, vig, datosContacto, nombre, precio);
				anuncioActivo = mapper.getAnuncioActivo(idUsuario);
				Anuncio ultimo = anuncioActivo.get(anuncioActivo.size() - 1);
				logger.info("Se ha creado un anuncio: {}", anuncioActivo.toString());
				return anuncioActivo.get(anuncioActivo.size() - 1).getId();
            		}else {

				mapper.insert(idUsuario, catalogoCondicion, catalogoPago,  catalogoEntrega,
                        		catalogoDepartamento, descripcion, vigencia, datosContacto, nombre, precio);
				anuncioActivo = mapper.getAnuncioActivo(idUsuario);
				Anuncio ultimo = anuncioActivo.get(anuncioActivo.size() - 1);
				logger.info("Se ha creado un anuncio: {}", anuncioActivo.toString());
				return anuncioActivo.get(anuncioActivo.size() - 1).getId();
				
            		}

			
		} catch(SQLException e){
			throw new BusinessException(e);
		}
	}
	
    
}
