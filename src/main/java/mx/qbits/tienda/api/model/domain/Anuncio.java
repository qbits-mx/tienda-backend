package mx.qbits.tienda.api.model.domain;

import java.util.Date;
import java.util.Objects;

/**
 * Implementacion del POJO de la entidad de {@link mx.qbits.tienda.api.model.domain.Anuncio}.
 *
 * @author  JoseRamirezRojas
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class Anuncio {
	int id;
	int idUsuario;
	int idComprador;
	int idCatalogoCondicion;
	int idCatalogoFormaPago;
	int idCatalogoZonaEntrega;
	String descripcion;
	Date vigencia;
	String datosContacto = null;
	boolean validado;
	boolean notificado;
	int revisado;
	boolean activo;
	boolean comprado;
	Date fechaCompra = null;
	int estrellas;
	String comentario = null;
	boolean comentarioAprobado;
	
	/**
	 * 
	 */
	public Anuncio() {
		super();
	}
	
	/**
	 * 
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
	 * @param estrellas
	 * @param comentario
	 * @param comentarioAprobado
	 */
	public Anuncio(int id, int idUsuario, int idComprador, int idCatalogoCondicion, int idCatalogoFormaPago,
			int idCatalogoZonaEntrega, String descripcion, Date vigencia, String datosContacto, boolean validado,
			boolean notificado, int revisado, boolean activo, boolean comprado, Date fechaCompra, int estrellas,
			String comentario, boolean comentarioAprobado) {
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
		this.estrellas = estrellas;
		this.comentario = comentario;
		this.comentarioAprobado = comentarioAprobado;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getIdUsuario() {
		return idUsuario;
	}
	
	/**
	 * 
	 * @param idUsuario
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdComprador() {
		return idComprador;
	}
	
	/**
	 * 
	 * @param idComprador
	 */
	public void setIdComprador(int idComprador) {
		this.idComprador = idComprador;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getIdCatalogoCondicion() {
		return idCatalogoCondicion;
	}
	
	/**
	 * 
	 * @param idCatalogoCondicion
	 */
	public void setIdCatalogoCondicion(int idCatalogoCondicion) {
		this.idCatalogoCondicion = idCatalogoCondicion;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getIdCatalogoFormaPago() {
		return idCatalogoFormaPago;
	}
	
	/**
	 * 
	 * @param idCatalogoFormaPago
	 */
	public void setIdCatalogoFormaPago(int idCatalogoFormaPago) {
		this.idCatalogoFormaPago = idCatalogoFormaPago;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getIdCatalogoZonaEntrega() {
		return idCatalogoZonaEntrega;
	}
	
	/**
	 * 
	 * @param idCatalogoZonaEntrega
	 */
	public void setIdCatalogoZonaEntrega(int idCatalogoZonaEntrega) {
		this.idCatalogoZonaEntrega = idCatalogoZonaEntrega;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	/**
	 * 
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * 
	 * @return
	 */
	public Date getVigencia() {
		return vigencia;
	}
	
	/**
	 * 
	 * @param vigencia
	 */
	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDatosContacto() {
		return datosContacto;
	}
	
	/**
	 * 
	 * @param datosContacto
	 */
	public void setDatosContacto(String datosContacto) {
		this.datosContacto = datosContacto;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isValidado() {
		return validado;
	}
	
	/**
	 * 
	 * @param validado
	 */
	public void setValidado(boolean validado) {
		this.validado = validado;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isNotificado() {
		return notificado;
	}
	
	/**
	 * 
	 * @param notificado
	 */
	public void setNotificado(boolean notificado) {
		this.notificado = notificado;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getRevisado() {
		return revisado;
	}
	
	/**
	 * 
	 * @param revisado
	 */
	public void setRevisado(int revisado) {
		this.revisado = revisado;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isActivo() {
		return activo;
	}
	
	/**
	 * 
	 * @param activo
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isComprado() {
		return comprado;
	}
	
	/**
	 * 
	 * @param comprado
	 */
	public void setComprado(boolean comprado) {
		this.comprado = comprado;
	}
	
	/**
	 * 
	 * @return
	 */
	public Date getFechaCompra() {
		return fechaCompra;
	}
	
	/**
	 * 
	 * @param fechaCompra
	 */
	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getEstrellas() {
		return estrellas;
	}
	
	/**
	 * 
	 * @param estrellas
	 */
	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getComentario() {
		return comentario;
	}
	
	/**
	 * 
	 * @param comentario
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isComentarioAprobado() {
		return comentarioAprobado;
	}
	
	/**
	 * 
	 * @param comentarioAprobado
	 */
	public void setComentarioAprobado(boolean comentarioAprobado) {
		this.comentarioAprobado = comentarioAprobado;
	}
	
	/**
	 * 
	 */
	@Override
	public int hashCode() {
		return Objects.hash(activo, comentario, comentarioAprobado, comprado, datosContacto, descripcion, estrellas,
				fechaCompra, id, idCatalogoCondicion, idCatalogoFormaPago, idCatalogoZonaEntrega, idComprador,
				idUsuario, notificado, revisado, validado, vigencia);
	}
	
	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Anuncio other = (Anuncio) obj;
		return activo == other.activo && Objects.equals(comentario, other.comentario)
				&& comentarioAprobado == other.comentarioAprobado && comprado == other.comprado
				&& Objects.equals(datosContacto, other.datosContacto) && Objects.equals(descripcion, other.descripcion)
				&& estrellas == other.estrellas && Objects.equals(fechaCompra, other.fechaCompra) && id == other.id
				&& idCatalogoCondicion == other.idCatalogoCondicion && idCatalogoFormaPago == other.idCatalogoFormaPago
				&& idCatalogoZonaEntrega == other.idCatalogoZonaEntrega && idComprador == other.idComprador
				&& idUsuario == other.idUsuario && notificado == other.notificado && revisado == other.revisado
				&& validado == other.validado && Objects.equals(vigencia, other.vigencia);
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Anuncio [id=" + id + ", idUsuario=" + idUsuario + ", idComprador=" + idComprador
				+ ", idCatalogoCondicion=" + idCatalogoCondicion + ", idCatalogoFormaPago=" + idCatalogoFormaPago
				+ ", idCatalogoZonaEntrega=" + idCatalogoZonaEntrega + ", descripcion=" + descripcion + ", vigencia="
				+ vigencia + ", datosContacto=" + datosContacto + ", validado=" + validado + ", notificado="
				+ notificado + ", revisado=" + revisado + ", activo=" + activo + ", comprado=" + comprado
				+ ", fechaCompra=" + fechaCompra + ", estrellas=" + estrellas + ", comentario=" + comentario
				+ ", comentarioAprobado=" + comentarioAprobado + "]";
	}
	
	
}
