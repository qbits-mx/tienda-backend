package mx.qbits.tienda.api.model;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
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
import static org.mockito.BDDMockito.*;

/**
 * <p>Descripción:</p>
 * Class 'AnuncioServiceImplTest' asociada al servicio AnuncioServiceImpl.
 * @author  Dos de Pastor
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
     * Prueba para verificar que se guarda un anuncio con todos los parámetros necesarios.
     */
    @Test
    public void guardaAnuncioOK() {
        // given
        Anuncio creado = new Anuncio();
        int idAnuncio = 0;
        try{
            given(anuncioMapper.insert(1, 1, 4, 3, 2, "hermoso árbol de navidad", LocalDate.of(2021, 1, 27), "prueba@gmail.com",
                    "Árbol navideño", 756.23)).willReturn(1);
            creado.setActivo(false);
            creado.setId(1);
            LinkedList<Anuncio> anuncios = new LinkedList<>();
            anuncios.add(creado);
            given(anuncioMapper.getAnuncioActivo(1)).willReturn(anuncios);
        }catch(SQLException e) {
            assert(false);
        }

        // when
        try{
            idAnuncio = anuncioService.salvaAnuncio(1, 1,
                    4, 3, 2,
                    "hermoso árbol de navidad",
                    LocalDate.of(2021, 1, 27),
                    "prueba@gmail.com",
                    "Árbol navideño", 756.23);
        }catch(BusinessException e) {
            assert(false);
        }

        // then

        then(idAnuncio).isEqualTo(1);
    }

    /**
     * Prueba para verificar que se guarda un anuncio aún cuando la vigencia tiene un valor nulo.
     */
    @Test
    public void guardaAnuncioFechaNull() {
        // given
        Anuncio creado = new Anuncio();
        int idAnuncio = 0;
        try{
            given(anuncioMapper.insert(1, 1,
                    4, 3, 2,
                    "hermoso árbol de navidad", null,
                    "prueba@gmail.com",
                    "Árbol navideño", 756.23)).willThrow(new SQLException());
            creado.setActivo(false);
            creado.setId(1);
            LinkedList<Anuncio> anuncios = new LinkedList<>();
            anuncios.add(creado);
            given(anuncioMapper.getAnuncioActivo(1)).willReturn(anuncios);
        }catch(SQLException e) {
            assert(false);
        }

        // when
        try{
            idAnuncio = anuncioService.salvaAnuncio(1, 1,
                    4, 3, 2,
                    "hermoso árbol de navidad",
                    null,
                    "prueba@gmail.com",
                    "Árbol navideño", 756.23);
        }catch(BusinessException e) {
            assert(false);
        }

        // then

        then(idAnuncio).isEqualTo(1);
    }

    /**
     * Prueba para verificar que sólo se guardan anuncios cuando el usuario al que pertenecen
     * no tiene otros anuncios activos.
     */
    @Test
    public void guardaConActivo() {
        // given
        Anuncio creado = new Anuncio();
        int idAnuncio = 0;
        try{
            given(anuncioMapper.insert(1, 1,
                    4, 3, 2,
                    "hermoso árbol de navidad", null,
                    "prueba@gmail.com",
                    "Árbol navideño", 756.23)).willThrow(new SQLException());
            creado.setActivo(true);
            creado.setId(1);
            LinkedList<Anuncio> anuncios = new LinkedList<>();
            anuncios.add(creado);
            given(anuncioMapper.getAnuncioActivo(1)).willReturn(anuncios);
        }catch(SQLException e) {
            assert(false);
        }

        // when
        try{
            idAnuncio = anuncioService.salvaAnuncio(1, 1,
                    4, 3, 2,
                    "hermoso árbol de navidad",
                    null,
                    "prueba@gmail.com",
                    "Árbol navideño", 756.23);
        }catch(BusinessException e) {
            assert(false);
        }

        // then

        then(idAnuncio).isEqualTo(-1);
    }
}