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

    @GetMapping(path = "/enviar-mensaje.json", produces = "application/json; charset=utf-8")
    public List<Chat> enviarMensaje(
        @RequestParam int idAnuncio, 
        @RequestParam int idRemitente, 
        @RequestParam int idHiloPadre, 
        @RequestParam String mensaje) throws ChatException{
            chatService.enviarMensaje(idAnuncio, idRemitente, idHiloPadre, mensaje);
            return chatService.getConversacion(idAnuncio, idHiloPadre);
    }
    
    @GetMapping(path = "/get-conversacion.json", produces = "application/json; charset=utf-8")
    public List<Chat> getConversacion(
        @RequestParam int idAnuncio,
        @RequestParam int idHiloPadre
        ) throws ChatException{
            return chatService.getConversacion(idAnuncio, idHiloPadre);
    }


    @GetMapping(path = "/get-conversaciones.json", produces = "application/json; charset=utf-8")
    public List<List<Chat>> getConversaciones(
        @RequestParam int idAnuncio
        ) throws ChatException{
            return chatService.getConversaciones(idAnuncio);
    }




}

