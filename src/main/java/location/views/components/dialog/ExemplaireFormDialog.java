package location.views.components.dialog;

import location.models.Exemplaire;
import location.views.components.form.ExemplaireForm;

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
        setContentPane(exemplaireForm);
        pack();
        setVisible(true);
    }
}
