package mx.qbits.tienda.api.model.request;

import java.util.Objects;

/**
 * <p>MultimediaRequest class.</p>
 *
 * @author 2 de Pastor
 * @version 1
 */
public class MultimediaRequest {
	private int idAnuncio;
	private String url;
	private String tipo;


	/**
	* Constructor por omisión
	*/
    	public MultimediaRequest() {
    	}
	
	/**
	* Constructor por parámetros
	* @param int idAnuncio
	* @param String url
	* @param String tipo
	*/
    	public MultimediaRequest(int idAnuncio, String url, String tipo
    	) {
    		this.idAnuncio = idAnuncio;
        	this.url = url;
        	this.tipo = tipo;

    	}


   	/**
   	* Getter de idAnuncio
   	* @return int idAnuncio
    	*/
   	public int getIdAnuncio() {
		return idAnuncio;
	}
	
	/**
	* Setter de idAnuncio
	* @param int idAnuncio
	*/
	public void setIdAnuncio(int idAnuncio) {
		this.idAnuncio = idAnuncio;
	}
	
	/**
	* Getter de url
	* @return String url
	*/
	public String getUrl() {
		return url;
	}

	/**
	* Setter de url
	* @param Sring url
	*/
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	* Getter de tipo
	* @return String tipo
	*/
	public String getTipo() {
		return tipo;
	}
	
	/**
	* Setter de tipo
	* @param String tipo
	*/
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
   	
	/** {@inheritDoc} */
    	@Override
	public int hashCode() {
		return Objects.hash(tipo, url);
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
		MultimediaRequest other = (MultimediaRequest) obj;
		return Objects.equals(tipo, other.tipo) && Objects.equals(url, other.url);
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "MultimediaRequest [url=" + url + ", tipo=" + tipo + "]";
	}




}
