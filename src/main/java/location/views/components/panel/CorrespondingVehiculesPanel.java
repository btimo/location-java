package location.views.components.panel;


import location.Application;
import location.containers.Flotte;
import location.models.*;
import location.views.components.dialog.ExemplaireFormDialog;
import location.views.components.misc.Fenetre;
import location.views.components.misc.TableauRecherche;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CorrespondingVehiculesPanel extends BoxPanel {

    private TableauRecherche table;


    public CorrespondingVehiculesPanel(){
        super();
        initCorrespondigVehiculesPanel();
    }

    public CorrespondingVehiculesPanel(Color bgColor){
        super(bgColor);
        initCorrespondigVehiculesPanel();
    }

    private void initCorrespondigVehiculesPanel(){
        // Données tableau
        String[] entetes = {"Numéro", "Marque", "Modèle/Cylindrée", "Kilométrage", "Réservoir", "Etat", "Actions"};

        Object[][] donnees = new Object[location.containers.Flotte.get().size()][7];

        Integer[] numData = {0, 3};

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
            donnees[count][6] = "Détails";

            count++;
        }

        table = new TableauRecherche(donnees, entetes, numData, new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable)e.getSource();
                // Récupère l'ID - 1
                int modelRow = Integer.valueOf( e.getActionCommand() );

                Fenetre mainFenetre = Application.getApp().getView().getLocationFenetre();
                new ExemplaireFormDialog(mainFenetre, Flotte.get().get(modelRow));
            }
        });

        add(table);
    }

    public void setSearchParam(Vehicule vehiculeChoisi/*, Date debut, Date fin*/){
        table.repaint();
        // Données tableau
        String[] entetes = {"Numéro", "Marque", "Modèle/Cylindrée", "Kilométrage", "Réservoir", "Etat", "Actions"};

        Object[][] donnees = new Object[location.containers.Flotte.get().size()][7];

        Integer[] numData = {0, 3};

        int count = 0;
        for (Exemplaire e : location.containers.Flotte.get()) {
            donnees[count][0] = e.getId();
            donnees[count][1] = e.getVehicule().getMarque();

            String modeleCylindree;

            if (e.getVehicule().equals(vehiculeChoisi)) {
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
            donnees[count][6] = "Détails";

            count++;
        }

        table = new TableauRecherche(donnees, entetes, numData, new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable)e.getSource();
                // Récupère l'ID - 1
                int modelRow = Integer.valueOf( e.getActionCommand() );

                Fenetre mainFenetre = Application.getApp().getView().getLocationFenetre();
                new ExemplaireFormDialog(mainFenetre, Flotte.get().get(modelRow));
            }
        });

        }

        add(table);
    }
}
