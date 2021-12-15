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
    public List<Anuncio> buscarProducto(String descripcion,int idCatalogoDepartamento, int idCatalogoZonaEntrega, int idCatalogoFormaPago,int idCatalogoCondicion,int estrellas) throws BusinessException {
        String descripcion  =  this.descripcion;
        String idCatalogoDepartamento =  (idCatalogoDepartamento == -1 ) ? "" :  this.idCatalogoDepartamento;
        String idCatalogoZonaEntrega =  (idCatalogoZonaEntrega == -1 ) ? "" :  this.idCatalogoZonaEntrega;
        String idCatalogoFormaPago =  (idCatalogoFormaPago == -1 ) ? "" :  this.idCatalogoFormaPago;
        String idCatalogoCondicion =  (idCatalogoCondicion == -1 ) ? "" :  this.idCatalogoCondicion;
        String estrellas =  (estrellas == -1 ) ? "" :  this.estrellas;
        
        List<Anuncio> coincidencias = mapper.getByFiltros(descripcion,idCatalogoDepartamento, idCatalogoZonaEntrega, idCatalogoFormaPago,idCatalogoCondicion, estrellas);

        return coincidencias;
    }

}