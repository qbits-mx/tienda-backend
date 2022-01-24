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
 * Nombre:      Paqueteria
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 28 Nov 2021 @ 07:50:49
 */
package mx.qbits.tienda.api.model.domain;

/**
 * Implementacion del POJO de la entidad de {@link mx.qbits.tienda.api.model.domain.Catalogo}.
 *
 * @author Juan Carlos Bautista Sandoval
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class Catalogo {

    /**
     * Atributos de clase.
     */
    private int id;
    private int idCatalogoCategoria;
    private boolean activo;
    private String nombre;
    
    /**
     * Constructor por omision.
     */
    public Catalogo() {
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     * @param id a int.
     * @param idCatalogoCategoria a int
     * @param activo a boolean
     * @param nombre a {@link java.lang.String} object.
     */
    public Catalogo(int id, int idCatalogoCategoria, boolean activo, String nombre) {
        this.id = id;
        this.idCatalogoCategoria = idCatalogoCategoria;
        this.activo = activo;
        this.nombre = nombre;
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
     * <p>Getter for the field <code>idCatalogoCategoria</code>.</p>
     * @return a int.
     */
    public int getIdCatalogoCategoria() {
        return idCatalogoCategoria;
    }

    /**
     * <p>Setter for the field <code>idCatalogoCategoria</code>.</p>
     * @param id a int.
     */
    public void setIdCatalogoCategoria(int idCatalogoCategoria) {
        this.idCatalogoCategoria = idCatalogoCategoria;
    }

    /**
     * <p>Getter for the field <code>activo</code>.</p>
     * @return a boolean
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * <p>Setter for the field <code>activo</code>.</p>
     * @param activo a boolean.
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * <p>Getter for the field <code>nombre</code>.</p>
     * @return a {@link java.lang.String} object.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * <p>Setter for the field <code>nombre</code>.</p>
     * @param nombre a {@link java.lang.String} object.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (activo ? 1231 : 1237);
        result = prime * result + id;
        result = prime * result + idCatalogoCategoria;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
        Catalogo other = (Catalogo) obj;
        if (activo != other.activo)
            return false;
        if (id != other.id)
            return false;
        if (idCatalogoCategoria != other.idCatalogoCategoria)
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "Catalogo [activo=" + activo + ", id=" + id + ", idCatalogoCategoria=" + idCatalogoCategoria
                + ", nombre=" + nombre + "]";
    }

}
