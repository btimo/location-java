package location.views;

import location.views.components.misc.Fenetre;

/**
 * Fenêtre de l'application
 * @author Timothée Barbot
 * @author Stéphane Gâteau
 * @author Adrien Poupa
 */
public class LocationView {
    private Fenetre locationFenetre;

    /**
     * Construction de la fenêtre de l'application
     */
    public LocationView() {
        locationFenetre = new Fenetre("LocAppli",600,600);
    }

    /**
     * Getter de la fenetre de l'application
     * @return fenêtre où l'application se lancera
     */
    public Fenetre getLocationFenetre() {
        return locationFenetre;
    }

    /**
     * Setter de la fenêtre de l'application
     * @param locationFenetre fenêtre où afficher l'application
     */
    public void setLocationFenetre(Fenetre locationFenetre) {
        this.locationFenetre = locationFenetre;
    }
}
