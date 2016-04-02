package location.views.components.panel;


import location.Application;
import location.containers.Flotte;
import location.models.*;
import location.util.SelectedExemplaireWithAssurance;
import location.views.components.dialog.ExemplaireFormDialog;
import location.views.components.misc.Fenetre;
import location.views.components.misc.Tableau;
import location.views.components.misc.TableauRecherche;
import location.views.components.tab.ExemplairesTab;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ContainerAdapter;
import java.util.ArrayList;
import java.util.List;

public class CorrespondingVehiculesPanel extends BoxPanel {

    private Tableau table;
    private Tableau table2;
    private String modeleCylindree;
    private Location locationChoisie;
    private boolean assurance;

    private ArrayList<Exemplaire> searchResults = new ArrayList<>();

    private ArrayList<SelectedExemplaireWithAssurance> selectedExemplaireWithAssurances = new ArrayList<>();


    public CorrespondingVehiculesPanel(){
        super();
        initCorrespondigVehiculesPanel();
    }

    public CorrespondingVehiculesPanel(Location l, boolean a){
        super();
        this.locationChoisie = l;
        assurance = a;
        initCorrespondigVehiculesPanel();
    }

    public CorrespondingVehiculesPanel(Color bgColor){
        super(bgColor);
        initCorrespondigVehiculesPanel();
    }

    private void initCorrespondigVehiculesPanel(){
        addChoiceTable();
        addChosenTable();
    }

    private void addChoiceTable() {
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
            donnees[count][6] = "Ajouter";

            count++;
        }

        JPanel firstTable = new JPanel();
        firstTable.setBackground(Color.ORANGE);
        firstTable.setLayout(new BoxLayout(firstTable, BoxLayout.Y_AXIS));
        JLabel info = new JLabel("Véhicules disponibles");
        info.setAlignmentX(CENTER_ALIGNMENT);
        firstTable.add(info);

        table = new Tableau(donnees, entetes, numData, new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable)e.getSource();
                // Récupère l'ID - 1
                int modelRow = Integer.valueOf( e.getActionCommand() );

                Exemplaire ex = searchResults.get(modelRow);
                selectedExemplaireWithAssurances.add(new SelectedExemplaireWithAssurance(ex, assurance));

                Object[] object = new Object[]{ex.getId(), ex.getVehicule().getMarque(),
                    getModeleCylindree(ex.getVehicule()), ex.getKilometres(), ex.getReservoir(),
                        ((ex.isEndommage()) ? "Mauvais" : "OK"), "Supprimer"};

                if (!Tableau.existsInTable(table2.getTableau(), object)) {
                    table2.addRow(object);
                }
            }
        });

        table.setPreferredSize(new Dimension(200,150));

        firstTable.add(table);
        add(firstTable);
    }

    private void addChosenTable() {
        JPanel chosenTable = new JPanel();
        chosenTable.setBackground(Color.ORANGE);
        chosenTable.setLayout(new BoxLayout(chosenTable, BoxLayout.Y_AXIS));
        JLabel info = new JLabel("Véhicules loués");
        info.setBackground(Color.ORANGE);
        info.setAlignmentX(CENTER_ALIGNMENT);
        chosenTable.add(info);

        // Données tableau
        String[] entetes = {"Numéro", "Marque", "Modèle/Cylindrée", "Kilométrage", "Réservoir", "Etat", "Actions"};

        Object[][] donnees = new Object[0][7];

        Integer[] numData = {0, 3};

        table2 = new Tableau(donnees, entetes, numData, new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable)e.getSource();
                // Récupère l'ID - 1
                int modelRow = Integer.valueOf( e.getActionCommand() );

                table2.deleteRow(modelRow);
                selectedExemplaireWithAssurances.remove(modelRow);
            }
        });

        // Ajout des anciennes locations
        if (locationChoisie != null) {
            for (LocationExemplaire le : locationChoisie.getLocationExemplaires()) {
                Exemplaire ex = le.getExemplaire();
                Object[] object = new Object[]{ex.getId(), ex.getVehicule().getMarque(),
                        getModeleCylindree(ex.getVehicule()), ex.getKilometres(), ex.getReservoir(),
                        ((ex.isEndommage()) ? "Mauvais" : "OK"), "Supprimer"};

                table2.addRow(object);
            }
        }

        table2.setPreferredSize(new Dimension(200,150));

        chosenTable.add(table2);

        add(chosenTable);
    }

    public void setSearchParam(Vehicule vehiculeChoisi, Date debut, Date fin){

        //System.out.println("Recherche de: " + vehiculeChoisi.getDisplayName() + ", d: " + debut + ", f: " + fin);

        /*RowFilter<TableModel, Object> firstFiler;
        RowFilter<TableModel, Object> secondFilter;
        List<RowFilter<TableModel,Object>> filters = new ArrayList<>();
        RowFilter<TableModel, Object> compoundRowFilter;

        firstFiler = RowFilter.regexFilter("(?i)" + vehiculeChoisi.getMarque(), 1);
        secondFilter = RowFilter.regexFilter("(?i)" + getModeleCylindree(vehiculeChoisi), 2);
        filters.add(firstFiler);
        filters.add(secondFilter);
        compoundRowFilter = RowFilter.andFilter(filters);

        table.search(compoundRowFilter);
        */

        table.clearTable();
        searchResults.clear();

        for(Exemplaire ex: Flotte.get()){
            if(ex.getVehicule().getDisplayName().equals(vehiculeChoisi.getDisplayName())){
                if(ex.isAvailable(debut, fin)) {
                    searchResults.add(ex);
                    table.addRow(new Object[]{ex.getId(), ex.getVehicule().getMarque(),
                            getModeleCylindree(ex.getVehicule()), ex.getKilometres(), ex.getReservoir(),
                            ((ex.isEndommage()) ? "Mauvais" : "OK"), "Ajouter"});
                }
            }
        }
    }

    /**
     * Retourne le modèle ou la cylindrée suivant si auto/moto
     * @param vehiculeChoisi véhicule pour lequel rechercher le nom
     * @return modèle/Cylindrée
     */
    public String getModeleCylindree(Vehicule vehiculeChoisi) {
        if (vehiculeChoisi instanceof Auto) {
            modeleCylindree = ((Auto) vehiculeChoisi).getModele();
        }
        else {
            modeleCylindree = Integer.toString(((Moto) vehiculeChoisi).getCylindree());
        }

        return modeleCylindree;
    }

    public ArrayList<SelectedExemplaireWithAssurance> getSelectedExemplaireWithAssurances() {
        return selectedExemplaireWithAssurances;
    }
}
