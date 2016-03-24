package views;

import containers.Vehicules;
import models.Auto;
import models.Date;
import models.Moto;
import models.Vehicule;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Properties;

/**
 * Created by sgate on 23/03/2016.
 */
public class Panel {
    protected static JRadioButton premierButton =Bouton.radioBouton("oui",false,Color.ORANGE);
    protected static JRadioButton deuxButton =Bouton.radioBouton("non",true,Color.ORANGE);


    public static JPanel nvPanelBox(Color couleur) {
        JPanel panelBox = new JPanel();
        panelBox.setLayout(new BoxLayout(panelBox, BoxLayout.Y_AXIS));
        panelBox.setBackground(couleur);
        return panelBox;

    }

    public static JPanel nvPanelFlow(Color couleur) {
        JPanel panelFlow = new JPanel();
        panelFlow.setLayout(new FlowLayout());
        panelFlow.setBackground(couleur);
        return panelFlow;
    }

    public static JPanel identification(Color couleur) {
        JPanel identifiantPanel = nvPanelFlow(couleur);
        JLabel nomLabel = Label.nvLabel("nom et prenom :");
        JTextField nomTexte = Texte.nvTextField(" nom", 10);
        JTextField prenomTexte = Texte.nvTextField(" prenom", 10);
        identifiantPanel.add(nomLabel);
        identifiantPanel.add(nomTexte);
        identifiantPanel.add(prenomTexte);
        return identifiantPanel;
    }

    public static JPanel adresse(Color couleur){
        JPanel adressePanel = nvPanelFlow(couleur);
        JLabel adresseLabel = Label.nvLabel("Adresse :");
        JTextField numeroTexte= Texte.nvTextField("5",3);
        JTextField rueTexte = Texte.nvTextField("rue",13);
        JTextField codeTexte = Texte.nvTextField("CP",5);
        JTextField villeTexte = Texte.nvTextField("ville",5);
        adressePanel.add(adresseLabel);
        adressePanel.add(numeroTexte);
        adressePanel.add(rueTexte);
        adressePanel.add(codeTexte);
        adressePanel.add(villeTexte);
        return adressePanel;
    }

    public static JComboBox listeAutoMoto(Color couleur){
        JComboBox liste1 = new JComboBox();
        ArrayList<String> marques = new ArrayList<>();
        premierButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                marques.clear();
                for(Vehicule v : Vehicules.get()) {
                    if (v instanceof Auto) {
                        marques.add(v.getMarque() + " " + ((Auto) v).getModele());

                    }
                }
                liste1.setModel(new DefaultComboBoxModel(marques.toArray()));
            }
        });
        deuxButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                marques.clear();
                for(Vehicule v : Vehicules.get()) {
                    if (v instanceof Moto) {
                        marques.add(v.getMarque() + " " + ((Moto) v).getCylindree());
                    }
                }
                liste1.setModel(new DefaultComboBoxModel(marques.toArray()));
            }
        });

        return liste1;
    }

    public static JPanel choixPanel(String nom, Color couleur,String nomBouton1,String nomBouton2){
        JPanel panel =nvPanelFlow(couleur);
        JLabel label =Label.nvLabel(nom);
        ArrayList<JRadioButton> boutonListe= new ArrayList();
        premierButton =Bouton.radioBouton(nomBouton1,false,couleur);
        deuxButton =Bouton.radioBouton(nomBouton2,true,couleur);
        boutonListe.add(premierButton);
        boutonListe.add(deuxButton);
        ButtonGroup groupe = Bouton.nvgroupeButton(boutonListe);
        panel.add(label);
        panel.add(premierButton);
        panel.add(deuxButton);
        return panel;
    }

public static JPanel datePanel(String nom, Color couleur) {
    JPanel datePanel = nvPanelFlow(couleur);
    JLabel departLabel = Label.nvLabel(nom);
    UtilDateModel model = new UtilDateModel();
    Properties p = new Properties();
    JDatePanelImpl dateDepart = new JDatePanelImpl(model, p);
    JDatePickerImpl dateDepartPicker = new JDatePickerImpl(dateDepart, new DateLabelFormatter());
    datePanel.add(departLabel);
    datePanel.add(dateDepartPicker);
    Date date = (Date) dateDepartPicker.getModel().getValue();
    return datePanel;
    }

    public static JPanel listePanel(Color couleur) {

        JPanel ajoutOnglet = nvPanelFlow(couleur);
        JButton nouveau = new JButton("Valider");
        JPanel fenetrePanel =Panel.nvPanelBox(Color.ORANGE);

        nouveau.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                LocationViews.donnee.add("liste des voiture",fenetrePanel);
                LocationViews.locationFrame.add(LocationViews.donnee);
            }
        });
        ajoutOnglet.add(nouveau);
        return ajoutOnglet;
    }
    public static JPanel checkBoxPanel(JComboBox comboBox, ArrayList<Vehicule> liste){
        JPanel comboPanel = nvPanelBox(Color.ORANGE);
        comboBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for (int i=0; i<liste.size();i++){
                JCheckBox check= Bouton.nvCheckbox(liste.get(i));
                comboPanel.add(check);
                }
            }
        });
        return  comboPanel;
    }
}