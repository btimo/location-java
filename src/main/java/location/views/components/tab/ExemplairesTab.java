package location.views.components.tab;

import location.Application;
import location.models.Auto;
import location.models.Exemplaire;
import location.models.Moto;
import location.views.components.dialog.EmprunteurFormDialog;
import location.views.components.dialog.ExemplaireFormDialog;
import location.views.components.misc.Fenetre;
import location.views.components.misc.TableauRecherche;
import location.views.components.misc.CustomFontLabel;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExemplairesTab extends JPanel {

    private JButton addExemplaireButton;

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
        addExemplaireButton = new JButton("Ajouter un exemplaire");
        addExemplaireButton.addActionListener(new ButtonListener());
        add(addExemplaireButton);

        // Données tableau
        String[] entetes = {"Numéro", "Marque", "Modèle/Cylindrée", "Kilométrage", "Réservoir", "Etat", "Actions"};

        Object[][] donnees = new Object[location.containers.Flotte.get().size()][7];

        int count = 0;
        for (Exemplaire e : location.containers.Flotte.get()) {
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

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event){
            JButton me = (JButton) event.getSource();

            if(me.equals(addExemplaireButton)){
                Fenetre mainFenetre = Application.getApp().getView().getLocationFenetre();
                new ExemplaireFormDialog(mainFenetre);
            }
        }
    }
}
