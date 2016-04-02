package location.views.components.misc;

import location.views.components.dialog.EmprunteurFormDialog;
import location.views.components.dialog.ExemplaireFormDialog;
import location.views.components.dialog.LocationFormDialog;
import location.views.components.dialog.VehiculeFormDialog;
import location.views.components.panel.MainPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Création d'une fenêtre
 * @author Timothée Barbot
 */
public class Fenetre extends JFrame{

    public static Color defaultColor = Color.ORANGE;

    private MainPanel tabs;

    private EmprunteurFormDialog emprunteurFormDialog;

    private ExemplaireFormDialog exemplaireFormDialog;

    private VehiculeFormDialog vehiculeFormDialog;

    private LocationFormDialog locationFormDialog;

    protected String nom;
    protected int hauteur;
    protected int largeur;

    /**
     * Constructeur par défaut
     * @param nom nom fenêtre
     * @param hauteur hauteur
     * @param largeur largeur
     */
    public Fenetre(String nom, int hauteur, int largeur){
        super(nom);
        this.largeur = largeur;
        this.hauteur = hauteur;
        initFenetre();
    }

    /**
     * Initialisation de la fenêtre
     */
    public void initFenetre(){
        setSize(largeur, hauteur);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tabs = new MainPanel();
        add(tabs);
        setVisible(true);
    }

    /**
     * Fenêtre modale emprunteur
     * @return fenêtre modale emprunteur
     */
    public EmprunteurFormDialog getEmprunteurFormDialog() {
        return emprunteurFormDialog;
    }

    /**
     * Modification fenêtre modale emprunteur
     * @param emprunteurFormDialog fenêtre modale emprunteur
     */
    public void setEmprunteurFormDialog(EmprunteurFormDialog emprunteurFormDialog) {
        this.emprunteurFormDialog = emprunteurFormDialog;
    }

    /**
     * Fenêtre modale exemplaire
     * @return fenêtre modale exemplaire
     */
    public ExemplaireFormDialog getExemplaireFormDialog() {
        return exemplaireFormDialog;
    }

    /**
     * Modification fenêtre modale exemplaire
     * @param exemplaireFormDialog fenêtre modale exemplaire
     */
    public void setExemplaireFormDialog(ExemplaireFormDialog exemplaireFormDialog) {
        this.exemplaireFormDialog = exemplaireFormDialog;
    }

    /**
     * Fenêtre modale véhicule
     * @return fenêtre modale véhicule
     */
    public VehiculeFormDialog getVehiculeFormDialog() {
        return vehiculeFormDialog;
    }

    /**
     * Modification fenêtre modale véhicule
     * @param vehiculeFormDialog fenêtre modale véhicule
     */
    public void setVehiculeFormDialog(VehiculeFormDialog vehiculeFormDialog) {
        this.vehiculeFormDialog = vehiculeFormDialog;
    }

    /**
     * Fenêtre modale location
     * @return fenêtre modale location
     */
    public LocationFormDialog getLocationFormDialog() {
        return locationFormDialog;
    }

    /**
     * Modification fenêtre modale location
     * @param locationFormDialog fenêtre modale location
     */
    public void setLocationFormDialog(LocationFormDialog locationFormDialog) {
        this.locationFormDialog = locationFormDialog;
    }

    /**
     * Récupération des onglets
     * @return onglets
     */
    public MainPanel getTabs() {
        return tabs;
    }

    /**
     * Modification des onglets
     * @param tabs onglets
     */
    public void setTabs(MainPanel tabs) {
        this.tabs = tabs;
    }

    /**
     * Récupération du nom de la fenêtre
     * @return nom
     */
    public String getNom(){
        return nom;
    }

    /**
     * Modification du nom fenêtre
     * @param nom nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Hauteur fenêtre
     * @return hauteur
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     * Modification hauteur fenêtre
     * @param hauteur hauteur
     */
    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    /**
     * Largeur fenêtre
     * @return largeur
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * Modification largeur fenêtre
     * @param largeur largeur
     */
    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }
}
