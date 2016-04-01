package views;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

/**
 * Created by Adrien on 01/04/2016.
 */
public class Locations {
    public Locations(JPanel fenetrePanel) {
        // rajout du titre
        JPanel titrePanel = Panel.nvPanelFlow(Color.ORANGE);
        JLabel reservationLabel = Label.nvLabel("Liste des locations","Calibri", Font.PLAIN, 25);
        titrePanel.add(reservationLabel);

        // Bouton rajout Ajouter une location
        JPanel ajoutPanel = Panel.nvPanelFlow(Color.ORANGE);
        JButton ajouter = new JButton("Ajouter une location");
        ajoutPanel.add(ajouter);

        Object[][] donnees = {
                {"Johnathan", "Sykes", Color.RED, true, "Tennis"},
                {"Johnathan", "Sykes", Color.RED, true, "Tennis"},
                {"Johnathan", "Sykes", Color.RED, true, "Tennis"},
                {"Johnathan", "Sykes", Color.RED, true, "Tennis"},
                {"Johnathan", "Sykes", Color.RED, true, "Tennis"},
                {"Adrien", "Sykes", Color.RED, true, "Tennis"},
                {"Johnathan", "Sykes", Color.RED, true, "Tennis"},
                {"Johnathan", "Aykes", Color.RED, true, "Tennis"},
        };

        String[] entetes = {"Prénom", "Nom", "Couleur favorite", "Homme", "Sport"};

        JTable tableau = new JTable(donnees, entetes);
        TableRowSorter <TableModel> rowSorter = new TableRowSorter< >(tableau.getModel());
        tableau.setRowSorter(rowSorter);

        JPanel searchPanel = Panel.nvPanelFlow(Color.orange);

        JLabel nomLabel = Label.nvLabel("Recherche : ");
        JTextField nomTexte = Texte.nvTextField("", 10);

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

        searchPanel.add(nomLabel);
        searchPanel.add(nomTexte);

        fenetrePanel.add(titrePanel);

        fenetrePanel.add(searchPanel);

        fenetrePanel.add(tableau.getTableHeader(), BorderLayout.NORTH);
        fenetrePanel.add(tableau, BorderLayout.CENTER);

        fenetrePanel.add(ajoutPanel);
    }
}
