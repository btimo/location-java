package models;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.IllegalFormatCodePointException;
import java.util.concurrent.TimeUnit;

/**
 * Gestion des dates de location et retour
 * @author Adrien Poupa
 */
@Embeddable
public class Date {

    private int jour;

    private int mois;

    private int annee;

    @Transient
    private static final String[] nomsMois = new String[]{"inconnu","Janvier","Février", "Mars", "Avril", "Mai", "Juin", "Juillet",
            "Aout", "Septembre", "Octobre", "Novembre", "Decembre"};

    /**
     * Constructeur par défaut de date
     * @param jour jour 1-31
     * @param mois mois 1-12
     * @param annee année de la forme XXXX
     * @throws IllegalArgumentException exception en cas d'irrespect du format
     */
    public Date(int jour, int mois, int annee) throws IllegalArgumentException {
        if (jour < 1 || jour > 31) {
            throw new IllegalArgumentException("Les jours doivent etre compris entre 1 et 31");
        }
        if (mois < 1 || mois > 12) {
            throw new IllegalArgumentException("Les mois doivent etre compris entre 1 et 12");
        }
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }

    /**
     * Constructeur avec les mois en String
     * @param jour jour 1-31
     * @param mois chaîne du type 'Janvier'
     * @param annee année de la forme XXXX
     * @throws IllegalArgumentException exception en cas d'irrespect du format
     */
    public Date(int jour, String mois, int annee) throws IllegalArgumentException {
        if (jour < 1 || jour > 31) {
            throw new IllegalArgumentException("Les jours doivent etre compris entre 1 et 31");
        }

        this.jour = jour;

        this.setMois(mois);

        this.annee = annee;
    }

    /**
     * Getter de jour
     * @return jour
     */
    public int getJour() {
        return jour;
    }

    /**
     * Setter de jour
     * @param jour jour à mettre à jour
     */
    public void setJour(int jour) {
        this.jour = jour;
    }

    /**
     * Getter de mois
     * @return mois
     */
    public int getMois() {
        return mois;
    }

    /**
     * Setter de mois en int
     * @param mois mois à mettre à jour type 1-12
     */
    public void setMois(int mois) {
        this.mois = mois;
    }

    /**
     * Setter de mois en string
     * @param mois mois à mettre à jour type "Janvier"
     */
    public void setMois(String mois) {
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
    }

    /**
     * Getter de l'année
     * @return année
     */
    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    /**
     * Nombre de jours écoulés entre deux dates
     * @param d date la plus faible
     * @return nombre de jours
     */
    public int daysBetween(Date d)
    {
        long diff = 0;

        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
        String inputString1 = Integer.toString(d.getJour()) + " " + Integer.toString(d.getMois()) + " " + Integer.toString(d.getAnnee());
        String inputString2 = Integer.toString(this.jour) + " " + Integer.toString(this.mois) + " " + Integer.toString(this.annee);

        try {
            java.util.Date date1 = myFormat.parse(inputString1);
            java.util.Date date2 = myFormat.parse(inputString2);
            diff = date2.getTime() - date1.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
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

        Date date = (Date) o;

        if (jour != date.jour) return false;
        if (mois != date.mois) return false;
        if (annee != date.annee) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(nomsMois, date.nomsMois);

    }

    /**
     * Surcharge de hashcode
     * @return int hash unique
     */
    @Override
    public int hashCode() {
        int result = jour;
        result = 31 * result + mois;
        result = 31 * result + annee;
        result = 31 * result + Arrays.hashCode(nomsMois);
        return result;
    }

    /**
     * Surcharge de toString
     * @return date formatée
     */
    @Override
    public String toString() {
        return jour + " " + nomsMois[mois] + " " + annee;
    }
}
