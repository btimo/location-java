package location.views.components.panel;

import location.views.components.tab.EmprunteursTab;
import location.views.components.tab.ExemplairesTab;
import location.views.components.tab.LocationsTab;
import location.views.components.tab.VehiculesTab;

import javax.swing.*;

public class MainPanel extends JTabbedPane {

    private EmprunteursTab emprunteurTab;
    private ExemplairesTab exemplairesTab;
    private LocationsTab locationsTab;
    private VehiculesTab vehiculesTab;

    public MainPanel(){
        super();
        initMainPanel();
    }

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

    public EmprunteursTab getEmprunteurTab() {
        return emprunteurTab;
    }

    public void setEmprunteurTab(EmprunteursTab emprunteurTab) {
        this.emprunteurTab = emprunteurTab;
    }

    public ExemplairesTab getExemplairesTab() {
        return exemplairesTab;
    }

    public void setExemplairesTab(ExemplairesTab exemplairesTab) {
        this.exemplairesTab = exemplairesTab;
    }

    public LocationsTab getLocationsTab() {
        return locationsTab;
    }

    public void setLocationsTab(LocationsTab locationsTab) {
        this.locationsTab = locationsTab;
    }

    public VehiculesTab getVehiculesTab() {
        return vehiculesTab;
    }

    public void setVehiculesTab(VehiculesTab vehiculesTab) {
        this.vehiculesTab = vehiculesTab;
    }
}
