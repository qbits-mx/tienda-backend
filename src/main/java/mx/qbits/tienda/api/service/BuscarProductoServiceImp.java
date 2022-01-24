package mx.qbits.tienda.api.service;

import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Service;
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
    private String nombre;
    private int idCatalogoDepartamento;
    private int idCatalogoZonaEntrega;
    private int idCatalogoFormaPago;
    private int idCatalogoCondicion;
    private int estrellas;

    public BuscarProductoServiceImp(BuscarProductoMapper mapper) {
        this.mapper = mapper;
    }

    /** {@inheritDoc} */
    @Override
    public List<Anuncio> buscarProducto(String nombre,
    									int idCatalogoDepartamento,
    									int idCatalogoZonaDeEntrega,
    									int idCatalogoFormaDePago,
    									int idCatalogoCondicion,
    									int estrellasVend) throws BusinessException{
    	/*
        this.idCatalogoDepartamento = (idCatalogoDepartamento == -1) ? "" : String.valueOf(idCatalogoDepartamento);
        this.idCatalogoZonaEntrega = (idCatalogoZonaDeEntrega == -1) ? "" : String.valueOf(idCatalogoZonaEntrega);
        this.idCatalogoFormaPago = (idCatalogoFormaDePago == -1) ? "" : String.valueOf(idCatalogoFormaPago);
        this.idCatalogoCondicion = (idCatalogoCondicion == -1) ? "" : String.valueOf(idCatalogoCondicion);
        this.estrellas = (estrellasVend == -1) ? "" : String.valueOf(estrellas);
        */

        try {
            List<Anuncio> coincidencias = mapper.getByFiltros(this.nombre, this.idCatalogoDepartamento,
                this.idCatalogoZonaEntrega,
                this.idCatalogoFormaPago, this.idCatalogoCondicion, this.estrellas);

        return coincidencias;
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
        
    }

}