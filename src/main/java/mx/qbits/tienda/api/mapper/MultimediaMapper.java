package mx.qbits.tienda.api.mapper;
import java.sql.SQLException;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import org.springframework.stereotype.Repository;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' MyBatis asociado a la entidad 'Multimedia'.
 *
 * @author  2 de Pastor
 * @see     mx.qbits.tienda.api.model.domain.Multimedia
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */

@Repository
public interface MultimediaMapper{
	final String CAMPOS_MULTIMEDIA = "id_anuncio, tipo, url";

	/**
	* Devuelve una lista de multimedia
	* @return lista de Multimedia
	* @throws java.sql.SQLException en caso de haber un error en la operación en la base de datos
	*/
	@Results(id="AnuncioMapping", value = {
			@Result(property = "id",              					column = "id"),
			@Result(property = "idAnuncio",      					column = "id_anuncio"),
			@Result(property = "tipo",    					column = "tipo"),
			@Result(property = "url",						column = "url")
	})
	
	/**
	* Inserta un objeto de tipo Multimedia a la base con base a la información de dicho objeto
	* @param la multimedia que se va a insertar en la base de datos
	* @throws java.sql.SQLException en caso de haber un error en la operación en la base de datos
	*/
	@Insert("INSERT INTO multimedia("+CAMPOS_MULTIMEDIA+")"
			+ " VALUES(#{id_anuncio}, #{tipo}, #{url})")
	int insert(int id_anuncio, String tipo, String url) throws SQLException;

}