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
 * Nombre:      CatalogoMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 28 Nov 2021 @ 07:50:49
 */
package mx.qbits.tienda.api.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import mx.qbits.tienda.api.model.domain.Catalogo;

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad Catalogo.
 * @author Juan Carlos Bautista Sandoval
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see mx.qbits.tienda.api.model.domain.Catalogo
 */
public interface CatalogoMapper {
    /** Constant <code>CAMPOS_CATALOGO" id, id_catalogo_categoria, activo, nombre "{trunked}</code> */
    final String CAMPOS_CATALOGO = "id, id_catalogo_categoria, activo, nombre";

    /**
     * Obtiene un objeto de tipo 'Catalogo' dado su id.
     * @param id a int , el cual nos indica el id del Catalogo que deceamos recuperar.
     * @return Catalogo en caso de encontrar el catalogo maestro asociado al id 
     * pasado como parametro, null en caso de no encontrar un Catalogo asociado al
     * id pasado como parametro. 
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Results(id="CatalogoMapping", value = {
        @Result(property = "id", column = "id"),
        @Result(property = "idCatalogoCategoria", column = "id_catalogo_categoria"),
        @Result(property = "activo", column = "activo"),
        @Result(property = "nombre", column = "nombre")
    })@Select("SELECT " + CAMPOS_CATALOGO + " FROM catalogo WHERE id = #{id}")
    Catalogo getById(int id) throws SQLException;

    /**
     * Obitiene un objeto de tipo 'Catalogo' dado su id y su idCatalogoCategoria.
     * @param id a int, el cual nos indica el id del Catalogo que decesmos recuperar.
     * @param idCatalogoCategoria a int, el cual nos indica el idCatalogoCategoria del catalogo que deceamos,
     * eliminar.
     * @return Catalogo, en caso de encontrar el catalogo asociado al id e idCatalogoCategoria
     * , null en caso de no enconstrar dicho catalogo.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @ResultMap("CatalogoMapping")
    @Select("SELECT " + CAMPOS_CATALOGO + " FROM catalogo WHERE id = #{id} AND id_catalogo_categoria=#{idCatalogoCategoria}")
    Catalogo getByIdAndIdCategoria(int id, int idCatalogoCategoria) throws SQLException;

    /**
     * Obtiene un objeto de tipo 'Catalogo' dado su nombre.
     * @param nombre a String , el cual nos indica el nombre del Catalogo que deceamos recuperar.
     * @return Catalogo en caso de encontrar el catalogo maestro asociado al nombre 
     * pasado como parametro, null en caso de no encontrar un Catalogo asociado al
     * nombre pasado como parametro.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @ResultMap("CatalogoMapping")
    @Select("SELECT " + CAMPOS_CATALOGO + " FROM catalogo WHERE nombre = #{nombre}")
    Catalogo getByNombre(String nombre) throws SQLException;

    /**
     * Obtiene un objeto de tipo 'Catalogo' dado su nombre y idCatalogoCategoria.
     * @param nombre a String, el cual nos indica el nombre del Catalogo que deceamos recuperar.
     * @param idCatalogoCategoria a ins, el cual nos indica el idCatalogoCategoria del catalogo que deceamos recuperar.
     * @return Catalogo en caso de encontrar el catalogo con el nomre e idCatalogoCategoria asociado al nombre pasado como
     * parametro, null en caso de no encontrar un Catalogo asociado a los parametros de entrada.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @ResultMap("CatalogoMapping")
    @Select("SELECT " + CAMPOS_CATALOGO + " FROM catalogo WHERE nombre = #{nombre} AND id_catalogo_categoria=#{idCatalogoCategoria}")
    Catalogo getByNombreAndIdCategoria(String nombre, int idCatalogoCategoria) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'Catalogo' relacionados con el idCatalogoCategoria.
     * @param idCatalogoCategoria a int, el cual nos indica el id del catalogo categoria, sobre el cual
     * queremos recuperar, los catalogos.
     * @return List<Catalogo> en el caso de encontrar catalogos asociados a el idCatalogoCategoria.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @ResultMap("CatalogoMapping")
    @Select("SELECT " + CAMPOS_CATALOGO + " FROM catalogo WHERE id_catalogo_categoria = #{idCatalogoCategoria}")
    List<Catalogo> getByIdCatalogoCategoria(int idCatalogoCategoria) throws SQLException;

    /**
     * Obtiene todos los catalogos en la base de datos.
     * @return List<Catalogo>, lista con todos los catalogos maestro de la base de datos.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @ResultMap("CatalogoMapping")
    @Select("SELECT " + CAMPOS_CATALOGO + " FROM catalogo ORDER BY nombre ASC")
    List<Catalogo> getAll() throws SQLException;

    /**
     * Inserta un objeto de tipo 'Catalogo' con base en la información dada por el objeto 'tipoCatalogo'.
     * @param idCatalogoCategoria a int, el cual indica la categoria a la cual pertenece dicho catalogo.
     * @param activo a boolean, indica si el catalogo esta activo en el sistema.
     * @param nombre a String, el cual indica el nombre del catalogo.
     * @return el id auto incremental asociado a esa inserción.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO catalogo(id_catalogo_categoria, activo, nombre) VALUES(#{idCatalogoCategoria}, #{activo}, #{nombre})")
    int insert(int idCatalogoCategoria, boolean activo, String nombre) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'catalogo' con base en la información dada por el id del objeto de tipo 'Catalogo'.
     * @param catalogo a ser actualizado.
     * @return el número de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE catalogo set id_catalogo_categoria=#{idCatalogoCategoria}, activo=#{activo}, nombre=#{nombre} WHERE id=#{id}")
    int update(Catalogo catalogo) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'Catalogo' con base en el id e idCatalogoCategoria del objeto tipo 'Catalogo'.
     * @param catalogo a ser acutalizado.
     * @return el número de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE catalogo set activo=#{activo}, nombre=#{nombre} WHERE id=#{id} AND id_catalogo_categoria = #{idCatalogoCategoria}")
    int updateWithIdAndIdCatalogoCategoria(Catalogo catalogo) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de Catalogo dado su nombre.
     * @param nombre a String, que representa el nombre del Catalogo a ser eliminado.
     * @return id del Catalogo a ser eliminado.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM catalogo WHERE nombre=#{nombre}")
    int deleteByNombre(String nombre) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de Catalogo dado su nombre e idCatalogoCategoria.
     * @param nombre a String, que representa el nombre del Catalogo a ser eliminado.
     * @param idCatalogoCategoria a int, que representa el idCatalogoCategoria del catalogo a ser elimiando.
     * @return id del Catalogo a ser eliminado.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM catalogo WHERE nombre=#{nombre} AND id_catalogo_categoria=#{idCatalogoCategoria}")
    int deleteByNombreAndIdCatalogoCategoria(String nombre, int idCatalogoCategoria) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de Catalogo dado su id.
     * @param id a int, el id del catalogo a ser elimindado.
     * @return id del Catalogo a ser eliminado.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM catalogo WHERE id=#{id}")
    int deleteById(int id) throws SQLException;

    /**
     * Borra (de manera lógica y no fisisca) el registro de Catalogo dado su id.
     * @param id a int, el id del catalogo a ser eliminado.
     * @param idCatalogoCategoria a int, que representa el idCatalogoCategoria del catalogo a ser elimindado.
     * @return id del Catalogo a ser elimindado.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM catalogo WHERE id=#{id} AND id_catalogo_categoria=#{idCatalogoCategoria}")
    int deleteByIdAndIdCatalogoCategoria(int id, int idCatalogoCategoria) throws SQLException;

}
