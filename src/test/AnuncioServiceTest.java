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

import mx.qbits.tienda.api.mapper.AnuncioMapper;
import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.service.AnuncioService;
import mx.qbits.tienda.api.service.AnuncioServiceImpl;

/**
 * <p>Descripción:</p>
 * Class AnuncioServiceTest asociado a la entidad Anuncio.
 * @author 2 de Pastor
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */

@RunWith(MockitoJUnitRunner.class)
public class AnuncioServiceTest{
  
  private AnuncioService anuncioService;
  
  @Mock
  private AnuncioMapper anuncioMapper;
  
  @Test
    public void salvaAnuncioTest (){
        anuncioService = new AnuncioServiceImpl(anuncioMapper);
        try {
          anuncioService.salvaAnuncio(9, 1, 1, 1, 1, Anuncio de prueba, '2022-01-31', "prueba@gmail.com", Anuncio Prueba, 30.00)
            assertTrue(true);
        } catch (BusinessException e) {
            assertTrue(false);
        }
    }

}
