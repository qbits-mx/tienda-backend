/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.domain
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      Usuario
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 07:53:22
 */
package mx.qbits.tienda.api.model.domain;

import java.util.Objects;

/**
 * Implementacion del POJO de la entidad de 'Usuario'.
 *
 * @author  garellano
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class Usuario {

    /*
     * Atributos de la clase.
     */
    private int id;
    private String correo;
    private String clave;
    private long creado;
    private boolean activo;
    private int accesoNegadoContador;
    private long instanteBloqueo;
    private long instanteUltimoAcceso;
    private long instanteUltimoCambioClave;
    private String regeneraClaveToken;
    private long regeneraClaveInstante;

    /**
     * Constructor por default (sin parámetros).
     */
    public Usuario() {
    }

    /**
     * Constructor basado en correo y clave con su id.
     *
     * @param id a int.
     * @param correo a {@link java.lang.String} object.
     * @param clave a {@link java.lang.String} object.
     */
    public Usuario(int id, String correo, String clave) {
        this.id = id;
        this.correo = correo;
        this.clave = clave;
        // Default values
        this.activo = true;
        this.accesoNegadoContador = 0;
        this.creado = System.currentTimeMillis();
        this.instanteBloqueo = 0;
        this.instanteUltimoAcceso = 0;
        this.instanteUltimoCambioClave = 0;
        this.regeneraClaveInstante = 0;
        this.regeneraClaveToken = "NA";
    }

    /**
     * Constructor basado en los atributos de la clase.
     *
     * @param id a int.
     * @param correo a {@link java.lang.String} object.
     * @param clave a {@link java.lang.String} object.
     * @param creado a long.
     * @param activo a boolean.
     * @param accesoNegadoContador a int.
     * @param instanteBloqueo a long.
     * @param instanteUltimoAcceso a long.
     * @param instanteUltimoCambioClave a long.
     * @param regeneraClaveToken a {@link java.lang.String} object.
     * @param regeneraClaveInstante a long.
     */
    public Usuario(
            int id,
            String correo,
            String clave,
            long creado,
            boolean activo,
            int accesoNegadoContador,
            long instanteBloqueo,
            long instanteUltimoAcceso,
            long instanteUltimoCambioClave,
            String regeneraClaveToken,
            long regeneraClaveInstante) {
        this.id = id;
        this.correo = correo;
        this.clave = clave;
        this.creado = creado;
        this.activo = activo;
        this.accesoNegadoContador = accesoNegadoContador;
        this.instanteBloqueo = instanteBloqueo;
        this.instanteUltimoAcceso = instanteUltimoAcceso;
        this.instanteUltimoCambioClave = instanteUltimoCambioClave;
        this.regeneraClaveToken = regeneraClaveToken;
        this.regeneraClaveInstante = regeneraClaveInstante;
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
     * <p>Getter for the field <code>correo</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * <p>Setter for the field <code>correo</code>.</p>
     *
     * @param correo a {@link java.lang.String} object.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * <p>Getter for the field <code>clave</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getClave() {
        return this.clave;
    }

    /**
     * <p>Setter for the field <code>clave</code>.</p>
     *
     * @param clave a {@link java.lang.String} object.
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * <p>Getter for the field <code>creado</code>.</p>
     *
     * @return a long.
     */
    public long getCreado() {
        return creado;
    }

    /**
     * <p>Setter for the field <code>creado</code>.</p>
     *
     * @param creado a long.
     */
    public void setCreado(long creado) {
        this.creado = creado;
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

    /**
     * <p>Getter for the field <code>accesoNegadoContador</code>.</p>
     *
     * @return a int.
     */
    public int getAccesoNegadoContador() {
        return accesoNegadoContador;
    }

    /**
     * <p>Setter for the field <code>accesoNegadoContador</code>.</p>
     *
     * @param accesoNegadoContador a int.
     */
    public void setAccesoNegadoContador(int accesoNegadoContador) {
        this.accesoNegadoContador = accesoNegadoContador;
    }

    /**
     * <p>Getter for the field <code>instanteBloqueo</code>.</p>
     *
     * @return a long.
     */
    public long getInstanteBloqueo() {
        return instanteBloqueo;
    }

    /**
     * <p>Setter for the field <code>instanteBloqueo</code>.</p>
     *
     * @param instanteBloqueo a long.
     */
    public void setInstanteBloqueo(long instanteBloqueo) {
        this.instanteBloqueo = instanteBloqueo;
    }

    /**
     * <p>Getter for the field <code>instanteUltimoAcceso</code>.</p>
     *
     * @return a long.
     */
    public long getInstanteUltimoAcceso() {
        return instanteUltimoAcceso;
    }

    /**
     * <p>Setter for the field <code>instanteUltimoAcceso</code>.</p>
     *
     * @param instanteUltimoAcceso a long.
     */
    public void setInstanteUltimoAcceso(long instanteUltimoAcceso) {
        this.instanteUltimoAcceso = instanteUltimoAcceso;
    }

    /**
     * <p>Getter for the field <code>instanteUltimoCambioClave</code>.</p>
     *
     * @return a long.
     */
    public long getInstanteUltimoCambioClave() {
        return instanteUltimoCambioClave;
    }

    /**
     * <p>Setter for the field <code>instanteUltimoCambioClave</code>.</p>
     *
     * @param instanteUltimoCambioClave a long.
     */
    public void setInstanteUltimoCambioClave(long instanteUltimoCambioClave) {
        this.instanteUltimoCambioClave = instanteUltimoCambioClave;
    }

    /**
     * <p>Getter for the field <code>regeneraClaveToken</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getRegeneraClaveToken() {
        return regeneraClaveToken;
    }

    /**
     * <p>Setter for the field <code>regeneraClaveToken</code>.</p>
     *
     * @param regeneraClaveToken a {@link java.lang.String} object.
     */
    public void setRegeneraClaveToken(String regeneraClaveToken) {
        this.regeneraClaveToken = regeneraClaveToken;
    }

    /**
     * <p>Getter for the field <code>regeneraClaveInstante</code>.</p>
     *
     * @return a long.
     */
    public long getRegeneraClaveInstante() {
        return regeneraClaveInstante;
    }

    /**
     * <p>Setter for the field <code>regeneraClaveInstante</code>.</p>
     *
     * @param regeneraClaveInstante a long.
     */
    public void setRegeneraClaveInstante(long regeneraClaveInstante) {
        this.regeneraClaveInstante = regeneraClaveInstante;
    }

    /**
     * Método especial (y adicional) de soporte al proceso de pruebas de regresión.
     *
     * @return a long.
     */
    public long getHash() {
        return this.hashCode();
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "Usuario [id=" + id + ", correo=" + correo + ", clave=" + clave + ", creado=" + creado + ", activo="
                + activo + ", accesoNegadoContador=" + accesoNegadoContador + ", instanteBloqueo=" + instanteBloqueo
                + ", instanteUltimoAcceso=" + instanteUltimoAcceso + ", instanteUltimoCambioClave="
                + instanteUltimoCambioClave + ", regeneraClaveToken=" + regeneraClaveToken + ", regeneraClaveInstante="
                + regeneraClaveInstante + "]";
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + accesoNegadoContador;
        result = prime * result + (activo ? 1231 : 1237);
        result = prime * result + ((clave == null) ? 0 : clave.hashCode());
        result = prime * result + ((correo == null) ? 0 : correo.hashCode());
        result = prime * result + (int) (creado ^ (creado >>> 32));
        result = prime * result + id;
        result = prime * result + (int) (instanteBloqueo ^ (instanteBloqueo >>> 32));
        result = prime * result + (int) (instanteUltimoAcceso ^ (instanteUltimoAcceso >>> 32));
        result = prime * result + (int) (instanteUltimoCambioClave ^ (instanteUltimoCambioClave >>> 32));
        result = prime * result + (int) (regeneraClaveInstante ^ (regeneraClaveInstante >>> 32));
        result = prime * result + ((regeneraClaveToken == null) ? 0 : regeneraClaveToken.hashCode());
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id && creado == usuario.creado && activo == usuario.activo &&
                accesoNegadoContador == usuario.accesoNegadoContador && instanteBloqueo == usuario.instanteBloqueo &&
                instanteUltimoAcceso == usuario.instanteUltimoAcceso &&
                instanteUltimoCambioClave == usuario.instanteUltimoCambioClave &&
                regeneraClaveInstante == usuario.regeneraClaveInstante && Objects.equals(correo, usuario.correo) &&
                Objects.equals(clave, usuario.clave) && Objects.equals(regeneraClaveToken, usuario.regeneraClaveToken);
    }
}
