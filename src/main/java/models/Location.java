package models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Adrien on 07/03/2016.
 */
@Entity
@Table(name="location")
public class Location extends BaseModel {

    @Embedded
    private Date debut;

    @Embedded
    private Date fin;

    @Embedded
    private Date rendu;

    @ManyToOne
    private Emprunteur emprunteur;

    @ManyToMany
    @JoinTable(name="exemplaire_location")
    private List<Exemplaire> exemplaires;

    private boolean assurance;

    private boolean approuvee; // Devis accepté ?

    public Location(Date debut, Date fin, boolean assurance, boolean approuvee) {
        this.fin = fin;
        this.debut = debut;
        this.assurance = assurance;
        this.approuvee = approuvee;
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
