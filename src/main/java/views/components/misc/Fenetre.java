package views.components.misc;

import javax.swing.*;

/**
 * Created by sgate on 23/03/2016.
 */
public class Fenetre {
    protected String nom;
    protected int longueur;
    protected int largeur;

    public static JFrame nvFenetre (String nom, int longueur, int largeur){
        JFrame locationFrame = new JFrame();
        locationFrame.setTitle(nom);
        locationFrame.setSize(largeur,longueur);
        locationFrame.setVisible(true);
        locationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return locationFrame;
    }



    public String getNom(){return nom;}

    public int getLongueur(){return longueur;}

    public int getLargeur(){return largeur;}
}
