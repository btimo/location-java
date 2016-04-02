package location.views.components.dialog;

import location.Application;
import location.models.Emprunteur;
import location.views.components.form.EmprunteurForm;
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
public class EmprunteurFormDialog extends JDialog{

    private EmprunteurForm emprunteurForm;
    private static final String TITLE = "Formulaire emprunteur";

    /**
     * Constructeur frame
     * @param owner frame owner
     */
    public EmprunteurFormDialog(Frame owner){
        super(owner, TITLE, ModalityType.APPLICATION_MODAL);
        ((Fenetre) owner).setEmprunteurFormDialog(this);
        emprunteurForm = new EmprunteurForm();
        initEmprunteurFormDialog();
    }

    /**
     * Constructeur frame / emprunteur
     * @param owner frame owner
     * @param e emprunteur
     */
    public EmprunteurFormDialog(Frame owner, Emprunteur e){
        super(owner, TITLE + ": " + e.getDisplayName(), ModalityType.APPLICATION_MODAL);
        ((Fenetre) owner).setEmprunteurFormDialog(this);
        emprunteurForm = new EmprunteurForm(e);
        initEmprunteurFormDialog();
    }

    /**
     * Initialisation de la fenêtre
     */
    private void initEmprunteurFormDialog(){
        setContentPane(emprunteurForm);
        emprunteurForm.getCancelButton().addActionListener(new ButtonListener());
        emprunteurForm.getValidButton().addActionListener(new ButtonListener());
        pack();
        setVisible(true);
    }

    /**
     * Ecouteur du bouton
     */
    private class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent event){
            JButton me = (JButton)event.getSource();
            EmprunteurFormDialog dialog = Application.getApp().getView().getLocationFenetre().getEmprunteurFormDialog();

            if(me.equals(emprunteurForm.getCancelButton())){
                dialog.setVisible(false);
                dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
            }
            else if(me.equals(emprunteurForm.getValidButton())){
                emprunteurForm.buildAndSaveEmprunteur();
                // todo: update Emprunteurs containers and redraw table
                dialog.setVisible(false);
                dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
            }
        }
    }
}
