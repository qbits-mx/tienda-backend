/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.response
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      LoginResponse
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:21:02
 */
package mx.qbits.tienda.api.model.response;

import java.util.Date;
import java.util.List;

import mx.qbits.tienda.api.model.domain.Rol;
import mx.qbits.tienda.api.model.domain.UsuarioDetalle;

/**
 * <p>LoginResponse class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 */
public class LoginResponse {
    private UsuarioDetalle usuarioDetalle;
    private String correo;
    private String jwt;
    private Date ultimoAcceso;
    private List<Rol> roles;

    /**
     * <p>Constructor for LoginResponse.</p>
     */
    public LoginResponse() {
    }

    /**
     * <p>Constructor for LoginResponse.</p>
     *
     * @param usuarioDetalle a {@link io.kebblar.petstore.api.model.domain.UsuarioDetalle} object.
     * @param ultimoAcceso a {@link java.util.Date} object.
     * @param correo a {@link java.lang.String} object.
     * @param jwt a {@link java.lang.String} object.
     * @param roles a {@link java.util.List} object.
     */
    public LoginResponse(
            UsuarioDetalle usuarioDetalle,
            Date ultimoAcceso,
            String correo,
            String jwt,
            List<Rol> roles) {
        this.usuarioDetalle = usuarioDetalle;
        this.ultimoAcceso = ultimoAcceso;
        this.correo = correo;
        this.jwt = jwt;
        this.roles = roles;
    }

    /**
     * <p>Getter for the field <code>usuarioDetalle</code>.</p>
     *
     * @return a {@link io.kebblar.petstore.api.model.domain.UsuarioDetalle} object.
     */
    public UsuarioDetalle getUsuarioDetalle() {
        return usuarioDetalle;
    }

    /**
     * <p>Setter for the field <code>usuarioDetalle</code>.</p>
     *
     * @param usuarioDetalle a {@link io.kebblar.petstore.api.model.domain.UsuarioDetalle} object.
     */
    public void setUsuarioDetalle(UsuarioDetalle usuarioDetalle) {
        this.usuarioDetalle = usuarioDetalle;
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
     * <p>Getter for the field <code>jwt</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getJwt() {
        return jwt;
    }

    /**
     * <p>Setter for the field <code>jwt</code>.</p>
     *
     * @param jwt a {@link java.lang.String} object.
     */
    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    /**
     * <p>Getter for the field <code>ultimoAcceso</code>.</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getUltimoAcceso() {
        return ultimoAcceso;
    }

    /**
     * <p>Setter for the field <code>ultimoAcceso</code>.</p>
     *
     * @param ultimoAcceso a {@link java.util.Date} object.
     */
    public void setUltimoAcceso(Date ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }

    /**
     * <p>Getter for the field <code>roles</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<Rol> getRoles() {
        return roles;
    }

    /**
     * <p>Setter for the field <code>roles</code>.</p>
     *
     * @param roles a {@link java.util.List} object.
     */
    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "LoginResponse [usuarioDetalle=" + usuarioDetalle + ", correo=" + correo + ", jwt=" + jwt
                + ", ultimoAcceso=" + ultimoAcceso + ", roles=" + roles + "]";
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((correo == null) ? 0 : correo.hashCode());
        result = prime * result + ((roles == null) ? 0 : roles.hashCode());
        result = prime * result + ((usuarioDetalle == null) ? 0 : usuarioDetalle.hashCode());
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
        LoginResponse other = (LoginResponse) obj;
        if (correo == null) {
            if (other.correo != null)
                return false;
        } else if (!correo.equals(other.correo))
            return false;
        if (roles == null) {
            if (other.roles != null)
                return false;
        } else if (!roles.equals(other.roles))
            return false;
        if (usuarioDetalle == null) {
            if (other.usuarioDetalle != null)
                return false;
        } else if (!usuarioDetalle.equals(other.usuarioDetalle))
            return false;
        return true;
    }

    /**
     * <p>getHash.</p>
     *
     * @return a long.
     */
    public long getHash() {
        return this.hashCode();
    }

}
