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
 * Nombre:      CatalogoMaestroMapper
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

import mx.qbits.tienda.api.model.domain.CatalogoMaestro;

/**
 * <p>Descripción:</p>
 *
 * @author Juan Carlos Bautista Sandoval
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see mx.qbits.tienda.api.model.domain.CatalogoMaestro
 */
public interface CatalogoMaestroMapper {
    /** Constant <code>CAMPOS_CATALOGO_MAESTRO" id, tipo_catalogo "{trunked}</code> */
    final String CAMPOS_CATALOGO_MAESTRO = "id, tipo_catalogo";

    /**
     * 
     * @param id
     * @return
     * @throws SQLException
     */
    @Results(id = "CatalogoMaestroMapping", value = {
        @Result(property = "id",           column = "id"),
        @Result(property = "tipoCatalogo", column = "tipo_catalogo")
    })@Select("SELECT " + CAMPOS_CATALOGO_MAESTRO + " FROM catalogo_maestro WHERE id = #{id}")
    CatalogoMaestro getById(int id) throws SQLException;

    /**
     * 
     * @param tipoCatalogo
     * @return
     * @throws SQLException
     */
    @ResultMap("CatalogoMaestroMapping")
    @Select("SELECT " + CAMPOS_CATALOGO_MAESTRO + " FROM catalogo_maestro WHERE tipo_catalogo = #{tipoCatalogo}")
    CatalogoMaestro getByTipoCatalogo(String tipoCatalogo) throws SQLException;

    /**
     * 
     * @param tipoCatalogo
     * @return
     * @throws SQLException
     */
    @Insert("INSERT INTO catalogo_maestro(tipo_catalogo) VALUES(#{tipoCatalogo})")
    int insert(String tipoCatalogo) throws SQLException;

    /**
     * 
     * @param catalogoMaestro
     * @return
     * @throws SQLException
     */
    @Update("UPDATE catalogo_maestro set tipo_catalogo=#{tipoCatalogo} WHERE id=#{id}")
    int update(CatalogoMaestro catalogoMaestro) throws SQLException;

    /**
     * 
     * @param id
     * @return
     * @throws SQLException
     */
    @Delete("DELETE FROM catalogo_maestro WHERE id=#{id}")
    int deleteById(int id) throws SQLException;

    /**
     * 
     * @param tipoCatalogo
     * @return
     * @throws SQLException
     */
    @Delete("DELETE FROM catalogo_maestro WHERE tipo_catalogo=#{tipoCatalogo}")
    int deleteByTipoCatalogo(String tipoCatalogo) throws SQLException;
}
