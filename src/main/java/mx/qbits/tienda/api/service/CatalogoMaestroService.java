package mx.qbits.tienda.api.service;

import mx.qbits.tienda.api.model.domain.CatalogoMaestro;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

public interface CatalogoMaestroService {
    boolean eliminarCatalogo(String tipoCatalogo) throws BusinessException;
    boolean eliminarCatalogo(int id) throws BusinessException;
    CatalogoMaestro buscarCatalogo(int id) throws BusinessException;
    CatalogoMaestro buscarCatalogo(String tipoCatalogo) throws BusinessException;
    boolean modificarTipoCatalogo(int id, String nuevoTipoCatalogo) throws BusinessException;
    boolean modificarTipoCatalogo(String tipoCatalogo, String nuevoTipoCatalogo) throws BusinessException;
    boolean crearCatalogo(String tipoCatalogo) throws BusinessException;
}
