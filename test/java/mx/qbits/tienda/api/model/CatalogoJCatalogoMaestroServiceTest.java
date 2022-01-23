/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     mx.qbits.tienda.api.model
 * Proyecto:    tienda
 * Tipo:        Class
 * Nombre:      CatalogoServiceTest
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 6 Dic 2021 @ 08:46:09
 */
package mx.qbits.tienda.api.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import mx.qbits.tienda.api.mapper.CatalogoJCatalogoMaestroMapper;
import mx.qbits.tienda.api.model.domain.CatalogoJCatalogoMaestro;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.service.CatalogoJCatalogoMaestroImpl;
import mx.qbits.tienda.api.service.CatalogoJCatalogoMaestroService;

/**
 * <p>Descripción:</p>
 * Class 'CatalogoServiceTest' asociado a la entidad Catalogo.
 * @author Ricardo Ruben Gonzalez Garcia
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see mx.qbits.tienda.api.model.domain.CatalogoJCatalogoMaestroServiceTest
 */
@RunWith(MockitoJUnitRunner.class)
public class CatalogoJCatalogoMaestroServiceTest {
    
    private CatalogoJCatalogoMaestroService service;

    @Mock
    private CatalogoJCatalogoMaestroMapper mapper;


    CatalogoJCatalogoMaestro catalogo1,catalogo2,catalogo3,catalogo4;
    List<CatalogoJCatalogoMaestro> res;

    @Before
    public void setup() throws SQLException{

        catalogo1 = new CatalogoJCatalogoMaestro(1,1,"Condicion", "Nuevo", 1);
        catalogo2 = new CatalogoJCatalogoMaestro(3,2,"Departamento", "Mascotas", 1);
        catalogo3 = new CatalogoJCatalogoMaestro(3,2,"Departamento", "Deportes", 1);
        catalogo4 = new CatalogoJCatalogoMaestro(4,2,"Departamento", "Otros", 1);

        res = new ArrayList<>();
            res.add(catalogo1);res.add(catalogo3);res.add(catalogo4);res.add(catalogo2);
        when(mapper.getAll()).thenReturn(res);
    }

    @Test
    public void getAllTests(){
        service = new CatalogoJCatalogoMaestroImpl(mapper);
        try {
            if (service.dameTodosLosCatalogos().get(3) != catalogo4) {
                assertTrue(false);
                
            }
            assertTrue(catalogoService.eliminarCatalogo("Jalisco"));
        } catch (Exception e) {
            assertTrue(false);
        }
    }
}