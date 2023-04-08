/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PiServices;

import PiEntities.Publicite;
import PiUtils.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import PiEntities.Event;

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
public class PubliciteService {
    private Connection cnx; 
    
    public PubliciteService() {
        cnx = MyConnection.getInstance().getCnx();
    }
    
    
    
    
    
    
    
    
    
    
    
       public void ajouterPublicite(Publicite publicite) {
    try {
        String requete = "INSERT INTO publicite(nom, dateDebut, dateFin, eventId) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = cnx.prepareStatement(requete);
        ps.setString(1, publicite.getNom());
        ps.setDate(2, Date.valueOf(publicite.getDateDebut()));
        ps.setDate(3, Date.valueOf(publicite.getDateFin()));
        ps.setInt(4, publicite.getEvent().getId());
        ps.execute();
        System.out.println("Publicité ajoutée avec succès !");
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
}
        
    
    public void modifierPublicite(Publicite publicite) {
        try {
            String requete = "UPDATE publicite SET nom = ?, dateDebut = ?, dateFin = ?, eventId = ? WHERE id = ?";
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, publicite.getNom());
            ps.setDate(2, Date.valueOf(publicite.getDateDebut()));
            ps.setDate(3, Date.valueOf(publicite.getDateFin()));
            ps.setInt(4, publicite.getEvent().getId());
            ps.setInt(5, publicite.getId());
            ps.executeUpdate();
            System.out.println("Publicite modifiee avec succes !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
     public void supprimerPublicite(int id) {
        try {
            String requete = "DELETE FROM publicite WHERE id = ?";
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, id);
            ps.execute();
            System.out.println("Publicité supprimée avec succès !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
     public Publicite trouverPubliciteParId(int id) {
        try {
            String requete = "SELECT * FROM publicite WHERE id = ?";
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idPublicite = rs.getInt("id");
                String nom = rs.getString("nom");
                LocalDate dateDebut = rs.getDate("dateDebut").toLocalDate();
                LocalDate dateFin = rs.getDate("dateFin").toLocalDate();
                int idEvenement = rs.getInt("evenId");
                Event evenement = new EventService().trouverEventParId(idEvenement);
                return new Publicite(idPublicite, nom, dateDebut, dateFin, evenement);
            } else {
                System.err.println("Publicite non trouvee !");
                return null;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
     
 public List<Publicite> trouverPublicitesParEvenement(int idEvenement) {
        try {
            String requete = "SELECT * FROM publicite WHERE evenement_id = ?";
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, idEvenement);
            ResultSet rs = ps.executeQuery();
            List<Publicite> publicites = new ArrayList<>();
            while (rs.next()) {
int id = rs.getInt("id");
String nom = rs.getString("nom");
LocalDate dateDebut = rs.getDate("dateDebut").toLocalDate();
LocalDate dateFin = rs.getDate("dateFin").toLocalDate();
Event event = new EventService().trouverEventParId(rs.getInt("eventId"));
Publicite pub=new Publicite(id,nom,dateDebut,dateFin,event); 
publicites.add(pub);
}
return publicites;
} catch (SQLException ex) {
System.err.println(ex.getMessage());
return null;
}
} 
 public void afficherPublicites() {
    try {
        String requete = "SELECT * FROM publicite";
        Statement statement = cnx.createStatement();
        ResultSet rs = statement.executeQuery(requete);
        while (rs.next()) {
            int id = rs.getInt("id");
            String nom = rs.getString("nom");
            LocalDate dateDebut = rs.getDate("dateDebut").toLocalDate();
            LocalDate dateFin = rs.getDate("dateFin").toLocalDate();
            Event event = new EventService().trouverEventParId(rs.getInt("eventId"));
            Publicite pub = new Publicite(id, nom, dateDebut, dateFin, event);
            System.out.println(pub);
        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
}
