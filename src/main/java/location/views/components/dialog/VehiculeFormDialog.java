package location.views.components.dialog;

import location.Application;
import location.models.Vehicule;
import location.views.components.form.VehiculeForm;
import location.views.components.misc.Fenetre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class VehiculeFormDialog extends JDialog {

    private VehiculeForm vehiculeForm;
    private static final String TITLE = "Formulaire vehicule";

    public VehiculeFormDialog(Frame owner){
        super(owner, TITLE, ModalityType.APPLICATION_MODAL);
        ((Fenetre) owner).setVehiculeFormDialog(this);
        vehiculeForm = new VehiculeForm();
        initVehiculeFormDialog();
    }

    public VehiculeFormDialog(Frame owner, Vehicule v){
        super(owner, TITLE + ": " + v.getMarque(), ModalityType.APPLICATION_MODAL);
        ((Fenetre) owner).setVehiculeFormDialog(this);
        vehiculeForm = new VehiculeForm(v);
        initVehiculeFormDialog();
    }

    private void initVehiculeFormDialog(){
        setContentPane(vehiculeForm);

        vehiculeForm.getValidButton().addActionListener(new ButtonListener());
        vehiculeForm.getCancelButton().addActionListener(new ButtonListener());
        pack();
        setVisible(true);
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event){
            JButton me = (JButton)event.getSource();
            VehiculeFormDialog dialog = Application.getApp().getView().getLocationFenetre().getVehiculeFormDialog();

            if(me.equals(vehiculeForm.getCancelButton())){
                dialog.setVisible(false);
                dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
            }
            else if(me.equals(vehiculeForm.getValidButton())){
                vehiculeForm.buildAndSaveVehicule();
                // todo: update Exemplaires containers and redraw table
                dialog.setVisible(false);
                dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
            }
        }
    }
}
