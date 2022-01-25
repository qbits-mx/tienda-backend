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
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import mx.qbits.tienda.api.mapper.CatalogoMaestroMapper;
import mx.qbits.tienda.api.mapper.CatalogoMapper;
import mx.qbits.tienda.api.model.domain.Catalogo;
import mx.qbits.tienda.api.model.domain.CatalogoMaestro;
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

    private CatalogoMaestroMapper catalogoMaestroMapper;
    private CatalogoMapper catalogoMapper;

    public CatalogoServiceImpl(CatalogoMapper catalogoMapper, CatalogoMaestroMapper catalogoMaestroMapper) {
        this.catalogoMapper = catalogoMapper;
        this.catalogoMaestroMapper = catalogoMaestroMapper;
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
            Catalogo prueba = catalogoMapper.getByNombre(nuevoNombre);
            if(result == null || (prueba != null && prueba.isActivo())) return false;
            if(prueba != null){
                catalogoMapper.updateWithIdAndIdCatalogoCategoria(new Catalogo(prueba.getId(),prueba.getIdCatalogoCategoria(),true,prueba.getNombre()));
                catalogoMapper.update(new Catalogo(result.getId(), result.getIdCatalogoCategoria(),false, result.getNombre()));
                return true;
            }
            if(catalogoMapper.getByNombre(nuevoNombre) != null) return false;
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
            Catalogo prueba = catalogoMapper.getByNombre(nuevoNombre);
            if(result == null || (prueba != null && prueba.isActivo())) return false;
            if(prueba != null){
                catalogoMapper.updateWithIdAndIdCatalogoCategoria(new Catalogo(prueba.getId(),prueba.getIdCatalogoCategoria(),true,prueba.getNombre()));
                catalogoMapper.update(new Catalogo(result.getId(), result.getIdCatalogoCategoria(),false, result.getNombre()));
                return true;
            }
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
            Catalogo catalogo = catalogoMapper.getByNombre(nombre);
            if (catalogo == null) {
                catalogoMapper.insert(idCatalogoCategoria, activo, nombre);
                return true;
            }
            if ( !catalogo.isActivo() ) {
                catalogoMapper.update(new Catalogo(catalogo.getId(), catalogo.getIdCatalogoCategoria(), true, catalogo.getNombre()) );
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public boolean eliminarCatalogo(String nombre, int idCatalogoCategoria) throws BusinessException {
        try {
            return catalogoMapper.deleteByNombreAndIdCatalogoCategoria(nombre, idCatalogoCategoria) > 0;
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public boolean eliminarCatalogo(int id, int idCatalogoCategoria) throws BusinessException {
        try {
            return catalogoMapper.deleteByIdAndIdCatalogoCategoria(id, idCatalogoCategoria) > 0;
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public Catalogo buscarCatalogo(String nombre, int idCatalogoCategoria) throws BusinessException {
        try {
            return catalogoMapper.getByNombreAndIdCategoria(nombre, idCatalogoCategoria);
        } catch (SQLException e) {
            throw new BusinessException(e);    
        }
    }

    @Override
    public Catalogo buscarCatalogo(int id, int idCatalogoCategoria) throws BusinessException {
        try {
            return catalogoMapper.getByIdAndIdCategoria(id, idCatalogoCategoria);
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public boolean modificarNombreConIdEIdCatalogoCategoria(int id, int idCatalogoCategoria, String nuevoNombre)
            throws BusinessException {
        try {
            Catalogo result = catalogoMapper.getByIdAndIdCategoria(id, idCatalogoCategoria);
            Catalogo prueba = catalogoMapper.getByNombre(nuevoNombre);
            if (result == null || (prueba != null && prueba.isActivo()) ) return false;
            if (prueba != null) {
                catalogoMapper.updateWithIdAndIdCatalogoCategoria(new Catalogo(prueba.getId(),prueba.getIdCatalogoCategoria(),true,prueba.getNombre()));
                return true;
            }
            catalogoMapper.updateWithIdAndIdCatalogoCategoria(new Catalogo(id, idCatalogoCategoria, result.isActivo(), nuevoNombre));
            return true;
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public boolean modificarNombreConNombreEIdCatalogoCategoria(String nombre, int idCatalogoCategoria,
            String nuevoNombre) throws BusinessException {
        try {
            Catalogo result = catalogoMapper.getByNombreAndIdCategoria(nombre, idCatalogoCategoria);
            Catalogo prueba = catalogoMapper.getByNombre(nuevoNombre);
            if (result == null || (prueba != null && prueba.isActivo()) ) return false;
            if (prueba != null) {
                catalogoMapper.updateWithIdAndIdCatalogoCategoria(new Catalogo(prueba.getId(),prueba.getIdCatalogoCategoria(),true,prueba.getNombre()));
                return true;
            }
            catalogoMapper.updateWithIdAndIdCatalogoCategoria(new Catalogo(result.getId(), idCatalogoCategoria, result.isActivo(), nuevoNombre));
            return true;
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public boolean modificarActivoConIdEIdCatalogoCategoria(int id, int idCatalogoCategoria, boolean nuevoActivo)
            throws BusinessException {
        try {
            Catalogo result = catalogoMapper.getByIdAndIdCategoria(id, idCatalogoCategoria);
            if (result == null) return false;
            catalogoMapper.updateWithIdAndIdCatalogoCategoria(new Catalogo(id, idCatalogoCategoria, nuevoActivo, result.getNombre()));
            return true;
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public boolean modificarActivoConNombreEIdCatalogoCategoria(String nombre, int idCatalogoCategoria,
            boolean nuevoActivo) throws BusinessException {
        try {
            Catalogo result = catalogoMapper.getByNombreAndIdCategoria(nombre, idCatalogoCategoria);
            if (result == null) return false;
            catalogoMapper.updateWithIdAndIdCatalogoCategoria(new Catalogo(result.getId(), idCatalogoCategoria, nuevoActivo, nombre));
            return true;
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public boolean modificarIdCatalogoCategoriaConIdEIdCatalogoCategoria(int id, int idCatalogoCategoria,
            int nuevoIdCatalogoCategoria) throws BusinessException {
        try {
            Catalogo result = catalogoMapper.getByIdAndIdCategoria(id, idCatalogoCategoria);
            if (result == null) return false;
            catalogoMapper.updateWithIdAndIdCatalogoCategoria(new Catalogo(id, nuevoIdCatalogoCategoria, result.isActivo(), result.getNombre()));
            return true;
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public boolean modificarIdCatalogoCategoriaConNombreEIdCatalogoCategoria(String nombre, int idCatalogoCategoria,
            int nuevoIdCatalogoCategoria) throws BusinessException {
        try {
            Catalogo result = catalogoMapper.getByNombreAndIdCategoria(nombre, idCatalogoCategoria);
            if (result == null) return false;
            catalogoMapper.updateWithIdAndIdCatalogoCategoria(new Catalogo(result.getId(), nuevoIdCatalogoCategoria, result.isActivo(), nombre));
            return true;
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public List<Catalogo> obtenerTodosLosCatalogos() throws BusinessException {
        try {
            return catalogoMapper.getAll();
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public List<Catalogo> obtenerCatalogosPorIdCatalogoCategoria(int idCatalogoCategoria) throws BusinessException {
        try {
            return catalogoMapper.getByIdCatalogoCategoria(idCatalogoCategoria);
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public List<List<Catalogo>> obtenerCatalogosPorCategoria() throws BusinessException {
        try {
            List<List<Catalogo>> result = new ArrayList<>();
            for (CatalogoMaestro catalogoMaestro : catalogoMaestroMapper.getAll()) {
                int idCatalgoMaestro = catalogoMaestro.getId();
                result.add(obtenerCatalogosPorIdCatalogoCategoria(idCatalgoMaestro));
            }
            return result;    
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }
}
