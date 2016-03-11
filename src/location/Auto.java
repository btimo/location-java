package location;

/**
 * Created by Adrien on 07/03/2016.
 */
public class Auto extends Vehicule {
    private String modele;

    public Auto(String marque, String modele) {
        this.marque = marque;
        this.modele = modele;

        // Ajout du véhicule actuel
        Vehicules.ajoutVehicule(this);
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Auto auto = (Auto) o;

        return modele.equals(auto.modele);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + modele.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "modele='" + modele + '\'' +
                '}';
    }
}
