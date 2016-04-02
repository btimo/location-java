package location.views.components.form;


import location.containers.Emprunteurs;
import location.containers.Vehicules;
import location.models.*;
import location.util.SelectedExemplaireWithAssurance;
import location.views.components.misc.CustomFontLabel;
import location.views.components.misc.Fenetre;
import location.views.components.panel.BoxPanel;
import location.views.components.panel.ChooseVehiculePanel;
import location.views.components.panel.CorrespondingVehiculesPanel;
import location.views.components.panel.FlowPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Formulaire d'ajout location
 * @author Timothée Barbot
 */
public class LocationForm extends BoxPanel {

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
        initContent();
    }

    /**
     * Constructeur avec location (modification)
     * @param l location à modifier
     */
    public LocationForm(Location l){
        super();
        location = l;
        initContent();
        initContentWithData();
    }

    /**
     * init the panel with its components
     */
    private void initContent(){
        // label + field to select the user
        JPanel emprunteurPanel = new FlowPanel(Color.ORANGE);

        JLabel emprunterLabel = new CustomFontLabel("Emprunteur : ","Arial",Font.BOLD,20);
        emprunteursComboBox = new JComboBox();
        for(Emprunteur e: Emprunteurs.get()){
            emprunteursComboBox.addItem(e.getDisplayName());
        }

        // labels + fields to select vehicules
        chooseVehiculePanel = new ChooseVehiculePanel(Fenetre.defaultColor, location);

        // recap table of selected vehicules

        // button to cancel any modification + close the window
        cancelButton = new JButton("Annuler");

        // button to validate the form + close the window
        validButton = new JButton("Valider");

        JPanel boutonPanel = new JPanel(new FlowLayout());
        boutonPanel.setBackground(Color.ORANGE);

        emprunteurPanel.add(emprunterLabel);

        emprunteurPanel.add(emprunteursComboBox);
        boutonPanel.add(cancelButton);
        boutonPanel.add(validButton);

        add(emprunteurPanel);
        add(chooseVehiculePanel);
        add(boutonPanel);
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
        if(location == null) location = new Location();

        location.setEmprunteur(Emprunteurs.get().get(emprunteursComboBox.getSelectedIndex()));
        location.setDebut(new Date(chooseVehiculePanel.getDateDepartPanel().getDate()));
        location.setFin(new Date(chooseVehiculePanel.getDateRetourPanel().getDate()));

        for(SelectedExemplaireWithAssurance sewa: chooseVehiculePanel.getCorrespondingVehiculesPanel().getSelectedExemplaireWithAssurances()){
            location.louer(sewa.getExemplaire(), sewa.isAssurance());
        }

        System.out.println(location);
        location.save();
    }
}
