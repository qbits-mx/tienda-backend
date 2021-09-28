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
 * Nombre:      PaqueteriaMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:10:28
 */
package mx.qbits.tienda.api.mapper;

import java.util.List;
import java.sql.SQLException;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import mx.qbits.tienda.api.model.domain.Paqueteria;

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad Paqueteria.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see Paqueteria
 */

@Repository
public interface PaqueteriaMapper {

    /** Constant <code>CAMPOS_PAQ=" id, nombre, breve_descripcion, html_de"{trunked}</code> */
    String CAMPOS_PAQ = " id, nombre, breve_descripcion, html_descripcion, precio ";

    /**
     * Obtiene un objeto de tipo 'Paqueteria' dado su id.
     *
     * @return Paqueteria que tiene asignado el id pasado como parámetro
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     * @param id a int.
     */
    @Results(id="PaqueteriaMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "nombre",   column = "nombre"),
            @Result(property = "breveDescripcion",   column = "breve_descripcion"),
            @Result(property = "htmlDescripcion",   column = "html_descripcion"),
            @Result(property = "precio",   column = "precio")
    })
    @Select("SELECT " + CAMPOS_PAQ + " FROM paqueteria WHERE     id = #{id}     ")
    Paqueteria getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'Paqueteria'.
     *
     * @return Lista de obetos de tipo Paqueteria
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("PaqueteriaMap")
    @Select("SELECT " + CAMPOS_PAQ + " FROM paqueteria ")
    List<Paqueteria> getAll() throws SQLException;

    /**
     * Inserta un objeto de tipo 'Paqueteria' con base en la información dada por el objeto de tipo 'Paqueteria'.
     *
     * @param paqueteria a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert(
    "INSERT INTO paqueteria(id, nombre, breve_descripcion, html_descripcion, precio) "
   + "VALUES(#{id}, #{nombre}, #{breveDescripcion}, #{htmlDescripcion}, #{precio} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Paqueteria paqueteria) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'Paqueteria' con base en la infrmación dada por el objeto de tipo 'Paqueteria'.
     *
     * @param paqueteria a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update(
    "UPDATE paqueteria"
    + " SET nombre = #{nombre}, breve_descripcion = #{breveDescripcion}, html_descripcion = #{htmlDescripcion}, precio = #{precio}"
    + " WHERE id = #{id} ")
    int update(Paqueteria paqueteria) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de Paqueteria.
     *
     * @param id id del Paqueteria a ser borrado
     * @return id del Paqueteria borrado
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM paqueteria WHERE id = #{id} ")
    int delete(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'paqueteria' filtrado por el nombre ingresado.
     *
     * @param nombre la paqueteria.
     * @return Lista de objetos de tipo paqueteria filtrado por el nombre ingresado
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("PaqueteriaMap")
    @Select("SELECT " + CAMPOS_PAQ + " FROM paqueteria WHERE nombre LIKE '%' #{nombre} '%'")
    List<Paqueteria> getByNombre(String nombre) throws SQLException;

}
