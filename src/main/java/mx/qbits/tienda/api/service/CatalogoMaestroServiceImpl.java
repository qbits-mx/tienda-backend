package mx.qbits.tienda.api.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import mx.qbits.tienda.api.mapper.CatalogoMaestroMapper;
import mx.qbits.tienda.api.model.domain.CatalogoMaestro;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

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
        // TODO Auto-generated method stub
        return false;
    }
    
}
