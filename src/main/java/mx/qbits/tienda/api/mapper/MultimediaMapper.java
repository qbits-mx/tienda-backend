package mx.qbits.tienda.api.mapper;
import java.sql.SQLException;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import org.springframework.stereotype.Repository;

@Repository
public interface MultimediaMapper{
	final String CAMPOS_MULTIMEDIA = "id_anuncio, tipo, url";

	@Results(id="AnuncioMapping", value = {
			@Result(property = "id",              					column = "id"),
			@Result(property = "idAnuncio",      					column = "id_anuncio"),
			@Result(property = "tipo",    					column = "tipo"),
			@Result(property = "url",						column = "url")
	})
	@Insert("INSERT INTO multimedia("+CAMPOS_MULTIMEDIA+")"
			+ " VALUES(#{id_anuncio}, #{tipo}, #{url}, #{id_catalogo_zona_entrega})")
	int insert(int id_anuncio, String tipo, String url) throws SQLException;

}