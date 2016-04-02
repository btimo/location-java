package location.views.components.panel;

import javax.swing.*;
import java.awt.*;

/**
 * Gestion d'un FlowPanel
 * @author Timothée Barbot
 * @author Stéphane Gâteau
 */
public class FlowPanel extends JPanel {

    /**
     * Constructeur par défaut
     */
    public FlowPanel(){
        super();
        setLayout(new FlowLayout());
    }

    /**
     * Constructeur complet
     * @param bgColor couleur de fond
     */
    public FlowPanel(Color bgColor){
        super();
        setLayout(new FlowLayout());
        setBackground(bgColor);
    }
}
