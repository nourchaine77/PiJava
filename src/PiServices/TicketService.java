/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PiServices;

import PiEntities.Event;
import PiEntities.Ticket;
import PiUtils.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class TicketService {
    private Connection cnx;

    public TicketService() {
        cnx = MyConnection.getInstance().getCnx();
    }

    public void ajouterTicket(double prix, String type, LocalDate date, Event event) {
          if (event == null) {
        System.err.println("Impossible d'ajouter le ticket : l'objet Event est null.");
        return;
    }

    try {
        String requete = "INSERT INTO ticket(prix, type, date, event_id, etat) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = cnx.prepareStatement(requete);
        ps.setDouble(1, prix);
        ps.setString(2, type);
        ps.setDate(3, Date.valueOf(date));
        ps.setInt(4, event.getId());
        ps.setString(5, "disponible");
        ps.execute();
        System.out.println("Ticket ajouté avec succès !");
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
    }

    public List<Ticket> afficherTickets() {
        List<Ticket> tickets = new ArrayList<>();
        try {
            String requete1 = "SELECT * FROM ticket";
            Statement st = new MyConnection().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete1);
            while (rs.next()) {
                Ticket ticket = new Ticket();
                ticket.setId(rs.getInt(1));
                ticket.setPrix(rs.getDouble("prix"));
                ticket.setType(rs.getString("type"));
                ticket.setDate(rs.getDate("date").toLocalDate());
                ticket.setEtat(rs.getString("etat"));
                int eventId = rs.getInt("event_id");
                Event event = new EventService().trouverEventParId(eventId);
                ticket.setEvent(event);
                tickets.add(ticket);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return tickets;
    }

    public Ticket trouverTicketParId(int id) {
        Ticket ticket = null;
        try {
            String query = "SELECT * FROM ticket WHERE id=?";
            PreparedStatement statement = cnx.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                double prix = resultSet.getDouble("prix");
                String type = resultSet.getString("type");
                LocalDate date = resultSet.getDate("date").toLocalDate();
                String etat = resultSet.getString("etat");
                int eventId = resultSet.getInt("event_id");
                Event event = new EventService().trouverEventParId(eventId);
                ticket = new Ticket(id, prix, type, date, etat, event);
            }
        } catch (SQLException ex) {
            System.err.println("Error finding ticket: " + ex.getMessage());
        }
        return ticket;
    }

   public void modifierTicket(Ticket ticket) {
    try {
        String requete = "UPDATE ticket SET prix=?, type=?, date=?, event_id=?, etat=? WHERE id=?";
        PreparedStatement ps = cnx.prepareStatement(requete);
        ps.setDouble(1, ticket.getPrix());
        ps.setString(2, ticket.getType());
        ps.setDate(3, Date.valueOf(ticket.getDate()));
        ps.setInt(4, ticket.getEvent().getId());
        ps.setString(5, ticket.getEtat());
        ps.setInt(6, ticket.getId());
        ps.executeUpdate();
        System.out.println("Ticket modifié avec succès !");
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
}

public void supprimerTicket(int id) {
    try {
        String requete = "DELETE FROM ticket WHERE id=?";
        PreparedStatement ps = cnx.prepareStatement(requete);
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("Ticket supprimé avec succès !");
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
}
}
