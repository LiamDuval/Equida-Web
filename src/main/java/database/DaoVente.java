/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cheval;
import model.Lieu;
import model.Lot;
import model.Vente;

/**
 *
 * @author sio2
 */
public class DaoVente {
    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;
    
    
     public static ArrayList<Vente> getLesVentes(Connection cnx) {
        ArrayList<Vente> lesVentes = new ArrayList<Vente>();
        try {
            requeteSql = cnx.prepareStatement(
            "SELECT v.id as v_id, v.nom as v_nom, " +
            "l.id as l_id, l.ville as l_ville " +
            "FROM vente v " +
            "JOIN lieu l ON v.lieu_id = l.id"
        );
            resultatRequete = requeteSql.executeQuery();
            while (resultatRequete.next()) {
                Vente v = new Vente();
                v.setId(resultatRequete.getInt("v_id"));
                v.setNom(resultatRequete.getString("v_nom"));
                Lieu l = new Lieu();
                l.setId(resultatRequete.getInt("l_id"));
                l.setVille(resultatRequete.getString("l_ville"));
                v.setLieu(l);
                lesVentes.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getLesChevaux a généré une exception SQL");
        }
        return lesVentes;
    }

     
  public static Vente getLaVente(Connection cnx, int idVente) {
        Vente vente = null;
        try {
    requeteSql = cnx.prepareStatement(
        "SELECT v.id AS v_id, v.nom AS v_nom, v.dateDebutVente AS v_dateDebutVente, " +
        "l.id AS l_id, l.ville AS l_ville " +
        "FROM vente v " +
        "JOIN lieu l ON v.lieu_id = l.id " +
        "WHERE v.id = ? " 

    );

            requeteSql.setInt(1, idVente);
            resultatRequete = requeteSql.executeQuery();
            if (resultatRequete.next()) {
                vente = new Vente();
                vente.setId(resultatRequete.getInt("v_id"));
                vente.setNom(resultatRequete.getString("v_nom"));
                java.sql.Date sqlDate = (resultatRequete.getDate("v_dateDebutVente"));
                vente.setDateDebutVente(sqlDate !=null ? sqlDate.toLocalDate() : null);
                
                
                
                Lieu lieu = new Lieu();
                lieu.setId(resultatRequete.getInt("l_id"));
                lieu.setVille(resultatRequete.getString("l_ville"));
                vente.setLieu(lieu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getLaVente a généré une exception SQL");
        }
        return vente;
    }
     
  public static boolean ajouterVente(Connection cnx, Vente vente) {
    try {
        requeteSql = cnx.prepareStatement(
            "INSERT INTO vente (nom, dateDebutVente, race_id) VALUES (?, ?, ?)",
            PreparedStatement.RETURN_GENERATED_KEYS
        );
        requeteSql.setString(1, vente.getNom());
        
        // Gestion de la date de naissance
        if (vente.getDateDebutVente() != null) {
            requeteSql.setDate(2, java.sql.Date.valueOf(vente.getDateDebutVente()));
        } else {
            requeteSql.setNull(2, java.sql.Types.DATE);
        }
        
        requeteSql.setInt(3, vente.getLieu().getId());
        
        int result = requeteSql.executeUpdate();
        
        if (result == 1) {
            // Récupération de l'id auto-généré
            ResultSet rs = requeteSql.getGeneratedKeys();
            if (rs.next()) {
                vente.setId(rs.getInt(1));
            }
            return true;
        }
        return false;
        
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Erreur lors de l'ajout du vente");
        return false;
    }



  }

  
  public static ArrayList<Lot> getLesLots(Connection cnx, int idVente) {
             ArrayList<Lot> lesLots = new ArrayList<>();
             String sql = "SELECT l.id AS lot_id, l.prixDepart AS lot_prixDepart, " +
                          "c.id AS c_id, c.nom AS c_nom " +
                          "FROM lot l " +
                          "INNER JOIN cheval c ON l.cheval_id = c.id " +
                          "WHERE l.vente_id = ? ";

             try (PreparedStatement ps = cnx.prepareStatement(sql)) {
                 ps.setInt(1, idVente);
                 try (ResultSet rs = ps.executeQuery()) {
                     while (rs.next()) {
                         // Création du cheval
                         Cheval cheval = new Cheval();
                         cheval.setId(rs.getInt("c_id"));
                         cheval.setNom(rs.getString("c_nom"));

                         // Création du lot
                         Lot lot = new Lot();
                         lot.setId(rs.getInt("lot_id"));
                         lot.setPrixDepart(rs.getString("lot_prixDepart"));
                         lot.setCheval(cheval); // association cheval → lot

                         lesLots.add(lot);
                     }
                 }
             } catch (SQLException e) {
                 e.printStackTrace();
                 System.out.println("La requête getLesLots a échoué");
             }
             return lesLots;
         }

}
