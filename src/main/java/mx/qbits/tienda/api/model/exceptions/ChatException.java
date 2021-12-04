package mx.qbits.tienda.api.model.exceptions;

public class ChatException extends Exception{

    /**
     * Metodo que envia un mensaje
     * @param mensaje
     */
    public ChatException(String mensaje,int idAnuncio){
        super(mensaje+idAnuncio+"");
    }

    public ChatException(String mensaje,int idAnuncio,int idRemitente){
        super(mensaje+idAnuncio+idRemitente+"");
    }
}
