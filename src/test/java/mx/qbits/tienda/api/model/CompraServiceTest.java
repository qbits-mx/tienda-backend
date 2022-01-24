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

import mx.qbits.tienda.api.mapper.CompraMapper;
import mx.qbits.tienda.api.model.domain.Compra;
import mx.qbits.tienda.api.model.domain.CompraMultimedia;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.model.response.CompraResponse;
import mx.qbits.tienda.api.service.CompraService;
import mx.qbits.tienda.api.service.CompraServiceImpl;

/**
 * <p>Descripción:</p>
 * Class 'AnuncioServiceTest' para servicio de compra.
 * 
 * @author  gerardomt
 * @version 1.0-SNAPSHOOT
 * @since 1.0-SNAPSHOOT
 */

@RunWith(MockitoJUnitRunner.class)
public class CompraServiceTest {
	private CompraService anuncioService;
	private static final int id=1;

	@Mock
	private CompraMapper anuncioMapper;

	@Before
	public void setup() throws SQLException{
		/** Anuncio(id, id_usuario, id_comprador, id_catalogo_condicion, id_catalogo_forma_pago, 
					id_catalogo_zona_entrega, descripcion, vigencia, datos_contacto, validado, 
			  		notificado,revisado, activo, comprado, fecha_compra, estrellas_ven,
					estrellas_com, nombre, precio, comentario, comentario_aprobado")
		*/
		Compra anuncio = new Compra(id, 12345, 54321, 0, 1, 1, 1, "Descripción", null, "Contacto",
				true, true, true, true, false, null, 0, 0, "Nombre", 10.0, "Comentario", false);
		CompraMultimedia image = new CompraMultimedia(1, id, "imagen", "Dirección");
		when(anuncioMapper.getById(id)).thenReturn(anuncio);
		when(anuncioMapper.updateDatosCompra(anuncio)).thenReturn(1);
		when(anuncioMapper.getImageByIdAnuncio(id)).thenReturn(image);
	}

	// dameAnuncio con idUsuario válido y dado de alta.
	@Test
	public void dameAnuncioTest1() {
		anuncioService = new CompraServiceImpl(anuncioMapper);

		try {
			CompraResponse response = anuncioService.dameAnuncio(id);
			assertTrue(response.getId() == id);
		} catch(BusinessException be) {
			assertTrue(false);
		}
	}

	// dameAnuncio con idUsuario válido pero no dado de alta.
	@Test
	public void dameAnuncioTest2() {
		anuncioService = new CompraServiceImpl(anuncioMapper);

		try {
			CompraResponse response = anuncioService.dameAnuncio(2);
			assertFalse(true);
		} catch(BusinessException be) {
			assertTrue(true);
		}
	}

	// actualizaCompra con forma de pago no válida.	@Test
	public void actualizarCompraIncorrectoTest() throws SQLException{
		anuncioService = new CompraServiceImpl(anuncioMapper);

		try {
			Compra response = anuncioService.actualizarCompra(id, 787878, -1);
			assertFalse(true);
		} catch(BusinessException be) {
			assertTrue(true);
		}
	}

	// actualizarCompra con idUsuario no válido.
	@Test
	public void actualizarCompraIncorrectoTest2() throws SQLException{
		anuncioService = new CompraServiceImpl(anuncioMapper);

		try {
			Compra response = anuncioService.actualizarCompra(id, -20, 1);
			assertFalse(true);
		} catch(BusinessException be) {
			assertTrue(true);
		}
	}

	// actualizarCompra con idProducto no válido.
	@Test
	public void actualizarCompraIncorrectoTest3() throws SQLException{
		anuncioService = new CompraServiceImpl(anuncioMapper);

		try {
			Compra response = anuncioService.actualizarCompra(-1234, 20, 1);
			assertFalse(true);
		} catch(BusinessException be) {
			assertTrue(true);
		}
	}

	@Test
	public void actualizarCompraCorrectoTest() throws SQLException{
		anuncioService = new CompraServiceImpl(anuncioMapper);

		try {
			// Se crean los id,forma de pago entre 0-3 y actualiza la compra.
			int randIdComprador = new Random().nextInt(2000);
			int randFormaPago = new Random().nextInt(3);


			Compra response = anuncioService.actualizarCompra(id, randIdComprador, randFormaPago);

			assertTrue(response.getIdComprador() == randIdComprador);
			assertTrue(response.getIdCatalogoFormaPago() == randFormaPago);
			assertTrue(!response.isActivo());
			assertTrue(response.isComprado());
		} catch(BusinessException be) {
			assertTrue(false);
		}
	}

}
