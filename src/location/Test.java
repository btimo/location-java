package location;

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

        /**
         * Test d'adresse
         */
        Adresse adresse = new Adresse(3, "avenue de la République", 94800, "Villejuif");
        //System.out.println(adresse);

        /**
         * Test d'emprunteur
         */
        Emprunteur emprunteur = new Emprunteur(adresse, "Adrien", "Poupa");
        System.out.println(emprunteur);

        /**
         * Test de location
         */
        Location location = new Location(date, date2);
        System.out.println(location);

        /**
         * Test d'auto
         */
        Auto auto = new Auto("Ford", "Fiesta");
        System.out.println(auto);

        /**
         * Test d'exmplaire
         */
        Exemplaire exemplaire = new Exemplaire(250, location, auto);

        emprunteur.setExemplaire(exemplaire);

        System.out.println("Location");
        emprunteur.louer(); // events?
        System.out.println(emprunteur);
        System.out.println("Ramener");
        emprunteur.ramener();
        System.out.println(emprunteur);

        // Liste d'emprunteurs
        System.out.println("Liste d'emprunteurs");
        System.out.println(Emprunteurs.get());

        // Liste de véhicules
        System.out.println("Liste de véhicules");
        System.out.println(Vehicules.get());

        // Flotte d'exemplaires
        System.out.println(Flotte.get());
    }
}
