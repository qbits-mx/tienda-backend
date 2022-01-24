package mx.qbits.tienda.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import mx.qbits.tienda.api.model.exceptions.ChatException;
import mx.qbits.tienda.api.service.ChatService;
import java.util.List;
import mx.qbits.tienda.api.model.domain.Chat;

@RestController
@RequestMapping(value = "/api")
public class ChatController {
    

    @Autowired
    ChatService chatService;

    /**
    * Envia mensajes.
    * @param idAnuncio el id del anuncio al que le corresponde el chat.
    * @param idRemitente el id del usuario que envia el mensaje.
    * @param idHiloPadre es el id del hilo de la conversacion.
    * @param mensaje Contenido del mensaje.
    * @return Devuelve la lista de mensaje.
    * @throws ChatException Reporta errores al mandar mensajes.
    */
    @GetMapping(path = "/enviar-mensaje.json", produces = "application/json; charset=utf-8")
    public List<Chat> enviarMensaje(
        @RequestParam int idAnuncio, 
        @RequestParam int idRemitente, 
        @RequestParam int idHiloPadre, 
        @RequestParam String mensaje) throws ChatException{
            chatService.enviarMensaje(idAnuncio, idRemitente, idHiloPadre, mensaje);
            return chatService.getConversacion(idAnuncio, idHiloPadre);
    }
    
    /**
    * Recupera todos los mensajes relacionados a una conversacion.
    * @param idAnuncio el id del anuncio al que le corresponde a la conversacion.
    * @param idHiloPadre es el id del hilo de la conversacion.
    * @return Devuelve la lista de mensaje.
    * @throws ChatException Reporta errores al mandar mensajes.
    */
    @GetMapping(path = "/get-conversacion.json", produces = "application/json; charset=utf-8")
    public List<Chat> getConversacion(
        @RequestParam int idAnuncio,
        @RequestParam int idHiloPadre
        ) throws ChatException{
            return chatService.getConversacion(idAnuncio, idHiloPadre);
    }

    /**
    * Recupera todas las conversaciones de un anuncio. Regresa una lista de listas, en la que cada lista.
    * es una conversacion que guarda los mensajes.
    * @param idAnuncio El anuncio del que se quieren obtener las conversaciones.
    * @return Todos los mensajes relaciones a el anuncio.
    * @throws ChatException Reporta errores al mandar mensajes.
    */

    @GetMapping(path = "/get-conversaciones.json", produces = "application/json; charset=utf-8")
    public List<List<Chat>> getConversaciones(
        @RequestParam int idAnuncio
        ) throws ChatException{
            return chatService.getConversaciones(idAnuncio);
    }

    
    /**
    * Nos dice si el id pertenece al vendedor del anuncio.
    * @param idAnuncio el id del anuncio.
    * @param idRemitente es el id del usuario que manda el mensaje.
    * @return Devuelve true si el usuario es el vendedor del anuncio, false en otro caso.
    * @throws ChatException Reporta errores al mandar mensajes
    */
    @GetMapping(path = "/soy-vendedor.json", produces = "application/json; charset=utf-8")
    public int soyVendedor(
        @RequestParam int idAnuncio,
        @RequestParam int idRemitente
        ) throws ChatException{
            return chatService.soyVendedor(idAnuncio, idRemitente);
    }

    /**
    * Cuenta el numero de chats que tiene un usuario en un anuncio
    * @param idAnuncio el id del anuncio.
    * @param idRemitente es el id del usuario del que se quiere conocer la cantidad de mensajes.
    * @return Devuelve el numero de chats existentes.
    * @throws ChatException Reporta errores al mandar mensajes
    */
    
    @GetMapping(path = "/num-chats.json", produces = "application/json; charset=utf-8")
    public int numChats(
        @RequestParam int idAnuncio,
        @RequestParam int idRemitente
        ) throws ChatException{
            return chatService.numChats(idAnuncio, idRemitente);
        }

}

