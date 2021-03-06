package domaine;

import java.text.DecimalFormat;

/**
 * Module 634.1-Programmation - TP P02
 * 
 * Représentation d'une capsule (uniquement les informations qui nous intéressent dans cette application)
 *
 * @author Peter DAEHNE - HEG Genève
 * @version 2.1
 */
public class Capsule {

    private static final DecimalFormat FORMAT = new DecimalFormat("#0.00 CHF");

    private int id;      /* Identifiant */
    private String nom;  /* Nom */
    private double prix; /* Prix */

    /** Constructeurs */
    public Capsule (int id, String nom, double prix) {
        this.id = id;
        this.nom = nom; this.prix = prix;
    } // Constructeur

    /** Accesseurs */
    public int getId () {return id;}
    public String getNom () {return nom;}
    public double getPrix () {return prix;}

    public boolean equals (Object obj) {return ((Capsule)obj).id == id;}

    public String toString () {return nom + " [" + FORMAT.format(prix) + "]";}
  
} // Capsule
