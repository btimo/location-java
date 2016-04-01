package views.components.dialog;

import models.Emprunteur;
import views.components.form.EmprunteurForm;

import javax.swing.*;
import java.awt.*;

public class EmprunteurFormDialog extends JDialog {

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
        this.add(emprunteurForm);
    }
}
