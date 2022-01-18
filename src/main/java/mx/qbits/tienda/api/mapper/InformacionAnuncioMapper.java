package mx.qbits.tienda.api.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import mx.qbits.tienda.api.model.domain.InformacionAnuncio;
import mx.qbits.tienda.api.model.domain.InformacionMultimedia;

/**
 * <p>Descripción:</p>
 * Interfaz 'Mapper' MyBatis asociado a la entidad InformacionAnuncio y InformacionMultimedia.
 *
 * @author JenniferAlanisMtz
 * @author DTanatos01
 * @author Kalato-Pari
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see mx.qbits.tienda.api.model.domain.InformacionAnuncio
 * @see mx.qbits.tienda.api.model.domain.InformacionMultimedia
 */
@Repository
public interface InformacionAnuncioMapper {

	/** Constant <code>CAMPOS_ANUNCIO=" id, id_usuario, descripcion, datos_contacto "</code> */
	String CAMPOS_ANUNCIO = " id, id_usuario, nombre, descripcion, datos_contacto, precio, validado, notificado ";

	/** Constant <code>CAMPOS_MULTIMEDIA=" id, tipo, url "</code> */
	String CAMPOS_MULTIMEDIA = " id, tipo, url ";

	
	/**
	 * Obtiene un objeto de tipo {@link mx.qbits.tienda.api.model.domain.InformacionAnuncio} realizando la búsqueda con base en el 'id' del Anuncio.
	 * 
	 * @param representa el identificador de un objeto {@link mx.qbits.tienda.api.model.domain.InformacionAnuncio} .
	 * @return el {@link mx.qbits.tienda.api.model.domain.InformacionAnuncio}  encontrado con el criterio de búsqueda.
	 * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
	 */
	@Results(id="InformacionAnuncioMap", value = {
		@Result(property = "id", column = "id"),
		@Result(property = "idUsuario", column = "id_usuario"),
		@Result(property = "nombre", column = "nombre"),
		@Result(property = "descripcion", column = "descripcion"),
		@Result(property = "datosContacto", column = "datos_contacto"),
		@Result(property = "precio", column = "precio"),
		@Result(property = "validado", column = "validado"),
		@Result(property = "notificado", column = "notificado")
	})
	@Select("SELECT " + CAMPOS_ANUNCIO + " FROM anuncio WHERE id = #{id} ")
	InformacionAnuncio getById(int id) throws SQLException;

	/**
	 * Actualiza un objeto de tipo {@link mx.qbits.tienda.api.model.domain.InformacionAnuncio} con base en la información dada por el objeto de tipo 'InformacionAnuncio'.
	 * 
	 * @param id representa el identificador de un objeto {@link mx.qbits.tienda.api.model.domain.InformacionAnuncio} .
	 * @param validado representa el nuevo valor de validado de un anuncio en la base de datos.
	 * @return el número de registros actualizados.
	 * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
	 */
	@Update("UPDATE anuncio SET validado = #{validado} WHERE id = #{id}")
	int updateValidado(int id, boolean validado) throws SQLException;
	
	/**
	 * Actualiza un objeto de tipo {@link mx.qbits.tienda.api.model.domain.InformacionAnuncio} con base en la información dada por el objeto de tipo 'InformacionAnuncio'.
	 * 
	 * @param id representa el identificador de un objeto {@link mx.qbits.tienda.api.model.domain.InformacionAnuncio} .
	 * @param validado representa el nuevo valor de validado de un anuncio en la base de datos.
	 * @return el número de registros actualizados.
	 * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
	 */
	@Update("UPDATE anuncio SET notificado = #{notificado} WHERE id = #{id}")
	int updateNotificado(int id, boolean notificado) throws SQLException;
	
	
	/**
	 * Obtiene una lista de objetos de tipo 'InformacionMultimedia' en base al id de un anuncio.
	 * @param representa el identificador de un objeto {@link mx.qbits.tienda.api.model.domain.InformacionAnuncio} .
	 * @return Lista de objetos de tipo InformacionMultimedia.
	 * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
	 */
	@Results(id="InformacionMultimediaMap", value = {
		@Result(property = "id", column = "id"),
		@Result(property = "tipo", column = "tipo"),
		@Result(property = "url", column = "url"),
	})
	@Select("SELECT " + CAMPOS_MULTIMEDIA + " FROM multimedia WHERE id_anuncio = #{id_anuncio}")
	List<InformacionMultimedia> getAllMultimediaByIdAnuncio(int idAnuncio) throws SQLException;
	
}