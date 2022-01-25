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
 * Tipo:        Clase
 * Nombre:      MailSenderServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:30:56
 */
package mx.qbits.tienda.api.support;

import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.model.exceptions.CustomException;

import static mx.qbits.tienda.api.model.enumerations.EnumMessage.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Descripción:
 * </p>
 * Implementacion del servicio de envio de mail.
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
@Service
public class MailSenderServiceImpl implements MailSenderService {

    private static final String ERROR_IN_MAIL_SERVICE_SEND_HTML_MAIL_METHOD = "error in mail service sendHtmlMail method {}";

    /** logger. */
    private Logger logger = LoggerFactory.getLogger(MailSenderServiceImpl.class);

    /** java mail sender. */
    private JavaMailSender javaMailSender;

    /** Constante NUM_QUICK_SERVICE_THREADS. */
    public static final int NUM_QUICK_SERVICE_THREADS = 20;

    /** quick service. */
    private ScheduledExecutorService quickService = Executors
            .newScheduledThreadPool(NUM_QUICK_SERVICE_THREADS);

    /**
     * CBDI Constructor.
     *
     * @param javaMailSender (avoiding Autowire)
     */
    public MailSenderServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    /** {@inheritDoc} */
    @Override
    public String sendMail2(String to, String subject, String body) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(to);
        mail.setSubject(subject);
        mail.setText(body);
        logger.info("Sending...");
        javaMailSender.send(mail);
        logger.info("Done!");
        return "";
    }

    /** {@inheritDoc} */
    @Override
    @Async
    public String sendHtmlMail(String to, String subject, String body) {
        try {
            MimeMessage mail = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true);
            javaMailSender.send(mail);
            return "succeed";
        } catch (MessagingException me) {
            logger.error(ERROR_IN_MAIL_SERVICE_SEND_HTML_MAIL_METHOD, me.getMessage());
            return ERROR_IN_MAIL_SERVICE_SEND_HTML_MAIL_METHOD;
        }
    }

    /** {@inheritDoc} */
    @Override
    @Async
    public String sendHtmlMail(HelperConfig helperConfig) throws BusinessException {
        try {
            MimeMessage mail = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helperConfig.configure(helper);
            javaMailSender.send(mail);
            return "";
        } catch (MessagingException me) {
            throw new CustomException(SEND_MAIL);
        }
    }

    /** {@inheritDoc} */
    @Override
    @Async
    public String sendHtmlMail2(String to, String subject, String body, File file) {
        try {
            MimeMessage mail = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.addAttachment("Adjuntinto", file);
            helper.setSubject(subject);
            helper.setText(body, true);
            javaMailSender.send(mail);
            return "";
        } catch (MessagingException me) {
            logger.error(ERROR_IN_MAIL_SERVICE_SEND_HTML_MAIL_METHOD, me.getMessage());
            return ERROR_IN_MAIL_SERVICE_SEND_HTML_MAIL_METHOD;
        }
    }

    /** {@inheritDoc} */
    @Override
    public String sendASynchronousHtmlMail(String to, String subject, String body) {
        logger.debug("inside sendASynchronousMail method");
        MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true);
        } catch (MessagingException me) {
            logger.error(ERROR_IN_MAIL_SERVICE_SEND_HTML_MAIL_METHOD, me.getMessage());
        }
        // FROM:
        // https://www.oodlestechnologies.com/blogs/Asynchronous-Mail-In-Spring-Boot/
        quickService.submit(() -> {
            try {
                javaMailSender.send(mail);
            } catch (Exception e) {
                logger.error("Exception occur while send a mail : ", e);
            }
        });
        return "";
    }

    /** {@inheritDoc} */
    @Override
    public String getTemplate(String user, String randStr) throws CustomException {
        String archivo = "public/mail/templateMail.html";
        try {
            // Accedemos al recurso
            InputStream resource = new ClassPathResource(archivo).getInputStream();
            // Leemos el recurso
            BufferedReader reader = new BufferedReader( new InputStreamReader(resource));
            String template = reader.lines().collect(Collectors.joining("\n"));
            // remplazamos el contenido:
            template = template.replace("%NAME%",user);
            template = template.replace("%TOKEN%",randStr);
            return template;
        } catch (IOException e) {
            throw new CustomException(e, INTERNAL_SERVER, "No se ha podido leer el archivo " + archivo);
        }
    }
}
