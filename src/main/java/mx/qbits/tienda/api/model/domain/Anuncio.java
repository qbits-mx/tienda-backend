package mx.qbits.tienda.api.model.domain;

import java.sql.Date;
import java.util.List;

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
    private List<Multimedia> multimedia;

    public Anuncio() {
    }

    public Anuncio(int id, int idUsuario, int idComprador, int idCatalogoDepartamento,
                   int idCatalogoCondicion, int idCatalogoFormaDePago, int idCatalogoZonaDeEntrega,
                   String descripcion, Date vigenciaAnuncio, String contacto, boolean validado,
                   boolean notificado, boolean revisado, boolean activo, boolean comprado,
                   Date fechaCompra, int estrellas, int comentario, boolean comentarioAprobado
            , List<Multimedia> multimedia) {
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
        this.multimedia = multimedia;
    }

    public Anuncio(int id, int idUsuario,  int idCatalogoDepartamento,
                   int idCatalogoCondicion, int idCatalogoFormaDePago, int idCatalogoZonaDeEntrega,
                   String descripcion, Date vigenciaAnuncio, String contacto, List<Multimedia> multimedia) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idCatalogoDepartamento = idCatalogoDepartamento;
        this.idCatalogoCondicion = idCatalogoCondicion;
        this.idCatalogoFormaDePago = idCatalogoFormaDePago;
        this.idCatalogoZonaDeEntrega = idCatalogoZonaDeEntrega;
        this.descripcion = descripcion;
        this.vigenciaAnuncio = vigenciaAnuncio;
        this.contacto = contacto;
        this.multimedia = multimedia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(int idComprador) {
        this.idComprador = idComprador;
    }

    public int getIdCatalogoDepartamento() {
        return idCatalogoDepartamento;
    }

    public void setIdCatalogoDepartamento(int idCatalogoDepartamento) {
        this.idCatalogoDepartamento = idCatalogoDepartamento;
    }

    public int getIdCatalogoCondicion() {
        return idCatalogoCondicion;
    }

    public void setIdCatalogoCondicion(int idCatalogoCondicion) {
        this.idCatalogoCondicion = idCatalogoCondicion;
    }

    public int getIdCatalogoFormaDePago() {
        return idCatalogoFormaDePago;
    }

    public void setIdCatalogoFormaDePago(int idCatalogoFormaDePago) {
        this.idCatalogoFormaDePago = idCatalogoFormaDePago;
    }

    public int getIdCatalogoZonaDeEntrega() {
        return idCatalogoZonaDeEntrega;
    }

    public void setIdCatalogoZonaDeEntrega(int idCatalogoZonaDeEntrega) {
        this.idCatalogoZonaDeEntrega = idCatalogoZonaDeEntrega;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getVigenciaAnuncio() {
        return vigenciaAnuncio;
    }

    public void setVigenciaAnuncio(Date vigenciaAnuncio) {
        this.vigenciaAnuncio = vigenciaAnuncio;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public boolean isValidado() {
        return validado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }

    public boolean isNotificado() {
        return notificado;
    }

    public void setNotificado(boolean notificado) {
        this.notificado = notificado;
    }

    public boolean isRevisado() {
        return revisado;
    }

    public void setRevisado(boolean revisado) {
        this.revisado = revisado;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean isComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public int getComentario() {
        return comentario;
    }

    public void setComentario(int comentario) {
        this.comentario = comentario;
    }

    public boolean getComentarioAprobado() {
        return comentarioAprobado;
    }

    public void setComentarioAprobado(boolean comentarioAprobado) {
        this.comentarioAprobado = comentarioAprobado;
    }

    public List<Multimedia> getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(List<Multimedia> multimedia) {
        this.multimedia = multimedia;
    }

    public void setMultimedia(Multimedia multimedia) {
        this.multimedia.add(multimedia);
    }
}
