package location.views.components.form;


import location.models.Auto;
import location.models.Moto;
import location.models.Vehicule;
import location.views.components.misc.Fenetre;
import location.views.components.panel.*;

import javax.swing.*;
import java.awt.*;

/**
 * Formulaire d'ajout véhicule
 * @author Timothée Barbot
 */
public class VehiculeForm extends BoxPanel {

    private Vehicule vehicule;

    private TwoRadioPanel vehiculeTypePanel;

    private JTextField marqueTexte;

    private JTextField priceTexte;

    private JTextField insuranceTexte;

    private AutoPanel autoPanel;

    private MotoPanel motoPanel;

    private JButton cancelButton;

    private JButton validButton;

    /**
     * Constructeur par défaut
     */
    public VehiculeForm(){
        super();
        initContent();
    }

    /**
     * Constructeur complet avec véhicule (modification)
     * @param v véhicule à modifier
     */
    public VehiculeForm(Vehicule v){
        super();
        vehicule = v;
        initContent();
    }

    /**
     * init the panel with its components
     */
    private void initContent(){
        // label + field for the vehicle type (boolean or string -> not saved but used for the end of the form)
        vehiculeTypePanel = new TwoRadioPanel(Fenetre.defaultColor, "Type de vehicule", "Auto", "Moto");
        vehiculeTypePanel.getBtn1().addActionListener(e -> {
            motoPanel.setVisible(false);
            autoPanel.setVisible(true);
        });

        vehiculeTypePanel.getBtn2().addActionListener(e -> {
            motoPanel.setVisible(true);
            autoPanel.setVisible(false);
        });

        // label + field for the vehicule make (string)
        JPanel marqueModelPanel = new FlowPanel(Color.ORANGE);
        JLabel marqueLabel = new JLabel("Marque : ");
        marqueTexte = new JTextField("marque", 20);

        // label + field for the vehicule price/day (int)
        JPanel pricePanel = new FlowPanel(Color.ORANGE);
        JLabel priceLabel = new JLabel("Prix à la journée: ");
        priceTexte = new JTextField("0", 10);

        // label + field for the vehicule price for assurance (int)
        JLabel insuranceLabel = new JLabel("       Prix de l'assurance: ");
        insuranceTexte = new JTextField("0", 10);

        // Only if type is Auto
        autoPanel = new AutoPanel(Fenetre.defaultColor);

        // Only if type is Moto
        // label + field for the vehicule cylinder (int)
        motoPanel = new MotoPanel(Fenetre.defaultColor);

        if(vehicule != null) {
            if (vehicule.getClass().equals("Moto")) {
                motoPanel.setVisible(true);
                autoPanel.setVisible(false);
                motoPanel.getCylindreeTexte().setText(Integer.toString(((Moto) vehicule).getCylindree()));

            } else {
                autoPanel.setVisible(true);
                motoPanel.setVisible(false);
                autoPanel.getLuxeCheckbox().setSelected(((Auto) vehicule).isLuxe());
                autoPanel.getModeleTexte().setText(((Auto) vehicule).getModele());
            }

            marqueTexte.setText(vehicule.getMarque());
            priceTexte.setText(Integer.toString(vehicule.getPrixJour()));
            insuranceTexte.setText(Integer.toString(vehicule.getPrixAssurance()));
        }
        else {
            autoPanel.setVisible(true);
            motoPanel.setVisible(false);
        }

        JPanel boutonPanel =new FlowPanel(Color.ORANGE);
        // button to cancel any modification + close the window
        cancelButton = new JButton("Annuler");

        // button to validate the form + close the window
        validButton = new JButton("Valider");

        marqueModelPanel.add(marqueLabel);
        marqueModelPanel.add(marqueTexte);
        marqueModelPanel.add(autoPanel);
        marqueModelPanel.add(motoPanel);

        boutonPanel.add(cancelButton);
        boutonPanel.add(validButton);

        pricePanel.add(priceLabel);
        pricePanel.add(priceTexte);
        pricePanel.add(insuranceLabel);
        pricePanel.add(insuranceTexte);

        add(vehiculeTypePanel);
        add(marqueModelPanel);
        add(pricePanel);
        add(boutonPanel);

    }

    /**
     * Sauvegarde véhicule
     */
    public void buildAndSaveVehicule(){
        if(vehicule == null){
            if(vehiculeTypePanel.getBtn1().isSelected()){
                vehicule = new Auto();
                ((Auto) vehicule).setModele(autoPanel.getModeleTexte().getText());
                ((Auto) vehicule).setLuxe(autoPanel.getLuxeCheckbox().isSelected());
            }
            else {
                vehicule = new Moto();
                ((Moto) vehicule).setCylindree(Integer.parseInt(motoPanel.getCylindreeTexte().getText()));
            }
        }

        vehicule.setMarque(marqueTexte.getText());
        vehicule.setPrixJour(Integer.parseInt(priceTexte.getText()));
        vehicule.setPrixAssurance(Integer.parseInt(insuranceTexte.getText()));
        //System.out.println(vehicule.toString());
        vehicule.save();
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
