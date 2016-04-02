package location.views.components.tab;

import location.Application;
import location.containers.Locations;
import location.models.Location;
import location.models.LocationExemplaire;
import location.views.components.dialog.HistogrammeLocationsDialog;
import location.views.components.dialog.LocationFormDialog;
import location.views.components.misc.CustomFontLabel;
import location.views.components.misc.Fenetre;
import location.views.components.misc.TableauRecherche;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Fenêtre de l'onglet Locations
 * @author Timothée Barbot
 * @author Adrien Poupa
 */
public class LocationsTab extends JPanel {

    private JButton addLocationButton;
    private JButton histogramme;

    /**
     * Initialisation de la fenêtre
     */
    public LocationsTab() {
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
        JLabel title = new CustomFontLabel("Liste des locations","Calibri", Font.PLAIN, 25);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(title);

        // Bouton rajout Ajouter une location
        addLocationButton = new JButton("Ajouter une location");
        addLocationButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addLocationButton.addActionListener(new ButtonListener());
        add(addLocationButton);

        // Bouton histogramme
        histogramme = new JButton("Histogramme");
        histogramme.setAlignmentX(Component.CENTER_ALIGNMENT);
        histogramme.addActionListener(new ButtonListener());
        add(histogramme);

        // Données tableau
        String[] entetes = {"Numéro", "Locataire", "Date début", "Date fin", "Devis accepté", "Prix TTC", "Actions"};

        Object[][] donnees = new Object[location.containers.Locations.get().size()][7];

        Integer[] numData = {0, 5};

        int count = 0;
        for (Location l : location.containers.Locations.get()) {
            donnees[count][0] = l.getId();
            donnees[count][1] = l.getEmprunteur().getDisplayName();
            donnees[count][2] = l.getDebut().toString();
            donnees[count][3] = l.getFin().toString();
            donnees[count][4] = (l.isApprouvee()) ? "Oui" : "Non";

            double prixFinal = 0;
            for (LocationExemplaire e : l.getLocationExemplaires()) {
                prixFinal += e.getPrixFinalRetour();
            }

            donnees[count][5] = prixFinal;
            donnees[count][6] = "Détails";

            count++;
        }

        add(new TableauRecherche(donnees, entetes, numData, new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable)e.getSource();
                // Récupère l'ID - 1
                int modelRow = Integer.valueOf( e.getActionCommand() );

                Fenetre mainFenetre = Application.getApp().getView().getLocationFenetre();
                new LocationFormDialog(mainFenetre, Locations.get().get(modelRow));
            }
        }));
    }

    /**
     * Ecouteur du bouton d'ajout
     */
    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event){
            JButton me = (JButton) event.getSource();

            if (me.equals(addLocationButton)){
                Fenetre mainFenetre = Application.getApp().getView().getLocationFenetre();
                new LocationFormDialog(mainFenetre);
            }

            if (me.equals(histogramme)){
                Fenetre mainFenetre = Application.getApp().getView().getLocationFenetre();
                new HistogrammeLocationsDialog(mainFenetre);
            }
        }
    }
}
