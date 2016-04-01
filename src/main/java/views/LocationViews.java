package views;

import containers.Vehicules;
import javax.swing.*;
import java.awt.*;



public class LocationViews {
    public static  JFrame locationFrame = Fenetre.nvFenetre("LocAppli",500,500);
    public static JTabbedPane donnee = Onglet.nvOnglet();

    public LocationViews() {

        // Fenetre principale
        JPanel fenetrePanel = Panel.nvPanelBox(Color.ORANGE);
        donnee.add("Choix de voiture",fenetrePanel);
        // rajout du titre
        JPanel titrePanel = Panel.nvPanelFlow(Color.ORANGE);
        JLabel reservationLabel = Label.nvLabel("LocAppli","Calibri", Font.PLAIN, 25);
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

        //JPanel selectedVehicules = Panel.checkBoxPanel(Panel.listeAutoMoto(Color.ORANGE).getSelectedObjects());
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

        locationFrame.add(donnee);
        locationFrame.setVisible(true);
    }

}
