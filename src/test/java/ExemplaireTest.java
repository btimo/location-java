import location.models.Auto;
import location.models.Exemplaire;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

/**
 * Test d'un exemplaire
 * @author Adrien Poupa
 */
public class ExemplaireTest {
    private Exemplaire exemplaire;
    private Exemplaire exemplaire2;

    private Auto auto;
    private Auto auto2;

    /**
     * Initialisation du test
     */
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

    /**
     * Vérification du nombre de kilomètres pour un exemplaire
     */
    @org.junit.Test
    public void getKilometerShouldReturn2500(){
        assertEquals("La voiture devrait avoir 2500km", 2500, exemplaire.getKilometres());
    }

    /**
     * Vérification du réservoir
     */
    @org.junit.Test
    public void getReservoirShouldReturnPlein(){
        assertEquals("Le réservoir devrait être plein", "Plein", exemplaire.getReservoir());
    }

    /**
     * Vérification de la pénalité en cas de réservoir vide
     */
    @org.junit.Test
    public void getPenaliteReservoir(){
        assertEquals("Le pénalité devrait être de 0", 0, exemplaire.getPenaliteReservoir(), 0);
    }

    /**
     * Vérification du prix hors assurance
     */
    @org.junit.Test
    public void getPrixFinalHorsAssuranceShouldBe200(){
        assertEquals("Le prix final hors assurance devrait être de 200", 200, exemplaire.getPrixFinalHorsAssurance(), 0);
    }

    /**
     * Vérification du prix avec assurance
     */
    @org.junit.Test
    public void getPrixFinalAvecAssuranceShouldBe250(){
        assertEquals("Le prix final hors assurance devrait être de 250", 250, exemplaire.getPrixFinalAvecAssurance(), 0);
    }

    /**
     * Attente d'une exception : exemplaire trop kilométré
     */
    @org.junit.Test(expected=IllegalArgumentException.class)
    public void testExemplaireTooOld() {
        Exemplaire oldie = new Exemplaire(200000, auto);
    }
}
