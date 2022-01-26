/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.mapper
 * Proyecto:    petstore-back
 * Tipo:        Interface
 * Nombre:      UsuarioDetalleMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:11:21
 */
package mx.qbits.tienda.api.mapper;

import java.util.List;
import java.sql.SQLException;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import mx.qbits.tienda.api.model.domain.UsuarioDetalle;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad {@link io.kebblar.petstore.api.model.domain.UsuarioDetalle}.
 *
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.domain.UsuarioDetalle
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@Repository
public interface UsuarioDetalleMapper {

    /** Constant <code>CAMPOS_USER_D=" id_usuario, nombre, apellido_paterno, "{trunked}</code> */
    String CAMPOS_USER_D = " id_usuario, nombre, apellido_paterno, apellido_materno, nick_name, " +
            "fecha_nacimiento, telefono_celular ";

    /**
     * Obtiene un objeto de tipo '{@link io.kebblar.petstore.api.model.domain.UsuarioDetalle} ' realizando la búsqueda con base en el 'id' del Usuario.
     *
     * @param idUsuario representa el identificador de un objeto {@link io.kebblar.petstore.api.model.domain.UsuarioDetalle} .
     * @return el {@link io.kebblar.petstore.api.model.domain.UsuarioDetalle}  encontrado con el criterio de búsqueda.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Results(id="UsuarioDetalleMap", value = {
        @Result(property = "id", column = "id_usuario"),
        @Result(property = "nombre", column = "nombre"),
        @Result(property = "apellidoPaterno", column = "apellido_paterno"),
        @Result(property = "apellidoMaterno", column = "apellido_materno"),
        @Result(property = "nickName", column = "nick_name"),
        @Result(property = "fechaNacimiento", column = "fecha_nacimiento"),
        @Result(property = "telefonoCelular", column = "telefono_celular")
    })
    @Select("SELECT " + CAMPOS_USER_D + " FROM usuario_detalle WHERE id_usuario = #{idUsuario} ")
    UsuarioDetalle getById(int idUsuario) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo {@link io.kebblar.petstore.api.model.domain.UsuarioDetalle} .
     *
     * @return Lista de objetos de tipo {@link io.kebblar.petstore.api.model.domain.UsuarioDetalle}
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("UsuarioDetalleMap")
    @Select("SELECT " + CAMPOS_USER_D + " FROM usuario_detalle ")
    List<UsuarioDetalle> getAll() throws SQLException;

    /**
     * Inserta un objeto de tipo {@link io.kebblar.petstore.api.model.domain.UsuarioDetalle}  con base en la información dada por el objeto de tipo 'UsuarioDetalle'.
     *
     * @param usuarioDetalle objeto de tipo {@link io.kebblar.petstore.api.model.domain.UsuarioDetalle} a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO usuario_detalle(id_usuario, nombre, apellido_paterno, apellido_materno, nick_name, fecha_nacimiento, telefono_celular) VALUES(#{id}, #{nombre}, #{apellidoPaterno}, #{apellidoMaterno}, #{nickName}, #{fechaNacimiento}, #{telefonoCelular} )")
    Integer insert(UsuarioDetalle usuarioDetalle) throws SQLException;

    /**
     * Actualiza un objeto de tipo {@link io.kebblar.petstore.api.model.domain.UsuarioDetalle} con base en la información dada por el objeto de tipo 'UsuarioDetalle'.
     *
     * @param usuarioDetalle objeto de tipo {@link io.kebblar.petstore.api.model.domain.UsuarioDetalle} a ser actualizado.
     * @return el número de registros actualizados.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE usuario_detalle SET nombre = #{nombre}, apellido_paterno = #{apellidoPaterno}, apellido_materno = #{apellidoMaterno}, fecha_nacimiento = #{fechaNacimiento}, nick_name = #{nickName}, telefono_celular = #{telefonoCelular} WHERE id_usuario = #{id} ")
    Integer update(UsuarioDetalle usuarioDetalle) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de {@link io.kebblar.petstore.api.model.domain.UsuarioDetalle}.
     *
     * @param id que representa el identificador del usuario a borrar
     * @return id del usuario borrado
     * @throws java.sql.SQLException dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM usuario_detalle WHERE id_usuario = #{id} ")
    Integer delete(int id) throws SQLException;

    @Insert("update usuario_detalle set foto_perfil = #{nuevoNombre} where id_usuario=#{idUser}")
    int subeFotoPerfil(int idUser, String nuevoNombre) throws SQLException;

    @Select("SELECT foto_perfil FROM usuario_detalle WHERE id_usuario = #{idUser}")
    String getProfilePic(int idUser) throws SQLException;
}