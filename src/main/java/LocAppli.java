import containers.Flotte;
import controllers.Application;

/**
 * Classe à lancer pour initialiser l'application
 * TODO: remplir containers avec find()
 * @author Adrien Poupa
 * @author Timothée Barbot
 * @author Stéphane Gâteau
 */
public class LocAppli {
    /**
     * Lancement de l'application
     * @param args paramètres par défaut
     */
    public static void main(String[] args) {
        try {
            // Récupération du singleton
            Application app = Application.getApp();

            // todo: remplissage...
            //List<Exemplaire> exemplaires = Exemplaire.find.select("*").findList();

            System.out.println(Flotte.get());

            // Affichage Swing
            //app.load();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void initData(){

    }
}
