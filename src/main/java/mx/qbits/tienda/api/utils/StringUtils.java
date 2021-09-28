/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o 
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es, 
 *              bajo cualquier criterio, el único dueño de la totalidad de este 
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     mx.qbits.tienda.api.utils
 * Proyecto:    tienda
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
}
