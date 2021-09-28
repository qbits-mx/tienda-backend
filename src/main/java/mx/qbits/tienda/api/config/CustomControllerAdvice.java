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
 * Nombre:      CustomControllerAdvice
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 4 Sep 2021 @ 20:02:00
 */
package mx.qbits.tienda.api.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.qbits.tienda.api.model.exceptions.ControllerException;
import mx.qbits.tienda.api.model.exceptions.StrengthPasswordValidatorException;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controlador que manejara las excepciones lanzadas por los demas
 * controladores.
 *
 * @author garellano
 * @version $Id: $Id
 */
@ControllerAdvice
public class CustomControllerAdvice {

    /*
     * Logger para la clase CustomControllerAdvice.
     * Take a look at:
     * https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/400
     */
    private Logger logger = LoggerFactory.getLogger(CustomControllerAdvice.class);

    /**
     * <p>userErrorHandler.</p>
     *
     * @param geEx a {@link mx.qbits.tienda.api.model.exceptions.StrengthPasswordValidatorException} object.
     * @return a {@link org.springframework.http.ResponseEntity} object.
     */
    @ResponseBody
    @ExceptionHandler(value = StrengthPasswordValidatorException.class)
    public ResponseEntity<Map<String, Object>> userErrorHandler(StrengthPasswordValidatorException geEx) {
        logger.error(getStackTraceExStr(geEx));
        return new ResponseEntity<>(buildValidationErrorResponse(geEx), HttpStatus.BAD_REQUEST);
    }

    /**
     * Método que maneja las excepciones de {@link org.springframework.web.bind.MethodArgumentNotValidException}.
     *
     * @param geEx la excepcion que manejará (de tipo MethodArgumentNotValidException).
     * @return un ResponseEntity con los valores a mostrarse en el JSON de salida.
     */
    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> userErrorHandler(MethodArgumentNotValidException geEx) {
        Map<String, Object> lista = buildValidationErrorResponse(geEx);
        String s = lista.toString();
        logger.error(s);
        return new ResponseEntity<>(lista, HttpStatus.BAD_REQUEST);
    }

    /**
     * Método que maneja las exepciones de {@link mx.qbits.tienda.api.model.exceptions.ControllerException}.
     *
     * @param geEx la excepción que manejará (de tipo ControllerException).
     * @return un ResponseEntity con los valores a mostrarse en el JSON de salida.
     */
    @ResponseBody
    @ExceptionHandler(value = ControllerException.class)
    public ResponseEntity<Map<String, Object>> errorHandler(ControllerException geEx) {
        logger.error(getStackTraceExStr(geEx));
        int value = geEx.getHttpStatus().value();
        return new ResponseEntity<>(crearMapaRetorno(geEx), HttpStatus.valueOf(value));
    }

    /**
     * Construye una respuesta que contiene el consolidado de violaciones en una clave dada.
     *
     * @param spve
     * @return Mapa con la lista de errores detectados
     */
    private Map<String, Object> buildValidationErrorResponse(StrengthPasswordValidatorException spve) {
        List<String> messages = spve.getMessages();
        Map<String, Object> result = crearMapaRetorno(spve);
        result.put("strengthViolations", messages);
        return result;
    }

    /**
     * Mapa de retorno para errores de tipo MethodArgumentNotValidException.
     *
     * @param geEx la excepción a mapear (de tipo MethodArgumentNotValidException).
     * @return mapa de valores para una respuesta de validación de campos.
     */
    private Map<String, Object> buildValidationErrorResponse(MethodArgumentNotValidException geEx) {
        BindingResult binding = geEx.getBindingResult();
        Map<String, Object> map = new HashMap<>();
        List<Map<String, String>> lista = new ArrayList<>();
        for (ObjectError fe : binding.getAllErrors()) {
            FieldError error = (FieldError)fe;
            Map<String, String> err = new HashMap<>();
            if(error.getDefaultMessage() != null) {
                String[] arr = error.getDefaultMessage().split("\\|");
                String index = (arr.length > 1) ? arr[1] : "0";

                err.put("index", index);
                err.put("description", arr[0]);
                err.put("validationType", error.getCode());
                err.put("objectName", error.getObjectName());
                err.put("rejectedValue", error.getRejectedValue() + "");
                err.put("fieldName", error.getField());
                lista.add(err);
            }
        }
        map.put("errorType", "3001");
        map.put("errors", lista);
        return map;
    }

    /**
     * Método auxiliar que crea el objeto a mostrarse cuando se lance la excepcion.
     *
     * @param ex la excepcion a mapear
     * @return el diccionario con la excepcion mapeada
     */
    private Map<String, Object> crearMapaRetorno(Exception ex) {
        Map<String, Object> map = new HashMap<>();
        if (ex instanceof ControllerException) {
            ControllerException ad = (ControllerException) (ex);
            map.put("exceptionTypeNumber", ad.getLocalExceptionNumber());
            map.put("exceptionTypeKey", ad.getLocalExceptionKey());
            map.put("exceptionLongDescription", ad.getDetailedMessage());
            map.put("exceptionShortDescription", ad.getShortMessage());
            map.put("httpResponse",  ad.getHttpStatus());
        }
        return map;
    }

    /**
     * Método auxiliar que obtiene a traza de la excepcion completa.
     *
     * @param excepcion la excepcion que se debe rastrear
     * @return su representacion en string
     */
    private String getStackTraceExStr(Exception excepcion) {
        StringBuilder errorGenerica = new StringBuilder();
        if (excepcion instanceof ControllerException) {
            ControllerException ge = (ControllerException) (excepcion);
            errorGenerica.append("tipo: ");
            errorGenerica.append(ge.getLocalExceptionNumber());
            errorGenerica.append(": ");
            errorGenerica.append(ge.getLocalExceptionKey());
            errorGenerica.append(": ");
            errorGenerica.append(ge.getDetailedMessage());
            StringWriter errores = new StringWriter();
            ge.printStackTrace(new PrintWriter(errores));
            errorGenerica.append("\n");
        }
        return errorGenerica.toString();
    }

}

