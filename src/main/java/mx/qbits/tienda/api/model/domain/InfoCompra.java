package mx.qbits.tienda.api.model.domain;

import java.sql.Date;

public class InfoCompra {
	
	/**
	 * Implementacion del POJO de la entidad de {@link mx.qbits.tienda.api.model.domain.InfoCompra}.
	 *
	 * @author  JoseRamirezRojas
	 * @version 1.0-SNAPSHOT
	 * @since   1.0-SNAPSHOT
	 */
	
	String nick_name;
	int id_usuario;
	int id_anuncio;
	Date fecha;
	String nombre;
	double precio;
	int estrellas;
	String comentario;
	boolean comentario_aprobado;
	
	public InfoCompra() {
		super();
	}
	
	public InfoCompra(String nick_name, int id_usuario, int id_anuncio, Date fecha, String nombre, int precio,int estrellas,String comentario,boolean comentario_aprobado) {
		this.nick_name = nick_name;
		this.id_usuario = id_usuario;
		this.id_anuncio = id_anuncio;
		this.fecha = fecha;
		this.nombre = nombre;
		this.precio = precio;
		this.estrellas = estrellas;
		this.comentario = comentario;
		this.comentario_aprobado = comentario_aprobado;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public int getId_anuncio() {
		return id_anuncio;
	}

	public void setId_anuncio(int id_anuncio) {
		this.id_anuncio = id_anuncio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public boolean getComentario_aprobado() {
		return comentario_aprobado;
	}

	public void setComentario_aprobado(boolean comentario_aprobado) {
		this.comentario_aprobado = comentario_aprobado;
	}

	
	
}
