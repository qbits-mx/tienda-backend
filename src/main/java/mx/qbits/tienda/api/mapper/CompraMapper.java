package mx.qbits.tienda.api.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import mx.qbits.tienda.api.model.domain.Compra;
import mx.qbits.tienda.api.model.domain.CompraMultimedia;

/**
 * <p>Descripción:</p>
 * Interface 'Mapper' asociado a la entidad 'Anuncio'.
 *
 * @author  gerardomt
 * @see     mx.qbits.tienda.api.model.domain.Compra
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@Repository
public interface CompraMapper {

    /** Constant <code>CAMPOS_ANUNCIO=" id, id_usuario, id_comprador, id_catalogo_condicion"{trunked}</code> */
	String CAMPOS_ANUNCIO = "id, id_usuario, " +
			  "id_comprador, " +
			  "id_catalogo_condicion, " +
			  "id_catalogo_forma_pago, " +
			  "id_catalogo_zona_entrega, " +
			  "id_catalogo_departamento, " +
			  "descripcion, " +
			  "vigencia, " +
			  "datos_contacto, " +
			  "validado, " +
			  "notificado, " +
			  "revisado, " +
			  "activo, " +
			  "comprado, " +
			  "fecha_compra, " +
			  "estrellas_ven, " +
			  "estrellas_com, " + 
			  "nombre, " +
			  "precio, " +
			  "comentario, " +
			  "comentario_aprobado";

	/**
     * Obtiene un objeto de tipo 'anuncio' dado el id.
     *
     * @return Anuncio con el mismo id que el pasado como parámetro
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     * @param id a int.
     */
	@Results(id="AnuncioMap", value = {
	        @Result(property = "id",                  column = "id"),
	        @Result(property = "idUsuario",           column = "id_usuario"),
	        @Result(property = "idComprador",         column = "id_comprador"),
	        @Result(property = "idCatalogoCondicion", column = "id_catalogo_condicion"),
	        @Result(property = "idCatalogoFormaPago",  column = "id_catalogo_forma_pago"),
	        @Result(property = "idCatalogoZonaEntrega",  column = "id_catalogo_zona_entrega"),
	        @Result(property = "idCatalogoDepartamento", column = "id_catalogo_departamento"),
	        @Result(property = "descripcion",         column = "descripcion"),
	        @Result(property = "vigencia",            column = "vigencia"),
	        @Result(property = "datosContacto",       column = "datos_contacto"),
	        @Result(property = "validado",            column = "validado"),
	        @Result(property = "notificado",          column = "notificado"),
	        @Result(property = "revisado",            column = "revisado"),
	        @Result(property = "activo",              column = "activo"),
	        @Result(property = "comprado",            column = "comprado"),
	        @Result(property = "fechaCompra",         column = "fecha_compra"),
	        @Result(property = "estrellasVen",        column = "estrellas_ven"),
	        @Result(property = "estrellasCom",        column = "estrellas_com"),
	        @Result(property = "nombre",              column = "nombre"),
	        @Result(property = "precio",              column = "precio"),
	        @Result(property = "comentario",          column = "comentario"),
	        @Result(property = "comentarioAprobado",  column = "comentarioAprobado")
	        })
	@Select("SELECT " + CAMPOS_ANUNCIO + " FROM anuncio WHERE id = #{id} ")
    Compra getById(int id) throws SQLException;
	
	/**
     * Actualiza un objeto de tipo 'anuncio' con base en la información dada por el objeto de tipo 'anuncio'.
     *
     * @param anuncio a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
	@Update("UPDATE anuncio SET id_comprador = #{idComprador}, comprado = 1, id_catalogo_forma_pago= #{idCatalogoFormaPago}"
            + " fecha_compra = now()"
            + " WHERE id = #{id} ")
    int updateCompra(Compra anuncio) throws SQLException;
	
	/**
     * Actualiza sólo datos de compra de un objeto de tipo 'Compra' con base en la información dada por
     * 'anuncio.
     *
     * @param compra a ser actualizado.
     * @return el numero de registros actualizados.
     * @throws java.sql.SQLException Se dispara en caso de que se dispare un error en esta operación desde la base de datos.
     */
	@Update("UPDATE anuncio SET id_comprador = #{idComprador}, activo = #{activo}, comprado = #{comprado}, id_catalogo_forma_pago= #{idCatalogoFormaPago}, "
            + " fecha_compra = #{fechaCompra} "
            + " WHERE id = #{id} ")
    int updateDatosCompra(Compra anuncio) throws SQLException;
	
	/**
     * Obtiene un objeto de tipo 'CompraMultimedia' dado el id del anuncio.
     *
     * @param idAnuncio id del anuncio.
     * @return Un objeto de tipo Compra Multimedia con el mismo id_anuncio que el pasado como parámetro
     * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     * 
     */
	@Results(id="MultimediaMap", value = {
	        @Result(property = "id",                  column = "id"),
	        @Result(property = "idAnuncio",           column = "id_anuncio"),
	        @Result(property = "tipo",                column = "tipo"),
	        @Result(property = "url",                 column = "url")
	        })
	@Select("SELECT id,id_anuncio, tipo, url FROM multimedia WHERE id_anuncio = #{idAnuncio} " +
	        "AND tipo = 'imagen' LIMIT 1;")
    CompraMultimedia getImageByIdAnuncio(int idAnuncio) throws SQLException;

}
