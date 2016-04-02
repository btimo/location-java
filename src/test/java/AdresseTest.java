import location.models.Adresse;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test d'adresse
 * @author Adrien Poupa
 */
public class AdresseTest {

    private Adresse adresse;


    /**
     * Initialisation du test
     */
    @Before
    public void testInit(){
        adresse = new Adresse(3, "avenue de la République", "94800", "Villejuif");
    }


    /**
     * Vérification de l'affichage d'une adresse
     */
    @Test
    public void testDisplayAdresse(){
        assertEquals("Affichage adresse", "3 avenue de la République 94800 Villejuif", adresse.toString());
    }
}
