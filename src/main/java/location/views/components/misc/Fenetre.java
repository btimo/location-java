package location.views.components.misc;

import location.views.components.dialog.EmprunteurFormDialog;
import location.views.components.dialog.ExemplaireFormDialog;
import location.views.components.dialog.LocationFormDialog;
import location.views.components.dialog.VehiculeFormDialog;
import location.views.components.form.ExemplaireForm;
import location.views.components.panel.MainPanel;

import javax.swing.*;
import java.awt.*;

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


    public Fenetre(String nom, int hauteur, int largeur){
        super(nom);
        this.largeur = largeur;
        this.hauteur = hauteur;
        initFenetre();
    }

    public void initFenetre(){
        setSize(largeur, hauteur);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tabs = new MainPanel();
        add(tabs);
        setVisible(true);
    }

    public EmprunteurFormDialog getEmprunteurFormDialog() {
        return emprunteurFormDialog;
    }

    public void setEmprunteurFormDialog(EmprunteurFormDialog emprunteurFormDialog) {
        this.emprunteurFormDialog = emprunteurFormDialog;
    }

    public ExemplaireFormDialog getExemplaireFormDialog() {
        return exemplaireFormDialog;
    }

    public void setExemplaireFormDialog(ExemplaireFormDialog exemplaireFormDialog) {
        this.exemplaireFormDialog = exemplaireFormDialog;
    }

    public VehiculeFormDialog getVehiculeFormDialog() {
        return vehiculeFormDialog;
    }

    public void setVehiculeFormDialog(VehiculeFormDialog vehiculeFormDialog) {
        this.vehiculeFormDialog = vehiculeFormDialog;
    }

    public LocationFormDialog getLocationFormDialog() {
        return locationFormDialog;
    }

    public void setLocationFormDialog(LocationFormDialog locationFormDialog) {
        this.locationFormDialog = locationFormDialog;
    }

    public MainPanel getTabs() {
        return tabs;
    }

    public void setTabs(MainPanel tabs) {
        this.tabs = tabs;
    }

    public String getNom(){
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }
}
