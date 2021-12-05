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
     * Obtiene un objeto de tipo 'Catalogo' dado su nombre.
     * @param nombre a String , el cual nos indica el nombre del Catalogo que deceamos recuperar.
     * @return Catalogo en caso de encontrar el catalogo maestro asociado al nombre 
     * pasado como parametro, null en caso de no encontrar un Catalogo asociado al
     * nombre pasado como parametro.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @ResultMap("CatalogoMapping")
    @Select("SELECT " + CAMPOS_CATALOGO + " FROM catalogo WHERE id = #{nombre}")
    Catalogo getByNombre(String nombre) throws SQLException;

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
     * Actualiza un objeto de tipo 'catalogo' con base en la información dada por el objeto de tipo 'Catalogo'.
     * @param catalogo a ser actualizado.
     * @return el número de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE catalogo set id_catalogo_categoria=#{idCatalogoCategoria}, activo=#{activo}, nombre=#{nombre} WHERE id=#{id}")
    int update(Catalogo catalogo) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de Catalogo dado su nombre.
     * @param nombre a String, que representa el nombre del Catalogo a ser eliminado.
     * @return id del CatalogoMaestro a ser eliminado.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM catalogo WHERE nombre=#{nombre}")
    int deleteByNombre(String nombre) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de Catalogo dado su id.
     * @param id a int, el id del catalogo a ser elimindado.
     * @return id del CatalogoMaestro a ser eliminado.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM catalogo WHERE id=#{id}")
    int deleteById(int id) throws SQLException;
}
