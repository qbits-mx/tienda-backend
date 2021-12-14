package mx.qbits.tienda.api.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import mx.qbits.tienda.api.model.domain.Anuncio;

/**
 * Interfaz 'Mapper' MyBatis asociado a la entidad Anuncio.
 *
 * @author Sunflower
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see Anuncio
 */
public interface BuscarAnuncioMapper {
	
	final String CAMPOS_BUSCAR_ANUNCIO = " id, id_usuario, id_comprador, id_catalogo_departamento,"
			+ "id_catalogo_condicion, id_catalogo_forma_de_pago, id_catalogo_zona_de_entrega, descripcion,"
			+ "vigencia_anuncio, contacto, validado, notificado, revisado, activo, comprado, fecha_compra,"
			+ "estrellas, comentario, comentario_aprobado ";

    /**
     * Obtiene un objeto de tipo 'Anuncio' dado su id.
     *
     * @return Anuncio que tiene asignado el id pasado como parámetro
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     * @param id a int.
     */
    @Results(id = "BuscarAnuncioMapping", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "idUsuario", column = "id_usuario"),
            @Result(property = "idComprador", column = "id_comprador"),
            @Result(property = "idCatalogoDepartamento", column = "id_catalogo_departamento"),
            @Result(property = "idCatalogoCondicion", column = "id_catalogo_condicion"),
            @Result(property = "idCatalogoFormaDePago", column = "id_catalogo_forma_pago"),
            @Result(property = "idCatalogoZonaDeEntrega", column = "id_catalogo_zona_entrega"),
            @Result(property = "descripcion", column = "descripcion"),
            @Result(property = "vigenciaAnuncio", column = "vigencia_anuncio"),
            @Result(property = "contacto", column = "contacto"),
            @Result(property = "validado", column = "validado"),
            @Result(property = "notificado", column = "notificado"),
            @Result(property = "revisado", column = "revisado"),
            @Result(property = "activo", column = "activo"),
            @Result(property = "comprado", column = "comprado"),
            @Result(property = "fechaCompra", column = "fecha_compra"),
            @Result(property = "estrellas", column = "estrellas"),
            @Result(property = "comentario", column = "comentario"),
            @Result(property = "comentarioAprobado", column = "comentario_aprobado"),

    })
    @Select("SELECT " + CAMPOS_BUSCAR_ANUNCIO + " FROM anuncio WHERE id = #{id} ")
    Anuncio getById(int id) throws SQLException;
	
    /**
     * Obtiene una lista de objetos de tipo 'Anuncio'.
     *
     * @return Lista de objetos de tipo Anuncio
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("BuscarAnuncioMapping")
    @Select("SELECT " + CAMPOS_BUSCAR_ANUNCIO + " FROM anuncio ")
    List<Anuncio> getAll() throws SQLException;
    
    /**
     * Dado el id de catalogo departamento, se retornan todos los anuncios que pertenecen a este.
     *
     * @param id id del catalogo departamento que contiene a los anuncios retornados.
     * @return Lista de anuncios pertenecientes al catalogo departamento recibido.
     * @throws java.sql.SQLException Si ocurre un error en la consulta o en el sistema.
     */
    @Select("SELECT " + CAMPOS_BUSCAR_ANUNCIO + " FROM anuncio WHERE id_catalogo_departamento=#{id}" )
    List<Anuncio> getByDepartamento(int id_catalogo_departamento) throws SQLException;
    
    /**
     * Dado el id de catalogo condicion, se retornan todos los anuncios que pertenecen a este.
     *
     * @param id id de la condicion que contiene a los anuncios retornados.
     * @return Lista de anuncios pertenecientes a la condicion recibido.
     * @throws java.sql.SQLException Si ocurre un error en la consulta o en el sistema.
     */
    @Select("SELECT " + CAMPOS_BUSCAR_ANUNCIO + " FROM anuncio WHERE id_catalogo_condicion=#{id}" )
    List<Anuncio> getByCondicion(int id_catalogo_condicion) throws SQLException;
    
    /**
     * Dado el id de la forma de pago, se retornan todos los anuncios que pertenecen a este.
     *
     * @param id id de la forma de pago que contiene a los anuncios retornados.
     * @return Lista de anuncios pertenecientes a la forma de pago recibido.
     * @throws java.sql.SQLException Si ocurre un error en la consulta o en el sistema.
     */
    @Select("SELECT " + CAMPOS_BUSCAR_ANUNCIO + " FROM anuncio WHERE id_catalogo_forma_pago=#{id}" )
    List<Anuncio> getByFormaPago(int id_catalogo_forma_pago) throws SQLException;
    
    /**
     * Dado el id de la zona de entrega, se retornan todos los anuncios que pertenecen a este.
     *
     * @param id id de la zona de entrega que contiene a los anuncios retornados.
     * @return Lista de anuncios pertenecientes a la zona de entrega recibido.
     * @throws java.sql.SQLException Si ocurre un error en la consulta o en el sistema.
     */
    @Select("SELECT " + CAMPOS_BUSCAR_ANUNCIO + " FROM anuncio WHERE id_catalogo_zona_entrega=#{id}" )
    List<Anuncio> getByZonaEntrega(int id_catalogo_zona_entrega) throws SQLException;
        

}
