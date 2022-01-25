package mx.qbits.tienda.api.model;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.Date;


import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.AssertTrue;

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

    private List<List<Chat>> chatAnuncio1;

    private List<Chat> chat2, chat3;
    private Chat chat2_0,chat2_1,chat2_2,
                 chat3_0,chat3_1,chat3_2;

    @Before
    public void setup() throws SQLException {

        
        chat2_0 = new Chat(1,1,2,2,"Hola!","2022-01-10");
        chat2_1 = new Chat(2,1,1,2,"Buenas tardes!","2022-01-10");
        chat2_2 = new Chat(3,1,2,2,"Tiene los audifinos en azul?","2022-01-10");
        
        chat3_0 = new Chat(4,1,3,2,"Hola!","2022-01-10");
        chat3_1 = new Chat(5,1,3,2,"Ya es lo menos?","2022-01-10");
        chat3_2 = new Chat(6,1,1,2,"Si, ya es lo menos","2022-01-10");


        chatAnuncio1 = new ArrayList<>();
            List<Chat> chat2 = new ArrayList<>();
            chat2.add(chat2_0);
            chat2.add(chat2_1);
            chat2.add(chat2_2);

            List<Chat> chat3 = new ArrayList<>();
            chat3.add(chat3_0);
            chat3.add(chat3_1);
            chat3.add(chat3_2);

        chatAnuncio1.add(chat2); chatAnuncio1.add(chat3);

        when(chatMapper.getByConversacion(1, 2)).thenReturn(chat2);

        when(chatMapper.getByConversacion(1,3)).thenReturn(chat3);

        when(chatMapper.getByAnuncio(1)).thenReturn(chatAnuncio1);

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


    // Verifica si 
    @Test 
    public void getConversacionCorrectTest(){
        chatService = new ChatServiceImpl(chatMapper);
        try {
        	
            List<Chat> res = chatService.getConversacion(1, 2);
            if (res.size()== 3) {
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
            List<List<Chat>> res = chatService.getConversaciones(1);
            if (res.size() != 2) {
                assertTrue(false);
            }
            if (res.get(0).get(0) != chat2_0) {
                assertTrue(false);
            }
            if (res.get(0).get(1) != chat2_1) {
                assertTrue(false);
            }
            if (res.get(0).get(2) != chat2_2) {
                assertTrue(false);
            }
            if (res.get(1).get(0) != chat3_0) {
                assertTrue(false);
            }
            if (res.get(1).get(1) != chat3_1) {
                assertTrue(false);
            }
            if (res.get(1).get(2) != chat3_2) {
                assertTrue(false);
            }
            
            assertTrue(true);

        } catch(ChatException e){

            assertTrue(false);
        }
    }

     
}
