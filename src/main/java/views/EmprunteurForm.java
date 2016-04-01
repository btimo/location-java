package views;


import models.Emprunteur;

import javax.swing.*;

public class EmprunteurForm extends JPanel {

    private Emprunteur emprunteur;

    public EmprunteurForm(){
        super();
        emprunteur = new Emprunteur();
        initContent();
    }

    public EmprunteurForm(Emprunteur e){
        super();
        emprunteur = e;
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
