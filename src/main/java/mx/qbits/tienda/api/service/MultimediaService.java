package mx.qbits.tienda.api.service;

import mx.qbits.tienda.api.model.domain.Multimedia;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

import java.util.List;


public interface MultimediaService{
    int salvaMultimedia(List<Multimedia> multimedia) throws BusinessException;
}