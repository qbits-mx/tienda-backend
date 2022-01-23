package mx.qbits.tienda.api.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import mx.qbits.tienda.api.model.domain.Anuncio;

/**
 * Interfaz 'Mapper' MyBatis asociado a la entidad Anuncio.
 *
 * @author Sunflower
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see Anuncio
 */
public interface BuscarProductoMapper {
	
	final String CAMPOS_BUSCAR_ANUNCIO = " id, id_usuario, id_comprador, id_catalogo_departamento,"
			+ "id_catalogo_condicion, id_catalogo_forma_de_pago, id_catalogo_zona_de_entrega, descripcion,"
			+ "vigencia_anuncio, contacto, validado, notificado, revisado, activo, comprado, fecha_compra,"
			+ "estrellas, comentario, comentario_aprobado ";

        /**
         * Obtiene un objeto de tipo 'Producto' dado su id.
         *
         * @return Anuncio que tiene asignado el id pasado como parámetro
         * @throws java.sql.SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
         * @param id a int.
         */
        @Results(id = "BuscarAnuncioMapping", value = {
                @Result(property = "id", 							column = "id"),
                @Result(property = "idUsuario", 					column = "id_usuario"),
                @Result(property = "idComprador", 					column = "id_comprador"),
                @Result(property = "idCatalogoDepartamento", 		column = "id_catalogo_departamento"),
                @Result(property = "idCatalogoCondicion", 			column = "id_catalogo_condicion"),
                @Result(property = "idCatalogoFormaDePago", 		column = "id_catalogo_forma_pago"),
                @Result(property = "idCatalogoZonaDeEntrega",		column = "id_catalogo_zona_entrega"),
                @Result(property = "descripcion", 					column = "descripcion"),
                @Result(property = "vigenciaAnuncio", 				column = "vigencia_anuncio"),
                @Result(property = "contacto", 						column = "contacto"),
                @Result(property = "validado", 						column = "validado"),
                @Result(property = "notificado", 					column = "notificado"),
                @Result(property = "revisado", 						column = "revisado"),
                @Result(property = "activo", 						column = "activo"),
                @Result(property = "comprado", 						column = "comprado"),
                @Result(property = "fechaCompra", 					column = "fecha_compra"),
                @Result(property = "estrellasVend", 				column = "estrellas_ven"),
                @Result(property = "estrellasComp", 				column = "estrellas_com"),
                @Result(property = "comentario", 					column = "comentario"),
                @Result(property = "comentarioAprobado", 			column = "comentario_aprobado"),
                @Result(property = "nombre", 						column = "nombre"),
                @Result(property = "precio", 						column = "precio"),

        })
                
        /**
         * Dado el id del departamento,
         * la zona de entrega,
         * la forma de pago,
         * la condición y las estrellas
         * se retornan todos los anuncios que
         * cumplan con los filtros.
         *
         * @param id_departamento id del departamento.
         * @param id_zona         id de la zona de entrega.
         * @param id_pago         id de la forma de pago.
         * @param id_condicion    id de la condicion del producto.
         * @param id_estrellas    id de la cantidad de estrellas.
         * @return Lista de anuncios dependiendo a los filtros.
         * @throws java.sql.SQLException Si ocurre un error en la consulta o en el
         *                               sistema.
         */
        @ResultMap("BuscarAnunciomapping")
        @Select("SELECT " + CAMPOS_BUSCAR_ANUNCIO + " FROM anuncio"
        		+ "WHERE nombre=#{nombre}"
                        + "AND id_catalogo_departamento=#{idCatalogoDepartamento}"
        		+ "AND id_catalogo_zona_entrega=#{idCatalogoZonaDeEntrega}"
        		+ "AND id_catalogo_forma_pago=#{idCatalogoFormaDePago}"
        		+ "AND id_catalogo_condicion=#{idCatalogoCondicion}"
        		+ "AND estrellas_ven=#{estrellasVend}"
                        + "AND validado=#{TRUE}"
                        + "AND revisado=#{TRUE}"
                        + "AND activo=#{TRUE}"
                        + "AND comprado=#{FALSE}"
                        )
        List<Anuncio> getByFiltros() throws SQLException;

}
