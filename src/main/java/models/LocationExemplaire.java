package models;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;

/**
 * Created by Timote on 22/03/2016.
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

    public LocationExemplaire(){}

    public LocationExemplaire(Location l, Exemplaire e, Boolean a){
        exemplaire = e;
        location = l;
        assurance = a;
    }

    public Exemplaire getExemplaire() {
        return exemplaire;
    }

    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isAssurance() {
        return assurance;
    }

    public void setAssurance(boolean assurance) {
        this.assurance = assurance;
    }

    /**
     * Calcul du prix facturé lors du retour du véhicule
     * Application des pénalités sur le niveau de réservoir et l'état du véhicule
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

}
