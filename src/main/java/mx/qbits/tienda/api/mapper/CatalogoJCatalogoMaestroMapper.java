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
 * Nombre:      CatalogoJCatalogoMaestroMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 12 Dic 2021 @ 07:50:49
 */
package mx.qbits.tienda.api.mapper;

import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

import mx.qbits.tienda.api.model.domain.CatalogoJCatalogoMaestro;

/**
 * Interfaz 'Mapper' MyBatis asociado a la entidad CatalogoJCatalogoMaestro.
 * @author Ricardo Ruben González García
 * @version 1.0-SNAPSHOT
 * @since 1.O-SNAPSHOT
 * @see mx.qbits.tienda.api.model.domain.CatalogoJCatalogoMaestro
 */
public interface CatalogoJCatalogoMaestroMapper {
    /** Constant <code>CAMPOS "catalogo.id, id_catalogo_categoria, tipo_catalogo, nombre, activo" </code> */
    final String CAMPOS = "catalogo.id, id_catalogo_categoria, tipo_catalogo, nombre, activo";

    /**
     * Obtiene el join de todos los catalgos con sus catalogos maestros, si dicho catalogo esta activo
     * ademas el resultado esta ordenado por el nombre de manera ascendente.
     * @return List<CatalogoJCatalogoMaestro> una lista de catalogos con su respectivo join a catalogo maestro.
     * @throws SQLException Se dispaara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @Results(id="CatalogoJCatalogoMaestroMapping", value = {
        @Result(property = "id", column = "catalogo.id"),
        @Result(property = "idMaestro", column = "id_catalogo_categoria"),
        @Result(property = "tipoCatalogo", column = "catalogo_maestro.tipo_catalogo"),
        @Result(property = "nombre" ,column = "nombre"),
        @Result(property = "activo", column = "activo")
    })@Select("SELECT " + CAMPOS + " FROM catalogo inner join catalogo_maestro on catalogo.id_catalogo_categoria = catalogo_maestro.id WHERE activo = 1 ORDER BY nombre ASC")
    List<CatalogoJCatalogoMaestro> getAll() throws SQLException;
    
}
