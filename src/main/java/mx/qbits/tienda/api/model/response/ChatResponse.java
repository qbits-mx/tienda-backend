package mx.qbits.tienda.api.model.response;

import java.util.List;

import mx.qbits.tienda.api.model.domain.Chat;

public class ChatResponse {
    /**
     *  
     * 
     * 
     json = {
         bla = bal 
         bla2 = bal2
         bla3 = [
             {
                 mensaje = "hola mundo",
                 idHiloPadre = 1,
                 id = 14
             },
             {
                 mensaje = "hola ruka",
                 idHiloPadre = 1,
                 id = 14
             }
         ]
     }

     
    
     // Si el comprador quiere ver sus chats, entonces mensajes sería una lista con solo una lista.
     // Si el vendedor quiere ver sus chats, entonces mensajes podría tener más de una lista adentro.
     // Cada Lista de Chats es una conversación completa entre comprador y vendedor.


     */
    private List <List<Chat>> mensajes;

    public ChatResponse(List<List<Chat>> mensajes) {
        this.mensajes = mensajes;
    }

    public ChatResponse() {
    }

    public List<List<Chat>> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<List<Chat>> mensajes) {
        this.mensajes = mensajes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((mensajes == null) ? 0 : mensajes.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ChatResponse other = (ChatResponse) obj;
        if (mensajes == null) {
            if (other.mensajes != null)
                return false;
        } else if (!mensajes.equals(other.mensajes))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ChatResponse [mensajes=" + mensajes + "]";
    }
    
    
    
}
