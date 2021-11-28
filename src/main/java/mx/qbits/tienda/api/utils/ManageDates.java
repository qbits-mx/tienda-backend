package mx.qbits.tienda.api.utils;

import static mx.qbits.tienda.api.model.enumerations.EnumMessage.INCORRECT_DATE;
import static mx.qbits.tienda.api.model.enumerations.EnumMessage.TOO_YOUNG;

import java.util.Date;

import mx.qbits.tienda.api.model.exceptions.BusinessException;
import mx.qbits.tienda.api.model.exceptions.CustomException;

public class ManageDates {
    
    public Date validaEdad(Date now, Date fechaNacimiento, int edadMinima) throws BusinessException {
        long diff = daysBetweenDates(now, fechaNacimiento);
        long min = 1+ 365*edadMinima + edadMinima/4; // lo último es por los años biciestos que suman 1 a cada 4 (y el 1 es porque debe ser MAYOR que)
        if(diff<min) throw new CustomException(TOO_YOUNG, edadMinima);
        return fechaNacimiento;
    }
    
    @SuppressWarnings("deprecation")
    public Date validaFechaPropuesta(int anio, int mes, int dia) throws BusinessException {
        if(dia>31)
            avisa("Ningún mes posee mas de 31 dias");
        
        if( (dia==31) && (mes==2 || mes==4 || mes==6 || mes==9 || mes==11) )
            avisa("El mes " + mes + "NO posee "+dia+" dias");

        if(dia>=30 && mes==2)
            avisa("Febrero no posee "+dia+" dias");

        if(dia==29 && mes==2 && anio%4!=0) {
            avisa("Febrero no fué biciesto en el "+anio);
        }
        
        return new Date(anio-1900, mes-1, dia);
    }
    
    private void avisa(String msg) throws CustomException {
        throw new CustomException(INCORRECT_DATE, msg);
    }
    
    /**
     * <p>daysBetweenDates.</p>
     *
     * @param startDate a {@link java.util.Date} object.
     * @param endDate a {@link java.util.Date} object.
     * @return a int.
     */
    public long daysBetweenDates(Date startDate, Date endDate) {
        long unDia = 24 * 60 * 60 * 1000L;
        long diff = endDate.getTime() - startDate.getTime();
        long diffDays = diff / unDia;            
        return Math.abs(diffDays);
    }
    
}
