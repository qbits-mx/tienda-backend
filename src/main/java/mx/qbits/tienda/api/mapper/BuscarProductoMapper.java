package mx.qbits.tienda.api.mapper;

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
public interface BuscarProductoMapper {
    final String CAMPOS_BUSCAR_PRODUCTO = " id, id_usuario, id_comprador, id_catalogo_departamento, id_catalogo_condicion, id_catalogo_forma_de_pago, id_catalogo_zona_de_entrega, descripcion, vigencia_anuncio, contacto, validado, notificado, revisado, activo, comprado, fecha_compra, estrellas, comentario, comentario_aprobado ";

    @Results(id = "BuscarProductoMapping", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "idUsuario", column = "id_usuario"),
            @Result(property = "idComprador", column = "id_comprador"),
            @Result(property = "idCatalogoDepartamento", column = "id_catalogo_departamento"),
            @Result(property = "idCatalogoCondicion", column = "id_catalogo_condicion"),
            @Result(property = "idCatalogoFormaDePago", column = "id_catalogo_forma_de_pago"),
            @Result(property = "idCatalogoZonaDeEntrega", column = "id_catalogo_zona_de_entrega"),
            @Result(property = "descripcion", column = "descripcion"),
            @Result(property = "vigenciaAnuncio", column = "vigencia_anuncio"),
            @Result(property = "contacto", column = "contacto"),
            @Result(property = "validado", column = "validado"),
            @Result(property = "notificado", column = "notificado"),
            @Result(property = "revisado", column = "revisado"),
            @Result(property = "activo", column = "activo"),
            @Result(property = "comprado", column = "comprado"),
            @Result(property = "fechaCompra", column = "fecha_compra"),
            @Result(property = "estrellas", column = "estrellas"),
            @Result(property = "comentario", column = "comentario"),
            @Result(property = "comentarioAprobado", column = "comentario_aprobado"),

    })

    @Select("SELECT " + CAMPOS_BUSCAR_PRODUCTO + " FROM anuncio WHERE id = #{id} ")
    Anuncio getById(int id) throws SQLException;

}