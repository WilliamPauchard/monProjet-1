package base;

import domaine.Capsule;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Module 634.1-Programmation - TP P02
 * 
 * Gestion des accès à la base de données pour l'entité Capsule.
 *
 * @author Peter DAEHNE - HEG-Genève
 * @version 2.1
*/
public class CapsuleDao {
  
    /** Retourne la capsule d'identifiant id */
    public static Capsule getCapsule (int id) {
        Capsule capsule = null;
        try {
            Connection con = ConnexionBase.get();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Id, Nom, Prix FROM Capsule WHERE Id = " + id);
            rs.next(); /* La base de données est intègre ! */
            capsule = new Capsule(rs.getInt("Id"), rs.getString("Nom"), rs.getDouble("Prix"));
            stmt.close();
        }
        catch (SQLException e) {System.out.println("CapsuleDao.getCapsule(): " + e.getMessage()); e.printStackTrace(); return null;}
        return capsule;
    } // getCapsule

    /** Retourne la liste complète des capsules, dans l'ordre des noms. */
    public static ArrayList getListeCapsules () {
        ArrayList liste = new ArrayList();
        try {
            Connection con = ConnexionBase.get();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Id, Nom, Prix FROM Capsule ORDER BY Nom");
            while (rs.next()) {
                Capsule capsule = new Capsule(rs.getInt("Id"), rs.getString("Nom"), rs.getDouble("Prix"));
                liste.add(capsule);
            }
            stmt.close();
        }
        catch (SQLException e) {System.out.println("CapsuleDao.getListeCapsules(): " + e.getMessage()); e.printStackTrace(); return null;}
        return liste;
    } // getListeCapsules

} // CapsuleDao
