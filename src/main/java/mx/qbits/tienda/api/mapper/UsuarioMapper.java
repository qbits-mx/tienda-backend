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
 * Nombre:      UsuarioMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:11:32
 */
package mx.qbits.tienda.api.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import mx.qbits.tienda.api.model.domain.Usuario;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad 'Usuario'.
 *
 * @author  garellano
 * @see     io.kebblar.petstore.api.model.domain.Usuario
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@Repository
public interface UsuarioMapper {

    /** Constant <code>CAMPOS_USER=" id, correo, clave, creado, activo, acc"{trunked}</code> */
    String CAMPOS_USER = " id, correo, clave, creado, activo, acceso_negado_contador, instante_bloqueo, " +
            "instante_ultimo_acceso, instante_ultimo_cambio_clave, regenera_clave_token, regenera_clave_instante ";

    /**
     * Obtiene una lista de objetos de tipo 'usuario'.
     *
     * @return Lista de obetos de tipo usuario
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     * @param id a int.
     */
    @Results(id="UsuarioMap", value = {
        @Result(property = "id",     column = "id"),
        @Result(property = "correo", column = "correo"),
        @Result(property = "clave",  column = "clave"),
        @Result(property = "creado", column = "creado"),
        @Result(property = "activo", column = "activo"),
        @Result(property = "accesoNegadoContador",      column = "acceso_negado_contador"),
        @Result(property = "instanteBloqueo",           column = "instante_bloqueo"),
        @Result(property = "instanteUltimoAcceso",      column = "instante_ultimo_acceso"),
        @Result(property = "instanteUltimoCambioClave", column = "instante_ultimo_cambio_clave"),
        @Result(property = "regeneraClaveToken",        column = "regenera_clave_token"),
        @Result(property = "regeneraClaveInstante",     column = "regenera_clave_instante")
        })
    @Select("SELECT " + CAMPOS_USER + " FROM usuario WHERE id = #{id} ")
    Usuario getById(int id) throws SQLException;

    /**
     * <p>getAll.</p>
     *
     * @return a {@link java.util.List} object.
     * @throws java.sql.SQLException if any.
     */
    @ResultMap("UsuarioMap")
    @Select("SELECT " + CAMPOS_USER + " FROM usuario ")
    List<Usuario> getAll() throws SQLException;

    /**
     * <p>getAllAscendingByCorreo.</p>
     *
     * @return a {@link java.util.List} object.
     * @throws java.sql.SQLException if any.
     */
    @ResultMap("UsuarioMap")
    @Select("SELECT " + CAMPOS_USER + " FROM usuario order by correo asc")
    List<Usuario> getAllAscendingByCorreo() throws SQLException;

    /**
     * Obtiene un objeto de tipo 'usuario' realizando la búsqueda con base en el 'mail' del Usuario.
     *
     * @param correo mail del usuario.
     * @return el usuario encontrado con el criterio de búsqueda.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @ResultMap("UsuarioMap")
    @Select("SELECT " + CAMPOS_USER + " FROM usuario WHERE correo = #{correo} ")
    Usuario getByCorreo(String correo) throws SQLException;

    /**
     * Inserta un objeto de tipo 'usuario' con base en la información dada por el objeto de tipo 'usuario'.
     *
     * @param usr a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO usuario(correo, clave, creado, activo, acceso_negado_contador, instante_bloqueo, "
            + "instante_ultimo_acceso, instante_ultimo_cambio_clave, regenera_clave_token, regenera_clave_instante) "
            + "VALUES(#{correo}, #{clave}, #{creado}, #{activo}, #{accesoNegadoContador}, #{instanteBloqueo}, "
            + "#{instanteUltimoAcceso}, #{instanteUltimoCambioClave}, #{regeneraClaveToken}, #{regeneraClaveInstante} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Usuario usr) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'usuario' con base en la infrmación dada por el objeto de tipo 'usuario'.
     *
     * @param usr a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE usuario SET correo = #{correo}, clave = #{clave}, creado = #{creado}, activo = #{activo}, "
            + "acceso_negado_contador = #{accesoNegadoContador}, instante_bloqueo = #{instanteBloqueo}, "
            + "instante_ultimo_acceso = #{instanteUltimoAcceso}, instante_ultimo_cambio_clave = #{instanteUltimoCambioClave}, "
            + "regenera_clave_token = #{regeneraClaveToken}, regenera_clave_instante = #{regeneraClaveInstante} "
            + "WHERE id = #{id} ")
    int update(Usuario usr) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de usuario.
     *
     * @param id id del usuario a ser borrado
     * @return id del usuario borrado
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("Update usuario SET actvo=false where id=#{id}")
    int delete(int id) throws SQLException;

    /**
     * <p>confirmaRegeneraClave.</p>
     *
     * @param token a {@link java.lang.String} object.
     * @param clave a {@link java.lang.String} object.
     * @return a int.
     */
    @Update("Update usuario SET clave=#{clave} where regenera_clave_token=#{token}")
    int confirmaRegeneraClave(String token, String clave);

    /**
     * <p>getByToken.</p>
     *
     * @param token a {@link java.lang.String} object.
     * @return a {@link io.kebblar.petstore.api.model.domain.Usuario} object.
     */
    @ResultMap("UsuarioMap")
    @Select("SELECT " + CAMPOS_USER + " FROM usuario WHERE regenera_clave_token=#{token} ")
    Usuario getByToken(String token);

}
