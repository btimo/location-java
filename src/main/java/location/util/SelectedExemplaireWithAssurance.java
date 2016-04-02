package location.util;

import location.models.Exemplaire;

public class SelectedExemplaireWithAssurance {
    private Exemplaire exemplaire;
    private boolean assurance;

    public SelectedExemplaireWithAssurance(Exemplaire e, boolean a){
        exemplaire = e;
        assurance = a;
    }

    public Exemplaire getExemplaire() {
        return exemplaire;
    }

    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }

    public boolean isAssurance() {
        return assurance;
    }

    public void setAssurance(boolean assurance) {
        this.assurance = assurance;
    }
}
