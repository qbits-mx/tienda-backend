package mx.qbits.tienda.api.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import mx.qbits.tienda.api.utils.Calculadora;
import mx.qbits.tienda.api.utils.JWTUtil;

public class CalcTest {
    
    @Test
    public void ok1() {
        Calculadora c = new Calculadora();
        int r = c.sum(2, 3);
        assertTrue(r==5);
    }
    
    @Test
    public void ok2() {
        Calculadora c = new Calculadora();
        int r = c.sum(2, 2);
        assertTrue(r==4);
    }
    
    @Test
    public void testDecodeJwt() {
        String decoded = JWTUtil.getInstance().decodeJwt("eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJjcnlwdG8tZXhlY3V0b3Itand0TWFuYWdlciIsImlhdCI6MTYzNzkzMjI4Miwic3ViIjoiQ29vbCBqd3QgVG9rZW4gb246IDE2Mzc5MzIyODI3OTIiLCJqdGkiOiJndXN0YXZvLWFyZWxsYW5vQGdtYWlsLmNvbSIsImV4cCI6MTYzNzkzMzE4Mn0.qJk0UylGcp097ZUL_JfzHokaX7D5E3tjzXPa3pcaM1g");
        System.out.println(decoded);
        String correo = JWTUtil.getInstance().getCorreo(decoded);
        assertTrue("gustavo-arellano@gmail.com".equals(correo));
    }
}
