/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import domaine.Employe;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
/**
 *
 * @author LKABOUSSE
 */
public class EmployeDao {
    
    /* Récupération de tous les employés */
    public static ArrayList getEmployes(){
        ArrayList alstEmployes = new ArrayList();
        try{
            Connection con = ConnexionBase.get();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employe ORDER BY Nom, Prenom");
            while (rs.next()) {
                Employe e = new Employe(rs.getInt("Id"), rs.getString("Nom"), rs.getString("Prenom"));
                alstEmployes.add(e);
            }
          stmt.close();
        }
        catch (SQLException e) {System.out.println("EmployeDao.getEmployes(): " + e.getMessage()); e.printStackTrace(); return null;}
        return alstEmployes;
    }//getEmployes
    
    /* Récupération d'un employé */
    public static Employe getEmploye(int idEmp){
        try{
            Connection con = ConnexionBase.get();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employe WHERE Id = " + idEmp);
            rs.next();
            Employe e = new Employe(rs.getInt("Id"), rs.getString("Nom"), rs.getString("Prenom"));
            stmt.close();
            return e;
        } catch (SQLException e) {System.out.println("EmployeDao.getEmploye(): " + e.getMessage()); e.printStackTrace(); return null;}
    }//getEmploye
    
}
