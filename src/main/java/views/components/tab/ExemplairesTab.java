package views.components.tab;

import models.Auto;
import models.Exemplaire;
import models.Moto;
import views.components.misc.TableauRecherche;
import views.components.misc.CustomFontLabel;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class ExemplairesTab extends JPanel {
    public ExemplairesTab() {
        super();
        setBackground(Color.orange);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initContent();
    }

    private void initContent() {
        // rajout du titre
        JLabel reservationLabel = new CustomFontLabel("Liste des exemplaires","Calibri", Font.PLAIN, 25);
        add(reservationLabel);

        // Bouton rajout Ajouter un exemplaire
        JButton ajouter = new JButton("Ajouter un exemplaire");
        add(ajouter);

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

        add(new TableauRecherche(donnees, entetes));
    }
}
