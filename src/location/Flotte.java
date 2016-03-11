package location;

import java.util.ArrayList;

/**
 * Liste de tous les véhicules
 */
public class Flotte {
    private static ArrayList<Exemplaire> exemplaires = new ArrayList<Exemplaire>();

    public static void ajoutFlotte(Exemplaire e) {
        exemplaires.add(e);
    }
}
