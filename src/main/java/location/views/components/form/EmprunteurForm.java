package location.views.components.form;

import location.models.Adresse;
import location.models.Emprunteur;
import location.views.components.panel.FlowPanel;
import location.views.components.panel.IdentificationPanel;
import location.views.components.panel.AdressePanel;

import javax.swing.*;
import java.awt.*;

public class EmprunteurForm extends FlowPanel{

    private Emprunteur emprunteur;

    private IdentificationPanel identifiantPanel;

    private AdressePanel adressePanel;

    private JButton cancelButton;

    private JButton validButton;

    public EmprunteurForm(){
        super();
        initContent();
    }

    public EmprunteurForm(Emprunteur e){
        super();
        emprunteur = e;
        initContent();
    }

    // init the panel with its components
    private void initContent(){
        // Panel identification
        identifiantPanel = new IdentificationPanel(Color.ORANGE);

        // Panel adresse
        adressePanel = new AdressePanel(Color.ORANGE);

        if(emprunteur != null){
            identifiantPanel.getNomTexte().setText(emprunteur.getNom());
            identifiantPanel.getPrenomTexte().setText(emprunteur.getPrenom());

            adressePanel.getNumeroTexte().setText(Integer.toString(emprunteur.getAdresse().getNumero()));
            adressePanel.getRueTexte().setText(emprunteur.getAdresse().getRue());
            adressePanel.getCodeTexte().setText(emprunteur.getAdresse().getCp());
            adressePanel.getVilleTexte().setText(emprunteur.getAdresse().getVille());
        }

        // button to cancel any modification + close the window
        cancelButton = new JButton("Annuler");

        // button to validate the form + close the window
        validButton = new JButton("Valider");

        add(identifiantPanel);
        add(adressePanel);
        add(cancelButton);
        add(validButton);
    }

    // take data from identification and adressePanel to build an Emprunter entity
    public void buildAndSaveEmprunteur(){

        if(emprunteur == null) emprunteur = new Emprunteur();

        emprunteur.setNom(identifiantPanel.getNomTexte().getText());
        emprunteur.setPrenom(identifiantPanel.getPrenomTexte().getText());
        emprunteur.setAdresse(new Adresse(Integer.parseInt(adressePanel.getNumeroTexte().getText()),
                adressePanel.getRueTexte().getText(),
                adressePanel.getCodeTexte().getText(),
                adressePanel.getVilleTexte().getText())
        );
        emprunteur.save();
    }

    public Emprunteur getEmprunteur() {
        return emprunteur;
    }

    public void setEmprunteur(Emprunteur emprunteur) {
        this.emprunteur = emprunteur;
    }

    public IdentificationPanel getIdentifiantPanel() {
        return identifiantPanel;
    }

    public void setIdentifiantPanel(IdentificationPanel identifiantPanel) {
        this.identifiantPanel = identifiantPanel;
    }

    public AdressePanel getAdressePanel() {
        return adressePanel;
    }

    public void setAdressePanel(AdressePanel adressePanel) {
        this.adressePanel = adressePanel;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    public JButton getValidButton() {
        return validButton;
    }

    public void setValidButton(JButton validButton) {
        this.validButton = validButton;
    }
}
