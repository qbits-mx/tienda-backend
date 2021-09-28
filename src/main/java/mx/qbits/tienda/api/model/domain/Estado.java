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
 * Nombre:      Estado
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:22:33
 */
package mx.qbits.tienda.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Implementacion del POJO de la entidad de {@link mx.qbits.tienda.api.model.domain.Estado}.
 *
 * @author  garellano
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class Estado implements Serializable {
    private static final long serialVersionUID = -4082525936309639098L;

    /*
     * Atributos de la clase.
     */
    private Integer id;
    private int idPais;
    private String nombre;
    private String nombrePais;

    /**
     * Constructor por default (sin parámetros).
     */
    public Estado() {
    }

    /**
     * Constructor basado en la llave primaria.
     *
     * @param id a {@link java.lang.Integer} object.
     */
    public Estado(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     *
     * @param id a {@link java.lang.Integer} object.
     * @param idPais a int.
     * @param nombre a {@link java.lang.String} object.
     */
    public Estado(Integer id, int idPais, String nombre) {
        this.id = id;
        this.idPais = idPais;
        this.nombre = nombre;
    }

    /**
     * Constructor basado en atributos temporales para el nombre del Pais.
     *
     * @param id a {@link java.lang.Integer} object.
     * @param idPais a int.
     * @param nombre a {@link java.lang.String} object.
     * @param nombrePais a {@link java.lang.String} object.
     */
    public Estado(Integer id, int idPais, String nombre, String nombrePais) {
        this.id = id;
        this.idPais = idPais;
        this.nombre = nombre;
        this.nombrePais = nombrePais;
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
     * <p>Getter for the field <code>idPais</code>.</p>
     *
     * @return a int.
     */
    public int getIdPais() {
        return idPais;
    }

    /**
     * <p>Setter for the field <code>idPais</code>.</p>
     *
     * @param idPais a int.
     */
    public void setIdPais(int idPais) {
        this.idPais = idPais;
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



    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "[Estado] : ["
                + " id =" + this.id
                + " idPais =" + this.idPais
                + " nombre =" + this.nombre
                + "]";
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) obj;
        return
               id == other.id &&
               idPais == other.idPais &&
               nombre == other.nombre;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            idPais,
            nombre
        );
    }

}
