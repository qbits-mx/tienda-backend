package mx.qbits.tienda.api.service;


import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import mx.qbits.tienda.api.mapper.CatalogoJCatalogoMaestroMapper;
import mx.qbits.tienda.api.model.domain.CatalogoJCatalogoMaestro;

import mx.qbits.tienda.api.model.exceptions.BusinessException;

@Service
public class CatalogoJCatalogoMaestroImpl implements CatalogoJCatalogoMaestroService{
    
    private CatalogoJCatalogoMaestroMapper catalogoMapper;

    public CatalogoJCatalogoMaestroImpl(CatalogoJCatalogoMaestroMapper mapper){
        this.catalogoMapper = mapper;
    }

    @Override
    public List<CatalogoJCatalogoMaestro> dameTodosLosCatalogos() throws BusinessException{
        try{
            List<CatalogoJCatalogoMaestro> res = this.catalogoMapper.getAll();
            CatalogoJCatalogoMaestro aux = null;

            for (CatalogoJCatalogoMaestro catalogoJCatalogoMaestro : res) {
                if (catalogoJCatalogoMaestro.getNombre().equals("Otros")){
                    aux=catalogoJCatalogoMaestro;
                }
            }
            res.remove(aux);
            res.add(aux);
            return res;
        }catch (SQLException e){
            throw new BusinessException(e);
        }
    }


}
