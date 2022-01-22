package mx.qbits.tienda.api.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import mx.qbits.tienda.api.mapper.ChatMapper;
import mx.qbits.tienda.api.model.domain.Chat;
import mx.qbits.tienda.api.model.exceptions.ChatException;

@Service
public class ChatServiceImpl implements ChatService {

    ChatMapper chatMapper;

    public ChatServiceImpl(ChatMapper chatMapper) {
        this.chatMapper = chatMapper;
    }
    

    @Override
    public boolean enviarMensaje(int idAnuncio, int idRemitente, int idHiloPadre, String mensaje) throws ChatException {
        try {
            chatMapper.insertSinFecha(idAnuncio, idRemitente, idHiloPadre, mensaje);
            return true;
        } catch (SQLException e) {
            String error = "Error en el anuncio " + idAnuncio + " .\nError al mandar el mensaje: " +
                    mensaje + " .\nEnviado por " + idRemitente + ".\nDe la conversacion " + idHiloPadre;
            throw new ChatException(error, idAnuncio, idRemitente);
        }
    }

    @Override
    public List<Chat> getConversacion(int idAnuncio, int idHiloPadre) throws ChatException {
        try {
            return chatMapper.getByConversacion(idAnuncio, idHiloPadre);
        } catch (SQLException e) {
            String error = "Error al obtener la conversación " + idHiloPadre + " del anuncio " + idAnuncio + ".";
            throw new ChatException(error, idAnuncio); 
        }

    }

    @Override
    public List<List<Chat>> getConversaciones(int idAnuncio) throws ChatException {
        try {
            List<Chat> todasLasConversaciones = chatMapper.getByAnuncio(idAnuncio);
            List<List<Chat>> respuesta = new ArrayList<>();

            int convActual = -1;
            int contador = 0;
            for (Chat chat : todasLasConversaciones) {
                if (chat.getIdHiloPadre() != convActual) {
                    convActual = chat.getIdHiloPadre();
                    contador++;
                }
            }

            for (int i = 0; i < contador; i++) {
                List<Chat> aux = new ArrayList<>();
                respuesta.add(aux);
            }

            contador = -1;
            convActual = -1;
            for (Chat chat : todasLasConversaciones) {
                if (chat.getIdHiloPadre() != convActual) {
                    contador++;
                    convActual = chat.getIdHiloPadre();
                }
                
                respuesta.get(contador).add(chat);

            }
            return respuesta;

        } catch (Exception e) {
            String error = "Error al recuperar las conversaciones del anuncio: " + idAnuncio;
            throw new ChatException(error, idAnuncio);
        }

    }

    @Override
    public int soyVendedor(int idAnuncio, int idRemitente) throws ChatException{
        try {
            return chatMapper.soyVendedor(idAnuncio, idRemitente);
        } catch (SQLException e) {
            String error = "Error al verificar al usuario" + idAnuncio + " del anuncio: " + idAnuncio;
            throw new ChatException(error, idAnuncio);
        }
    }
    @Override
    public int numChats(int idAnuncio, int idRemitente) throws ChatException{
        try {
            return chatMapper.numChats(idAnuncio, idRemitente);
        } catch (SQLException e) {
            String error = "Error al verificar al usuario" + idAnuncio + " del anuncio: " + idAnuncio;
            throw new ChatException(error, idAnuncio);
        }
    }

}