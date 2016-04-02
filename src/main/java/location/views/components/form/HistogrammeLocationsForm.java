package location.views.components.form;


import location.containers.Emprunteurs;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

/**
 * Formulaire de vue d'histogramme
 * @author Adrien Poupa
 */
public class HistogrammeLocationsForm extends JPanel {

    /**
     * Constructeur par défaut
     */
    public HistogrammeLocationsForm(){
        super();
        initContent();
    }

    /**
     * init the panel with its components
     */
    private void initContent(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(Emprunteurs.rechercheMontant(0, 100).size(), "Factures", "0, 100");
        dataset.setValue(Emprunteurs.rechercheMontant(100, 500).size(), "Factures", "100, 500");
        dataset.setValue(Emprunteurs.rechercheMontant(500, 1000).size(), "Factures", "500, 1 000");
        dataset.setValue(Emprunteurs.rechercheMontant(1000, 3000).size(), "Factures", "1 000, 3 000");
        dataset.setValue(Emprunteurs.rechercheMontant(3000, 5000).size(), "Factures", "3 000, 5 000");
        JFreeChart chart = ChartFactory.createBarChart("Répartition des montants de factures",
                "Prix", "Nombre de Factures", dataset, PlotOrientation.VERTICAL,
                false, true, false);

        //create and display a frame...
        ChartFrame frame = new ChartFrame("Répartition kilométrique de la flotte",chart);
        frame.pack();
        add(frame.getChartPanel());
    }

}
