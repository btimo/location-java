
import containers.Emprunteurs;
import containers.Flotte;
import containers.Vehicules;
import models.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Classe de tests
 * @author Adrien Poupa
 */
public class Test {
    /**
     * Jeu de tests
     * @param args arguments par défaut
     */
    public static void main (String[] args) {
        /**
         * Test de date
         */
        Date date = new Date(1, 1, 2016);
        //System.out.println(date);

        Date date2 = new Date(1, "Février", 2016);
        //System.out.println(date2);

        /*System.out.println("Jours entre deux dates:");
        System.out.println(date2.daysBetween(date));*/

        /**
         * Test d'adresse
         */
        Adresse adresse = new Adresse(3, "avenue de la République", "94800", "Villejuif");
        //System.out.println(adresse);
        Adresse adresse2 = new Adresse(3, "avenue des champs Elysées", "75800", "Paris");
        Adresse adresse3 = new Adresse(3, "place de la Comédie", "34000", "Montpellier");

        /**
         * Test d'emprunteur
         */
        Emprunteur emprunteur = new Emprunteur(adresse, "Adrien", "Poupa");
        emprunteur.save();
        Emprunteur emprunteur2 = new Emprunteur(adresse2, "Stéphane", "Gateau");
        emprunteur2.save();
        Emprunteur emprunteur3 = new Emprunteur(adresse3, "Timothée", "Barbot");
        emprunteur3.save();
        System.out.println(emprunteur);

        /**
         * Test de location
         */
        Location locationAvecAssurance = new Location(date, date2, true);
        locationAvecAssurance.save();
        System.out.println(locationAvecAssurance);

        /**
         * Test d'auto
         */
        Auto auto = new Auto("Ford", "Fiesta", 200, 50, false);
        auto.save();
        System.out.println(auto);
        Auto auto2 = new Auto("Dacia", "Sandero", 200, 30, false);
        auto2.save();
        System.out.println(auto2);
        Auto auto3 = new Auto("Audi", "A1", 500, 100, true);
        auto3.save();
        System.out.println(auto3);

        /**
         * Test d'exemplaire
         */
        try {
            Exemplaire exemplaire = new Exemplaire(250, auto);
            exemplaire.save();
            locationAvecAssurance.louer(exemplaire, true);
            Exemplaire exemplaire2 = new Exemplaire(60000, auto2);
            exemplaire2.save();
            System.out.println(emprunteur);
            locationAvecAssurance.louer(exemplaire2, true);
            emprunteur.louer(locationAvecAssurance);
            System.out.println(emprunteur);
            emprunteur.genererDevis(locationAvecAssurance.getId().intValue());
            exemplaire.setEndommage(true);
            exemplaire.setReservoir(0);
            System.out.println("Location");
            System.out.println("Ramener");
            emprunteur.genererFacture(1);
            emprunteur.ramener();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Liste d'emprunteurs
        System.out.println("Liste d'emprunteurs");
        System.out.println(Emprunteurs.get());
        System.out.println("Tri nom");
        Emprunteurs.triNom();
        System.out.println(Emprunteurs.get());
        System.out.println("Tri ID");
        Emprunteurs.triId();
        System.out.println(Emprunteurs.get());
        System.out.println("Tri Code Postal");
        Emprunteurs.triCodePostal();
        System.out.println(Emprunteurs.get());
        System.out.println("Recherche pour le nom: Barbot");
        System.out.println(Emprunteurs.rechercheNom("Barbot"));
        System.out.println("Recherche pour le véhicule: Fiesta");
        try {
            Exemplaire exemplaire = new Exemplaire(250, auto);
            exemplaire.save();
            Exemplaire exemplaire2 = new Exemplaire(150, auto2);
            exemplaire2.save();
            locationAvecAssurance.louer(exemplaire, true);
            locationAvecAssurance.louer(exemplaire2, true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(Emprunteurs.rechercheVehicule(auto));

        // Liste de véhicules
        System.out.println("Liste de véhicules");
        System.out.println(Vehicules.get());
        System.out.println("Tri alphabétique");
        Vehicules.triMarque();
        System.out.println(Vehicules.get());
        System.out.println("Modele: Sandero");
        System.out.println(Vehicules.triModele("Sandero"));

        // Flotte d'exemplaires
        System.out.println("Liste d'exemplaires");
        System.out.println(Flotte.get());
        System.out.println("Tri kilométrique");
        Flotte.triKm();
        System.out.println(Flotte.get());
        System.out.println("Tri ID");
        Flotte.triId();
        System.out.println(Flotte.get());
        System.out.println("< 160km");
        System.out.println(Flotte.rechercheKm("<", 160));
        System.out.println("= 250km");
        System.out.println(Flotte.rechercheKm("=", 250));

        /**
         * Histogramme
         */

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
        frame.setVisible(true);

        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
        dataset2.setValue(Emprunteurs.rechercheMontant(0, 100).size(), "Factures", "0, 100");
        dataset2.setValue(Emprunteurs.rechercheMontant(100, 500).size(), "Factures", "100, 500");
        dataset2.setValue(Emprunteurs.rechercheMontant(500, 1000).size(), "Factures", "500, 1 000");
        dataset2.setValue(Emprunteurs.rechercheMontant(1000, 3000).size(), "Factures", "1 000, 3 000");
        dataset2.setValue(Emprunteurs.rechercheMontant(3000, 5000).size(), "Factures", "3 000, 5 000");
        JFreeChart chart2 = ChartFactory.createBarChart("Répartition des montants de factures",
                "Kilométrage", "Nombre de Factures", dataset2, PlotOrientation.VERTICAL,
                false, true, false);

        //create and display a frame...
        ChartFrame frame2 = new ChartFrame("Répartition des montants de factures",chart2);
        frame2.pack();
        frame2.setVisible(true);
    }
}
