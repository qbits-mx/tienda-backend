package mx.qbits.tienda.api.service;

import java.sql.Date;
import org.springframework.stereotype.Service;
import mx.qbits.tienda.api.mapper.AnuncioMapper;
import mx.qbits.tienda.api.model.domain.Anuncio;

@Service
public class AnuncioServiceImpl implements AnuncioService{
	private AnuncioMapper mapper;

	pubic AnuncioServiceImpl(AnuncioMapper mapper){
		this.mapper = mapper;
	}
	@Override
	public int salvaAnuncio(int idUsuario, int catalogoDepartamento, int catalogoPago, int catalogoCondicion, int catalogoEntrega, String descripcion, Date vigencia, String datosContacto) throws BusinessException{

		try{
			mapper.insert(idUsuario, catalogoDepartamento, catalogoPago, catalogoCondicion, catalogoCondicion, catalogoEntrega, descripcion, vigencia, datosContacto);
			return 1;
		} catch(SQLException e){
			throws new BusinessException(e);
		}
	}
}
