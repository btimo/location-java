package models;

import containers.Flotte;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Création et modification d'un exemplaire d'un véhicule
 * @author Adrien Poupa
 * @author Timothée Barbot
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

    /**
     * Constructeur complet d'un exemplaire
     * @param kilometres kilométrage de l'exemplaire
     * @param locationExemplaires liste de locations
     * @param vehicule type du véhicule
     * @throws IllegalArgumentException si dépassement des 180 000km au compteur
     */
    public Exemplaire(int kilometres, Vehicule vehicule, List<LocationExemplaire> locationExemplaires)
            throws IllegalArgumentException {

        this(kilometres, vehicule);

        this.locationExemplaires = locationExemplaires;
    }

    /**
     * Constructeur par défaut d'un exemplaire
     * @param kilometres kilométrage de l'exemplaire
     * @param vehicule type du véhicule
     * @throws IllegalArgumentException si dépassement des 180 000km au compteur
     */
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

    /**
     * Getter du nombre de kilomètres
     * @return nombre de kilomètres parcourus par l'exemplaire
     */
    public int getKilometres() {
        return kilometres;
    }

    /**
     * Setter du nombre de kilomètres
     * @param kilometres nombre de kilomètres parcourus par l'exemplaire
     */
    public void setKilometres(int kilometres) {
        this.kilometres = kilometres;
    }

    /**
     * Getter de la liste de locations du véhicules
     * @return liste de locations du véhicules
     */
    public List<LocationExemplaire> getLocationExemplaires() {
        return locationExemplaires;
    }

    /**
     * Setter de la liste de locations du véhicules
     * @param locationExemplaires liste de locations du véhicules
     */
    public void setLocationExemplaires(List<LocationExemplaire> locationExemplaires) {
        this.locationExemplaires = locationExemplaires;
    }

    /**
     * Getter du véhicule attaché à l'exemplaire
     * @return véhicule attaché à l'exemplaire
     */
    public Vehicule getVehicule() {
        return vehicule;
    }

    /**
     * Setter du véhicule attaché à l'exemplaire
     * @param vehicule véhicule attaché à l'exemplaire
     */
    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    /**
     * Getter du boolean indiquant l'état du véhicule
     * @return véhicule endommagé ou non
     */
    public boolean isEndommage() {
        return endommage;
    }

    /**
     * Setter du boolean indiquant l'état du véhicule
     * @param endommage véhicule endommagé ou non
     */
    public void setEndommage(boolean endommage) {
        this.endommage = endommage;
    }

    /**
     * Getter 'intelligent' du réservoir
     * @return string Vide/Plein ou niveau actuel (1/2, 1/4, 3/4)
     */
    public String getReservoir() {
        if (reservoir == 0.0) {
            return "Vide";
        }
        else if (reservoir == 1.0) {
            return "Plein";
        }
        return Float.toString(reservoir);
    }

    /**
     * Setter 'intelligent' du réservoir
     * @param reservoir string Vide/Plein ou niveau actuel (1/2, 1/4, 3/4)
     */
    public void setReservoir(float reservoir) {
        if (this.reservoir == 0 | this.reservoir == 0.25  || this.reservoir == 0.5 || this.reservoir == 0.75 || this.reservoir == 1) {
            this.reservoir = reservoir;
        }
        else {
            this.reservoir = 0;
        }
    }

    /**
     * Getter de la pénalité appliquée en cas de rendu du véhicule sans plein
     * Le montant de celle-ci diffère selon le niveau de remplissage du réservoir
     * @return flottant montant à payer
     */
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
            return penaliteReservoir;
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

    /**
     * Surcharge de equals
     * @param o objet à comparer
     * @return true/false selon égalité
     */
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

    /**
     * Surcharge de hashcode
     * @return int hash unique
     */
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

    /**
     * Surcharge de toString
     * @return chaîne retournant les caractéristiques de l'exemplaire
     */
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
