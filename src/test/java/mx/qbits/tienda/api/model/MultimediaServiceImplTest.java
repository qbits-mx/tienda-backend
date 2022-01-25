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

@ExtendWith(MockitoExtension.class)
public class MultimediaServiceImplTest {

    private MultimediaService multimediaService;

    @Mock
    private MultimediaMapper multimediaMapper;


    @BeforeEach
    public void setUp() {
        multimediaService = new MultimediaServiceImpl(multimediaMapper);
    }

    @Test
    public void guardaMultimedia() {
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
            assert(false);
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
}