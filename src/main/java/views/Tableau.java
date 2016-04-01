package views;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Objects;


/**
 * Created by sgate on 24/03/2016.
 */
public class Tableau {
    protected TableRowSorter<TableModel> rowSorter;
    protected JTable tableau;
    protected JPanel fenetre;
    protected String[] entetes;

    public Tableau(JPanel fenetre, Object[][] donnees, String[] entetes){
        this.fenetre = fenetre;
        this.entetes = entetes;
        this.tableau = new JTable(donnees, entetes);
        this.rowSorter = new TableRowSorter< >(tableau.getModel());
    }

    public JPanel generer(){
        tableau.setRowSorter(rowSorter);

        Action delete = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable)e.getSource();
                // Récupère l'ID - 1
                int modelRow = Integer.valueOf( e.getActionCommand() );
            }
        };

        ButtonColumn buttonColumn = new ButtonColumn(tableau, delete, entetes.length-1);
        buttonColumn.setMnemonic(KeyEvent.VK_D);

        fenetre.add(tableau.getTableHeader(), BorderLayout.NORTH);
        fenetre.add(tableau, BorderLayout.CENTER);

        return fenetre;
    }
}
