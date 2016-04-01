package views.components.panel;

import views.components.misc.Label;
import views.components.misc.TextField;

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

    public TextField getNumeroTexte() {
        return numeroTexte;
    }

    public void setNumeroTexte(TextField numeroTexte) {
        this.numeroTexte = numeroTexte;
    }

    public TextField getRueTexte() {
        return rueTexte;
    }

    public void setRueTexte(TextField rueTexte) {
        this.rueTexte = rueTexte;
    }

    public TextField getCodeTexte() {
        return codeTexte;
    }

    public void setCodeTexte(TextField codeTexte) {
        this.codeTexte = codeTexte;
    }

    public TextField getVilleTexte() {
        return villeTexte;
    }

    public void setVilleTexte(TextField villeTexte) {
        this.villeTexte = villeTexte;
    }
}
