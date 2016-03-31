package models;

import containers.Emprunteurs;
import util.GenerationPdf;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Modélisation d'un emprunteur
 * @author Adrien Poupa
 * @author Timothée Barbot
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

    /**
     * Constructeur de base d'un emprunteur
     * @param adresse adresse de l'emprunteur
     * @param prenom prénom de l'emprunteur
     * @param nom nom du l'emprunteur
     */
    public Emprunteur(Adresse adresse, String prenom, String nom) {
        this.adresse = adresse;
        this.prenom = prenom;
        this.nom = nom;
        this.locations = new ArrayList<Location>();
    }

    /**
     * Constructeur de base d'un emprunteur avec ArrayList de locations
     * @param adresse adresse de l'emprunteur
     * @param prenom prénom de l'emprunteur
     * @param nom nom du l'emprunteur
     * @param locations ArrayList des locations effectuées par l'emprunteur
     */
    public Emprunteur(Adresse adresse, String prenom, String nom, ArrayList<Location> locations) {
        this(adresse, prenom, nom);
        this.locations = locations;
    }

    /**
     * Getter des locations effectuées par l'emprunteur
     * @return locations effectuées par l'emprunteur
     */
    public List<Location> getLocations() {
        return locations;
    }

    /**
     * Setter des locations effectuées par l'emprunteur
     * @param locations effectuées par l'emprunteur
     */
    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    /**
     * Getter du nom
     * @return nom de l'emprunteur
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter du nom
     * @param nom de l'emprunteur
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter du prénom
     * @return prénom de l'emprunteur
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Setter du prénom
     * @param prenom prénom de l'emprunteur
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Getter de l'adresse
     * @return adresse de l'emprunteur
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * Setter de l'adresse
     * @param adresse adresse de l'emprunteur
     */
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    /**
     * Ajout d'une location à un emprunteur
     * Ajout de la location à la liste de l'instance et mise à jour de l'emprunteur dans la location passée
     * @param l location à ajouter
     */
    public void louer(Location l) {
        locations.add(l);
        l.setEmprunteur(this);
    }

    /**
     * On ramène la (les) voiture(s) louée(s) : la liste doit être vidée
     */
    public void ramener() {
        this.locations = new ArrayList<Location>();
    }

    /**
     * Génération de la facture
     * @param locationId ID de la location à générer
     */
    public void genererFacture(int locationId) {
        new GenerationPdf("facture", this, locationId).generateDocument();
    }

    /**
     * Génération de la facture
     * @param locationId ID de la location à générer
     */
    public void genererFacture(int locationId, boolean test) {
        new GenerationPdf("facture", this, locationId, test).generateDocument();
    }

    /**
     * Génération du devis
     * @param locationId ID du devis à générer
     */
    public void genererDevis(int locationId) {
        new GenerationPdf("devis", this, locationId).generateDocument();
    }

    /**
     * Génération du devis
     * @param locationId ID du devis à générer
     * @param test fichier de test
     */
    public void genererDevis(int locationId, boolean test) {
        new GenerationPdf("devis", this, locationId, test).generateDocument();
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

        Emprunteur that = (Emprunteur) o;

        if (id != that.id) return false;
        if (!nom.equals(that.nom)) return false;
        if (!prenom.equals(that.prenom)) return false;
        if (!locations.equals(that.locations)) return false;
        return adresse.equals(that.adresse);

    }

    /**
     * Surcharge de hashcode
     * @return int hash unique
     */
    @Override
    public int hashCode() {
        int result = getId().intValue();
        result = 31 * result + nom.hashCode();
        result = 31 * result + prenom.hashCode();
        result = 31 * result + adresse.hashCode();
        result = 31 * result + locations.hashCode();
        return result;
    }

    /**
     * Surcharge de toString
     * @return chaîne retournant les caractéristiques de l'emprunteur
     */
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
