package location.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * Gestion d'un modèle d'une moto
 * Etend Vehicule
 * @author Adrien Poupa
 */
@Entity
@DiscriminatorValue("moto")
public class Moto extends Vehicule {

    private int cylindree;

    /**
     * Constructeur vide pour eBean
     */
    public Moto(){

    }

    /**
     * Constructeur par défaut
     * @param marque marque de la moto
     * @param cylindree cylindrée
     * @param prixJour prix de location journalier
     * @param prixAssurance prix de l'assurance
     */
    public Moto(String marque, int cylindree, int prixJour, int prixAssurance) {
        this.cylindree = cylindree;
        this.marque = marque;
        this.prixJour = prixJour;
        this.prixAssurance = prixAssurance;
    }

    /**
     * Getter de la cylindrée
     * @return cylindrée
     */
    public int getCylindree() {
        return cylindree;
    }

    /**
     * Setter de la cylindrée
     * @param cylindree cylindrée
     */
    public void setCylindree(int cylindree) {
        this.cylindree = cylindree;
    }

    @Transient
    @Override
    public String getDisplayName(){
        return getMarque() + " - " + getCylindree();
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
        if (!super.equals(o)) return false;

        Moto moto = (Moto) o;

        return cylindree == moto.cylindree;

    }

    /**
     * Surcharge de hashcode
     * @return int hash unique
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + cylindree;
        return result;
    }

    /**
     * Surcharge de toString
     * @return chaîne retournant les caractéristiques de la moto
     */
    @Override
    public String toString() {
        return "Moto{" +
                "marque='" + getMarque() + ", " + '\'' +
                "prix de base=" + prixJour + ", " +
                "prix assurance=" + prixAssurance + ", " +
                "cylindree=" + cylindree +
                '}';
    }
}
