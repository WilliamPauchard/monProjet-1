/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import domaine.Capsule;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author LKABOUSSE
 */
public class CapsuleDao {

    /* Récupération de toutes les capsules */
    public static ArrayList getCapsules() {
        ArrayList alstCapsules = new ArrayList();
        try {
            Connection con = ConnexionBase.get();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM capsule ORDER BY Nom");
            while (rs.next()) {
                int id = rs.getInt("Id");
                String nom = rs.getString("Nom");
                double prix = rs.getDouble("Prix");
                Capsule caps = new Capsule(id, nom, prix);
                alstCapsules.add(caps);
            }
            stmt.close();
        }
        catch (SQLException e) {System.out.println("CapsuleDao.getCapsules(): " + e.getMessage()); e.printStackTrace(); return null;}
        return alstCapsules;
    }//getCapsules
    
    /* Récupération de la capsule courante*/
    public static Capsule getCapsule(int noCap){
        try{
            Connection con = ConnexionBase.get();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM capsule WHERE Id = " + noCap);
            rs.next();
            Capsule c = new Capsule(rs.getInt("Id"), rs.getString("Nom"), rs.getDouble("Prix"));
            stmt.close();
            return c;
        } catch (SQLException e) {System.out.println("CapsuleDao.getCapsule(): " + e.getMessage()); e.printStackTrace(); return null;}
    }//getCapsule
}
