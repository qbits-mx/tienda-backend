package mx.qbits.tienda.api.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import mx.qbits.tienda.api.model.domain.InfoVenta;
import mx.qbits.tienda.api.model.domain.InfoCompra;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad 'Anuncio'.
 *
 * @author  JoseRamirezRojas
 * @see     io.InfoVenta.petstore.api.model.domain.InfoCompraVenta
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@Repository
public interface ConsultaMapper {
	
	
	@Results(id="AnuncioMap", value = {
	        @Result(property = "nick_name",     column = "nick_name"),
	        @Result(property = "id_usuario", column = "id_usuario"),
	        @Result(property = "id_anuncio",  column = "id"),
	        @Result(property = "fecha", column = "fecha_compra"),
	        @Result(property = "nombre", column = "nombre"),
	        @Result(property = "precio",column = "precio"),
	        @Result(property = "estrellas", column = "estrellas_com")
	})
	
	/**
	 * 
	 * @param idAnuncio
	 * @return
	 * @throws SQLException
	 */
	@Select("SELECT usuario_detalle.nick_name, usuario_detalle.id_usuario, anuncio.id , anuncio.fecha_compra , anuncio.nombre , anuncio.precio , anuncio.estrellas_com " + 
			"FROM usuario_detalle " + 
			"LEFT JOIN anuncio ON usuario_detalle.id_usuario = anuncio.id_comprador " + 
			"WHERE anuncio.comprado = 1 AND anuncio.id = #{idAnuncio}") 
	InfoVenta consultaAnuncioVendido (int idAnuncio) throws SQLException;
	
}