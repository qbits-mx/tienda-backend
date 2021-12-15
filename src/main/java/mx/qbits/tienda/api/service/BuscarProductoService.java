package mx.qbits.tienda.api.service;

import java.sql.SQLException;
import java.util.List;

import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

public interface BuscarProductoService {

    public List<Anuncio> getByFiltros(String descripcion, String idCatalogoDepartamento, String idCatalogoZonaEntrega,
            String idCatalogoFormaPago, String idCatalogoCondicion, String estrellas) throws SQLException;

    /**
     * Recibe un objeto de tipo 'Producto' y retorna todas las conincidencias de la
     * base de datos
     * 
     * @param descripcion
     * @param idCatalogoDepartamento
     * @param idCatalogoZonaEntrega
     * @param idCatalogoFormaPago
     * @param idCatalogoCondicion
     * @param estrellas
     * 
     * @return la lista de Anuncios encontrada
     * @throws BusinessException Se dispara en caso de que hubier un problema
     *                           interno
     */
    public List<Anuncio> buscarProducto(String descripcion, int idCatalogoDepartamento, int idCatalogoZonaEntrega,
            int idCatalogoFormaPago, int idCatalogoCondicion, int estrellas) throws BusinessException;

}