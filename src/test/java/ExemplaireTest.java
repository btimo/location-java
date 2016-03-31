import models.Auto;
import models.Exemplaire;
import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Adrien on 31/03/2016.
 */
public class ExemplaireTest {
    private Exemplaire exemplaire;
    private Exemplaire exemplaire2;

    private Auto auto;
    private Auto auto2;

    @Before
    public void testInit(){
        auto = new Auto("Ford", "Fiesta", 200, 50, false);
        auto.save();
        auto2 = new Auto("Dacia", "Sandero", 200, 30, false);
        auto2.save();

        exemplaire = new Exemplaire(2500, auto);
        exemplaire.save();

        /*locationAvecAssurance.louer(exemplaire, true);
        Exemplaire exemplaire2 = new Exemplaire(60000, auto2);
        exemplaire2.save();*/
    }

    @org.junit.Test
    public void getKilometerShouldReturn2500(){
        assertEquals("La voiture devrait avoir 2500km", 2500, exemplaire.getKilometres());
    }

    @org.junit.Test
    public void getReservoirShouldReturnPlein(){
        assertEquals("Le réservoir devrait être plein", "Plein", exemplaire.getReservoir());
    }

    @org.junit.Test
    public void getPenaliteReservoir(){
        assertEquals("Le pénalité devrait être de 0", 0, exemplaire.getPenaliteReservoir(), 0);
    }

    @org.junit.Test
    public void getPrixFinalHorsAssuranceShouldBe200(){
        assertEquals("Le prix final hors assurance devrait être de 200", 200, exemplaire.getPrixFinalHorsAssurance(), 0);
    }

    @org.junit.Test
    public void getPrixFinalAvecAssuranceShouldBe200(){
        assertEquals("Le prix final hors assurance devrait être de 250", 250, exemplaire.getPrixFinalAvecAssurance(), 0);
    }

    @org.junit.Test(expected=IllegalArgumentException.class)
    public void testExemplaireTooOld() {
        Exemplaire oldie = new Exemplaire(200000, auto);
    }
}
