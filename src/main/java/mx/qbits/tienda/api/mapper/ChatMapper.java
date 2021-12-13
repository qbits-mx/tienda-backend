package mx.qbits.tienda.api.mapper;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import mx.qbits.tienda.api.model.domain.Chat;

public interface ChatMapper {

    /**
     * 
     * 
     */
    final String CAMPOS_CHAT = "id, id_anuncio, id_remitente, id_hilo_padre, mensaje, fecha";

    /**
     * 
     * @param id
     * @return
     * @throws SQLException
     */
    @Results(id = "ChatMapping", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "idAnuncio", column = "id_anuncio"),
            @Result(property = "idRemitente", column = "id_remitente"),
            @Result(property = "idHiloPadre", column = "id_hilo_padre"),
            @Result(property = "mensaje", column = "mensaje"),
            @Result(property = "fecha", column = "fecha")
    })@Select("SELECT *"+ " FROM chat WHERE id = #{id} ")
    Chat getById(int id) throws SQLException;

    /**
     * Obtiene todos los mensajes de una conversación iniciada por el usuario id.
     * El interesado/comprador tiene accceso únicamente a estos mensajes.
     * 
     * @param id
     * @return
     * @throws SQLException
     */
    @ResultMap("ChatMapping")
    @Select("SELECT "+ CAMPOS_CHAT + " FROM chat  WHERE id_hilo_padre = #{idHiloPadre} AND id_anuncio = #{idAnuncio}")
    List<Chat> getByConversacion(int idAnuncio, int idHiloPadre) throws SQLException;

    /**
     * Obtiene todos los mensajes relevantes a un anuncio, separados por chat.
     * El dueño del anuncio/vendedor tiene acceso a estos mensajes.
     * 
     * @param id
     * @return
     * @throws SQLException
     */
  
    @ResultMap("ChatMapping")
    @Select("SELECT " + CAMPOS_CHAT+" FROM chat  WHERE id_anuncio = #{idAnuncio} ORDER BY id_hilo_padre")
    List<Chat> getByAnuncio(int idAnuncio) throws SQLException;

    /**
     * 
     * @param idAnuncio
     * @param idRemitente
     * @param idHiloPadre
     * @param mensaje
     * @param fecha
     * @return
     * @throws SQLException
     */
    @Insert("INSERT INTO chat(id_anuncio, id_remitente, id_hilo_padre, mensaje, fecha) VALUES(#{idAnuncio}, #{idRemitente}, #{idHiloPadre}, #{mensaje}, #{fecha})")
    int insertConFecha(int idAnuncio, int idRemitente, int idHiloPadre, String mensaje, Date fecha) throws SQLException;

    /**
     * 
     * @param idAnuncio
     * @param idRemitente
     * @param idHiloPadre
     * @param mensaje
     * @return
     * @throws SQLException
     */
    @Insert("INSERT INTO chat(id_anuncio, id_remitente, id_hilo_padre, mensaje, fecha) VALUES (#{idAnuncio}, #{idRemitente}, #{idHiloPadre}, #{mensaje}, CURRENT_TIMESTAMP)")
    int insertSinFecha(int idAnuncio, int idRemitente, int idHiloPadre, String mensaje) throws SQLException;

}