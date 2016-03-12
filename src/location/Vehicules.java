package location;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Adrien on 07/03/2016.
 */
public class Vehicules {
    private static ArrayList<Vehicule> vehicules = new ArrayList<Vehicule>();

    public static void ajout(Vehicule v) {
        vehicules.add(v);
    }

    public static ArrayList<Vehicule> get() {
        return vehicules;
    }

    public static void triMarque()
    {
        Collections.sort(vehicules, new Comparator<Vehicule>()
        {
            public int compare(Vehicule v1, Vehicule v2)
            {
                return v1.getMarque().compareTo(v2.getMarque());
            }
        });
    }

    public static void triModele()
    {
        // TODO: extract Auto from Vehicule? Limit sort to Autos....
    }
}
