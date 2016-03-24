package views;

import containers.Vehicules;
import models.Auto;
import models.Moto;
import models.Vehicule;

import javax.swing.*;
import java.awt.*;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public static JCheckBox nvCheckbox(Auto voiture){
        JCheckBox checkBox = new JCheckBox(voiture.getModele()+""+voiture.);

    }

    public static ButtonGroup nvgroupeButton( ArrayList<JRadioButton> boutons) {
        ButtonGroup groupeButton = new ButtonGroup();
        for (JRadioButton btn : boutons) {
            groupeButton.add(btn);
        }
        return groupeButton;
    }


}
