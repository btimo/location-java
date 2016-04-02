package location.views.components.misc;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


public class Tableau extends JPanel {
    protected TableRowSorter<TableModel> rowSorter;
    protected JTable tableau;
    protected String[] entetes;
    protected AbstractAction action;

    public Tableau(Object[][] donnees, String[] entetes, AbstractAction action){
        super();
        this.entetes = entetes;
        this.tableau = new JTable(donnees, entetes);
        this.rowSorter = new TableRowSorter< >(tableau.getModel());
        this.action = action;
        setBackground(Color.orange);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        generer();
    }

    public void generer(){
        tableau.setRowSorter(rowSorter);

        tableau.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Ajout du bouton passé en dernière position
        ButtonColumn buttonColumn = new ButtonColumn(tableau, action, entetes.length-1);
        buttonColumn.setMnemonic(KeyEvent.VK_D);

        add(tableau.getTableHeader(), BorderLayout.NORTH);
        add(tableau, BorderLayout.CENTER);
    }
}
