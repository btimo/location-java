package main.java.models;

/**
 * Created by Adrien on 07/03/2016.
 */
public class Location {
    private static int numero = 1; // Variable partagée par toutes les instances de Exemplaire
    private int id;
    private Date debut;
    private Date fin;

    public Location(Date fin, Date debut) {
        id = numero;
        numero++;
        this.fin = fin;
        this.debut = debut;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (id != location.id) return false;
        if (!debut.equals(location.debut)) return false;
        return fin.equals(location.fin);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + debut.hashCode();
        result = 31 * result + fin.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", debut=" + debut +
                ", fin=" + fin +
                '}';
    }
}
