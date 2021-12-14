package mx.qbits.tienda.api.model.domain;

import java.sql.Date;

public class Anuncio {
    private int id;
    private int idUsuario;
    private int idComprador;
    private int idCatalogoCondicion;
    private int idCatalogoFormaPago;
    private int idCatalogoZonaEntrega;
    private int idCatalogoDepartamento;
    private String descripcion;
    private Date vigencia;
    private String datosContacto;
    private boolean validado;
    private boolean notificado;
    private boolean revisado;
    private boolean activo;
    private boolean comprado;
    private Date fechaCompra;
    private int estrellas;
    private String comentario;
    private boolean comentarioAprobado;

    public Anuncio() {
    }

    public Anuncio(int id, int idUsuario, int idComprador, int idCatalogoCondicion, int idCatalogoFormaPago,
            int idCatalogoZonaEntrega, int idCatalogoDepartamento, String descripcion, Date vigencia,
            String datosContacto, boolean validado, boolean notificado, boolean revisado, boolean activo,
            boolean comprado, Date fechaCompra, int estrellas, String comentario, boolean comentarioAprobado) {
        super();
        this.id = id;
        this.idUsuario = idUsuario;
        this.idComprador = idComprador;
        this.idCatalogoCondicion = idCatalogoCondicion;
        this.idCatalogoFormaPago = idCatalogoFormaPago;
        this.idCatalogoZonaEntrega = idCatalogoZonaEntrega;
        this.idCatalogoDepartamento = idCatalogoDepartamento;
        this.descripcion = descripcion;
        this.vigencia = vigencia;
        this.datosContacto = datosContacto;
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

    public int getIdCatalogoCondicion() {
        return idCatalogoCondicion;
    }

    public void setIdCatalogoCondicion(int idCatalogoCondicion) {
        this.idCatalogoCondicion = idCatalogoCondicion;
    }

    public int getIdCatalogoFormaPago() {
        return idCatalogoFormaPago;
    }

    public void setIdCatalogoFormaPago(int idCatalogoFormaPago) {
        this.idCatalogoFormaPago = idCatalogoFormaPago;
    }

    public int getIdCatalogoZonaEntrega() {
        return idCatalogoZonaEntrega;
    }

    public void setIdCatalogoZonaEntrega(int idCatalogoZonaEntrega) {
        this.idCatalogoZonaEntrega = idCatalogoZonaEntrega;
    }

    public int getIdCatalogoDepartamento() {
        return idCatalogoDepartamento;
    }

    public void setIdCatalogoDepartamento(int idCatalogoDepartamento) {
        this.idCatalogoDepartamento = idCatalogoDepartamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

    public String getDatosContacto() {
        return datosContacto;
    }

    public void setDatosContacto(String datosContacto) {
        this.datosContacto = datosContacto;
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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public boolean isComentarioAprobado() {
        return comentarioAprobado;
    }

    public void setComentarioAprobado(boolean comentarioAprobado) {
        this.comentarioAprobado = comentarioAprobado;
    }

}