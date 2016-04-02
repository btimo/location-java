package location.views.components.panel;

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
        nomLabel = new JLabel("Nom et prénom : ");
        nomTexte = new JTextField(" Nom", 10);
        prenomTexte = new JTextField(" Prénom", 10);

        add(nomLabel);
        add(nomTexte);
        add(prenomTexte);
    }
}
