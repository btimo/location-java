package containers;

import models.Auto;
import models.Exemplaire;
import models.Moto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Liste de tous les véhicules
 */
public class Flotte {
    private static List<Exemplaire> exemplaires = new ArrayList<Exemplaire>();

    public static void ajout(Exemplaire e) {
        exemplaires.add(e);
    }

    public static List<Exemplaire> get() {
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
