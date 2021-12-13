package mx.qbits.tienda.api.service;

import java.util.List;

import mx.qbits.tienda.api.model.domain.CatalogoJCatalogoMaestro;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

public interface CatalogoJCatalogoMaestroService {
    

    /**
     * Método que obtiene todos los catalogos join catalogos maestros en la base de datos.
     * @return List<CatalogoMaestro> Una lista con todos los catalogos y dos campos extra, el id del catalogo_maestro
     * y el nombre del catalogo_maestro.
     * @throws BusinessException en caso de que ocurra un problema con el select.
     */
    List<CatalogoJCatalogoMaestro> dameTodosLosCatalogos() throws BusinessException;
    


}
