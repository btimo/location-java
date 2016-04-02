import location.containers.Emprunteurs;
import location.models.Adresse;
import location.models.Emprunteur;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmprunteursTest {

    private Adresse adresse;
    private Adresse adresse2;
    private Adresse adresse3;
    private Emprunteur emprunteur;
    private Emprunteur emprunteur2;
    private Emprunteur emprunteur3;

    @Before
    public void testInit() {
        adresse = new Adresse(3, "avenue de la République", "94800", "Villejuif");
        adresse2 = new Adresse(3, "avenue des champs Elysées", "75800", "Paris");
        adresse3 = new Adresse(3, "place de la Comédie", "34000", "Montpellier");

        emprunteur = new Emprunteur(adresse, "Adrien", "Poupa");
        emprunteur.save();
        emprunteur2 = new Emprunteur(adresse2, "Stéphane", "Gateau");
        emprunteur2.save();
        emprunteur3 = new Emprunteur(adresse3, "Timothée", "Barbot");
        emprunteur3.save();
    }

    @Test
    public void getLengthshouldReturn3(){
        assertEquals("Il devrait y avoir 3 emprunteurs", 3, Emprunteurs.get().size());
    }
}
