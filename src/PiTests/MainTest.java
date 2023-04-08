/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PiTests;

import PiEntities.Event;
import PiEntities.Publicite;
import PiEntities.Ticket;
import PiServices.EventService;
import PiServices.PubliciteService;
import PiServices.TicketService;
import PiUtils.MyConnection;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class MainTest {
    public static void main (String[] args) {
        
       // MyConnection mc =MyConnection.getInstance() ;
       
       
     //**********Modifier Ticket*********
   /*   TicketService ticketService = new TicketService();
    
    // Afficher les tickets avant la modification
    System.out.println("Tickets avant la modification :");
    System.out.println(ticketService.afficherTickets());
    
    // Modifier un ticket
    Ticket ticketAModifier = ticketService.trouverTicketParId(5);
    ticketAModifier.setPrix(25.0);
    ticketAModifier.setType("Ticket VIP");
    ticketAModifier.setDate(LocalDate.of(2023, 7, 15));
    ticketAModifier.setEtat("indisponible");
    ticketService.modifierTicket(ticketAModifier);
    
    // Afficher les tickets après la modification
    System.out.println("Tickets après la modification :");
    System.out.println(ticketService.afficherTickets()); */
     /* EventService eventService = new EventService();
        Event event = eventService.trouverEventParId(10); // Récupérer l'événement à partir de son ID
        
        TicketService ticketService = new TicketService();
        double prix = 90.0;
        String type = "VIP";
        LocalDate date = LocalDate.of(2023, 7, 15);
        
        ticketService.ajouterTicket(prix, type, date, event);*/ 
     
     
     
     

    // Ajout de l'événement dans la base de données
  EventService eventService = new EventService();
Event event = eventService.trouverEventParId(9);

// Création d'un objet Publicite
Publicite pub = new Publicite("Bio Now ", LocalDate.of(2023, 5, 25), LocalDate.of(2023,5, 27), event);

// Ajout de la publicité dans la base de données
PubliciteService publiciteService = new PubliciteService();
publiciteService.ajouterPublicite(pub);
        publiciteService.afficherPublicites();
}   
}
