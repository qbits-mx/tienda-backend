package mx.qbits.tienda.api.model.domain;

/**
 * <p>Implementación de la clase Multimedia.</p>
 *
 * @author 2 de Pastor
 * @version 1.0-SNAPSHOT
 */
public class Multimedia {
	
	int id;
	int idAnuncio;
    String url;
    String tipo;

    /**
    * Constructor por Omisión
    */
    public Multimedia(){
    }
    
    /**
    * Constructor por parámetros
    * @param int id
    * @param int idAnuncio
    * @param String url
    * @param String tipo
    */
    public Multimedia(int id, int idAnuncio, String url, String tipo) {
    	
    	this.id = id;
    	this.idAnuncio = idAnuncio;
        this.url = url;
        this.tipo = tipo;
    }
    
    /**
    * Getter de id
    * @return int id
    */
    public int getId() {
    	return id;
    }
    
    /**
    * Setter de id
    * @param int id
    */
    public void setId(int id) {
    	this.id = id;
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
    	this.idAnuncio= idAnuncio;
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
    * @para String url
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

}