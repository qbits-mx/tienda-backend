package mx.qbits.tienda.api.service;

import static mx.qbits.tienda.api.model.enumerations.EnumMessage.*;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import mx.qbits.tienda.api.mapper.RolMapper;
import mx.qbits.tienda.api.mapper.UsuarioDetalleMapper;
import mx.qbits.tienda.api.mapper.UsuarioMapper;
import mx.qbits.tienda.api.model.domain.Rol;
import mx.qbits.tienda.api.model.domain.Usuario;
import mx.qbits.tienda.api.model.domain.UsuarioDetalle;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.model.exceptions.CustomException;
import mx.qbits.tienda.api.support.JwtManagerService;

@Service
public class AccessHelperServiceImpl implements AccessHelperService {    
    private UsuarioDetalleMapper usuarioDetalleMapper;
    private UsuarioMapper usuarioMapper;
    private RolMapper rolMapper;
    private JwtManagerService jwtManagerService;
    
    public AccessHelperServiceImpl(
            UsuarioDetalleMapper usuarioDetalleMapper,
            UsuarioMapper usuarioMapper, 
            RolMapper rolMapper,
            JwtManagerService jwtManagerService) {
        this.usuarioDetalleMapper = usuarioDetalleMapper;
        this.usuarioMapper = usuarioMapper;
        this.rolMapper = rolMapper;
        this.jwtManagerService = jwtManagerService;
    }

    /** {@inheritDoc} */
    @Override
    public void valida(String usr, String clave) throws CustomException {
        if(usr.trim().length()<1 || clave.trim().length()<1) throw new CustomException(BAD_CREDENTIALS);
    }

    @Override
    public void update(Usuario usuario) throws BusinessException {
        try {
            usuarioMapper.update(usuario);
        } catch (SQLException e) {
            throw new CustomException(e, DATABASE, "login::update");
        }
    }
    
    @Override
    public Usuario obtenUsuarioPorCorreo(String correo) throws BusinessException {
        try {
            return usuarioMapper.getByCorreo(correo);
        } catch (SQLException e) {
            throw new CustomException(e, DATABASE, "login::update");
        }
    }
    
    @Override
    public List<Rol> getUserRoles(int userId) throws BusinessException {
        try {
            return rolMapper.getUserRoles(userId);
        } catch (SQLException e) {
            throw new CustomException(e, DATABASE, "login::update");
        }
    }
    
    @Override
    public UsuarioDetalle getUsuarioDetalle(int userId) throws BusinessException {
        try {
            return usuarioDetalleMapper.getById(userId);
        } catch (SQLException e) {
            throw new CustomException(e, DATABASE, "login::update");
        }
    }
    
    @Override
    public String createToken(String mail) {
        return jwtManagerService.createToken(mail);
    }
}
