/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     mx.qbits.tienda.api.model
 * Proyecto:    tienda
 * Tipo:        Class
 * Nombre:      CatalogoMaestroServiceTest
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 6 Dic 2021 @ 08:46:09
 */
package mx.qbits.tienda.api.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

/**
 * <p>Descripción:</p>
 * Class 'CatalogoMaestroServiceTest' asociado a la entidad CatalogoMaestro.
 * @author Juan Carlos Bautista Sandoval
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see mx.qbits.tienda.api.model.domain.CatalogoMaestroServiceTest
 */
@RunWith(MockitoJUnitRunner.class)
public class CatalogoMaestroServiceTest {
    
    private CatalogoMaestroService catalogoMaestroService;

    @Mock
    private CatalogoMaestroMapper catalogoMaestroMapper;
    
    @Before
    public void setup() throws SQLException {
        CatalogoMaestro catalogoMaestro = new CatalogoMaestro(1, "Estados");
        CatalogoMaestro catalogoMaestro2 = new CatalogoMaestro(5, "Paises");
        CatalogoMaestro catalogoMaestro3 = new CatalogoMaestro(6, "Estados");
        
        List<CatalogoMaestro> result = new ArrayList<>();
        result.add(catalogoMaestro);
        result.add(catalogoMaestro2);
        result.add(catalogoMaestro3);

        when(catalogoMaestroMapper.deleteByTipoCatalogo("Estados")).thenReturn(1);
        when(catalogoMaestroMapper.deleteById(1)).thenReturn(1);
        when(catalogoMaestroMapper.getByTipoCatalogo("Estados")).thenReturn(catalogoMaestro);
        when(catalogoMaestroMapper.getById(1)).thenReturn(catalogoMaestro);
        when(catalogoMaestroMapper.insert("Cocina")).thenReturn(2);
        when(catalogoMaestroMapper.getAll()).thenReturn(result);
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

    @Test
    public void dameTodosLosCatalogosMaestrosCorrectTest (){
        catalogoMaestroService = new CatalogoMaestroServiceImpl(catalogoMaestroMapper);
        try {
            assertNotNull(catalogoMaestroService.dameTodosLosCatalogosMaestros());
        } catch (BusinessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void dameTodosLosCatalogosMaestrosIncorrectTest (){
        catalogoMaestroService = new CatalogoMaestroServiceImpl(catalogoMaestroMapper);
        try {
            assertNotNull(catalogoMaestroService.dameTodosLosCatalogosMaestros());
        } catch (BusinessException e) {
            assertTrue(false);
        }
    }

}