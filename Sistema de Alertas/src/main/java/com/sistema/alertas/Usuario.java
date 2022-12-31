package com.sistema.alertas;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

// Clase que representa a un usuario del sistema
public class Usuario {
    private String name;
    private String lastname;
    private List<Tema> subscribedTopics;
    private List<Alerta> alerts;

    public Usuario(String name,String lastname) {
        this.name = name;
        this.lastname=lastname;
        this.subscribedTopics = new ArrayList<>();
        this.alerts = new ArrayList<>();
    }


    //Suscribir un usuario a un tema
    public void subscribeToTopic(Tema topic) {
        this.subscribedTopics.add(topic);
    }

    //Temas susciptos por el usuario
    public List<Tema> getSubscribedTopics() {
        return subscribedTopics;
    }

    //Alertas del usuario
    public List<Alerta> getAlerts() {
        return alerts;
    }
    //Agregar alerta al usuario
    public void addAlert(Alerta alerta) {
        alerts.add(alerta);
    }

    //Metodo que devuelve las alertas no expiradas y no leidas
    public List<Alerta> getUnexpiredAlerts() {
        LocalDateTime now = LocalDateTime.now();
        List<Alerta> unexpiredAlerts = new ArrayList<>();
        for (Alerta alert : alerts) {
            if (alert.getExpiration().isAfter(now) && !alert.isRead()) {
                unexpiredAlerts.add(alert);
            }
        }
        return unexpiredAlerts;
    }

    //Metodo que devuelve las alertas no expiradas y no leidas ordenadas por fecha
    List<Alerta> getUnreadNonExpiredAlerts() {
        LocalDateTime now = LocalDateTime.now();
        List<Alerta> unexpiredAlerts = new ArrayList<>();
        for (Alerta alert : alerts) {
            if (alert.getExpiration().isAfter(now) && !alert.isRead()) {
                unexpiredAlerts.add(alert);
                unexpiredAlerts.sort(new AlertExpirationDateComparator());

            }
        }
        return unexpiredAlerts;
    }
    //Marcar alerta como leida
    public void markAlertAsRead(Alerta alert) {
        alert.markAsRead();
    }



    @Override
    public String toString() {
        return "Usuario{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", subscribedTopics=" + subscribedTopics +
                ", alerts=" + alerts +
                '}';
    }
}



class AlertExpirationDateComparator implements Comparator<Alerta> {
    @Override
    public int compare(Alerta a1, Alerta a2) {
        return a2.getExpiration().compareTo(a1.getExpiration());
    }


}
