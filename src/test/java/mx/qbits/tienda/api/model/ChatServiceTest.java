package mx.qbits.tienda.api.model;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import mx.qbits.tienda.api.mapper.ChatMapper;
import mx.qbits.tienda.api.model.domain.Chat;
import mx.qbits.tienda.api.model.exceptions.ChatException;
import mx.qbits.tienda.api.service.ChatService;
import mx.qbits.tienda.api.service.ChatServiceImpl;
    
@RunWith(MockitoJUnitRunner.class)
public class ChatServiceTest {
    
	private ChatService chatService;

    @Mock
    private ChatMapper chatMapper;
    
    @Before
    public void setup() throws SQLException {
        
        Chat chatAnuncio6_0 = new Chat(699,6,518,518,"cras non velit nec","fecha");
        Chat chatAnuncio10_0 = new Chat(107,10,741,741,"duis bibendum felis sed interdum venenatis turpis","fecha");
        Chat chatAnuncio10_1 = new Chat(335,10,893,893,"eu tincidunt in leo","fecha");

        List<List<Chat>> listaAnuncio6 = new ArrayList<>(), listaAnuncio10 = new ArrayList<>();

        List<Chat> listaAnuncio6Conv0 = new ArrayList<>();
        listaAnuncio6Conv0.add(chatAnuncio6_0);
        listaAnuncio6.add(listaAnuncio6Conv0);

        List<Chat> listaAnuncio10Conv0 = new ArrayList<>();
        listaAnuncio10Conv0.add(chatAnuncio10_0);
        List<Chat> listaAnuncio10Conv1 = new ArrayList<>();
        listaAnuncio10Conv1.add(chatAnuncio10_1);
        listaAnuncio10.add(listaAnuncio10Conv0);
        listaAnuncio10.add(listaAnuncio10Conv1);

        List<Chat> listaAnuncio10T = new ArrayList<>();
        listaAnuncio10T.add(chatAnuncio10_0);
        listaAnuncio10T.add(chatAnuncio10_1);
        
        when(chatMapper.insertSinFecha(1, 1, 2, "Chat 1: Vendedor Mensaje")).thenReturn(1);
        when(chatMapper.insertSinFecha(-11, 1, 2, "Chat 1: Vendedor Mensaje")).thenThrow(new SQLException());
        when(chatMapper.getByConversacion(10,741)).thenReturn(listaAnuncio10Conv0);
        when(chatMapper.getByConversacion(10, 10)).thenThrow(new SQLException());
        when(chatMapper.getByAnuncio(10)).thenReturn(listaAnuncio10T);
        when(chatMapper.getByAnuncio(-11)).thenThrow(new SQLException());
    }


    @Test
    public void enviarMensajeCorrectTest(){
        chatService = new ChatServiceImpl(chatMapper);

        try{
            int idAnuncio=1;
            int idRemitente=1;
            int idHiloPadre=2;
            String mensaje="Chat 1: Vendedor Mensaje";
            assertTrue(chatService.enviarMensaje(idAnuncio, idRemitente, idHiloPadre, mensaje));
        } catch(ChatException e){
            assertTrue(false);
        }
    }

    @Test
    public void enviarMensajeIncorrectTest(){
        chatService = new ChatServiceImpl(chatMapper);
        try{
            int idAnuncio=-11;
            int idRemitente=1;
            int idHiloPadre=2;
            String mensaje="Chat 1: Vendedor Mensaje";
            chatService.enviarMensaje(idAnuncio, idRemitente, idHiloPadre, mensaje);
            assertTrue(false);
        } catch(ChatException e){
            assertTrue(true);
        }
    }

    @Test 
    public void getConversacionCorrectTest(){
        chatService = new ChatServiceImpl(chatMapper);
        try {
            List<Chat> res = chatService.getConversacion(10, 741);
            if (res.size()== 1) {
                assertTrue(true);
            }else{
                assertTrue(false);
            }
        }catch (ChatException e){
            assertTrue(false);
        }
    }

    public void getConversacionIncorrectTest(){
        chatService = new ChatServiceImpl(chatMapper);
        try {
            chatService.getConversacion(10, 10);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test 
    public void getConversacionesCorrectTest(){
        chatService = new ChatServiceImpl(chatMapper);
        try{
            chatService.getConversaciones(10);
            assertTrue(true);
        } catch(ChatException e){
            assertTrue(false);
        }
    }

    @Test 
    public void getConversacionesIncorrectTest(){
        chatService = new ChatServiceImpl(chatMapper);
        try{
            chatService.getConversaciones(-11);
            assertTrue(false);
        } catch(ChatException e){
            assertTrue(true);
        }
    }
    
}
