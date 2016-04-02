package location.views.components.panel;


import javax.swing.*;
import java.awt.*;

/**
 * JPanel de Moto
 * @author Timothée Barbot
 */
public class MotoPanel extends FlowPanel {

    private JTextField cylindreeTexte;

    /**
     * Constructeur par défaut
     */
    public MotoPanel(){
        super();
        initMotoPanel();
    }

    /**
     * Constructeur coloré
     * @param bgColor couleur de fond
     */
    public MotoPanel(Color bgColor){
        super(bgColor);
        initMotoPanel();
    }

    /**
     * Initialisation
     */
    private void initMotoPanel(){
        JLabel cylindreeLabel = new JLabel("cylindree : ");
        cylindreeTexte = new JTextField("0", 10);

        add(cylindreeLabel);
        add(cylindreeTexte);
    }

    /**
     * Cylindrée
     * @return cylindrée
     */
    public JTextField getCylindreeTexte() {
        return cylindreeTexte;
    }

    /**
     * Modification cylindrée
     * @param cylindreeTexte cylindrée
     */
    public void setCylindreeTexte(JTextField cylindreeTexte) {
        this.cylindreeTexte = cylindreeTexte;
    }
}
