/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     mx.qbits.tienda.api.model.domain
 * Proyecto:    tienda
 * Tipo:        Clase
 * Nombre:      Paqueteria
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 27 Nov 2021 @ 07:50:49
 */
package mx.qbits.tienda.api.model.domain;

//import java.util.String;


/**
 * Implementacion del POJO de la entidad de {@link mx.qbits.tienda.api.model.domain.Chat}.
 * @author Juan Carlos Bautista Sandoval
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class Chat {

    /**
     * Atributos de clase
     */
    private int id;
    private int idAnuncio;
    private int idRemitente;
    private int idHiloPadre;
    private String mensaje;
    private String fecha;
    
    /**
     * Constructor por default.
     */
    public Chat() {
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     * @param id el hilo del mensaje
     * @param idAnuncio el identificador del anuncio al cual esta asociado el chat
     * @param idRemitente el identificador de la persona que envio el mensaje
     * @param idHiloPadre el hilo padre del mensaje
     * @param mensaje el mensaje
     * @param fecha la fecha de l acreación del chat
     */
    public Chat(int id, int idAnuncio, int idRemitente, int idHiloPadre, String mensaje, String fecha) {
        this.id = id;
        this.idAnuncio = idAnuncio;
        this.idRemitente = idRemitente;
        this.idHiloPadre = idHiloPadre;
        this.mensaje = mensaje;
        System.out.println("Fecha nueva: " + fecha);
        this.fecha = fecha;
    }

    /**
     * Metodo que devuelce el idHIlo de la instancia chat que lo llama
     * @return int con el idHIlo
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @param idHilo
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 
     * @return
     */
    public int getIdAnuncio() {
        return idAnuncio;
    }

    /**
     * 
     * @param idAnuncion
     */
    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    /**
     * 
     * @return
     */
    public int getIdRemitente() {
        return idRemitente;
    }

    /**
     * 
     * @param idRemitente
     */
    public void setIdRemitente(int idRemitente) {
        this.idRemitente = idRemitente;
    }

    /**
     * 
     * @return
     */
    public int getIdHiloPadre() {
        return idHiloPadre;
    }

    /**
     * 
     * @param idHiloPadre
     */
    public void setIdHiloPadre(int idHiloPadre) {
        this.idHiloPadre = idHiloPadre;
    }

    /**
     * 
     * @return
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * 
     * @param mensaje
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * 
     * @return
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * 
     * @param fecha
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
        result = prime * result + idAnuncio;
        result = prime * result + id;
        result = prime * result + idHiloPadre;
        result = prime * result + idRemitente;
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
        Chat other = (Chat) obj;
        if (fecha == null) {
            if (other.fecha != null)
                return false;
        } else if (!fecha.equals(other.fecha))
            return false;
        if (idAnuncio != other.idAnuncio)
            return false;
        if (id != other.id)
            return false;
        if (idHiloPadre != other.idHiloPadre)
            return false;
        if (idRemitente != other.idRemitente)
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
        return "Chat [fecha=" + fecha + ", idAnuncio=" + idAnuncio + ", id=" + id + ", idHiloPadre="
                + idHiloPadre + ", idRemitente=" + idRemitente + ", mensaje=" + mensaje + "]";
    }

}
