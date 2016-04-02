package location.views.components.misc;

import javax.swing.*;
import java.awt.*;

/**
 * Création d'une police
 * @author Timothée Barbot
 * @author Stéphane Gâteau
 */
public class CustomFontLabel extends JLabel{

    protected String nom;

    /**
     * Constructeur par défaut
     */
    public CustomFontLabel(){
        super();
    }

    /**
     * Constructeur nom
     * @param nom nom
     */
    public CustomFontLabel(String nom){
        super(nom);
    }

    /**
     * Constructeur complet
     * @param nom nom
     * @param police police demandée
     * @param grasItalique gras ou italique?
     * @param taille taille de la police
     */
    public CustomFontLabel(String nom, String police, int grasItalique, int taille){
        super(nom);
        Font f = new Font(police, grasItalique, taille);
        setFont(f);
    }

    /**
     * Retour nom
     * @return nom
     */
    public String getNom(){
        return nom;
    }
}
