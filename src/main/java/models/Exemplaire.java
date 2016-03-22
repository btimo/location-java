package models;

import containers.Flotte;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Création et modification d'un exemplaire d'un véhicule
 * @author Adrien Poupa
 */
@Entity
@Table(name="exemplaire")
public class Exemplaire extends BaseModel{

    private int kilometres;

    @OneToMany(mappedBy = "exemplaire")
    private List<LocationExemplaire> locationExemplaires = new ArrayList<>();

    @ManyToOne
    private Vehicule vehicule;

    private float reservoir;

    private boolean endommage;

    public static final int penaliteReservoir = 30;
    public static final int penaliteEndommage = 500;

    public Exemplaire(int kilometres, List<LocationExemplaire> locationExemplaires, Vehicule vehicule) throws IllegalArgumentException {

        if (kilometres > 180000) {
            throw new IllegalArgumentException("Kilométrage maximum dépassé");
        }

        this.kilometres = kilometres;
        this.locationExemplaires = locationExemplaires;
        this.vehicule = vehicule;

        // Ajout du véhicule au container de Vehicule et de Flotte
        vehicule.ajoutExemplaire(this);
        Flotte.ajout(this);

        this.reservoir = 1;

        this.endommage = false;
    }

    public Exemplaire(int kilometres, Vehicule vehicule) throws IllegalArgumentException {

        if (kilometres > 180000) {
            throw new IllegalArgumentException("Kilométrage maximum dépassé");
        }

        this.kilometres = kilometres;
        this.vehicule = vehicule;

        // Ajout du véhicule au container de Vehicule et de Flotte
        vehicule.ajoutExemplaire(this);
        Flotte.ajout(this);

        this.reservoir = 1;

        this.endommage = false;
    }

    public int getKilometres() {
        return kilometres;
    }

    public void setKilometres(int kilometres) {
        this.kilometres = kilometres;
    }

    public List<LocationExemplaire> getLocationExemplaires() {
        return locationExemplaires;
    }

    public void setLocationExemplaires(List<LocationExemplaire> locationExemplaires) {
        this.locationExemplaires = locationExemplaires;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public boolean isEndommage() {
        return endommage;
    }

    public void setEndommage(boolean endommage) {
        this.endommage = endommage;
    }

    public String getReservoir() {
        if (reservoir == 0.0) {
            return "Vide";
        }
        else if (reservoir == 1.0) {
            return "Plein";
        }
        return Float.toString(reservoir);
    }

    public void setReservoir(float reservoir) {
        if (this.reservoir == 0 | this.reservoir == 0.25  || this.reservoir == 0.5 || this.reservoir == 0.75 || this.reservoir == 1) {
            this.reservoir = reservoir;
        }
        else {
            this.reservoir = 0;
        }
    }

    public float getPenaliteReservoir(){
        if(reservoir < 0.25){
            return penaliteReservoir * 4;
        }
        else if(reservoir < 0.5){
            return penaliteReservoir * 3;
        }
        else if(reservoir < 0.75){
            return penaliteReservoir * 2;
        }
        else if(reservoir < 1){
            return penaliteReservoir * 1;
        }
        else
            return 0;
    }

    /**
     * Retourne le prix final de la location de cet exemplaire par jour
     * 10% de réduction tous les 50 000 kms
     * @return prix final sans assurance
     */
    public double getPrixFinalHorsAssurance() {
        return vehicule.getPrixJour() - ((int) Math.ceil((double)kilometres / 50000) - 1)*0.1*vehicule.getPrixJour();
    }

    /**
     * Retourne le prix final de la location de cet exemplaire par jour
     * 10% de réduction tous les 50 000 kms
     * Ajout du prix de l'assurance
     * @return prix final avec assurance
     */
    public double getPrixFinalAvecAssurance() {
        return getPrixFinalHorsAssurance() + vehicule.getPrixAssurance();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exemplaire that = (Exemplaire) o;

        if (id != that.id) return false;
        if (kilometres != that.kilometres) return false;
        if (endommage != that.endommage) return false;
        if (Float.compare(that.reservoir, reservoir) != 0) return false;
        //if (location != null ? !location.equals(that.location) : that.location != null) return false;
        return vehicule.equals(that.vehicule);

    }

    @Override
    public int hashCode() {
        int result = id.intValue();
        result = 31 * result + kilometres;
        //result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + vehicule.hashCode();
        result = 31 * result + (endommage ? 1 : 0);
        result = 31 * result + (reservoir != +0.0f ? Float.floatToIntBits(reservoir) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Exemplaire{" +
                "id=" + id +
                ", kilometres=" + kilometres +
                //", location=" + location +
                ", vehicule=" + vehicule +
                ", reservoir=" + getReservoir() +
                ", prix sans assurance= " + getPrixFinalAvecAssurance() +
                ", prix avec assurance= " + getPrixFinalHorsAssurance() +
                ", endommage=" + endommage +
                '}';
    }
}
