package views;

import containers.Vehicules;
import javax.swing.*;
import java.awt.*;



public class LocationViews {
    public static  JFrame locationFrame = Fenetre.nvFenetre("Location de vehicule auto/moto",500,500);
    public static JTabbedPane donnee = Onglet.nvOnglet();

    public LocationViews() {

        // Fenetre principal
        JPanel fenetrePanel = Panel.nvPanelBox(Color.ORANGE);
        donnee.add("Choix de voiture",fenetrePanel);
        // rajout du titre
        JPanel titrePanel = Panel.nvPanelFlow(Color.ORANGE);
        JLabel reservationLabel = Label.nvLabel("Reservation de vehicule :","Calibri", Font.PLAIN, 25);
        titrePanel.add(reservationLabel);

        // Panel identification
        JPanel identifiantPanel = Panel.identification(Color.ORANGE);

        // Panel adresse
        JPanel adressePanel = Panel.adresse(Color.ORANGE);

        // Panel choix type de vehicule
        JPanel choixPanel = Panel.choixPanel("louer:",Color.ORANGE,"une auto","une moto");

        // Panel selection du vehicule
        JPanel modelPanel = Panel.nvPanelFlow(Color.ORANGE);
        JLabel constructeurModel = Label.nvLabel("Constructeur et modele :","Arial",Font.BOLD,14);
        modelPanel.add(constructeurModel);
        modelPanel.add(Panel.listeAutoMoto());

        // Panel date
        JPanel dateDepartPanel = Panel.datePanel("date de depart :", Color.ORANGE);
        JPanel dateRetourPanel = Panel.datePanel("date de retour :", Color.ORANGE);

        JPanel selectedVehicules = Panel.checkBoxPanel(Panel.listeAutoMoto(), Vehicules.get());
        JPanel listePanel = Panel.listePanel(Color.ORANGE);

        // Panel assurance
        JPanel assurancePanel = Panel.choixPanel("Voulez vous une assurance :", Color.ORANGE, "oui ", "non");


        fenetrePanel.add(titrePanel);
        fenetrePanel.add(identifiantPanel);
        fenetrePanel.add(adressePanel);
        fenetrePanel.add(choixPanel);
        fenetrePanel.add(modelPanel);
        fenetrePanel.add(dateDepartPanel);
        fenetrePanel.add(dateRetourPanel);
        fenetrePanel.add(assurancePanel);
        fenetrePanel.add(selectedVehicules);
        fenetrePanel.add(listePanel);

        locationFrame.add(donnee);
        locationFrame.setVisible(true);
    }

}
