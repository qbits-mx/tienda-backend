package mx.qbits.tienda.api.service;

import mx.qbits.tienda.api.mapper.AnuncioMapper;

public class AnuncioServiceImpl implements AnuncioService{
	AnuncioMapper mapper = new AnuncioMapper();
	int salvaAnuncio(Anuncio anuncio) throws Exception{
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
			throw new Exception("Error de Conexión con la base de datos");
		}
	}
}
