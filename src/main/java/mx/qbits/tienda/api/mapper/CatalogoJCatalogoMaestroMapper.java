package mx.qbits.tienda.api.mapper;


import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;


import java.sql.SQLException;
import java.util.List;

import mx.qbits.tienda.api.model.domain.CatalogoJCatalogoMaestro;

public interface CatalogoJCatalogoMaestroMapper {
 
    final String CAMPOS = "catalogo.id, id_catalogo_categoria, tipo_catalogo, nombre, activo";

    @Results(id="CatalogoJCatalogoMaestroMapping", value = {
        @Result(property = "id", column = "catalogo.id"),
        @Result(property = "idMaestro", column = "id_catalogo_categoria"),
        @Result(property = "tipoCatalogo", column = "catalogo_maestro.tipo_catalogo"),
        @Result(property = "nombre" ,column = "nombre"),
        @Result(property = "activo", column = "activo")
    })@Select("SELECT " + CAMPOS + " FROM catalogo inner join catalogo_maestro on catalogo.id_catalogo_categoria = catalogo_maestro.id WHERE activo = 1 ORDER BY nombre ASC")
    List<CatalogoJCatalogoMaestro> getAll() throws SQLException;
    


}
