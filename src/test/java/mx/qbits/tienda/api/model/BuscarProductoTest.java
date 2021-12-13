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


//@RunWith(MockitoJUnitRunner.class)
public class BuscarProductoServiceTest {
    
    private LoginService loginService;
    
    //Datos a Suplantar

    //Necesito la entrada de la pagina  y una consulta a la base de datos y una respuesta
    //la consulta la hara el mapper

    //suplantar la llamada al mapper y la respues de la base
    @Mock
    private BuscarProductoMapper buscarProductoMapper;
    
    
    @Test
    //flujo nomral de eventos, es decir se encuentran anuncios
    public void busquedaEncontrada() {
        
        //provisional hasta implementar la estructura adecuada para la busqueda
        String buscar = "Telefono Celular"

        Anuncio anuncio_encontrado = new Anuncio(1024, "Franco Escamilla", "10101", "Electronicos", "0", "3", "19", "Telefono sony", "11-03-2022", "55 84 59 36 19", true,  true, true, true, false,"03-01-2022", 4, "", true);
        
        
        busqueda = BuscarProductoService.buscarProducto(buscar , 0 , 0, 0,
        0, "", true, 0);
        
        when(buscarProductoMapper.getById(buscar)).thenReturn(anuncio_encontrado)

        if (busqueda == anuncio_encontrado){
            assertTrue(true);
        }else{
            assertTrue(false);
        }
    
    }
    
    @Test
    //flujo alternativo de eventos, es decir no encuentra nada
    public void busquedaNoEncontrada() throws SQLException {
        
        String buscar = "Bazoka"

        Anuncio anuncio_encontrado = new Anuncio();
        
        busqueda = BuscarProductoService.buscarProducto(buscar , 0 , 0, 0,
        0, "", true, 0);
        
        when(buscarProductoMapper.getById(buscar)).thenReturn(anuncio_encontrado)

        if (busqueda == anuncio_encontrado){
            assertFalse(false);
        }else{
            assertFalse(true);
        }
    }
}
