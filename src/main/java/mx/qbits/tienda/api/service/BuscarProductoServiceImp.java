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
    String descripcion;
    String idCatalogoDepartamento;
    String idCatalogoZonaEntrega;
    String idCatalogoFormaPago;
    String idCatalogoCondicion;
    String estrellas;

    public BuscarProductoServiceImp(BuscarProductoMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Anuncio> getByFiltros(String idCatalogoDepartamento, String idCatalogoZonaEntrega,
            String idCatalogoFormaPago, String idCatalogoCondicion, String estrellas)throws BusinessException{
        try {
            return mapper.getByFiltros(idCatalogoDepartamento, idCatalogoZonaEntrega, idCatalogoFormaPago,
                idCatalogoCondicion, estrellas);
        } catch (SQLException e) {
         throw new BusinessException(e);
        }
                
    }

    /** {@inheritDoc} */
    @Override
    public List<Anuncio> buscarProducto(int idCatalogoDepartamento, int idCatalogoZonaEntrega,
            int idCatalogoFormaPago, int idCatalogoCondicion, int estrellas) throws BusinessException{
        this.idCatalogoDepartamento = (idCatalogoDepartamento == -1) ? "" : String.valueOf(idCatalogoDepartamento);
        this.idCatalogoZonaEntrega = (idCatalogoZonaEntrega == -1) ? "" : String.valueOf(idCatalogoZonaEntrega);
        this.idCatalogoFormaPago = (idCatalogoFormaPago == -1) ? "" : String.valueOf(idCatalogoFormaPago);
        this.idCatalogoCondicion = (idCatalogoCondicion == -1) ? "" : String.valueOf(idCatalogoCondicion);
        this.estrellas = (estrellas == -1) ? "" : String.valueOf(estrellas);

        try {
            List<Anuncio> coincidencias = mapper.getByFiltros(this.idCatalogoDepartamento,
                this.idCatalogoZonaEntrega,
                this.idCatalogoFormaPago, this.idCatalogoCondicion, this.estrellas);

        return coincidencias;
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
        
    }

}