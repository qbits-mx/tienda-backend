package mx.qbits.tienda.api.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.qbits.tienda.api.model.domain.InfoVenta;
import mx.qbits.tienda.api.model.domain.InfoCompra;
import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.service.ConsultaService;

/**
 * <p>Descripción:</p>
 * Clase controladora REST para una consulta de compra/venta
 *
 * @author  JoseRamirezRojas
 * @version 1.0-SNAPSHOT
 * @since   1.0-SNAPSHOT
 */

@RestController
@RequestMapping(value = "/api") 
public class ConsultaController{
	
	 private ConsultaService consultaService;
	 
	 /**
	  * 
	  * @param consultaService
	  */
	 public ConsultaController(ConsultaService consultaService) {
	        this.consultaService = consultaService;
	 }
	 
	 
    /**
     * 
     * @param idComprador
     * @return
     * @throws BusinessException
     */
    @GetMapping(path = "/obtener-info-vendido.json", produces = "application/json; charset=utf-8")
    public InfoVenta consultarVendido(int idAnuncio) throws BusinessException {
        return consultaService.consultaAnuncioVendido(idAnuncio);
    } 
    
	 

}