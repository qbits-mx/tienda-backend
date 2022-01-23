package mx.qbits.tienda.api.model;





import org.junit.Test;

import org.mockito.Mock;

import mx.qbits.tienda.api.mapper.BuscarProductoMapper;
import mx.qbits.tienda.api.service.BuscarProductoServiceImp;

/**
 * Test para Servicio de Buscar Producto.
 *
 * @author Sunflower
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */

// @RunWith(MockitoJUnitRunner.class)
public class BuscarProductoTest {

    // suplantar la llamada al mapper y la respues de la base
    @Mock
    private BuscarProductoMapper buscarProductoMapper;

    @Mock
    private BuscarProductoServiceImp buscarProductoService;

    /**
     * Flujo nomral de eventos, es decir se encuentran anuncios
     */
    @Test
    public void busquedaEncontrada() {
        //long millis=System.currentTimeMillis(); 
        //java.util.Date date = new java.util.Date(millis);
        //String buscar = "Telefono Celular";     
        //Anuncio anuncio = new Anuncio(1024, 2048, 01, 1, 2, 03, 06, "Telefono Celular", date,"55 84 59 36 19", true , true, true, true, false, date, 4, "Telefono Celular Sony Nuevo", true);
        //int id, int idUsuario, int idComprador, int idCatalogoCondicion, int idCatalogoFormaPago,
        //int idCatalogoZonaEntrega, int idCatalogoDepartamento, String descripcion, Date vigencia,
        //String datosContacto, boolean validado, boolean notificado, boolean revisado, boolean activo,
        //boolean comprado, Date fechaCompra, int estrellas, String comentario, boolean comentarioAprobado
        //List<Anuncio> anuncios_encontrados = [anuncio];
        
        //busqueda = BuscarProductoService.buscarProducto(bucar,-1,-1,-1,-1,-1);
        
        //when(buscarProductoMapper.getByFiltros(buscar, "", "", "", "", "")).thenReturn(anuncios_encontrados);

        //if (busqueda.size() == 1){
            //assertTrue(true);
        //}else{
            //assertTrue(false);
        //}
    
    }

    /**
     * Flujo alternativo de eventos, es decir no encuentra nada
     */
   // @Test
    //public void busquedaNoEncontrada() throws SQLException {

        //String buscar = "Bazoka";

        //List<Anuncio> anuncios_encontrados;

        //List<Anuncio> busqueda = BuscarProductoService.buscarProducto(buscar, -1, -1, -1, -1, -1);

        //when(buscarProductoMapper.getByFiltros(buscar, "", "", "", "", "")).thenReturn(anuncios_encontrados);

        //if (busqueda.size() ==  0) {
            //assertFalse(false);
        //} else {
            //assertFalse(true);
        //}
    //}
} 
