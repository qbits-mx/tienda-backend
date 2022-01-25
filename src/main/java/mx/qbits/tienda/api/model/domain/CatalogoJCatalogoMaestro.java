package mx.qbits.tienda.api.model.domain;

public class CatalogoJCatalogoMaestro {
    private int id;
    private int idMaestro;
    private String tipoCatalogo;
    private String nombre;   
    private boolean activo;
    public CatalogoJCatalogoMaestro(int id, int idMaestro, String tipoCatalogo, String nombre, boolean activo) {
        this.id = id;
        this.idMaestro = idMaestro;
        this.tipoCatalogo = tipoCatalogo;
        this.nombre = nombre;
        this.activo = activo;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdMaestro() {
        return idMaestro;
    }
    public void setIdMaestro(int idMaestro) {
        this.idMaestro = idMaestro;
    }
    public String getTipoCatalogo() {
        return tipoCatalogo;
    }
    public void setTipoCatalogo(String tipoCatalogo) {
        this.tipoCatalogo = tipoCatalogo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (activo ? 1231 : 1237);
        result = prime * result + id;
        result = prime * result + idMaestro;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((tipoCatalogo == null) ? 0 : tipoCatalogo.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CatalogoJCatalogoMaestro other = (CatalogoJCatalogoMaestro) obj;
        if (activo != other.activo)
            return false;
        if (id != other.id)
            return false;
        if (idMaestro != other.idMaestro)
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (tipoCatalogo == null) {
            if (other.tipoCatalogo != null)
                return false;
        } else if (!tipoCatalogo.equals(other.tipoCatalogo))
            return false;
        return true;
    }

}
