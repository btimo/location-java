package location.views.components.misc;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Arrays;

/**
 * Gestion d'un tableau
 * @author Adrien Poupa
 */
public class Tableau extends JPanel {
    protected TableRowSorter<TableModel> rowSorter;
    protected JTable tableau;
    protected String[] entetes;
    protected AbstractAction action;
    protected Integer[] numData;
    protected Object[][] donnees;
    private DefaultTableModel model;

    /**
     * Constructeur complet
     * @param donnees données du tableau
     * @param entetes intitulé des en-têtes
     * @param numData en-têtes numériques
     * @param action action accrochée au bouton du tableau
     */
    public Tableau(Object[][] donnees, String[] entetes, Integer[] numData, AbstractAction action){
        super();
        this.donnees = donnees;
        this.entetes = entetes;
        this.numData = numData;

        // Utilisation du tri adéquat (tri d'Integer si présence de la colonne dans numData)
        model = new DefaultTableModel(donnees, entetes) {
            @Override
            public Class getColumnClass(int entetes) {
                if (Arrays.asList(numData).contains(entetes)) {
                    return Integer.class;
                }
                return String.class;
            }
        };

        this.tableau = new JTable(model);
        this.rowSorter = new TableRowSorter< >(tableau.getModel());

        tableau.setRowSorter(rowSorter);
        tableau.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.action = action;
        setBackground(Color.orange);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        generer();
    }

    /**
     * Génération du tableau
     */
    public void generer(){
        // Ajout du bouton passé en dernière position
        ButtonColumn buttonColumn = new ButtonColumn(tableau, action, entetes.length-1);
        buttonColumn.setMnemonic(KeyEvent.VK_D);

        add(tableau.getTableHeader(), BorderLayout.NORTH);
        add(tableau, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(tableau, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane);
    }

    /**
     * Vérification de l'existance d'une ligne dans un tableau
     * http://stackoverflow.com/questions/15639611/how-to-check-if-a-value-exists-in-jtable-which-i-am-trying-to-add
     * @param table tableau où rechercher
     * @param entry entrée à rechercher
     * @return true/false
     */
    public static boolean existsInTable(JTable table, Object[] entry) {

        // Get row and column count
        int rowCount = table.getRowCount();
        int colCount = table.getColumnCount();

        // Get Current Table Entry
        String curEntry = "";
        for (Object o : entry) {
            String e = o.toString();
            curEntry = curEntry + " " + e;
        }

        // Check against all entries
        for (int i = 0; i < rowCount; i++) {
            String rowEntry = "";
            for (int j = 0; j < colCount; j++)
                rowEntry = rowEntry + " " + table.getValueAt(i, j).toString();
            if (rowEntry.equalsIgnoreCase(curEntry)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Mise à jour des données du tableau
     * @param donnees nouvelles données
     */
    public void setData(Object[][] donnees) {
        this.donnees = donnees;
    }

    /**
     * Recherche dans un tableau
     * @param search chaîne recherchée
     */
    public void search(String search) {
        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + search));
        tableau.repaint();
    }

    /**
     * Recherche dans un tableau et une colonne
     * @param search chaîne recherchée
     * @param col colonne où chercher
     */
    public void search(String search, int col) {
        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + search, col));
        tableau.repaint();
    }

    /**
     * Recherche dans un tableau et une colonne
     * @param compoundRowFilter ensemble de filtres
     */
    public void search(RowFilter<TableModel, Object> compoundRowFilter) {
        rowSorter.setRowFilter(compoundRowFilter);
        tableau.repaint();
    }

    /**
     * Ajout d'une ligne
     * @param row ligne
     */
    public void addRow(Object[] row) {
        model.addRow(row);
    }

    /**
     * Suppression d'une ligne
     * @param row ligne
     */
    public void deleteRow(int row) {
        model.removeRow(row);
    }

    public void clearTable(){
        while(tableau.getRowCount() > 0){
            deleteRow(tableau.getRowCount() - 1);
        }
    }

    /**
     * Getter de tableau
     * @return tableau
     */
    public JTable getTableau() {
        return tableau;
    }
}
