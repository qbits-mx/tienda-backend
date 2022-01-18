package mx.qbits.tienda.api.mapper;
import java.sql.SQLException;
import java.util.List;

import mx.qbits.tienda.api.model.domain.InformacionAnuncio;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;


public interface GestorAdministradorMapper {

    final String CAMPOS_GESTOR = " id, id_usuario, nombre, descripcion, datos_contacto, precio, validado, notificado ";

    
    @Results(id="GestorMapping", value = {
    		@Result(property = "id", column = "id"),
    		@Result(property = "idUsuario", column = "id_usuario"),
    		@Result(property = "nombre", column = "nombre"),
    		@Result(property = "descripcion", column = "descripcion"),
    		@Result(property = "datosContacto", column = "datos_contacto"),
    		@Result(property = "precio", column = "precio"),
    		@Result(property = "validado", column = "validado"),
    		@Result(property = "notificado", column = "notificado")
    })
    @Select("SELECT " + CAMPOS_GESTOR + " FROM anuncio WHERE id = #{id} ")
    InformacionAnuncio getById(int id) throws SQLException;

    @ResultMap("GestorMapping")
    @Select("SELECT " + CAMPOS_GESTOR + " FROM anuncio WHERE validado>0 AND notificado = 0")
    List<InformacionAnuncio> consultarValidados() throws SQLException;

    @ResultMap("GestorMapping")
    @Select("SELECT " + CAMPOS_GESTOR + " FROM anuncio WHERE validado = 0 AND notificado = 0")
    List<InformacionAnuncio> consultarNoValidados() throws SQLException;

}
