package views.components.dialog;

import models.Vehicule;
import views.components.form.VehiculeForm;

import javax.swing.*;
import java.awt.*;

public class VehiculeFormDialog extends JDialog {

    private VehiculeForm vehiculeForm;
    private static final String TITLE = "Formulaire vehicule";

    public VehiculeFormDialog(Frame owner){
        super(owner, TITLE, ModalityType.APPLICATION_MODAL);
        vehiculeForm = new VehiculeForm();
        initVehiculeFormDialog();
    }

    public VehiculeFormDialog(Frame owner, Vehicule v){
        super(owner, TITLE + ": " + v.getMarque(), ModalityType.APPLICATION_MODAL);
        vehiculeForm = new VehiculeForm(v);
        initVehiculeFormDialog();
    }

    private void initVehiculeFormDialog(){
        setContentPane(vehiculeForm);
        pack();
        setVisible(true);
    }
}
