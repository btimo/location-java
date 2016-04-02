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

    /**
     * Constructeur complet
     * @param donnees données du tableau
     * @param entetes intitulé des en-têtes
     * @param numData en-têtes numériques
     * @param action action accrochée au bouton du tableau
     */
    public Tableau(Object[][] donnees, String[] entetes, Integer[] numData, AbstractAction action){
        super();
        this.entetes = entetes;
        this.numData = numData;

        // Utilisation du tri adéquat (tri d'Integer si présence de la colonne dans numData)
        DefaultTableModel model = new DefaultTableModel(donnees, entetes) {
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
}
