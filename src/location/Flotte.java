package location;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

    public static void triId()
    {
        Collections.sort(exemplaires, new Comparator<Exemplaire>()
        {
            public int compare(Exemplaire e1, Exemplaire e2)
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

    public static void triKm()
    {
        Collections.sort(exemplaires, new Comparator<Exemplaire>()
        {
            public int compare(Exemplaire e1, Exemplaire e2)
            {
                if (e1.getKilometres() > e2.getKilometres()) {
                    return 1;
                }
                else if (e1.getKilometres() < e2.getKilometres()) {
                    return -1;
                }
                return 0;
            }
        });
    }
}
