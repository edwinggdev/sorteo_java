
package com.example.demo.models;

public class Imagen {
    String url;
    String texto;

    public Imagen(String url, String texto) {
        this.url = url;
        this.texto = texto;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
}
