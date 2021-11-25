package mx.qbits.tienda.api.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import mx.qbits.tienda.api.mapper.RolMapper;
import mx.qbits.tienda.api.mapper.UsuarioDetalleMapper;
import mx.qbits.tienda.api.mapper.UsuarioMapper;
import mx.qbits.tienda.api.model.domain.Rol;
import mx.qbits.tienda.api.model.domain.Usuario;
import mx.qbits.tienda.api.model.domain.UsuarioDetalle;
import mx.qbits.tienda.api.model.enumerations.EnumMessage;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.model.exceptions.CustomException;
import mx.qbits.tienda.api.model.response.LoginResponse;
import mx.qbits.tienda.api.utils.DigestEncoder;
import mx.qbits.tienda.api.utils.JWTUtil;

@Service
public class LoginServiceImpl implements LoginService {
    private UsuarioDetalleMapper usuarioDetalleMapper;
    private UsuarioMapper usuarioMapper;
    private RolMapper rolMapper;
    
    public LoginServiceImpl(
            UsuarioDetalleMapper usuarioDetalleMapper,
            UsuarioMapper usuarioMapper, 
            RolMapper rolMapper) {
        this.usuarioDetalleMapper = usuarioDetalleMapper;
        this.usuarioMapper = usuarioMapper;
        this.rolMapper = rolMapper;
    }

    @Override
    public LoginResponse login(String correo, String password) throws BusinessException {
        UsuarioDetalle ud;
        Usuario usuario;
        List<Rol> lista;
        try {
            usuario = usuarioMapper.getByCorreo(correo);
            if(usuario==null) throw new CustomException(EnumMessage.USER_NOT_EXIST, correo);
            lista = rolMapper.getUserRoles(usuario.getId());
            ud = usuarioDetalleMapper.getById(usuario.getId());
        } catch (SQLException e) {
            throw new CustomException(EnumMessage.DATABASE, "Error localizando al usuario por correo");
        }
        String cadenaDigestada = DigestEncoder.digest(password, correo);
        if(usuario.getClave().equals(cadenaDigestada)) {
            String jwt = JWTUtil.getInstance().createToken(correo, 20*60*1000, "password");
            LoginResponse lr = new LoginResponse(); //gustavo
            lr.setCorreo(correo); 
            lr.setJwt(jwt);
            lr.setRoles(lista);
            lr.setUltimoAcceso(null);
            lr.setUsuarioDetalle(ud);
            return lr;
        } else {
            throw new CustomException(EnumMessage.BAD_CREDENTIALS);
        }
    }

}
