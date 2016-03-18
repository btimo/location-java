
import models.*;

/**
 * Classe de tests
 */
public class Test {
    public static void main (String[] args) {
        /**
         * Test de date
         */
        Date date = new Date(1, 1, 2016);
        //System.out.println(date);

        Date date2 = new Date(1, "Février", 2016);
        //System.out.println(date2);

        /*System.out.println("Jours entre deux dates:");
        System.out.println(date2.daysBetween(date));*/

        /**
         * Test d'adresse
         */
        Adresse adresse = new Adresse(3, "avenue de la République", "94800", "Villejuif");
        //System.out.println(adresse);
        Adresse adresse2 = new Adresse(3, "avenue des champs Elysées", "75800", "Paris");
        Adresse adresse3 = new Adresse(3, "place de la Comédie", "34000", "Montpellier");

        /**
         * Test d'emprunteur
         */
        Emprunteur emprunteur = new Emprunteur(adresse, "Adrien", "Poupa");
        Emprunteur emprunteur2 = new Emprunteur(adresse2, "Stéphane", "Gateau");
        Emprunteur emprunteur3 = new Emprunteur(adresse3, "Timothée", "Barbot");
        System.out.println(emprunteur);

        /**
         * Test de location
         */
        Location locationAvecAssurance = new Location(date, date2, true, true);
        System.out.println(locationAvecAssurance);

        /**
         * Test d'auto
         */
        Auto auto = new Auto("Ford", "Fiesta", 200, 50, false);
        System.out.println(auto);
        Auto auto2 = new Auto("Dacia", "Sandero", 200, 30, false);
        System.out.println(auto2);
        Auto auto3 = new Auto("Audi", "A1", 500, 100, true);
        System.out.println(auto3);

        /**
         * Test d'exmplaire
         */
        try {
            Exemplaire exemplaire = new Exemplaire(250, locationAvecAssurance, auto);
            Exemplaire exemplaire2 = new Exemplaire(60000, auto2);
            emprunteur.louer(exemplaire); // events?
            emprunteur.genererDevis();
            exemplaire.setEndommage(true);
            exemplaire.setReservoir(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Location");
        System.out.println(emprunteur);
        System.out.println("Ramener");
        emprunteur.genererFacture();
        emprunteur.ramener();
        System.out.println(emprunteur);

        // Liste d'emprunteurs
        System.out.println("Liste d'emprunteurs");
        System.out.println(Emprunteurs.get());
        System.out.println("Tri nom");
        Emprunteurs.triNom();
        System.out.println(Emprunteurs.get());
        System.out.println("Tri ID");
        Emprunteurs.triId();
        System.out.println(Emprunteurs.get());
        System.out.println("Tri Code Postal");
        Emprunteurs.triCodePostal();
        System.out.println(Emprunteurs.get());
        System.out.println("Recherche pour le nom: Barbot");
        System.out.println(Emprunteurs.rechercheNom("Barbot"));
        System.out.println("Recherche pour le véhicule: Fiesta");
        try {
            Exemplaire exemplaire = new Exemplaire(250, locationAvecAssurance, auto);
            Exemplaire exemplaire2 = new Exemplaire(150, auto2);
            emprunteur.setExemplaire(exemplaire);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(Emprunteurs.rechercheVehicule(auto));

        // Liste de véhicules
        System.out.println("Liste de véhicules");
        System.out.println(Vehicules.get());
        System.out.println("Tri alphabétique");
        Vehicules.triMarque();
        System.out.println(Vehicules.get());
        System.out.println("Modele: Sandero");
        System.out.println(Vehicules.triModele("Sandero"));

        // Flotte d'exemplaires
        System.out.println("Liste d'exemplaires");
        System.out.println(Flotte.get());
        System.out.println("Tri kilométrique");
        Flotte.triKm();
        System.out.println(Flotte.get());
        System.out.println("Tri ID");
        Flotte.triId();
        System.out.println(Flotte.get());
        System.out.println("< 160km");
        System.out.println(Flotte.rechercheKm("<", 160));
        System.out.println("= 250km");
        System.out.println(Flotte.rechercheKm("=", 250));
    }
}
