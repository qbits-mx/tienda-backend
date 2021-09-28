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
 * Nombre:      Municipio
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 07:50:21
 */
package mx.qbits.tienda.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * POJO asociado a la entidad 'municipio'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class Municipio implements Serializable {
    private static final long serialVersionUID = 5007490559310553080L;

    /*
     * Atributos de la clase
     */
    private Integer id;
    private int idEstado;
    private String nombre;
    private String nombrePais;
    private String nombreEstado;

    /**
     * Constructor por default (sin parámetros).
     */
    public Municipio() {
    }

    /**
     * Constructor basado en la llave primaria.
     *
     * @param id a {@link java.lang.Integer} object.
     */
    public Municipio(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     *
     * @param id a {@link java.lang.Integer} object.
     * @param idEstado a int.
     * @param nombre a {@link java.lang.String} object.
     */
    public Municipio(Integer id, int idEstado, String nombre) {
        this.id = id;
        this.idEstado = idEstado;
        this.nombre = nombre;
    }

    /**
     * Constructor basado en atributos temporales para el nombre del Estado.
     *
     * @param id a {@link java.lang.Integer} object.
     * @param idEstado a int.
     * @param nombre a {@link java.lang.String} object.
     * @param nombrePais a {@link java.lang.String} object.
     * @param nombreEstado a {@link java.lang.String} object.
     */
    public Municipio(Integer id, int idEstado, String nombre, String nombrePais, String nombreEstado) {
        this.id = id;
        this.idEstado = idEstado;
        this.nombre = nombre;
        this.nombrePais = nombrePais;
        this.nombreEstado = nombreEstado;
    }

    /*
     * Getter y Setter.
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
     * <p>Getter for the field <code>idEstado</code>.</p>
     *
     * @return a int.
     */
    public int getIdEstado() {
        return idEstado;
    }

    /**
     * <p>Setter for the field <code>idEstado</code>.</p>
     *
     * @param idEstado a int.
     */
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
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
     * <p>Getter for the field <code>nombrePais</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getNombrePais() {
        return nombrePais;
    }

    /**
     * <p>Setter for the field <code>nombrePais</code>.</p>
     *
     * @param nombrePais a {@link java.lang.String} object.
     */
    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    /**
     * <p>Getter for the field <code>nombreEstado</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getNombreEstado() {
        return nombreEstado;
    }

    /**
     * <p>Setter for the field <code>nombreEstado</code>.</p>
     *
     * @param nombreEstado a {@link java.lang.String} object.
     */
    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "[Municipio] : ["
                + " id =" + this.id
                + " idEstado =" + this.idEstado
                + " nombre =" + this.nombre
                + " nombrePais =" + this.nombrePais
                + " nombreEstado =" + this.nombreEstado
                + "]";
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) obj;
        return
               id == other.id &&
               idEstado == other.idEstado &&
               nombre == other.nombre;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            idEstado,
            nombre
        );
    }

}
