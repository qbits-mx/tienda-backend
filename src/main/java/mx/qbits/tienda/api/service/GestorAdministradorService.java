package mx.qbits.tienda.api.service;

import java.util.List;

import mx.qbits.tienda.api.model.domain.InformacionAnuncio;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

public interface GestorAdministradorService {


    /**
     * regresa todos los Anuncios No validados de la base de datos.
     * @return
     * @throws BusinessException
     */
    List<InformacionAnuncio> consultarNoValidados() throws BusinessException;

    /**
     * regresa todos los Anuncios validados de la base de datos.
     * @return
     * @throws BusinessException
     */
    List<InformacionAnuncio> consultarValidados() throws BusinessException;
}