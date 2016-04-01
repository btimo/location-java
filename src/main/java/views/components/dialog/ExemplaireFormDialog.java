package views.components.dialog;

import models.Exemplaire;
import views.components.form.ExemplaireForm;

import javax.swing.*;
import java.awt.*;

public class ExemplaireFormDialog extends JDialog {

    private ExemplaireForm exemplaireForm;
    private static final String TITLE = "Formulaire exemplaire";

    public ExemplaireFormDialog(Frame owner){
        super(owner, TITLE, ModalityType.APPLICATION_MODAL);
        exemplaireForm = new ExemplaireForm();
        initExemplaireFormDialog();
    }

    public ExemplaireFormDialog(Frame owner, Exemplaire e){
        super(owner, TITLE + ": " + e.getDisplayName(), ModalityType.APPLICATION_MODAL);
        exemplaireForm = new ExemplaireForm(e);
        initExemplaireFormDialog();
    }

    private void initExemplaireFormDialog(){
        this.add(exemplaireForm);
    }
}
