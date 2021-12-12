package mx.qbits.tienda.api.service;

import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

import java.util.Date;

public interface AnuncioService{
    int salvaAnuncio(int idUsuario, int catalogoDepartamento, int catalogoPago,
                     int catalogoCondicion, int catalogoEntrega, String descripcion,
                     Date vigencia, String datosContacto) throws BusinessException;
}