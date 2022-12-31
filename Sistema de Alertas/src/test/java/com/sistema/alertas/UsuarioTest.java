package com.sistema.alertas;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioTest {
    private Usuario user = new Usuario ("Juan","Perez");
    private Tema clima = new Tema("Clima");
    private Informativa alert=new Informativa("Esta lloviendo en Buenos Aires.", LocalDateTime.of(2022,12,29,17,30),clima);
    private Urgente alerta2=new Urgente("Se ha producido un terremoto en la región.", LocalDateTime.now(),clima );

    @Test
    public void testAddAlert() {
        user.addAlert(alert);
        user.addAlert(alerta2);
        assertEquals(  2, user.getAlerts().size());
        assertEquals(alert,user.getAlerts().get(0));
    }

}
