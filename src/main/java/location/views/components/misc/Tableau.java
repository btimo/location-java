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

    public Tableau(Object[][] donnees, String[] entetes){
        super();
        this.entetes = entetes;
        this.tableau = new JTable(donnees, entetes);
        this.rowSorter = new TableRowSorter< >(tableau.getModel());
        setBackground(Color.orange);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        generer();
    }

    public void generer(){
        tableau.setRowSorter(rowSorter);

        // todo: etre capable de passer des abstractAction en parametre lors de la creation d'un tableau
        // - abstractAction pour le delete dans le choix des vehicule
        // - abstractAction pour l'affichage des détails dans les tableaux des 4 onglets
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

        add(tableau.getTableHeader(), BorderLayout.NORTH);
        add(tableau, BorderLayout.CENTER);
    }
}
