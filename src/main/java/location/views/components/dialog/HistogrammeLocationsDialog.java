package location.views.components.dialog;

import location.views.components.form.HistogrammeLocationsForm;
import location.views.components.misc.Fenetre;

import javax.swing.*;
import java.awt.*;

/**
 * Affichage de l'histogramme des locations
 * @author Adrien Poupa
 */
public class HistogrammeLocationsDialog extends JDialog {

    private HistogrammeLocationsForm histogrammeLocationsForm;
    private static final String TITLE = "Répartition des montants des factures";

    /**
     * Constructeur frame
     * @param owner frame owner
     */
    public HistogrammeLocationsDialog(Frame owner){
        super(owner, TITLE, Dialog.ModalityType.APPLICATION_MODAL);
        ((Fenetre) owner).setHistogrammeLocationsDialog(this);
        histogrammeLocationsForm = new HistogrammeLocationsForm();
        initExemplaireLocationsDialog();
    }

    /**
     * Initialisation de la fenêtre
     */
    private void initExemplaireLocationsDialog(){
        setContentPane(histogrammeLocationsForm);

        pack();
        setVisible(true);
    }
}
