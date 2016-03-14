package main.java.models;

/**
 * Création et modification d'un exemplaire d'un véhicule
 * @author Adrien Poupa
 */
public class Exemplaire {
    private static int numero = 1; // Variable partagée par toutes les instances de Exemplaire
    private int id;
    private int kilometres;
    private Location location;
    private Vehicule vehicule;
    private boolean loue;

    public Exemplaire(int kilometres, Location location, Vehicule vehicule) throws IllegalArgumentException {
        id = numero;
        numero++;

        if (kilometres > 180000) {
            throw new IllegalArgumentException("Kilométrage maximum dépassé");
        }

        this.kilometres = kilometres;
        this.location = location;
        this.vehicule = vehicule;

        // Ajout du véhicule au container de Vehicule et de Flotte
        vehicule.ajoutExemplaire(this);
        Flotte.ajout(this);
        this.setLoue(); // L'exemplaire est loué
    }

    public Exemplaire(int kilometres, Vehicule vehicule) throws IllegalArgumentException {
        id = numero;
        numero++;

        if (kilometres > 180000) {
            throw new IllegalArgumentException("Kilométrage maximum dépassé");
        }

        this.kilometres = kilometres;
        this.vehicule = vehicule;

        // Ajout du véhicule au container de Vehicule et de Flotte
        vehicule.ajoutExemplaire(this);
        Flotte.ajout(this);

        // L'exemplaire n'est pas loué
        this.unsetLoue();
    }

    public void setLoue() {
        this.loue = true;
    }

    public void unsetLoue() {
        this.loue = false;
    }

    public int getId() {
        return id;
    }

    public int getKilometres() {
        return kilometres;
    }

    public void setKilometres(int kilometres) {
        this.kilometres = kilometres;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exemplaire that = (Exemplaire) o;

        if (id != that.id) return false;
        if (kilometres != that.kilometres) return false;
        if (loue != that.loue) return false;
        if (!location.equals(that.location)) return false;
        return vehicule.equals(that.vehicule);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + kilometres;
        result = 31 * result + location.hashCode();
        result = 31 * result + vehicule.hashCode();
        result = 31 * result + (loue ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Exemplaire{" +
                "id=" + id +
                ", kilometres=" + kilometres +
                ", location=" + location +
                ", vehicule=" + vehicule +
                ", loue=" + loue +
                '}';
    }
}
