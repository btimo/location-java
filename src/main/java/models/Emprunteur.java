package models;

import containers.Emprunteurs;
import util.GenerationPdf;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrien on 07/03/2016.
 */
@Entity
@Table(name="emprunteur")
public class Emprunteur extends BaseModel  {

    private String nom;

    private String prenom;

    @Embedded
    private Adresse adresse;

    @OneToMany(cascade= CascadeType.ALL , mappedBy = "emprunteur")
    private List<Location> locations;

    public Emprunteur(Adresse adresse, String prenom, String nom) {
        this.adresse = adresse;
        this.prenom = prenom;
        this.nom = nom;
        this.locations = new ArrayList<Location>();

        // Ajout de l'emprunteur
        Emprunteurs.ajout(this);
    }

    public Emprunteur(Adresse adresse, String prenom, String nom, ArrayList<Location> locations) {
        this.adresse = adresse;
        this.prenom = prenom;
        this.nom = nom;
        this.locations = locations;

        // Ajout de l'emprunteur
        Emprunteurs.ajout(this);
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void louer(Location l) {
        locations.add(l);
        l.setEmprunteur(this);
    }

    public void ramener() {
        this.locations = new ArrayList<Location>();
    }

    public void genererFacture(int locationId) {
        new GenerationPdf("facture", this, locationId);
    }

    public void genererDevis(int locationId) {
        new GenerationPdf("devis", this, locationId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Emprunteur that = (Emprunteur) o;

        if (id != that.id) return false;
        if (!nom.equals(that.nom)) return false;
        if (!prenom.equals(that.prenom)) return false;
        if (!locations.equals(that.locations)) return false;
        return adresse.equals(that.adresse);

    }

    @Override
    public int hashCode() {
        int result = getId().intValue();
        result = 31 * result + nom.hashCode();
        result = 31 * result + prenom.hashCode();
        result = 31 * result + adresse.hashCode();
        result = 31 * result + locations.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Emprunteur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", locations=" + locations +
                '}';
    }
}
