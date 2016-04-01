package views.components.panel;


import views.components.misc.Label;
import views.components.misc.TextField;

import javax.swing.*;
import java.awt.Color;

public class IdentificationPanel extends FlowPanel{

    private JLabel nomLabel;
    private JTextField nomTexte;
    private JTextField prenomTexte;

    public IdentificationPanel(){
        super();
        initIdentificationPanel();
    }

    public IdentificationPanel(Color bgColor){
        super(bgColor);
        initIdentificationPanel();
    }

    private void initIdentificationPanel(){
        nomLabel = new Label("Nom et prénom : ");
        nomTexte = new TextField(" Nom", 10);
        prenomTexte = new TextField(" Prénom", 10);

        add(nomLabel);
        add(nomTexte);
        add(prenomTexte);
    }
}
