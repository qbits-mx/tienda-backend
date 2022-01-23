/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     mx.qbits.tienda.api.rest
 * Proyecto:    tienda
 * Tipo:        Clase
 * Nombre:      CatalogoMaestroController
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 3 Dic 2021 @ 08:22:14
 */
package mx.qbits.tienda.api.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.qbits.tienda.api.model.domain.CatalogoMaestro;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.service.CatalogoMaestroService;

/**
 * Implementacion  del controlador REST asociado a los endpoints
 * de gestión por CatalogoMaestroService.
 * 
 * <p>NOTA IMPORTANTE: Los  distntos métodos de este controlador no
 * llevan  javadoc  debido a que la  documentación  Swagger  API
 * cumple con ese objetivo.</p>
 *
 * @author  Juan Carlos Bautista Sandoval
 * @see     mx.qbits.tienda.api.service.CatalogoMaestroService
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */
@RestController
@RequestMapping(value = "/api")
public class CatalogoMaestroController {
    
    private CatalogoMaestroService catalogoMaestroService;

    /**
     * Constructor que realiza el setting de los servicios que serán
     * utilizados en este controlador.
     * @param catalogoMaestroService Servicios de CatalogoMaestroService
     */
    public CatalogoMaestroController(CatalogoMaestroService catalogoMaestroService) {
        this.catalogoMaestroService = catalogoMaestroService;
    }

    /**
     * Elimina un catalogo maestro.
     * @param tipoCatalogo el nombre del catalogo a eliminar
     * @return true en caso de eliminarlo, false en caso de no hacerlo.
     * @throws BusinessException Si hubo algun error con la BD
     */
    @GetMapping(path = "/eliminar-tipo.json", produces = "application/json; charset=utf-8")
    public boolean eliminarTipo(@RequestParam String tipoCatalogo) throws BusinessException {
        return catalogoMaestroService.eliminarCatalogo(tipoCatalogo);
    }

    /**
     * Elimina un catalogo maestro
     * @param id el id del catalogo a eliminar
     * @return true en caso de eliminarlo, false en caso de no hacerlo.
     * @throws BusinessException Si hubo algun error con la BD
     */
    @GetMapping(path = "/eliminar-id.json", produces = "application/json; charset=utf-8")
    public boolean eliminarId(@RequestParam int id) throws BusinessException {
        return catalogoMaestroService.eliminarCatalogo(id);
    }


    /**
     * Busca un catalogo maestro dentro de la BD.
     * @param id el id del catalogo a buscar
     * @return true en caso de eliminarlo, false en caso de no hacerlo.
     * @throws BusinessException Si hubo algun error con la BD
     */

    @GetMapping(path = "/buscar-catalogo-id.json", produces = "application/json; charset=utf-8")
    public CatalogoMaestro buscarCatalogoId(@RequestParam int id) throws BusinessException {
        return catalogoMaestroService.buscarCatalogo(id);
    }
    
    /**
     * Busca un catalogo maestro dentro de la BD.
     * @param id el id del catalogo a buscar
     * @return El catalogo que tiene el id buscado
     * @throws BusinessException En caso de no existir
     */

    @GetMapping(path = "/buscar-catalogo-tipo-catalogo.json", produces = "application/json; charset=utf-8")
    public CatalogoMaestro buscarCatalogoTipoCatalogo(@RequestParam String tipoCatalogo) throws BusinessException {
        return catalogoMaestroService.buscarCatalogo(tipoCatalogo);
    }
    /**
     * Busca un catalogo maestro dentro de la BD y le cambia el nombre.
     * @param id el id del catalogo a buscar
     * @param nuevoTipoCatalogo el nuevo nombre del catalogo maestro
     * @return true en caso de cambiarlo, false en caso de no hacerlo.
     * @throws BusinessException Si hubo algun error con la BD
     */
    @GetMapping(path = "/modificar-tipo-catalogo-id.json", produces = "application/json; charset=utf-8")
    public boolean modificarTipoCatalogoId(
            @RequestParam int id,
            @RequestParam String nuevoTipoCatalogo) throws BusinessException {
        return catalogoMaestroService.modificarTipoCatalogo(id, nuevoTipoCatalogo);
    }
    
    /**
     * Busca un catalogo maestro dentro de la BD y le cambia el tipo.
     * @param id el id del catalogo a buscar
     * @param nuevoTipoCatalogo el nuevo tipo del catalogo maestro
     * @return true en caso de cambiarlo, false en caso de no hacerlo.
     * @throws BusinessException Si hubo algun error con la BD
     */
    @GetMapping(path = "/modificar-tipo-catalogo-tipo-catalogo.json", produces = "application/json; charset=utf-8")
    public boolean modificarTipoCatalogoTipoCatalogo(
            @RequestParam int tipoCatalogo,
            @RequestParam String nuevoTipoCatalogo) throws BusinessException {
        return catalogoMaestroService.modificarTipoCatalogo(tipoCatalogo, nuevoTipoCatalogo);
    }

    /**
     * Crea un nuevo catalogo maestro
     * @param tipoCatalogo el nombre del catalogo maestro nuevo
     * @return true en caso de cambiarlo, false en caso de no hacerlo.
     * @throws BusinessException Si hubo algun error con la BD
     */
    @GetMapping(path = "/crear-catalogo.json", produces = "application/json; charset=utf-8")
    public boolean crearCatalogo(@RequestParam String tipoCatalogo) throws BusinessException {
        return catalogoMaestroService.crearCatalogo(tipoCatalogo);
    }


    /**
     * Regresa todos los catalogos maestros
     * @return Una lista de todos los catalogos
     * @throws BusinessException Si hubo algun error con la BD
     */

    @GetMapping(path = "/obtener-todos-catalogosMaestros.json", produces = "application/json; charset=utf-8")
    public List<CatalogoMaestro> dameTodo() throws BusinessException {
        return catalogoMaestroService.dameTodosLosCatalogosMaestros();
    }
}
