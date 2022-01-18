package mx.qbits.tienda.api.service;

import mx.qbits.tienda.api.model.exceptions.BusinessException;

import java.time.LocalDate;
import java.util.Date;

public interface AnuncioService{
    int salvaAnuncio(int idUsuario, int catalogoPago,
                     int catalogoCondicion, int catalogoEntrega, int catalogoDepartamento, String descripcion,
                     LocalDate vigencia, String datosContacto, String nombre, double precio) throws BusinessException;
}