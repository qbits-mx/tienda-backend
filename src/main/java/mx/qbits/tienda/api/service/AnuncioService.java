package mx.qbits.tienda.api.service;

import mx.qbits.tienda.api.model.exceptions.BusinessException;
import java.time.LocalDate;

/**
* Interface AnuncioService
* @author 2 de Pastor
* @version 1
*/
public interface AnuncioService{
    
    /**
    * Metodo para salvar el anuncio en la base da datos
    * @param int idUsuario
    * @param int catalogoPago
    * @param int catalogoCondicion
    * @param int catalogoEntrega
    * @param int catalogoDepartamento
    * @param String descripcion
    * @param LocalDate vigencia
    * @param String datosContacto
    * @param String nombre
    * @param int precio
    */
    int salvaAnuncio(int idUsuario, int catalogoPago,
                         int catalogoCondicion, int catalogoEntrega, int catalogoDepartamento, String descripcion,
                         LocalDate vigencia, String datosContacto, String nombre, double precio)
            throws BusinessException;

}
