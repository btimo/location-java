package location.views.components.tab;

import location.views.components.misc.CustomFontLabel;

import javax.swing.*;
import java.awt.*;

/**
 * Fenêtre de l'onglet Emprunteurs
 * @author Timothée Barbot
 * @author Adrien Poupa
 */
public class AProposTab extends JPanel{

    private JLabel title;

    /**
     * Initialisation de la fenêtre
     */
    public AProposTab() {
        super();
        setBackground(Color.orange);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initContent();
    }

    /**
     * Contenu de la fenêtre
     */
    private void initContent() {
        // rajout du titre
        title = new CustomFontLabel("A propos","Calibri", Font.PLAIN, 25);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(title);

        JLabel aPropos = new JLabel("<html><br />Application développée dans le cadre du projet Efrei Java 2" +
                "<br /><br />Auteurs : Timothée Barbot, Adrien Poupa, Stéphane Gâteau</html>");
        aPropos.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(aPropos);
    }
}
