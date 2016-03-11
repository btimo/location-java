package location;

import java.util.ArrayList;

/**
 * Liste de tous les emprunteurs
 */
public class Emprunteurs {
    private static ArrayList<Emprunteur> emprunteurs = new ArrayList<Emprunteur>();

    public static void ajoutEmprunteur(Emprunteur e) {
        emprunteurs.add(e);
    }
}
