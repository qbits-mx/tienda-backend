/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     mx.qbits.tienda.api.service
 * Proyecto:    tienda
 * Tipo:        Class
 * Nombre:      CatalogoServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 1 Dic 2021 @ 08:46:09
 */
package mx.qbits.tienda.api.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import mx.qbits.tienda.api.mapper.CatalogoMapper;
import mx.qbits.tienda.api.model.domain.Catalogo;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

/**
 * Class 'CatalogoServiceImpl' que implementa a la interfaz CatalogoService.
 * @author Juan Carlos Bautista Sandoval
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see mx.qbits.tienda.api.service.CatalogoService
 */
@Service
public class CatalogoServiceImpl implements CatalogoService {

    private CatalogoMapper catalogoMapper;

    public CatalogoServiceImpl(CatalogoMapper catalogoMapper) {
        this.catalogoMapper = catalogoMapper;
    }

    /** {@inheritDoc} */
    @Override
    public boolean eliminarCatalogo(String nombre) throws BusinessException {
        try {
            return catalogoMapper.deleteByNombre(nombre) > 0;
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public boolean eliminarCatalogo(int id) throws BusinessException {
        try {
            return catalogoMapper.deleteById(id) > 0;
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public Catalogo buscarCatalogo(int id) throws BusinessException {
        try {
            return catalogoMapper.getById(id);
        } catch (SQLException e) {
            throw new BusinessException(e);    
        }
    }

    /** {@inheritDoc} */
    @Override
    public Catalogo buscarCatalogo(String nombre) throws BusinessException {
        try {
            return catalogoMapper.getByNombre(nombre);
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public boolean modificarNombre(int id, String nuevoNombre) throws BusinessException {
        try {
            Catalogo result = catalogoMapper.getById(id);
            if(result == null) return false;
            catalogoMapper.update(new Catalogo(id, result.getIdCatalogoCategoria(), result.isActivo(), nuevoNombre));
            return true;
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public boolean modificarNombre(String nombre, String nuevoNombre) throws BusinessException {
        try {
            Catalogo result = catalogoMapper.getByNombre(nombre);
            if(result == null) return false;
            catalogoMapper.update(new Catalogo(result.getId(), result.getIdCatalogoCategoria(), result.isActivo(), nuevoNombre));
            return true;
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public boolean modificarActivo(int id, boolean nuevoActivo) throws BusinessException {
        try {
            Catalogo result = catalogoMapper.getById(id);
            if(result == null) return false;
            catalogoMapper.update(new Catalogo(id, result.getIdCatalogoCategoria(), nuevoActivo, result.getNombre()));
            return true;
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public boolean modificarActivo(String nombre, boolean nuevoActivo) throws BusinessException {
        try {
            Catalogo result = catalogoMapper.getByNombre(nombre);
            if(result == null) return false;
            catalogoMapper.update(new Catalogo(result.getId(), result.getIdCatalogoCategoria(), nuevoActivo, nombre));
            return true;
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public boolean modificarIdCatalogoCategoria(int id, int nuevoIdCatalogoCategoria) throws BusinessException {
        try {
            Catalogo result = catalogoMapper.getById(id);
            if(result == null) return false;
            catalogoMapper.update(new Catalogo(id, nuevoIdCatalogoCategoria, result.isActivo(), result.getNombre()));
            return true;
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public boolean modificarIdCatalogoCategoria(String nombre, int nuevoIdCatalogoCategoria) throws BusinessException {
        try {
            Catalogo result = catalogoMapper.getByNombre(nombre);
            if(result == null) return false;
            catalogoMapper.update(new Catalogo(result.getId(), nuevoIdCatalogoCategoria, result.isActivo(), nombre));
            return true;
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public boolean crearCatalogo(int idCatalogoCategoria, boolean activo, String nombre) throws BusinessException {
        try {
            if (catalogoMapper.getByNombre(nombre) == null) {
                catalogoMapper.insert(idCatalogoCategoria, activo, nombre);
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }
    
}
