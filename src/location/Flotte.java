package location;

import java.util.ArrayList;

/**
 * Liste de tous les véhicules
 */
public class Flotte {
    private static ArrayList<Exemplaire> exemplaires = new ArrayList<Exemplaire>();

    public static void ajout(Exemplaire e) {
        exemplaires.add(e);
    }

    public static ArrayList<Exemplaire> get() {
        return exemplaires;
    }
}
