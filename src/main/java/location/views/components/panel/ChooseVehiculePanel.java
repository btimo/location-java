package location.views.components.panel;

import location.views.components.misc.CustomFontLabel;
import location.views.components.misc.Panel;

import javax.swing.*;
import java.awt.*;

/**
 * Panneau de choix d'un véhicule
 * @author Timothée Barbot
 * @author Stéphane Gâteau
 */
public class ChooseVehiculePanel extends FlowPanel {

    private TwoRadioPanel typeVehicule;

    private FlowPanel modelPanel;

    private JPanel dateDepartPanel;

    private JPanel dateRetourPanel;

    private JCheckBox assurancePanel;

    /**
     * Constructeur par défaut
     */
    public ChooseVehiculePanel(){
        super();
    }

    /**
     * Constructeur avec couleur
     * @param bgColor couleur
     */
    public ChooseVehiculePanel(Color bgColor){
        super(bgColor);
    }

    /**
     * Initialisation de la fenêtre
     */
    private void initChooseVehiculePanel(){
        // Panel choix type de vehicule
        typeVehicule = new TwoRadioPanel(Color.ORANGE, "Type de location", "Auto", "Moto");

        // Panel selection du vehicule
        modelPanel = new FlowPanel(Color.ORANGE);
        JLabel constructeurModel = new CustomFontLabel("Choix du véhicule","Arial", Font.BOLD,14);
        modelPanel.add(constructeurModel);
        modelPanel.add(Panel.listeAutoMoto(Color.ORANGE, true));

        // Panel date
        dateDepartPanel = new DatePanel(Color.ORANGE, "Date de départ");
        dateRetourPanel = new DatePanel(Color.ORANGE, "Date de retour");

        // assurance
        assurancePanel = new JCheckBox("Assurance");
        assurancePanel.setAlignmentX(CENTER_ALIGNMENT);
        assurancePanel.setBackground(Color.ORANGE);


        //JPanel selectedVehicules = Panel.checkBoxPanel(Panel.listeAutoMoto(Color.ORANGE, true), Vehicules.get());
        //JPanel listePanel = Panel.listePanel(Color.ORANGE);

        // Panel assurance
    }
}
