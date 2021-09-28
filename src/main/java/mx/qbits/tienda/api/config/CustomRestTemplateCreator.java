/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     mx.qbits.tienda.api.config
 * Proyecto:    tienda
 * Tipo:        Clase
 * Nombre:      CustomRestTemplateCreator
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:02:30
 */
package mx.qbits.tienda.api.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import mx.qbits.tienda.api.utils.Convert;
import mx.qbits.tienda.api.utils.CreatePDF;

/**
 * Esta clase auxiliar me permitirá invocar servicios REST de otras fuentes.
 *
 * @author garellano
 * @version $Id: $Id
 */
@Configuration
public class CustomRestTemplateCreator {
    /**
     * <p>restTemplate.</p>
     *
     * @param builder a {@link org.springframework.boot.web.client.RestTemplateBuilder} object.
     * @return a {@link org.springframework.web.client.RestTemplate} object.
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
       return builder.build();
    }
    /**
     * <p>createConvert.</p>
     *
     * @return a {@link mx.qbits.tienda.api.utils.Convert} object.
     */
    @Bean
    public Convert createConvert() {
        return new Convert();
    }
    /**
     * <p>createPDF.</p>
     *
     * @param convert a {@link mx.qbits.tienda.api.utils.Convert} object.
     * @return a {@link mx.qbits.tienda.api.utils.CreatePDF} object.
     */
    @Bean
    public CreatePDF createPDF(Convert convert) {
        return null;
    }
}
