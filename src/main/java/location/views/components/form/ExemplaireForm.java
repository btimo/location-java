package location.views.components.form;


import location.containers.Vehicules;
import location.models.Exemplaire;
import location.models.Vehicule;

import javax.swing.*;

/**
 * Formulaire d'ajout exemplaire
 * @author Timothée Barbot
 */
public class ExemplaireForm extends JPanel {

    private Exemplaire exemplaire;

    private JLabel vehiculeLabel;
    private JComboBox vehiculesComboBox;

    private JLabel kmLabel;
    private JTextField kmTexte;

    private JButton cancelButton;

    private JButton validButton;

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
        vehiculeLabel = new JLabel("Vehicule : ");
        vehiculesComboBox = new JComboBox();
        for(Vehicule v: Vehicules.get()){
            vehiculesComboBox.addItem(v.getDisplayName());
            if(exemplaire != null && exemplaire.getVehicule().getDisplayName().equals(v.getDisplayName())) vehiculesComboBox.setSelectedItem(v.getDisplayName());
        }
        // label + field for the exemplaire kmCounter
        kmLabel = new JLabel("Kilométrage : ");
        kmTexte = new JTextField("0", 10);

        // button to cancel any modification + close the window
        cancelButton = new JButton("Annuler");

        // button to validate the form + close the window
        validButton = new JButton("Valider");

        if(exemplaire != null){
            vehiculesComboBox.setEnabled(false);
            kmTexte.setText(Integer.toString(exemplaire.getKilometres()));
        }

        add(vehiculeLabel);
        add(vehiculesComboBox);
        add(kmLabel);
        add(kmTexte);
        add(cancelButton);
        add(validButton);
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
}
