/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domaine;
import java.util.Date;

/**
 *
 * @author LKABOUSSE
 */
public class Employe {
    private int noEmpl; /* Numéro de l'employé */
    private String nomEmpl; /* Nom de l'employé */
    private String prenomEmpl; /* Prénom de l'employé */
    private Fonction noFonc; /* Numéro de la fonction de l'employé */
    private Date dateEmpl; /* Date d'engagement de l'employé */
    private Departement noDept; /* Numéro de département de l'employé */
    
    public Employe (int noEmpl, String nomEmpl, String prenomEmpl, Fonction noFonc, Date dateEmpl, Departement noDept) {
        this.noEmpl=noEmpl;
        this.nomEmpl=nomEmpl;
        this.prenomEmpl=prenomEmpl;
        this.noFonc=noFonc;
        this.dateEmpl=dateEmpl;
        this.noDept=noDept;
    };
    
    public int getNoEmpl(){return noEmpl;}
    public String getNomEmpl() {return nomEmpl; }
    public String getPrenomEmpl(){return prenomEmpl; }
    public Fonction getNoFonc(){ return noFonc; }
    public Date getDateEmpl() { return dateEmpl; }
    public Departement getNoDept() { return noDept; }
    
    public String toString(){ return noEmpl + " " + prenomEmpl; }
}
