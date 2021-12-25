package mx.qbits.tienda.api.model;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.Date;


import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import mx.qbits.tienda.api.mapper.ChatMapper;
import mx.qbits.tienda.api.model.domain.Chat;
import mx.qbits.tienda.api.service.ChatService;
import mx.qbits.tienda.api.service.ChatServiceImpl;
import mx.qbits.tienda.api.model.exceptions.ChatException;
    
@RunWith(MockitoJUnitRunner.class)
public class ChatServiceTest {
    
	@Mock
    private ChatService chatService;

    @Mock
    private ChatMapper chatMapper;

    private List<List<Chat>> listaAnuncio6, listaAnuncio10;

    private List<Chat> listaAnuncio10T;

    /**
     * En total tenemos 4 chats.
     *chat1 = {
     * anuncio = 1,
     * vendedor = 333,
     * comprador = 1001,
     * idHiloPadre = 1001
     *}
     *chat2 ={
         anuncio = 2,
         vendedor = 528,
         comprador = 4,
         idHiloPadre = 4,
     }
     *chat3 = {
         anuncio = 3,
         vendedor = 817,
         comprador = 5,
         idHiloPadre = 5,
     }
     */

    
    @Before
    public void setup() throws SQLException {

        
        Chat chatAnuncio6_0 = new Chat(699,6,518,518,"cras non velit nec","1606521600");

        Chat chatAnuncio10_0 = new Chat(107,10,741,741,"duis bibendum felis sed interdum venenatis turpis","163261440");
        Chat chatAnuncio10_1 = new Chat(335,10,893,893,"eu tincidunt in leo","1617321600");


        listaAnuncio6 = new ArrayList<>();
            List<Chat> listaAnuncio6Conv0 = new ArrayList<>();
            listaAnuncio6Conv0.add(chatAnuncio6_0);
            listaAnuncio6.add(listaAnuncio6Conv0);

        listaAnuncio10 = new ArrayList<>();
            List<Chat> listaAnuncio10Conv0 = new ArrayList<>();
            listaAnuncio10Conv0.add(chatAnuncio10_0);
            List<Chat> listaAnuncio10Conv1 = new ArrayList<>();
            listaAnuncio10Conv1.add(chatAnuncio10_1);
            listaAnuncio10.add(listaAnuncio10Conv0);listaAnuncio10.add(listaAnuncio10Conv1);

        listaAnuncio10T = new ArrayList<>();
        listaAnuncio10T.add(chatAnuncio10_0);listaAnuncio10T.add(chatAnuncio10_1);

        when(chatMapper.getByConversacion(6, 518)).thenReturn(listaAnuncio6Conv0);

        when(chatMapper.getByConversacion(10,741)).thenReturn(listaAnuncio10Conv0);
        when(chatMapper.getByConversacion(10,893)).thenReturn(listaAnuncio10Conv1);

        when(chatMapper.getByAnuncio(10)).thenReturn(listaAnuncio10T);

        try{
            when(chatService.getConversaciones(10)).thenReturn(listaAnuncio10);
        }catch(ChatException e){
            System.out.println("No se pudo crear el chatServiceGetConversaciones");
            assertTrue(false);
        } 
    }



    @Test
    public void enviarMensajeCorrectTest(){
        chatService = new ChatServiceImpl(chatMapper);

        try{
            int idAnuncio=1;
            int idRemitente=1;
            int idHiloPadre=2;
            String mensaje="Chat 1: Vendedor Mensaje";
            chatService.enviarMensaje(idAnuncio, idRemitente, idHiloPadre, mensaje);
            assertTrue(true);
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
            assertTrue(true);
        } catch(ChatException e){
            assertTrue(false);
        }
    }

    // Verifica si 
    @Test 
    public void getConversacionCorrectTest1(){
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



    @Test 
    public void getConversacionesCorrectTest(){
        chatService = new ChatServiceImpl(chatMapper);
        try{
            chatService.getConversaciones(6);
            assertTrue(true);

        } catch(ChatException e){

            assertTrue(false);
        }
    }

    @Test 
    public void getConversacionesIncorrectTest1(){
        chatService = new ChatServiceImpl(chatMapper);
        try{
            int idAnuncio=-11;

            chatService.getConversaciones(idAnuncio);
            assertTrue(false);
        } catch(ChatException e){
            assertTrue(true);
        }
    }

    @Test 
    public void getConversacionesIncorrectTest2(){
        chatService = new ChatServiceImpl(chatMapper);
        try{
            int idAnuncio= 10;
            List<List<Chat>> res = chatService.getConversaciones(idAnuncio);
            if (res == listaAnuncio6 ) {
                assertTrue(false);
            }
//            System.out.println(res);
            if (res.size() != 2 ) {
                assertTrue(false);
            }

            assertTrue(true);
        } catch(ChatException e){
            assertTrue(false);
        }
    }
    
}
