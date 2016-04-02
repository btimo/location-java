import location.models.Moto;
import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Adrien on 31/03/2016.
 */
public class MotoTest {
    private Moto moto;
    private Moto moto2;
    private Moto moto3;

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

    @org.junit.Test
    public void getBrandShouldReturnHarleyDavidson(){
        assertEquals("La marque devrait être Harley Davidson", "Harley Davidson", moto.getMarque());
    }

    @org.junit.Test
    public void getCylindreeShouldReturn1000(){
        assertEquals("La cylindrée devrait être de 1000", 1000, moto.getCylindree());
    }

    @org.junit.Test
    public void getPrixJourShouldReturn140(){
        assertEquals("Le prix journalier devrait être 140", 140, moto2.getPrixJour());
    }

    @org.junit.Test
    public void getPrixAssuranceShouldReturn50(){
        assertEquals("Le prix journalier devrait être 50", 50, moto3.getPrixAssurance());
    }
}
