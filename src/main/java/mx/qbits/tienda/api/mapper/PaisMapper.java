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
 * Nombre:      PaisMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:10:14
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

import mx.qbits.tienda.api.model.domain.Pais;

/**
 * Interfaz 'Mapper' MyBatis asociado a la entidad Pais.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see Pais
 */
@Repository
public interface PaisMapper {

    /** Constant <code>CAMPOS_PAIS=" id, nombre "</code> */
    String CAMPOS_PAIS = " id, nombre ";

    /**
     * Obtiene un objeto de tipo 'Pais' dado su id.
     *
     * @return Pais que tiene asignado el id pasado como parámetro
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     * @param id a int.
     */
    @Results(id="PaisMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "nombre",   column = "nombre")
    })
    @Select("SELECT " + CAMPOS_PAIS + " FROM pais WHERE id = #{id} ")
    Pais getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'Pais'.
     *
     * @return Lista de obetos de tipo Pais
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("PaisMap")
    @Select("SELECT " + CAMPOS_PAIS + " FROM pais ")
    List<Pais> getAll() throws SQLException;

    /**
     * Inserta un objeto de tipo 'Pais' con base en la información dada por el objeto de tipo 'Pais'.
     *
     * @param pais a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO pais(id, nombre) VALUES(#{id}, #{nombre} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Pais pais) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'Pais' con base en la información dada por el objeto de tipo 'Pais'.
     *
     * @param pais a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE pais SET nombre = #{nombre} WHERE id = #{id} ")
    int update(Pais pais) throws SQLException;

    /**
     * Borra (física) el registro de Pais.
     *
     * @param id id del Pais a ser borrado
     * @return id del Pais borrado
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM pais WHERE id = #{id} ")
    int delete(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'pais' filtrado por el nombre ingresado.
     *
     * @param  nombre del pais.
     * @return Lista de objetos de tipo pais filtrado por el nombre ingresado
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("PaisMap")
    @Select("SELECT " + CAMPOS_PAIS + " FROM pais WHERE nombre LIKE '%' #{nombre} '%'")
    List<Pais> getByNombre(String nombre) throws SQLException;

}
