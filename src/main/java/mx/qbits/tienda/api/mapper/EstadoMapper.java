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
 * Nombre:      EstadoMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:07:48
 */
package mx.qbits.tienda.api.mapper;

import java.util.List;
import java.sql.SQLException;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;

import mx.qbits.tienda.api.model.domain.Estado;

/**
 * Interfaz 'Mapper' MyBatis asociado a la entidad Estado.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see Estado
 */
@Repository
public interface EstadoMapper {

    /** Constant <code>CAMPOS_EDO=" id, id_pais, nombre "</code> */
    String CAMPOS_EDO = " id, id_pais, nombre ";

    /**
     * Obtiene un objeto de tipo 'Estado' dado su id.
     *
     * @return Estado que tiene asignado el id pasado como parámetro
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     * @param id a int.
     */
    @Results(id="EstadoMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "idPais",   column = "id_pais"),
            @Result(property = "nombre",   column = "nombre")
    })
    @Select("SELECT " + CAMPOS_EDO + " FROM estado WHERE     id = #{id}     ")
    Estado getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'Estado'.
     *
     * @return Lista de objetos de tipo Estado
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("EstadoMap")
    @Select("SELECT " + CAMPOS_EDO + " FROM estado ")
    List<Estado> getAll() throws SQLException;

    /**
     * Inserta un objeto de tipo 'Estado' con base en la información dada por el objeto de tipo 'Estado'.
     *
     * @param estado a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO estado(id, id_pais, nombre) VALUES(#{id}, #{idPais}, #{nombre} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Estado estado) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'Estado' con base en la información dada por el objeto de tipo 'Estado'.
     *
     * @param estado a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE estado SET id_pais = #{idPais}, nombre = #{nombre} WHERE id = #{id} ")
    int update(Estado estado) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de Estado.
     *
     * @param id id del Estado a ser borrado
     * @return id del Estado borrado
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM estado WHERE id = #{id} ")
    int delete(int id) throws SQLException;

    /**
     * Dado el id de un pais, se retornan todos los estados que pertenecen a este.
     *
     * @param id id del país que contiene a los estados retornados.
     * @return Lista de estados pertenecientes al país recibido.
     * @throws java.sql.SQLException Si ocurre un error en la consulta o en el sistema.
     */
    @Select("SELECT " + CAMPOS_EDO + " FROM estado WHERE id_pais=#{id}" )
    List<Estado> getByPais(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'estado' haciedo INNER JOIN con la tabla Pais para la obtencion del nombre del Pais.
     *
     * @return Lista de objetos de tipo estado
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @Results(id="EstadoNombreMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "idPais", column = "id_pais"),
            @Result(property = "nombrePais", column = "nombre_pais"),
            @Result(property = "nombre", column = "nombre")
        })
    @Select("SELECT e.id, e.id_pais, e.nombre, p.nombre as nombre_pais FROM estado e INNER JOIN pais p on  p.id=e.id_pais ")
    List<Estado> getAllNombrePais() throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'estado' filtrado por el nombre ingresado.
     *
     * @param  nombre del estado.
     * @return Lista de objetos de tipo estado filtrado por el nombre ingresado
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("EstadoNombreMap")
    @Select("SELECT e.id, e.id_pais, e.nombre, p.nombre as nombre_pais FROM estado e INNER JOIN pais p on  p.id=e.id_pais WHERE e.nombre LIKE '%' #{nombre} '%'")
    List<Estado> getByNombre(String nombre) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'estado' filtrado por el id ingresado.
     *
     * @param  idPais del pais.
     * @return Lista de objetos de tipo estado filtrado por el id ingresado
     */
    @ResultMap("EstadoNombreMap")
    @Select("SELECT e.id, e.id_pais, e.nombre, p.nombre as nombre_pais FROM estado e INNER JOIN pais p on  p.id=e.id_pais WHERE e.id_pais = #{idPais}")
    List<Estado> getEstadosByPais(int idPais);

    /**
     * Obtiene una lista de objetos de tipo 'estado' filtrado por el nombre ingresado.
     *
     * @param  nombre del estado.
     * @param  idPais del estado.
     * @return Lista de objetos de tipo estado filtrado por el nombre ingresado
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("EstadoNombreMap")
    @Select("SELECT e.id, e.id_pais, e.nombre, p.nombre as nombre_pais FROM estado e INNER JOIN pais p on  p.id=e.id_pais WHERE e.id_pais = #{idPais} and e.nombre LIKE '%' #{nombre} '%'")
    List<Estado> getByNombreAndIdPais(String nombre, int idPais) throws SQLException;

}
