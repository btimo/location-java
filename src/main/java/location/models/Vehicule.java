package location.models;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestion du modèle d'un véhicule
 * @author Adrien Poupa
 * @author Timothée Barbot
 */
@Entity
@Inheritance
public abstract class Vehicule extends BaseModel{

    protected String marque;
    @OneToMany(mappedBy = "vehicule")
    protected List<Exemplaire> exemplaires = new ArrayList<Exemplaire>();
    protected int prixJour;
    protected int prixAssurance;


    /**
     * Getter de la marque
     * @return marque marque du véhicule
     */
    public String getMarque() {
        return marque;
    }

    /**
     * Setter de la marque
     * @param marque marque du véhicule
     */
    public void setMarque(String marque) {
        this.marque = marque;
    }

    /**
     * Ajout d'un exemplaire à la liste des exemplaires d'un véhicule
     * @param e exemplaire à ajouter
     */
    public synchronized void ajoutExemplaire(Exemplaire e) {
        exemplaires.add(e);
    }

    /**
     * Suppression d'un exemplaire à la liste des exemplaires d'un véhicule
     * @param e exemplaire à supprimer
     */
    public synchronized void suppressionExemplaire(Exemplaire e) {
        exemplaires.remove(e);
    }

    /**
     * Getter du prix de location journalier
     * @return prix de location journalier
     */
    public int getPrixJour() {
        return prixJour;
    }

    public void setPrixJour(int prixJour) {
        this.prixJour = prixJour;
    }

    /**
     * Getter du prix de l'assurance
     * @return prix de l'assurance
     */
    public int getPrixAssurance() {
        return prixAssurance;
    }

    public void setPrixAssurance(int prixAssurance) {
        this.prixAssurance = prixAssurance;
    }

    /**
     * Getter des exemplaires
     * @return exemplaires
     */
    public synchronized List<Exemplaire> getExemplaires() {
        return exemplaires;
    }

    @Transient
    public String getDisplayName(){
        return marque;
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

        Vehicule vehicule = (Vehicule) o;

        if (prixJour != vehicule.prixJour) return false;
        if (prixAssurance != vehicule.prixAssurance) return false;
        return marque.equals(vehicule.marque);

    }

    /**
     * Surcharge de hashcode
     * @return int hash unique
     */
    @Override
    public int hashCode() {
        int result = marque.hashCode();
        result = 31 * result + prixJour;
        result = 31 * result + prixAssurance;
        return result;
    }

    /**
     * Surcharge de toString
     * @return chaîne retournant les caractéristiques du véhicule
     */
    @Override
    public String toString() {
        return "Vehicule{" +
                "marque='" + marque + '\'' +
                "exemplaire='" + exemplaires + '\'' +
                "prix de base='" + prixJour + '\'' +
                ", prix assurance=" + prixAssurance +
                '}';
    }
}
