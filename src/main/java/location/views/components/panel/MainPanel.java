package location.views.components.panel;

import location.views.components.tab.EmprunteursTab;
import location.views.components.tab.ExemplairesTab;
import location.views.components.tab.LocationsTab;
import location.views.components.tab.VehiculesTab;

import javax.swing.*;

/**
 * Gestion des onglets
 * @author Timothée Barbot
 * @author Adrien Poupa
 */
public class MainPanel extends JTabbedPane {

    private EmprunteursTab emprunteurTab;
    private ExemplairesTab exemplairesTab;
    private LocationsTab locationsTab;
    private VehiculesTab vehiculesTab;

    /**
     * Constructeur par défaut
     */
    public MainPanel() {
        super();
        initMainPanel();
    }

    /**
     * Initialisation du panneau
     */
    private void initMainPanel(){
        emprunteurTab = new EmprunteursTab();
        exemplairesTab = new ExemplairesTab();
        locationsTab = new LocationsTab();
        vehiculesTab = new VehiculesTab();

        addTab("Locations", locationsTab);
        addTab("Emprunteurs", emprunteurTab);
        addTab("Exemplaires", exemplairesTab);
        addTab("Vehicules", vehiculesTab);

        setVisible(true);
    }

    /**
     * Onglet emprunteur
     * @return onglet
     */
    public EmprunteursTab getEmprunteurTab() {
        return emprunteurTab;
    }

    /**
     * Modification onglet emprunteur
     * @param emprunteurTab onglet
     */
    public void setEmprunteurTab(EmprunteursTab emprunteurTab) {
        this.emprunteurTab = emprunteurTab;
    }

    /**
     * Onglet exemplaires
     * @return onglet
     */
    public ExemplairesTab getExemplairesTab() {
        return exemplairesTab;
    }

    /**
     * Modification onglet exemplaires
     * @param exemplairesTab onglet
     */
    public void setExemplairesTab(ExemplairesTab exemplairesTab) {
        this.exemplairesTab = exemplairesTab;
    }

    /**
     * Onglet locations
     * @return onglet
     */
    public LocationsTab getLocationsTab() {
        return locationsTab;
    }

    /**
     * Modification onglet locations
     * @param locationsTab onglet
     */
    public void setLocationsTab(LocationsTab locationsTab) {
        this.locationsTab = locationsTab;
    }

    /**
     * Onglet véhicules
     * @return onglet
     */
    public VehiculesTab getVehiculesTab() {
        return vehiculesTab;
    }

    /**
     * Modification onglet véhicules
     * @param vehiculesTab onglet
     */
    public void setVehiculesTab(VehiculesTab vehiculesTab) {
        this.vehiculesTab = vehiculesTab;
    }
}
