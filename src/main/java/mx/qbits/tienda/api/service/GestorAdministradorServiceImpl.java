package mx.qbits.tienda.api.service;

import java.sql.SQLException;
import java.util.List;

import mx.qbits.tienda.api.mapper.GestorAdministradorMapper;
import org.springframework.stereotype.Service;
import mx.qbits.tienda.api.model.domain.InformacionAnuncio;
import mx.qbits.tienda.api.model.exceptions.BusinessException;


@Service
public class GestorAdministradorServiceImpl implements GestorAdministradorService {
    private GestorAdministradorMapper mapper;
    public GestorAdministradorServiceImpl(GestorAdministradorMapper mapper) {
        this.mapper = mapper;
    }
    @Override
    public List<InformacionAnuncio> consultarNoValidados() throws BusinessException {
        try {
            return mapper.consultarNoValidados();
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public List<InformacionAnuncio> consultarValidados() throws BusinessException {
        try {
            return mapper.consultarValidados();
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }
}
