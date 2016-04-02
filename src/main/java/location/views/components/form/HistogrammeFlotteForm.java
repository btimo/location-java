package location.views.components.form;


import location.containers.Flotte;
import location.containers.Vehicules;
import location.models.Exemplaire;
import location.models.Vehicule;
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
public class HistogrammeFlotteForm extends JPanel {

    /**
     * Constructeur par défaut
     */
    public HistogrammeFlotteForm(){
        super();
        initContent();
    }

    /**
     * init the panel with its components
     */
    private void initContent(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(Flotte.rechercheKm(0, 5000).size(), "Véhicules", "0, 5 000");
        dataset.setValue(Flotte.rechercheKm(5000, 20000).size(), "Véhicules", "5 000, 20 000");
        dataset.setValue(Flotte.rechercheKm(20000, 40000).size(), "Véhicules", "20 000, 40 000");
        dataset.setValue(Flotte.rechercheKm(40000, 80000).size(), "Véhicules", "40 000, 80 000");
        JFreeChart chart = ChartFactory.createBarChart("Répartition kilométrique de la flotte",
                "Kilométrage", "Nombre de véhicules", dataset, PlotOrientation.VERTICAL,
                false, true, false);

        //create and display a frame...
        ChartFrame frame = new ChartFrame("Répartition kilométrique de la flotte",chart);
        frame.pack();
        add(frame.getChartPanel());
    }

}
