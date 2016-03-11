package location;

/**
 * Created by Adrien on 07/03/2016.
 */
public class Test {
    public static void main (String[] args) {
        Date date = new Date(1, 1, 2016);
        System.out.println(date);

        Date date2 = new Date(1, "Février", 2016);
        System.out.println(date2);

        Adresse adresse = new Adresse(3, "avenue de la République", 94800, "Villejuif");
        System.out.println(adresse);
    }
}
