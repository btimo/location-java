package location;

/**
 * Created by Adrien on 07/03/2016.
 */
public class Exemplaire {
    private static int numero = 1; // Variable partagée par toutes les instances de Exemplaire
    private int id;
    private int kilometres;
    private Location location;
    private Vehicule vehicule;

    public Exemplaire(int kilometres, Location location, Vehicule vehicule) {
        id = numero;
        numero++;
        this.kilometres = kilometres;
        this.location = location;
        this.vehicule = vehicule;

        // Ajout du véhicule au container de Vehicule et de Flotte
        vehicule.ajoutExemplaire(this);
        Flotte.ajoutFlotte(this);
    }

    public Exemplaire(int kilometres, Vehicule vehicule) {
        id = numero;
        numero++;
        this.kilometres = kilometres;
        this.vehicule = vehicule;

        // Ajout du véhicule au container de Vehicule et de Flotte
        vehicule.ajoutExemplaire(this);
        Flotte.ajoutFlotte(this);
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
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        return vehicule.equals(that.vehicule);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + kilometres;
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + vehicule.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Exemplaire{" +
                "id=" + id +
                ", kilometres=" + kilometres +
                ", location=" + location +
                ", vehicule=" + vehicule +
                '}';
    }
}
