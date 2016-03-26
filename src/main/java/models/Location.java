package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Adrien on 07/03/2016.
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


    public Location(Date debut, Date fin, boolean approuvee) {
        this(debut, fin);
        this.approuvee = approuvee;
    }

    public Location(Date debut, Date fin){
        this.debut = debut;
        this.fin = fin;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public Date getRendu() {
        return rendu;
    }

    public void setRendu(Date rendu) {
        this.rendu = rendu;
    }

    public Emprunteur getEmprunteur() {
        return emprunteur;
    }

    public void setEmprunteur(Emprunteur emprunteur) {
        this.emprunteur = emprunteur;
    }

    public List<LocationExemplaire> getLocationExemplaires() {
        return locationExemplaires;
    }

    public void setLocationExemplaires(List<LocationExemplaire> locationExemplaires) {
        this.locationExemplaires = locationExemplaires;
    }

    public void addLocationExemplaire(LocationExemplaire locationExemplaire){
        this.locationExemplaires.add(locationExemplaire);
    }

    public boolean isApprouvee() {
        return approuvee;
    }

    public void setApprouvee(boolean approuvee) {
        this.approuvee = approuvee;
    }

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
