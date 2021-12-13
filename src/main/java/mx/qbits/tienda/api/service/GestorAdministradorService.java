package mx.qbits.tienda.api.service;

import java.util.List;

import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

public interface GestorAdministradorService {


    /**
     * regresa todos los Anuncios No validados de la base de datos.
     * @return
     * @throws BusinessException
     */
    List<Anuncio> consultarNoValidados() throws BusinessException;

    /**
     * regresa todos los Anuncios validados de la base de datos.
     * @return
     * @throws BusinessException
     */
    List<Anuncio> consultarValidados() throws BusinessException;
}