/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PiEntities;
    import java.time.LocalDate;
import PiEntities.Event;

/**
 *
 * @author Lenovo
 */
public class Publicite {

    private int id;
    private String nom;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Event event;

    public Publicite() {
    }

    public Publicite(int id, String nom, LocalDate dateDebut, LocalDate dateFin, Event event) {
        this.id = id;
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.event = event;
    }

    public Publicite(String nom, LocalDate dateDebut, LocalDate dateFin, Event event) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.event = event;
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

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

   

    @Override
    public String toString() {
        return "Publicite{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", evenement=" + event +
                '}';
    }
}


