package location.views.components.dialog;

import location.models.Location;
import location.views.components.form.LocationForm;

import javax.swing.*;
import java.awt.*;

/**
 * Fenêtre modale Emprunteur
 * @author Timothée Barbot
 */
public class LocationFormDialog extends JDialog {

    private LocationForm locationForm;
    private static final String TITLE = "Formulaire location";

    /**
     * Constructeur frame
     * @param owner frame owner
     */
    public LocationFormDialog(Frame owner){
        super(owner, TITLE, ModalityType.APPLICATION_MODAL);
        locationForm = new LocationForm();
        initLocationFormDialog();
    }

    /**
     * Constructeur frame / emprunteur
     * @param owner frame owner
     * @param l location
     */
    public LocationFormDialog(Frame owner, Location l){
        super(owner, TITLE + ": #" + l.getId(), ModalityType.APPLICATION_MODAL);
        locationForm = new LocationForm(l);
        initLocationFormDialog();
    }

    /**
     * Initialisation de la fenêtre
     */
    private void initLocationFormDialog(){
        setContentPane(locationForm);
        pack();
        setVisible(true);
    }
}
