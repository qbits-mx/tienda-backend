/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.model.request
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      Preregistro
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:01:35
 */
package mx.qbits.tienda.api.model.request;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * <p>Preregistro class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 */
public class Preregistro {
    private int id;
    private String nick;

    @ApiModelProperty(example = "example@hotmail.com")
    @NotBlank(message = "Llénalo, por favor")
    @Email(message = "El correo electrónico proporcionado es inválido")
    private String correo;

    @ApiModelProperty(example = "12345678aA")
    @NotNull(message = "La clave no puede ser nula")
    @Pattern(regexp = "^(?=.*\\d)(?!.* )(?=.*[a-z])(?=.*[A-Z]).{8,30}$",
            message = "La clave debe tener al menos 1 número, 1 letra minuscula y una letra mayucula y no debe de " +
                    "contener espacios. Además debe tener de 8 a 30 caracteres")
    private String claveHash = "";

    @ApiModelProperty(example = "5543562126")
    @Pattern(regexp="^\\d{10}$", message = "Teléfono inválido, deben ser exactamente 10 números sin expacios")
    private String telefono;

    private Date fechaNacimiento;

    private String randomString;

    private long instanteRegistro;

    /**
     * <p>Constructor for Preregistro.</p>
     */
    public Preregistro() {
    }

    /**
     * <p>Constructor for Preregistro.</p>
     *
     * @param id a int.
     * @param nick a {@link java.lang.String} object.
     * @param correo a {@link java.lang.String} object.
     * @param claveHash a {@link java.lang.String} object.
     * @param telefono a {@link java.lang.String} object.
     * @param fechaNacimiento a {@link java.util.Date} object.
     * @param randomString a {@link java.lang.String} object.
     * @param instanteRegistro a long.
     */
    public Preregistro(
            int id,
            String nick,
            String correo,
            String claveHash,
            String telefono,
            Date fechaNacimiento,
            String randomString,
            long instanteRegistro) {
        this.id = id;
        this.nick = nick;
        this.correo = correo;
        this.claveHash = claveHash;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.randomString = randomString;
        this.instanteRegistro = instanteRegistro;
    }

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
     * <p>Getter for the field <code>nick</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getNick() {
        return nick;
    }

    /**
     * <p>Setter for the field <code>nick</code>.</p>
     *
     * @param nick a {@link java.lang.String} object.
     */
    public void setNick(String nick) {
        this.nick = nick;
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
     * <p>Getter for the field <code>claveHash</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getClaveHash() {
        return claveHash;
    }

    /**
     * <p>Setter for the field <code>claveHash</code>.</p>
     *
     * @param claveHash a {@link java.lang.String} object.
     */
    public void setClaveHash(String claveHash) {
        this.claveHash = claveHash;
    }

    /**
     * <p>Getter for the field <code>telefono</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * <p>Setter for the field <code>telefono</code>.</p>
     *
     * @param telefono a {@link java.lang.String} object.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * <p>Getter for the field <code>fechaNacimiento</code>.</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * <p>Setter for the field <code>fechaNacimiento</code>.</p>
     *
     * @param fechaNacimiento a {@link java.util.Date} object.
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * <p>Getter for the field <code>randomString</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getRandomString() {
        return randomString;
    }

    /**
     * <p>Setter for the field <code>randomString</code>.</p>
     *
     * @param randomString a {@link java.lang.String} object.
     */
    public void setRandomString(String randomString) {
        this.randomString = randomString;
    }

    /**
     * <p>Getter for the field <code>instanteRegistro</code>.</p>
     *
     * @return a long.
     */
    public long getInstanteRegistro() {
        return instanteRegistro;
    }

    /**
     * <p>Setter for the field <code>instanteRegistro</code>.</p>
     *
     * @param instanteRegistro a long.
     */
    public void setInstanteRegistro(long instanteRegistro) {
        this.instanteRegistro = instanteRegistro;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "PreRegistroRequest [id=" + id + ", nick=" + nick + ", correo=" + correo + ", claveHash=" + claveHash
                + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", randomString=" + randomString
                + ", instanteRegistro=" + instanteRegistro + "]";
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((claveHash == null) ? 0 : claveHash.hashCode());
        result = prime * result + ((correo == null) ? 0 : correo.hashCode());
        result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
        result = prime * result + id;
        result = prime * result + (int) (instanteRegistro ^ (instanteRegistro >>> 32));
        result = prime * result + ((nick == null) ? 0 : nick.hashCode());
        result = prime * result + ((randomString == null) ? 0 : randomString.hashCode());
        result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Preregistro)) return false;
        Preregistro that = (Preregistro) o;
        return id == that.id && instanteRegistro == that.instanteRegistro && Objects.equals(nick, that.nick) &&
                Objects.equals(correo, that.correo) && Objects.equals(claveHash, that.claveHash) &&
                Objects.equals(telefono, that.telefono) && Objects.equals(fechaNacimiento, that.fechaNacimiento) &&
                Objects.equals(randomString, that.randomString);
    }

    public int getHash() {
        return this.hashCode();
    }
    
}
