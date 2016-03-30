import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.ServerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import views.InterfaceLocation;

/**
 * Classe utilisée pour le lancement des fenêtres
 */
public class Application {

    /**
     * Change this variable if in production mode
     * This will stop Ebean from deleting and re-creating the DB
     */
    private static final boolean isDeveloppement = true;

    private static EbeanServer server;

    protected static Logger logger = LoggerFactory.getLogger(Application.class);

    private static Application app = null;

    public static void main(String[] args){
        Application app = getApp();
    }

    /**
     * Constructeur privé
     */
    private Application(){
        System.out.println("Application Location");

        initEbeanServer();

        // initialize data of the application
        // initData();
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
     * Chargement de l'interfae Swing
     */
    public void load() {
        InterfaceLocation.load();
    }

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
    public void initData(){
        //
    }
}
