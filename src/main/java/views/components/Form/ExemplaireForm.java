package views.components.form;


import models.Exemplaire;

import javax.swing.*;

public class ExemplaireForm extends JPanel {

    private Exemplaire exemplaire;

    public ExemplaireForm(){
        super();
        exemplaire = new Exemplaire();
        initContent();
    }

    public ExemplaireForm(Exemplaire e){
        super();
        exemplaire = e;
        initContent();
    }

    // init the panel with its components
    private void initContent(){
        // label + field for the exemplaire vehicule

        // label + field for the exemplaire kmCounter

        // label + field for the exemplaire tank level

        // label + field for the exemplaire state (dommaged?)

        // button to cancel any modification + close the window

        // button to validate the form + close the window
    }
}
