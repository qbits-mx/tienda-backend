package mx.qbits.tienda.api.service;

import mx.qbits.tienda.api.model.domain.Anuncio;
import mx.qbits.tienda.api.model.exceptions.BusinessException;


import java.sql.SQLException;
import java.time.LocalDate;

public interface AnuncioService{
    int salvaAnuncio(int idUsuario, int catalogoPago,
                         int catalogoCondicion, int catalogoEntrega, int catalogoDepartamento, String descripcion,
                         LocalDate vigencia, String datosContacto, String nombre, double precio)
            throws BusinessException;

}