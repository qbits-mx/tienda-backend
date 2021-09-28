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
 * Nombre:      UploadModel
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 07:53:03
 */
package mx.qbits.tienda.api.model.domain;

import java.util.Date;

/**
 * Clase que modela la estructura de datos que será empleada para registrar una carga de un archivo
 * al sistema. La variable md5 representa el digest MD5 asociado a los bytes del archivo cargado.
 *
 * @author garellano
 * @version $Id: $Id
 */
public class UploadModel {

    /*
     * Atributos de clase.
     */
    private int id;
    private String nombreOriginal;
    private String nuevoNombre;
    private String md5;
    private Date fechaCarga;
    private long peso;
    private boolean activo;

    /**
     * Constructor por default (sin parámetros).
     */
    public UploadModel() {
    }

    /**
     * Constructor basado en parámetros de la clase.
     *
     * @param id a int.
     * @param nombreOriginal a {@link java.lang.String} object.
     * @param nuevoNombre a {@link java.lang.String} object.
     * @param md5 a {@link java.lang.String} object.
     * @param fechaCarga a {@link java.util.Date} object.
     * @param peso a long.
     * @param activo a boolean.
     */
    public UploadModel(int id, String nombreOriginal, String nuevoNombre, String md5, Date fechaCarga, long peso, boolean activo) {
        this.id = id;
        this.nombreOriginal = nombreOriginal;
        this.nuevoNombre = nuevoNombre;
        this.md5 = md5;
        this.fechaCarga = fechaCarga;
        this.peso = peso;
        this.activo = activo;
    }

    /*
     * Setter y Getter.
     */
    /**
     * <p>Getter for the field <code>id</code>.</p>
     *
     * @return a int.
     */
    public int getId() {
        return id;
    }
    /**
     * <p>Setter for the field <code>id</code>.</p>
     *
     * @param id a int.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * <p>Getter for the field <code>nombreOriginal</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getNombreOriginal() {
        return nombreOriginal;
    }
    /**
     * <p>Setter for the field <code>nombreOriginal</code>.</p>
     *
     * @param nombreOriginal a {@link java.lang.String} object.
     */
    public void setNombreOriginal(String nombreOriginal) {
        this.nombreOriginal = nombreOriginal;
    }
    /**
     * <p>Getter for the field <code>nuevoNombre</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getNuevoNombre() {
        return nuevoNombre;
    }
    /**
     * <p>Setter for the field <code>nuevoNombre</code>.</p>
     *
     * @param nuevoNombre a {@link java.lang.String} object.
     */
    public void setNuevoNombre(String nuevoNombre) {
        this.nuevoNombre = nuevoNombre;
    }
    /**
     * <p>Getter for the field <code>md5</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getMd5() {
        return md5;
    }
    /**
     * <p>Setter for the field <code>md5</code>.</p>
     *
     * @param md5 a {@link java.lang.String} object.
     */
    public void setMd5(String md5) {
        this.md5 = md5;
    }
    /**
     * <p>Getter for the field <code>fechaCarga</code>.</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getFechaCarga() {
        return fechaCarga;
    }
    /**
     * <p>Setter for the field <code>fechaCarga</code>.</p>
     *
     * @param fechaCarga a {@link java.util.Date} object.
     */
    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }
    /**
     * <p>Getter for the field <code>peso</code>.</p>
     *
     * @return a long.
     */
    public long getPeso() {
        return peso;
    }
    /**
     * <p>Setter for the field <code>peso</code>.</p>
     *
     * @param peso a long.
     */
    public void setPeso(long peso) {
        this.peso = peso;
    }
    /**
     * <p>isActivo.</p>
     *
     * @return a boolean.
     */
    public boolean isActivo() {
        return activo;
    }
    /**
     * <p>Setter for the field <code>activo</code>.</p>
     *
     * @param activo a boolean.
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "UploadModel [id=" + id + ", nombreOriginal=" + nombreOriginal + ", nuevoNombre=" + nuevoNombre
                + ", md5=" + md5 + ", fechaCarga=" + fechaCarga + ", peso=" + peso + ", activo=" + activo + "]";
    }
}
