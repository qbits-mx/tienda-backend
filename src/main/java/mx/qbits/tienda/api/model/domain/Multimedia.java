package mx.qbits.tienda.api.model.domain;

public class Multimedia {

    String url;
    boolean tipo;
    public Multimedia(String url, boolean tipo) {
        this.url = url;
        this.tipo = tipo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }




}
