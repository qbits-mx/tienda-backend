package mx.qbits.tienda.api.service;

import mx.qbits.tienda.api.model.domain.Usuario;
import mx.qbits.tienda.api.model.domain.UsuarioDetalle;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.model.request.GoogleCaptcha;
import mx.qbits.tienda.api.model.response.LoginResponse;

public interface AccessService {
    LoginResponse login(String correo, String password) throws BusinessException;
    LoginResponse login(Usuario usuario, String claveProporcionada, long delta, int maximoNumeroIntentosConcedidos, long instanteActual) throws BusinessException;
    UsuarioDetalle actualizaUsuarioDetalle(String jwt, UsuarioDetalle usuarioDetalle) throws BusinessException;
    Usuario cambiaClave(String jwt, String correo, String clave) throws BusinessException;
    String regeneraClave(String correo);
    String confirmaRegeneraClave(String token, String clave) throws BusinessException;
    String checkCaptcha(GoogleCaptcha googleCaptcha) throws BusinessException;
}
