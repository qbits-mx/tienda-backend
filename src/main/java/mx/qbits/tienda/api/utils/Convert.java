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
 * Nombre:      Convert
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia: 
 *              Creación: 5 Sep 2021 @ 08:33:53
 */
package mx.qbits.tienda.api.utils;

/**
 * Clase de soporte para convertir cantidades numericas a letras formato String
 *
 * @author Daniel Alvarez
 * @version 1.0
 */
public class Convert {

    private static final String[] UNIDADES = {"", "UN ", "DOS ", "TRES ", "CUATRO ", "CINCO ", "SEIS ", "SIETE ", "OCHO ", "NUEVE ", "DIEZ ", "ONCE ", "DOCE ", "TRECE ", "CATORCE ", "QUINCE ", "DIECISEIS", "DIECISIETE", "DIECIOCHO", "DIECINUEVE", "VEINTE"};
    private static final String[] DECENAS  = {"VENTI", "TREINTA ", "CUARENTA ", "CINCUENTA ", "SESENTA ", "SETENTA ", "OCHENTA ", "NOVENTA ", "CIEN "};
    private static final String[] CENTENAS = {"CIENTO ", "DOSCIENTOS ", "TRESCIENTOS ", "CUATROCIENTOS ", "QUINIENTOS ", "SEISCIENTOS ", "SETECIENTOS ", "OCHOCIENTOS ", "NOVECIENTOS "};

     /**
      * Método para transformar cantidades a cadena  String.
      *
      * @return String cadena convertida
      * @param n a int.
      */
     public String convertir(int n) {
          if (n<0) return "MENOS "+convertir(-n);
          if (n>=0 && n<21) return UNIDADES[n];
          if (n>=21 && n<100) return DECENAS[(n/10)-2] + ((n%10)==0 || (n/10)-2==0 ? "" : "Y ") + convertir(n%10);
          if (n==100) return "CIEN";
          if (n>100 && n<1000) return CENTENAS[(n/100)-1] + convertir(n%100);
          if (n>=1000 && n<1000000) return (n/1000)>2 ? (convertir(n/1000) + " MIL " + convertir(n%1000)) : "MIL " + convertir(n%1000) ;
          if (n>=1000000 && n<999000000) return convertir(n/1000000) + " MILLONES " + convertir(n%1000000);
          return "to big";
      }

     private int contador = 0;
     /**
      * <p>Getter for the field <code>contador</code>.</p>
      *
      * @return a int.
      */
     public int getContador() {
         return contador++;
     }
}
