package location.views.components.form;

import location.models.Adresse;
import location.models.Emprunteur;
import location.views.components.panel.AdressePanel;
import location.views.components.panel.BoxPanel;
import location.views.components.panel.FlowPanel;
import location.views.components.panel.IdentificationPanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Formulaire d'ajout d'emprunteur
 * @author Timothée Barbot
 */
public class EmprunteurForm extends BoxPanel {

    private Emprunteur emprunteur;

    private IdentificationPanel identifiantPanel;

    private AdressePanel adressePanel;

    private JButton cancelButton;

    private JButton validButton;

    private JButton deletButton;

    /**
     * Constructeur par défaut
     */
    public EmprunteurForm(){
        super();
        initContent();
    }

    /**
     * Constructeur complet avec emprunteur (modification)
     * @param e emprunteur
     */
    public EmprunteurForm(Emprunteur e){
        super();
        emprunteur = e;
        initContent();
    }

    /**
     * Initialisation fenêtre
     */
    // init the panel with its components
    private void initContent(){
        // Panel identification
        identifiantPanel = new IdentificationPanel(Color.ORANGE);

        // Panel adresse
        adressePanel = new AdressePanel(Color.ORANGE);
        deletButton = new JButton("Supprimer");
        if(emprunteur != null){

            identifiantPanel.getNomTexte().setText(emprunteur.getNom());
            identifiantPanel.getPrenomTexte().setText(emprunteur.getPrenom());

            adressePanel.getNumeroTexte().setText(Integer.toString(emprunteur.getAdresse().getNumero()));
            adressePanel.getRueTexte().setText(emprunteur.getAdresse().getRue());
            adressePanel.getCodeTexte().setText(emprunteur.getAdresse().getCp());
            adressePanel.getVilleTexte().setText(emprunteur.getAdresse().getVille());
        }
        else{
            deletButton.setVisible(false);
        }

        JPanel boutonPanel = new JPanel(new FlowLayout());
        boutonPanel.setBackground(Color.ORANGE);
        // button to cancel any modification + close the window
        cancelButton = new JButton("Annuler");
        // button to validate the form + close the window
        validButton = new JButton("Valider");



        add(identifiantPanel);
        add(adressePanel);
        boutonPanel.add(cancelButton);
        boutonPanel.add(validButton);
        boutonPanel.add(deletButton);
        add(boutonPanel);
    }

    /**
     * Take data from identification and adressePanel to build an Emprunter entity
     */
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

    /**
     * Récupération emprunteur
     * @return emprunteur
     */
    public Emprunteur getEmprunteur() {
        return emprunteur;
    }

    /**
     * Modification emprunteur
     * @param emprunteur emprunteur
     */
    public void setEmprunteur(Emprunteur emprunteur) {
        this.emprunteur = emprunteur;
    }

    /**
     * Récupération panneau identification
     * @return panneau identification
     */
    public IdentificationPanel getIdentifiantPanel() {
        return identifiantPanel;
    }

    /**
     * Modification panneau identification
     * @param identifiantPanel panneau identification
     */
    public void setIdentifiantPanel(IdentificationPanel identifiantPanel) {
        this.identifiantPanel = identifiantPanel;
    }

    /**
     * Récupération panneau adresse
     * @return panneau adresse
     */
    public AdressePanel getAdressePanel() {
        return adressePanel;
    }

    /**
     * Modification panneau adresse
     * @param adressePanel panneau adresse
     */
    public void setAdressePanel(AdressePanel adressePanel) {
        this.adressePanel = adressePanel;
    }

    /**
     * Récupération bouton annulation
     * @return bouton annulation
     */
    public JButton getCancelButton() {
        return cancelButton;
    }

    /**
     * Modification bouton annulation
     * @param cancelButton bouton anulation
     */
    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    /**
     * Récupération bouton validation
     * @return bouton validation
     */
    public JButton getValidButton() {
        return validButton;
    }

    /**
     * Modification bouton validation
     * @param validButton bouton validation
     */
    public void setValidButton(JButton validButton) {
        this.validButton = validButton;
    }
}
