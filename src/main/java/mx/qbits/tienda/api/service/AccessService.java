package mx.qbits.tienda.api.service;

import mx.qbits.tienda.api.model.domain.Usuario;
import mx.qbits.tienda.api.model.domain.UsuarioDetalle;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.model.request.GoogleCaptcha;
import mx.qbits.tienda.api.model.request.Preregistro;
import mx.qbits.tienda.api.model.request.PreregistroRequest;
import mx.qbits.tienda.api.model.response.LoginResponse;

public interface AccessService {
    LoginResponse login(String correo, String password) throws BusinessException;
    LoginResponse login(Usuario usuario, String claveProporcionada, long delta, int maximoNumeroIntentosConcedidos, long instanteActual) throws BusinessException;
    
    /**
     * Efectúa la actualización de los datos adicionales de un usuario que está autorizado para solicitar dichos cambios.
     * @param jwt Token de seguridad a validar para demostrar que el usuario es quién dice ser
     * @param usuarioDetalle Conjuno de daos adicionales al perfil de un usuario
     * @return Objeto de tipo UsuarioDetalle con los detalles cambiados
     * @throws BusinessException
     */
    UsuarioDetalle actualizaUsuarioDetalle(String jwt, UsuarioDetalle usuarioDetalle) throws BusinessException;
    
    Usuario cambiaClave(String jwt, String correo, String clave) throws BusinessException;
    String checkCaptcha(GoogleCaptcha googleCaptcha) throws BusinessException;
        
    String regeneraClave(String correo);
    String confirmaRegeneraClave(String token, String clave) throws BusinessException;
    
    Preregistro preRegistro(PreregistroRequest preRegistroRequest) throws BusinessException;
    Usuario confirmaPreregistro(String token) throws BusinessException;
}
