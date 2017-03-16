/*******************************************************/
/* VOUS NE DEVEZ EN PRINCIPE PAS MODIFIER CETTE CLASSE */
/* Si vous le faites, indiquez vos nom et prénom dans  */
/* l'entête ci-dessous.*/
/* LKABOUSSE Yan */
/*******************************************************/
package domaine;

import java.sql.Date;
import java.text.DecimalFormat;

/**
 * 634.1 - Programmation - TP P02
 * 
 * Représentation d'une commande (les commandes d'une même capsule sont regroupées: donc pas d'attribut id, ni d'attribut date).
 *
 * @author Peter DAEHNE - HEG Genève
 * @version 1.0
 */
public class Commande {
  
    private static final DecimalFormat FORMAT = new DecimalFormat("#0.00 CHF");

    private Employe employe; /* L'employé concernée par la commande */
    private Capsule capsule; /* La capsule concernée par la commande */
    private int nombre;      /* Le nombre de capsules commandées */
    private Date date;       /* La date de la commande */
    
    /** Constructeurs */
    public Commande (Employe employe, Capsule capsule, int nombre, Date date) {
        this.employe = employe; this.capsule = capsule; this.nombre = nombre; this.date = date;
    } // Constructeur

    /** Accesseurs */
    public Capsule getCapsule () {return capsule;}
    
    /*Ajout d'une méthode getEmploye() afin de d'accéder à l'employé. Voir CommandeDao.addCommande(). */
    public Employe getEmploye() { return employe; }
    
    public int getNombre () {return nombre;}
    
    public double getPrix () {return nombre * capsule.getPrix();}
    
    public Date getDate(){ return date; }

    public boolean equals (Object obj) {return ((Commande)obj).employe.equals(employe) && ((Commande)obj).capsule.equals(capsule);}

    public String toString () {return nombre + " x " + capsule.getNom() + " à " + FORMAT.format(capsule.getPrix());}
    

  
} // Commande
