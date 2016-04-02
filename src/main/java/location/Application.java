package location;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.ServerConfig;
import location.containers.Vehicules;
import location.models.*;
import location.views.LocationView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

/**
 * Classe utilisée pour le lancement des fenêtres
 * @author Timothée Barbot
 * @author Stéphane Gâteau
 * @author Adrien Poupa
 */
public class Application {

    /**
     * Change this variable if in production mode
     * This will stop Ebean from deleting and re-creating the DB
     */
    private static final boolean isDeveloppement = false;

    private static EbeanServer server;

    protected static Logger logger = LoggerFactory.getLogger(Application.class);

    private static Application app = null;

    private LocationView view;

    /**
     * Lancement de l'application
     * @param args arguments par défaut
     */
    public static void main(String[] args){
        Application app = getApp();
    }

    /**
     * Constructeur privé
     */
    private Application(){
        System.out.println("Lancement de l'application en cours...");

        initEbeanServer();

        // initialize data of the application
        if (isDeveloppement) {
            initData();
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // initialize frame
                view = new LocationView();
            }
        });
    }

    /**
     * Obtention du singleton
     * @return singleton App
     */
    public static Application getApp()
    {
        if(app == null){
            app = new Application();
        }

        return app;
    }

    /**
     * Initialisation du serveur eBean
     */
    private void initEbeanServer(){
        ServerConfig c = new ServerConfig();
        c.setName("sqlite");

        // read the ebean.properties and load
        // those settings into this serverConfig object
        c.loadFromProperties();

        // generate DDL and run it
        c.setDdlGenerate(isDeveloppement);
        c.setDdlRun(isDeveloppement);

        // register as the 'Default' server
        c.setDefaultServer(true);

        server = EbeanServerFactory.create(c);
    }

    /**
     * Ajout des données aux programmes
     * Utilisé en phase de développement seulement
     */
    private void initData(){
        System.out.println("Initialisation des données");
        new Emprunteur(new Adresse(3, "avenue de la République", "94800", "Villejuif"), "Adrien", "Poupa").save();
        new Emprunteur(new Adresse(5, "avenue de la République", "94800", "Villejuif"), "Timothée", "Barbot").save();
        new Emprunteur(new Adresse(15, "avenue de la République", "94800", "Villejuif"), "Stéphane", "Gâteau").save();
        new Emprunteur(new Adresse(25, "avenue de l'Espérance", "54000", "Nancy"), "Jack", "Rackam").save();
        new Emprunteur(new Adresse(2, "rue des Trésoriers", "54000", "Nancy"), "Jean", "Taer").save();
        new Emprunteur(new Adresse(2, "rue des Trésoriers", "54000", "Nancy"), "Jeanne", "Taer").save();
        new Emprunteur(new Adresse(45, "rue des Filatiers", "31000", "Toulouse"), "Léna", "Simon").save();
        new Emprunteur(new Adresse(4, "rue des Chalets", "31000", "Toulouse"), "David", "Dupont").save();
        new Emprunteur(new Adresse(4, "Grand-Rue", "13000", "Marseille"), "Steve", "Mandanda").save();
        new Emprunteur(new Adresse(276, "Promenade des anglais", "06000", "Marseille"), "Harvey", "Lee").save();
        new Emprunteur(new Adresse(276, "Promenade des anglais", "06000", "Marseille"), "Harvey", "Kevin").save();
        new Emprunteur(new Adresse(276, "Promenade des anglais", "06000", "Marseille"), "Harvey", "Jena").save();
        new Emprunteur(new Adresse(1, "The Wall", "56000", "The North"), "John", "Snow").save();
        new Emprunteur(new Adresse(1, "The Wall", "56000", "The North"), "Samwell", "Tarly").save();
        new Emprunteur(new Adresse(1, "Palace", "90000", "Meereen"), "Daenerys", "Targaryen").save();
        new Emprunteur(new Adresse(34, "Friendzone avenue", "90000", "Meereen"), "Jorah", "Mormont").save();
        new Emprunteur(new Adresse(1, "Palace", "10000", "King's Landing"), "Tommen", "Baratheon").save();
        new Emprunteur(new Adresse(1, "Palace", "10000", "King's Landing"), "Cersei", "Lannister").save();
        new Emprunteur(new Adresse(1, "Palace", "10000", "King's Landing"), "Jaime", "Lannister").save();
        new Emprunteur(new Adresse(1, "Palace", "10000", "King's Landing"), "Ned", "Stark").save();

        // Voitures standards
        new Auto("Dacia", "Sandero", 100, 30, false).save();
        new Auto("Dacia", "Logan", 70, 30, false).save();
        new Auto("Dacia", "Duster", 150, 50, false).save();
        new Auto("Renault", "Twingo", 120, 40, false).save();
        new Auto("Renault", "Kangoo", 120, 40, false).save();
        new Auto("Renault", "Megan", 120, 40, false).save();
        new Auto("Renault", "Scénic", 150, 50, false).save();
        new Auto("Renault", "Espace", 200, 60, false).save();
        new Auto("Renault", "Zoe", 110, 40, false).save();
        new Auto("Renault", "Captur", 140, 50, false).save();
        new Auto("Citroën", "C1", 110, 20, false).save();
        new Auto("Citroën", "C2", 130, 30, false).save();
        new Auto("Citroën", "C3", 150, 40, false).save();
        new Auto("Citroën", "C4", 160, 50, false).save();
        new Auto("Citroën", "C4 Cactus", 170, 50, false).save();

        // Voitures de luxe
        new Auto("Mercedes", "SLR", 300, 100, true).save();
        new Auto("Mercedes", "SLK", 400, 100, true).save();
        new Auto("Mercedes", "Classe E", 300, 100, true).save();
        new Auto("Mercedes", "Classe B", 300, 100, true).save();
        new Auto("Mercedes", "Classe C", 250, 100, true).save();
        new Auto("Mercedes", "Classe A", 200, 100, true).save();
        new Auto("Mercedes", "Classe S", 400, 200, true).save();
        new Auto("Mercedes", "GLA", 400, 200, true).save();
        new Auto("Mercedes", "GLE Coupé", 500, 300, true).save();
        new Auto("Ferrari", "F12 TDF", 800, 400, true).save();
        new Auto("Ferrari", "GTC4 Lusso", 800, 400, true).save();
        new Auto("Ferrari", "488 Spider", 1000, 500, true).save();
        new Auto("Ferrari", "488 GTB", 1000, 500, true).save();
        new Auto("Ferrari", "California T", 1000, 500, true).save();
        new Auto("Ferrari", "458 Speciale", 1000, 500, true).save();

        // Motos
        new Moto("Harley Davidson", 750, 100, 30).save();
        new Moto("Harley Davidson", 1000, 100, 30).save();
        new Moto("Harley Davidson", 1200, 100, 30).save();
        new Moto("Harley Davidson", 1500, 100, 30).save();
        new Moto("Ducati", 1000, 100, 30).save();
        new Moto("Ducati", 1200, 120, 20).save();
        new Moto("Suzuki", 1000, 80, 20).save();
        new Moto("Suzuki", 1100, 100, 20).save();
        new Moto("Suzuki", 1500, 90, 40).save();
        new Moto("Yamaha", 1500, 90, 50).save();
        new Moto("Yamaha", 500, 90, 20).save();
        new Moto("Suzuki", 400, 60, 40).save();
        new Moto("Suzuki", 300, 40, 20).save();
        new Moto("Suzuki", 200, 30, 20).save();
        new Moto("Suzuki", 1200, 100, 60).save();

        // Création d'exemplaires, 3 par modèle
        for (Vehicule v : Vehicules.get()) {
            new Exemplaire((int) (Math.random() * (180000)), v).save();
            new Exemplaire((int) (Math.random() * (180000)), v).save();
            new Exemplaire((int) (Math.random() * (180000)), v).save();
        }

        // Quelques locations...
        Emprunteur emp = new Emprunteur(new Adresse(3, "avenue de la République", "94800", "Villejuif"), "Adrien", "Poupa");
        emp.save();
        Date date1 = new Date(1, 1, 2016);
        Date date2 = new Date(1, "Février", 2016);

        Location locationAvecAssurance = new Location(date1, date2, true);

        Auto auto = new Auto("Dacia", "Sandero", 200, 30, false);
        auto.save();

        Exemplaire exemplaire = new Exemplaire(60000, auto);
        exemplaire.save();

        locationAvecAssurance.louer(exemplaire, true);
        emp.louer(locationAvecAssurance);

        locationAvecAssurance.save();
    }

    /**
     * Récupération de la vue
     * @return vue
     */
    public LocationView getView() {
        return view;
    }

    /**
     * Mise à jour de la vue
     * @param view vue
     */
    public void setView(LocationView view) {
        this.view = view;
    }
}
