package com.sistema.alertas;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Creamos el sistema de alertas
        Systemalert alertSystem = new Systemalert();

        // Creamos algunos usuarios
        Usuario user1 = new Usuario("Juan","Perez");
        Usuario user2 = new Usuario("Ana","Aichino");

        //Registramos los usuarios al sistema
        alertSystem.registerUser(user1);
        alertSystem.registerUser(user2);

        // Creamos los temas
        Tema clima= new Tema("Clima");
        Tema deporte= new Tema("Deporte");
        Tema cumples = new Tema("Cumple");

        //Registramos los topicos al sistema
        alertSystem.registerTopic(clima);
        alertSystem.registerTopic(deporte);
        alertSystem.registerTopic(cumples);
        //Suscribo usuario a topico
        // Suscribimos a algunos usuarios a algunos temas
        user1.subscribeToTopic(clima);
        user2.subscribeToTopic(clima);
        user2.subscribeToTopic(deporte);


        // Creamos Alertas
        Informativa alerta1=new Informativa("Esta lloviendo en Buenos Aires.", LocalDateTime.of(2022,12,29,17,30),clima);
        Urgente alerta2=new Urgente("Se ha producido un terremoto en la región.", LocalDateTime.now(),clima );
        Informativa alerta3=new Informativa("Messi renueva en el psg.", LocalDateTime.of(2023,1,4,20,30),deporte );
        Urgente alerta4=new Urgente("Cumpleños de Esteban Fernandez.", LocalDateTime.of(2023,1,13,20,30),cumples );
        Urgente alerta5 = new Urgente("Cumpleaños de Juan Perez",LocalDateTime.of(2023,2,12,17,30),cumples);
        Informativa alerta6 = new Informativa("Messi vuelve a los entrenamientos el 1/15/2023.", LocalDateTime.of(2023,1,15,20,30),deporte );



        alertSystem.sendAlertas(alerta1);
        alertSystem.sendAlertas(alerta2);
        alertSystem.sendAlertas(alerta3);
        alertSystem.sendAlertas(alerta4);
        alertSystem.sendAlertas(alerta5);
        alertSystem.sendAlertas(alerta6);

        System.out.println("++++++++++++++++++++++++++++++++++++++ Usuario 1 ++++++++++++++++++++++++++++++++++++++");
        System.out.println(" Temas Subscrito ");
        System.out.println(user1.getSubscribedTopics());
        System.out.println("------------------------------------------------------------------------------------ ");
        System.out.println(" Alertas Que no expiraron ");
        System.out.println(user1.getUnexpiredAlerts());
        System.out.println(" Ordenadas por fechas ");
        System.out.println(user1.getUnreadNonExpiredAlerts());
        System.out.println("------------------------------------------------------------------------------------ ");
        System.out.println(" Todas las alertas ");
        System.out.println(user1.getAlerts());

        System.out.println("++++++++++++++++++++++++++++++++++++++ Usuario 2 ++++++++++++++++++++++++++++++++++++++");
        user2.markAlertAsRead(alerta3);
        System.out.println(" Temas Subscrito ");
        System.out.println(user2.getSubscribedTopics());
        System.out.println("------------------------------------------------------------------------------------ ");
        System.out.println(" Alertas Que no expiraron ");
        System.out.println(user2.getUnexpiredAlerts());
        System.out.println(" Ordenadas por fechas ");
        System.out.println(user2.getUnreadNonExpiredAlerts());
        System.out.println("------------------------------------------------------------------------------------ ");
        System.out.println(" Todas las alertas ");
        System.out.println(user2.getAlerts());

    }
}