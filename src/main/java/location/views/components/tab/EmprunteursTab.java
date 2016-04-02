package location.views.components.tab;

import location.Application;
import location.containers.Emprunteurs;
import location.containers.Flotte;
import location.models.Emprunteur;
import location.views.components.dialog.EmprunteurFormDialog;
import location.views.components.dialog.ExemplaireFormDialog;
import location.views.components.misc.CustomFontLabel;
import location.views.components.misc.Fenetre;
import location.views.components.misc.TableauRecherche;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Fenêtre de l'onglet Emprunteurs
 * @author Timothée Barbot
 * @author Adrien Poupa
 */
public class EmprunteursTab extends JPanel{

    private JLabel title;

    private JButton addEmprunteurButton;

    private TableauRecherche table;

    /**
     * Initialisation de la fenêtre
     */
    public EmprunteursTab() {
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
        title = new CustomFontLabel("Liste des emprunteurs","Calibri", Font.PLAIN, 25);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(title);

        // Bouton rajout Ajouter un emprunteur
        addEmprunteurButton = new JButton("Ajouter un emprunteur");
        addEmprunteurButton.addActionListener(new ButtonListener());
        addEmprunteurButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(addEmprunteurButton);

        // Données tableau
        String[] entetes = {"Numéro", "Nom", "Prénom", "Adresse", "Actions"};

        Object[][] donnees = new Object[location.containers.Emprunteurs.get().size()][5];

        int count = 0;
        for (Emprunteur e : location.containers.Emprunteurs.get()) {
            donnees[count][0] = e.getId();
            donnees[count][1] = e.getNom();
            donnees[count][2] = e.getPrenom();
            donnees[count][3] = e.getAdresse().toString();
            donnees[count][4] = "Détails";

            count++;
        }

        Integer[] numData = {0};

        table = new TableauRecherche(donnees, entetes, numData, new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable)e.getSource();
                // Récupère l'ID - 1
                int modelRow = Integer.valueOf( e.getActionCommand() );

                Fenetre mainFenetre = Application.getApp().getView().getLocationFenetre();
                new EmprunteurFormDialog(mainFenetre, Emprunteurs.get().get(modelRow));
            }
        });

        add(table);
    }

    /**
     * Ecouteur du bouton de la fenêtre
     */
    private class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent event){
            JButton me = (JButton) event.getSource();

            if(me.equals(addEmprunteurButton)){
                Fenetre mainFenetre = Application.getApp().getView().getLocationFenetre();
                new EmprunteurFormDialog(mainFenetre, table);
            }
        }
    }
}
