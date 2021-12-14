package mx.qbits.tienda.api.model.request;

import java.util.Objects;

public class MultimediaRequest {
	private int idAnuncio;
	private String url;
	private String tipo;


    public MultimediaRequest() {
    }

    public MultimediaRequest(int idAnuncio, String url, String tipo
    ) {
    	this.idAnuncio = idAnuncio;
        this.url = url;
        this.tipo = tipo;

    }


    public int getIdAnuncio() {
		return idAnuncio;
	}

	public void setIdAnuncio(int idAnuncio) {
		this.idAnuncio = idAnuncio;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
   
    @Override
	public int hashCode() {
		return Objects.hash(tipo, url);
	}

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

	@Override
	public String toString() {
		return "MultimediaRequest [url=" + url + ", tipo=" + tipo + "]";
	}




}