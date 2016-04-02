package location.containers;

import com.avaje.ebean.Model.Find;
import location.models.Auto;
import location.models.Vehicule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Liste de tous les véhicules
 * @author Adrien Poupa
 */
public class Vehicules {
    private static ArrayList<Vehicule> vehicules = new ArrayList<Vehicule>();
    private static final Find<Long, Vehicule> find = new Find<Long, Vehicule>(){};

    /**
     * Récupération de tous les véhicules
     */
    private static void fetchAll(){
        vehicules = new ArrayList<>(find.all());
    }

    /**
     * Ajout d'un véhicule
     * @param v véhicule à ajouter
     */
    public synchronized static void ajout(Vehicule v) {
        vehicules.add(v);
    }

    /**
     * Liste des véhicules
     * @return liste des véhicules actuellement stockés
     */
    public synchronized static ArrayList<Vehicule> get() {
        fetchAll();
        return vehicules;
    }

    /**
     * Tri par marque
     */
    public synchronized static void triMarque()
    {
        Collections.sort(vehicules, new Comparator<Vehicule>()
        {
            public synchronized int compare(Vehicule v1, Vehicule v2)
            {
                return v1.getMarque().compareTo(v2.getMarque());
            }
        });
    }

    /**
     * Recherche par marque
     * @param marque marque à rechercher
     * @return liste de véhicules correspondant à la marque
     */
    public synchronized static ArrayList<Vehicule> rechercheMarque(String marque)
    {
        ArrayList<Vehicule> vehiculesSearch = new ArrayList<Vehicule>();

        for(Vehicule v : vehicules) {
            if(v.getMarque() != null && v.getMarque().contains(marque)) {
                vehiculesSearch.add(v);
            }
        }

        return vehiculesSearch;
    }

    /**
     * Recherche par modèle
     * @param modele modèle à rechercher
     * @return liste des véhicules du modèle donné
     */
    public synchronized static ArrayList<Vehicule> triModele(String modele)
    {
        ArrayList<Vehicule> vehiculesSearch = new ArrayList<Vehicule>();

        for(Vehicule e : vehicules) {
            if (e instanceof Auto && (((Auto) e).getModele()).equals(modele)) {
                vehiculesSearch.add(e);
            }
        }

        return vehiculesSearch;
    }
}
