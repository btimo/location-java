package views.components.tab;

import models.Auto;
import models.Moto;
import models.Vehicule;
import views.components.misc.TableauRecherche;
import views.components.misc.Label;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;


public class Vehicules extends JPanel {
    public Vehicules() {
        super();
        setBackground(Color.orange);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initContent();
    }

    public void initContent() {
        // rajout du titre
        JLabel reservationLabel = new Label("Liste des véhicules","Calibri", Font.PLAIN, 25);
        add(reservationLabel);

        // Bouton rajout Ajouter un exemplaire
        JButton ajouter = new JButton("Ajouter un véhicule");
        add(ajouter);

        // Données tableau
        String[] entetes = {"Numéro", "Marque", "Modèle/Cylindrée", "Prix journalier", "Prix assurance", "Actions"};

        Object[][] donnees = new Object[containers.Vehicules.get().size()][6];

        int count = 0;
        for (Vehicule v : containers.Vehicules.get()) {
            donnees[count][0] = v.getId();
            donnees[count][1] = v.getMarque();

            String modeleCylindree;

            if (v instanceof Auto) {
                modeleCylindree = ((Auto) v).getModele();
                if (((Auto) v).isLuxe()) {
                    modeleCylindree += " (luxe)";
                }
            }
            else {
                modeleCylindree = Integer.toString(((Moto) v).getCylindree());
            }

            donnees[count][2] = modeleCylindree;
            donnees[count][3] = v.getPrixJour();
            donnees[count][4] = v.getPrixAssurance();
            donnees[count][5] = "Bouton";

            count++;
        }

        add(new TableauRecherche(donnees, entetes));
    }
}
