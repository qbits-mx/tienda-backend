package mx.qbits.tienda.api.service;

import mx.qbits.tienda.api.model.domain.Catalogo;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

public interface CatalogoService {
    boolean eliminarCatalogo(String nombre) throws BusinessException;
    boolean eliminarCatalogo(int id) throws BusinessException;
    Catalogo buscarCatalogo(int id) throws BusinessException;
    Catalogo buscarCatalogo(String nombre) throws BusinessException;
    boolean modificarNombre(int id, String nuevoNombre) throws BusinessException;
    boolean modificarNombre(String nombre, String nuevoNombre) throws BusinessException;
    boolean modificarActivo(int id, boolean nuevoActivo) throws BusinessException;
    boolean modificarActivo(String nombre, boolean nuevoActivo) throws BusinessException;
    boolean modificarIdCatalogoCategoria(int id, int nuevoIdCatalogoCategoria) throws BusinessException;
    boolean modificarIdCatalogoCategoria(String nombre, int nuevoIdCatalogoCategoria) throws BusinessException;
    boolean crearCatalogo(int idCatalogoCategoria, boolean activo, String nombre) throws BusinessException;
}
