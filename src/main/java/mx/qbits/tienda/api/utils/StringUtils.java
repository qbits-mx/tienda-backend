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
 * Nombre:      StringUtils
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:36:21
 */
package mx.qbits.tienda.api.utils;

import java.security.SecureRandom;

/**
 * <p>StringUtils class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 */
public class StringUtils {
    /**
     * <p>main.</p>
     *
     * @param s a {@link java.lang.String} object.
     */
    public static void main(String...s) {
        System.out.println(limpia("+82 (54) 16@91-3070#"));
    }

    /**
     * <p>limpia.</p>
     *
     * @param s a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public static String limpia(String s) {
        String result = "";
        int len = s.length();
        for(int i=0; i<len; i++) {
            result = result + separa(s.charAt(i));
        }
        return result.replaceAll("@", "");
    }

    private static char separa(char s) {
        if(s>47 && s<=57) return s;
        return '@';
    }
    

    /**
     * Retorna una cadena de 'len' caracteres aleatoria
     *
     * @param len longitud de la cadena retornada
     * @return String aleatorio
     */
    public static String getRandomString(int len) {
        StringBuilder result = new StringBuilder();
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for(int i =0; i<len; i++) {
            SecureRandom random = new SecureRandom();
            int num = random.nextInt(base.length());
            result.append(base.charAt(num));
        }
        return result.toString();
    }
}
