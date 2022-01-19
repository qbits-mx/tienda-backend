package mx.qbits.tienda.api.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.springframework.stereotype.Repository;

import mx.qbits.tienda.api.model.domain.Multimedia;

@Repository
public interface MultimediaMapper {

	final String CAMPOS_MULTIMEDIA = "id_anuncio, tipo, url";

	@Results(id="AnuncioMapping", value = {
			@Result(property = "id",     							column = "id"),
			@Result(property = "idAnuncio",      					column = "id_anuncio"),
			@Result(property = "tipo",    					column = "tipo"),
			@Result(property = "url",						column = "url")
	})
	@Select("SELECT * FROM multimedia WHERE id_anuncio = #{idAnuncio}" )
	List<Multimedia> getMultimedia(int idAnuncio) throws SQLException;
}
