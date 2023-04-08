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
public class Event {



    private int id;
    private String nom;
    private String description;
    private String lieu;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    public Event(int id, String nom, String description, String lieu, LocalDate dateDebut, LocalDate dateFin) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.lieu = lieu;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Event(String nom, String description, String lieu, LocalDate dateDebut, LocalDate dateFin) {
        this.nom = nom;
        this.description = description;
        this.lieu = lieu;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Event() {
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", nom=" + nom + ", description=" + description + ", lieu=" + lieu + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + '}';
    }

 
}
