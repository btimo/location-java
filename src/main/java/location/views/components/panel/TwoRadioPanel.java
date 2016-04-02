package location.views.components.panel;

import location.views.components.misc.Bouton;

import javax.swing.*;
import java.awt.*;

/**
 * Gestion d'un Oui/Non en boutons radio
 * @author Timothée Barbot
 * @author Stéphane Gâteau
 */
public class TwoRadioPanel extends FlowPanel {

    private JLabel groupLabel;

    private JRadioButton btn1;
    private JRadioButton btn2;
    private ButtonGroup btnGroup;

    /**
     * Constructeur minimal, texte par défaut Oui Non
     * @param bgColor couleur de fond
     * @param nom nom du panneau
     */
    public TwoRadioPanel(Color bgColor, String nom){
        super(bgColor);
        initTwoRadioPanel(bgColor, nom, "Oui", "Non");
    }

    /**
     * Constructeur complet
     * @param bgColor couleur de fond
     * @param nom nom du panneau
     * @param btn1Text texte du bouton 1
     * @param btn2Text texte du bouton 2
     */
    public TwoRadioPanel(Color bgColor, String nom, String btn1Text, String btn2Text ){
        super(bgColor);
        initTwoRadioPanel(bgColor, nom, btn1Text, btn2Text);
    }

    /**
     * Initialisation de la fenêtre
     * @param bgColor couleur de fond
     * @param nom nom
     * @param btn1Text texte du bouton 1
     * @param btn2Text texte du bouton 2
     */
    private void initTwoRadioPanel(Color bgColor, String nom, String btn1Text, String btn2Text){
        groupLabel = new JLabel(nom);

        btn1 = Bouton.radioBouton(btn1Text, true, bgColor);
        btn2 = Bouton.radioBouton(btn2Text, false, bgColor);

        btnGroup = new ButtonGroup();
        btnGroup.add(btn1);
        btnGroup.add(btn2);
        add(groupLabel);
        add(btn1);
        add(btn2);
    }

    /**
     * Groupe de boutons
     * @return groupe de boutons
     */
    public ButtonGroup getBtnGroup() {
        return btnGroup;
    }

    /**
     * Mise à jour du groupe de bouton
     * @param btnGroup groupe de boutons
     */
    public void setBtnGroup(ButtonGroup btnGroup) {
        this.btnGroup = btnGroup;
    }

    /**
     * Bouton 1
     * @return bouton 1
     */
    public JRadioButton getBtn1() {
        return btn1;
    }

    /**
     * Modification bouton 1
     * @param btn1 bouton 1
     */
    public void setBtn1(JRadioButton btn1) {
        this.btn1 = btn1;
    }

    /**
     * Bouton 2
     * @return bouton 2
     */
    public JRadioButton getBtn2() {
        return btn2;
    }

    /**
     * Modification bouton 2
     * @param btn2 bouton 2
     */
    public void setBtn2(JRadioButton btn2) {
        this.btn2 = btn2;
    }
}
