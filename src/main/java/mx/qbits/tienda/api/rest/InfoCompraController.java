package mx.qbits.tienda.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.qbits.tienda.api.model.domain.InfoCompra;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.service.InfoCompraService;

@RestController
@RequestMapping(value = "/api") 
public class InfoCompraController {
	
	private InfoCompraService infoCompraService;
	
	public InfoCompraController(InfoCompraService infoCompraService) {
		this.infoCompraService = infoCompraService;
	}
	
	/**
     * 
     * @param idComprador
     * @return
     * @throws BusinessException
     */
    @GetMapping(path = "/obtener-info-comprado.json", produces = "application/json; charset=utf-8")
    public InfoCompra consultarComprado(int idAnuncio) throws BusinessException {
        return infoCompraService.consultaAnuncioComprado(idAnuncio);
    } 
	 

}
