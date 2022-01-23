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
 *              Creación: 12 Dic 2021 @ 07:50:49
 */
package mx.qbits.tienda.api.model.domain;

/**
 * Implementacion del POJO de la entidad de {@link mx.qbits.tienda.api.model.domain.CatalogoJCatalogoMaestro}.
 *
 * @author Ricardo Rubén González García
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class CatalogoJCatalogoMaestro {
    
    private int id;
    private int idMaestro;
    private String tipoCatalogo;
    private String nombre;   
    private boolean activo;
    
    /**
     * Construcotor basado en todos los atributos de la clase.
     * @param id a int
     * @param idMaestro a int
     * @param tipoCatalogo a {@link java.lang.String} object.
     * @param nombre {@link java.lang.String} object.
     * @param activo a boolean.
     */
    public CatalogoJCatalogoMaestro(int id, int idMaestro, String tipoCatalogo, String nombre, boolean activo) {
        this.id = id;
        this.idMaestro = idMaestro;
        this.tipoCatalogo = tipoCatalogo;
        this.nombre = nombre;
        this.activo = activo;
    }

    /**
     * <p>Getter for the field <code>id</code>.</p>
     * @return a int
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
     * <p>Getter for the field <code>idMaestro</code>.</p>
     * @return a int
     */
    public int getIdMaestro() {
        return idMaestro;
    }

    /**
     * <p>Setter for the field <code>idMaestro</code>.</p>
     * @param idMaestro a int.
     */
    public void setIdMaestro(int idMaestro) {
        this.idMaestro = idMaestro;
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

    /**
     * <p>Getter for the field <code>activo</code>.</p>
     * @return a boolean.
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
    
    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (activo ? 1231 : 1237);
        result = prime * result + id;
        result = prime * result + idMaestro;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
        CatalogoJCatalogoMaestro other = (CatalogoJCatalogoMaestro) obj;
        if (activo != other.activo)
            return false;
        if (id != other.id)
            return false;
        if (idMaestro != other.idMaestro)
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (tipoCatalogo == null) {
            if (other.tipoCatalogo != null)
                return false;
        } else if (!tipoCatalogo.equals(other.tipoCatalogo))
            return false;
        return true;
    }

}
