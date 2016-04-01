package views;

import containers.Vehicules;
import javax.swing.*;
import java.awt.*;



public class LocationViews {
    public static JFrame locationFrame = Fenetre.nvFenetre("LocAppli",600,600);
    public static JTabbedPane tabs;

    public LocationViews() {

        // Fenetre principale
        JPanel fenetrePanel = Panel.nvPanelBox(Color.ORANGE);
        JPanel fenetrePanel2 = Panel.nvPanelBox(Color.ORANGE);
        JPanel fenetrePanel3 = Panel.nvPanelBox(Color.ORANGE);
        JPanel fenetrePanel4 = Panel.nvPanelBox(Color.ORANGE);
        JPanel fenetrePanel5 = Panel.nvPanelBox(Color.ORANGE);
        // Tabs = container des onglets
        tabs = Onglet.nvOnglet();
        tabs.addTab("Locations",fenetrePanel5);
        tabs.addTab("Emprunteurs",fenetrePanel2);
        tabs.addTab("Exemplaires",fenetrePanel3);
        tabs.addTab("Véhicules",fenetrePanel4);
        tabs.addTab("Ajout location - à bouger",fenetrePanel);

        new AjoutLocation(fenetrePanel);
        new Locations(fenetrePanel5);

        locationFrame.add(tabs);
        locationFrame.setVisible(true);
    }

}
