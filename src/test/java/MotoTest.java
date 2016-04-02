import location.models.Moto;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

/**
 * Test d'une moto
 * @author Adrien Poupa
 */
public class MotoTest {
    private Moto moto;
    private Moto moto2;
    private Moto moto3;

    /**
     * Initialisation du test
     */
    @Before
    public void setUp(){
        moto = new Moto("Harley Davidson", 1000, 150, 30);
        moto.save();
        moto2 = new Moto("Harley Davidson", 1200, 140, 40);
        moto2.save();
        moto3 = new Moto("Harley Davidson", 1500, 160, 50);
        moto3.save();
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
    public void getBrandShouldReturnHarleyDavidson(){
        assertEquals("La marque devrait être Harley Davidson", "Harley Davidson", moto.getMarque());
    }

    /**
     * Vérification de la cylindrée
     */
    @org.junit.Test
    public void getCylindreeShouldReturn1000(){
        assertEquals("La cylindrée devrait être de 1000", 1000, moto.getCylindree());
    }

    /**
     * Vérification du prix journalier
     */
    @org.junit.Test
    public void getPrixJourShouldReturn140(){
        assertEquals("Le prix journalier devrait être 140", 140, moto2.getPrixJour());
    }

    /**
     * Vérification du prix assurance
     */
    @org.junit.Test
    public void getPrixAssuranceShouldReturn50(){
        assertEquals("Le prix journalier devrait être 50", 50, moto3.getPrixAssurance());
    }
}
