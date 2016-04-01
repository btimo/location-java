package views;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.Objects;


/**
 * Created by sgate on 24/03/2016.
 */
public class Tableau {
    protected TableRowSorter<TableModel> rowSorter;
    protected JTable tableau;
    protected JPanel fenetre;

    public Tableau(JPanel fenetre, Object[][] donnees, String[] entetes){
        this.fenetre = fenetre;
        this.tableau = new JTable(donnees, entetes);
        this.rowSorter = new TableRowSorter< >(tableau.getModel());
    }

    public JPanel generer(){
        tableau.setRowSorter(rowSorter);
        
        fenetre.add(tableau.getTableHeader(), BorderLayout.NORTH);
        fenetre.add(tableau, BorderLayout.CENTER);

        return fenetre;
    }
}
