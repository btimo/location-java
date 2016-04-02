package location.views.components.tab;

import location.views.components.misc.*;
import location.views.components.misc.CustomFontLabel;

import location.models.Location;
import location.models.LocationExemplaire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Adrien on 01/04/2016.
 */
public class LocationsTab extends JPanel {
    public LocationsTab() {
        super();
        setBackground(Color.orange);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initContent();
    }

    private void initContent() {
        // rajout du titre
        JLabel title = new CustomFontLabel("Liste des locations","Calibri", Font.PLAIN, 25);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(title);

        // Bouton rajout Ajouter une location
        JButton addLocationButton = new JButton("Ajouter une location");
        addLocationButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(addLocationButton);

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
            donnees[count][6] = "Bouton";

            count++;
        }

        add(new TableauRecherche(donnees, entetes, numData, new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable)e.getSource();
                // Récupère l'ID - 1
                int modelRow = Integer.valueOf( e.getActionCommand() );
            }
        }));
    }
}
