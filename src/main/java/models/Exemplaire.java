package models;

import containers.Flotte;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Création et modification d'un exemplaire d'un véhicule
 * @author Adrien Poupa
 */
@Entity
@Table(name="exemplaire")
public class Exemplaire extends BaseModel{

    private int kilometres;

    @ManyToMany(mappedBy = "exemplaires")
    private ArrayList<Location> locations;

    @ManyToOne
    private Vehicule vehicule;

    private float reservoir;

    private boolean endommage;

    public static final int penaliteReservoir = 30;
    public static final int penaliteEndommage = 500;

    public Exemplaire(int kilometres, Location location, Vehicule vehicule) throws IllegalArgumentException {

        if (kilometres > 180000) {
            throw new IllegalArgumentException("Kilométrage maximum dépassé");
        }

        this.kilometres = kilometres;
        locations = new ArrayList<>();
        addLocation(location);
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
        locations = new ArrayList<>();

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

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void addLocation(Location location) {
        locations.add(location);
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

    /**
     * Retourne le prix final de la location par jour
     * 10% de réduction tous les 50 000 kms
     * @return prix final sans assurance
     */
    public double getPrixFinalHorsAssurance() {
        return vehicule.getPrixJour() - ((int) Math.ceil((double)kilometres / 50000) - 1)*0.1*vehicule.getPrixJour();
    }

    /**
     * Retourne le prix final de la location par jour
     * 10% de réduction tous les 50 000 kms
     * Ajout du prix de l'assurance si nécessaire
     * @return prix final
     */
    public double getPrixFinalAvantLocation() {
        double prixTemp = getPrixFinalHorsAssurance();

        if (locations != null /*&& location.isAssurance()*/) {
            prixTemp += vehicule.getPrixAssurance();
        }

        return prixTemp;
    }

    /**
     * Calcul du prix facturé lors du retour du véhicule
     * Application des pénalités sur le niveau de réservoir et l'état du véhicule
     * @return prix à payer
     */
    public double getPrixFinalRetour() {
        double prixTemp = getPrixFinalAvantLocation();

        // Si le réservoir n'est pas plein, pénalité
        if (reservoir != 1.0) {
            prixTemp += penaliteReservoir;
        }

        // Si la voiture est endommagée et qu'on n'a pas prix d'assurance
        if (isEndommage() /*&& !location.isAssurance()*/) {
            prixTemp += penaliteEndommage;
        }

        return prixTemp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exemplaire that = (Exemplaire) o;

        if (kilometres != that.kilometres) return false;
        if (Float.compare(that.reservoir, reservoir) != 0) return false;
        if (endommage != that.endommage) return false;
        if (!locations.equals(that.locations)) return false;
        return vehicule.equals(that.vehicule);

    }

    @Override
    public int hashCode() {
        int result = kilometres;
        result = 31 * result + locations.hashCode();
        result = 31 * result + vehicule.hashCode();
        result = 31 * result + (reservoir != +0.0f ? Float.floatToIntBits(reservoir) : 0);
        result = 31 * result + (endommage ? 1 : 0);
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
                ", prixFinal=" + getPrixFinalAvantLocation() +
                ", endommage=" + endommage +
                '}';
    }
}
