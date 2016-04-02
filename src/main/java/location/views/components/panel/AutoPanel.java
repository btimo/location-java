package location.views.components.panel;

import location.models.Auto;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Timote on 02/04/2016.
 */
public class AutoPanel extends FlowPanel {

    private JTextField modeleTexte;

    private JCheckBox luxeCheckbox;

    public AutoPanel(){
        super();
        initAutoPanel();
    }

    public AutoPanel(Color bgColor){
        super(bgColor);
        initAutoPanel();
    }

    private void initAutoPanel(){
        JLabel modeleLabel = new JLabel("Modele : ");
        modeleTexte = new JTextField("modele", 10);

        JLabel luxeLabel = new JLabel("luxe : ");
        luxeCheckbox = new JCheckBox();

        add(modeleLabel);
        add(modeleTexte);
        add(luxeLabel);
        add(luxeCheckbox);
    }

    public JTextField getModeleTexte() {
        return modeleTexte;
    }

    public void setModeleTexte(JTextField modeleTexte) {
        this.modeleTexte = modeleTexte;
    }

    public JCheckBox getLuxeCheckbox() {
        return luxeCheckbox;
    }

    public void setLuxeCheckbox(JCheckBox luxeCheckbox) {
        this.luxeCheckbox = luxeCheckbox;
    }
}
