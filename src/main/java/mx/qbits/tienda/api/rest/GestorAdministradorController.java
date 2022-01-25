package mx.qbits.tienda.api.rest;

import java.util.List;

import mx.qbits.tienda.api.service.GestorAdministradorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import mx.qbits.tienda.api.model.domain.InformacionAnuncio;
import mx.qbits.tienda.api.model.exceptions.BusinessException;

@RestController
@RequestMapping(value = "/api")
public class GestorAdministradorController {

    private GestorAdministradorService gestorAdministradorService;

    public GestorAdministradorController(GestorAdministradorService gestorAdministradorService) {
        this.gestorAdministradorService = gestorAdministradorService;
    }

    @GetMapping(path = "/gestor-novalidados.json", produces = "application/json; charset=utf-8")
    public List<InformacionAnuncio> dameNoValidados() throws BusinessException {
        return gestorAdministradorService.consultarNoValidados();
    }

    @GetMapping(path = "/gestor-validados.json", produces = "application/json; charset=utf-8")
    public List<InformacionAnuncio> dameValidados() throws BusinessException {
        return gestorAdministradorService.consultarValidados();
    }
    // http://localhost:9999/api/salva.json?id=4&correo=gus@aol.com&clave=hola
    // http://localhost:9999/api/dame-datos.json

}