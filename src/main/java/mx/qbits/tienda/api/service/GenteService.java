package mx.qbits.tienda.api.service;


import java.util.List;

import mx.qbits.tienda.api.model.domain.Gente;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

public interface GenteService {
    /**
     * Recibe un objeto de tipo 'Gente' y averigua si ya existe en la base de datos.
     * Si existe, actualiza los datos, pero si NO existe, lo inserta.
     *
     * @param id
     * @param correo
     * @param clave
     *
     * @return 1 si tuvo éxito 0 en otro caso
     * @throws BusinessException Se dispara en caso de que hubier un problema interno
     */
    int salvaDatos(int id, String correo, String clave) throws BusinessException;

    /**
     * regresa todos los registros de la base de datos en donde el instante de bloqueo sea mayor a cero.
     * @return
     * @throws BusinessException
     */
    List<Gente> dameDatos() throws BusinessException;
}
