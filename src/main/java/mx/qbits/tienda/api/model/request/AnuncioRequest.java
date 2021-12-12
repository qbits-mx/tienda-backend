
package mx.qbits.tienda.api.model.request;

import java.util.Date;

public class AnuncioRequest {
    private int idUsuario;
    private int idCatalogoCondicion;
    private int idCatalogoFormaDePago;
    private int idCatalogoZonaDeEntrega;
    private int idCatalogoDepartamento;
    private String descripcion;
    private Date vigencia;
    private String contacto;


    public AnuncioRequest() {
    }

    public AnuncioRequest(int idUsuario,
                          int idCatalogoCondicion,
                          int idCatalogoFormaDePago,
                          int idCatalogoZonaDeEntrega,
                          int idCatalogoDepartamento,
                          String descripcion,
                          Date vigencia,
                          String contacto
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public Date getVigenciaAnuncio() {
        return vigencia;
    }

    public void setVigenciaAnuncio(Date vigenciaAnuncio) {
        this.vigencia = vigenciaAnuncio;
    }

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

    @Override
    public String toString() {
        return "AnuncioRequest [idUsuario=" + idUsuario + ", idCatalogoCondicion=" + idCatalogoCondicion
                + ", idCatalogoFormaDePago=" + idCatalogoFormaDePago + ", idCatalogoZonaDeEntrega="
                + idCatalogoZonaDeEntrega + ", idCatalogoDepartamento=" + idCatalogoDepartamento + ", descripcion="
                + descripcion + ", contacto=" + contacto + ", vigenciaAnuncio=" + vigencia + "]";
    }






}