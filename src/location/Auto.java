package location;

/**
 * Created by Adrien on 07/03/2016.
 */
public class Auto extends Vehicule {
    private String modele;
    private boolean luxe;

    public Auto(String marque, String modele) {
        this.marque = marque;
        this.modele = modele;
        this.luxe = false;

        // Ajout du véhicule actuel
        Vehicules.ajout(this);
    }

    public Auto(String marque, String modele, boolean luxe) {
        this.marque = marque;
        this.modele = modele;
        this.luxe = luxe;

        // Ajout du véhicule actuel
        Vehicules.ajout(this);
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public boolean isLuxe() {
        return luxe;
    }

    public void setLuxe(boolean luxe) {
        this.luxe = luxe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Auto auto = (Auto) o;

        if (luxe != auto.luxe) return false;
        return modele.equals(auto.modele);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + modele.hashCode();
        result = 31 * result + (luxe ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "marque=" + getMarque() + ", " +
                "modele=" + modele + ", " +
                "luxe=" + luxe +
                '}';
    }
}
