package mx.qbits.tienda.api.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import mx.qbits.tienda.api.mapper.CatalogoMapper;
import mx.qbits.tienda.api.model.domain.Catalogo;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.service.CatalogoService;
import mx.qbits.tienda.api.service.CatalogoServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CatalogoServiceTest {
    
    private CatalogoService catalogoService;

    @Mock
    private CatalogoMapper catalogoMapper;

    @Before
    public void setup() throws SQLException{
        Catalogo catalogo = new Catalogo(3, 2, true, "Deporte");
        
        when(catalogoMapper.deleteByNombre("Jalisco")).thenReturn(1);
        when(catalogoMapper.deleteById(1)).thenReturn(1);
        when(catalogoMapper.getByNombre("Deporte")).thenReturn(catalogo);
        when(catalogoMapper.getById(3)).thenReturn(catalogo);
    }

    @Test
    public void eliminarCatalogoNombreCorrectTest(){
        catalogoService = new CatalogoServiceImpl(catalogoMapper);
        try {
            assertTrue(catalogoService.eliminarCatalogo("Jalisco"));
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void eliminarCatalogoNombreIncorrectTest(){
        catalogoService = new CatalogoServiceImpl(catalogoMapper);
        try {
            assertFalse(catalogoService.eliminarCatalogo("Jaliscoo"));
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void eliminarCatalogoIdCorrectTest(){
        catalogoService = new CatalogoServiceImpl(catalogoMapper);
        try {
            assertTrue(catalogoService.eliminarCatalogo(1));
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void eliminarCatalogoIdIncorrectTest(){
        catalogoService = new CatalogoServiceImpl(catalogoMapper);
        try {
            assertFalse(catalogoService.eliminarCatalogo(2));
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void buscarCatalogoIdCorrectTest (){
        catalogoService = new CatalogoServiceImpl(catalogoMapper);
        try {
            assertNotNull(catalogoService.buscarCatalogo(3)); 
        } catch (BusinessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void buscarCatalogoIdIncorrectTest (){
        catalogoService = new CatalogoServiceImpl(catalogoMapper);
        try {
            assertNull(catalogoService.buscarCatalogo(4)); 
        } catch (BusinessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void buscarCatalogoNombreCorrectTest (){
        catalogoService = new CatalogoServiceImpl(catalogoMapper);
        try {
            assertNotNull(catalogoService.buscarCatalogo("Deporte")); 
        } catch (BusinessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void buscarCatalogoNombreIncorrectTest (){
        catalogoService = new CatalogoServiceImpl(catalogoMapper);
        try {
            assertNull(catalogoService.buscarCatalogo("Deportes")); 
        } catch (BusinessException e) {
            assertTrue(false);
        }
    }


    @Test
    public void modificarCatalogoIdNombreCorrectTest (){
        catalogoService = new CatalogoServiceImpl(catalogoMapper);
        try {
            catalogoService.modificarNombre(3, "Muebles");
            assertTrue(true);
        } catch (BusinessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void modificarCatalogoIdNombreIncorrectTest (){
        catalogoService = new CatalogoServiceImpl(catalogoMapper);
        try {
            assertFalse(catalogoService.modificarNombre(2, "Depote") );
        } catch (BusinessException e) {
            assertTrue(true);
        }
    }

    @Test
    public void modificarCatalogoNombreNombreCorrectTest (){
        catalogoService = new CatalogoServiceImpl(catalogoMapper);
        try {
            catalogoService.modificarNombre("Deporte", "Muebles");
            assertTrue(true);
        } catch (BusinessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void modificarCatalogoNombreNombreIncorrectTest (){
        catalogoService = new CatalogoServiceImpl(catalogoMapper);
        try {
            assertFalse(catalogoService.modificarNombre("Cocina", "Depote") );
        } catch (BusinessException e) {
            assertTrue(true);
        }
    }

    //puede que necesite el iddelcatalogocategoria
    @Test
    public void modificarCatalogoIdActivoCorrectTest (){
        catalogoService = new CatalogoServiceImpl(catalogoMapper);
        try {
            catalogoService.modificarActivo(3, false);
            assertTrue(true);
        } catch (BusinessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void modificarCatalogoIdActivoIncorrectTest (){
        catalogoService = new CatalogoServiceImpl(catalogoMapper);
        try {
            assertFalse(catalogoService.modificarActivo(4, false));
        } catch (BusinessException e) {
            assertTrue(true);
        }
    }

    @Test
    public void modificarCatalogoNombreActivoCorrectTest (){
        catalogoService = new CatalogoServiceImpl(catalogoMapper);
        try {
            catalogoService.modificarActivo("Deporte", false);
            assertTrue(true);
        } catch (BusinessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void modificarCatalogoNombreActivoIncorrectTest (){
        catalogoService = new CatalogoServiceImpl(catalogoMapper);
        try {
            assertFalse(catalogoService.modificarActivo("Coches", false));
        } catch (BusinessException e) {
            assertTrue(true);
        }
    }

    @Test
    public void modificarCatalogoIdCatalogoCategoriaCorrectTest (){
        catalogoService = new CatalogoServiceImpl(catalogoMapper);
        try {
            catalogoService.modificarIdCatalogoCategoria(3, 4);
            assertTrue(true);
        } catch (BusinessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void modificarCatalogoIdCatalogoCategoriaIncorrectTest (){
        catalogoService = new CatalogoServiceImpl(catalogoMapper);
        try {
            catalogoService.modificarIdCatalogoCategoria(4, 5);
        } catch (BusinessException e) {
            assertTrue(true);
        }
    }

    @Test
    public void modificarCatalogoNombreCatalogoCategoriaCorrectTest (){
        catalogoService = new CatalogoServiceImpl(catalogoMapper);
        try {
            catalogoService.modificarIdCatalogoCategoria("Deporte", 4);
            assertTrue(true);
        } catch (BusinessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void modificarCatalogoNombreCatalogoCategoriaIncorrectTest (){
        catalogoService = new CatalogoServiceImpl(catalogoMapper);
        try {
            catalogoService.modificarIdCatalogoCategoria("Cocina", 4);
        } catch (BusinessException e) {
            assertTrue(true);
        }
    }

    @Test
    public void crearCatalogoCorrectTest (){
        catalogoService = new CatalogoServiceImpl(catalogoMapper);
        try {
            assertTrue(catalogoService.crearCatalogo(9, false, "Electronica"));
        } catch (BusinessException e) {
            
        }
    }

    @Test
    public void crearCatalogoIncorrectTest (){
        catalogoService = new CatalogoServiceImpl(catalogoMapper);
        try {
            assertFalse(catalogoService.crearCatalogo(9, false, "Deporte"));
        } catch (BusinessException e) {
            assertFalse(true);
        }
    }
}
