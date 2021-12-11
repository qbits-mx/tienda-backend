package mx.qbits.tienda.api.mapper;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import mx.qbits.tienda.api.model.domain.Anuncio;
import org.springframework.stereotype.Repository;

@Repository
public interface AnuncioMapper{
	final String CAMPOS_ANUNCIO: "id, id_usuario, id_comprador, id_catalogo_departamento, id_catalogo_condicion, id_catalogo_forma_pago, id_catalogo_zona_entrega, descripcion, vigencia, datos_contacto, validado, notificado, revisado, activo, comprado, fecha_compra, estrellas, comentario, comentario_aprobado";

	@Results(id="AnuncioMapping", value = {
					@Result(property = "id",              				column = "id"),
					@Result(property = "idUsuario",      					column = "id_usuario"),
					@Result(property = "idComprador",    					column = "id_comprador"),
					@Result(property = "idCatalogoDepartamento",	column = "id_catalogo_departamento"),
					@Result(property = "idCatalogoCondicion", 		column = "id_catalogo_condicion")
					@Result(property = "idCatalogoFormaDePago",		column = "id_catalogo_forma_pago"),
					@Result(property = "idCatalogoZonaEntrega",		column = "id_catalogo_zona_entrega"),
					@Result(property = "descripcion",							column = "descripcion"),
					@Result(property = "vigenciaAnuncio",					column = "vigencia"),
					@Result(property = "contacto",								column = "datos_contacto"),
					@Result(property = "validado",								column = "validado"),
					@Result(property = "notificado",							column = "notificado"),
					@Result(property = "revisado",								column = "revisado"),
					@Result(property = "activo",									column = "activo"),
					@Result(property = "comprado",								column = "comprado"),
					@Result(property = "fechaCompra",							column = "fecha_compra"),
					@Result(property = "estrellas",								column = "estrellas"),
					@Result(property = "comentario",							column = "comentario"),
					@Result(property = "comentarioAprobado",			column = "comentario_aprobado"),
					@Result(property = "multimedia",	column = "mulimedia"),
	})
	@Insert("INSERT INTO anuncio(id_usuario, id_catalogo_condicion, id_catalogo_forma_pago, id_catalogo_zona_entrega id_catalogo_departamento, descripcion, vigencia, datos_contacto) VALUES(#{id_usuario}, #{id_catalogo_condicion}, #{id_catalogo_forma_pago}, #{id_catalogo_zona_entrega}, #{id_catalogo_departamento}, #{descripcion}, #{vigencia}, #{datos_contacto}}")
	int insert(int id_usuario, int id_catalogo_condicion, int id_catalogo_forma_pago, int id_catalogo_zona_entrega, int catalogo_departamento, String descripcion, Date vigencia, String datos_contacto) throws SQLException;

}
