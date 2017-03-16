/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import base.CapsuleDao;
import domaine.Capsule;

/**
 *
 * @author LKABOUSSE
 */
public class ListeCapsules extends ListeObjects {
    
    /** Constructeur */
    public ListeCapsules () {liste = CapsuleDao.getCapsules();}

    /** Retourne la capsule courante, null si la position courante est NO_POS */
    public Capsule getCapsuleCourante () {return (Capsule)super.getCourant();}

    /** Retourne la capsule courante d'indice k, null si k n'est pas correctement défini */
    public Capsule getCapsule (int k) {return (Capsule)super.get(k);}
    
}
