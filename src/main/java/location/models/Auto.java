package location.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * Gestion d'un modèle d'auto
 * Etend Véhicule
 * @author Adrien Poupa
 * @author Timothée Barbot
 */
@Entity
@DiscriminatorValue("auto")
public class Auto extends Vehicule {

    private String modele;

    private boolean luxe;

    public Auto(){

    }

    /**
     * Constructeur de base d'une auto
     * @param marque nom du constructeur
     * @param modele nom du modèle
     * @param prixJour prix journalier de la location
     * @param prixAssurance prix de l'assurance
     * @param luxe booléen : voiture de luxe ?
     */
    public Auto(String marque, String modele, int prixJour, int prixAssurance, boolean luxe) {
        this.marque = marque;
        this.modele = modele;
        this.luxe = luxe;
        this.prixJour = prixJour;
        this.prixAssurance = prixAssurance;
    }

    /**
     * Getter de modèle
     * @return nom du modèle
     */
    public String getModele() {
        return modele;
    }

    /**
     * Setter de modèle
     * @param modele nom du modèle
     */
    public void setModele(String modele) {
        this.modele = modele;
    }

    /**
     * Getter de luxe
     * @return booléen luxe?
     */
    public boolean isLuxe() {
        return luxe;
    }

    /**
     * Setter de luxe
     * @param luxe booléen luxe?
     */
    public void setLuxe(boolean luxe) {
        this.luxe = luxe;
    }

    @Transient
    @Override
    public String getDisplayName(){
        return getMarque() + " - " + getModele() + (isLuxe() ? " - luxe": "");
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

        Auto auto = (Auto) o;

        if (luxe != auto.luxe) return false;
        return modele.equals(auto.modele);

    }

    /**
     * Surcharge de hashcode
     * @return int hash unique
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + modele.hashCode();
        result = 31 * result + (luxe ? 1 : 0);
        return result;
    }

    /**
     * Surcharge de toString
     * @return chaîne retournant les caractéristiques de l'auto
     */
    @Override
    public String toString() {
        return "Auto{" +
                "marque=" + getMarque() + ", " +
                "modele=" + modele + ", " +
                "prix de base=" + prixJour + ", " +
                "prix assurance=" + prixAssurance + ", " +
                "luxe=" + luxe +
                '}';
    }
}
