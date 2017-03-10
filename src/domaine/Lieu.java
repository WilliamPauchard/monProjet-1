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
public class Lieu {
    private int noLieu; /* Numéro de la fonction */
    private String nomLieu; /* Nom de la fonction */
    
    public Lieu (int noLieu, String nomLieu) {
        this.noLieu=noLieu;
        this.nomLieu=nomLieu;
    };
   
    public int getNoLieu(){return noLieu;}
    public String getNomLieu() {return nomLieu; }
    
    
}
