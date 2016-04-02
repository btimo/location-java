package location.views.components.panel;

import location.views.components.misc.CustomFontLabel;

import javax.swing.*;
import java.awt.Color;

public class AdressePanel extends FlowPanel {

    private CustomFontLabel adresseLabel;

    private JTextField numeroTexte;
    private JTextField rueTexte;
    private JTextField codeTexte;
    private JTextField villeTexte;

    public AdressePanel(){
        super();
    }

    public AdressePanel(Color bgColor){
        super(bgColor);
    }

    private void initAdressePanel(){
        adresseLabel = new CustomFontLabel("Adresse :");
        numeroTexte = new JTextField("5",3);
        rueTexte = new JTextField("rue",13);
        codeTexte = new JTextField("CP",5);
        villeTexte = new JTextField("ville",5);

        add(adresseLabel);
        add(numeroTexte);
        add(rueTexte);
        add(codeTexte);
        add(villeTexte);
    }

    public JTextField getNumeroTexte() {
        return numeroTexte;
    }

    public void setNumeroTexte(JTextField numeroTexte) {
        this.numeroTexte = numeroTexte;
    }

    public JTextField getRueTexte() {
        return rueTexte;
    }

    public void setRueTexte(JTextField rueTexte) {
        this.rueTexte = rueTexte;
    }

    public JTextField getCodeTexte() {
        return codeTexte;
    }

    public void setCodeTexte(JTextField codeTexte) {
        this.codeTexte = codeTexte;
    }

    public JTextField getVilleTexte() {
        return villeTexte;
    }

    public void setVilleTexte(JTextField villeTexte) {
        this.villeTexte = villeTexte;
    }
}
