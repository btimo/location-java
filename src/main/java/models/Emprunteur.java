package models;

import containers.Emprunteurs;
import util.GenerationPdf;

import javax.persistence.*;
import java.util.ArrayList;

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

    /*
    @ManyToMany
    private Exemplaire exemplaire;
    */

    @OneToMany(mappedBy = "emprunteur")
    private ArrayList<Location> locations;

    public Emprunteur(Adresse adresse, String prenom, String nom) {
        this.adresse = adresse;
        this.prenom = prenom;
        this.nom = nom;

        // Ajout de l'emprunteur
        Emprunteurs.ajout(this);
    }

    /*
    public Emprunteur(Adresse adresse, String prenom, String nom, Exemplaire exemplaire) {
        this.adresse = adresse;
        this.prenom = prenom;
        this.nom = nom;
        this.exemplaire = exemplaire;

        // Ajout de l'emprunteur
        Emprunteurs.ajout(this);
    }
    */

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

    /*public Exemplaire getExemplaire() {
        return exemplaire;
    }

    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }

    public void louer(Exemplaire e) {
        this.exemplaire = e;
    }

    public void ramener() {
        // L'exemplaire n'a plus de location
        exemplaire.setLocation(null);

        // L'emprunteur n'a plus de véhicule
        this.exemplaire = null;
    }
    */

    public void genererFacture() {
        new GenerationPdf("facture", this);
    }

    public void genererDevis() {
        new GenerationPdf("devis", this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Emprunteur that = (Emprunteur) o;

        if (id != that.id) return false;
        if (!nom.equals(that.nom)) return false;
        if (!prenom.equals(that.prenom)) return false;
        //if (!exemplaire.equals(that.exemplaire)) return false;
        return adresse.equals(that.adresse);

    }

    @Override
    public int hashCode() {
        int result = getId().intValue();
        result = 31 * result + nom.hashCode();
        result = 31 * result + prenom.hashCode();
        result = 31 * result + adresse.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Emprunteur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                //", exemplaire=" + exemplaire +
                '}';
    }
}
