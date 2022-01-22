package mx.qbits.tienda.api.mapper;
import java.time.LocalDate;
import java.util.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import mx.qbits.tienda.api.model.domain.Anuncio;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AnuncioMapper{
	final String CAMPOS_ANUNCIO = "id_usuario, id_catalogo_condicion, id_catalogo_forma_pago, id_catalogo_zona_entrega, id_catalogo_departamento, descripcion, vigencia, datos_contacto, validado, notificado, revisado, activo, comprado,  comentario_aprobado, nombre, precio";

	@Insert("INSERT INTO anuncio("+CAMPOS_ANUNCIO+")"
			+ " VALUES(#{id_usuario}, #{id_catalogo_condicion}, #{id_catalogo_forma_pago}, #{id_catalogo_zona_entrega}, #{id_catalogo_departamento}, #{descripcion}, #{vigencia}, #{datos_contacto},0,0,0,0,0,0, #{nombre}, #{precio})")
	int insert(int id_usuario, int id_catalogo_condicion, int id_catalogo_forma_pago,
			   int id_catalogo_zona_entrega, int id_catalogo_departamento, String descripcion,
			   LocalDate vigencia, String datos_contacto, String nombre, double precio) throws SQLException;

	@Results(id="AnuncioMapping", value = {
			@Result(property = "activo",              					column = "activo")})
	@Select("SELECT activo FROM anuncio WHERE id_usuario = #{idUsuario}")
	List<Anuncio> getAnuncioActivo(int idUsuario) throws SQLException;

}