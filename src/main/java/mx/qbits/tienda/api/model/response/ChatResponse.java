package mx.qbits.tienda.api.model.response;

import java.util.List;

import mx.qbits.tienda.api.model.domain.Chat;

public class ChatResponse {

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
