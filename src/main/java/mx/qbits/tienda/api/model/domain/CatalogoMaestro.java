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
 * Nombre:      CatalogoMaestro
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 28 Nov 2021 @ 07:50:49
 */
package mx.qbits.tienda.api.model.domain;

/**
 * Implementacion del POJO de la entidad de {@link mx.qbits.tienda.api.model.domain.CatalogoMaestro}.
 *
 * @author Juan Carlos Bautista Sandoval
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class CatalogoMaestro {

    /**
     * Atributos de clase.
     */
    private int id;
    private String tipoCatalogo;

    /**
     * Constructor por omision.
     */
    public CatalogoMaestro() {
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     * @param id a int.
     * @param tipoCatalogo a {@link java.lang.String} object.
     */
    public CatalogoMaestro(int id, String tipoCatalogo) {
        this.id = id;
        this.tipoCatalogo = tipoCatalogo;
    }

    /**
     * <p>Getter for the field <code>id</code>.</p>
     * @return a int.
     */
    public int getId() {
        return id;
    }

    /**
     * <p>Setter for the field <code>id</code>.</p>
     * @param id a int.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * <p>Getter for the field <code>tipoCatalogo</code>.</p>
     * @return a {@link java.lang.String} object.
     */
    public String getTipoCatalogo() {
        return tipoCatalogo;
    }

    /**
     * <p>Setter for the field <code>tipoCatalogo</code>.</p>
     * @param tipoCatalogo a {@link java.lang.String} object.
     */
    public void setTipoCatalogo(String tipoCatalogo) {
        this.tipoCatalogo = tipoCatalogo;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((tipoCatalogo == null) ? 0 : tipoCatalogo.hashCode());
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
        CatalogoMaestro other = (CatalogoMaestro) obj;
        if (id != other.id)
            return false;
        if (tipoCatalogo == null) {
            if (other.tipoCatalogo != null)
                return false;
        } else if (!tipoCatalogo.equals(other.tipoCatalogo))
            return false;
        return true;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "CatalogoMaestro [id=" + id + ", tipoCatalogo=" + tipoCatalogo + "]";
    }
    
}
