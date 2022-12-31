package com.sistema.alertas;

import java.time.LocalDateTime;


public abstract class Alerta {
    private String message;
    private LocalDateTime expiration;
    private boolean leido;
    private Tema tema;

    public Tema getTema() {
        return tema;
    }


    public Alerta(String message, LocalDateTime expiration, Tema tema) {
        this.message = message;
        this.expiration= expiration;
        this.leido = false;
        this.tema = tema;

    }

    //Getters
    public LocalDateTime getExpiration() {
        return expiration;
    }
    public boolean isRead() {
        return leido;
    }
    public String getMessage() {
        return message;
    }
    //Setters
    public void markAsRead() {
        leido = true;
    }




    @Override
    public String toString() {
        return "Alerta{" +
                "mensaje='" + message + '\'' +
                ", expiracion=" + expiration +
                ", leido=" + leido +
                ", tema=" + tema +
                '}';
    }
}








