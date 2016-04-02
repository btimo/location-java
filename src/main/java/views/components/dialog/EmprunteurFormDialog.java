package views.components.dialog;

import models.Emprunteur;
import views.LocationViews;
import views.components.form.EmprunteurForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Objects;
import java.util.logging.Logger;

public class EmprunteurFormDialog extends JDialog{

    private EmprunteurForm emprunteurForm;
    private static final String TITLE = "Formulaire emprunteur";

    public EmprunteurFormDialog(Frame owner){
        super(owner, TITLE, ModalityType.APPLICATION_MODAL);
        emprunteurForm = new EmprunteurForm();
        initEmprunteurFormDialog();
    }

    public EmprunteurFormDialog(Frame owner, Emprunteur e){
        super(owner, TITLE + ": " + e.getDisplayName(), ModalityType.APPLICATION_MODAL);
        emprunteurForm = new EmprunteurForm(e);
        initEmprunteurFormDialog();
    }

    private void initEmprunteurFormDialog(){
        setContentPane(emprunteurForm);
        emprunteurForm.getCancelButton().addActionListener(new ButtonListener());
        emprunteurForm.getValidButton().addActionListener(new ButtonListener());
        pack();
        setVisible(true);
    }

    public class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent event){
            JButton me = (JButton)event.getSource();

            /*if(Objects.equals(me.getText(), "Annuler")){
                EmprunteurFormDialog dialog = LocationViews.emprunteurFormDialog;
                System.out.println(dialog);
                dialog.setVisible(false);
                dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
            }
            else if(Objects.equals(me.getText(), "Valider")){
                EmprunteurFormDialog dialog = LocationViews.emprunteurFormDialog;
                emprunteurForm.buildAndSaveEmprunteur();
                dialog.setVisible(false);
                dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
            }*/
        }
    }
}
