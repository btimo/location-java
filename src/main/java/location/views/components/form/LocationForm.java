package location.views.components.form;


import location.models.Location;

import javax.swing.*;

/**
 * Formulaire d'ajout location
 * @author Timothée Barbot
 */
public class LocationForm extends JPanel {

    private Location location;

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
        initContent();
    }

    /**
     * init the panel with its components
     */
    private void initContent(){
        // label + field to select the user

        // labels + fields to select vehicules

        // recap table of selected vehicules

        // button to cancel any modification + close the window

        // button to validate the form + close the window
    }
}
