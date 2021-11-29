package mx.qbits.tienda.api.service;

import java.util.List;

import mx.qbits.tienda.api.model.domain.Rol;
import mx.qbits.tienda.api.model.domain.Usuario;
import mx.qbits.tienda.api.model.domain.UsuarioDetalle;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.model.exceptions.CustomException;
import mx.qbits.tienda.api.model.request.Preregistro;

public interface AccessHelperService {

    /**
     * Método auxiliar que valida si se ingreso alguna credencial vacía.
     * @param usr corresponde al usuariuo de inicio de sesión.
     * @param clave corresponde a la clave de inicio de sesión.
     * @throws CustomException
     */
    void valida(String usr, String clave) throws CustomException;

    /**
     * Método privado para actualizar la información de un usuario en el sistema.
     * @param usuario objeto usuario a actualizar.
     * @throws CustomException En caso que ocurra algún problema con la actualización.
     */
    void updateUsuario(Usuario usuario) throws BusinessException;

    Usuario obtenUsuarioPorCorreo(String correo) throws BusinessException;

    List<Rol> getUserRoles(int userId) throws BusinessException;

    UsuarioDetalle getUsuarioDetalle(int userId) throws BusinessException;

    String createToken(String mail);

    UsuarioDetalle actualizaUsuarioDetalle(UsuarioDetalle usuarioDetalle) throws BusinessException;
    
    String getCorreoFromJwt(String jwt);

    Usuario getByToken(String token);

    void confirmaRegeneraClave(String token, String claveHash);

    Preregistro getRegistroByMail(String correo) throws BusinessException;

    void insertRegistro(Preregistro preRegistroRequest) throws BusinessException;

    void updateRegistro(Preregistro preRegistroRequest) throws BusinessException;

    void insertUsuario(Usuario usuario) throws BusinessException;

    void insertUsuarioDetalle(UsuarioDetalle usuarioDetalle) throws BusinessException;

    void insertUserRol(int idUsuario, int rolId) throws BusinessException;

    void deletePreregistroByRandomString(String randomString) throws BusinessException;
    
    Preregistro getByRandomString(String token) throws BusinessException;
}
