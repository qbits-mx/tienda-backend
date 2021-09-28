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
 * Nombre:      WebMvcConfig
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:02:47
 */
package mx.qbits.tienda.api.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Clase WebMvcConfig.
 *
 * @author garellano
 * @version $Id: $Id
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);

    @Value("${jwt.encryptor.password}")
    private String encryptKey;

    /** {@inheritDoc} */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
            .addResourceHandler("/404/**")
            .addResourceLocations("classpath:/public/error/clouds-404/");
    }

    /** {@inheritDoc} */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CustomInterceptor(encryptKey));
    }

    /** {@inheritDoc} */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        /**/
        logger.info("Disabling CORS");
        registry
            .addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("GET", "POST","PUT", "DELETE", "OPTIONS", "HEAD");
        /**/
    }

}
