package location;

import java.util.ArrayList;

/**
 * Created by Adrien on 07/03/2016.
 */
public class Vehicule {
    protected String marque;
    protected static ArrayList<Exemplaire> exemplaire = new ArrayList<Exemplaire>();

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void ajoutExemplaire(Exemplaire e) {
        exemplaire.add(e);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicule vehicule = (Vehicule) o;

        if (!marque.equals(vehicule.marque)) return false;
        return exemplaire.equals(vehicule.exemplaire);

    }

    @Override
    public int hashCode() {
        int result = marque.hashCode();
        result = 31 * result + exemplaire.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "marque='" + marque + '\'' +
                ", exemplaire=" + exemplaire +
                '}';
    }
}
