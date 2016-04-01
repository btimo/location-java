package views.components.misc;

import containers.Vehicules;
import models.Auto;
import models.Moto;
import models.Vehicule;
import views.LocationViews;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel {
    protected static JRadioButton premierButton = Bouton.radioBouton("oui",false,Color.ORANGE);
    protected static JRadioButton deuxButton = Bouton.radioBouton("non",true,Color.ORANGE);

    /**
     * Simple panel with color background parameter
     * @param bgColor, color of the panel background
     * @return JPanel
     */
    public static JPanel nvPanelBox(Color bgColor) {
        JPanel panelBox = new JPanel();

        panelBox.setLayout(new BoxLayout(panelBox, BoxLayout.Y_AXIS));
        panelBox.setBackground(bgColor);

        return panelBox;

    }

    /**
     * Simple panel with flowLayout and background color as parameter
     * @param bgColor, color of the background
     * @return JPanel
     */
    public static JPanel nvPanelFlow(Color bgColor) {
        JPanel panelFlow = new JPanel();

        panelFlow.setLayout(new FlowLayout());
        panelFlow.setBackground(bgColor);

        return panelFlow;
    }

    /**
     * Panel containing identification labels and fields
     * @param bgColor, background color
     * @return JPanel
     */
    /*public static JPanel identification(Color bgColor) {
        JPanel identifiantPanel = nvPanelFlow(bgColor);

        JLabel nomLabel = views.components.misc.Label.nvLabel("Nom et prénom : ");
        JTextField nomTexte = Texte.nvTextField(" Nom", 10);
        JTextField prenomTexte = Texte.nvTextField(" Prénom", 10);

        identifiantPanel.add(nomLabel);
        identifiantPanel.add(nomTexte);
        identifiantPanel.add(prenomTexte);

        return identifiantPanel;
    }*/

    /**
     * Panel containing adresse labels and fields
     * @param bgColor, background color
     * @return JPanel
     */
    /*public static JPanel adresse(Color bgColor){
        JPanel adressePanel = nvPanelFlow(bgColor);

        JLabel adresseLabel = Label.nvLabel("Adresse :");
        JTextField numeroTexte = Texte.nvTextField("5",3);
        JTextField rueTexte = Texte.nvTextField("rue",13);
        JTextField codeTexte = Texte.nvTextField("CP",5);
        JTextField villeTexte = Texte.nvTextField("ville",5);

        adressePanel.add(adresseLabel);
        adressePanel.add(numeroTexte);
        adressePanel.add(rueTexte);
        adressePanel.add(codeTexte);
        adressePanel.add(villeTexte);

        return adressePanel;
    }*/

    /**
     * ComboBox to select
     * @param bgColor, background color
     * @return
     */
    public static JComboBox listeAutoMoto(Color bgColor, boolean firstLauch){
        JComboBox comboBox = new JComboBox();
        JPanel checkBoxrecap= nvPanelBox(Color.ORANGE);
        //JTable tableauRecap = Tableau.tableau();
        ArrayList<String> marques = new ArrayList<>();
        premierButton.addActionListener(e -> {
            marques.clear();
            for(Vehicule v : Vehicules.get()) {
                if (v instanceof Auto) {
                    marques.add(v.getMarque() + " " + ((Auto) v).getModele());
                }
            }
            comboBox.setModel(new DefaultComboBoxModel(marques.toArray()));
        });
        deuxButton.addActionListener(e -> {
            marques.clear();
            for(Vehicule v : Vehicules.get()) {
                if (v instanceof Moto) {
                    marques.add(v.getMarque() + " " + ((Moto) v).getCylindree());
                }
            }
            comboBox.setModel(new DefaultComboBoxModel(marques.toArray()));
        });
        checkBoxrecap.add(comboBox);
        //tableauRecap.add(comboBox.getSelectedItem());
        //checkBoxrecap.add(tableauRecap);

        if (firstLauch) {
            for(Vehicule v : Vehicules.get()) {
                if (v instanceof Auto) {
                    marques.add(v.getMarque() + " " + ((Auto) v).getModele());
                }
            }
            comboBox.setModel(new DefaultComboBoxModel(marques.toArray()));
        }

        return comboBox;
    }

    /*public static JPanel choixPanel(String nom, Color couleur, String nomBouton1, String nomBouton2){
        JPanel panel = nvPanelFlow(couleur);
        JLabel label = Label.nvLabel(nom);
        ArrayList<JRadioButton> boutonListe = new ArrayList();
        premierButton = Bouton.radioBouton(nomBouton1,true,couleur);
        deuxButton = Bouton.radioBouton(nomBouton2,false,couleur);
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
    }*/

    public static JPanel listePanel(Color couleur) {

        JPanel ajoutOnglet = nvPanelFlow(couleur);
        JButton nouveau = new JButton("Valider");
        JPanel fenetrePanel = Panel.nvPanelBox(Color.ORANGE);

        nouveau.addActionListener(e -> {
            LocationViews.tabs.add("Liste des voitures", fenetrePanel);
            LocationViews.locationFrame.add(LocationViews.tabs);
        });
        ajoutOnglet.add(nouveau);
        return ajoutOnglet;
    }

    /*public static JPanel checkBoxPanel(JComboBox comboBox, Vehicule vehicules){
        JPanel comboPanel = nvPanelBox(Color.ORANGE);
        comboBox.addActionListener(e -> {
                JCheckBox check = Bouton.nvCheckbox(vehicules);
                comboPanel.add(check);
            });
        return  comboPanel;
    }*/

   // public static JPanel

    public static JCheckBox addCheckbox(String message) {
        JCheckBox checkbox = new JCheckBox(message);
        checkbox.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        return checkbox;
    }
}