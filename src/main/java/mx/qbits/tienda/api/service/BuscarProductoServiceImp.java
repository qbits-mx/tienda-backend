package mx.qbits.tienda.api.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.qbits.tienda.api.mapper.BuscarProductoMapper;
import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

@Service
class BuscarProductoServiceImpl implements BuscarProductoService {

    private BuscarProductoMapper mapper;

    public BuscarProductoServiceImpl(BuscarProductoMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public int buscarProducto(int idCatalogoDepartamento, int idCatalogoCondicion, int idCatalogoFormaDePago,
            int idCatalogoZonaDeEntrega, String descripcion, boolean activo, int estrellas) throws BusinessException {
        return 0;
    }

    @Override
    public List<Anuncio> dameDatos() throws BusinessException {
        return 0;
    }

}