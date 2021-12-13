package mx.qbits.tienda.api.model.domain;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Objects;
import java.sql.Date;

public class Anuncio {

    private int id;
    private int idUsuario;
    private int idComprador;
    private int idCatalogoDepartamento;
    private int idCatalogoCondicion;
    private int idCatalogoFormaDePago;
    private int idCatalogoZonaDeEntrega;
    private String descripcion;
    private Date vigenciaAnuncio;
    private String contacto;
    private boolean validado;
    private boolean notificado;
    private boolean revisado;
    private boolean activo;
    private boolean comprado;
    private Date fechaCompra;
    private int estrellas;
    private int comentario;
    private boolean comentarioAprobado;

    public Anuncio() {
    }

    public Anuncio(int id, int idUsuario, int idComprador, int idCatalogoDepartamento,
            int idCatalogoCondicion, int idCatalogoFormaDePago, int idCatalogoZonaDeEntrega,
            String descripcion, Date vigenciaAnuncio, String contacto, boolean validado,
            boolean notificado, boolean revisado, boolean activo, boolean comprado,
            Date fechaCompra, int estrellas, int comentario, boolean comentarioAprobado) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idComprador = idComprador;
        this.idCatalogoDepartamento = idCatalogoDepartamento;
        this.idCatalogoCondicion = idCatalogoCondicion;
        this.idCatalogoFormaDePago = idCatalogoFormaDePago;
        this.idCatalogoZonaDeEntrega = idCatalogoZonaDeEntrega;
        this.descripcion = descripcion;
        this.vigenciaAnuncio = vigenciaAnuncio;
        this.contacto = contacto;
        this.validado = validado;
        this.notificado = notificado;
        this.revisado = revisado;
        this.activo = activo;
        this.comprado = comprado;
        this.fechaCompra = fechaCompra;
        this.estrellas = estrellas;
        this.comentario = comentario;
        this.comentarioAprobado = comentarioAprobado;
    }

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return int return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return int return the idComprador
     */
    public int getIdComprador() {
        return idComprador;
    }

    /**
     * @param idComprador the idComprador to set
     */
    public void setIdComprador(int idComprador) {
        this.idComprador = idComprador;
    }

    /**
     * @return int return the idCatalogoDepartamento
     */
    public int getIdCatalogoDepartamento() {
        return idCatalogoDepartamento;
    }

    /**
     * @param idCatalogoDepartamento the idCatalogoDepartamento to set
     */
    public void setIdCatalogoDepartamento(int idCatalogoDepartamento) {
        this.idCatalogoDepartamento = idCatalogoDepartamento;
    }

    /**
     * @return int return the idCatalogoCondicion
     */
    public int getIdCatalogoCondicion() {
        return idCatalogoCondicion;
    }

    /**
     * @param idCatalogoCondicion the idCatalogoCondicion to set
     */
    public void setIdCatalogoCondicion(int idCatalogoCondicion) {
        this.idCatalogoCondicion = idCatalogoCondicion;
    }

    /**
     * @return int return the idCatalogoFormaDePago
     */
    public int getIdCatalogoFormaDePago() {
        return idCatalogoFormaDePago;
    }

    /**
     * @param idCatalogoFormaDePago the idCatalogoFormaDePago to set
     */
    public void setIdCatalogoFormaDePago(int idCatalogoFormaDePago) {
        this.idCatalogoFormaDePago = idCatalogoFormaDePago;
    }

    /**
     * @return int return the idCatalogoZonaDeEntrega
     */
    public int getIdCatalogoZonaDeEntrega() {
        return idCatalogoZonaDeEntrega;
    }

    /**
     * @param idCatalogoZonaDeEntrega the idCatalogoZonaDeEntrega to set
     */
    public void setIdCatalogoZonaDeEntrega(int idCatalogoZonaDeEntrega) {
        this.idCatalogoZonaDeEntrega = idCatalogoZonaDeEntrega;
    }

    /**
     * @return String return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return Date return the vigenciaAnuncio
     */
    public Date getVigenciaAnuncio() {
        return vigenciaAnuncio;
    }

    /**
     * @param vigenciaAnuncio the vigenciaAnuncio to set
     */
    public void setVigenciaAnuncio(Date vigenciaAnuncio) {
        this.vigenciaAnuncio = vigenciaAnuncio;
    }

    /**
     * @return String return the contacto
     */
    public String getContacto() {
        return contacto;
    }

    /**
     * @param contacto the contacto to set
     */
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    /**
     * @return boolean return the validado
     */
    public boolean isValidado() {
        return validado;
    }

    /**
     * @param validado the validado to set
     */
    public void setValidado(boolean validado) {
        this.validado = validado;
    }

    /**
     * @return boolean return the notificado
     */
    public boolean isNotificado() {
        return notificado;
    }

    /**
     * @param notificado the notificado to set
     */
    public void setNotificado(boolean notificado) {
        this.notificado = notificado;
    }

    /**
     * @return boolean return the revisado
     */
    public boolean isRevisado() {
        return revisado;
    }

    /**
     * @param revisado the revisado to set
     */
    public void setRevisado(boolean revisado) {
        this.revisado = revisado;
    }

    /**
     * @return boolean return the activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * @return boolean return the comprado
     */
    public boolean isComprado() {
        return comprado;
    }

    /**
     * @param comprado the comprado to set
     */
    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }

    /**
     * @return Date return the fechaCompra
     */
    public Date getFechaCompra() {
        return fechaCompra;
    }

    /**
     * @param fechaCompra the fechaCompra to set
     */
    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    /**
     * @return int return the estrellas
     */
    public int getEstrellas() {
        return estrellas;
    }

    /**
     * @param estrellas the estrellas to set
     */
    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    /**
     * @return int return the comentario
     */
    public int getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(int comentario) {
        this.comentario = comentario;
    }

    /**
     * @return boolean return the comentarioAprobado
     */
    public boolean isComentarioAprobado() {
        return comentarioAprobado;
    }

    /**
     * @param comentarioAprobado the comentarioAprobado to set
     */
    public void setComentarioAprobado(boolean comentarioAprobado) {
        this.comentarioAprobado = comentarioAprobado;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Anuncio)) {
            return false;
        }
        Anuncio anuncio = (Anuncio) o;
        return id == anuncio.id && idUsuario == anuncio.idUsuario && idComprador == anuncio.idComprador
                && idCatalogoDepartamento == anuncio.idCatalogoDepartamento
                && idCatalogoCondicion == anuncio.idCatalogoCondicion
                && idCatalogoFormaDePago == anuncio.idCatalogoFormaDePago
                && idCatalogoZonaDeEntrega == anuncio.idCatalogoZonaDeEntrega
                && Objects.equals(descripcion, anuncio.descripcion)
                && Objects.equals(vigenciaAnuncio, anuncio.vigenciaAnuncio)
                && Objects.equals(contacto, anuncio.contacto) && validado == anuncio.validado
                && notificado == anuncio.notificado && revisado == anuncio.revisado && activo == anuncio.activo
                && comprado == anuncio.comprado && Objects.equals(fechaCompra, anuncio.fechaCompra)
                && estrellas == anuncio.estrellas && comentario == anuncio.comentario
                && comentarioAprobado == anuncio.comentarioAprobado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUsuario, idComprador, idCatalogoDepartamento, idCatalogoCondicion,
                idCatalogoFormaDePago, idCatalogoZonaDeEntrega, descripcion, vigenciaAnuncio, contacto, validado,
                notificado, revisado, activo, comprado, fechaCompra, estrellas, comentario, comentarioAprobado);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", idUsuario='" + getIdUsuario() + "'" +
                ", idComprador='" + getIdComprador() + "'" +
                ", idCatalogoDepartamento='" + getIdCatalogoDepartamento() + "'" +
                ", idCatalogoCondicion='" + getIdCatalogoCondicion() + "'" +
                ", idCatalogoFormaDePago='" + getIdCatalogoFormaDePago() + "'" +
                ", idCatalogoZonaDeEntrega='" + getIdCatalogoZonaDeEntrega() + "'" +
                ", descripcion='" + getDescripcion() + "'" +
                ", vigenciaAnuncio='" + getVigenciaAnuncio() + "'" +
                ", contacto='" + getContacto() + "'" +
                ", validado='" + isValidado() + "'" +
                ", notificado='" + isNotificado() + "'" +
                ", revisado='" + isRevisado() + "'" +
                ", activo='" + isActivo() + "'" +
                ", comprado='" + isComprado() + "'" +
                ", fechaCompra='" + getFechaCompra() + "'" +
                ", estrellas='" + getEstrellas() + "'" +
                ", comentario='" + getComentario() + "'" +
                ", comentarioAprobado='" + isComentarioAprobado() + "'" +
                "}";
    }

}