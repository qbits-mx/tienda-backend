package mx.qbits.tienda.api.service;

import mx.qbits.tienda.api.model.exceptions.BusinessException;

/**
* Interface MultimediaService
* @author 2 de Pastor
* @version 1
*/
public interface MultimediaService{
    
    /**
    * Metodo que salva un objeto en la tabla de Multimedia
    * @param int idAnuncio
    * @param String url
    * @param String tipo
    * @throw Business Exception
    */
    int salvaMultimedia(int idAnuncio, String url, String tipo) throws BusinessException;
}
