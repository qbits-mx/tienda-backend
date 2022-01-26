package mx.qbits.tienda.api.model.request;

import java.util.Date;


/**
 * <p>AnuncioRequest class.</p>
 *
 * @author 2 de Pastor
 * @version 1
 */
public class AnuncioRequest {
    private int idUsuario;
    private int idCatalogoCondicion;
    private int idCatalogoFormaDePago;
    private int idCatalogoZonaDeEntrega;
    private int idCatalogoDepartamento;
    private String descripcion;
    private Date vigencia;
    private String contacto;
    private int precio;
    private String nombre;

    /**
    * Constructor por omisión
    */
    public AnuncioRequest() {
    }
    
    /**
    * Constructor con parametros
    * @param int idUsuario
    * @param int idCatalogoCondicion
    * @param int idCatalogoFormaDePago
    * @param int idCatalogoZonaDeEntrega
    * @param int idCatalogoDepartamento
    * @param String descripcion
    * @param Date vigencia
    * @param String contacto
    * @param int precio
    * @param String nombre
    */
    public AnuncioRequest(int idUsuario,
                          int idCatalogoCondicion,
                          int idCatalogoFormaDePago,
                          int idCatalogoZonaDeEntrega,
                          int idCatalogoDepartamento,
                          String descripcion,
                          Date vigencia,
                          String contacto,
                          int precio,
                          String nombre
    ) {

        this.idUsuario = idUsuario;
        this.idCatalogoCondicion = idCatalogoCondicion;
        this.idCatalogoFormaDePago = idCatalogoFormaDePago;
        this.idCatalogoZonaDeEntrega = idCatalogoZonaDeEntrega;
        this.idCatalogoDepartamento = idCatalogoDepartamento;
        this.descripcion = descripcion;
        this.vigencia = vigencia;
        this.contacto = contacto;

    }

    /**
    * Getter de idUsuario 
    * @return int idUsuario
    */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
    * Setter de idUsuario
    * @param int idUsuario
    */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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
    * @param int idCatalogoCondicion
    */
    public void setIdCatalogoCondicion(int idCatalogoCondicion) {
        this.idCatalogoCondicion = idCatalogoCondicion;
    }

    /**
    * Getter de idCatalogoFormaDePago
    * @return int idCatalogoFOrmaDePago
    */
    public int getIdCatalogoFormaDePago() {
        return idCatalogoFormaDePago;
    }

    /**
    * Setter de idCatalogoFormaDePago
    * @param int idCatalogoFormaDePago
    */
    public void setIdCatalogoFormaDePago(int idCatalogoFormaDePago) {
        this.idCatalogoFormaDePago = idCatalogoFormaDePago;
    }

    /**
    * Getter de idCatalogoZonaDeEntrega
    * @return int idCatalogoZonaDeEntrega
    */
    public int getIdCatalogoZonaDeEntrega() {
        return idCatalogoZonaDeEntrega;
    }

    /**
    * Setter de idCatalogoZonaDeEntrega
    * @param int idCatalogoZonaDeEntrega
    */
    public void setIdCatalogoZonaDeEntrega(int idCatalogoZonaDeEntrega) {
        this.idCatalogoZonaDeEntrega = idCatalogoZonaDeEntrega;
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
    * @param int idCatalogoDepartamento
    */
    public void setIdCatalogoDepartamento(int idCatalogoDepartamento) {
        this.idCatalogoDepartamento = idCatalogoDepartamento;
    }

    /**
    * Getter de Descripcion
    * @return String descripcion
    */
    public String getDescripcion() {
        return descripcion;
    }

    /**
    * Setter de Descripcion
    * @param String Descripcion
    */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
    * Getter de Contacto
    * @return String contacto
    */
    public String getContacto() {
        return contacto;
    }

    /**
    * Setter de Contacto
    * @param String Contacto
    */
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    /**
    * Getter de vigencia del Anuncio
    * @return Date vigencia
    */
    public Date getVigenciaAnuncio() {
        return vigencia;
    }

    /**
    * Setter de vigencia del Anuncio
    * @param Date vigencia
    */
    public void setVigenciaAnuncio(Date vigenciaAnuncio) {
        this.vigencia = vigenciaAnuncio;
    }

    /**
    * Getter de precio
    * @return int precio
    */
    public int getPrecio(){
        return precio;
    }
    
    /**
    * Setter de precio
    * @param int precio
    */
    public void setPrecio(int precio){
        this.precio = precio;
    }
    
    /**
    * Getter de nombre
    * @return String nombre
    */
    public String getNombre(){
        return nombre;
    }
    
    /**
    * Setter de nombre
    * @param String nombre
    */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((contacto == null) ? 0 : contacto.hashCode());
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
        result = prime * result + idCatalogoCondicion;
        result = prime * result + idCatalogoDepartamento;
        result = prime * result + idCatalogoFormaDePago;
        result = prime * result + idCatalogoZonaDeEntrega;
        result = prime * result + idUsuario;
        result = prime * result + ((vigencia == null) ? 0 : vigencia.hashCode());
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
        AnuncioRequest other = (AnuncioRequest) obj;
        if (contacto == null) {
            if (other.contacto != null)
                return false;
        } else if (!contacto.equals(other.contacto))
            return false;
        if (descripcion == null) {
            if (other.descripcion != null)
                return false;
        } else if (!descripcion.equals(other.descripcion))
            return false;
        if (idCatalogoCondicion != other.idCatalogoCondicion)
            return false;
        if (idCatalogoDepartamento != other.idCatalogoDepartamento)
            return false;
        if (idCatalogoFormaDePago != other.idCatalogoFormaDePago)
            return false;
        if (idCatalogoZonaDeEntrega != other.idCatalogoZonaDeEntrega)
            return false;
        if (idUsuario != other.idUsuario)
            return false;
        if (vigencia == null) {
            if (other.vigencia != null)
                return false;
        } else if (!vigencia.equals(other.vigencia))
            return false;
        return true;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "AnuncioRequest [idUsuario=" + idUsuario + ", idCatalogoCondicion=" + idCatalogoCondicion
                + ", idCatalogoFormaDePago=" + idCatalogoFormaDePago + ", idCatalogoZonaDeEntrega="
                + idCatalogoZonaDeEntrega + ", idCatalogoDepartamento=" + idCatalogoDepartamento + ", descripcion="
                + descripcion + ", contacto=" + contacto + ", vigenciaAnuncio=" + vigencia + "]";
    }
}
