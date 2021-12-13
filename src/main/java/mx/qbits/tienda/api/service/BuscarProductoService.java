package mx.qbits.tienda.api.service;

import java.util.List;

import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

public interface BuscarProductoService {
    /**
     * Recibe un objeto de tipo 'Producto' y averigua si existe en la base de
     * datos.
     * Si existe, lo devuelve.
     * 
     * @param idCatalogoDepartamento
     * @param idCatalogoCondicion
     * @param idCatalogoFormaDePago
     * @param idCatalogoZonaDeEntrega
     * @param descripcion
     * @param activo
     * @param estrellas
     * 
     * 
     * @return 1 si tuvo éxito 0 en otro caso
     * @throws BusinessException Se dispara en caso de que hubier un problema
     *                           interno
     */
    int buscarProducto(int idCatalogoDepartamento, int idCatalogoCondicion, int idCatalogoFormaDePago,
            int idCatalogoZonaDeEntrega, String descripcion, boolean activo, int estrellas) throws BusinessException;

    /**
     * regresa todos los registros de la base de datos en donde coinciden los
     * filtros de busqueda.
     * 
     * @return
     * @throws BusinessException
     */
    List<Anuncio> dameDatos() throws BusinessException;
}