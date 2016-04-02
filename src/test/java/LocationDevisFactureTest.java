import location.models.*;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test d'une location, d'un devis, d'une facture
 * @author Adrien Poupa
 */
public class LocationDevisFactureTest {

    private Date date1;
    private Date date2;
    private Location locationAvecAssurance;
    private Emprunteur emprunteur;
    private Adresse adresse;
    private Auto auto;
    private Exemplaire exemplaire;

    /**
     * Initialisation du test
     */
    @Before
    public void testInit(){
        date1 = new Date(1, 1, 2016);
        date2 = new Date(1, "Février", 2016);

        locationAvecAssurance = new Location(date1, date2, true);

        adresse = new Adresse(3, "avenue de la République", "94800", "Villejuif");

        emprunteur = new Emprunteur(adresse, "Adrien", "Poupa");
        emprunteur.save();

        auto = new Auto("Dacia", "Sandero", 200, 30, false);
        auto.save();

        exemplaire = new Exemplaire(60000, auto);
        exemplaire.save();

        locationAvecAssurance.louer(exemplaire, true);
        emprunteur.louer(locationAvecAssurance);

        locationAvecAssurance.save();
    }

    /**
     * Nombre de jours entre deux locations
     */
    @Test
    public void daysBetweenLocation() {
        assertEquals("Nombre de jours entre " + locationAvecAssurance.getDebut() + " et " +
                locationAvecAssurance.getFin() + " doit être 31", -31,
                locationAvecAssurance.getDebut().daysBetween(locationAvecAssurance.getFin()));
    }

    /**
     * Pour vérifier que deux fichiers soient égaux, on ruse vu que les timestamps diffèrents
     * On a un fichier de référence, et on va vérifier que le fichier nouvellement généré a au moins
     * 90% de similarité avec l'ancien, en utilisant la List de String retournée par IO Commons
     */
    @Test
    public void testDevis() {
        emprunteur.genererDevis(99999999, true);
        try {
            List<String> expected = FileUtils.readLines(new File("pdf/devis/test.pdf"));
            List<String> generated = FileUtils.readLines(new File("pdf/devis/99999999.pdf"));

            int count = 0;

            Iterator<String> it = expected.iterator();

            while (it.hasNext()){
                String s = it.next();

                if (generated.contains(s)){
                    count++;
                }
            }

            double percentage = ((double)count / (double)expected.size())*100;

            assertTrue(percentage > 90);

        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Pour vérifier que deux fichiers soient égaux, on ruse vu que les timestamps diffèrents
     * On a un fichier de référence, et on va vérifier que le fichier nouvellement généré a au moins
     * 90% de similarité avec l'ancien, en utilisant la List de String retournée par IO Commons
     */
    @Test
    public void testFacture() {
        emprunteur.genererFacture(99999999, true);
        try {
            List<String> expected = FileUtils.readLines(new File("pdf/facture/test.pdf"));
            List<String> generated = FileUtils.readLines(new File("pdf/facture/99999999.pdf"));

            int count = 0;

            Iterator<String> it = expected.iterator();

            while (it.hasNext()){
                String s = it.next();

                if (generated.contains(s)){
                    count++;
                }
            }

            double percentage = ((double)count / (double)expected.size())*100;

            assertTrue(percentage > 90);

        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
