package models;

import javax.persistence.*;
import java.util.ArrayList;

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

    //@ManyToOne
    // Commenté sinon arrêt du code
    private Emprunteur emprunteur;

    //@ManyToMany
    // Commenté sinon arrêt du code
    //@JoinTable(name="exemplaire_location")
    private ArrayList<Exemplaire> exemplaires;

    private boolean assurance;

    private boolean approuvee; // Devis accepté ?

    public Location(Date debut, Date fin, boolean assurance, boolean approuvee) {
        this.fin = fin;
        this.debut = debut;
        this.assurance = assurance;
        this.approuvee = approuvee;
        this.exemplaires = new ArrayList<Exemplaire>();
    }

    public Location(Date debut, Date fin, boolean assurance, boolean approuvee, ArrayList<Exemplaire> exemplaires) {
        this.fin = fin;
        this.debut = debut;
        this.assurance = assurance;
        this.approuvee = approuvee;
        this.exemplaires = exemplaires;
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

    public boolean isAssurance() {
        return assurance;
    }

    public void setAssurance(boolean assurance) {
        this.assurance = assurance;
    }

    public boolean isApprouvee() {
        return approuvee;
    }

    public void setApprouvee(boolean approuvee) {
        this.approuvee = approuvee;
    }

    public Emprunteur getEmprunteur() {
        return emprunteur;
    }

    public void setEmprunteur(Emprunteur emprunteur) {
        this.emprunteur = emprunteur;
    }

    public ArrayList<Exemplaire> getExemplaires() {
        return exemplaires;
    }

    public void setExemplaires(ArrayList<Exemplaire> exemplaires) {
        this.exemplaires = exemplaires;
    }

    public void louer(Exemplaire e) {
        exemplaires.add(e);
    }

    public Date getRendu() {
        return rendu;
    }

    public void setRendu(Date rendu) {
        this.rendu = rendu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (id != location.id) return false;
        if (assurance != location.assurance) return false;
        if (approuvee != location.approuvee) return false;
        if (!debut.equals(location.debut)) return false;
        return fin.equals(location.fin);

    }

    @Override
    public int hashCode() {
        int result = debut.hashCode();
        result = 31 * result + fin.hashCode();
        result = 31 * result + (assurance ? 1 : 0);
        result = 31 * result + (approuvee ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", debut=" + debut +
                ", fin=" + fin +
                ", assurance=" + assurance +
                ", approuvee=" + approuvee +
                '}';
    }
}
