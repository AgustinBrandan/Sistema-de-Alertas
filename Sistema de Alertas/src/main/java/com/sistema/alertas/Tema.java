package com.sistema.alertas;
public class Tema {
    private String tema;

    public Tema(String tema) {
        this.tema = tema;
    }

    public String getTema() {
        return tema;
    }

    @Override
    public String toString() {
        return "Tema{" +
                "tema='" + tema + '\'' +
                '}';
    }
}

