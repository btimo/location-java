package views.components.panel;

import views.components.tab.EmprunteursTab;
import views.components.tab.ExemplairesTab;
import views.components.tab.LocationsTab;
import views.components.tab.VehiculesTab;

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
}
