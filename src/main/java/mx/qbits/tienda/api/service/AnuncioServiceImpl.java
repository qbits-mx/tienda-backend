package mx.qbits.tienda.api.service;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import mx.qbits.tienda.api.model.domain.Anuncio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.qbits.tienda.api.mapper.AnuncioMapper;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

@Service
public class AnuncioServiceImpl implements AnuncioService{
	AnuncioMapper mapper;

	@Autowired
	public AnuncioServiceImpl(AnuncioMapper mapper){
		this.mapper = mapper;
	}

	@Override
	public int salvaAnuncio(int idUsuario, int catalogoCondicion, int catalogoPago, int catalogoEntrega,
							int catalogoDepartamento, String descripcion, LocalDate vigencia, String datosContacto,
							String nombre, double precio) throws BusinessException {

		try{
			List<Anuncio> anuncioActivo = mapper.getAnuncioActivo(idUsuario);
			if(anuncioActivo.size() > 0) {
				return -1;
			}

			mapper.insert(idUsuario, catalogoCondicion, catalogoPago,  catalogoEntrega,
					catalogoDepartamento, descripcion, vigencia, datosContacto, nombre, precio);
			return 1;
		} catch(SQLException e){
			throw new BusinessException(e);
		}
	}
}