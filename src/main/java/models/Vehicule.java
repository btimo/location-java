package models;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrien on 07/03/2016.
 */
@Entity
@Inheritance
public abstract class Vehicule extends BaseModel{

    protected String marque;

    @OneToMany(mappedBy = "vehicule")
    protected List<Exemplaire> exemplaires = new ArrayList<Exemplaire>();

    protected int prixJour;

    protected int prixAssurance;



    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void ajoutExemplaire(Exemplaire e) {
        exemplaires.add(e);
    }

    public int getPrixJour() {
        return prixJour;
    }

    public int getPrixAssurance() {
        return prixAssurance;
    }

    public List<Exemplaire> getExemplaires() {
        return exemplaires;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicule vehicule = (Vehicule) o;

        if (prixJour != vehicule.prixJour) return false;
        if (prixAssurance != vehicule.prixAssurance) return false;
        return marque.equals(vehicule.marque);

    }

    @Override
    public int hashCode() {
        int result = marque.hashCode();
        result = 31 * result + prixJour;
        result = 31 * result + prixAssurance;
        return result;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "marque='" + marque + '\'' +
                "exemplaire='" + exemplaires + '\'' +
                "prix de base='" + prixJour + '\'' +
                ", prix assurance=" + prixAssurance +
                '}';
    }
}
