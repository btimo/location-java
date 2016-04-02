package location.views.components.form;


import location.containers.Vehicules;
import location.models.Exemplaire;
import location.models.Vehicule;
import location.views.components.panel.BoxPanel;
import location.views.components.panel.FlowPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Formulaire d'ajout exemplaire
 * @author Timothée Barbot
 */
public class ExemplaireForm extends BoxPanel {

    private Exemplaire exemplaire;

    private JLabel vehiculeLabel;
    private JComboBox vehiculesComboBox;

    private JLabel kmLabel;
    private JTextField kmTexte;

    private JButton cancelButton;

    private JButton validButton;

    private JButton deletBoutton;

    /**
     * Constructeur par défaut
     */
    public ExemplaireForm(){
        super();
        exemplaire = new Exemplaire();
        initContent();
    }

    /**
     * Constructeur complet avec exemplaire (modification)
     * @param e exemplaire
     */
    public ExemplaireForm(Exemplaire e){
        super();
        exemplaire = e;
        initContent();
    }

    /**
     * init the panel with its components
     */
    private void initContent(){
        // label + field for the exemplaire vehicule
        JPanel vehiculePanel = new FlowPanel(Color.ORANGE);
        vehiculeLabel = new JLabel("Vehicule : ");
        vehiculesComboBox = new JComboBox();
        for(Vehicule v: Vehicules.get()){
            vehiculesComboBox.addItem(v.getDisplayName());
            if(exemplaire != null && exemplaire.getVehicule() != null && exemplaire.getVehicule().getDisplayName().equals(v.getDisplayName())) vehiculesComboBox.setSelectedItem(v.getDisplayName());
        }
        JPanel kmPanel = new FlowPanel(Color.ORANGE);
        // label + field for the exemplaire kmCounter
        kmLabel = new JLabel("Kilométrage : ");
        kmTexte = new JTextField("0", 10);

        JPanel boutonPanel = new FlowPanel(Color.ORANGE);
        // button to cancel any modification + close the window
        cancelButton = new JButton("Annuler");

        // button to validate the form + close the window
        validButton = new JButton("Valider");

        deletBoutton = new JButton("Supprimer");
        if(exemplaire != null && exemplaire.getVehicule() != null ){
            vehiculesComboBox.setEnabled(false);
            kmTexte.setText(Integer.toString(exemplaire.getKilometres()));
        }

        boutonPanel.add(cancelButton);
        boutonPanel.add(validButton);
        boutonPanel.add(deletBoutton);

        vehiculePanel.add(vehiculeLabel);
        vehiculePanel.add(vehiculesComboBox);

        kmPanel.add(kmLabel);
        kmPanel.add(kmTexte);

        add(vehiculePanel);
        add(kmPanel);
        add(boutonPanel);
    }

    /**
     * Sauvegarde exemplaire
     */
    public void buildAndSaveExemplaire(){
        if(exemplaire == null) exemplaire = new Exemplaire();

        exemplaire.setVehicule(Vehicules.get().get(vehiculesComboBox.getSelectedIndex()));
        exemplaire.setKilometres(Integer.parseInt(kmTexte.getText().trim()));
        exemplaire.save();
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

    public JButton getDeletBoutton() {
        return deletBoutton;
    }

    public void setDeletBoutton(JButton deletBoutton) {
        this.deletBoutton = deletBoutton;
    }
}
