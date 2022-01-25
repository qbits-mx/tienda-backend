package mx.qbits.tienda.api.model;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import mx.qbits.tienda.api.mapper.AnuncioMapper;
import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.service.AnuncioService;
import mx.qbits.tienda.api.service.AnuncioServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.*;

/**
 * <p>Descripción:</p>
 * Class 'AnuncioServiceImplTest' asociada al servicio AnuncioServiceImpl.
 * @author  JoseRamirezRojas
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see mx.qbits.tienda.api.model.AnuncioServiceImplTest
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class AnuncioServiceImplTest {

    private AnuncioService anuncioService;

    @Mock
    private AnuncioMapper anuncioMapper;


    @BeforeEach
    public void setUp() {
        anuncioService = new AnuncioServiceImpl(anuncioMapper);
    }

    /**
     * Prueba para verificar que se no se guarda una calificación en un id no existente 
     */
    @Test
    public void guardaCalifIdNoExist() {
        int idAnuncio = 0;
        try{
        	int status = anuncioService.crearCalificacionAnuncio(idAnuncio, "comentario", 100);
            assertEquals(status,1);
        }catch(BusinessException e) {
            assertTrue(false);
        }
    }
    
    /**
     * Prueba para verificar que se no se guarda una calificación en un id no existente 
     */
    @Test
    public void guardaCalifOk() {
        int idAnuncio = 0;
        try{
        	int status = anuncioService.crearCalificacionAnuncio(idAnuncio, "comentario", 5);
            assertEquals(status,1);
        }catch(BusinessException e) {
            assertTrue(false);
        }
    }
    
    /**
     * Prueba para verificar que no se audita una calificación en un id no existente 
     */
    @Test
    public void auditarComentIdNoExiste() {
        int idAnuncio = 0;
        byte aprobacion = 1;
        try{
        	int status = anuncioService.aprobarComentario(idAnuncio, aprobacion);
            assertEquals(status,1);
        }catch(BusinessException e) {
            assertTrue(false);
        }
    }
    
    /**
     * Prueba para verificar que se audita una calificación en un id existente 
     */
    @Test
    public void auditarComentOk() {
        int idAnuncio = 1;
        byte aprobacion = 1;
        try{
        	int status = anuncioService.aprobarComentario(idAnuncio, aprobacion);
            assertEquals(status,1);
        }catch(BusinessException e) {
            assertTrue(false);
        }
    }
    
    
    

    
}