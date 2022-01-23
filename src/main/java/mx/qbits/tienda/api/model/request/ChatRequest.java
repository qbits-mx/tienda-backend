/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     mx.qbits.tienda.api.model.request
 * Proyecto:    tienda
 * Tipo:        Clase
 * Nombre:      ChatRequest
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 30 Nov 2021 @ 08:00:59
 */
package mx.qbits.tienda.api.model.request;

/**
 * <p>ChatRequest class.</p>
 * @author Ricardo Rubén González García
 * @author José Angel Correa García
 * @author Juan Carlos Bautista Sandoval
 * @author Leon Ramos
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class ChatRequest {
    
    /**
     * Atributos de clase.
     */
    private String mensaje;
    private int idUsuario;
    private int idAnuncio;
    private int idHiloPadre;
    
    /**
     * Constructor basado en todos los atributos de la clase.
     * @param idUsuario a int, el id del usuario del mensaje(Chat).
     * @param idAnuncio a int, el id del anuncio del mensaje(Chat).
     * @param idHiloPadre a int, el id del hiloPadre del mensaje(Chat).
     * @param mensaje a String, que hace referencia a un mensaje(Chat). 
     */
    public ChatRequest(int idUsuario, int idAnuncio, int idHiloPadre, String mensaje) {
        this.idUsuario = idUsuario;
        this.idAnuncio = idAnuncio;
        this.idHiloPadre = idHiloPadre;
        this.mensaje = mensaje;
    }

    /**
     * Constructor basado en algunos de los atributos de la clase.
     * @param idUsuario a int, el id del usuario del mensaje(Chat).
     * @param idAnuncio idAnuncio a int, el id del anuncio del mensaje(Chat).
     * @param idHiloPadre idHiloPadre a int, el id del hiloPadre del mensaje(Chat).
     */
    public ChatRequest(int idUsuario, int idAnuncio, int idHiloPadre) {
        this.idUsuario = idUsuario;
        this.idAnuncio = idAnuncio;
        this.idHiloPadre = idHiloPadre;
    }

    /**
     * <p>Getter for the field <code>mensaje</code>.</p>
     * @return a {@link java.lang.String} object.
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * <p>Setter for the field <code>mensaje</code>.</p>
     * @param mensaje a {@link java.lang.String} object.
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * <p>Getter for the field <code>idUsuario</code>.</p>
     * @return a int.
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * <p>Setter for the field <code>idUsuario</code>.</p>
     * @param idUsuario a int.
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * <p>Getter for the field <code>idAnuncio</code>.</p>
     * @return a int.
     */
    public int getIdAnuncio() {
        return idAnuncio;
    }

    /**
     * <p>Setter for the field <code>idAnuncio</code>.</p>
     * @param idAnuncio a int.
     */
    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    /**
     * <p>Getter for the field <code>idHiloPadre</code>.</p>
     * @return a int.
     */
    public int getIdHiloPadre() {
        return idHiloPadre;
    }

    /**
     * <p>Setter for the field <code>idHiloPadre</code>.</p>
     * @param idHiloPadre a int.
     */
    public void setIdHiloPadre(int idHiloPadre) {
        this.idHiloPadre = idHiloPadre;
    }

    /** {@inheritDoc} */
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

    /** {@inheritDoc} */
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

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "ChatRequest [idAnuncio=" + idAnuncio + ", idHiloPadre=" + idHiloPadre + ", idUsuario=" + idUsuario
                + ", mensaje=" + mensaje + "]";
    }

}
