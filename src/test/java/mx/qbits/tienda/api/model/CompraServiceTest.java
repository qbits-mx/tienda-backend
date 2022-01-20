package mx.qbits.tienda.api.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import mx.qbits.tienda.api.mapper.AnuncioMapper;
import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.model.domain.CompraMultimedia;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.model.response.CompraAnuncioResponse;
import mx.qbits.tienda.api.service.AnuncioService;
import mx.qbits.tienda.api.service.AnuncioServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class AnuncioServiceTest {
	private AnuncioService anuncioService;
	private static final int id=1;

	@Mock
	private AnuncioMapper anuncioMapper;

	@Before
	public void setup() throws SQLException{
		/** Anuncio(
		 * id, id_usuario, id_comprador, id_catalogo_condicion
		 * id_catalogo_zona_entrega, descripcion, vigencia
		 * datos_contacto, validado, notificado, revisado
		 * activo, comprado, fecha_compra, estrellas
		 * comentario, comentario_aprobado)
		*/
		Anuncio anuncio = new Anuncio(id, 12345, 54321, 0, 1, 1, "Descripción", null, "Contacto",
				true, true, true, true, false, null, 0, 0, "Nombre", 10.0, "Comentario", false);
		CompraMultimedia image = new CompraMultimedia(1, id, "imagen", "Dirección");
		when(anuncioMapper.getById(id)).thenReturn(anuncio);
		when(anuncioMapper.updateDatosCompra(anuncio)).thenReturn(1);
		when(anuncioMapper.getImageByIdAnuncio(id)).thenReturn(image);
	}

	// ActualizaCompra con valores negativos
	@Test
	public void actualizarCompraIncorrectoTest() throws SQLException{
		anuncioService = new AnuncioServiceImpl(anuncioMapper);

		try {
			Anuncio response = anuncioService.actualizarCompra(id, 787878, -1);
			assertFalse(true);
		} catch(BusinessException be) {
			assertTrue(true);
		}
	}

	@Test
	public void dameAnuncioTest1() {
		anuncioService = new AnuncioServiceImpl(anuncioMapper);

		try {
			CompraAnuncioResponse response = anuncioService.dameAnuncio(id);
			assertTrue(response.getId() == id);
		} catch(BusinessException be) {
			assertTrue(false);
		}
	}

	@Test
	public void dameAnuncioTest2() {
		anuncioService = new AnuncioServiceImpl(anuncioMapper);

		try {
			CompraAnuncioResponse response = anuncioService.dameAnuncio(2);
			assertFalse(true);
		} catch(BusinessException be) {
			assertTrue(true);
		}
	}
	@Test
	public void actualizarCompraIncorrectoTest2() throws SQLException{
		anuncioService = new AnuncioServiceImpl(anuncioMapper);

		try {
			Anuncio response = anuncioService.actualizarCompra(id, -20, 1);
			assertFalse(true);
		} catch(BusinessException be) {
			assertTrue(true);
		}
	}

	@Test
	public void actualizarCompraIncorrectoTest3() throws SQLException{
		anuncioService = new AnuncioServiceImpl(anuncioMapper);

		try {
			Anuncio response = anuncioService.actualizarCompra(-1234, 20, 1);
			assertFalse(true);
		} catch(BusinessException be) {
			assertTrue(true);
		}
	}

	@Test
	public void actualizarCompraCorrectoTest() throws SQLException{
		anuncioService = new AnuncioServiceImpl(anuncioMapper);

		try {
			// Se crean los id,forma de pago entre 0-3 y actualiza la compra.
			int randIdComprador = new Random().nextInt(2000);
			int randFormaPago = new Random().nextInt(3);


			Anuncio response = anuncioService.actualizarCompra(id, randIdComprador, randFormaPago);

			assertTrue(response.getIdComprador() == randIdComprador);
			assertTrue(response.getIdCatalogoFormaPago() == randFormaPago);
			assertTrue(!response.isActivo());
			assertTrue(response.isComprado());
		} catch(BusinessException be) {
			assertTrue(false);
		}
	}

}
