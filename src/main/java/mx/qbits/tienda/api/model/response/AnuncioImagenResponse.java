/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     mx.qbits.tienda.api.model.response
 * Proyecto:    tienda
 * Tipo:        Clase
 * Nombre:      AnuncioImagenResponse
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:02:08
 */
package mx.qbits.tienda.api.model.response;

import java.util.Objects;

/**
 * POJO asociado a la entidad 'anuncio_imagen' para mostrar el detalle de la imagen.
 *
 * @author Javier Chávez Barrios
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class AnuncioImagenResponse {

    /**
     * Atributos de clase.
     */
    private Integer idImagen;
    private Integer idAnuncio;
    private String uuid;
    private Integer idTipo;
    private Boolean principal;

    /**
     * <p>Constructor for AnuncioImagenResponse.</p>
     */
    public AnuncioImagenResponse() {
    }

    /**
     * <p>Constructor for AnuncioImagenResponse.</p>
     *
     * @param idImagen a {@link java.lang.Integer} object.
     * @param idAnuncio a {@link java.lang.Integer} object.
     * @param uuid a {@link java.lang.String} object.
     * @param idTipo a {@link java.lang.Integer} object.
     * @param principal a {@link java.lang.Boolean} object.
     */
    public AnuncioImagenResponse(Integer idImagen, Integer idAnuncio, String uuid, Integer idTipo, Boolean principal) {
        this.idImagen = idImagen;
        this.idAnuncio = idAnuncio;
        this.uuid = uuid;
        this.idTipo = idTipo;
        this.principal = principal;
    }

    /**
     * <p>Getter for the field <code>idAnuncio</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getIdAnuncio() {
        return idAnuncio;
    }

    /**
     * <p>Setter for the field <code>idAnuncio</code>.</p>
     *
     * @param idAnuncio a {@link java.lang.Integer} object.
     */
    public void setIdAnuncio(Integer idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    /**
     * <p>Getter for the field <code>idImagen</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getIdImagen() {
        return idImagen;
    }

    /**
     * <p>Setter for the field <code>idImagen</code>.</p>
     *
     * @param idImagen a {@link java.lang.Integer} object.
     */
    public void setIdImagen(Integer idImagen) {
        this.idImagen = idImagen;
    }

    /**
     * <p>Getter for the field <code>uuid</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * <p>Setter for the field <code>uuid</code>.</p>
     *
     * @param uuid a {@link java.lang.String} object.
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * <p>Getter for the field <code>idTipo</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getIdTipo() {
        return idTipo;
    }

    /**
     * <p>Setter for the field <code>idTipo</code>.</p>
     *
     * @param idTipo a {@link java.lang.Integer} object.
     */
    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    /**
     * <p>Getter for the field <code>principal</code>.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getPrincipal() {
        return principal;
    }

    /**
     * <p>Setter for the field <code>principal</code>.</p>
     *
     * @param principal a {@link java.lang.Boolean} object.
     */
    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idAnuncio == null) ? 0 : idAnuncio.hashCode());
        result = prime * result + ((idImagen == null) ? 0 : idImagen.hashCode());
        result = prime * result + ((idTipo == null) ? 0 : idTipo.hashCode());
        result = prime * result + ((principal == null) ? 0 : principal.hashCode());
        result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnuncioImagenResponse)) return false;
        AnuncioImagenResponse that = (AnuncioImagenResponse) o;
        return Objects.equals(idImagen, that.idImagen) && Objects.equals(idAnuncio, that.idAnuncio) &&
                Objects.equals(uuid, that.uuid) && Objects.equals(idTipo, that.idTipo) &&
                Objects.equals(principal, that.principal);
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "AnuncioImagenResponse [idImagen=" + idImagen + ", idAnuncio=" + idAnuncio + ", uuid=" + uuid
                + ", idTipo=" + idTipo + ", principal=" + principal + "]";
    }

}
