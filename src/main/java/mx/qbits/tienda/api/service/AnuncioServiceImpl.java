package mx.qbits.tienda.api.service;

import java.sql.Date;
import org.springframework.stereotype.Service;
import mx.qbits.tienda.api.mapper.AnuncioMapper;
import mx.qbits.tienda.api.model.domain.Anuncio;

@Service
public class AnuncioServiceImpl implements AnuncioService{
	private AnuncioMapper anuncioMapper;

	public AnuncioServiceImpl(AnuncioMapper anuncioMapper) {
		this.anuncioMapper = anuncioMapper;
	}

	@Override
	public int salvaAnuncio(Anuncio anuncio) throws Exception{
		int usuario = anuncio.getIdUsuario();
		int catalogoPago = anuncio.getIdCatalogoFormaDePago();
		int catalogoCondicion = anuncio.getIdCatalogoCondicion();
		int catalogoEntrega = anuncio.getIdCatalogoZonaDeEntrega();
		int catalogoDepartamento =anuncio.getIdCatalogoDepartamento();
		String descripcion = anuncio.getDescripcion();
		Date vigencia = anuncio.getVigenciaAnuncio();
		String datosContacto = anuncio.getContacto();

		//anuncioMapper.insert(usuario, catalogoPago, catalogoCondicion, catalogoCondicion, catalogoEntrega, catalogoDepartamento, descripcion, vigencia, datosContacto);
		return 1;
	}
}
