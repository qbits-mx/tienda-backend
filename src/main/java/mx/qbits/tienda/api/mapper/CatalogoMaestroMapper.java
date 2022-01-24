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
import java.util.List;

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
 * Interfaz 'Mapper' MyBatis asociado a la entidad CatalogoMaestro.
 * @author Juan Carlos Bautista Sandoval
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see mx.qbits.tienda.api.model.domain.CatalogoMaestro
 */
public interface CatalogoMaestroMapper {
    /** Constant <code>CAMPOS_CATALOGO_MAESTRO" id, tipo_catalogo "{trunked}</code> */
    final String CAMPOS_CATALOGO_MAESTRO = "id, tipo_catalogo";

    /**
     * Obtiene un objeto de tipo 'CatalogoMaestro' dado su id.
     * @param id  a int , el cual nos indica el id del CatalogoMaestro que deceamos recuperar.
     * @return CatalogoMaestro en caso de encontrar el catalogo maestro asociado al id 
     * pasado como parametro, null en caso de no encontrar un CatalogoMaestro asociado al
     * id pasado como parametro. 
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @Results(id = "CatalogoMaestroMapping", value = {
        @Result(property = "id",           column = "id"),
        @Result(property = "tipoCatalogo", column = "tipo_catalogo")
    })@Select("SELECT " + CAMPOS_CATALOGO_MAESTRO + " FROM catalogo_maestro WHERE id = #{id}")
    CatalogoMaestro getById(int id) throws SQLException;

    /**
     * Obtiene un objeto de tipo 'CatalogoMaestro' dado su tipoCatalogo.
     * @param tipoCatalogo a String, el cual nos indica el tipoCatalogo que deceamos recuperar.
     * @return CatalogoMaestro en caso de encontrar el catalogo maestro asociado al tipoCatalogo 
     * pasado como parametro, null en caso de no encontrar un CatalogoMaestro asociado al
     * tipoCatalogo pasado como parametro. 
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("CatalogoMaestroMapping")
    @Select("SELECT " + CAMPOS_CATALOGO_MAESTRO + " FROM catalogo_maestro WHERE tipo_catalogo = #{tipoCatalogo}")
    CatalogoMaestro getByTipoCatalogo(String tipoCatalogo) throws SQLException;
    
    /**
     * Obtiene todos los catalogosMaestros en la base de datos.
     * @return List<CatalogoMaestro> , lista con todos los catalogos maestros en la base de datos.
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("CatalogoMaestroMapping")
    @Select("SELECT "+ CAMPOS_CATALOGO_MAESTRO + " FROM catalogo_maestro")
    List<CatalogoMaestro> getAll() throws SQLException;

    /**
     * Obtiene el número total de catalogos maestros.
     * @return a Integer con el numero total de catalogos maestros.
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("CatalogoMaestroMapping")
    @Select("SELECT COUNT(*) FROM catalogo_maestro")
    Integer totalCatalogosMaestro() throws SQLException;

    /**
     * Inserta un objeto de tipo 'CatalogoMaestro' con base en la información dada por el objeto 'tipoCatalogo'.
     * @param tipoCatalogo a String, el cual tiene el tipoCatalogo que se necesita para insertar un nuevo 'CatalogoMaestro'.
     * @return el id auto incremental asociado a esa inserción.
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO catalogo_maestro(tipo_catalogo) VALUES(#{tipoCatalogo})")
    int insert(String tipoCatalogo) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'catalogo_maestro' con base en la información dada por el objeto de tipo 'catalogoMaestro'.
     * @param catalogoMaestro a ser actualizado.
     * @return el número de registros actualizados.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE catalogo_maestro set tipo_catalogo=#{tipoCatalogo} WHERE id=#{id}")
    int update(CatalogoMaestro catalogoMaestro) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de CatalogoMaestro dado su id.
     * @param id a int, que representa el id del CatalogoMaestro a ser eliminado.
     * @return id del CatalogoMaestro a ser eliminado.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM catalogo_maestro WHERE id=#{id}")
    int deleteById(int id) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de CatalogoMaestro dado su tipoCatalogo.
     * @param tipoCatalogo a String, que representa el tipoCatalogo a ser eliminado.
     * @return id del CatalogoMaestro a ser eliminado.
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM catalogo_maestro WHERE tipo_catalogo=#{tipoCatalogo}")
    int deleteByTipoCatalogo(String tipoCatalogo) throws SQLException;
}
