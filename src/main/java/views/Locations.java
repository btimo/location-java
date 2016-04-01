package views;

import models.Location;
import models.LocationExemplaire;

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

        // Données tableau
        String[] entetes = {"Numéro", "Locataire", "Date début", "Date fin", "Devis accepté", "Prix TTC", "Actions"};

        Object[][] donnees = new Object[containers.Locations.get().size()][7];

        int count = 0;
        for (Location l : containers.Locations.get()) {
            donnees[count][0] = l.getId();
            donnees[count][1] = l.getEmprunteur().getDisplayName();
            donnees[count][2] = l.getDebut().toString();
            donnees[count][3] = l.getFin().toString();
            donnees[count][4] = (l.isApprouvee()) ? "Oui" : "Non";

            double prixFinal = 0;
            for (LocationExemplaire e : l.getLocationExemplaires()) {
                prixFinal += e.getPrixFinalRetour();
            }

            donnees[count][5] = prixFinal;
            donnees[count][6] = "Bouton";

            count++;
        }

        fenetrePanel.add(titrePanel);

        fenetrePanel.add(ajoutPanel);

        Tableau tableau = new TableauRecherche(fenetrePanel, donnees, entetes);
        tableau.generer();
    }
}
