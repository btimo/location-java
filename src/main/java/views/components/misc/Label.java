package views.components.misc;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel{

    protected String nom;

    public Label(){
        super();
    }

    public Label(String nom){
        super(nom);
    }

    public Label(String nom, String police, int grasItalique, int taille){
        super(nom);
        Font f = new Font(police, grasItalique, taille);
        setFont(f);
    }

    public String getNom(){
        return nom;
    }
}
