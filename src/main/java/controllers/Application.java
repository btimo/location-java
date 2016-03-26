package controllers;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.config.dbplatform.DbPlatformName;
import com.avaje.ebean.dbmigration.DbMigration;
import org.avaje.agentloader.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import views.InterfaceLocation;

import java.io.IOException;

/**
 * Classe utilisée pour le lancement des fenêtres
 */
public class Application {

    private static EbeanServer server = Ebean.getServer("sqlite");

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

        /*if (!AgentLoader.loadAgentFromClasspath("avaje-ebeanorm-agent","debug=1;packages=models.*")) {
            System.out.println("avaje-ebeanorm-agent not found in classpath - not dynamically loaded");
        }*/

        /*DbMigration migration = new DbMigration(server);
        migration.setPlatform(DbPlatformName.SQLITE);

        try{
            System.out.println("debut migration ...");
            migration.generateMigration();
            System.out.println("fin migration !");
        }catch(IOException e){
            e.getStackTrace();
        }*/

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
}
