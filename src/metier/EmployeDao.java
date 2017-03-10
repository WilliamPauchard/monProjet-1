/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;


import domaine.Employe;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import presentation.FrmMain;

/**
 *
 * @author LKABOUSSE
 */
public class EmployeDao {
    public static ArrayList alstEmployes = new ArrayList();
    public static ArrayList getlisteEmployes(){
        try {
            Connection con = base.ConnectionBase.get();
            Statement stmtEmpl = con.createStatement();
            ResultSet rsEmpl = stmtEmpl.executeQuery("SELECT * FROM employe ORDER BY NomEmpl, PrenomEmpl");
            while(rsEmpl.next()){rsEmpl.getString("NomEmpl"); rsEmpl.getString("PrenomEmpl");  }
            stmtEmpl.close();
        }
        catch(SQLException e){  }
        return alstEmployes;
    }
}