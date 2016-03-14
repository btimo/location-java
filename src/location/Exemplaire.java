package location;

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
    private float reservoir;
    private int prixFinal;

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

        this.reservoir = 1;
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

        this.reservoir = 1;
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

    public String getReservoir() {
        if (reservoir == 0.0) {
            return "Vide";
        }
        else if (reservoir == 1.0) {
            return "Plein";
        }
        return Float.toString(reservoir);
    }

    public void setReservoir(float reservoir) {
        if (this.reservoir == 0 | this.reservoir == 0.25  || this.reservoir == 0.5 || this.reservoir == 0.75 || this.reservoir == 1) {
            this.reservoir = reservoir;
        }
        else {
            this.reservoir = 0;
        }
    }

    /**
     * Retourne le prix final de la location
     * 10% de réduction tous les 50 000 kms
     * @return prix final
     */
    public double getPrixFinal() {
        return vehicule.getPrixJour() - (int) Math.ceil((double)kilometres / 50000)*0.1*vehicule.getPrixJour();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exemplaire that = (Exemplaire) o;

        if (id != that.id) return false;
        if (kilometres != that.kilometres) return false;
        if (loue != that.loue) return false;
        if (Float.compare(that.reservoir, reservoir) != 0) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        return vehicule.equals(that.vehicule);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + kilometres;
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + vehicule.hashCode();
        result = 31 * result + (loue ? 1 : 0);
        result = 31 * result + (reservoir != +0.0f ? Float.floatToIntBits(reservoir) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Exemplaire{" +
                "id=" + id +
                ", kilometres=" + kilometres +
                ", location=" + location +
                ", vehicule=" + vehicule +
                ", reservoir=" + getReservoir() +
                ", prixFinal=" + getPrixFinal() +
                ", loue=" + loue +
                '}';
    }
}
