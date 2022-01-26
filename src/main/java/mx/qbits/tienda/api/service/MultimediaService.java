package mx.qbits.tienda.api.service;

import mx.qbits.tienda.api.model.domain.Multimedia;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

import java.util.List;


public interface MultimediaService{
    List<Multimedia> getMultimedia(int idAnuncio) throws BusinessException;
    int salvaMultimedia(List<Multimedia> multimedia) throws BusinessException;
}
