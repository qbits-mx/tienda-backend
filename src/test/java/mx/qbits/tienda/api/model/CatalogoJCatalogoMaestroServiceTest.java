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
 * Nombre:      CatalogoJCatalogoMaestroServiceTest
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 7 Enero 2021 @ 08:46:09
 */
package mx.qbits.tienda.api.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;
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
 * Class 'CatalogoJMaestroServiceTest' asociado a la entidad CatalogoJCatalogoMaestro.
 * @author Juan Carlos Bautista Sandoval
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 * @see mx.qbits.tienda.api.model.domain.CatalogoJCatalogoMaestroServiceTest
 */
@RunWith(MockitoJUnitRunner.class)
public class CatalogoJCatalogoMaestroServiceTest {

    private CatalogoJCatalogoMaestroService catalogoJCatalogoMaestroService;
    
    @Mock
    private CatalogoJCatalogoMaestroMapper catalogoJCatalogoMaestroMapper;

    @Before
    public void setup() throws SQLException {
        CatalogoJCatalogoMaestro catalogoJCatalogoMaestro = new CatalogoJCatalogoMaestro(1, 1, "tipo", "nombre", true);
        CatalogoJCatalogoMaestro catalogoJCatalogoMaestro2 = new CatalogoJCatalogoMaestro(2, 2, "tipoCatalogo", "nombre", false);

        List<CatalogoJCatalogoMaestro> result = new ArrayList<>();
        result.add(catalogoJCatalogoMaestro);
        result.add(catalogoJCatalogoMaestro2);

        when(catalogoJCatalogoMaestroMapper.getAll()).thenReturn(result);
    }

    @Test
    public void dameTodosLosCatalogosCorrectAndIncorrectTest () {
        catalogoJCatalogoMaestroService = new CatalogoJCatalogoMaestroImpl(catalogoJCatalogoMaestroMapper);
        try {
            assertNotNull(catalogoJCatalogoMaestroService.dameTodosLosCatalogos());
        } catch (BusinessException e) {
            assertTrue(false);
        }
    }

}
