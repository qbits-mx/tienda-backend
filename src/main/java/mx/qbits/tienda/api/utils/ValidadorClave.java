/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.utils
 * Proyecto:    petstore-back
 * Tipo:        Clase
 * Nombre:      ValidadorClave
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:36:30
 */
package mx.qbits.tienda.api.utils;

//import static io.kebblar.petstore.api.model.enumerations.EnumMessage.INTERNAL_SERVER;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.passay.*;

import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.model.exceptions.CustomException;
import mx.qbits.tienda.api.model.exceptions.StrengthPasswordValidatorException;
import static mx.qbits.tienda.api.model.enumerations.EnumMessage.*;

/**
 * <p>ValidadorClave class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 */
public class ValidadorClave {

    private ValidadorClave() {}

    /**
     * <p>validate.</p>
     *
     * @param clave a {@link java.lang.String} object.
     * @return a boolean.
     * @throws BusinessException if any
     */
    public static boolean validate(String clave) throws BusinessException {
        List<Rule> rules = new ArrayList<>();
        //Rule 1: Password length should be in between
        //8 and 16 characters
        rules.add(new LengthRule(8, 16));
        //Rule 2: No whitespace allowed
        rules.add(new WhitespaceRule());
        //Rule 3.a: At least one Upper-case character
        rules.add(new CharacterRule(EnglishCharacterData.UpperCase, 1));
        //Rule 3.b: At least one Lower-case character
        rules.add(new CharacterRule(EnglishCharacterData.LowerCase, 1));
        //Rule 3.c: At least one digit
        rules.add(new CharacterRule(EnglishCharacterData.Digit, 1));
        //Rule 3.d: At least one special character
        rules.add(new CharacterRule(EnglishCharacterData.Special, 1));

        Properties props = new Properties();
        InputStream is = ValidadorClave.class.getClassLoader().getResourceAsStream("passay.properties");
        try {
            props.load(is);
        } catch (IOException e) {
            throw new CustomException(e, INTERNAL_SERVER);
        }
        MessageResolver resolver = new PropertiesMessageResolver(props);
        PasswordValidator validator = new PasswordValidator(resolver, rules);

        PasswordData password = new PasswordData(clave);
        RuleResult result = validator.validate(password);


        if(!result.isValid()) { // NOT valid !!!!
           List<String> messages = validator.getMessages(result);
           StringBuilder sb = new StringBuilder();
           for(String msg : messages) {
               sb.append(msg);
               sb.append("\n");
           }
           throw new StrengthPasswordValidatorException(messages);
        }
        return true;
    }
}