/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     mx.qbits.tienda.api.mapper
 * Proyecto:    tienda
 * Tipo:        Interface
 * Nombre:      ChatMapper
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 28 Nov 2021 @ 07:50:49
 */
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

/**
 * Interfaz 'Mapper' MyBatis asociado a la entidad Chat.
 * @author Juan Carlog Bautista Sandoval
 * @author Ricardo Ruben González García
 * @author Jose Angel Correa García
 * @author León
 * @version 1.0-SNAPSHOT
 * @since 1.O-SNAPSHOT
 * @see mx.qbits.tienda.api.model.domain.Chat
 */
public interface ChatMapper {
    
    /** Constant <code>CAMPOS_CHAT" id, id_anuncio, id_remitente, id_hilo_padre, mensaje, fecha "{trunked}</code> */
    final String CAMPOS_CHAT = "id, id_anuncio, id_remitente, id_hilo_padre, mensaje, fecha";

    /**
     * Obtiene un objeto de tipo 'Chat' dado su id.
     * @param id a int, el cual nos indica el id del chat que deceamos recuperar.
     * @return Chat en caso de encontrar el Chat asociado al id pasado como paramentro, 
     * null en caso de no encontrar un Chat asociado al id pasado como parametro.
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
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
     * Obtiene una conversación dado el id del anuncio y el id del hilo padre.
     * @param idAnuncio a int, el cual debe contener el id del anuncio sobre el cual obtendremos la conversación.
     * @param idHiloPadre a int, el cual nos indica una conversación en particular de dicho anuncio.
     * @return List<Chat> una lista de chats los cuales contienen la conversación de un anuncio e hilo especifico.
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("ChatMapping")
    @Select("SELECT "+ CAMPOS_CHAT + " FROM chat  WHERE id_hilo_padre = #{idHiloPadre} AND id_anuncio = #{idAnuncio} ORDER BY id DESC")
    List<Chat> getByConversacion(int idAnuncio, int idHiloPadre) throws SQLException;

    /**
     * Obtiene todos los chats que estan asociados a un anuncio en especifico.
     * @param idAnuncio a int, el cual nos indica el id del anuncio sobre el cual queremos obtener los chats.
     * @return List<Chat> una lista de chats asociados al id del anuncio pasado como parametro.
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @ResultMap("ChatMapping")
    @Select("SELECT " + CAMPOS_CHAT+" FROM chat  WHERE id_anuncio = #{idAnuncio} ORDER BY id_hilo_padre ASC, id DESC")
    List<Chat> getByAnuncio(int idAnuncio) throws SQLException;

    /**
     * Inserta un objeto de tipo 'Chat' con base en la información dado por el objeto 'Chat'
     * @param idAnuncio a int, el cual nos indica el id del anuncio al que pertenecera el chat.
     * @param idRemitente a int, el cual nos indica quien fue el remitente de dicho chat.
     * @param idHiloPadre a int, el cual nos indica el hilo al que pertenence el chat.
     * @param mensaje a String, el cual contiene el mensaje del chat.
     * @param fecha a Date, el cual indica la hora en el que se creo dicho chat.
     * @return el id auto incremental asociado a ese insercción.
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO chat(id_anuncio, id_remitente, id_hilo_padre, mensaje, fecha) VALUES(#{idAnuncio}, #{idRemitente}, #{idHiloPadre}, #{mensaje}, #{fecha})")
    int insertConFecha(int idAnuncio, int idRemitente, int idHiloPadre, String mensaje, Date fecha) throws SQLException;

    /**
     * Inserta un objeto de tipo 'Chat' con base en la información dado por el objeto 'Chat' exepctuando la fecha.
     * ya que esta se pone automaticamente, en el momento en el que es llamada la función.
     * @param idAnuncio a int, el cual nos indica el id del anuncio al que pertenecera el chat.
     * @param idRemitente idRemitente a int, el cual nos indica quien fue el remitente de dicho chat.
     * @param idHiloPadre a int, el cual nos indica el hilo al que pertenence el chat.
     * @param mensaje a String, el cual contiene el mensaje del chat.
     * @return el id auto incremental asociado a ese insercción.
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @Insert("INSERT INTO chat(id_anuncio, id_remitente, id_hilo_padre, mensaje, fecha) VALUES (#{idAnuncio}, #{idRemitente}, #{idHiloPadre}, #{mensaje}, CURRENT_TIMESTAMP)")
    int insertSinFecha(int idAnuncio, int idRemitente, int idHiloPadre, String mensaje) throws SQLException;

    /**
     * Nos indica el numero de de chats perteneciente a un anuncio y usuario en especifico.
     * @param idAnuncio a int, el anuncio sobre el que haremos el conteo,
     * @param idRemitente a int, el remitente del mensaje.
     * @return a int int, el cual contiene el numero de mensajes(chats) asociados a el anuncio y remitente pasado
     * como parametro.
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @Select("SELECT COUNT(id) FROM anuncio  WHERE id = #{idAnuncio} AND id_usuario = #{idRemitente} ")
    int soyVendedor(int idAnuncio, int idRemitente) throws SQLException;

    /**
     * Metodo que cuenta el numero de chats asociados a un anuncio y el remitente del mismo.
     * @param idAnuncio a int, el anuncio sobre el cual haremos el conteo.
     * @param idRemitente a int, el remitente de los mensajes.
     * @return int, el cual contiene el numero de mensajes(chats) asociados a el anuncio y remitente pasado
     * como parametro.
     * @throws SQLException Se dispara en caso de que ocurra un error en esta operación desde la base de datos.
     */
    @Select("SELECT COUNT(id) from chat WHERE id_anuncio = #{idAnuncio} AND id_remitente = #{idRemitente}")
    int numChats(int idAnuncio, int idRemitente) throws SQLException;

}