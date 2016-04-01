package views.components.panels;

import views.components.misc.Label;
import views.components.misc.TextField;

import javax.swing.*;
import java.awt.Color;

public class AdressePanel extends FlowPanel {

    private Label adresseLabel;

    private TextField numeroTexte;
    private TextField rueTexte;
    private TextField codeTexte;
    private TextField villeTexte;

    public AdressePanel(){
        super();
    }

    public AdressePanel(Color bgColor){
        super(bgColor);
    }

    private void initAdressePanel(){
        adresseLabel = new Label("Adresse :");
        numeroTexte = new TextField("5",3);
        rueTexte = new TextField("rue",13);
        codeTexte = new TextField("CP",5);
        villeTexte = new TextField("ville",5);

        add(adresseLabel);
        add(numeroTexte);
        add(rueTexte);
        add(codeTexte);
        add(villeTexte);
    }
}
