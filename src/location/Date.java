package location;

import java.util.Arrays;

/**
 * Gestion des dates de location et retour
 * @author Adrien Poupa
 */
public class Date {
    private int jour;
    private int mois;
    private int annee;

    private final String[] nomsMois = new String[]{"inconnu","Janvier","Février", "Mars", "Avril", "Mai", "Juin", "Juillet",
            "Aout", "Septembre", "Octobre", "Novembre", "Decembre"};

    public Date(int jour, int mois, int annee) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }

    public Date(int jour, String mois, int annee) {
        this.jour = jour;

        int i = 0;

        // Par défaut, mois inconnu
        this.mois = 0;
        for (String nomActuel : nomsMois) {
            if (nomActuel.equals(mois)) {
                this.mois = i;
                break;
            }
            i++;
        }

        this.annee = annee;
    }

    public int getJour() {
        return jour;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Date date = (Date) o;

        if (jour != date.jour) return false;
        if (mois != date.mois) return false;
        if (annee != date.annee) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(nomsMois, date.nomsMois);

    }

    @Override
    public int hashCode() {
        int result = jour;
        result = 31 * result + mois;
        result = 31 * result + annee;
        result = 31 * result + Arrays.hashCode(nomsMois);
        return result;
    }

    @Override
    public String toString() {
        return jour + " " + nomsMois[mois] + " " + annee;
    }
}
