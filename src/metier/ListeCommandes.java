package metier;

import base.CommandeDao;
import domaine.Commande;
import domaine.Employe;
import java.util.Collections;
import java.util.Comparator;

/**
 * Module 634.1-Programmation - TP P02
 * 
 * Liste des commandes d'un employé avec une position courante.
 * La liste est dans l'ordre des noms de capsule (pas demandé dans l'énoncé)
 *
 * @author Peter DAEHNE - HEG Genève
 * @version 2.1
 */
public class ListeCommandes extends ListeObjects {
    
    /* Ordre des noms de capsules sur lesquelles porte la commande */
    private static final Comparator COMP = new Comparator () {
        public int compare (Object o1, Object o2) {
            Commande c1 = (Commande)o1; Commande c2 = (Commande)o2;
            return c1.getCapsule().getNom().compareTo(c2.getCapsule().getNom());
        } // compare
    };

    /** Constructeur */
    public ListeCommandes (Employe e) {
        liste = CommandeDao.getListeCommandes(e);
        Collections.sort(liste, COMP); /* Trier les commandes dans l'ordre des noms de capsule (pas demandé dans l'énoncé) */
    } // Constructeur

    /** Retourne la commande courante, null si la position courante est NO_POS */
    public Commande getCommandeCourante () {return (Commande)super.getCourant();}

    /** Retourne la commande d'indice k, null si k n'est pas correctement défini */
    public Commande getCommande (int k) {return (Commande)super.get(k);}
  
    /* Recherche c dans la liste: [algorithme de Mauchly (1946)]
       - si trouvé, retourne sa position (sous la forme d'un entier positif);
       - si pas trouvé, retourne la position où ajouter c dans l'ordre (si res = A, il faut insérer en -A-1) */
    private int posOrdre (Commande c) {
        int g = 0; int d = liste.size() - 1; /* Invariant de la boucle: g-1 <= placeDe(c) < d+1 */
        while (g <= d) {
            int m = (g + d) >>> 1;   /* int m = (g + d) / 2 */
            if (COMP.compare(getCommande(m), c) <= 0) {g = m + 1;} else {d = m - 1;}
        }
        if (d >= 0 && COMP.compare(getCommande(d), c) == 0) {return d;} else {return -g-1;}
    } // posOrdre

    /** Ajoute une commande à la liste: si la commande existe déjà, incrémente le nombre de capsules, sinon l'insère en ordre */
    public void add (Commande c) {
        int pos = posOrdre(c); 
        if (pos >= 0) {getCommande(pos).incNombre(c.getNombre());} else {super.add(c, -pos-1);}
    } // add

} // ListeCommandes
