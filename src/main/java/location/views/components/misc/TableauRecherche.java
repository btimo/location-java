package location.views.components.misc;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

/**
 * Gestion d'un tableau
 * Ajout d'un formulaire de recherche
 * @author Adrien Poupa
 */
public class TableauRecherche extends Tableau {

    /**
     * Constructeur complet
     * @param donnees données du tableau
     * @param entetes intitulé des en-têtes
     * @param numData en-têtes numériques
     * @param action action accrochée au bouton du tableau
     */
    public TableauRecherche(Object[][] donnees, String[] entetes, Integer[] numData, AbstractAction action){
        super(donnees, entetes, numData, action);
    }

    /**
     * Création du formulaire de recherche avant génération du tableau par fonction mère
     */
    public void generer(){
        JLabel nomLabel = new CustomFontLabel("Recherche : ");
        nomLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField nomTexte = new JTextField("", 10);
        nomTexte.setMaximumSize( new Dimension( 200, 24 ) );
        nomTexte.setAlignmentX(Component.CENTER_ALIGNMENT);

        nomTexte.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = nomTexte.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
                tableau.repaint();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = nomTexte.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                //not needed: throw new UnsupportedOperationException("Not supported yet.");
            }
        });

        add(nomLabel);
        add(nomTexte);

        // Appel fonction parente pour créer le tableau
        super.generer();
    }
}
