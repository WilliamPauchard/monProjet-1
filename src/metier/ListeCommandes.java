/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import base.CommandeDao;
import domaine.Commande;
import domaine.Employe;
/**
 *
 * @author LKABOUSSE
 */
public class ListeCommandes extends ListeObjects{
        
    /** Constructeur */
    public ListeCommandes (Employe e) {liste = CommandeDao.getCommandes(e);}
    
     /** Retourne la commande d'indice i, null si i n'est pas correctement défini */
    public Commande getCommande (int i) {return (Commande)super.get(i);}
    
    /** Retourne la commande courante, null si la position courante est NO_POS */
    public Commande getCommandeCourrante () {return (Commande)super.getCourant();}
    
}
