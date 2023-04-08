/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PiServices;

import PiEntities.Event;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class EventService {
     private List<Event> evenements;
       Connection cnx2;  




    public EventService() {
        cnx2=MyConnection.getInstance().getCnx(); 
    }

   
     public void ajouterEvent(){ 
         try {
String requete = "INSERT INTO event(nom, lieu, description, dateDebut, dateFin) VALUES ('bbbb', 'hhh', 'hhhhh', '" + LocalDate.of(2023, 4, 2) + "', '" + LocalDate.of(2023, 4, 10) + "')";
Statement st = cnx2.createStatement();
             st.executeUpdate(requete);
             System.out.println("Event ajoute avec succes ");
         } catch (SQLException ex) {
             System.err.println(ex.getMessage());         }
       
                 
     }
 
     public void ajouterEvent(String nom, String lieu, String description, LocalDate dateDebut, LocalDate dateFin) {
    try {
        String requete = "INSERT INTO event(nom, lieu, description, dateDebut, dateFin) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = cnx2.prepareStatement(requete);
        ps.setString(1, nom);
        ps.setString(2, lieu);
        ps.setString(3, description);
        ps.setDate(4, Date.valueOf(dateDebut));
        ps.setDate(5, Date.valueOf(dateFin));
        ps.execute();
        System.out.println("Evenement ajouté avec succès !");
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
}


     
    public List<Event> afficherEvent() {
                     List<Event> events = new ArrayList<>();

         try {
             String requete1 = "SELECT * FROM event";
             Statement st=new MyConnection().getCnx().createStatement();
             ResultSet rs=st.executeQuery(requete1);
             while (rs.next()){
                 Event e=new Event(); 
                 e.setId(rs.getInt(1));
                 e.setNom(rs.getString("nom"));
                 e.setDescription(rs.getString("description"));
                 e.setLieu(rs.getString("lieu"));
                 e.setDateDebut(rs.getDate("dateDebut").toLocalDate());
                 e.setDateFin(rs.getDate("dateFin").toLocalDate());
                 events.add(e);
             }
         } catch (SQLException ex) {
             System.err.println(ex.getMessage());     
         }
         return  events;
    
}


 public Event trouverEventParId(int id) {
    Event event = null;
    try {
        String query = "SELECT * FROM event WHERE id=?";
        PreparedStatement statement = cnx2.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String nom = resultSet.getString("nom");
            String lieu = resultSet.getString("lieu");
            String description = resultSet.getString("description");
            LocalDate dateDebut = resultSet.getDate("dateDebut").toLocalDate();
            LocalDate dateFin = resultSet.getDate("dateFin").toLocalDate();
            event = new Event(id, nom, lieu, description, dateDebut, dateFin);
        }
    } catch (SQLException ex) {
        System.err.println("Error finding event: " + ex.getMessage());
    }
    return event;
}


    public void modifierEvenement(int id, String nom, String description, String lieu, LocalDate dateDebut, LocalDate dateFin) {
         try {
             String requete = "UPDATE event SET nom=?, lieu=?, description=?, dateDebut=?, dateFin=? WHERE id=?";
             PreparedStatement ps = cnx2.prepareStatement(requete);
             Event evenement = trouverEventParId(id);
             if (evenement != null) {
                evenement.setNom(nom);
            evenement.setDescription(description);
            evenement.setLieu(lieu);
            evenement.setDateDebut(dateDebut);
            evenement.setDateFin(dateFin);
            evenement.setId(id);
            ps.setString(1, nom);
            ps.setString(2, lieu);
            ps.setString(3, description);
            ps.setDate(4, Date.valueOf(dateDebut));
            ps.setDate(5, Date.valueOf(dateFin));
            ps.setInt(6, id);
            ps.executeUpdate();
             }
             System.out.println("Event modifie");
         } catch (SQLException ex) {
             System.err.println(ex.getMessage());         }
    }

   public void supprimerEvenement(int id) {
    try (Connection conn = MyConnection.getInstance().getCnx();
         PreparedStatement st = conn.prepareStatement("DELETE FROM event WHERE id=?")) {
        st.setInt(1, id);
        int rowsDeleted = st.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("L'événement avec l'ID " + id + " a été supprimé avec succès.");
        } else {
            System.out.println("Aucun événement trouvé avec l'ID " + id);
        }
    } catch (SQLException ex) {
        Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
    }
}


 
    
}
