package base;

import domaine.Employe;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Module 634.1-Programmation - TP P02
 * 
 * Gestion des accès à la base de données pour l'entité Employe.
 *
 * @author Peter DAEHNE - HEG-Genève
 * @version 2.1
*/
public class EmployeDao {
  
    /** Retourne la liste des employés, dans l'ordre des nom et prénom. */
    public static ArrayList getListeEmployes () {
        ArrayList liste = new ArrayList();
        try {
            Connection con = ConnexionBase.get();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Id, Nom, Prenom FROM Employe ORDER BY Nom, Prenom");
            while (rs.next()) {
                Employe employe = new Employe(rs.getInt("Id"), rs.getString("Nom"), rs.getString("Prenom"));
                liste.add(employe);
            }
            stmt.close();
        }
        catch (SQLException e) {System.out.println("EmployeDao.getListeEmployes(): " + e.getMessage()); e.printStackTrace(); return null;}
        return liste;
    } // getListeEmployes
  
} // EmployeDao
