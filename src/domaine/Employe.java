package domaine;

/**
 * Module 634.1-Programmation - TP P02
 * 
 * Représentation d'un employé
 *
 * @author Peter DAEHNE - HEG Genève
 * @version 2.1
 */
public class Employe {

    private int id;        /* Identifiant */
    private String nom;    /* Nom */
    private String prenom; /* Prénom */

    /** Constructeur */
    public Employe (int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom; this.prenom = prenom;
    } // Constructeur

    /** Accesseurs */
    public int getId () {return id;}
    public String getNom () {return nom;}
    public String getPrenom () {return prenom;}

    public boolean equals (Object obj) {return ((Employe)obj).id == id;}

    public String toString () {return nom + " " + prenom;}
  
} // Employe
