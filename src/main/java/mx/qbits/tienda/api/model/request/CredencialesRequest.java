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
 * Nombre:      CredencialesRequest
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:00:43
 */
package mx.qbits.tienda.api.model.request;

/**
 * Implementacion del POJO de la entidad de 'CredencialesRequest'.
 *
 * @author  luz
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class CredencialesRequest {
    private String usuario;
    private String clave;
    /**
     * <p>Constructor for CredencialesRequest.</p>
     */
    public CredencialesRequest() {
    }
    /**
     * <p>Constructor for CredencialesRequest.</p>
     *
     * @param usuario a {@link java.lang.String} object.
     * @param clave a {@link java.lang.String} object.
     */
    public CredencialesRequest(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }
    /**
     * <p>Getter for the field <code>usuario</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getUsuario() {
        return usuario;
    }
    /**
     * <p>Setter for the field <code>usuario</code>.</p>
     *
     * @param usuario a {@link java.lang.String} object.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    /**
     * <p>Getter for the field <code>clave</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getClave() {
        return clave;
    }
    /**
     * <p>Setter for the field <code>clave</code>.</p>
     *
     * @param clave a {@link java.lang.String} object.
     */
    public void setClave(String clave) {
        this.clave = clave;
    }
    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "CredencialesRequest [usuario=" + usuario + ", clave=" + clave + "]";
    }
    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clave == null) ? 0 : clave.hashCode());
        result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
        CredencialesRequest other = (CredencialesRequest) obj;
        if (clave == null) {
            if (other.clave != null)
                return false;
        } else if (!clave.equals(other.clave))
            return false;
        if (usuario == null) {
            if (other.usuario != null)
                return false;
        } else if (!usuario.equals(other.usuario))
            return false;
        return true;
    }
}
