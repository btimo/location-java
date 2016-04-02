package location.containers;

import com.avaje.ebean.Model.*;
import location.models.Location;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Liste de toutes les locations
 * @author Adrien Poupa
 */
public class Locations {
    private static ArrayList<Location> locations = new ArrayList<Location>();
    public static final Find<Long, Location> find = new Find<Long, Location>(){};

    private static void fetchAll(){
        locations = new ArrayList<>(find.all());
    }

    /**
     * Ajout d'un véhicule
     * @param v véhicule à ajouter
     */
    public static void ajout(Location v) {
        locations.add(v);
    }

    /**
     * Liste des locations
     * @return liste des locations stockées
     */
    public static ArrayList<Location> get() {
        fetchAll();
        return locations;
    }

    /**
     * Tri par ID
     */
    public static void triID()
    {
        Collections.sort(locations, new Comparator<Location>()
        {
            public int compare(Location l1, Location l2)
            {
                return l1.getId().compareTo(l2.getId());
            }
        });
    }
}
