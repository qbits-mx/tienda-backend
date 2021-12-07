package mx.qbits.tienda.api.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import mx.qbits.tienda.api.mapper.CatalogoMaestroMapper;
import mx.qbits.tienda.api.model.domain.CatalogoMaestro;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.service.CatalogoMaestroService;
import mx.qbits.tienda.api.service.CatalogoMaestroServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CatalogoMaestroServiceTest {
    
    private CatalogoMaestroService catalogoMaestroService;

    @Mock
    private CatalogoMaestroMapper catalogoMaestroMapper;
    
    @Before
    public void setup() throws SQLException {
        CatalogoMaestro catalogoMaestro = new CatalogoMaestro(1, "Estados");

        when(catalogoMaestroMapper.deleteByTipoCatalogo("Estados")).thenReturn(1);
        when(catalogoMaestroMapper.deleteById(1)).thenReturn(1);
        when(catalogoMaestroMapper.getByTipoCatalogo("Estados")).thenReturn(catalogoMaestro);
        when(catalogoMaestroMapper.getById(1)).thenReturn(catalogoMaestro);
        when(catalogoMaestroMapper.insert("Cocina")).thenReturn(2);
    }

    @Test
    public void eliminarCatalogoTipoCorrectTest (){
        catalogoMaestroService = new CatalogoMaestroServiceImpl(catalogoMaestroMapper);
        try {
            assertTrue(catalogoMaestroService.eliminarCatalogo("Estados"));
        } catch (BusinessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void eliminarCatalogoIdIncorrectTest (){
        catalogoMaestroService = new CatalogoMaestroServiceImpl(catalogoMaestroMapper);
        try {
            assertFalse(catalogoMaestroService.eliminarCatalogo("Estadoss"));
        } catch (BusinessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void eliminarCatalogoIdCorrectTest (){
        catalogoMaestroService = new CatalogoMaestroServiceImpl(catalogoMaestroMapper);
        try {
            assertTrue(catalogoMaestroService.eliminarCatalogo(1));
        } catch (BusinessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void eliminarCatalogoTipoIncorrectTest (){
        catalogoMaestroService = new CatalogoMaestroServiceImpl(catalogoMaestroMapper);
        try {
            assertFalse(catalogoMaestroService.eliminarCatalogo(2));
        } catch (BusinessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void buscarCatalogoTipoCorrectTest (){
        catalogoMaestroService = new CatalogoMaestroServiceImpl(catalogoMaestroMapper);
        try {
            assertNotNull(catalogoMaestroService.buscarCatalogo("Estados")); 
        } catch (BusinessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void buscarCatalogoTipoIncorrectTest (){
        catalogoMaestroService = new CatalogoMaestroServiceImpl(catalogoMaestroMapper);
        try {
            assertNull(catalogoMaestroService.buscarCatalogo("Estadoss"));
        } catch (BusinessException e) {
            assertTrue(true);
        }
    }

    @Test
    public void buscarCatalogoIdCorrectTest (){
        catalogoMaestroService = new CatalogoMaestroServiceImpl(catalogoMaestroMapper);
        try {
            assertNotNull(catalogoMaestroService.buscarCatalogo(1)); 
        } catch (BusinessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void buscarCatalogoIdIncorrectTest (){
        catalogoMaestroService = new CatalogoMaestroServiceImpl(catalogoMaestroMapper);
        try {
            assertNull(catalogoMaestroService.buscarCatalogo(2));
        } catch (BusinessException e) {
            assertTrue(true);
        }
    }

    @Test
    public void modificarCatalogoIdCorrectTest (){
        catalogoMaestroService = new CatalogoMaestroServiceImpl(catalogoMaestroMapper);
        try {
            catalogoMaestroService.modificarTipoCatalogo(1, "Deporte");
            assertTrue(true);
        } catch (BusinessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void modificarCatalogoIdIncorrectTest (){
        catalogoMaestroService = new CatalogoMaestroServiceImpl(catalogoMaestroMapper);
        try {
            assertFalse(catalogoMaestroService.modificarTipoCatalogo(2, "Depote"));
        } catch (BusinessException e) {
            assertTrue(true);
        }
    }

    @Test
    public void modificarCatalogoTipoCorrectTest (){
        catalogoMaestroService = new CatalogoMaestroServiceImpl(catalogoMaestroMapper);
        try {
            catalogoMaestroService.modificarTipoCatalogo("Estados", "Deporte");
            assertTrue(true);
        } catch (BusinessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void modificarCatalogoTipoIncorrectTest (){
        catalogoMaestroService = new CatalogoMaestroServiceImpl(catalogoMaestroMapper);
        try {
            assertFalse(catalogoMaestroService.modificarTipoCatalogo("Estadoss", "Depote"));
        } catch (BusinessException e) {
            assertTrue(true);
        }
    }

    @Test
    public void crearCatalogoCorrectTest (){
        catalogoMaestroService = new CatalogoMaestroServiceImpl(catalogoMaestroMapper);
        try {
            assertTrue(catalogoMaestroService.crearCatalogo("Cocina"));
        } catch (BusinessException e) {
            
        }
    }

    @Test
    public void crearCatalogoIncorrectTest (){
        catalogoMaestroService = new CatalogoMaestroServiceImpl(catalogoMaestroMapper);
        try {
            assertFalse(catalogoMaestroService.crearCatalogo("Estados"));
        } catch (BusinessException e) {
            
        }
    }

}
