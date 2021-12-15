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

/**
 * Implementacion de Service
 *
 * @author Sunflower
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see Anuncio
 */
@Service
public class BuscarProductoServiceImp implements BuscarProductoService {

    private BuscarProductoMapper mapper;
    String descripciones;
    String idCatalogoDepartamento;
    String idCatalogoZonaEntrega;
    String idCatalogoFormaPago;
    String idCatalogoCondicion;
    String estrellas;

    public BuscarProductoServiceImp(BuscarProductoMapper mapper) {
        this.mapper = mapper;
    }

    /** {@inheritDoc} */
    @Override
    public List<Anuncio> buscarProducto(String descripcion, int idCatalogoDepartamento, int idCatalogoZonaEntrega,
            int idCatalogoFormaPago, int idCatalogoCondicion, int estrellas) throws BusinessException {
        this.descripciones = descripcion;
        this.idCatalogoDepartamento = (idCatalogoDepartamento == -1) ? "" : String.valueOf(idCatalogoDepartamento);
        this.idCatalogoZonaEntrega = (idCatalogoZonaEntrega == -1) ? "" : String.valueOf(idCatalogoZonaEntrega);
        this.idCatalogoFormaPago = (idCatalogoFormaPago == -1) ? "" : String.valueOf(idCatalogoFormaPago);
        this.idCatalogoCondicion = (idCatalogoCondicion == -1) ? "" : String.valueOf(idCatalogoCondicion);
        this.estrellas = (estrellas == -1) ? "" : String.valueOf(estrellas);

        List<Anuncio> coincidencias = mapper.getByFiltros(descripcion, idCatalogoDepartamento, idCatalogoZonaEntrega,
                idCatalogoFormaPago, idCatalogoCondicion, estrellas);

        return coincidencias;
    }

}