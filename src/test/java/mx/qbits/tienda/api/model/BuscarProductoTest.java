package mx.qbits.tienda.api.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import mx.qbits.tienda.api.mapper.BuscarProductoMapper;
import mx.qbits.tienda.api.service.BuscarProductoService;
import mx.qbits.tienda.api.service.BuscarProductoServiceImpl;

/**
 * Test para Servicio de Buscar Producto.
 *
 * @author Sunflower
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */

//@RunWith(MockitoJUnitRunner.class)
public class BuscarProductoServiceTest {
    
    private LoginService loginService;

    //suplantar la llamada al mapper y la respues de la base
    @Mock
    private BuscarProductoMapper buscarProductoMapper;
    
    /**
     * Flujo nomral de eventos, es decir se encuentran anuncios
     */
    @Test
    public void busquedaEncontrada() {
        
        //provisional hasta implementar la estructura adecuada para la busqueda
        String buscar = "Telefono Celular"      

        Anuncio  anuncio =  new Anuncio(1024, 2048, 01, 1, 2, 03, 06, "Telefono Celular", "11-03-2022","55 84 59 36 19", true , true, true, true, false, "11-03-2022", 4, "Telefono Celular Sony Nuevo", true)
        List<Anuncio> anuncios_encontrados = [anuncio];
        
        busqueda = BuscarProductoService.buscarProducto(bucar,-1,-1,-1,-1,-1);
        
        when(buscarProductoMapper.getByFiltros(buscar)).thenReturn(anuncios_encontrados)

        if (busqueda.size() == anuncios_encontrados.size()){
            assertTrue(true);
        }else{
            assertTrue(false);
        }
    
    }
    
    /**
     * Flujo alternativo de eventos, es decir no encuentra nada
     */
    @Test
    public void busquedaNoEncontrada() throws SQLException {
        
        String buscar = "Bazoka"

        List<Anuncio> anuncios_encontrados = new List<Anuncio> [];
        
        busqueda = BuscarProductoService.buscarProducto(bucar,-1,-1,-1,-1,-1);
        
        when(buscarProductoMapper.getByFiltros(buscar)).thenReturn(anuncios_encontrados)

        if (busqueda.size() == anuncios_encontrados.size()){
            assertFalse(false);
        }else{
            assertFalse(true);
        }
    }
}
