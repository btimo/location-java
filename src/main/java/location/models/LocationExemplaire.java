package location.models;

import javax.persistence.*;

/**
 * Gestion de la liste des locations d'un exemplaire
 * @author Timothée Barbot
 */
@Entity
public class LocationExemplaire extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "exemplaireId")
    private Exemplaire exemplaire;

    @ManyToOne
    @JoinColumn(name = "locationId")
    private Location location;

    private boolean assurance;

    /**
     * Constructeur sans argument, JavaBean compliant
     */
    public LocationExemplaire(){}

    /**
     * Constructeur utilisé pour l'initialisation d'une LocationExemplaire
     * @param l location
     * @param e exemplaire
     * @param a assurance
     */
    public LocationExemplaire(Location l, Exemplaire e, Boolean a){
        exemplaire = e;
        location = l;
        assurance = a;
    }

    /**
     * Getter de l'exemplaire
     * @return exemplaire de la LocationExemplaire
     */
    public Exemplaire getExemplaire() {
        return exemplaire;
    }

    /**
     * Setter de l'exemplaire
     * @param exemplaire exemplaire de la LocationExemplaire
     */
    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }

    /**
     * Setter de la location
     * @return location de l'exemplaire
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Getter de la location
     * @param location location de l'exemplaire
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Boolean de l'assurance attachée à la LocationExemplaire
     * @return true/false suivant si l'assurance a été prise
     */
    public boolean isAssurance() {
        return assurance;
    }

    /**
     * Setter de l'assurance attachée à la LocationExemplaire
     * @param assurance true/false suivant si l'assurance a été prise
     */
    public void setAssurance(boolean assurance) {
        this.assurance = assurance;
    }

    /**
     * Calcul du prix facturé lors du retour du véhicule
     * location.Application des pénalités sur le niveau de réservoir et l'état du véhicule
     * @return prix à payer
     */
    public double getPrixFinalRetour() {
        // todo: refaire pour prendre en compte assurance
        double prixTemp = exemplaire.getPrixFinalAvecAssurance();

        // Si le réservoir n'est pas plein, pénalité
        prixTemp += exemplaire.getPenaliteReservoir();

        // Si la voiture est endommagée et qu'on n'a pas prix d'assurance
        if(exemplaire.isEndommage())
            prixTemp += assurance ? 0: Exemplaire.penaliteEndommage;

        return prixTemp;
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

        LocationExemplaire that = (LocationExemplaire) o;

        if (assurance != that.assurance) return false;
        if (exemplaire != null ? !exemplaire.equals(that.exemplaire) : that.exemplaire != null) return false;
        return location != null ? location.equals(that.location) : that.location == null;

    }

    /**
     * Surcharge de hashcode
     * @return int hash unique
     */
    @Override
    public int hashCode() {
        int result = exemplaire != null ? exemplaire.hashCode() : 0;
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (assurance ? 1 : 0);
        return result;
    }

    /**
     * Surcharge de toString
     * @return chaîne retournant les caractéristiques de la location
     */
    @Override
    public String toString() {
        return "LocationExemplaire{" +
                "exemplaire=" + exemplaire +
                ", location=" + location +
                ", assurance=" + assurance +
                '}';
    }
}
