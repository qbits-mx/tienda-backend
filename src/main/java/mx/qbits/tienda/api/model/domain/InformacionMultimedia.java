package mx.qbits.tienda.api.model.domain;

/**
 * Implementación del POJO de la entidad de 'Multimedia'
 * 
 * @author JenniferAlanisMtz
 * @author DTanatos01
 * @author Kalato-Pari
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class InformacionMultimedia {

	/*
	 * Atributos de la clase 
	 */
	private int id;
	private String tipo;
	private String url;
	
	/**
	 * Constructor por defecto (sin parámetros)
	 */
	public InformacionMultimedia() {		
	}
	
	/**
	 * Constructor basado en todos los atributos de la clase
	 * 
	 * @param id a int.
	 * @param tipo a {@link java.lang.String} object.
	 * @param url a {@link java.lang.String} object.
	 */
	public InformacionMultimedia(int id, String tipo, String url) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.url = url;
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
	 * <p>Getter for the field <code>tipo</code>.</p>
	 * 
	 * @return a {@link java.lang.String} object.
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * <p>Setter for the field <code>tipo</code>.</p>
	 * 
	 * @param tipo a {@link java.lang.String} object.
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * <p>Getter for the field <code>url</code>.</p>
	 * 
	 * @return a {@link java.lang.String} object.
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * <p>Setter for the field <code>url</code>.</p>
	 * 
	 * @param url a {@link java.lang.String} object.
	 */
	public void setUrl(String url) {
		this.url = url;
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
		result = prime * result + id;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		InformacionMultimedia other = (InformacionMultimedia) obj;
		if (id != other.id)
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "InformacionMultimedia [id=" + id + ", tipo=" + tipo + ", url=" + url + "]";
	};
}
