package metier;

import base.CapsuleDao;
import domaine.Capsule;

/**
 * Module 634.1-Programmation - TP P02
 * 
 * Liste des capsules avec une position courante
 *
 * @author Peter DAEHNE - HEG Genève
 * @version 2.1
 */
public class ListeCapsules extends ListeObjects {

    /** Constructeur */
    public ListeCapsules () {liste = CapsuleDao.getListeCapsules();}

    /** Retourne l'employé courant, null si la position courante est NO_POS */
    public Capsule getCapsuleCourante () {return (Capsule)super.getCourant();}

    /** Retourne l'employé d'indice k, null si k n'est pas correctement défini */
    public Capsule getCapsule (int k) {return (Capsule)super.get(k);}
  
} // ListeCapsules
