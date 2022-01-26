package mx.qbits.tienda.api.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import mx.qbits.tienda.api.model.domain.Gente;
import org.springframework.stereotype.Repository;

@Repository
public interface GenteMapper {

    final String CAMPOS_GENTE = " id, correo, clave, instante_bloqueo ";

    @Results(id="GenteMapping", value = {
            @Result(property = "id",              column = "id"),
            @Result(property = "correo",          column = "correo"),
            @Result(property = "clave",           column = "clave"),
            @Result(property = "instanteBloqueo", column = "instante_bloqueo")
    })
    @Select("SELECT " + CAMPOS_GENTE + " FROM gente WHERE id = #{id} ")
    Gente getById(int id) throws SQLException;

    @ResultMap("GenteMapping")
    @Select("SELECT " + CAMPOS_GENTE + " FROM gente WHERE instante_bloqueo>0 ")
    List<Gente> getNonBlockedUsers() throws SQLException;

    @Insert("INSERT INTO gente(correo, clave, instante_bloqueo) VALUES(#{correo}, #{clave}, 0)")
    int insert(String correo, String clave) throws SQLException;

    @Update("UPDATE gente set correo=#{correo}, clave=#{clave}, instante_bloqueo=#{instanteBloqueo} WHERE id=#{id}")
    int update(Gente gente) throws SQLException;

    @Delete("DELETE FROM gente WHERE id=#{id}")
    int delete(int id) throws SQLException;
}
