package mx.qbits.tienda.api.model.domain;

import java.sql.Date;
import java.util.Objects;

/**
 * Implementación del POJO de la entidad 'Compra'
 *
 * @author pum4Developer$
 * @version 0.1.1-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class Compra {

	/*
     * Atributos de la clase.
     */
	private int id;
	private int idUsuario;
	private int idComprador;
	private int idCatalogoCondicion;
	private int idCatalogoFormaPago;
	private int idCatalogoZonaEntrega;
	private int idCatalogoDepartamento;
	private String descripcion;
	private Date vigencia;
	private String datosContacto;
	private boolean validado;
	private boolean notificado;
	private boolean revisado;
	private boolean activo;
	private boolean comprado;
	private Date fechaCompra;
	private int estrellasVen;
	private int estrellasCom;
	private String nombre;
	private double precio;
	private String comentario;
	private boolean comentarioAprobado;

	/**
     * Constructor por defecto (sin parámetros).
     */
	public Compra() {
	}

	/**
	 * Constructor basado en los atributos del objeto 'Anuncio'.
	 * 
	 * @param id a int.
	 * @param idUsuario a int.
	 * @param idComprador a int.
	 * @param idCatalogoCondicion a int.
	 * @param idCatalogoFormaPago a int. 
	 * @param idCatalogoZonaEntrega a int.
	 * @param idCatalogoDepartamento a int.
	 * @param descripcion a {@link java.lang.String} object.
	 * @param vigencia a {@link java.sql.Date} object.
	 * @param datosContacto a {@link java.lang.String} object.
	 * @param validado a boolean.
	 * @param notificado a boolean.
	 * @param revisado a boolean.
	 * @param activo a boolean.
	 * @param comprado a boolean.
	 * @param fechaCompra a {@link java.sql.Date} object.
	 * @param estrellasVen a int.
	 * @param estrellasCom a int.
	 * @param nombre a {@link java.lang.String} object.
	 * @param precio a double.
	 * @param comentario a {@link java.lang.String} object.
	 * @param comentarioAprobado a boolean.
	 */
	public Compra(int id, int idUsuario, int idComprador, int idCatalogoCondicion, int idCatalogoFormaPago,
			int idCatalogoZonaEntrega, int idCatalogoDepartamento, String descripcion, Date vigencia, String datosContacto, boolean validado,
			boolean notificado, boolean revisado, boolean activo, boolean comprado, Date fechaCompra, int estrellasVen,
			int estrellasCom, String nombre, double precio, String comentario, boolean comentarioAprobado) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.idComprador = idComprador;
		this.idCatalogoCondicion = idCatalogoCondicion;
		this.idCatalogoFormaPago = idCatalogoFormaPago;
		this.idCatalogoZonaEntrega = idCatalogoZonaEntrega;
		this.idCatalogoDepartamento = idCatalogoDepartamento;
		this.descripcion = descripcion;
		this.vigencia = vigencia;
		this.datosContacto = datosContacto;
		this.validado = validado;
		this.notificado = notificado;
		this.revisado = revisado;
		this.activo = activo;
		this.comprado = comprado;
		this.fechaCompra = fechaCompra;
		this.estrellasVen = estrellasVen;
		this.estrellasCom = estrellasCom;
		this.nombre = nombre;
		this.precio = precio;
		this.comentario = comentario;
		this.comentarioAprobado = comentarioAprobado;
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
	 * <p>Getter for the field <code>idUsuario</code>.</p>
	 * 
	 * @return the idUsuario.
	 */
	public int getIdUsuario() {
		return idUsuario;
	}

	/**
     * <p>Setter for the field <code>idUsuario</code>.</p>
	 * 
	 * @param idUsuario a int.
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * <p>Getter for the field <code>idComprador</code>.</p>
	 * 
	 * @return a int.
	 */
	public int getIdComprador() {
		return idComprador;
	}

	/**
     * <p>Setter for the field <code>idComprador</code>.</p>
	 * 
	 * @param idComprador a int.
	 */
	public void setIdComprador(int idComprador) {
		this.idComprador = idComprador;
	}

	/**
     * <p>Getter for the field <code>idCatalogoCondicion</code>.</p>
	 * 
	 * @return a int.
	 */
	public int getIdCatalogoCondicion() {
		return idCatalogoCondicion;
	}

	/**
     * <p>Setter for the field <code>idCatalogoCondicion</code>.</p>
	 * 
	 * @param idCatalogoCondicion a int.
	 */
	public void setIdCatalogoCondicion(int idCatalogoCondicion) {
		this.idCatalogoCondicion = idCatalogoCondicion;
	}

	/**
     * <p>Getter for the field <code>idCatalogoFormaPago</code>.</p>
	 * 
	 * @return a int.
	 */
	public int getIdCatalogoFormaPago() {
		return idCatalogoFormaPago;
	}

	/**
     * <p>Setter for the field <code>idCatalogoFormaPago</code>.</p>
	 * 
	 * @param idCatalogoFormaPago a int.
	 */
	public void setIdCatalogoFormaPago(int idCatalogoFormaPago) {
		this.idCatalogoFormaPago = idCatalogoFormaPago;
	}

	/**
     * <p>Getter for the field <code>idCatalogoZonaEntrega</code>.</p>
	 * 
	 * @return a int.
	 */
	public int getIdCatalogoZonaEntrega() {
		return idCatalogoZonaEntrega;
	}

	/**
     * <p>Setter for the field <code>idCatalogoZonaEntrega</code>.</p>
	 * 
	 * @param idCatalogoZonaEntrega a int.
	 */
	public void setIdCatalogoZonaEntrega(int idCatalogoZonaEntrega) {
		this.idCatalogoZonaEntrega = idCatalogoZonaEntrega;
	}

	/**
	 * <p>Getter for the field <code>idCatalogoDepartamento</code>.</p>
	 * 
	 * @return a int.
	 */
	public int getIdCatalogoDepartamento() {
		return idCatalogoDepartamento;
	}

	/**
	 * <p>Setter for the field <code>idCatalogoZonaEntrega</code>.</p>
	 * 
	 * @param idCatalogoDepartamento a int.
	 */
	public void setIdCatalogoDepartamento(int idCatalogoDepartamento) {
		this.idCatalogoDepartamento = idCatalogoDepartamento;
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

	/**
     * <p>Getter for the field <code>vigencia</code>.</p>
	 * 
	 * @return a {@link java.sql.Date} object.
	 */
	public Date getVigencia() {
		return vigencia;
	}

	/**
     * <p>Setter for the field <code>vigencia</code>.</p>
	 * 
	 * @param vigencia a {@link java.sql.Date} object.
	 */
	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}

	/**
     * <p>Getter for the field <code>datosContacto</code>.</p>
	 * 
	 * @return a {@link java.lang.String} object.
	 */
	public String getDatosContacto() {
		return datosContacto;
	}

	/**
     * <p>Setter for the field <code>datosContacto</code>.</p>
	 * 
	 * @param datosContacto a {@link java.lang.String} object.
	 */
	public void setDatosContacto(String datosContacto) {
		this.datosContacto = datosContacto;
	}

	/**
     * <p>Getter for the field <code>validado</code>.</p>
	 * 
	 * @return a boolean.
	 */
	public boolean isValidado() {
		return validado;
	}

	/**
     * <p>Setter for the field <code>valido</code>.</p>
	 * 
	 * @param validado a boolean.
	 */
	public void setValidado(boolean validado) {
		this.validado = validado;
	}

	/**
     * <p>Getter for the field <code>notificado</code>.</p>
	 * 
	 * @return a boolean
	 */
	public boolean isNotificado() {
		return notificado;
	}

	/**
     * <p>Setter for the field <code>notificado</code>.</p>
	 * 
	 * @param notificado a boolean.
	 */
	public void setNotificado(boolean notificado) {
		this.notificado = notificado;
	}

	/**
     * <p>Getter for the field <code>revisado</code>.</p>
	 * 
	 * @return a boolean.
	 */
	public boolean isRevisado() {
		return revisado;
	}

	/**
     * <p>Setter for the field <code>revisado</code>.</p>
	 * 
	 * @param revisado a boolean.
	 */
	public void setRevisado(boolean revisado) {
		this.revisado = revisado;
	}

	/**
     * <p>Getter for the field <code>activo</code>.</p>
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
     * <p>Getter for the field <code>comprado</code>.</p>
	 * 
	 * @return a boolean.
	 */
	public boolean isComprado() {
		return comprado;
	}

	/**
     * <p>Setter for the field <code>comprado</code>.</p>
	 * 
	 * @param comprado a boolean.
	 */
	public void setComprado(boolean comprado) {
		this.comprado = comprado;
	}

	/**
     * <p>Getter for the field <code>fechaCompra</code>.</p>
	 * 
	 * @return a {@link java.sql.Date} object.
	 */
	public Date getFechaCompra() {
		return fechaCompra;
	}

	/**
     * <p>Setter for the field <code>fechaCompra</code>.</p>
	 * 
	 * @param fechaCompra a {@link java.sql.Date} object.
	 */
	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	/**
     * <p>Getter for the field <code>estrellasVen</code>.</p>
	 * 
	 * @return a int.
	 */
	public int getEstrellasVen() {
		return estrellasVen;
	}

	/**
     * <p>Setter for the field <code>estrellasVen</code>.</p>
	 * 
	 * @param estrellasVen a int.
	 */
	public void setEstrellasVen(int estrellasVen) {
		this.estrellasVen = estrellasVen;
	}

	/**
     * <p>Getter for the field <code>estrellasCom</code>.</p>
	 * 
	 * @return a int.
	 */
	public int getEstrellasCom() {
		return estrellasCom;
	}

	/**
     * <p>Setter for the field <code>estrellasCom</code>.</p>
	 * 
	 * @param estrellasCom a int.
	 */
	public void setEstrellasCom(int estrellasCom) {
		this.estrellasCom = estrellasCom;
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
	 * @param nombre a {@link java.lang.String} object.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
     * <p>Getter for the field <code>precio</code>.</p>
	 * 
	 * @return a double.
	 */
	public double getPrecio() {
		return precio;
	}

	/**
     * <p>Setter for the field <code>precio</code>.</p>
	 * 
	 * @param precio a double.
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
     * <p>Getter for the field <code>comentario</code>.</p>
	 * 
	 * @return a {@link java.lang.String} object.
	 */
	public String getComentario() {
		return comentario;
	}

	/**
     * <p>Setter for the field <code>comentario</code>.</p>
	 * 
	 * @param comentario a {@link java.lang.String} object.
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	/**
     * <p>Getter for the field <code>comentarioAprobado</code>.</p>
	 * 
	 * @return comentarioAprobado a boolean.
	 */
	public boolean isComentarioAprobado() {
		return comentarioAprobado;
	}

	/**
     * <p>Setter for the field <code>comentarioAprobado</code>.</p>
	 * 
	 * @param comentarioAprobado a boolean.
	 */
	public void setComentarioAprobado(boolean comentarioAprobado) {
		this.comentarioAprobado = comentarioAprobado;
	}

    /**
     * Método especial (y adicional) de soporte al proceso de pruebas de regresión.
     *
     * @return a int.
     */
	@Override
	public int hashCode() {
		return Objects.hash(activo, comentario, comentarioAprobado, comprado, datosContacto, descripcion, estrellasCom,
				estrellasVen, fechaCompra, id, idCatalogoCondicion, idCatalogoFormaPago, idCatalogoZonaEntrega,
				idComprador, idUsuario, nombre, notificado, precio, revisado, validado, vigencia);
	}

    /** {@inheritDoc} */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Compra other = (Compra) obj;
		return activo == other.activo && Objects.equals(comentario, other.comentario)
				&& comentarioAprobado == other.comentarioAprobado && comprado == other.comprado
				&& Objects.equals(datosContacto, other.datosContacto) && Objects.equals(descripcion, other.descripcion)
				&& estrellasCom == other.estrellasCom && estrellasVen == other.estrellasVen
				&& Objects.equals(fechaCompra, other.fechaCompra) && id == other.id
				&& idCatalogoCondicion == other.idCatalogoCondicion && idCatalogoFormaPago == other.idCatalogoFormaPago
				&& idCatalogoZonaEntrega == other.idCatalogoZonaEntrega && idComprador == other.idComprador
				&& idUsuario == other.idUsuario && Objects.equals(nombre, other.nombre)
				&& notificado == other.notificado
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio)
				&& revisado == other.revisado && validado == other.validado && Objects.equals(vigencia, other.vigencia);
	}

    /** {@inheritDoc} */
	@Override
	public String toString() {
		return "Anuncio [id=" + id + ", idUsuario=" + idUsuario + ", idComprador=" + idComprador
				+ ", idCatalogoCondicion=" + idCatalogoCondicion + ", idCatalogoFormaPago=" + idCatalogoFormaPago
				+ ", idCatalogoZonaEntrega=" + idCatalogoZonaEntrega + ", descripcion=" + descripcion + ", vigencia="
				+ vigencia + ", datosContacto=" + datosContacto + ", validado=" + validado + ", notificado="
				+ notificado + ", revisado=" + revisado + ", activo=" + activo + ", comprado=" + comprado
				+ ", fechaCompra=" + fechaCompra + ", estrellasVen=" + estrellasVen + ", estrellasCom=" + estrellasCom
				+ ", nombre=" + nombre + ", precio=" + precio + ", comentario=" + comentario + ", comentarioAprobado="
				+ comentarioAprobado + "]";
	}
}