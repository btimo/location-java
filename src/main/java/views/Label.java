package views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sgate on 23/03/2016.
 */
public class Label {
    protected String nom;
    public static JLabel nvLabel(String nom, String police , int grasItalique, int taille){

        JLabel label = new JLabel(nom);
        Font f = new Font(police, grasItalique, taille);
        label.setFont(f);
        return  label;
    }
    public static JLabel nvLabel(String nom){
        JLabel label = new JLabel(nom);
        return label;

    }
    public String getNom(){return nom;}
}
