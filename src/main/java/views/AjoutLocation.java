package views;

import views.components.misc.Label;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Adrien on 01/04/2016.
 */
public class AjoutLocation {

    /*public AjoutLocation(JPanel fenetrePanel) {
        // rajout du titre
        JPanel titrePanel = Panel.nvPanelFlow(Color.ORANGE);
        JLabel reservationLabel = views.components.misc.Label.nvLabel("LocAppli","Calibri", Font.PLAIN, 25);
        titrePanel.add(reservationLabel);

        // Panel identification
        JPanel identifiantPanel = Panel.identification(Color.ORANGE);

        // Panel adresse
        JPanel adressePanel = Panel.adresse(Color.ORANGE);

        // Panel choix type de vehicule
        JPanel choixPanel = Panel.choixPanel("Type de location",Color.ORANGE,"Auto","Moto");

        // Panel selection du vehicule
        JPanel modelPanel = Panel.nvPanelFlow(Color.ORANGE);
        JLabel constructeurModel = Label.nvLabel("Choix du véhicule","Arial",Font.BOLD,14);
        modelPanel.add(constructeurModel);
        modelPanel.add(Panel.listeAutoMoto(Color.ORANGE, true));

        // Panel date
        JPanel dateDepartPanel = Panel.datePanel("Date de départ", Color.ORANGE);
        JPanel dateRetourPanel = Panel.datePanel("Date de retour", Color.ORANGE);

        //JPanel selectedVehicules = Panel.checkBoxPanel(Panel.listeAutoMoto(Color.ORANGE, true), Vehicules.get());
        JPanel listePanel = Panel.listePanel(Color.ORANGE);

        // Panel assurance
        JCheckBox assurancePanel = Panel.addCheckbox("Assurance");
        assurancePanel.setBackground(Color.ORANGE);

        fenetrePanel.add(titrePanel);
        fenetrePanel.add(identifiantPanel);
        fenetrePanel.add(adressePanel);
        fenetrePanel.add(choixPanel);
        fenetrePanel.add(modelPanel);
        fenetrePanel.add(dateDepartPanel);
        fenetrePanel.add(dateRetourPanel);
        fenetrePanel.add(assurancePanel);
        //fenetrePanel.add(selectedVehicules);
        fenetrePanel.add(listePanel);
    }*/
}
