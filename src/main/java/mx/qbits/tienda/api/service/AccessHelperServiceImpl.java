package mx.qbits.tienda.api.service;

import static mx.qbits.tienda.api.model.enumerations.EnumMessage.*;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import mx.qbits.tienda.api.mapper.RegistroMapper;
import mx.qbits.tienda.api.mapper.RolMapper;
import mx.qbits.tienda.api.mapper.UsuarioDetalleMapper;
import mx.qbits.tienda.api.mapper.UsuarioMapper;
import mx.qbits.tienda.api.model.domain.Rol;
import mx.qbits.tienda.api.model.domain.Usuario;
import mx.qbits.tienda.api.model.domain.UsuarioDetalle;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.model.exceptions.CustomException;
import mx.qbits.tienda.api.model.request.Preregistro;
import mx.qbits.tienda.api.support.JwtManagerService;
import mx.qbits.tienda.api.utils.JWTUtil;
import mx.qbits.tienda.api.utils.StringUtils;

@Service
public class AccessHelperServiceImpl implements AccessHelperService {    
    private UsuarioDetalleMapper usuarioDetalleMapper;
    private UsuarioMapper usuarioMapper;
    private RegistroMapper registroMapper;
    private RolMapper rolMapper;
    private JwtManagerService jwtManagerService;
    
    public AccessHelperServiceImpl(
            UsuarioDetalleMapper usuarioDetalleMapper,
            UsuarioMapper usuarioMapper, 
            RolMapper rolMapper,
            JwtManagerService jwtManagerService,
            RegistroMapper registroMapper) {
        this.usuarioDetalleMapper = usuarioDetalleMapper;
        this.usuarioMapper = usuarioMapper;
        this.rolMapper = rolMapper;
        this.jwtManagerService = jwtManagerService;
        this.registroMapper = registroMapper;
    }
    
    /** {@inheritDoc} */
    @Override
    public Usuario getByToken(String token) {
        return usuarioMapper.getByToken(token);
    }

    /** {@inheritDoc} */
    @Override
    public void confirmaRegeneraClave(String token, String claveHash) {
        usuarioMapper.confirmaRegeneraClave(token, claveHash);
    }

    /** {@inheritDoc} */
    @Override
    public void valida(String usr, String clave) throws CustomException {
        if(usr.trim().length()<1 || clave.trim().length()<1) throw new CustomException(BAD_CREDENTIALS);
    }
    
    @Override
    public String createToken(String mail) {
        return jwtManagerService.createToken(mail);
    }
    
    @Override
    public void updateUsuario(Usuario usuario) throws BusinessException {
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

    /** {@inheritDoc} */
    @Override
    public Preregistro getRegistroByMail(String correo) throws BusinessException {
        try {
            return registroMapper.getByMail(correo);
        } catch (SQLException e) {
            throw new CustomException(e, DATABASE, "AccessHelper::getRegistroByMail");
        }
    }

    /** {@inheritDoc} */
    @Override
    public void insertRegistro(Preregistro preRegistroRequest) throws BusinessException {
        try {
            registroMapper.insert(preRegistroRequest);
        } catch (SQLException e) {
            throw new CustomException(e, DATABASE, "AccessHelper::insertRegistro");
        }
    }

    /** {@inheritDoc} */
    @Override
    public void updateRegistro(Preregistro preRegistroRequest) throws BusinessException {
        try {
            registroMapper.update(preRegistroRequest);
        } catch (SQLException e) {
            throw new CustomException(e, DATABASE, "AccessHelper::updateRegistro");
        }
    }

    /** {@inheritDoc} */
    @Override
    public void insertUsuario(Usuario usuario) throws BusinessException {
        try {
            usuarioMapper.insert(usuario);
        } catch (SQLException e) {
            throw new CustomException(e, DATABASE, "AccessHelper::insertUsuario");
        }
    }

    /** {@inheritDoc} */
    @Override
    public void insertUsuarioDetalle(UsuarioDetalle usuarioDetalle) throws BusinessException {
        try {
            usuarioDetalleMapper.insert(usuarioDetalle);
        } catch (SQLException e) {
            throw new CustomException(e, DATABASE, "AccessHelper::insertUsuarioDetalle");
        }
    }

    /** {@inheritDoc} */
    @Override
    public void insertUserRol(int idUsuario, int rolId) throws BusinessException {
        try {
            rolMapper.insertUserRol(idUsuario, rolId);
        } catch (SQLException e) {
            throw new CustomException(e, DATABASE, "AccessHelper::insertUserRol");
        }
    }

    /** {@inheritDoc} */
    @Override
    public void deletePreregistroByRandomString(String randomString) throws BusinessException {
        try {
            registroMapper.deleteByRandomString(randomString);
        } catch (SQLException e) {
            throw new CustomException(e, DATABASE, "AccessHelper::deletePreregistroByRandomString");
        }
    }
    
    /** {@inheritDoc} */
    @Override
    public String getCorreoFromJwt(String jwt) {
        String decoded = JWTUtil.getInstance().decodeJwt(jwt);
        String correo = JWTUtil.getInstance().getCorreo(decoded);
        return correo;
    }
    
    
    /** {@inheritDoc} */
    @Override
    public UsuarioDetalle actualizaUsuarioDetalle(UsuarioDetalle usuarioDetalle) throws BusinessException {
        try {
            String nuevoCel = StringUtils.limpia(usuarioDetalle.getTelefonoCelular());
            usuarioDetalle.setTelefonoCelular(nuevoCel);
            usuarioDetalleMapper.update(usuarioDetalle);
            return usuarioDetalle;
        } catch (Exception e) {
            throw new CustomException(e, DATABASE, "Error actualizando los datos del usuario");
        }
    }

    @Override
    public Preregistro getByRandomString(String token) throws BusinessException {
        try {
            return registroMapper.getByRandomString(token);
        } catch (SQLException e) {
            throw new CustomException(e, DATABASE, "AccessHelper::getByRandomString");
        }
    }
    
}