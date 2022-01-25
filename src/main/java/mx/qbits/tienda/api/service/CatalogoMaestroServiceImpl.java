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
 * Nombre:      CatalogoMaestroServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 1 Dic 2021 @ 08:46:09
 */
package mx.qbits.tienda.api.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import mx.qbits.tienda.api.mapper.CatalogoMaestroMapper;
import mx.qbits.tienda.api.model.domain.CatalogoMaestro;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

/**
 * Class 'CatalogoMaestroServiceImpl' que implementa a la interfaz CatalogoMaestroService.
 * @author Juan Carlos Bautista Sandoval
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see mx.qbits.tienda.api.service.CatalogoMaestroService
 */
@Service
public class CatalogoMaestroServiceImpl implements CatalogoMaestroService {

    private CatalogoMaestroMapper catalogoMaestroMapper;

    public CatalogoMaestroServiceImpl(CatalogoMaestroMapper catalogoMaestroMapper) {
        this.catalogoMaestroMapper = catalogoMaestroMapper;
    }

    @Override
    public boolean eliminarCatalogo(String tipoCatalogo) throws BusinessException {
        try {
            return catalogoMaestroMapper.deleteByTipoCatalogo(tipoCatalogo) > 0;
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public boolean eliminarCatalogo(int id) throws BusinessException {
        try {
            return catalogoMaestroMapper.deleteById(id) > 0;
        } catch (SQLException e) {
            throw new BusinessException(e);    
        }
    }

    @Override
    public CatalogoMaestro buscarCatalogo(int id) throws BusinessException {
        try {
            return catalogoMaestroMapper.getById(id);
        } catch (SQLException e) {
            throw new BusinessException(e);    
        }
    }

    @Override
    public CatalogoMaestro buscarCatalogo(String tipoCatalogo) throws BusinessException {
        try {
            return catalogoMaestroMapper.getByTipoCatalogo(tipoCatalogo);
        } catch (SQLException e) {
            throw new BusinessException(e);    
        }
    }

    @Override
    public boolean modificarTipoCatalogo(int id, String nuevoTipoCatalogo) throws BusinessException {
        try {
            CatalogoMaestro result = catalogoMaestroMapper.getById(id);
            if(result == null) return false;
            catalogoMaestroMapper.update(new CatalogoMaestro(id, nuevoTipoCatalogo));
            return true;
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public boolean modificarTipoCatalogo(String tipoCatalogo, String nuevoTipoCatalogo) throws BusinessException {
        try {
            CatalogoMaestro result = catalogoMaestroMapper.getByTipoCatalogo(tipoCatalogo);
            if(result == null) return false;
            catalogoMaestroMapper.update(new CatalogoMaestro(result.getId(), nuevoTipoCatalogo));
            return true;
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public boolean crearCatalogo(String tipoCatalogo) throws BusinessException {
        try {
            if (catalogoMaestroMapper.getByTipoCatalogo(tipoCatalogo) == null) {
                catalogoMaestroMapper.insert(tipoCatalogo);
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public List<CatalogoMaestro> dameTodosLosCatalogosMaestros() throws BusinessException {
        try {
            return catalogoMaestroMapper.getAll();
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }
    
}
