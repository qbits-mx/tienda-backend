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

    /** Constant <code>CAMPOS_USER=" id, correo, clave, creado, activo, acc"{trunked}</code> */
    String CAMPOS_ANUNCIO = " id, idUsuario, idComprador, idCatalogoCondicion, idCatalogoFormaPago, "
    		+ " idCatalogoZonaEntrega, descripcion, vigencia, datosContacto, validado, notificado, "
    		+ "revisado, activo, comprado, fechaCompra, estrellas, comentario, comentarioAprobado ";
    
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
        @Result(property = "estrellas",  column = "estrellas"),
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
    @ResultMap("UsuarioMap")
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
    @ResultMap("UsuarioMap")
    @Select("SELECT " + CAMPOS_ANUNCIO + " FROM anuncio WHERE ( comentario IS NOT NULL AND "
    		+ "comentario_aprobado = 0 ) ")
    List<Anuncio> getComentariosPendientes() throws SQLException;


    /**
     * Permite auditar el comentario dado por el comprador, estando loggeado con permisos
     * de administrador
     * 
     * @param id id del usuario a ser borrado
     * @param aprobado booleano del comentario a ser aprobado
     * @return id del anuncio actualizado
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
    @Update("UPDATE anuncio SET comentario_aprobado = #{aprobado} where id = #{id}")
    int auditarComentario(int id, byte aprobado) throws SQLException;


}
