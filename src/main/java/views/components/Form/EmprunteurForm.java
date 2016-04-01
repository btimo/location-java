package views.components.form;

import models.Emprunteur;
import views.components.dialog.EmprunteurFormDialog;
import views.components.panel.IdentificationPanel;
import views.components.panel.AdressePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class EmprunteurForm extends JPanel {

    private Emprunteur emprunteur;

    private IdentificationPanel identifiantPanel;

    private AdressePanel adressePanel;

    private JButton cancelButton;

    private JButton validButton;

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
        // Panel identification
        identifiantPanel = new IdentificationPanel(Color.ORANGE);

        // Panel adresse
        adressePanel = new AdressePanel(Color.ORANGE);

        // button to cancel any modification + close the window
        cancelButton = new JButton("Annuler");
        cancelButton.addActionListener(e -> {
            EmprunteurForm me = (EmprunteurForm) e.getSource();
            EmprunteurFormDialog meParent = (EmprunteurFormDialog) me.getParent();
            meParent.setVisible(false);
            meParent.dispatchEvent(new WindowEvent(
                    meParent, WindowEvent.WINDOW_CLOSING));
        });

        // button to validate the form + close the window
        validButton = new JButton("Valider");
        validButton.addActionListener(e -> {
            EmprunteurForm me = (EmprunteurForm) e.getSource();
            EmprunteurFormDialog meParent = (EmprunteurFormDialog) me.getParent();
            me.buildAndSaveEmprunteur();
            meParent.setVisible(false);
            meParent.dispatchEvent(new WindowEvent(
                    meParent, WindowEvent.WINDOW_CLOSING));

        });

    }

    // take data from identification and adressePanel to build an Emprunter entity
    public void buildAndSaveEmprunteur(){
        // todo
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
