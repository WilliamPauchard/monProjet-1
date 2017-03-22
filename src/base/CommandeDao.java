package base;

import domaine.Capsule;
import domaine.Commande;
import domaine.Employe;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Module 634.1-Programmation - TP P02
 * 
 * Gestion des accès à la base de données pour l'entité Commande.
 *
 * @author Peter DAEHNE - HEG-Genève
 * @version 2.1
*/
public class CommandeDao {
  
    private static final Calendar CAL = Calendar.getInstance();

    /** Retourne la liste des commandes pour l'employé emp, les commandes sont regroupées par capsule. */
    public static ArrayList getListeCommandes (Employe emp) {
        ArrayList liste = new ArrayList();
        try {
            Connection con = ConnexionBase.get();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT IdCapsule, Nombre FROM Commande WHERE IdEmploye = " + emp.getId() + " ORDER BY IdCapsule");
            if (rs.next()) {
                int idCapsule = rs.getInt("IdCapsule"); int nombreTotal = rs.getInt("Nombre");
                Capsule capsule = CapsuleDao.getCapsule(idCapsule);
                while (rs.next()) {
                    int idC = rs.getInt("IdCapsule"); int nb = rs.getInt("Nombre");
                    if (idC == idCapsule) {
                        nombreTotal += nb;
                    } else {
                        liste.add(new Commande(emp, capsule, nombreTotal));
                        idCapsule = idC; nombreTotal = nb;
                        capsule = CapsuleDao.getCapsule(idCapsule);
                    }
                }
                liste.add(new Commande(emp, capsule, nombreTotal));
            }
            stmt.close();
        }
        catch (SQLException e) {System.out.println("CommandeDao.getListeCommandes(): " + e.getMessage()); e.printStackTrace(); return null;}
        return liste;
    } // getListeCommandes

    /** Enregistre la commande */
    public static void enregistreCommande (Commande commande) {
        try {
            Connection con = ConnexionBase.get();
            String sql = "INSERT INTO Commande (IdEmploye, IdCapsule, Nombre, Date) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, commande.getEmploye().getId()); stmt.setInt(2, commande.getCapsule().getId());
            stmt.setInt(3, commande.getNombre()); stmt.setDate(4, new Date(CAL.getTimeInMillis()));
            stmt.executeUpdate();
            stmt.close();
        }
        catch (SQLException e) {System.out.println("CommandeDao.enregistreCommande(): " + e.getMessage()); e.printStackTrace();}
    } // enregistreCommande
  
} // CommandeDao
