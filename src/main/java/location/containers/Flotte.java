package location.containers;

import com.avaje.ebean.Model.Find;
import location.models.Auto;
import location.models.Exemplaire;
import location.models.Moto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Liste de tous les exemplaires de véhicules et recherches variées
 * @author Adrien Poupa
 */
public class Flotte {
    private static List<Exemplaire> exemplaires = new ArrayList<Exemplaire>();
    public static final Find<Long,Exemplaire> find = new Find<Long, Exemplaire>(){};

    private static void fetchAll(){
        exemplaires = new ArrayList<>(find.all());
    }

    /**
     * Ajout d'un exemplaire à la flotte
     * @param e exemplaire à rajouter
     */
    public static void ajout(Exemplaire e) {
        exemplaires.add(e);
    }

    /**
     * Retour de tous les exemplaires actuellement stockés
     * @return liste des exemplaires
     */
    public static List<Exemplaire> get() {
        fetchAll();
        return exemplaires;
    }

    /**
     * Tri des exemplaires par ID
     */
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

    /**
     * Tri des exemplaires par kilométrage
     */
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

    /**
     * Recherche des exemplaires en fonction d'un kilométrage précis
     * @param operator opérande sélectionné : <, > ou = par défaut
     * @param km kilométrage recherché
     * @return liste d'exemplaires
     */
    public static ArrayList<Exemplaire> rechercheKm(String operator, int km)
    {
        ArrayList<Exemplaire> vehiculesSearch = new ArrayList<Exemplaire>();

        for(Exemplaire e : exemplaires) {
            if (operator.equals(">") && e.getKilometres() > km) {
                vehiculesSearch.add(e);
            }
            else if (operator.equals("<") && e.getKilometres() < km) {
                vehiculesSearch.add(e);
            }
            else if (e.getKilometres() == km) {
                vehiculesSearch.add(e);
            }
        }

        return vehiculesSearch;
    }

    /**
     * Recherche des exemplaires entre deux kilométrages précis
     * @param km1 kilométrage 1
     * @param km2 kilométrage 2
     * @return liste d'exemplaires
     */
    public static ArrayList<Exemplaire> rechercheKm(int km1, int km2)
    {
        ArrayList<Exemplaire> vehiculesSearch = new ArrayList<Exemplaire>();

        for(Exemplaire e : exemplaires) {
            if (e.getKilometres() >= km1 && e.getKilometres() <= km2) {
                vehiculesSearch.add(e);
            }
        }

        return vehiculesSearch;
    }

    /**
     * Liste des exemplaires de motos
     * @return liste des exemplaires de motos
     */
    public static ArrayList<Exemplaire> listeMoto()
    {
        ArrayList<Exemplaire> motos = new ArrayList<Exemplaire>();

        for (Exemplaire e : exemplaires) {
            if (e.getVehicule() instanceof Moto) {
                motos.add(e);
            }
        }

        return motos;
    }

    /**
     * Liste des voitures standards
     * @return liste des voitures standards
     */
    public static ArrayList<Exemplaire> listeVoitureStandard()
    {
        ArrayList<Exemplaire> autos = new ArrayList<Exemplaire>();

        for (Exemplaire e : exemplaires) {
            if (e.getVehicule() instanceof Auto && !((Auto) e.getVehicule()).isLuxe()) {
                autos.add(e);
            }
        }

        return autos;
    }

    /**
     * Liste des voitures de luxe
     * @return liste des voitures de luxe
     */
    public static ArrayList<Exemplaire> listeVoitureLuxe()
    {
        ArrayList<Exemplaire> autos = new ArrayList<Exemplaire>();

        for (Exemplaire e : exemplaires) {
            if (e.getVehicule() instanceof Auto && ((Auto) e.getVehicule()).isLuxe()) {
                autos.add(e);
            }
        }

        return autos;
    }
}
