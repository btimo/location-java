package containers;

import models.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Liste de tous les emprunteurs et recherches variées
 * @author Adrien Poupa
 */
public class Emprunteurs {
    private static ArrayList<Emprunteur> emprunteurs = new ArrayList<Emprunteur>();

    /**
     * Ajout d'un emprunteur
     * @param e emprunteur à ajouter
     */
    public static void ajout(Emprunteur e) {
        emprunteurs.add(e);
    }

    /**
     * Liste des emprunteurs
     * @return liste des emprunteurs
     */
    public static ArrayList<Emprunteur> get() {
        return emprunteurs;
    }

    /**
     * Tri par ID
     */
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

    /**
     * Tri par nom
     */
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

    /**
     * Recherche par nom
     * @param name nom de l'empruteur à rechercher
     * @return liste des emprunteurs correspondants à ka recherche
     */
    public static ArrayList<Emprunteur> rechercheNom(String name)
    {
        ArrayList<Emprunteur> emprunteursSearch = new ArrayList<Emprunteur>();

        for(Emprunteur e : emprunteurs) {
            if(e.getNom() != null && e.getNom().equals(name)) {
                emprunteursSearch.add(e);
            }
        }

        return emprunteursSearch;
    }

    /**
     * Recherche des empruteurs d'un véhicule en particulier
     * @param vehicule véhicule à rechercher
     * @return liste des emprunteurs du véhicule
     */
    public static ArrayList<Emprunteur> rechercheVehicule(Vehicule vehicule)
    {
        ArrayList<Emprunteur> emprunteursSearch = new ArrayList<Emprunteur>();

        for (Exemplaire e : vehicule.getExemplaires()) {
            for (LocationExemplaire le : e.getLocationExemplaires()) {
                emprunteursSearch.add(le.getLocation().getEmprunteur());
            }
        }

        return emprunteursSearch;
    }

    /**
     * Recherche des empruteurs ayant une location en cours
     * @return liste d'emprunteurs ayant une location en cours
     */
    public static ArrayList<Emprunteur> locationEnCours()
    {
        ArrayList<Emprunteur> emprunteursSearch = new ArrayList<Emprunteur>();

        for (Exemplaire e : Flotte.get()) {
            for (LocationExemplaire le : e.getLocationExemplaires()) {
                if (le.getLocation().isApprouvee()) {
                    emprunteursSearch.add(le.getLocation().getEmprunteur());
                }
            }
        }

        return emprunteursSearch;
    }

    /**
     * Recherche d'emprunteurs ayant réalisé une location entre deux montants
     * @param montant1 montant minimal
     * @param montant2 montant maximal
     * @return liste d'emprunteurs ayant réalisé une location entre deux montants
     */
    public static ArrayList<Emprunteur> rechercheMontant(int montant1, int montant2)
    {
        ArrayList<Emprunteur> emprunteursSearch = new ArrayList<Emprunteur>();

        for (Exemplaire e : Flotte.get()) {
            for (LocationExemplaire le : e.getLocationExemplaires()) {
                if (le.getPrixFinalRetour() >= montant1 && le.getPrixFinalRetour() <= montant2) {
                    emprunteursSearch.add(le.getLocation().getEmprunteur());
                }
            }
        }

        return emprunteursSearch;
    }

    /**
     * Recherche d'emprunteurs ayant une location avec une date de début
     * @param d date de début d
     * @return liste d'emprunteurs ayant une location avec une date de début
     */
    public ArrayList<Emprunteur> locationDateDebut(Date d)
    {
        ArrayList<Emprunteur> emprunteursSearch = new ArrayList<Emprunteur>();

        for (Exemplaire e : Flotte.get()) {
            for (LocationExemplaire le : e.getLocationExemplaires()) {
                if (le.getLocation().isApprouvee() && le.getLocation().getDebut().equals(d)) {
                    emprunteursSearch.add(le.getLocation().getEmprunteur());
                }
            }
        }

        return emprunteursSearch;
    }

    /**
     * Tri des emprunteurs par leur prénom
     */
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

    /**
     * Tri des emprunteurs par code postal
     */
    public static void triCodePostal()
    {
        Collections.sort(emprunteurs, new Comparator<Emprunteur>()
        {
            public int compare(Emprunteur e1, Emprunteur e2)
            {
                return e1.getAdresse().getCp().compareTo(e2.getAdresse().getCp());
            }
        });
    }

    /**
     * Tri des emprunteurs par la ville
     */
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
