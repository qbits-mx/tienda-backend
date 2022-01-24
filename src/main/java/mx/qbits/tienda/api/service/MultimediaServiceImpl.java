package mx.qbits.tienda.api.service;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import mx.qbits.tienda.api.mapper.MultimediaMapper;

import mx.qbits.tienda.api.model.exceptions.BusinessException;

/**
* Implementacion MultimediaServiceImpl de la interface MultimediaService
* @author 2 de Pastor
* @version 1
*/
@Service
public class MultimediaServiceImpl implements MultimediaService{
	MultimediaMapper mapper;

	/**
	* Constructor por parametro
	* @param MultimediaMapper mapper
	*/
	public MultimediaServiceImpl(MultimediaMapper mapper){
		this.mapper = mapper;
	}
	
	/**
    	* Metodo que salva un objeto en la tabla de Multimedia
   	* @param int idAnuncio
    	* @param String url
    	* @param String tipo
    	* @throw Business Exception
    	*/
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
