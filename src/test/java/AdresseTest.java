import models.Adresse;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Test d'adresse
 */
public class AdresseTest {

    private Adresse adresse;


    @Before
    public void testInit(){
        adresse = new Adresse(3, "avenue de la République", "94800", "Villejuif");
    }


    @Test
    public void testDisplayAdresse(){
        assertEquals("Affichage adresse", "3 avenue de la République 94800 Villejuif", adresse.toString());
    }
}
