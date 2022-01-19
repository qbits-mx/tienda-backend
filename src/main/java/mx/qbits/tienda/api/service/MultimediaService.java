package mx.qbits.tienda.api.service;

import java.util.List;

import mx.qbits.tienda.api.model.domain.Multimedia;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

public interface MultimediaService {

	List<Multimedia> getMultimedia(int idAnuncio) throws BusinessException;
}
