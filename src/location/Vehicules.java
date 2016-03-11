package location;

import java.util.ArrayList;

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
}
