package com.sistema.alertas;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Informativa extends Alerta  {

    public Informativa(String mensaje, LocalDateTime expiracion, Tema tema) {
        super(mensaje, expiracion, tema);
    }


}
