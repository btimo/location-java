package views.components.misc;

import views.components.panel.MainPanel;
import views.components.panel.TabInnerPanel;

import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame{

    private static Color defaultColor = Color.ORANGE;

    private TabInnerPanel tabInnerPanel;

    private MainPanel tabs;

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

    public String getNom(){
        return nom;
    }

    public TabInnerPanel getTabInnerPanel() {
        return tabInnerPanel;
    }

    public void setTabInnerPanel(TabInnerPanel tabInnerPanel) {
        this.tabInnerPanel = tabInnerPanel;
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
