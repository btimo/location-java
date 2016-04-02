package location.views.components.dialog;

import location.Application;
import location.models.Location;
import location.views.components.form.LocationForm;
import location.views.components.misc.Fenetre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

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
        ((Fenetre) owner).setLocationFormDialog(this);
        locationForm = new LocationForm();
        locationForm.setBackground(Color.ORANGE);
        initLocationFormDialog();
    }

    /**
     * Constructeur frame / emprunteur
     * @param owner frame owner
     * @param l location
     */
    public LocationFormDialog(Frame owner, Location l){
        super(owner, TITLE + ": #" + l.getId(), ModalityType.APPLICATION_MODAL);
        ((Fenetre) owner).setLocationFormDialog(this);
        locationForm = new LocationForm(l);
        initLocationFormDialog();
    }

    /**
     * Initialisation de la fenêtre
     */
    private void initLocationFormDialog(){
        setContentPane(locationForm);

        locationForm.getValidButton().addActionListener(new ButtonListener());
        locationForm.getCancelButton().addActionListener(new ButtonListener());
        setSize(400,500);
        pack();
        setVisible(true);
    }

    /**
     * Ecouteur du bouton
     */
    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event){
            JButton me = (JButton)event.getSource();
            LocationFormDialog dialog = Application.getApp().getView().getLocationFenetre().getLocationFormDialog();

            if(me.equals(locationForm.getCancelButton())){
                dialog.setVisible(false);
                dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
            }
            else if(me.equals(locationForm.getValidButton())){
                locationForm.buildAndSaveLocation();
                // todo: update Exemplaires containers and redraw table
                dialog.setVisible(false);
                dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
            }
        }
    }
}
