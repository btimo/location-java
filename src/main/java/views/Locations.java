package views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Adrien on 01/04/2016.
 */
public class Locations {
    public Locations(JPanel fenetrePanel) {
        // rajout du titre
        JPanel titrePanel = Panel.nvPanelFlow(Color.ORANGE);
        JLabel reservationLabel = Label.nvLabel("Liste des locations","Calibri", Font.PLAIN, 25);
        titrePanel.add(reservationLabel);

        // Bouton rajout Ajouter une location
        JPanel ajoutPanel = Panel.nvPanelFlow(Color.ORANGE);
        JButton ajouter = new JButton("Ajouter une location");
        ajoutPanel.add(ajouter);

        Object[][] donnees = {
                {"Johnathan", "Sykes", Color.RED, true, "Tennis"},
                {"Johnathan", "Sykes", Color.RED, true, "Tennis"},
                {"Johnathan", "Sykes", Color.RED, true, "Tennis"},
                {"Johnathan", "Sykes", Color.RED, true, "Tennis"},
                {"Johnathan", "Sykes", Color.RED, true, "Tennis"},
                {"Adrien", "Sykes", Color.RED, true, "Tennis"},
                {"Johnathan", "Sykes", Color.RED, true, "Tennis"},
                {"Johnathan", "Aykes", Color.RED, true, "Tennis"},
        };

        String[] entetes = {"Prénom", "Nom", "Couleur favorite", "Homme", "Sport"};

        fenetrePanel.add(titrePanel);

        fenetrePanel.add(ajoutPanel);

        Tableau tableau = new TableauRecherche(fenetrePanel, donnees, entetes);
        tableau.generer();

    }
}
