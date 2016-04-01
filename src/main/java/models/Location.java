package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Gestion d'une location d'un ou plusieurs véhicules
 * @author Adrien Poupa
 * @author Timothée Barbot
 */
@Entity
@Table(name="location")
public class Location extends BaseModel {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "jour", column = @Column(name = "debut_jour")),
            @AttributeOverride(name = "mois", column = @Column(name = "debut_mois")),
            @AttributeOverride(name = "annee", column = @Column(name = "debut_annee"))
    })
    private Date debut;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "jour", column = @Column(name = "fin_jour")),
            @AttributeOverride(name = "mois", column = @Column(name = "fin_mois")),
            @AttributeOverride(name = "annee", column = @Column(name = "fin_annee"))
    })
    private Date fin;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "jour", column = @Column(name = "rendu_jour")),
            @AttributeOverride(name = "mois", column = @Column(name = "rendu_mois")),
            @AttributeOverride(name = "annee", column = @Column(name = "rendu_annee"))
    })
    private Date rendu;

    @ManyToOne
    private Emprunteur emprunteur;

    @OneToMany(mappedBy = "location")
    private List<LocationExemplaire> locationExemplaires = new ArrayList<>();

    /*
     * Etat de la location : false -> devis; true -> entre devis et facture;
     */
    private boolean approuvee; // Devis accepté ?


    /**
     * Constructeur complet
     * @param debut date de début de location
     * @param fin date de fin de location
     * @param approuvee location signée?
     */
    public Location(Date debut, Date fin, boolean approuvee) {
        this(debut, fin);
        this.approuvee = approuvee;
    }

    /**
     * Constructeur par défaut
     * @param debut date de début de location
     * @param fin date de fin de location
     */
    public Location(Date debut, Date fin){
        this.debut = debut;
        this.fin = fin;
    }

    /**
     * Récupération de la date du début de la location
     * @return date de début de la location
     */
    public Date getDebut() {
        return debut;
    }

    /**
     * Changement de la date de début de la location
     * @param debut date de début de la location
     */
    public void setDebut(Date debut) {
        this.debut = debut;
    }

    /**
     * Récupération de la date de fin de la location
     * @return date de fin de la location
     */
    public Date getFin() {
        return fin;
    }

    /**
     * Changement de la date de fin de la location
     * @param fin date de fin de la location
     */
    public void setFin(Date fin) {
        this.fin = fin;
    }

    /**
     * Récupération de la date de rendu de la location
     * @return date de rendu de la location
     */
    public Date getRendu() {
        return rendu;
    }

    /**
     * Changement de la date de rendu de la location
     * @param rendu date de rendu de la location
     */
    public void setRendu(Date rendu) {
        this.rendu = rendu;
    }

    /**
     * Récupération de l'emprunteur de la location
     * @return emprunteur de la location
     */
    public Emprunteur getEmprunteur() {
        return emprunteur;
    }

    /**
     * Mise à jour de l'emprunteur de la location
     * @param emprunteur emprunteur de la location
     */
    public void setEmprunteur(Emprunteur emprunteur) {
        this.emprunteur = emprunteur;
    }

    /**
     * Récupération de la liste d'exemplaires de la location
     * @return liste d'exemplaires de la location
     */
    public List<LocationExemplaire> getLocationExemplaires() {
        return locationExemplaires;
    }

    /**
     * Mise à jour de la liste d'exemplaires de la location
     * @param locationExemplaires liste d'exemplaires de la location
     */
    public void setLocationExemplaires(List<LocationExemplaire> locationExemplaires) {
        this.locationExemplaires = locationExemplaires;
    }

    /**
     * Ajout à la liste d'exemplaires de la location
     * @param locationExemplaire exemplaire de location
     */
    public void addLocationExemplaire(LocationExemplaire locationExemplaire){
        this.locationExemplaires.add(locationExemplaire);
    }

    /**
     * Indique si la location est signée
     * @return location signée?
     */
    public boolean isApprouvee() {
        return approuvee;
    }

    /**
     * Mise à jour de la signature de la location
     * @param approuvee signature
     */
    public void setApprouvee(boolean approuvee) {
        this.approuvee = approuvee;
    }

    /**
     * Ajout d'un exemplaire à louer dans la location actuelle
     * @param exemplaire exemplaire à louer
     * @param assurance assurance?
     */
    public void louer(Exemplaire exemplaire, boolean assurance){
        LocationExemplaire le = new LocationExemplaire(this, exemplaire, assurance);
        locationExemplaires.add(le);
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
        Location location = (Location) o;
        return isApprouvee() == location.isApprouvee() &&
                Objects.equals(getDebut(), location.getDebut()) &&
                Objects.equals(getFin(), location.getFin()) &&
                Objects.equals(getRendu(), location.getRendu()) &&
                Objects.equals(getEmprunteur(), location.getEmprunteur()) &&
                Objects.equals(getLocationExemplaires(), location.getLocationExemplaires());
    }

    /**
     * Surcharge de hashcode
     * @return int hash unique
     */
    @Override
    public int hashCode() {
        return Objects.hash(getDebut(), getFin(), getRendu(), getEmprunteur(), getLocationExemplaires(), isApprouvee());
    }

    /**
     * Surcharge de toString
     * @return chaîne retournant les caractéristiques de la location
     */
    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", debut=" + debut +
                ", fin=" + fin +
                ", rendu=" + rendu +
                ", approuvee=" + approuvee +
                '}';
    }
}
