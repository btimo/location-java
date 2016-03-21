package models;

import containers.Vehicules;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Adrien on 07/03/2016.
 */
@Entity
@Table(name = "moto")
public class Moto extends Vehicule {

    private int cylindree;

    public Moto(String marque, int cylindree, int prixJour) {
        this.cylindree = cylindree;
        this.marque = marque;
        this.prixJour = prixJour;

        // Ajout du véhicule actuel
        Vehicules.ajout(this);
    }

    public int getCylindree() {
        return cylindree;
    }

    public void setCylindree(int cylindree) {
        this.cylindree = cylindree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Moto moto = (Moto) o;

        return cylindree == moto.cylindree;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + cylindree;
        return result;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "marque='" + getMarque() + ", " + '\'' +
                "prix de base=" + prixJour + ", " +
                "cylindree=" + cylindree +
                '}';
    }
}
