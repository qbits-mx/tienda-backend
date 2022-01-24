package mx.qbits.tienda.api.service;

import java.util.List;

import mx.qbits.tienda.api.model.exceptions.ChatException;
import mx.qbits.tienda.api.model.domain.Chat;


/**
 * Class 'ChatService' que implementa a la interfaz CatalogoMaestroService.
 * @author Juan Carlos Bautista Sandoval/ Jose Angel Correa Garcia / Ricardo Ruben Gonzalez Garcia
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see mx.qbits.tienda.api.service.chatService
 */

public interface ChatService {


    /**
     * Manda un mensaje del idRemitente, hacia el anuncio con cuerpo mensaje.
     * El idHiloPadre debe ser igual al id del remitente cuando el que manda un mensaje es el comprador.
     * @param idAnuncio El id del anuncio donde se esta comentando.
     * @param idRemitente El id del usuario que esta enviando el mensaje.
     * @param idHiloPadre El id de la conversacion.
     * @param mensaje El mensaje que sera enviado.
     * @return true Si el mensaje pudo ser guardado exitosamente en la base de datos.
     */
    boolean enviarMensaje(int idAnuncio,int idRemitente, int idHiloPadre, String mensaje) throws ChatException ;
    
    /**
    * Obtiene toda la conversacion de un usuario buscando por medio de un producto y el hilo de la conversacion.
    * El id_hilo_padre debe ser igual al id del remitente cuando el que manda un mensaje es el comprador.
    * @param id_anuncio El id del anuncio del que se quiere obtener la conversacion.
    * @param id_hilo_padre El id de la conversacion que se quiere buscar.
    * @return Una lista de Chat (id, idRemitente, mensaje, idHiloPadre) que contiene todas las conversaciones entre el comprador, vendedor.
    */
    List<Chat> getConversacion(int idAnuncio, int idHiloPadre) throws ChatException;
    
    /**
    * Obtiene todas las conversaciones de un anuncio, este metodo es mandado a llamar por un vendedor, para ver todas las conversaciones.
    * con sus posibles compradores.
    * @param id_anuncio El id del anuncio del que se quiere obtener la conversacion.
    * @return Una  de listas lista de Chat (id, idRemitente, mensaje) que contiene todas las conversaciones entre el comprador, vendedor.
    */
    List<List<Chat>> getConversaciones(int idAnuncio) throws ChatException;

    /**
     * Regresa si el idRemitente es el usuario que creo el anuncio con id idAnuncio.
     * @param idAnuncio el id del anuncio a consultar
     * @param idRemitente el id del usuario a verificar.
     * @return Regresa un 1 si eres el vendedor, un 0 si no
     * @throws ChatException
     */
    int soyVendedor(int idAnuncio, int idRemitente) throws ChatException;

    /**
     * Regresa la cantidad de chats que tiene idRemitente dentro del idAnuncio
     * @param idAnuncio El anuncio a revisar
     * @param idRemitente El usuario del que se solicitan la cantidad de chats.
     * @return El numero de chats en ese anuncio por parte del idRemitente.
     * @throws ChatException
     */
    int numChats(int idAnuncio, int idRemitente) throws ChatException;
}
