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
 * Nombre:      CatalogoJCatalogoMaestroRequest
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 12 Dic 2021 @ 08:00:59
 */
package mx.qbits.tienda.api.model.request;

/**
 * <p>CatalogoJCatalogoRequest class.</p>
 *
 * @author Ricardo Rubén González García
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class CatalogoJCatalogoMaestroRequest {
    String nombreCatalogo;
    String nombreCatalogoMaestro;

    /**
     * Constructor por omision.
     */
    public CatalogoJCatalogoMaestroRequest() {
    }

    /**
     * Constructor basado en los atributos de clase.
     * @param nombreCatalogo String, el cual contiene el nombre del catalogo.
     * @param nombreCatalogoMaestro String, el cual contiene el nombre del catalogo Maestro.
     */
    public CatalogoJCatalogoMaestroRequest(String nombreCatalogo, String nombreCatalogoMaestro) {
        this.nombreCatalogo = nombreCatalogo;
        this.nombreCatalogoMaestro = nombreCatalogoMaestro;
    }

    /**
     * <p>Getter for the field <code>nombreCatalogo</code>.</p>
     * @return a {@link java.lang.String} object.
     */
    public String getNombreCatalogo() {
        return nombreCatalogo;
    }

    /**
     * <p>Setter for the field <code>nombreCatalogo</code>.</p>
     * @param nombreCatalogo a {@link java.lang.String} object.
     */
    public void setNombreCatalogo(String nombreCatalogo) {
        this.nombreCatalogo = nombreCatalogo;
    }

    /**
     * <p>Getter for the field <code>nombreCatalogoMaestro</code>.</p>
     * @return a {@link java.lang.String} object.
     */
    public String getNombreCatalogoMaestro() {
        return nombreCatalogoMaestro;
    }

    /**
     * <p>Setter for the field <code>nombreCatalogoMaestro</code>.</p>
     * @param nombreCatalogoMaestro a {@link java.lang.String} object.
     */
    public void setNombreCatalogoMaestro(String nombreCatalogoMaestro) {
        this.nombreCatalogoMaestro = nombreCatalogoMaestro;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombreCatalogo == null) ? 0 : nombreCatalogo.hashCode());
        result = prime * result + ((nombreCatalogoMaestro == null) ? 0 : nombreCatalogoMaestro.hashCode());
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
        CatalogoJCatalogoMaestroRequest other = (CatalogoJCatalogoMaestroRequest) obj;
        if (nombreCatalogo == null) {
            if (other.nombreCatalogo != null)
                return false;
        } else if (!nombreCatalogo.equals(other.nombreCatalogo))
            return false;
        if (nombreCatalogoMaestro == null) {
            if (other.nombreCatalogoMaestro != null)
                return false;
        } else if (!nombreCatalogoMaestro.equals(other.nombreCatalogoMaestro))
            return false;
        return true;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "CatalogoJCatalogoMaestroRequest [nombreCatalogo=" + nombreCatalogo + ", nombreCatalogoMaestro="
                + nombreCatalogoMaestro + "]";
    }

}
