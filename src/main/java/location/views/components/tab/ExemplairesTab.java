package location.views.components.tab;

import location.Application;
import location.containers.Flotte;
import location.models.Auto;
import location.models.Exemplaire;
import location.models.Moto;
import location.views.components.dialog.ExemplaireFormDialog;
import location.views.components.dialog.HistogrammeFlotteDialog;
import location.views.components.misc.CustomFontLabel;
import location.views.components.misc.Fenetre;
import location.views.components.misc.TableauRecherche;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Fenêtre de l'onglet Exemplaires
 * @author Timothée Barbot
 * @author Adrien Poupa
 */
public class ExemplairesTab extends JPanel {

    private JButton addExemplaireButton;
    private JButton histogramme;
    private TableauRecherche table;

    /**
     * Initialisation de la fenêtre
     */
    public ExemplairesTab() {
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
        JLabel title = new CustomFontLabel("Liste des exemplaires","Calibri", Font.PLAIN, 25);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(title);

        // Bouton rajout Ajouter un exemplaire
        addExemplaireButton = new JButton("Ajouter un exemplaire");
        addExemplaireButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addExemplaireButton.addActionListener(new ButtonListener());
        add(addExemplaireButton);

        // Bouton histogramme
        histogramme = new JButton("Histogramme");
        histogramme.setAlignmentX(Component.CENTER_ALIGNMENT);
        histogramme.addActionListener(new ButtonListener());
        add(histogramme);

        // Données tableau
        String[] entetes = {"Numéro", "Marque", "Modèle/Cylindrée", "Kilométrage", "Réservoir", "Etat", "Actions"};

        Object[][] donnees = new Object[location.containers.Flotte.get().size()][7];

        Integer[] numData = {0, 3};

        int count = 0;
        for (Exemplaire e : location.containers.Flotte.get()) {
            donnees[count][0] = e.getId();
            donnees[count][1] = e.getVehicule().getMarque();

            String modeleCylindree;

            if (e.getVehicule() instanceof Auto) {
                modeleCylindree = ((Auto) e.getVehicule()).getModele();
            }
            else {
                modeleCylindree = Integer.toString(((Moto) e.getVehicule()).getCylindree());
            }

            donnees[count][2] = modeleCylindree;
            donnees[count][3] = e.getKilometres();
            donnees[count][4] = e.getReservoir();
            donnees[count][5] = (e.isEndommage()) ? "Mauvais" : "OK";
            donnees[count][6] = "Détails";

            count++;
        }

        table = new TableauRecherche(donnees, entetes, numData, new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable)e.getSource();
                // Récupère l'ID - 1
                int modelRow = Integer.valueOf( e.getActionCommand() );

                Fenetre mainFenetre = Application.getApp().getView().getLocationFenetre();
                new ExemplaireFormDialog(mainFenetre, Flotte.get().get(modelRow));
            }
        });

        add(table);
    }

    /**
     * Ecouteur du bouton de la fenêtre
     */
    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event){
            JButton me = (JButton) event.getSource();

            if (me.equals(addExemplaireButton)){
                Fenetre mainFenetre = Application.getApp().getView().getLocationFenetre();
                new ExemplaireFormDialog(mainFenetre, table);
            }

            if (me.equals(histogramme)){
                Fenetre mainFenetre = Application.getApp().getView().getLocationFenetre();
                new HistogrammeFlotteDialog(mainFenetre);
            }
        }
    }
}
