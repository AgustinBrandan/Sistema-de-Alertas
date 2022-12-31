package com.sistema.alertas;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Urgente extends Alerta{

    public Urgente(String mensaje, LocalDateTime expiracion, Tema tema) {
        super(mensaje, expiracion, tema);
    }

}