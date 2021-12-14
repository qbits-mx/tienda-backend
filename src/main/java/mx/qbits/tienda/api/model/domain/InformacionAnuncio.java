package mx.qbits.tienda.api.model.domain;

/**
 * Implementación del POJO de la entidad de 'Anuncio'
 * 
 * @author JenniferAlanisMtz
 * @author DTanatos01
 * @author Kalato-Pari
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class InformacionAnuncio {

	/*
	 * Atributos de la clase
	 */
	private int id;
	private int idUsuario;
	private String descripcion;
	private String datosContacto;
	private boolean validado;
	private boolean notificado;
	
	
	/**
	 * Constructor por defecto (sin parámetros)
	 */
	public InformacionAnuncio() {		
	}
	
	/**
	 * Constructor basado en todos los atributos de la clase
	 * 
	 * @param id a int.
	 * @param idUsuario a int.
	 * @param descripcion a {@link java.lang.String} object.
	 * @param datosContacto a {@link java.lang.String} object.
	 */
	public InformacionAnuncio(int id, int idUsuario, String descripcion, String datosContacto, boolean validado,
			boolean notificado) {
		this.id = id;
		this.idUsuario = idUsuario;
		this.descripcion = descripcion;
		this.datosContacto = datosContacto;
		this.validado = validado;
		this.notificado = notificado;
	}

	/*
	 * Setter y Getter
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
	 * @return a int.
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
	 * <p>Getter for the field <code>notificado</code>.</p>
	 * 
	 * @return a boolean.
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
	 * <p>Getter for the field <code>validado</code>.</p>
	 * 
	 * @return a boolean.
	 */
	public boolean isValidado() {
		return validado;
	}

	/**
	 * <p>Setter for the field <code>validado</code>.</p>
	 * 
	 * @param validado a boolean.
	 */
	public void setValidado(boolean validado) {
		this.validado = validado;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datosContacto == null) ? 0 : datosContacto.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + id;
		result = prime * result + idUsuario;
		result = prime * result + (notificado ? 1231 : 1237);
		result = prime * result + (validado ? 1231 : 1237);
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
		InformacionAnuncio other = (InformacionAnuncio) obj;
		if (datosContacto == null) {
			if (other.datosContacto != null)
				return false;
		} else if (!datosContacto.equals(other.datosContacto))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id != other.id)
			return false;
		if (idUsuario != other.idUsuario)
			return false;
		if (notificado != other.notificado)
			return false;
		if (validado != other.validado)
			return false;
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "InformacionAnuncio [id=" + id + ", idUsuario=" + idUsuario + ", descripcion=" + descripcion
				+ ", datosContacto=" + datosContacto + ", validado=" + validado + ", notificado=" + notificado + "]";
	}
}