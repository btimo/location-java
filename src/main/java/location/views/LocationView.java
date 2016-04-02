package location.views;

import location.views.components.misc.*;

public class LocationView {
    private Fenetre locationFenetre;

    public LocationView() {
        locationFenetre = new Fenetre("LocAppli",600,600);
    }

    public Fenetre getLocationFenetre() {
        return locationFenetre;
    }

    public void setLocationFenetre(Fenetre locationFenetre) {
        this.locationFenetre = locationFenetre;
    }
}
