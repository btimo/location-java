package location;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

    public static void triId()
    {
        Collections.sort(emprunteurs, new Comparator<Emprunteur>()
        {
            public int compare(Emprunteur e1, Emprunteur e2)
            {
                if (e1.getId() > e2.getId()) {
                    return 1;
                }
                else if (e1.getId() < e2.getId()) {
                    return -1;
                }
                return 0;
            }
        });
    }

    public static void triNom()
    {
        Collections.sort(emprunteurs, new Comparator<Emprunteur>()
        {
            public int compare(Emprunteur e1, Emprunteur e2)
            {
                return e1.getNom().compareTo(e2.getNom());
            }
        });
    }

    public static void triPrenom()
    {
        Collections.sort(emprunteurs, new Comparator<Emprunteur>()
        {
            public int compare(Emprunteur e1, Emprunteur e2)
            {
                return e1.getPrenom().compareTo(e2.getPrenom());
            }
        });
    }

    public static void triCodePostal()
    {
        Collections.sort(emprunteurs, new Comparator<Emprunteur>()
        {
            public int compare(Emprunteur e1, Emprunteur e2)
            {
                if (e1.getAdresse().getCp() > e2.getAdresse().getCp()) {
                    return 1;
                }
                else if (e1.getAdresse().getCp() < e2.getAdresse().getCp()) {
                    return -1;
                }
                return 0;
            }
        });
    }

    public static void triVille()
    {
        Collections.sort(emprunteurs, new Comparator<Emprunteur>()
        {
            public int compare(Emprunteur e1, Emprunteur e2)
            {
                return e1.getAdresse().getVille().compareTo(e2.getAdresse().getVille());
            }
        });
    }
}
