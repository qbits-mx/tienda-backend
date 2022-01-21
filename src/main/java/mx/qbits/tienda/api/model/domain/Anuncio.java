package mx.qbits.tienda.api.model.domain;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

/**
 * <p>Implementación de la clase Anuncio.</p>
 *
 * @author 2 de Pastor
 * @version 1.0-SNAPSHOT
 */
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
    private LocalDate fechaCompra;
    private int estrellasVend;
    private int estrellasComp;
    private String comentario;
    private boolean comentarioAprobado;
    private String nombre;
    private double precio;

    /*+
    * Constructor por omisión
    */
    public Anuncio() {
    }

    /**
    * Getter de idAnuncio
    * @return int el id del anuncio 
    */
    public int getId() {
        return id;
    }

    /**
    * Setter del id del anuncio
    * @param id nuevo id de anuncio
    */
    public void setId(int id) {this.id = id;}

    /**
    * Getter de idUsuario
    * @return int idUsuario
    */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
    * Setter de idUsuario
    * @param idUsuario
    */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
    * Getter de idComprador
    * @return int idComprador
    */
    public int getIdComprador() {
        return idComprador;
    }

    /**
    * Setter de idComprador
    * @param idComprador
    */
    public void setIdComprador(int idComprador) {
        this.idComprador = idComprador;
    }

    /**
    * Getter de idCatalogoDepartamento
    * @return int idCatalogoDepartamento
    */
    public int getIdCatalogoDepartamento() {
        return idCatalogoDepartamento;
    }

    /**
    * Setter de idCatalogoDepartamento
    * @param  idCatalogoDepartamento
    */
    public void setIdCatalogoDepartamento(int idCatalogoDepartamento) {
        this.idCatalogoDepartamento = idCatalogoDepartamento;
    }

    /**
    * Getter de idCatalogoCondicion
    * @return int idCatalogoCondicion
    */
    public int getIdCatalogoCondicion() {
        return idCatalogoCondicion;
    }

    /**
    * Setter de idCatalogoCondicion
    * @param idCatalogoCondicion
    */
    public void setIdCatalogoCondicion(int idCatalogoCondicion) {
        this.idCatalogoCondicion = idCatalogoCondicion;
    }

    /**
    * Getter de idCatalogoFormaDePago
    * @return int idCatalogoFormaDePago
    */
    public int getIdCatalogoFormaDePago() {
        return idCatalogoFormaDePago;
    }

    /**
    * Setter CatalogoFormaDePago
    * @param idCatalogoFormaDePago
    */
    public void setIdCatalogoFormaDePago(int idCatalogoFormaDePago) {
        this.idCatalogoFormaDePago = idCatalogoFormaDePago;
    }
    
    /**
    * Getter de idCatalogoZonaDeEntrega
    * @return int idCatalgoZonaDeEntrega
    */
    public int getIdCatalogoZonaDeEntrega() {
        return idCatalogoZonaDeEntrega;
    }

    /**
    * Setter de idCatalogoZonaDeEntrega
    * @param idCatalogoZonaDeEntrega
    */
    public void setIdCatalogoZonaDeEntrega(int idCatalogoZonaDeEntrega) {
        this.idCatalogoZonaDeEntrega = idCatalogoZonaDeEntrega;
    }
    
    /**
    * Getter de descripcion del anuncio
    * @return String descripcion
    */
    public String getDescripcion() {
        return descripcion;
    }

    /**
    * Setter de descripcion del anuncio
    * @param descripcion
    */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
    * Getter de vigencia del anuncio
    * @return LocalDate vigenciaAnuncio
    */
    public LocalDate getVigenciaAnuncio() {
        return vigenciaAnuncio;
    }

    /**
    * Setter de vigencia del anuncio
    * @param vigenciaAnuncio
    */
    public void setVigenciaAnuncio(LocalDate vigenciaAnuncio) { this.vigenciaAnuncio = vigenciaAnuncio; }

    public String getContacto() {
        return contacto;
    }

    /**
    * Setter de datos de contacto del anuncio
    * @param contacto
    */
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    /**
    * Devuelve si el anuncio ha sido validado
    * @return boolean validado
    */
    public boolean isValidado() {
        return validado;
    }

    /**
    * Setter de validado de anuncio
    * @param validado
    */
    public void setValidado(boolean validado) {
        this.validado = validado;
    }

    /**
    * Delvuelve el valor de notificado
    * @return boolean notificado
    */ 
    public boolean isNotificado() {
        return notificado;
    }

    /**
    * Setter de notificado
    * @param notificado
    */
    public void setNotificado(boolean notificado) {
        this.notificado = notificado;
    }

    /**
    * Devuelve el valor de revisado
    * @return boolean revisado
    */
    public boolean isRevisado() {
        return revisado;
    }

    /**
    * Setter de revisado
    * @param revisado
    */
    public void setRevisado(boolean revisado) {
        this.revisado = revisado;
    }

    /**
    * Delvuelve el valor del campo activo
    * @return boolean activo
    */
    public boolean isActivo() {
        return activo;
    }

    /**
    * Setter de activo
    * @param activo
    */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
    * Devuelve el calor del campo comprado
    * @return boolean comprado
    */
    public boolean isComprado() {
        return comprado;
    }

    /**
    * Setter de comprado
    * @param comprado
    */
    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }

    /**
    * Getter de la fecha de compra
    * @return Date fechaCompra
    */
    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    /**
    * Setter de la fecha de compra
    * @param fechaCompra
    */
    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    /**
    * Getter de las estrellas del vendedor
    * @return int estrellasVend
    */
    public int getEstrellasVend() {
        return estrellasVend;
    }

    /**
    * Setter de las estrellas del vendedor
    * @param estrellasVend
    */
    public void setEstrellasVend(int estrellasVend) {
        this.estrellasVend = estrellasVend;
    }

     /**
    * Getter de las estrellas del comprador
    * @return int estrellasVend
    */
    public int getEstrellasComp() {
        return estrellasComp;
    }
    
    /**
    * Setter de las estrellas del comprador
    * @param estrellasComp
    */
    public void setEstrellasComp(int estrellasComp) {
        this.estrellasComp = estrellasComp;
    }
    
    /**
    * Getter de comentario
    * @return String comentario
    */
    public String getComentario() {
        return comentario;
    }

    /**
    * Setter de comentario 
    * @param comentario
    */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
    * Getter de comentarioAprobado
    * @return boolean comenatarioAprobado
    */
    public boolean getComentarioAprobado() {
        return comentarioAprobado;
    }

    /**
    * Setter de comentarioAprobado
    * @param comentarioAprobado
    */
    public void setComentarioAprobado(boolean comentarioAprobado) {
        this.comentarioAprobado = comentarioAprobado;
    }
    
    /**
    * Getter del nombre del anuncio
    * @return String nombre
    */
    public String getNombre() {
        return this.nombre;
    }

    /**
    * Setter del nombre del anuncio
    * @param nombre
    */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
    * Getter de precio
    * @return double precio
    */
    public double getPrecio() {
        return this.precio;
    }

    /**
    * Setter de precio
    * @param precio
    */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
