package views;

import containers.Vehicules;
import models.Auto;
import models.Moto;
import models.Vehicule;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class LocationViews {
    public static  JFrame locationFrame = Fenetre.nvFenetre("Location de vehicule auto/moto",500,500);
    public static JTabbedPane donnee =Onglet.nvOnglet();
    public static Auto auto = new Auto("Ford", "Fiesta", 200,0,false);
    public static Auto auto2 = new Auto("Dacia", "Sandero", 200,0,true);
    public static Auto auto3 = new Auto("Audi", "A1", 500,0,false);
    public static Moto moto = new Moto("Harley Davidson", 300, 200);

      public static void main(String[] args) {
          //JFrame locationFrame = Fenetre.nvFenetre("Location de vehicule auto/moto",500,500);
         // JTabbedPane donnee =Onglet.nvOnglet();
          JPanel fenetrePanel =Panel.nvPanelBox(Color.ORANGE);
          donnee.add("Choix de voiture",fenetrePanel);
          JPanel titrePanel =Panel.nvPanelFlow(Color.ORANGE);
          JLabel reservationLabel = Label.nvLabel("Reservation de vehicule :","Calibri", Font.PLAIN, 25);
          titrePanel.add(reservationLabel);
          JPanel identifiantPanel =Panel.identification(Color.ORANGE);

          JPanel adressePanel = Panel.adresse(Color.ORANGE);

          JPanel choixPanel = Panel.choixPanel("louer:",Color.ORANGE,"une auto","une moto");

          JPanel modelPanel =Panel.nvPanelFlow(Color.ORANGE);
          JLabel constructeurModel = Label.nvLabel("Constructeur et modele :","Arial",Font.BOLD,14 );
          modelPanel.add(constructeurModel);
          modelPanel.add(Panel.listeAutoMoto(Color.ORANGE));
          JPanel assurancePanel = Panel.choixPanel("Voulez vous une assurance :", Color.ORANGE,"oui ", "non");

          JPanel dateDepartPanel = Panel.datePanel("date de depart :", Color.ORANGE);
          JPanel dateRetourPanel = Panel.datePanel("date de retour :", Color.ORANGE);

          JPanel listePanel = Panel.listePanel(Color.ORANGE);
          JPanel liste = Panel.checkBoxPanel(Panel.listeAutoMoto(Color.ORANGE),listeVehicule());

          fenetrePanel.add(titrePanel);
          fenetrePanel.add(identifiantPanel);
          fenetrePanel.add(adressePanel);
          fenetrePanel.add(choixPanel);
          fenetrePanel.add(modelPanel);
          fenetrePanel.add(dateDepartPanel);
          fenetrePanel.add(dateRetourPanel);
          fenetrePanel.add(assurancePanel);
          fenetrePanel.add(liste);
          fenetrePanel.add(listePanel);


          locationFrame.add(donnee);
          locationFrame.setVisible(true);
      }
    public static ArrayList<Vehicule> listeVehicule (){
        ArrayList<Vehicule> liste =new ArrayList<>();
        liste.add(auto);
        liste.add(auto2);
        liste.add(auto3);
        liste.add(moto);
        return liste;
    }

}
