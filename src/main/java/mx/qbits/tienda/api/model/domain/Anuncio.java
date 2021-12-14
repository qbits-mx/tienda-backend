package mx.qbits.tienda.api.model.domain;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Anuncio {
    private int id;
    private String descripcion;
    private Boolean validado;


    public Anuncio(int id,
                   String descripcion,
                   Boolean validado) {
        this.id = id;
        this.descripcion = descripcion;
        this.validado = validado;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    public Boolean getValidado() {
        return validado;
    }

    public void setValidado(Boolean validado) {
        this.validado = validado;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anuncio anuncio = (Anuncio) o;
        return id == anuncio.id &&
                descripcion.equals(anuncio.descripcion) &&
                validado.equals(anuncio.validado) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion, validado);
    }

    @Override
    public String toString() {
        return "Anuncio{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", validado=" + validado +
                '}';
    }
}
