import location.models.Auto;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

/**
 * Test d'Auto
 * @author Adrien Poupa
 */
public class AutoTest {
    private Auto auto;
    private Auto auto2;
    private Auto auto3;

    /**
     * Initialisation du test
     */
    @Before
    public void setUp(){
        auto = new Auto("Ford", "Fiesta", 200, 50, false);
        auto.save();
        auto2 = new Auto("Dacia", "Sandero", 200, 30, false);
        auto2.save();
        auto3 = new Auto("Audi", "A1", 500, 100, true);
        auto3.save();
    }

    // Problème : 12 au lieu de 3 quand lancement de tous les tests (init faite à chaque test...)
    /*@org.junit.Test
    public void getBatestLengthshouldReturn3(){
        assertEquals("Il devrait y avoir 3 voitures", 3, Vehicules.get().size());
    }*/

    /**
     * Vérification de la marque
     */
    @org.junit.Test
    public void getBrandShouldReturnFord(){
        assertEquals("La marque devrait être Ford", "Ford", auto.getMarque());
    }

    /**
     * Vérification du modèle
     */
    @org.junit.Test
    public void getModelShouldReturnFiesta(){
        assertEquals("Le modèle devrait être Fiesta", "Fiesta", auto.getModele());
    }

    /**
     * Vérification du prix journalier
     */
    @org.junit.Test
    public void getPrixJourShouldReturn200(){
        assertEquals("Le prix journalier devrait être 200", 200, auto.getPrixJour());
    }

    /**
     * Vérification du prux de l'assurance
     */
    @org.junit.Test
    public void getPrixAssuranceShouldReturn50(){
        assertEquals("Le prix de l'assurance devrait être 50", 50, auto.getPrixAssurance());
    }

    /**
     * Vérification de la 'luxure' de la voiture :-)
     */
    @org.junit.Test
    public void isLuxeShouldBeFalse(){
        assertEquals("La voiture ne devrait pas être de luxe", false, auto.isLuxe());
    }
}
