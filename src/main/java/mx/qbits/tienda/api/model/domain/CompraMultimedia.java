package mx.qbits.tienda.api.model.domain;

import java.util.Objects;

public class CompraMultimedia {
	private int id;
	private int idAnuncio;
	private String tipo;
	private String url;
	/**
	 * @param id
	 * @param idAnuncio
	 * @param tipo
	 * @param url
	 */
	public CompraMultimedia(int id, int idAnuncio, String tipo, String url) {
		super();
		this.id = id;
		this.idAnuncio = idAnuncio;
		this.tipo = tipo;
		this.url = url;
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
	 * @return the idAnuncio
	 */
	public int getIdAnuncio() {
		return idAnuncio;
	}
	/**
	 * @param idAnuncio the idAnuncio to set
	 */
	public void setIdAnuncio(int idAnuncio) {
		this.idAnuncio = idAnuncio;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, idAnuncio, tipo, url);
	}
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
