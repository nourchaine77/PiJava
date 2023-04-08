/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PiEntities;

import java.time.LocalDate;

/**
 *
 * @author Lenovo
 */
public class Ticket {
    private int id;
    private double prix;
    private String type;
    private LocalDate date;
    private String etat;
    private Event event;

    public Ticket() {
    }

    public Ticket(int id, double prix, String type, LocalDate date, String etat, Event event) {
        this.id = id;
        this.prix = prix;
        this.type = type;
        this.date = date;
        this.etat = etat;
        this.event = event;
    }

    public Ticket(double prix, String type, LocalDate date, String etat, Event event) {
        this.prix = prix;
        this.type = type;
        this.date = date;
        this.etat = etat;
        this.event = event;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", prix=" + prix +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", etat='" + etat + '\'' +
                ", event=" + event +
                '}';
    }

   

    
}
