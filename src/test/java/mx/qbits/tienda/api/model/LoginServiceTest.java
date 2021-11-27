package mx.qbits.tienda.api.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import mx.qbits.tienda.api.mapper.RolMapper;
import mx.qbits.tienda.api.mapper.UsuarioDetalleMapper;
import mx.qbits.tienda.api.mapper.UsuarioMapper;
import mx.qbits.tienda.api.model.domain.Rol;
import mx.qbits.tienda.api.model.domain.Usuario;
import mx.qbits.tienda.api.model.domain.UsuarioDetalle;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.model.response.LoginResponse;
import mx.qbits.tienda.api.service.AccessService;
import mx.qbits.tienda.api.service.AccessServiceImpl;

//@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {
    /*
    private AccessService loginService;
    
    @Mock
    private UsuarioDetalleMapper usuarioDetalleMapper;
    
    @Mock
    private UsuarioMapper usuarioMapper;
    
    @Mock
    private RolMapper rolMapper;
    
    @Before
    public void setup() throws SQLException  {
        Usuario usuario = new Usuario(2, "gustavo-arellano@gmail.com", "dee016e42f427b6fac0de1caee4a25e3f34a1f4eb5be4b97c4e995ac5044fd57", 0, false, 0, 0, 0, 0, null, 0);
        when(usuarioMapper.getByCorreo("gustavo-arellano@gmail.com")).thenReturn(usuario);
        
        List<Rol> lista = new ArrayList<Rol>();
        lista.add(new Rol(1, "admin", true));
        lista.add(new Rol(2, "capturista", true));
        when(rolMapper.getUserRoles(2)).thenReturn(lista);
        
        UsuarioDetalle ud = new UsuarioDetalle(2, "gustavo", "arellano", "sandoval", "goose", new Date(), "55 98765 4321");
        when(usuarioDetalleMapper.getById(2)).thenReturn(ud);
    }
        
    @Test
    public void loginIncorrectTest() {
        loginService = new AccessServiceImpl(usuarioDetalleMapper, usuarioMapper, rolMapper);
        
        try {
            LoginResponse lr = loginService.login("gustavo-arellano@gmail.com", "incorrecto");
            assertFalse(true);
        } catch (BusinessException be) {
            assertTrue(true); // hanna
        }
    }
    
    @Test
    public void loginCorrectTest() throws SQLException {
        loginService = new AccessServiceImpl(usuarioDetalleMapper, usuarioMapper, rolMapper);
        
        try {
            LoginResponse lr = loginService.login("gustavo-arellano@gmail.com", "Kebblar2017_");
            assertTrue(true);
        } catch (BusinessException be) {    
            assertTrue(false);
        }
    }*/
}
