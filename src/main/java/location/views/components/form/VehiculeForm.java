package location.views.components.form;


import location.models.Vehicule;

import javax.swing.*;

public class VehiculeForm extends JPanel {

    private Vehicule vehicule;

    public VehiculeForm(){
        super();
        initContent();
    }

    public VehiculeForm(Vehicule v){
        super();
        vehicule = v;
        initContent();
    }

    // init the panel with its components
    private void initContent(){
        // label + field for the vehicle type (boolean or string -> not saved but used for the end of the form)

        // label + field for the vehicule make (string)

        // label + field for the vehicule price/day (int)

        // label + field for the vehicule price for assurance (int)

        // Only if type is Auto
        // label + field for the vehicule model (string)

        // Only if type is Auto
        // label + field for the vehicule luxe (boolean)

        // Only if type is Moto
        // label + field for the vehicule cylinder (int)

        // button to cancel any modification + close the window

        // button to validate the form + close the window
    }
}
