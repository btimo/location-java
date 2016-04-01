package views;

import models.Emprunteur;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * Created by Adrien on 02/04/2016.
 */
public class Emprunteurs {
    public Emprunteurs(JPanel fenetrePanel) {
        // rajout du titre
        JPanel titrePanel = Panel.nvPanelFlow(Color.ORANGE);
        JLabel reservationLabel = Label.nvLabel("Liste des emprunteurs","Calibri", Font.PLAIN, 25);
        titrePanel.add(reservationLabel);

        // Bouton rajout Ajouter un emprunteur
        JPanel ajoutPanel = Panel.nvPanelFlow(Color.ORANGE);
        JButton ajouter = new JButton("Ajouter un emprunteur");
        ajoutPanel.add(ajouter);

        // Données tableau
        String[] entetes = {"Numéro", "Nom", "Prénom", "Adresse", "Actions"};

        Object[][] donnees = new Object[containers.Emprunteurs.get().size()][5];

        int count = 0;
        for (Emprunteur e : containers.Emprunteurs.get()) {
            donnees[count][0] = e.getId();
            donnees[count][1] = e.getNom();
            donnees[count][2] = e.getPrenom();
            donnees[count][3] = e.getAdresse().toString();
            donnees[count][4] = "Bouton";

            count++;
        }

        fenetrePanel.add(titrePanel);

        fenetrePanel.add(ajoutPanel);

        Tableau tableau = new TableauRecherche(fenetrePanel, donnees, entetes);
        tableau.generer();

    }
}
