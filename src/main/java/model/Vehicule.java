package main.java.model;

import java.util.ArrayList;

/**
 * Created by Adrien on 07/03/2016.
 */
public abstract class Vehicule {
    protected String marque;
    protected static ArrayList<Exemplaire> exemplaire = new ArrayList<Exemplaire>();
    protected int prixJour;

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void ajoutExemplaire(Exemplaire e) {
        exemplaire.add(e);
    }

    public int getPrixJour() {
        return prixJour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicule vehicule = (Vehicule) o;

        if (prixJour != vehicule.prixJour) return false;
        return marque.equals(vehicule.marque);

    }

    @Override
    public int hashCode() {
        int result = marque.hashCode();
        result = 31 * result + prixJour;
        return result;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "marque='" + marque + '\'' +
                "exemplaire='" + exemplaire + '\'' +
                ", prix de base=" + prixJour +
                '}';
    }
}
