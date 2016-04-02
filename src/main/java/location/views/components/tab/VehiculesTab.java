package location.views.components.tab;

import location.Application;
import location.models.Auto;
import location.models.Moto;
import location.models.Vehicule;
import location.views.components.dialog.ExemplaireFormDialog;
import location.views.components.dialog.VehiculeFormDialog;
import location.views.components.misc.Fenetre;
import location.views.components.misc.TableauRecherche;
import location.views.components.misc.CustomFontLabel;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VehiculesTab extends JPanel {

    private JButton addVehiculeButton;

    public VehiculesTab() {
        super();
        setBackground(Color.orange);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initContent();
    }

    public void initContent() {
        // rajout du titre
        JLabel reservationLabel = new CustomFontLabel("Liste des véhicules","Calibri", Font.PLAIN, 25);
        add(reservationLabel);

        // Bouton rajout Ajouter un exemplaire
        addVehiculeButton = new JButton("Ajouter un véhicule");
        addVehiculeButton.addActionListener(new ButtonListener());
        add(addVehiculeButton);

        // Données tableau
        String[] entetes = {"Numéro", "Marque", "Modèle/Cylindrée", "Prix journalier", "Prix assurance", "Actions"};

        Object[][] donnees = new Object[location.containers.Vehicules.get().size()][6];

        int count = 0;
        for (Vehicule v : location.containers.Vehicules.get()) {
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

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event){
            JButton me = (JButton) event.getSource();

            if(me.equals(addVehiculeButton)){
                Fenetre mainFenetre = Application.getApp().getView().getLocationFenetre();
                new VehiculeFormDialog(mainFenetre);
            }
        }
    }
}
