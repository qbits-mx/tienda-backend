package mx.qbits.tienda.api.mapper;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import mx.qbits.tienda.api.model.domain.Anuncio;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad 'Anuncio'.
 *
 * @author  JoseRamirezRojas
 * @see     io.kebblar.petstore.api.model.domain.Anuncio
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@Repository
public interface AnuncioMapper {

    /** Constant <code>CAMPOS_ANUNCIO=" id, idUsuario, idComprador, idCatalogoCondicion, idCatalogoFormaPago, 
    		,idCatalogoZonaEntrega, descripcion, vigencia, datosContacto, validado, notificado,
    		, revisado, activo, comprado, fechaCompra, estrellas, comentario, comentarioAprobado " </code> */
    final String CAMPOS_ANUNCIO = "id, id_usuario, " +
			  "id_comprador, " +
			  "id_catalogo_condicion, " +
			  "id_catalogo_forma_pago, " +
			  "id_catalogo_zona_entrega, " +
			  "descripcion, " +
			  "vigencia, " +
			  "datos_contacto, " +
			  "validado, " +
			  "notificado, " +
			  "revisado, " +
			  "activo, " +
			  "comprado, " +
			  "fecha_compra, " +
			  "estrellas_ven, " +
			  "estrellas_com, " + 
			  "nombre, " +
			  "precio, " +
			  "comentario, " +
			  "comentario_aprobado";
    
    /**
     * Obtiene una lista de objetos de tipo 'usuario'.
     *
     * @return Lista de obetos de tipo usuario
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     * @param id a int.
     */
    @Results(id="AnuncioMap", value = {
        @Result(property = "id",     column = "id"),
        @Result(property = "idUsuario", column = "id_usuario"),
        @Result(property = "idComprador",  column = "id_comprador"),
        @Result(property = "idCatalogoCondicion", column = "id_catalogo_condicion"),
        @Result(property = "idCatalogoFormaPago", column = "id_catalogo_forma_pago"),
        @Result(property = "idCatalogoZonaEntrega",column = "id_catalogo_zona_entrega"),
        @Result(property = "descripcion",   column = "descripcion"),
        @Result(property = "vigencia",  column = "vigencia"),
        @Result(property = "datosContacto", column = "datos_contacto"),
        @Result(property = "validado",  column = "validado"),
        @Result(property = "notificado",  column = "notificado"),
        @Result(property = "revisado",  column = "revisado"),
        @Result(property = "activo",  column = "activo"),
        @Result(property = "comprado",  column = "comprado"),
        @Result(property = "fechaCompra",  column = "fecha_compra"),
        @Result(property = "estrellasVen", column = "estrellas_ven"),
        @Result(property = "estrellasCom",   column = "estrellas_com"),
        @Result(property = "nombre",      column = "nombre"),
        @Result(property = "precio",    column = "precio"),
        @Result(property = "comentario",  column = "comentario"),
        @Result(property = "comentarioAprobado",  column = "comentario_aprobado"),
        })
    @Select("SELECT " + CAMPOS_ANUNCIO + " FROM usuario WHERE id = #{id} ")
    Anuncio getById(int id) throws SQLException;

    /**
     * <p>getAll.</p>
     *
     * @return a {@link java.util.List} object.
     * @throws java.sql.SQLException if any.
     */
    @ResultMap("AnuncioMap")
    @Select("SELECT " + CAMPOS_ANUNCIO + " FROM anuncio ")
    List<Anuncio> getAll() throws SQLException;

    /**
     * Obtiene una lista de anuncios que hayan sido calificados pero aún no hayan sido auditados
     * por un administrador
     *
     * @param correo mail del usuario.
     * @return el usuario encontrado con el criterio de búsqueda.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @ResultMap("AnuncioMap")
    @Select("SELECT " + CAMPOS_ANUNCIO + " FROM anuncio WHERE comentario IS NOT NULL AND "
    		+ "comentario_aprobado IS NULL ")
    List<Anuncio> getComentariosPendientes() throws SQLException;
    
    /**
     * Regresa el historial de Anuncios que fueron comprados por un usuario fijo
     * @param idComprador id del comprador a buscar sus anuncios comprados
     * @return lista de Anuncios comprados por el usuario con el id dado
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @ResultMap("AnuncioMap")
    @Select("SELECT " + CAMPOS_ANUNCIO + " FROM anuncio WHERE id_comprador = #{idUsuario} "
    		+ " AND comprado = 1")
    List<Anuncio> getComprados(int idUsuario) throws SQLException;
    
    /**
     * Regresa el historial de Anuncios que fueron vendidos por un usuario fijo
     * @param idUsuario id del vendedor a buscar sus anuncios vendidos
     * @return lista de Anuncios comprados por el usuario con el id dado
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @ResultMap("AnuncioMap")
    @Select("SELECT " + CAMPOS_ANUNCIO + " FROM anuncio WHERE id_usuario = #{idUsuario} "
    		+ " AND comprado = 1")
    List<Anuncio> getVendidos(int idUsuario) throws SQLException;


    /**
     * Permite auditar el comentario dado por el comprador, estando loggeado con permisos
     * de administrador
     * 
     * @param id id del usuario a ser borrado
     * @param aprobado byte para definir si se aprueba el comentario
     * @return 1 si el cambio pudo hacerse en la base de datos, 0 en otro caso
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE anuncio SET comentario_aprobado = #{aprobado} WHERE id = #{id}")
    int auditarComentario(int id, byte aprobado) throws SQLException;
    
    /**
     * Permite crear calificación por el comprador hacia un anuncio
     * @param idAnuncio id del anuncio a calificar
     * @param comentario comentario opcional para calificar a un producto, sujeto a ser auditado
     * @param estrellas número de estrellas dejado como calificacion
     * @return 1 si el cambio pudo hacerse en la base de datos, 0 en otro caso
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE anuncio SET comentario = #{comentario}, estrellas_ven = #{estrellas} WHERE id = #{idAnuncio}")
    int crearCalificacionVendedor(int idAnuncio, String comentario, int estrellas) throws SQLException;
    
    /**
     * 
     * @param idAnuncio id del anuncio a calificar
     * @param estrellas número de estrellas dejado como calificacion
     * @return 1 si el cambio pudo hacerse en la base de datos, 0 en otro caso
     * @throws SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE anuncio SET estrellas_com = #{estrellas} WHERE id = #{idAnuncio}")
    int crearCalificacionComprador(int idAnuncio, int estrellas) throws SQLException;
    
    /**
	 * Calcula el promedio que un usuario ha abtenido siendo calficado como comprador
	 * @param idComprador
	 * @return calificacion promedio de un usuario como comprador dado su id
	 * @throws SQLException
	 */
	@Select("SELECT AVG(estrellas_com) FROM anuncio WHERE id_comprador = #{idComprador}")
	double promedioComprador (int idComprador) throws SQLException;
}