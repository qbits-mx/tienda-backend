package mx.qbits.tienda.api.model.domain;

import java.sql.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

/**
 * <p>Implementación de la clase Anuncio.</p>
 *
 * @author 2 de Pastor
 * @version 1.0-SNAPSHOT
 */
public class Anuncio {
	private int id;
	private int idUsuario;
	private int idComprador;
	private int idCatalogoDepartamento;
	private int idCatalogoCondicion;
	private int idCatalogoFormaPago;
	private int idCatalogoZonaEntrega;
	private String descripcion;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private LocalDate vigencia;
	private String datosContacto;
	private boolean validado;
	private boolean notificado;
	private boolean revisado;
	private boolean activo;
	private boolean comprado;
	private LocalDate fechaCompra;
	private int estrellasVen;
	private int estrellasCom;
	private String nombre;
	private double precio;
	private String comentario;
	private boolean comentarioAprobado;

	public Anuncio() {
	}



	/**
	 * @param id
	 * @param idUsuario
	 * @param idComprador
	 * @param idCatalogoCondicion
	 * @param idCatalogoFormaPago
	 * @param idCatalogoZonaEntrega
	 * @param descripcion
	 * @param vigencia
	 * @param datosContacto
	 * @param validado
	 * @param notificado
	 * @param revisado
	 * @param activo
	 * @param comprado
	 * @param fechaCompra
	 * @param estrellasVen
	 * @param estrellasCom
	 * @param nombre
	 * @param precio
	 * @param comentario
	 * @param comentarioAprobado
	 */
	public Anuncio(int id, int idUsuario, int idComprador, int idCatalogoCondicion, int idCatalogoFormaPago,
			int idCatalogoZonaEntrega, String descripcion, LocalDate vigencia, String datosContacto, boolean validado,
			boolean notificado, boolean revisado, boolean activo, boolean comprado, LocalDate fechaCompra, int estrellasVen,
			int estrellasCom, String nombre, double precio, String comentario, boolean comentarioAprobado) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.idComprador = idComprador;
		this.idCatalogoCondicion = idCatalogoCondicion;
		this.idCatalogoFormaPago = idCatalogoFormaPago;
		this.idCatalogoZonaEntrega = idCatalogoZonaEntrega;
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

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}



	/**
	 * @return the idUsuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}



	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}



	/**
	 * @return the idComprador
	 */
	public int getIdComprador() {
		return idComprador;
	}



	/**
	 * @param idComprador the idComprador to set
	 */
	public void setIdComprador(int idComprador) {
		this.idComprador = idComprador;
	}



	/**
	 * @return the idCatalogoCondicion
	 */
	public int getIdCatalogoCondicion() {
		return idCatalogoCondicion;
	}



	/**
	 * @param idCatalogoCondicion the idCatalogoCondicion to set
	 */
	public void setIdCatalogoCondicion(int idCatalogoCondicion) {
		this.idCatalogoCondicion = idCatalogoCondicion;
	}



	/**
	 * @return the idCatalogoFormaPago
	 */
	public int getIdCatalogoFormaDePago() {
		return idCatalogoFormaPago;
	}



	/**
	 * @param idCatalogoFormaPago the idCatalogoFormaPago to set
	 */
	public void setIdCatalogoFormaDePago(int idCatalogoFormaPago) {
		this.idCatalogoFormaPago = idCatalogoFormaPago;
	}



	/**
	 * @return the idCatalogoZonaEntrega
	 */
	public int getIdCatalogoZonaDeEntrega() {
		return idCatalogoZonaEntrega;
	}



	/**
	 * @param idCatalogoZonaEntrega the idCatalogoZonaEntrega to set
	 */
	public void setIdCatalogoZonaDeEntrega(int idCatalogoZonaEntrega) {
		this.idCatalogoZonaEntrega = idCatalogoZonaEntrega;
	}



	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}



	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	/**
	 * @return the vigencia
	 */
	public LocalDate getVigenciaAnuncio() {
		return vigencia;
	}



	/**
	 * @param vigencia the vigencia to set
	 */
	public void setVigenciaAnuncio(LocalDate vigencia) {
		this.vigencia = vigencia;
	}



	/**
	 * @return the datosContacto
	 */
	public String getContacto() {
		return datosContacto;
	}



	/**
	 * @param datosContacto the datosContacto to set
	 */
	public void setContacto(String datosContacto) {
		this.datosContacto = datosContacto;
	}



	/**
	 * @return the validado
	 */
	public boolean isValidado() {
		return validado;
	}



	/**
	 * @param validado the validado to set
	 */
	public void setValidado(boolean validado) {
		this.validado = validado;
	}



	/**
	 * @return the notificado
	 */
	public boolean isNotificado() {
		return notificado;
	}



	/**
	 * @param notificado the notificado to set
	 */
	public void setNotificado(boolean notificado) {
		this.notificado = notificado;
	}



	/**
	 * @return the revisado
	 */
	public boolean isRevisado() {
		return revisado;
	}



	/**
	 * @param revisado the revisado to set
	 */
	public void setRevisado(boolean revisado) {
		this.revisado = revisado;
	}



	/**
	 * @return the activo
	 */
	public boolean isActivo() {
		return activo;
	}



	/**
	 * @param activo the activo to set
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}



	/**
	 * @return the comprado
	 */
	public boolean isComprado() {
		return comprado;
	}



	/**
	 * @param comprado the comprado to set
	 */
	public void setComprado(boolean comprado) {
		this.comprado = comprado;
	}



	/**
	 * @return the fechaCompra
	 */
	public LocalDate getFechaCompra() {
		return fechaCompra;
	}



	/**
	 * @param fechaCompra the fechaCompra to set
	 */
	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}



	/**
	 * @return the estrellasVen
	 */
	public int getEstrellasVen() {
		return estrellasVen;
	}



	/**
	 * @param estrellasVen the estrellasVen to set
	 */
	public void setEstrellasVen(int estrellasVen) {
		this.estrellasVen = estrellasVen;
	}



	/**
	 * @return the estrellasCom
	 */
	public int getEstrellasCom() {
		return estrellasCom;
	}



	/**
	 * @param estrellasCom the estrellasCom to set
	 */
	public void setEstrellasCom(int estrellasCom) {
		this.estrellasCom = estrellasCom;
	}



	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}



	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}



	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}



	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}



	/**
	 * @param comentario the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}



	/**
	 * @return the comentarioAprobado
	 */
	public boolean isComentarioAprobado() {
		return comentarioAprobado;
	}



	/**
	 * @param comentarioAprobado the comentarioAprobado to set
	 */
	public void setComentarioAprobado(boolean comentarioAprobado) {
		this.comentarioAprobado = comentarioAprobado;
	}

	
	

	public int getIdCatalogoDepartamento() {
		return idCatalogoDepartamento;
	}



	public void setIdCatalogoDepartamento(int idCatalogoDepartamento) {
		this.idCatalogoDepartamento = idCatalogoDepartamento;
	}



	@Override
	public int hashCode() {
		return Objects.hash(activo, comentario, comentarioAprobado, comprado, datosContacto, descripcion, estrellasCom,
				estrellasVen, fechaCompra, id, idCatalogoCondicion, idCatalogoFormaPago, idCatalogoZonaEntrega,
				idComprador, idUsuario, nombre, notificado, precio, revisado, validado, vigencia);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Anuncio other = (Anuncio) obj;
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