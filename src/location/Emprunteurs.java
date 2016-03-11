package location;

import java.util.ArrayList;

/**
 * Liste de tous les emprunteurs
 */
public class Emprunteurs {
    private static ArrayList<Emprunteur> emprunteurs = new ArrayList<Emprunteur>();

    public static void ajout(Emprunteur e) {
        emprunteurs.add(e);
    }

    public static ArrayList<Emprunteur> get() {
        return emprunteurs;
    }
}
