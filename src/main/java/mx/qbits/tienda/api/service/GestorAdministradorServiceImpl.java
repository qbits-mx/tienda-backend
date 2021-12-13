package mx.qbits.tienda.api.service;

import java.sql.SQLException;
import java.util.List;

import mx.qbits.tienda.api.mapper.GestorAdministradorMapper;
import mx.qbits.tienda.api.model.domain.Anuncio;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.qbits.tienda.api.mapper.GenteMapper;
import mx.qbits.tienda.api.model.domain.Gente;
import mx.qbits.tienda.api.model.exceptions.BusinessException;


@Service
public class GestorAdministradorServiceImpl implements GestorAdministradorService {
    private GestorAdministradorMapper mapper;
    public GestorAdministradorServiceImpl(GestorAdministradorMapper mapper) {
        this.mapper = mapper;
    }
    @Override
    public List<Anuncio> consultarNoValidados() throws BusinessException {
        try {
            return mapper.consultarNoValidados();
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public List<Anuncio> consultarValidados() throws BusinessException {
        try {
            return mapper.consultarValidados();
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }
}
