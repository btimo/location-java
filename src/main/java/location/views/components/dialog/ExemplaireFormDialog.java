package location.views.components.dialog;

import location.Application;
import location.models.Auto;
import location.models.Exemplaire;
import location.models.Moto;
import location.views.components.form.ExemplaireForm;
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
public class ExemplaireFormDialog extends JDialog {

    private ExemplaireForm exemplaireForm;
    private static final String TITLE = "Formulaire exemplaire";
    private TableauRecherche table;

    /**
     * Constructeur frame
     * @param owner frame owner
     */
    public ExemplaireFormDialog(Frame owner, TableauRecherche table){
        super(owner, TITLE, ModalityType.APPLICATION_MODAL);
        ((Fenetre) owner).setExemplaireFormDialog(this);
        exemplaireForm = new ExemplaireForm();
        this.table = table;
        initExemplaireFormDialog();
    }

    /**
     * Constructeur frame / emprunteur
     * @param owner frame owner
     * @param e exemplaire
     */
    public ExemplaireFormDialog(Frame owner, Exemplaire e){
        super(owner, TITLE + ": " + e.getDisplayName(), ModalityType.APPLICATION_MODAL);
        ((Fenetre) owner).setExemplaireFormDialog(this);
        exemplaireForm = new ExemplaireForm(e);
        initExemplaireFormDialog();
    }

    /**
     * Initialisation de la fenêtre
     */
    private void initExemplaireFormDialog(){
        setContentPane(exemplaireForm);
        exemplaireForm.getCancelButton().addActionListener(new ButtonListener());
        exemplaireForm.getValidButton().addActionListener(new ButtonListener());
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
            ExemplaireFormDialog dialog = Application.getApp().getView().getLocationFenetre().getExemplaireFormDialog();

            if(me.equals(exemplaireForm.getCancelButton())){
                dialog.setVisible(false);
                dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
            }
            else if(me.equals(exemplaireForm.getValidButton())){
                Exemplaire newExamplaire = exemplaireForm.buildAndSaveExemplaire();

                String modeleCylindree;
                if (newExamplaire.getVehicule() instanceof Auto) {
                    modeleCylindree = ((Auto) newExamplaire.getVehicule()).getModele();
                }
                else {
                    modeleCylindree = Integer.toString(((Moto) newExamplaire.getVehicule()).getCylindree());
                }

                Object [] newExamplaireRow = new Object[]{newExamplaire.getId(), newExamplaire.getVehicule().getMarque(),
                        modeleCylindree, newExamplaire.getKilometres(), newExamplaire.getReservoir(), ((newExamplaire.isEndommage()) ? "Mauvais" : "OK"), "Détails"};
                table.addRow(newExamplaireRow);
                dialog.setVisible(false);
                dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
            }

        }
    }
}
