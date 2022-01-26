package mx.qbits.tienda.api.model;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import mx.qbits.tienda.api.mapper.MultimediaMapper;
import mx.qbits.tienda.api.model.domain.Multimedia;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.service.MultimediaService;
import mx.qbits.tienda.api.service.MultimediaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.*;

/**
 * <p>Descripción:</p>
 * Class 'MultimediaServiceImplTest' asociada al servicio MultimediaServiceImpl.
 * @author  Dos de Pastor
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see mx.qbits.tienda.api.model.MultimediaServiceImplTest
 */
@ExtendWith(MockitoExtension.class)
public class MultimediaServiceImplTest {

    private MultimediaService multimediaService;

    @Mock
    private MultimediaMapper multimediaMapper;


    @BeforeEach
    public void setUp() {
        multimediaService = new MultimediaServiceImpl(multimediaMapper);
    }

    /**
     * Prueba para verificar que se guardan las direcciones de una imagen y un video
     * asociadas a un anuncio en específico.
     */
    @Test
    public void guardaMultimediaOK() {
        // given
        List<Multimedia> multimedia = new LinkedList<Multimedia>();
        Multimedia imagen = new Multimedia(1, 1, "imagen.jpg", "imagen");
        Multimedia video = new Multimedia(2, 1, "video.mp4", "video");
        multimedia.add(imagen);
        multimedia.add(video);
        int seInsertaron = 0;
        try{
            given(multimediaMapper.insert(imagen.getIdAnuncio(), imagen.getTipo(), imagen.getUrl())).willReturn(1);
            given(multimediaMapper.insert(video.getIdAnuncio(), video.getTipo(), video.getUrl())).willReturn(1);
        }catch(SQLException e) {
        }

        // when
        try{
            seInsertaron = multimediaService.salvaMultimedia(multimedia);
        }catch(BusinessException e) {
            assert(false);
        }

        // then

        then(seInsertaron).isEqualTo(1);
    }

    /**
     * Prueba para verificar que las multimedias no válidas no son guardadas.
     */
    @Test
    public void guardaMultimediaERROR() {
        // given
        List<Multimedia> multimedia = new LinkedList<Multimedia>();
        Multimedia imagen = new Multimedia(1, 1, "imagen.jpg", "imagen");
        Multimedia video = new Multimedia(1, 1, "video.mp4", "video");
        multimedia.add(imagen);
        multimedia.add(video);
        int seInsertaron = 0;
        try{
            given(multimediaMapper.insert(imagen.getIdAnuncio(), imagen.getTipo(), imagen.getUrl())).willReturn(1);
            given(multimediaMapper.insert(video.getIdAnuncio(), video.getTipo(), video.getUrl())).willThrow(new SQLException());
        }catch(SQLException e) {
        }

        // when
        try{
            seInsertaron = multimediaService.salvaMultimedia(multimedia);
        }catch(BusinessException e) {
            assert(true);
        }
    }
}