package mx.qbits.tienda.api.mapper;
import java.sql.SQLException;
import java.util.List;

import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.model.domain.InformacionMultimedia;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface GestorAdministradorMapper {

    final String CAMPOS_GESTOR = " id, descripcion, validado";


    @Results(id="GestorMapping", value = {
            @Result(property = "id",              column = "id"),
            @Result(property = "descripcion",           column = "descripcion"),
            @Result(property = "validado", column = "validado")
    })


    @Select("SELECT " + CAMPOS_GESTOR + " FROM anuncio WHERE id = #{id} ")
    Anuncio getById(int id) throws SQLException;

    @ResultMap("GestorMapping")
    @Select("SELECT " + CAMPOS_GESTOR + " FROM anuncio WHERE validado>0")
    List<Anuncio> consultarValidados() throws SQLException;

    @ResultMap("GestorMapping")
    @Select("SELECT " + CAMPOS_GESTOR + " FROM anuncio WHERE validado = 0")
    List<Anuncio> consultarNoValidados() throws SQLException;

}
