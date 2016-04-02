package location.views.components.form;


import location.containers.Emprunteurs;
import location.containers.Vehicules;
import location.models.Emprunteur;
import location.models.Exemplaire;
import location.models.Location;
import location.models.Vehicule;
import location.views.components.misc.Fenetre;
import location.views.components.panel.ChooseVehiculePanel;
import location.views.components.panel.CorrespondingVehiculesPanel;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Formulaire d'ajout location
 * @author Timothée Barbot
 */
public class LocationForm extends JPanel {

    private Location location;

    private ArrayList<Exemplaire> selectedExemplaires;

    private JComboBox emprunteursComboBox;

    private ChooseVehiculePanel chooseVehiculePanel;

    private JButton cancelButton;

    private JButton validButton;

    /**
     * Constructeur par défaut
     */
    public LocationForm(){
        super();
        location = new Location();
        initContent();
    }

    /**
     * Constructeur avec location (modification)
     * @param l location à modifier
     */
    public LocationForm(Location l){
        super();
        location = l;
        initContentWithData();
    }

    /**
     * init the panel with its components
     */
    private void initContent(){
        // label + field to select the user
        JLabel emprunterLabel = new JLabel("Emprunteur : ");
        emprunteursComboBox = new JComboBox();
        for(Emprunteur e: Emprunteurs.get()){
            emprunteursComboBox.addItem(e.getDisplayName());
        }

        // labels + fields to select vehicules
        chooseVehiculePanel = new ChooseVehiculePanel(Fenetre.defaultColor);

        // recap table of selected vehicules

        // button to cancel any modification + close the window
        cancelButton = new JButton("Annuler");

        // button to validate the form + close the window
        validButton = new JButton("Valider");

        add(emprunterLabel);
        add(emprunteursComboBox);
        add(chooseVehiculePanel);
        add(cancelButton);
        add(validButton);
        setVisible(true);
    }

    private void initContentWithData(){
        // TODO (devis, validation devis, rendu vehicules, facture)
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public JButton getValidButton() {
        return validButton;
    }

    public void buildAndSaveLocation(){
        // todo
    }
}
