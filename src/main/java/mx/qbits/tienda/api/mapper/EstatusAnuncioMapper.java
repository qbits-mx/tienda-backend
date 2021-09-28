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
 * Nombre:      EstatusAnuncioMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:08:07
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

import mx.qbits.tienda.api.model.domain.EstatusAnuncio;

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad EstatusAnuncio.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see mx.qbits.tienda.api.model.domain.EstatusAnuncio
 */
@Repository
public interface EstatusAnuncioMapper {

    /** Constant <code>CAMPOS_ESTATUS_ANUNCIO=" id, descripcion "</code> */
    String CAMPOS_ESTATUS_ANUNCIO = " id, descripcion ";

    /**
     * Obtiene un objeto de tipo 'EstatusAnuncio' dado su id.
     *
     * @return EstatusAnuncio que tiene asignado el id pasado como parámetro
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     * @param id a int.
     */
    @Results(id="EstatusAnuncioMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "descripcion",   column = "descripcion")
    })
    @Select("SELECT " + CAMPOS_ESTATUS_ANUNCIO + " FROM estatus_anuncio WHERE     id = #{id}     ")
    EstatusAnuncio getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'EstatusAnuncio'.
     *
     * @return Lista de objetos de tipo EstatusAnuncio
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("EstatusAnuncioMap")
    @Select("SELECT " + CAMPOS_ESTATUS_ANUNCIO + " FROM estatus_anuncio ")
    List<EstatusAnuncio> getAll() throws SQLException;

    /**
     * Inserta un objeto de tipo 'EstatusAnuncio' con base en la información dada por el objeto de tipo 'EstatusAnuncio'.
     *
     * @param estatusAnuncio a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert(
    "INSERT INTO estatus_anuncio(id, descripcion) "
   + "VALUES(#{id}, #{descripcion} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(EstatusAnuncio estatusAnuncio) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'EstatusAnuncio' con base en la información dada por el objeto de tipo 'EstatusAnuncio'.
     *
     * @param estatusAnuncio a ser actualizado.
     * @return el número de registros actualizados.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update(
    "UPDATE estatus_anuncio"
    + " SET descripcion = #{descripcion}"
    + " WHERE id = #{id} ")
    int update(EstatusAnuncio estatusAnuncio) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de EstatusAnuncio.
     *
     * @param id id del EstatusAnuncio a ser borrado
     * @return id del EstatusAnuncio borrado
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM estatus_anuncio WHERE id = #{id} ")
    int delete(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'EstatusAnuncio' filtrado por el nombre ingresado.
     *
     * @param  nombre de EstatusAnuncio.
     * @return Lista de objetos de tipo EstatusAnuncio filtrado por el nombre ingresado
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("EstatusAnuncioMap")
    @Select("SELECT " + CAMPOS_ESTATUS_ANUNCIO + " FROM estatus_anuncio WHERE descripcion LIKE '%' #{nombre} '%'")
    List<EstatusAnuncio> getByNombre(String nombre) throws SQLException;

}
