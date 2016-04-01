package views.components.dialog;

import models.Location;
import views.components.form.LocationForm;

import javax.swing.*;
import java.awt.*;

public class LocationFormDialog extends JDialog {

    private LocationForm locationForm;
    private static final String TITLE = "Formulaire location";

    public LocationFormDialog(Frame owner){
        super(owner, TITLE, ModalityType.APPLICATION_MODAL);
        locationForm = new LocationForm();
        initLocationFormDialog();
    }

    public LocationFormDialog(Frame owner, Location l){
        super(owner, TITLE + ": #" + l.getId(), ModalityType.APPLICATION_MODAL);
        locationForm = new LocationForm(l);
        initLocationFormDialog();
    }

    private void initLocationFormDialog(){
        setContentPane(locationForm);
        pack();
        setVisible(true);
    }
}
