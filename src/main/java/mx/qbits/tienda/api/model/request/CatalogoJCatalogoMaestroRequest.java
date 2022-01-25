package mx.qbits.tienda.api.model.request;

public class CatalogoJCatalogoMaestroRequest {
    String nombreCatalogo;
    String nombreCatalogoMaestro;

        /**
     * Constructor por omision.
     */
    public CatalogoJCatalogoMaestroRequest() {
    }

    /**
     * Constructor basado en todos los atributos de la clase.
     * @param tipoCatalogo a {@link java.lang.String} object.
     */
    public CatalogoJCatalogoMaestroRequest(String nombreCatalogo, String nombreCatalogoMaestro) {
        this.nombreCatalogo = nombreCatalogo;
        this.nombreCatalogoMaestro = nombreCatalogoMaestro;
    }

    public String getNombreCatalogo() {
        return nombreCatalogo;
    }

    public void setNombreCatalogo(String nombreCatalogo) {
        this.nombreCatalogo = nombreCatalogo;
    }

    public String getNombreCatalogoMaestro() {
        return nombreCatalogoMaestro;
    }

    public void setNombreCatalogoMaestro(String nombreCatalogoMaestro) {
        this.nombreCatalogoMaestro = nombreCatalogoMaestro;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombreCatalogo == null) ? 0 : nombreCatalogo.hashCode());
        result = prime * result + ((nombreCatalogoMaestro == null) ? 0 : nombreCatalogoMaestro.hashCode());
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
        CatalogoJCatalogoMaestroRequest other = (CatalogoJCatalogoMaestroRequest) obj;
        if (nombreCatalogo == null) {
            if (other.nombreCatalogo != null)
                return false;
        } else if (!nombreCatalogo.equals(other.nombreCatalogo))
            return false;
        if (nombreCatalogoMaestro == null) {
            if (other.nombreCatalogoMaestro != null)
                return false;
        } else if (!nombreCatalogoMaestro.equals(other.nombreCatalogoMaestro))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CatalogoJCatalogoMaestroRequest [nombreCatalogo=" + nombreCatalogo + ", nombreCatalogoMaestro="
                + nombreCatalogoMaestro + "]";
    }

}
