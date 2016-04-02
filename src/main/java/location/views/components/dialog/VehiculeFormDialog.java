package location.views.components.dialog;

import location.Application;
import location.models.Auto;
import location.models.Moto;
import location.models.Vehicule;
import location.views.components.form.VehiculeForm;
import location.views.components.misc.Fenetre;
import location.views.components.misc.TableauRecherche;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Fenêtre modale Emprunteur
 * @author Timothée Barbot
 */
public class VehiculeFormDialog extends JDialog {

    private VehiculeForm vehiculeForm;
    private static final String TITLE = "Formulaire vehicule";
    private TableauRecherche table;

    /**
     * Constructeur frame
     * @param owner frame owner
     */
    public VehiculeFormDialog(Frame owner, TableauRecherche table){
        super(owner, TITLE, ModalityType.APPLICATION_MODAL);
        ((Fenetre) owner).setVehiculeFormDialog(this);
        this.table = table;
        vehiculeForm = new VehiculeForm();
        initVehiculeFormDialog();
    }

    /**
     * Constructeur frame / emprunteur
     * @param owner frame owner
     * @param v vehicule
     */
    public VehiculeFormDialog(Frame owner, Vehicule v){
        super(owner, TITLE + ": " + v.getMarque(), ModalityType.APPLICATION_MODAL);
        ((Fenetre) owner).setVehiculeFormDialog(this);
        vehiculeForm = new VehiculeForm(v);
        initVehiculeFormDialog();
    }

    /**
     * Initialisation de la fenêtre
     */
    private void initVehiculeFormDialog(){
        setContentPane(vehiculeForm);

        vehiculeForm.getValidButton().addActionListener(new ButtonListener());
        vehiculeForm.getCancelButton().addActionListener(new ButtonListener());
        setSize(500,400);
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
            VehiculeFormDialog dialog = Application.getApp().getView().getLocationFenetre().getVehiculeFormDialog();

            if(me.equals(vehiculeForm.getCancelButton())){
                dialog.setVisible(false);
                dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
            }
            else if(me.equals(vehiculeForm.getValidButton())) {
                Vehicule newVehicule = vehiculeForm.buildAndSaveVehicule();

                String modeleCylindree;

                if (newVehicule instanceof Auto) {
                    modeleCylindree = ((Auto) newVehicule).getModele();
                    if (((Auto) newVehicule).isLuxe()) {
                        modeleCylindree += " (luxe)";
                    }
                }
                else {
                    modeleCylindree = Integer.toString(((Moto) newVehicule).getCylindree());
                }

                Object [] newVehiculeRow = new Object[]{newVehicule.getId(), newVehicule.getMarque(),
                        modeleCylindree, newVehicule.getPrixJour(), newVehicule.getPrixAssurance(), "Détails"};
                table.addRow(newVehiculeRow);

                dialog.setVisible(false);
                dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
            }
           /* else if(me.equals(vehiculeForm.getDeletButton())){
            JTable table = (JTable)event.getSource();
            // Récupère l'ID - 1
            int modelRow = Integer.valueOf( event.getActionCommand() );
            Vehicule ex = Vehicules.get().get(modelRow);
                dialog.deleteRox(ex.getId());
            }
            */
        }
    }
}
