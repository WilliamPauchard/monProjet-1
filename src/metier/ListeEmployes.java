/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import base.EmployeDao;
import domaine.Employe;

/**
 *
 * @author LKABOUSSE
 */
public class ListeEmployes extends ListeObjects {
    
    /** Constructeur */
    public ListeEmployes () {liste = EmployeDao.getEmployes();}

    /** Retourne l'employé courant, null si la position courante est NO_POS */
    public Employe getEmployeCourant () {return (Employe)super.getCourant();}

    /** Retourne l'employé d'indice k, null si k n'est pas correctement défini */
    public Employe getEmploye (int k) {return (Employe)super.get(k);}
}
