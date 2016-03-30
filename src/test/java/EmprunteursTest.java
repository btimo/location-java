import containers.Emprunteurs;
import models.Adresse;
import models.Emprunteur;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmprunteursTest {

    @Test
    public void getLengthshouldReturn3(){
        Adresse adresse = new Adresse(3, "avenue de la République", "94800", "Villejuif");
        Adresse adresse2 = new Adresse(3, "avenue des champs Elysées", "75800", "Paris");
        Adresse adresse3 = new Adresse(3, "place de la Comédie", "34000", "Montpellier");

        new Emprunteur(adresse, "Adrien", "Poupa").save();
        new Emprunteur(adresse2, "Stéphane", "Gateau").save();
        new Emprunteur(adresse3, "Timothée", "Barbot").save();

        assertEquals("Il devrait y avoir 3 emprunteurs", 3, Emprunteurs.get().size());
    }
}
