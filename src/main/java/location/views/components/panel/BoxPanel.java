package location.views.components.panel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sgate on 02/04/2016.
 */
public class BoxPanel extends JPanel {

    /**
     * Constructeur par défaut
     */
    public BoxPanel(){
        super();
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    }

    /**
     * Constructeur complet
     * @param bgColor couleur de fond
     */
    public BoxPanel(Color bgColor){
        super();
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBackground(bgColor);
    }
}