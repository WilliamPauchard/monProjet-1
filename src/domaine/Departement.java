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
public class Departement {
    private int noDept; /* Numéro du département */
    private String nomDept; /* Nom du département */
    private Lieu noLieu; /* Numéro du Lieu */
    
    public Departement (int noDept, String nomDept, Lieu noLieu) {
        this.noDept=noDept;
        this.nomDept=nomDept;
        this.noLieu=noLieu;
    };
   
    public int getNoDept(){return noDept;}
    public String getNomDept() {return nomDept; }
    public Lieu getNoLieu() { return noLieu; }
    
}
