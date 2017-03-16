/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
/**
 *
 * @author LKABOUSSE
 */
public class CommandeDao {

    /* Récupération de toutes les commandes */
    public static ArrayList getCommandes(Employe empl){
        ArrayList alstCommandes = new ArrayList();
        try {
            Connection con = ConnexionBase.get();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM commande WHERE IdEmploye = " + empl.getId());
            while (rs.next()) {                
                Employe emp = EmployeDao.getEmploye(rs.getInt("IdEmploye"));
                Capsule cap = CapsuleDao.getCapsule(rs.getInt("IdCapsule"));
                Commande comm = new Commande(emp, cap, rs.getInt("Nombre"), rs.getDate("Date"));
                alstCommandes.add(comm);
            }
            stmt.close();
        }
        catch (SQLException e) {System.out.println("CommandeDao.getCommandes(): " + e.getMessage()); e.printStackTrace(); return null;}
        return alstCommandes;
    }
    
    /* Récupération de la commande courante*/
    public static Commande getCommande(int idCom){
         try{
            Connection con = ConnexionBase.get();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM commande WHERE Id = " + idCom);
            rs.next();
            Employe emp = EmployeDao.getEmploye(rs.getInt("IdEmploye"));
            Capsule cap = CapsuleDao.getCapsule(rs.getInt("IdCapsule"));
            Commande c = new Commande(emp, cap, rs.getInt("Nombre"), rs.getDate("Date"));
            stmt.close();
            return c;
        } catch (SQLException e) {System.out.println("CommandeDao.getCommande(): " + e.getMessage()); e.printStackTrace(); return null;}
    }
    
    /* Insertion de la commande dans la base de données */
    public static int addCommande(Commande comm){
        int id = -1;
        try {
            Connection con = ConnexionBase.get();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO commande (IdEmploye, IdCapsule, Nombre, Date) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, comm.getEmploye().getId());
            stmt.setInt(2, comm.getCapsule().getId());
            stmt.setInt(3, comm.getNombre());
            stmt.setDate(4, new Date(comm.getDate().getTime()));
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next(); id = rs.getInt(1);
            stmt.close();
        }
        catch (SQLException e) {System.out.println("CommandeDao.addCommande(): " + e.getMessage()); e.printStackTrace();}
        return id;
    }//addCommande
}//CommandeDao
