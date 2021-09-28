package mx.qbits.tienda.api.model;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
//import org.mockito.runners.MockitoJUnitRunner;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.qbits.tienda.api.utils.Calculadora;


//@RunWith(MockitoJUnitRunner.class) 
//@RunWith(MockitoJUnitRunner.class)
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
}
