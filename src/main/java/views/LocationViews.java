package views;

import views.components.misc.*;
import views.components.tab.Emprunteurs;
import views.components.tab.Exemplaires;
import views.components.tab.Locations;
import views.components.tab.Vehicules;

import javax.swing.*;
import java.awt.*;



public class LocationViews {
    public static JFrame locationFrame = Fenetre.nvFenetre("LocAppli",600,600);
    public static JTabbedPane tabs;

    public LocationViews() {

        // Fenetre principale
        JPanel fenetrePanel = views.components.misc.Panel.nvPanelBox(Color.ORANGE);
        // Tabs = container des onglets
        tabs = Onglet.nvOnglet();
        tabs.addTab("Locations",new Locations());
        tabs.addTab("Emprunteurs",new Emprunteurs());
        tabs.addTab("Exemplaires",new Exemplaires());
        tabs.addTab("Véhicules",new Vehicules());
        tabs.addTab("Ajout location - à bouger",fenetrePanel);

        locationFrame.add(tabs);
        locationFrame.setVisible(true);
    }
}
