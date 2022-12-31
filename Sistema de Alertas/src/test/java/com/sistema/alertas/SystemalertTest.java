package com.sistema.alertas;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SystemalertTest {
    private Usuario user1 = new Usuario ("Juan","Perez");
    private Usuario user2 = new Usuario ("Juan","Perez");

    private Tema clima = new Tema("Clima");
    private Systemalert alertSystem = new Systemalert();

   @Test
   public void testregisterUser() {
       //Registro dos usuarios al sistema
       alertSystem.registerUser(user1); alertSystem.registerUser(user2);
       assertEquals(  2,alertSystem.getUsers().size() );
   }

   @Test
   public void testregisterTopic() {
       //Registro 1 tema al sistema
       alertSystem.registerTopic(clima);
       assertEquals(  1,alertSystem.getAvailableTopics().size() );
   }
   @Test
    public void  testsendAlertasinformativa(){
       Informativa alert1=new Informativa("Esta lloviendo en Buenos Aires.", LocalDateTime.of(2022,12,31,17,30),clima);
       //Registro tema y usuario al sistema
       alertSystem.registerTopic(clima); alertSystem.registerUser(user1); alertSystem.registerUser(user2);
       // Registro un tema al usuario
       user1.subscribeToTopic(clima);
       alertSystem.sendAlertas(alert1);
       int enviado1= user1.getAlerts().size();
       int enviado2= user2.getAlerts().size();
       assertEquals(1, enviado1+enviado2);
       //Recibe 1 ya que el usuario 2 no esta subscripto a clima y la alerta es informativa
   }

   @Test
    public void  testsendAlertasUrgentes(){
        Urgente alerta2=new Urgente("Se ha producido un terremoto en la región.", LocalDateTime.now(),clima );
        //Registro tema y usuario al sistema
        alertSystem.registerTopic(clima); alertSystem.registerUser(user1); alertSystem.registerUser(user2);
        // Registro un tema al usuario
        user1.subscribeToTopic(clima);
        alertSystem.sendAlertas(alerta2);
        int enviado1= user1.getAlerts().size();
        int enviado2= user2.getAlerts().size();
        assertEquals(2, enviado1+enviado2);
        //Recibe 2 ya que los dos usuarios reciben la alertas porque es urgente
    }






}
