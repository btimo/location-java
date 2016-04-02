package views.components.misc;

import javax.swing.*;
import java.awt.*;

public class CustomFontLabel extends JLabel{

    protected String nom;

    public CustomFontLabel(){
        super();
    }

    public CustomFontLabel(String nom){
        super(nom);
    }

    public CustomFontLabel(String nom, String police, int grasItalique, int taille){
        super(nom);
        Font f = new Font(police, grasItalique, taille);
        setFont(f);
    }

    public String getNom(){
        return nom;
    }
}
