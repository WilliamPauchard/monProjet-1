package domaine;

import java.text.DecimalFormat;

/**
 * Module 634.1-Programmation - TP P02
 * 
 * Représentation d'une commande (les commandes d'une même capsule sont regroupées: donc pas d'attribut id, ni d'attribut date).
 *
 * @author Peter DAEHNE - HEG Genève
 * @version 2.1
 */
public class Commande {
  
    private static final DecimalFormat FORMAT = new DecimalFormat("#0.00 CHF");

    private Employe employe; /* L'employé concernée par la commande */
    private Capsule capsule; /* La capsule concernée par la commande */
    private int nombre;      /* Le nombre de capsules commandées */

    /** Constructeurs */
    public Commande (Employe employe, Capsule capsule, int nombre) {
        this.employe = employe; this.capsule = capsule; this.nombre = nombre;
    } // Constructeur

    /** Accesseurs */
    public Employe getEmploye () {return employe;}
    public Capsule getCapsule () {return capsule;}
    public int getNombre () {return nombre;}
    public void incNombre (int val) {nombre += val;}

    public double getPrix () {return nombre * capsule.getPrix();}

    public boolean equals (Object obj) {return  ((Commande)obj).capsule.equals(capsule) && ((Commande)obj).employe.equals(employe);}

    public String toString () {return nombre + " x " + capsule.getNom() + " à " + FORMAT.format(capsule.getPrix());}
  
} // Commande
