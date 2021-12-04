/**
 * 
 */
package mx.qbits.tienda.api.model.request;

/**
 * 
 */
public class ChatRequest {
    
    /**
     * 
     */
    private String mensaje;
    private int idUsuario;
    private int idAnuncio;
    private int idHiloPadre;
    /**
     * 
     */
    public ChatRequest(int idUsuario, int idAnuncio, int idHiloPadre, String mensaje) {
        this.idUsuario = idUsuario;
        this.idAnuncio = idAnuncio;
        this.idHiloPadre = idHiloPadre;
        this.mensaje = mensaje;
    }


    public ChatRequest(int idUsuario, int idAnuncio, int idHiloPadre) {
        this.idUsuario = idUsuario;
        this.idAnuncio = idAnuncio;
        this.idHiloPadre = idHiloPadre;
    }


    public String getMensaje() {
        return mensaje;
    }


    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }


    public int getIdUsuario() {
        return idUsuario;
    }


    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }


    public int getIdAnuncio() {
        return idAnuncio;
    }


    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }


    public int getIdHiloPadre() {
        return idHiloPadre;
    }


    public void setIdHiloPadre(int idHiloPadre) {
        this.idHiloPadre = idHiloPadre;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idAnuncio;
        result = prime * result + idHiloPadre;
        result = prime * result + idUsuario;
        result = prime * result + ((mensaje == null) ? 0 : mensaje.hashCode());
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
        ChatRequest other = (ChatRequest) obj;
        if (idAnuncio != other.idAnuncio)
            return false;
        if (idHiloPadre != other.idHiloPadre)
            return false;
        if (idUsuario != other.idUsuario)
            return false;
        if (mensaje == null) {
            if (other.mensaje != null)
                return false;
        } else if (!mensaje.equals(other.mensaje))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "ChatRequest [idAnuncio=" + idAnuncio + ", idHiloPadre=" + idHiloPadre + ", idUsuario=" + idUsuario
                + ", mensaje=" + mensaje + "]";
    }

}
