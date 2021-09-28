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
 *              Creación: 5 Sep 2021 @ 07:50:49
 */
package mx.qbits.tienda.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'paqueteria'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class Paqueteria implements Serializable {

    private static final long serialVersionUID = 4781082860740788585L;

    /*
     * Atributos de la clase
     */
    private Integer id;
    private String nombre;
    private String breveDescripcion;
    private String htmlDescripcion;
    private int precio;

    /**
     * Constructor por default (sin parámetros).
     */
    public Paqueteria() {
    }

    /**
     * Constructor basado en la llave primaria.
     *
     * @param id a {@link java.lang.Integer} object.
     */
    public Paqueteria(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     *
     * @param id a {@link java.lang.Integer} object.
     * @param nombre a {@link java.lang.String} object.
     * @param breveDescripcion a {@link java.lang.String} object.
     * @param htmlDescripcion a {@link java.lang.String} object.
     * @param precio a int.
     */
    public Paqueteria(Integer id, String nombre, String breveDescripcion, String htmlDescripcion, int precio) {
        this.id = id;
        this.nombre = nombre;
        this.breveDescripcion = breveDescripcion;
        this.htmlDescripcion = htmlDescripcion;
        this.precio = precio;
    }

    /*
     * Setter y Getter.
     */
    /**
     * <p>Getter for the field <code>id</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getId() {
        return id;
    }

    /**
     * <p>Setter for the field <code>id</code>.</p>
     *
     * @param id a {@link java.lang.Integer} object.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <p>Getter for the field <code>nombre</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * <p>Setter for the field <code>nombre</code>.</p>
     *
     * @param nombre a {@link java.lang.String} object.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * <p>Getter for the field <code>breveDescripcion</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getBreveDescripcion() {
        return breveDescripcion;
    }

    /**
     * <p>Setter for the field <code>breveDescripcion</code>.</p>
     *
     * @param breveDescripcion a {@link java.lang.String} object.
     */
    public void setBreveDescripcion(String breveDescripcion) {
        this.breveDescripcion = breveDescripcion;
    }

    /**
     * <p>Getter for the field <code>htmlDescripcion</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getHtmlDescripcion() {
        return htmlDescripcion;
    }

    /**
     * <p>Setter for the field <code>htmlDescripcion</code>.</p>
     *
     * @param htmlDescripcion a {@link java.lang.String} object.
     */
    public void setHtmlDescripcion(String htmlDescripcion) {
        this.htmlDescripcion = htmlDescripcion;
    }

    /**
     * <p>Getter for the field <code>precio</code>.</p>
     *
     * @return a int.
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * <p>Setter for the field <code>precio</code>.</p>
     *
     * @param precio a int.
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "[Paqueteria] : ["
                + " id =" + this.id
                + " nombre =" + this.nombre
                + " breveDescripcion =" + this.breveDescripcion
                + " htmlDescripcion =" + this.htmlDescripcion
                + " precio =" + this.precio
                + "]";
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Paqueteria)) {
            return false;
        }
        Paqueteria other = (Paqueteria) obj;
        return
               id == other.id &&
               nombre == other.nombre &&
               breveDescripcion == other.breveDescripcion &&
               htmlDescripcion == other.htmlDescripcion &&
               precio == other.precio;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            nombre,
            breveDescripcion,
            htmlDescripcion,
            precio
        );
    }

}
