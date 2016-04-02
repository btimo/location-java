package views.components.misc;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;


public class TableauRecherche extends Tableau {

    public TableauRecherche(Object[][] donnees, String[] entetes){
        super(donnees, entetes);
    }

    public void generer(){
        JLabel nomLabel = new Label("Recherche : ");
        JTextField nomTexte = new TextField("", 10);
        //nomTexte.setMaximumSize(new Dimension(100,10));

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
