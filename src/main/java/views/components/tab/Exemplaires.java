package views.components.tab;

import models.Auto;
import models.Exemplaire;
import models.Moto;
import views.Panel;
import views.Tableau;
import views.TableauRecherche;
import views.components.misc.Label;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class Exemplaires {
    public Exemplaires(JPanel fenetrePanel) {
        // rajout du titre
        JPanel titrePanel = Panel.nvPanelFlow(Color.ORANGE);
        JLabel reservationLabel = new Label("Liste des exemplaires","Calibri", Font.PLAIN, 25);
        titrePanel.add(reservationLabel);

        // Bouton rajout Ajouter un exemplaire
        JPanel ajoutPanel = Panel.nvPanelFlow(Color.ORANGE);
        JButton ajouter = new JButton("Ajouter un exemplaire");
        ajoutPanel.add(ajouter);

        // Données tableau
        String[] entetes = {"Numéro", "Marque", "Modèle/Cylindrée", "Kilométrage", "Réservoir", "Etat", "Actions"};

        Object[][] donnees = new Object[containers.Flotte.get().size()][7];

        int count = 0;
        for (Exemplaire e : containers.Flotte.get()) {
            donnees[count][0] = e.getId();
            donnees[count][1] = e.getVehicule().getMarque();

            String modeleCylindree;

            if (e.getVehicule() instanceof Auto) {
                modeleCylindree = ((Auto) e.getVehicule()).getModele();
            }
            else {
                modeleCylindree = Integer.toString(((Moto) e.getVehicule()).getCylindree());
            }

            donnees[count][2] = modeleCylindree;
            donnees[count][3] = e.getKilometres();
            donnees[count][4] = e.getReservoir();
            donnees[count][5] = (e.isEndommage()) ? "Mauvais" : "OK";
            donnees[count][6] = "Bouton";

            count++;
        }

        fenetrePanel.add(titrePanel);

        fenetrePanel.add(ajoutPanel);

        Tableau tableau = new TableauRecherche(fenetrePanel, donnees, entetes);
        tableau.generer();

    }
}
