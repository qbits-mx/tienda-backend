package mx.qbits.tienda.api.model.domain;

import java.util.Objects;

/**
 * <p>Descripción:</p>
 * class 'CompraMultimedia' para mostrar multimedia.
 *
 * @author pum4Developer$
 * @version 0.1.1-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
public class CompraMultimedia {
	/** 
	 * Atributos de la clase  
	 * */
	private int id;
	private int idAnuncio;
	private String tipo;
	private String url;

	/**
	 * Constructor de la clase.
	 * 
	 * @param id a int.
	 * @param idAnuncio a int.
	 * @param tipo a {@link java.lang.String} object.
	 * @param url a {@link java.lang.String} object.
	 */
	public CompraMultimedia(int id, int idAnuncio, String tipo, String url) {
		super();
		this.id = id;
		this.idAnuncio = idAnuncio;
		this.tipo = tipo;
		this.url = url;
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
     * <p>Getter for the field <code>idAnuncio</code>.</p>
	 * 
	 * @return a int.
	 */
	public int getIdAnuncio() {
		return idAnuncio;
	}

	/**
     * <p>Setter for the field <code>idAnuncio</code>.</p>
	 * 
	 * @param idAnuncio a int.
	 */
	public void setIdAnuncio(int idAnuncio) {
		this.idAnuncio = idAnuncio;
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
     * {@inheritDoc}
     */
	@Override
	public int hashCode() {
		return Objects.hash(id, idAnuncio, tipo, url);
	}
	
	/**
     * {@inheritDoc}
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompraMultimedia other = (CompraMultimedia) obj;
		return id == other.id && idAnuncio == other.idAnuncio && Objects.equals(tipo, other.tipo)
				&& Objects.equals(url, other.url);
	}
	@Override
	public String toString() {
		return "CompraMultimedia [id=" + id + ", idAnuncio=" + idAnuncio + ", tipo=" + tipo + ", url=" + url + "]";
	}

}
