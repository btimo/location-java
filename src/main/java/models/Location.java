package main.java.models;

/**
 * Created by Adrien on 07/03/2016.
 */
public class Location {
    private static int numero = 1; // Variable partagée par toutes les instances de Location
    private int id;
    private Date debut;
    private Date fin;
    private boolean assurance;

    public Location(Date fin, Date debut, boolean assurance) {
        id = numero;
        numero++;
        this.fin = fin;
        this.debut = debut;
        this.assurance = assurance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (id != location.id) return false;
        if (assurance != location.assurance) return false;
        if (!debut.equals(location.debut)) return false;
        return fin.equals(location.fin);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + debut.hashCode();
        result = 31 * result + fin.hashCode();
        result = 31 * result + (assurance ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", debut=" + debut +
                ", fin=" + fin +
                ", assurance=" + assurance +
                '}';
    }
}
