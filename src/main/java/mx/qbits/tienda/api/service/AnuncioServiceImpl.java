package mx.qbits.tienda.api.service;

import java.sql.SQLException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.qbits.tienda.api.mapper.AnuncioMapper;
import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

public class AnuncioServiceImpl implements AnuncioService{
	AnuncioMapper mapper = new AnuncioMapper();
	int salvaAnuncio(Anuncio anuncio) throws BusinessException{
		int usuario = anuncio.getIdUsuario();
		int catalogoPago = anuncio.getCatalogoFormaPago();
		int catalogoCondicion = anuncio.getCatalogoCondicion();
		int catalogoEntrega = anuncio.getCatalogoZOnaEntrega();
		String descripcion = anuncio.getDescripcion();
		date vigencia = anuncio.getVigencia();
		String datosContacto = anuncio.getDatosContacto();

		try{
			mapper.salvaAnuncio(usuario, catalogoPago, catalogoCondicion, catalogoCondicion, catalogoEntrega, descripcion, vigencia, datosContacto);
		} catch(SQLException e){
			throw new BusinessException("Error de Conexión con la base de datos");
		}
	}
}

