package mx.qbits.tienda.api.model.response;

import java.util.List;

import mx.qbits.tienda.api.model.domain.Chat;

public class ChatResponse {
    
    /**
     * Atributos de clase.
     */

    private List <List<Chat>> mensajes;

    public ChatResponse(List<List<Chat>> mensajes) {
        this.mensajes = mensajes;
    }

    /**
     * <p>Constructor for ChatResponse.</p>
     */
    public ChatResponse() {
    }

    /**
     * <p>Getter for the field <code>mensajes</code>.</p>
     *
     * @return a List <List<Chat>>.
     */

    public List<List<Chat>> getMensajes() {
        return mensajes;
    }

    /**
     * <p>Setter for the field <code>mensajes</code>.</p>
     *
     * @param mensajes a List<List<Chat>>.
     */

    public void setMensajes(List<List<Chat>> mensajes) {
        this.mensajes = mensajes;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((mensajes == null) ? 0 : mensajes.hashCode());
        return result;
    }

    /** {@inheritDoc} */
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

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "ChatResponse [mensajes=" + mensajes + "]";
    }

}
