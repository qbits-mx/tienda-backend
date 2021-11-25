package mx.qbits.tienda.api.service;

import mx.qbits.tienda.api.model.domain.Usuario;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.model.response.LoginResponse;

public interface LoginService {
    LoginResponse login(String correo, String password) throws BusinessException;
    LoginResponse login(Usuario usuario, String claveProporcionada, long delta, int maximoNumeroIntentosConcedidos,
            long instanteActual) throws BusinessException;
}
