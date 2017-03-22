package metier;

import base.EmployeDao;
import domaine.Employe;

/**
 * Module 634.1-Programmation - TP P02
 * 
 * Liste des employés avec une position courante
 *
 * @author Peter DAEHNE - HEG Genève
 * @version 2.1
 */
public class ListeEmployes extends ListeObjects {

    /** Constructeur */
    public ListeEmployes () {liste = EmployeDao.getListeEmployes();}

    /** Retourne l'employé courant, null si la position courante est NO_POS */
    public Employe getEmployeCourant () {return (Employe)super.getCourant();}

    /** Retourne l'employé d'indice k, null si k n'est pas correctement défini */
    public Employe getEmploye (int k) {return (Employe)super.get(k);}
  
} // ListeEmployes
