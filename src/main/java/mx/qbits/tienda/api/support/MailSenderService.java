/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     mx.qbits.tienda.api.support
 * Proyecto:    tienda
 * Tipo:        Interface
 * Nombre:      MailSenderService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:30:40
 */
package mx.qbits.tienda.api.support;

import java.io.File;
import org.springframework.mail.javamail.MimeMessageHelper;

import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.model.exceptions.CustomException;

/**
 * <p>
 * Descripción:
 * </p>
 * Interface asociado al servicio de envio de mail.
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public interface MailSenderService {

    /**
     * Envio correo electronicos desde la aplicacion chatbot.
     *
     * @param to      Cadena con los correos electronicos a los que se el mensaje
     *                que genera el chatbot
     * @param subject Cadena con el titulo del correo electronico
     * @param body    Cadena con el cuerpo del mensaje que se envia desde el chatbot
     * @return a {@link java.lang.String} object.
     */
    String sendMail2(String to, String subject, String body);

    /**
     * Envio del chatbot por medio de JavaMailSender.
     *
     * @param to      Cadena con los correos electronicos a quienes se desea enviar
     *                el correo generado
     * @param subject Cadena con el titulo del correo electronico
     * @param body    Cadena con el cuerpodo del mensaje de correo
     * @return a {@link java.lang.String} object.
     */
    String sendHtmlMail(String to, String subject, String body);

    /**
     * Envio del chatbot por medio de JavaMailSender.
     *
     * @param to      Cadena con los correos electronicos a quienes se desea enviar
     *                el correo generado
     * @param subject Cadena con el titulo del correo electronico
     * @param body    Cadena con el cuerpodo del mensaje de correo
     * @param file    the file
     * @return a {@link java.lang.String} object.
     */
    String sendHtmlMail2(String to, String subject, String body, File file);

    /**
     * Este método usa un pool de executors para hacer su trabajo de manera
     * asíncrona.
     *
     * @param to      the to
     * @param subject the subject
     * @param body    the body
     * @return a {@link java.lang.String} object.
     */
    String sendASynchronousHtmlMail(String to, String subject, String body);

    /**
     * Envia un correo usando un HelperConfig para personalizar los parametros del
     * mensaje.
     *
     * @param helperConfig Helper que recibe el objeto MimeMessageHelper
     * @return a {@link java.lang.String} object.
     * @throws mx.qbits.tienda.api.model.exceptions.BusinessException if any.
     */
    String sendHtmlMail(HelperConfig helperConfig) throws BusinessException;

    /**
     * Clase auxiliar para exponer el MimeMessageHelper a los clientes.
     *
     * @author Jacob Lobaco
     *
     */
    public interface HelperConfig {
        /**
         * Configura el mensaje a enviar.
         *
         * @param helper El objeto que se utiliza para configurar el mensaje.
         * @throws MessagingException En caso de error al configurar el mensaje.
         */
        String configure(MimeMessageHelper helper) throws BusinessException;
    }
    
    /**
     * Obtiene una plantilla para el envío de un correo con formato HTML
     * @param user
     * @param randStr
     * @return
     * @throws CustomException
     */
    String getTemplate(String user, String randStr) throws CustomException;
}
