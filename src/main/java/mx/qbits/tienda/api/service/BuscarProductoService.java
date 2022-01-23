package mx.qbits.tienda.api.service;

import java.util.List;

import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

public interface BuscarProductoService {
	
        /**
         * Recibe un objeto de tipo 'Producto' y retorna todas las conincidencias de la
         * base de datos
         * 
         * 
         * @return la lista de Anuncios encontrada
         * @throws BusinessException Se dispara en caso de que hubier un problema
         *                           interno
         */
        public List<Anuncio> buscarProducto(String nombre, int idCatalogoDepartamento,
        int idCatalogoZonaDeEntrega,int idCatalogoFormaDePago,
        int idCatalogoCondicion,int estrellasVend) throws BusinessException;

}