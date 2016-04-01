package views;


import models.Location;

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
        // label + field for the user lastname

        // label + field for the user firstname

        // labels + fields for the user adress

        // button to cancel any modification + close the window

        // button to validate the form + close the window
    }
}
