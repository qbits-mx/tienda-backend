package mx.qbits.tienda.api.model.domain;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;
import java.time.LocalDate;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate vigenciaAnuncio;
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
    private String nombre;
    private double precio;

    public Anuncio() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {this.id = id;}

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

    public LocalDate getVigenciaAnuncio() {
        return vigenciaAnuncio;
    }

    public void setVigenciaAnuncio(LocalDate vigenciaAnuncio) { this.vigenciaAnuncio = vigenciaAnuncio; }

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
    /*
    public List<Multimedia> getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(List<Multimedia> multimedia) {
        this.multimedia = multimedia;
    }

    public void setMultimedia(Multimedia multimedia) {
        this.multimedia.add(multimedia);
    }
    */
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
