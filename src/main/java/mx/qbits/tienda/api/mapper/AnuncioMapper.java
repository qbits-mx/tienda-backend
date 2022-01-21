package mx.qbits.tienda.api.mapper;
import java.time.LocalDate;
import java.sql.SQLException;
import java.util.List;
import mx.qbits.tienda.api.model.domain.Anuncio;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad 'Anuncio'.
 *
 * @author  2 de Pastor
 * @see     mx.qbits.tienda.api.model.domain.Anuncio
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */

@Repository
public interface AnuncioMapper{
	final String CAMPOS_ANUNCIO = "id_usuario, id_catalogo_condicion, id_catalogo_forma_pago, id_catalogo_zona_entrega, id_catalogo_departamento, descripcion, vigencia, datos_contacto, validado, notificado, revisado, activo, comprado,  comentario_aprobado, nombre, precio";
	
	/**
	* Inserta un objeto de tipo anuncio a la base de datos con base a la información del objeto anuncio
	* @param id_usuario datos del anuncio a ser insertado
	* @throws java.sql.SQLException en caso de haber algún error con esta operación en la base de datos
	*/
	@Insert("INSERT INTO anuncio("+CAMPOS_ANUNCIO+")"
			+ " VALUES(#{id_usuario}, #{id_catalogo_condicion}, #{id_catalogo_forma_pago}, #{id_catalogo_zona_entrega}, #{id_catalogo_departamento}, #{descripcion}, #{vigencia}, #{datos_contacto},0,0,0,0,0,0, #{nombre}, #{precio})")
	int insert(int id_usuario, int id_catalogo_condicion, int id_catalogo_forma_pago,
			   int id_catalogo_zona_entrega, int id_catalogo_departamento, String descripcion,
			   LocalDate vigencia, String datos_contacto, String nombre, double precio) throws SQLException;
	
	/**
	* Nos devuelve el anuncio activo asociado a ese id de ususario
	* @return el anuncio que cumpla con los criterios de búsqueda
	* @param idUsuario identificador del usuario asociado a ese anuncio
	* @throws java.sql.SQLException en caso de haber algún error con esta operación en la base de datos
	*/
	@Results(id="AnuncioMapping", value = {
			@Result(property = "activo",              					column = "activo")})
	@Select("SELECT activo FROM anuncio WHERE id_usuario = #{idUsuario}")
	List<Anuncio> getAnuncioActivo(int idUsuario) throws SQLException;

}
