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
 * Nombre:      EstatusAnuncio
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:22:45
 */
package mx.qbits.tienda.api.model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'estatus_anuncio'.
 *
 * @author Fhernanda Romo
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class EstatusAnuncio implements Serializable {

    private static final long serialVersionUID = -3861741201718250311L;

    /*
     * Atributos de la clase
     */
    private Integer id;
    private String descripcion;

    /**
     * Constructor por default (sin parámetros).
     */
    public EstatusAnuncio() {
    }

    /**
     * Constructor basado en la llave primaria.
     *
     * @param id a {@link java.lang.Integer} object.
     */
    public EstatusAnuncio(Integer id) {
        this.id = id;
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     *
     * @param id a {@link java.lang.Integer} object.
     * @param descripcion a {@link java.lang.String} object.
     */
    public EstatusAnuncio(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
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
     * <p>Getter for the field <code>descripcion</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * <p>Setter for the field <code>descripcion</code>.</p>
     *
     * @param descripcion a {@link java.lang.String} object.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "[EstatusAnuncio] : ["
                + " id =" + this.id
                + " descripcion =" + this.descripcion
                + "]";
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EstatusAnuncio)) {
            return false;
        }
        EstatusAnuncio other = (EstatusAnuncio) obj;
        return
               id == other.id &&
               descripcion == other.descripcion;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            descripcion
        );
    }

}
