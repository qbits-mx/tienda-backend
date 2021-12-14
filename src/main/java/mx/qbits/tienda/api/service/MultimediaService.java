package mx.qbits.tienda.api.service;

import mx.qbits.tienda.api.model.exceptions.BusinessException;


public interface MultimediaService{
    int salvaMultimedia(int idAnuncio, String url, String tipo) throws BusinessException;
}