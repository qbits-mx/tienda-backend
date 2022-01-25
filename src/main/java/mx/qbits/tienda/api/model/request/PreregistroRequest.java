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
 * Nombre:      PreregistroRequest
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:01:44
 */
package mx.qbits.tienda.api.model.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * <p>PreregistroRequest class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 */
public class PreregistroRequest {
    private int id;
    @ApiModelProperty(example = "superboy")
    @Size(message = "El nick debe medir entre 3 y 15 caracteres", min=3, max=15)
    private String nick;

    @ApiModelProperty(example = "example@hotmail.com")
    @NotBlank(message = "El correo es un dato requerido")
    @Email(message = "El correo electrónico proporcionado es inválido")
    private String correo;

    @ApiModelProperty(example = "12345678aA")
    @NotNull(message = "La clave no puede ser nula")
    @Pattern(regexp = "^(?=.*\\d)(?!.* )(?=.*[a-z])(?=.*[A-Z]).{8,30}$",
            message = "La clave debe tener al menos 1 número, 1 letra minuscula y una letra mayucula y no debe de " +
                    "contener espacios. Además debe tener de 8 a 30 caracteres")
    private String claveHash = "";

    @ApiModelProperty(example = "5543562126")
    //@Pattern(regexp="^\\d{10}$", message = "Teléfono inválido, deben ser exactamente 10 números sin expacios")
    private String telefono;

    private String randomString;

    private long instanteRegistro;

    @ApiModelProperty(example = "1997")
    @Max(message = "El año debe ser menor o igual a 2001", value = 2001)
    @Min(message = "El año debe ser mayor o igual a 1900", value = 1900)
    private int year;

    @ApiModelProperty(example = "10")
    @Max(message = "El mes debe ser menor o igual a 12", value = 12)
    @Min(message = "El mes debe ser mayor o igual a 1", value = 1)
    private int month;

    @ApiModelProperty(example = "23")
    @Max(message = "El dia debe ser menor o igual a 31", value = 31)
    @Min(message = "El dia debe ser mayor o igual a 1", value = 1)
    private int day;

    /**
     * <p>Constructor for PreregistroRequest.</p>
     */
    public PreregistroRequest() {
    }

    /**
     * <p>Constructor for PreregistroRequest.</p>
     *
     * @param id a int.
     * @param nick a {@link java.lang.String} object.
     * @param correo a {@link java.lang.String} object.
     * @param claveHash a {@link java.lang.String} object.
     * @param telefono a {@link java.lang.String} object.
     * @param randomString a {@link java.lang.String} object.
     * @param instanteRegistro a long.
     * @param year a int.
     * @param month a int.
     * @param day a int.
     */
    public PreregistroRequest(
            int id,
            @Size(message = "El nick debe medir entre 3 y 15 caracteres", min=3, max=15) String nick,
            @NotBlank(message = "El correo es un dato requerido") @Email(message = "El correo electrónico proporcionado es inválido") String correo,
            @NotNull(message = "La clave no puede ser nula") @Pattern(regexp = "^(?=.*\\d)(?!.* )(?=.*[a-z])(?=.*[A-Z]).{8,30}$", message = "La clave debe tener al menos 1 número, 1 letra minuscula y una letra mayucula y no debe de contener espacios. Además debe tener de 8 a 30 caracteres") String claveHash,
            @Pattern(regexp = "^\\d{10}$", message = "Teléfono inválido, deben ser exactamente 10 números sin expacios") String telefono,
            String randomString,
            long instanteRegistro,
            @Max(message = "El año debe ser menor a 2021", value = 2001) int year,
            @Max(message = "El mes debe ser menor a 12", value = 12) int month,
            @Max(message = "El año debe ser menor a 31", value = 31) int day) {
        this.id = id;
        this.nick = nick;
        this.correo = correo;
        this.claveHash = claveHash;
        this.telefono = telefono;
        this.randomString = randomString;
        this.instanteRegistro = instanteRegistro;
        this.year = year;
        this.month = month;
        this.day = day;
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

    /**
     * <p>Getter for the field <code>year</code>.</p>
     *
     * @return a int.
     */
    public int getYear() {
        return year;
    }

    /**
     * <p>Setter for the field <code>year</code>.</p>
     *
     * @param year a int.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * <p>Getter for the field <code>month</code>.</p>
     *
     * @return a int.
     */
    public int getMonth() {
        return month;
    }

    /**
     * <p>Setter for the field <code>month</code>.</p>
     *
     * @param month a int.
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * <p>Getter for the field <code>day</code>.</p>
     *
     * @return a int.
     */
    public int getDay() {
        return day;
    }

    /**
     * <p>Setter for the field <code>day</code>.</p>
     *
     * @param day a int.
     */
    public void setDay(int day) {
        this.day = day;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "PreregistroRequest [id=" + id + ", nick=" + nick + ", correo=" + correo + ", claveHash=" + claveHash
                + ", telefono=" + telefono + ", randomString=" + randomString + ", instanteRegistro=" + instanteRegistro
                + ", year=" + year + ", month=" + month + ", day=" + day + "]";
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((claveHash == null) ? 0 : claveHash.hashCode());
        result = prime * result + ((correo == null) ? 0 : correo.hashCode());
        result = prime * result + day;
        result = prime * result + id;
        result = prime * result + (int) (instanteRegistro ^ (instanteRegistro >>> 32));
        result = prime * result + month;
        result = prime * result + ((nick == null) ? 0 : nick.hashCode());
        result = prime * result + ((randomString == null) ? 0 : randomString.hashCode());
        result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
        result = prime * result + year;
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PreregistroRequest)) return false;
        PreregistroRequest that = (PreregistroRequest) o;
        return id == that.id && instanteRegistro == that.instanteRegistro && year == that.year && month == that.month &&
                day == that.day && Objects.equals(nick, that.nick) && Objects.equals(correo, that.correo) &&
                Objects.equals(claveHash, that.claveHash) && Objects.equals(telefono, that.telefono) &&
                Objects.equals(randomString, that.randomString);
    }

    public int getHash() {
        return this.hashCode();
    }
    
}
