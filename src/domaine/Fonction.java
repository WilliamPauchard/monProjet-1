/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domaine;

/**
 *
 * @author LKABOUSSE
 */
public class Fonction {
    
    private int noFonc; /* Numéro de la fonction */
    private String nomFonc; /* Nom de la fonction */
    
    public Fonction (int noFonc, String nomFonc) {
        this.noFonc=noFonc;
        this.nomFonc=nomFonc;
    }
    
    public int getNoFonc(){return noFonc;}
    public String getNomFonc() {return nomFonc; }
    
}
