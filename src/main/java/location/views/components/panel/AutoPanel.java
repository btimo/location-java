package location.views.components.panel;

import javax.swing.*;
import java.awt.*;

/**
 * Gestion d'un JPanel Auto
 * @author Timothée Barbot
 */
public class AutoPanel extends FlowPanel {

    private JTextField modeleTexte;

    private JCheckBox luxeCheckbox;

    /**
     * Constructeur par défaut
     */
    public AutoPanel(){
        super();
        initAutoPanel();
    }

    /**
     * Constructeur coloré
     * @param bgColor couleur
     */
    public AutoPanel(Color bgColor){
        super(bgColor);
        initAutoPanel();
    }

    /**
     * Initialisation
     */
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

    /**
     * Champ de texte
     * @return champ de texte
     */
    public JTextField getModeleTexte() {
        return modeleTexte;
    }

    /**
     * Modification champ de texte
     * @param modeleTexte champ de texte
     */
    public void setModeleTexte(JTextField modeleTexte) {
        this.modeleTexte = modeleTexte;
    }

    /**
     * Checkbox luxe
     * @return checkbox luxe
     */
    public JCheckBox getLuxeCheckbox() {
        return luxeCheckbox;
    }

    /**
     * Modification checkbox luxe
     * @param luxeCheckbox checkbox luxe
     */
    public void setLuxeCheckbox(JCheckBox luxeCheckbox) {
        this.luxeCheckbox = luxeCheckbox;
    }
}
