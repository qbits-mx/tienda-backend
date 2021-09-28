/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     mx.qbits.tienda.api.mapper
 * Proyecto:    tienda
 * Tipo:        Interface
 * Nombre:      RolMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:10:49
 */
package mx.qbits.tienda.api.mapper;

import java.util.List;
import java.sql.SQLException;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;

import mx.qbits.tienda.api.model.domain.Rol;

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad Rol.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see mx.qbits.tienda.api.model.domain.Rol
 */

@Repository
public interface RolMapper {

    /** Constant <code>CAMPOS_ROL=" id, nombre, activo "</code> */
    String CAMPOS_ROL = " id, nombre, activo ";

    /**
     * Retorna el rol dado su id y si este está activo.
     *
     * @param id id del rol buscado
     * @return Rol correspondiente al id del parámetro
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos
     */
    @Select("SELECT id, nombre, activo FROM rol WHERE id = #{id} and activo=true")
    Rol getRol(int id) throws SQLException;

    /**
     * Dado el id de un usuario, la función nos devuelve la lista de roles que este tiene.
     *
     * @param idUser id del usuario buscado
     * @return Lista de roles asociados a esta cuenta
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos
     */
    @Select("select rol.* from usuario, rol, usuario_rol WHERE usuario.id=usuario_rol.id_usuario and usuario.id=#{idUser} and rol.id=usuario_rol.id_rol and rol.activo=true;")
    List<Rol> getUserRoles(int idUser) throws SQLException;

    /**
     * Inserta un usuario y su rol en una tabla que relaciona ambas características.
     *
     * @param idUsuario id del usuario
     * @param idRol id del rol asociado al usuario
     * @return Entero que indica que la operación salió bien
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos
     */
    @Insert("INSERT INTO usuario_rol VALUES(#{idUsuario}, #{idRol})")
    int insertUserRol(int idUsuario, int idRol) throws SQLException;

    /**
     * Obtiene un objeto de tipo 'Rol' dado su id.
     *
     * @return Rol que tiene asignado el id pasado como parámetro
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     * @param id a int.
     */
    @Results(id="RolMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "nombre",   column = "nombre"),
            @Result(property = "activo",   column = "activo")
    })
    @Select("SELECT " + CAMPOS_ROL + " FROM rol WHERE id = #{id} ")
    Rol getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'Rol'.
     *
     * @return Lista de objetos de tipo Rol
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("RolMap")
    @Select("SELECT " + CAMPOS_ROL + " FROM rol ")
    List<Rol> getAllSinFiltros() throws SQLException;

    /**
     * <p>getAll.</p>
     *
     * @return a {@link java.util.List} object.
     * @throws java.sql.SQLException if any.
     */
    @Select("SELECT id, nombre, activo FROM rol")
    List<Rol> getAll() throws SQLException;

    /**
     * Inserta un objeto de tipo 'Rol' con base en la información dada por el objeto de tipo 'Rol'.
     *
     * @param rol a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert(
    "INSERT INTO rol(id, nombre, activo) "
   + "VALUES(#{id}, #{nombre}, #{activo} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Rol rol) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'Rol' con base en la información dada por el objeto de tipo 'Rol'.
     *
     * @param rol a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update(
    "UPDATE rol"
    + " SET nombre = #{nombre}, activo = #{activo}"
    + " WHERE id = #{id} ")
    int update(Rol rol) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de Rol.
     *
     * @param id id del Rol a ser borrado
     * @return id del Rol borrado
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM rol WHERE id = #{id} ")
    int delete(int id) throws SQLException;

}
