package com.sistema.alertas;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Systemalert {
    protected List<Usuario> users;
    protected List<Tema> availableTopics;


    public Systemalert() {
        this.users = new ArrayList<>();
        this.availableTopics = new ArrayList<>();
    }

    //Metodo que registra usuario al sistema
    public void registerUser(Usuario user) {
        this.users.add(user);
    }
    //Metodo que devuelve los usuarios del sistema
    public List<Usuario> getUsers() {
        return users;
    }

    //Metodo que registra temas al sistema
    public void registerTopic(Tema topic) {
        this.availableTopics.add(topic);
    }

    public List<Tema> getAvailableTopics() {
        return availableTopics;
    }

    //Metodo que envia. Si es informativa se le envia al usuario suscripto al tema, si es urgente se les envia a todos los usuarios
    public void sendAlertas(Alerta alerta) {
        if (alerta instanceof Informativa){
            for (Usuario user : this.users) {
                if (user.getSubscribedTopics().contains(alerta.getTema())) {
                    user.addAlert( alerta);
                }
            }
        }
        else if (alerta instanceof Urgente) {
            for (Usuario user : this.users) {
                user.addAlert( alerta);
            }
        }
    }




}
