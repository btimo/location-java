package location.views.components.form;


import location.models.Location;

import javax.swing.*;

public class LocationForm extends JPanel {

    private Location location;

    public LocationForm(){
        super();
        location = new Location();
        initContent();
    }

    public LocationForm(Location l){
        super();
        location = l;
        initContent();
    }

    // init the panel with its components
    private void initContent(){
        // label + field to select the user

        // labels + fields to select vehicules

        // recap table of selected vehicules

        // button to cancel any modification + close the window

        // button to validate the form + close the window
    }
}
