package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

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

    private final int[] duration = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

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
