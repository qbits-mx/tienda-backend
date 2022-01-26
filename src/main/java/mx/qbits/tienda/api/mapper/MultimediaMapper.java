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

	/**
	* Inserta un objeto de tipo Multimedia a la base con base a la información de dicho objeto
	* @param la multimedia que se va a insertar en la base de datos
	* @throws java.sql.SQLException en caso de haber un error en la operación en la base de datos
	*/
	@Insert("INSERT INTO multimedia("+CAMPOS_MULTIMEDIA+")"
			+ " VALUES(#{id_anuncio}, #{tipo}, #{url})")
	int insert(int id_anuncio, String tipo, String url) throws SQLException;

}
