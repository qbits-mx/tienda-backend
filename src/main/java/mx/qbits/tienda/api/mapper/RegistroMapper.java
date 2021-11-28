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
 * Nombre:      RegistroMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:10:38
 */
package mx.qbits.tienda.api.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import mx.qbits.tienda.api.model.domain.UsuarioDetalle;
import mx.qbits.tienda.api.model.request.Preregistro;

import java.sql.SQLException;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad Registro.
 *
 * @author Gustavo A. Arellano
 * @version 0.1.1-SNAPSHOT
 */
public interface RegistroMapper {

    /** Constant <code>CAMPOS_REG=" id, nick, correo, clave_hash, telefono"{trunked}</code> */
    String CAMPOS_REG = " id, nick, correo, clave_hash, telefono, fecha_nacimiento, random_string, " +
            "instante_registro ";

    /**
     * Recupera un elemento del preregistro utilizando el correo electrónico que ingresó.
     *
     * @param correo mail de registro
     * @return Objeto con la información de los datos del preregistro
     * @throws java.sql.SQLException En caso de que haya un problema con la consulta
     */
    @Results(id="RegistroMap", value = {
            @Result(property = "id",  column = "id"),
            @Result(property = "nick",      column = "nick"),
            @Result(property = "correo",    column = "correo"),
            @Result(property = "claveHash", column = "clave_hash"),
            @Result(property = "telefono",  column = "telefono"),
            @Result(property = "fechaNacimiento",  column = "fecha_nacimiento"),
            @Result(property = "randomString",     column = "random_string"),
            @Result(property = "instanteRegistro", column = "instante_registro")
          })
    @Select("SELECT " + CAMPOS_REG + " FROM preregistro WHERE correo = #{correo} ")
    Preregistro getByMail(String correo) throws SQLException;

    /**
     * Recupera el registro por medio del código random generado.
     *
     * @param randomString código random generado
     * @return Objeto con la información de los datos del preregistro
     * @throws java.sql.SQLException En caso de que haya un problema con la consulta
     */
    @ResultMap("RegistroMap")
    @Select("SELECT " + CAMPOS_REG + " FROM preregistro WHERE random_string = #{randomString} ")
    Preregistro getByRandomString(String randomString) throws SQLException;

    /**
     * Asocia un rol a determinado usuario.
     *
     * @param idUsuario id del usuario al que se le asociará el rol
     * @param idRol id del rol a asociar
     * @return Un entero que indica que la operación fue exitosa
     * @throws java.sql.SQLException En caso de que haya un problema con la consulta
     */
    @Insert("INSERT into usuario_rol(id_usuario, id_rol) values(#{idUsuario}, #{idRol})")
    Integer asociateRol(int idUsuario, int idRol) throws SQLException;

    /**
     * Inserta un objeto de tipo 'usuario_detalle' con base en la información dada por el objeto de tipo 'usuarioDetalle'.
     *
     * @param usuarioDetalle a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO usuario_detalle(id_usuario, nombre, telefono, calle_y_numero, fecha_nacimiento, id_estado, id_municipio) VALUES(#{idUsuario}, #{nombre}, #{telefono},#{calleNumero}, #{fechaNacimiento}, #{idEstado}, #{idMunicipio} )")
    Integer insertUsuarioDetalles(UsuarioDetalle usuarioDetalle) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'usuario_detalle' con base en la información dada por el objeto de tipo 'usuarioDetalle'.
     *
     * @param usuarioDetalle a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE usuario_detalle SET nombre=#{nombre}, telefono=#{telefono}, calle_y_numero=#{calleNumero}, fecha_nacimiento=#{fechaNacimiento}, id_estado=#{idEstado}, id_municipio=#{idMunicipio} WHERE id_usuario=#{idUsuario}")
    Integer updateUsuarioDetalles(UsuarioDetalle usuarioDetalle) throws SQLException;

    /**
     * Genera un usuario en la base de datos con los datos ya completos del preregistro.
     *
     * @param preregistro Datos de inscripción al sistema de un usuario
     * @return Entero que indica que la consulta tuvo éxito
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO preregistro(nick, clave_hash, correo, telefono, fecha_nacimiento, random_string, instante_registro) VALUES(#{nick}, #{claveHash}, #{correo}, #{telefono}, #{fechaNacimiento}, #{randomString}, #{instanteRegistro} ) ON DUPLICATE KEY UPDATE nick=#{nick}, telefono=#{telefono}, fecha_nacimiento=#{fechaNacimiento}, clave_hash=#{claveHash}, random_string=#{randomString}, instante_registro=#{instanteRegistro}")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    Integer insert(Preregistro preregistro) throws SQLException;

    /**
     * Modifica un preregistro ya existente.
     *
     * @param registro Datos del registro que se desea modificar
     * @return Entro que indica que se tuvo éxito en la modificación
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos
     */
    @Update("UPDATE preregistro SET nick = #{nick}, telefono = #{telefono}, fecha_nacimiento = #{fechaNacimiento}, clave_hash = #{claveHash}, random_string = #{randomString}, instante_registro = #{instanteRegistro} WHERE correo = #{correo} ")
    Integer update(Preregistro registro) throws SQLException;

    /**
     * Borra un preregistro existente por medio de su código.
     *
     * @param randomString Clave random asociada a un registro
     * @return Entro que indica que se tuvo éxito en la modificación
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos
     */
    @Select("DELETE FROM preregistro WHERE random_string = #{randomString} ")
    Integer deleteByRandomString(String randomString) throws SQLException;

}
