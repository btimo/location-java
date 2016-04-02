package location.models;

import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

/**
 * Gestion de la ville des emprunteurs
 * @author Adrien Poupa
 */
@Embeddable
public class Adresse extends BaseModel{

    public static final Find<Long,Adresse> find = new Find<Long, Adresse>(){};

    private int numero;

    private String rue;

    @Size(max=20)
    private String cp;

    @Size(max=100)
    private String ville;

    /**
     * Constructeur d'une adresse
     * @param numero numéro de la rue
     * @param rue nom de la rue
     * @param cp code postal
     * @param ville ville de résidence
     */
    public Adresse(int numero, String rue, String cp, String ville) {
        this.numero = numero;
        this.ville = ville;
        this.cp = cp;
        this.rue = rue;
    }

    /**
     * Getter de numéro
     * @return numéro
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Setter de numéro
     * @param numero numéro à mettre à jour
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Getter du nom de rue
     * @return nom de la rue
     */
    public String getRue() {
        return rue;
    }

    /**
     * Setter du nom de rue
     * @param rue nom de la rue
     */
    public void setRue(String rue) {
        this.rue = rue;
    }

    /**
     * Getter du code postal
     * @return code postal
     */
    public String getCp() {
        return cp;
    }

    /**
     * Setter du code postal
     * @param cp code postal
     */
    public void setCp(String cp) {
        this.cp = cp;
    }

    /**
     * Getter de la ville
     * @return nom de la ville
     */
    public String getVille() {
        return ville;
    }

    /**
     * Setter de la ville
     * @param ville nom de la ville
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    /**
     * Surcharge de equals
     * @param o objet à comparer
     * @return true/false suivant égalité
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Adresse adresse = (Adresse) o;

        if (numero != adresse.numero) return false;
        if (cp != adresse.cp) return false;
        if (!rue.equals(adresse.rue)) return false;
        return ville.equals(adresse.ville);

    }

    /**
     * Surcharge de hashcode
     * @return int hash unique
     */
    @Override
    public int hashCode() {
        int result = id.intValue();
        result = 31 * result + numero;
        result = 31 * result + rue.hashCode();
        result = 31 * result + cp.hashCode();
        result = 31 * result + ville.hashCode();
        return result;
    }

    /**
     * Surcharge de toString
     * @return adresse formatée
     */
    @Override
    public String toString() {
        return numero + " " + rue + " " + cp + " " + ville;
    }
}
