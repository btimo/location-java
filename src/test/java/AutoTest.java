import models.Auto;
import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Adrien on 31/03/2016.
 */
public class AutoTest {
    private Auto auto;
    private Auto auto2;
    private Auto auto3;

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

    @org.junit.Test
    public void getBrandShouldReturnFord(){
        assertEquals("La marque devrait être Ford", "Ford", auto.getMarque());
    }

    @org.junit.Test
    public void getModelShouldReturnFiesta(){
        assertEquals("Le modèle devrait être Fiesta", "Fiesta", auto.getModele());
    }

    @org.junit.Test
    public void getPrixJourShouldReturn200(){
        assertEquals("Le prix journalier devrait être 200", 200, auto.getPrixJour());
    }

    @org.junit.Test
    public void getPrixAssuranceShouldReturn50(){
        assertEquals("Le prix journalier devrait être 50", 50, auto.getPrixAssurance());
    }

    @org.junit.Test
    public void isLuxeShouldBeFalse(){
        assertEquals("La voiture ne devrait pas être de luxe", false, auto.isLuxe());
    }
}
