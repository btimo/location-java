package models;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;
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

    public Adresse(int numero, String rue, String cp, String ville) {
        this.numero = numero;
        this.ville = ville;
        this.cp = cp;
        this.rue = rue;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

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

    @Override
    public int hashCode() {
        int result = id.intValue();
        result = 31 * result + numero;
        result = 31 * result + rue.hashCode();
        result = 31 * result + cp.hashCode();
        result = 31 * result + ville.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return numero + " " + rue + " " + cp + " " + ville;
    }
}
