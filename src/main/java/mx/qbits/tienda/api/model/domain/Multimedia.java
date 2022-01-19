package mx.qbits.tienda.api.model.domain;

public class Multimedia {

	int id;
	int idAnuncio;
    String url;
    String tipo;

    public Multimedia(){
    }
    
    public Multimedia(int id, int idAnuncio, String url, String tipo) {
    	
    	this.id = id;
    	this.idAnuncio = idAnuncio;
        this.url = url;
        this.tipo = tipo;
    }
    
    public int getId() {
    	return id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public int getIdAnuncio() {
    	return idAnuncio;
    }
    
    public void setIdAnuncio(int idAnuncio) {
    	this.idAnuncio= idAnuncio;
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
	
}
