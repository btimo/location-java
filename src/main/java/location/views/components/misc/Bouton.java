package location.views.components.misc;

import location.models.Auto;
import location.models.Moto;
import location.models.Vehicule;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by sgate on 23/03/2016.
 */
public class Bouton {
    public static ArrayList<JRadioButton> ouiNon = new ArrayList<>();

    public static JRadioButton radioBouton(String nom, boolean select, Color couleur) {
        JRadioButton button = new JRadioButton(nom, select);
        button.setBackground(couleur);
        return button;
    }

    public static JRadioButton radioBouton(String nom, boolean select) {
        JRadioButton button = new JRadioButton(nom, select);
        return button;
    }

    public static JButton nvSimpleBouton(String nom) {
        JButton button = new JButton(nom);
        return button;
    }

    public static JCheckBox nvCheckbox(Vehicule vehicule){
        JCheckBox checkBox;
            if (vehicule instanceof Auto) {
                checkBox = new JCheckBox(vehicule.getMarque() + " " + ((Auto) vehicule).getModele() + " " + vehicule.getExemplaires() + " ");
            }
            else{
                checkBox= new JCheckBox(vehicule.getMarque() + " " + ((Moto) vehicule).getCylindree() + " " + vehicule.getExemplaires() + " ");
            }
        return checkBox;
    }




}
