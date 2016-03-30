import containers.Emprunteurs;
import models.Adresse;
import models.Emprunteur;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Timote on 30/03/2016.
 */
public class EmprunteursTest {

    @Test
    public void getLengthshouldReturn3(){
        Adresse adresse = new Adresse(3, "avenue de la République", "94800", "Villejuif");
        //System.out.println(adresse);
        Adresse adresse2 = new Adresse(3, "avenue des champs Elysées", "75800", "Paris");
        Adresse adresse3 = new Adresse(3, "place de la Comédie", "34000", "Montpellier");

        /**
         * Test d'emprunteur
         */
        Emprunteur emprunteur = new Emprunteur(adresse, "Adrien", "Poupa");
        emprunteur.save();
        Emprunteur emprunteur2 = new Emprunteur(adresse2, "Stéphane", "Gateau");
        emprunteur2.save();
        Emprunteur emprunteur3 = new Emprunteur(adresse3, "Timothée", "Barbot");
        emprunteur3.save();

        Emprunteurs.fetchAll();
        System.out.println(Emprunteurs.get().size());
        for(Emprunteur e: Emprunteurs.get()){
            System.out.println(e);
        }
        assertEquals("Il devrait y avoir 3 emprunteur", 3, Emprunteurs.get().size());
    }
}
