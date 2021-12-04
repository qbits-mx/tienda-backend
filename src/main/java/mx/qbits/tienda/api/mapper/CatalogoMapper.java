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
 *
 * @author Juan Carlos Bautista Sandoval
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see mx.qbits.tienda.api.model.domain.Catalogo
 */
public interface CatalogoMapper {
    /** Constant <code>CAMPOS_CATALOGO" id, id_catalogo_categoria, activo, nombre "{trunked}</code> */
    final String CAMPOS_CATALOGO = "id, id_catalogo_categoria, activo, nombre";

    /**
     * 
     * @param id
     * @return
     * @throws SQLException
     */
    @Results(id="CatalogoMapping", value = {
        @Result(property = "id", column = "id"),
        @Result(property = "idCatalogoCategoria", column = "id_catalogo_categoria"),
        @Result(property = "activo", column = "activo"),
        @Result(property = "nombre", column = "nombre")
    })@Select("SELECT " + CAMPOS_CATALOGO + " FROM catalogo WHERE id = #{id}")
    Catalogo getById(int id) throws SQLException;

    /**
     * 
     * @param nombre
     * @return
     * @throws SQLException
     */
    @ResultMap("CatalogoMapping")
    @Select("SELECT " + CAMPOS_CATALOGO + " FROM catalogo WHERE id = #{nombre}")
    Catalogo getByNombre(String nombre) throws SQLException;

    /**
     * 
     * @param idCatalogoCategoria
     * @param activo
     * @param nombre
     * @return
     */
    @Insert("INSERT INTO catalogo(id_catalogo_categoria, activo, nombre) VALUES(#{idCatalogoCategoria}, #{activo}, #{nombre})")
    int insert(int idCatalogoCategoria, boolean activo, String nombre) throws SQLException;

    /**
     * 
     * @param catalogo
     * @return
     * @throws SQLException
     */
    @Update("UPDATE catalogo set id_catalogo_categoria=#{idCatalogoCategoria}, activo=#{activo}, nombre=#{nombre} WHERE id=#{id}")
    int update(Catalogo catalogo) throws SQLException;

    /**
     * 
     * @param nombre
     * @return
     * @throws SQLException
     */
    @Delete("DELETE FROM catalogo WHERE nombre=#{nombre}")
    int deleteByNombre(String nombre) throws SQLException;

    /**
     * 
     * @param id
     * @return
     * @throws SQLException
     */
    @Delete("DELETE FROM catalogo WHERE id=#{id}")
    int deleteById(int id) throws SQLException;
}
