package location.views.components.form;


import location.Application;
import location.containers.Vehicules;
import location.models.Auto;
import location.models.Exemplaire;
import location.models.Moto;
import location.models.Vehicule;
import location.views.LocationView;
import location.views.components.misc.Fenetre;
import location.views.components.panel.TwoRadioPanel;

import javax.swing.*;

public class VehiculeForm extends JPanel {

    private Vehicule vehicule;

    private TwoRadioPanel vehiculeTypePanel;

    private JTextField marqueTexte;

    private JTextField priceTexte;

    private JTextField insuranceTexte;

    private JButton cancelButton;

    private JButton validButton;

    public VehiculeForm(){
        super();
        initContent();
    }

    public VehiculeForm(Vehicule v){
        super();
        vehicule = v;
        initContent();
    }

    // init the panel with its components
    private void initContent(){
        // label + field for the vehicle type (boolean or string -> not saved but used for the end of the form)
        vehiculeTypePanel = new TwoRadioPanel(Fenetre.defaultColor, "Type de vehicule", "Auto", "Moto");
        vehiculeTypePanel.getBtn1().addActionListener(e -> {
            // Auto
            System.out.println("Auto selected");
        });

        vehiculeTypePanel.getBtn2().addActionListener(e -> {
            // Moto
            System.out.println("Moto selected");
        });

        // label + field for the vehicule make (string)
        JLabel marqueLabel = new JLabel("Marque : ");
        marqueTexte = new JTextField("marque", 20);

        // label + field for the vehicule price/day (int)
        JLabel priceLabel = new JLabel("Prix à la journée: ");
        priceTexte = new JTextField("prix", 10);

        // label + field for the vehicule price for assurance (int)
        JLabel insuranceLabel = new JLabel("Prix de l'assurance: ");
        insuranceTexte = new JTextField("assurance", 10);

        // Only if type is Auto
        // label + field for the vehicule model (string)

        // Only if type is Auto
        // label + field for the vehicule luxe (boolean)

        // Only if type is Moto
        // label + field for the vehicule cylinder (int)

        // button to cancel any modification + close the window
        cancelButton = new JButton("Annuler");

        // button to validate the form + close the window
        validButton = new JButton("Valider");

        add(vehiculeTypePanel);
        add(marqueLabel);
        add(marqueTexte);
        add(priceLabel);
        add(priceTexte);
        add(insuranceLabel);
        add(insuranceTexte);
        add(cancelButton);
        add(validButton);
    }

    public void buildAndSaveVehicule(){
        if(vehicule == null){
            if(vehiculeTypePanel.getBtn1().isSelected()){
                vehicule = new Auto();
            }
            else {
                vehicule = new Moto();
            }
        }

        System.out.println(vehicule);

        /*
        vehicule.setMarque();
        vehicule.setKilometres(Integer.parseInt(kmTexte.getText().trim()));
        vehicule.save();
        */
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
