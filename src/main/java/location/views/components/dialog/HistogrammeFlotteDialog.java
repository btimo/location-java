package location.views.components.dialog;

import location.views.components.form.HistogrammeFlotteForm;
import location.views.components.misc.Fenetre;

import javax.swing.*;
import java.awt.*;

/**
 * Affichage de l'histogramme des exemplaires
 * @author Adrien Poupa
 */
public class HistogrammeFlotteDialog extends JDialog {

    private HistogrammeFlotteForm histogrammeFlotteForm;
    private static final String TITLE = "Répartition kilométrique de la flotte";

    /**
     * Constructeur frame
     * @param owner frame owner
     */
    public HistogrammeFlotteDialog(Frame owner){
        super(owner, TITLE, Dialog.ModalityType.APPLICATION_MODAL);
        ((Fenetre) owner).setHistogrammeFlotteDialog(this);
        histogrammeFlotteForm = new HistogrammeFlotteForm();
        initExemplaireFormDialog();
    }

    /**
     * Initialisation de la fenêtre
     */
    private void initExemplaireFormDialog(){
        setContentPane(histogrammeFlotteForm);

        pack();
        setVisible(true);
    }
}
