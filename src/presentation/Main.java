package presentation;

/**
 * Module 634.1-Programmation - TP P02
 * 
 * Classe principale de l'application
 *
 * @author Peter DAEHNE - HEG Genève
 * @version 2.1
 */
public class Main {

    public static void main (String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {public void run() {new FrmMain().setVisible(true);}});
    } // main

} // Main
