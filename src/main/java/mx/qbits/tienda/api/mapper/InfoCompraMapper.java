package mx.qbits.tienda.api.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import mx.qbits.tienda.api.model.domain.InfoCompra;

public interface InfoCompraMapper {

	@Results(id="AnuncioMap", value = {
	        @Result(property = "nick_name",     column = "nick_name"),
	        @Result(property = "id_usuario", column = "id_usuario"),
	        @Result(property = "id_anuncio",  column = "id"),
	        @Result(property = "fecha", column = "fecha_compra"),
	        @Result(property = "nombre", column = "nombre"),
	        @Result(property = "precio",column = "precio"),
	        @Result(property = "comentario",column = "comentario"),
	        @Result(property = "estrellas",column = "estrellas_ven"),
	})
	
	/**
	 * 
	 * @param idAnuncio
	 * @return
	 * @throws SQLException
	 */
	@Select("SELECT usuario_detalle.nick_name, usuario_detalle.id_usuario, anuncio.id , anuncio.fecha_compra , anuncio.nombre , anuncio.precio, anuncio.estrellas_ven, anuncio.comentario, anuncio.comentario_aprobado  " + 
			"FROM usuario_detalle " + 
			"LEFT JOIN anuncio ON usuario_detalle.id_usuario = anuncio.id_usuario " + 
			"WHERE anuncio.comprado = 1 AND anuncio.id = #{idAnuncio}") 
	InfoCompra consultaAnuncioComprado (int idAnuncio) throws SQLException;

}
