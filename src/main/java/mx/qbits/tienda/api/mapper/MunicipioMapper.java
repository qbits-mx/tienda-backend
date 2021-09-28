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
 * Nombre:      MunicipioMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:09:55
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

import mx.qbits.tienda.api.model.domain.Municipio;

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad Municipio.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see Municipio
 */
@Repository
public interface MunicipioMapper {

    /** Constant <code>CAMPOS_MUN=" id, id_estado, nombre "</code> */
    String CAMPOS_MUN = " id, id_estado, nombre ";
    /** Constant <code>CAMPOS_AUX_MUN=" m.id, m.id_estado, m.nombre, e.nombre "{trunked}</code> */
    String CAMPOS_AUX_MUN = " m.id, m.id_estado, m.nombre, e.nombre as nombre_estado , p.nombre as nombre_pais";

    /**
     * Obtiene un objeto de tipo 'Municipio' dado su id.
     *
     * @return Municipio que tiene asignado el id pasado como parámetro
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     * @param id a int.
     */
    @Results(id="MunicipioMap", value = {
            @Result(property = "id",   column = "id"),
            @Result(property = "idEstado",   column = "id_estado"),
            @Result(property = "nombre",   column = "nombre")
    })
    @Select("SELECT " + CAMPOS_MUN + " FROM municipio WHERE     id = #{id}     ")
    Municipio getById(int id) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'Municipio'.
     *
     * @return Lista de objetos de tipo Municipio
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("MunicipioMap")
    @Select("SELECT " + CAMPOS_MUN + " FROM municipio ")
    List<Municipio> getAll() throws SQLException;

    /**
     * Inserta un objeto de tipo 'Municipio' con base en la información dada por el objeto de tipo 'Municipio'.
     *
     * @param municipio a ser insertado.
     * @return el auto incremental asociado a esa inserción.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO municipio(id, id_estado, nombre) VALUES(#{id}, #{idEstado}, #{nombre} )")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int insert(Municipio municipio) throws SQLException;

    /**
     * Actualiza un objeto de tipo 'Municipio' con base en la información dada por el objeto de tipo 'Municipio'.
     *
     * @param municipio a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE municipio SET id_estado = #{idEstado}, nombre = #{nombre} WHERE id = #{id} ")
    int update(Municipio municipio) throws SQLException;

    /**
     * Borra (de manera lógica y no física) el registro de Municipio.
     *
     * @param id id del Municipio a ser borrado
     * @return id del Municipio borrado
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Delete("DELETE FROM municipio WHERE id = #{id} ")
    int delete(int id) throws SQLException;

    /**
     * Dado determinado estado, el método retorna los municipios pertenecientes a este.
     *
     * @param id id del estado que contiene a los municipios.
     * @return Lista con los municipios de determinado estado.
     * @throws java.sql.SQLException en caso de un error en el servidor o en la consulta.
     */
    @Select("SELECT " + CAMPOS_MUN + " FROM municipio WHERE id_estado=#{id}" )
    List<Municipio> getByEstado(int id) throws SQLException;

    /**
     * Obtiene una lista de objectos de tipo 'municipio' realizando la búsqueda con base en el 'idEstado','starRow','pageSize'.
     *
     * @param idEstado identificador del estado
     * @param startRow Inicio de la fila
     * @param pageSize Número de registros por pagina
     * @return una lista de municipios encontrados con los criterios de búsqueda.
     */
    @ResultMap("MunicipioMap")
    @Select("SELECT " + CAMPOS_MUN + " FROM municipio WHERE id_estado=#{idEstado} LIMIT #{startRow},#{pageSize}")
    List<Municipio> getPaginatedMunicipios(int idEstado, int startRow, int pageSize);

    /**
     * Obtiene una lista de objetos de tipo 'Municipio' que trae el nombre del pais
     * y el nombre del estado filtrando el nombre del municipio.
     *
     * @return Lista de objetos de tipo Municipio
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     * @param nombre a {@link java.lang.String} object.
     */
    @Results(id="PaisEstadoMunicipioMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "idEstado", column = "id_estado"),
            @Result(property = "nombreEstado", column = "nombre_estado"),
            @Result(property = "nombrePais", column = "nombre_pais"),
            @Result(property = "nombre", column = "nombre")
        })
    @Select("SELECT " + CAMPOS_AUX_MUN + " FROM municipio m "
            + "INNER JOIN estado e on m.id_estado = e.id "
            + "INNER JOIN pais p on e.id_pais = p.id "
            + "WHERE m.nombre LIKE '%' #{nombre} '%'")
    List<Municipio> getByNombre(String nombre) throws SQLException;

    /**
     * Obtiene una lista de objetos de tipo 'Municipio' que trae el nombre del pais
     * y el nombre del estado.
     *
     * @return Lista de objetos de tipo Municipio
     */
    @ResultMap("PaisEstadoMunicipioMap")
    @Select("SELECT " + CAMPOS_AUX_MUN + " FROM municipio m "
            + "INNER JOIN estado e on m.id_estado = e.id "
            + "INNER JOIN pais p on e.id_pais = p.id  ")
    List<Municipio> getMunicipiosDescripcion();

    /**
     * Obtiene una lista de objetos de tipo 'Municipio' que trae el nombre del pais
     * y el nombre del estado.
     *
     * @param  idPais identificador del pais
     * @return Lista de objetos de tipo Municipio
     */
    @ResultMap("PaisEstadoMunicipioMap")
    @Select("SELECT " + CAMPOS_AUX_MUN + " FROM municipio m "
            + "INNER JOIN estado e on m.id_estado = e.id "
            + "INNER JOIN pais p on e.id_pais = p.id WHERE e.id_pais = #{idPais}  ")
    List<Municipio> getMunicipiosByPaisDescripcion(int idPais);

    /**
     * Obtiene una lista de objetos de tipo 'Municipio' que trae el nombre del pais
     * y el nombre del estado.
     *
     * @param idPais identificador del pais
     * @return Lista de objetos de tipo Municipio
     * @param nombre a {@link java.lang.String} object.
     */
    @ResultMap("PaisEstadoMunicipioMap")
    @Select("SELECT " + CAMPOS_AUX_MUN + " FROM municipio m "
            + "INNER JOIN estado e on m.id_estado = e.id "
            + "INNER JOIN pais p on e.id_pais = p.id WHERE e.id_pais = #{idPais} and m.nombre LIKE '%' #{nombre} '%' ")
    List<Municipio> getMunicipiosByPaisNombreDescripcion(int idPais, String nombre);

    /**
     * Obtiene una lista de objetos de tipo 'Municipio' que trae el nombre del pais
     * y el nombre del estado.
     *
     * @param idEstado identificador del pais
     * @return Lista de objetos de tipo Municipio
     * @param nombre a {@link java.lang.String} object.
     */
    @ResultMap("PaisEstadoMunicipioMap")
    @Select("SELECT " + CAMPOS_AUX_MUN + " FROM municipio m "
            + "INNER JOIN estado e on m.id_estado = e.id "
            + "INNER JOIN pais p on e.id_pais = p.id WHERE m.id_estado = #{idEstado}  and m.nombre LIKE '%' #{nombre} '%' ")
    List<Municipio> getMunicipiosByEstadoNombreDescripcion(int idEstado, String nombre);

}
