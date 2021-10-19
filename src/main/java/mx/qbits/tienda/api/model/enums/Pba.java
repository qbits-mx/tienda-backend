package mx.qbits.tienda.api.model.enums;

import mx.qbits.tienda.api.model.exceptions.EnumMessage;
import mx.qbits.tienda.api.model.exceptions.NegocioException;

public class Pba {
    public static void main(String...argv) {
        NegocioException ne = new NegocioException(
                new Exception("blah, blah, blah"), 
                EnumMessage.USER_NOT_EXIST_EN, 
                "goose", 1, "tavo");
        System.out.println(ne.getLocalExceptionKey());
        
        NegocioException ne2 = new NegocioException(
                EnumMessage.USER_NOT_EXIST_ES, 
                "goose", 1, "tavo");
        System.out.println(ne2.getLocalExceptionKey());
        
    }
}
