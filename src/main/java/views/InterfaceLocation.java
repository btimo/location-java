package main.java.views;


import main.java.models.Auto;
import main.java.models.Moto;
import main.java.models.Vehicule;
import main.java.models.Vehicules;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class InterfaceLocation {
    public static void main(String[] args) {
        JFrame locationFrame = new JFrame();
        locationFrame.setTitle("Location de vehicule auto/moto");
        locationFrame.setSize(400,300);
        locationFrame.setResizable(false);
        JPanel fenetrePanel =new JPanel();
        fenetrePanel.setLayout(new FlowLayout());
        fenetrePanel.setBackground(Color.ORANGE);

        locationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel reservationLabel = new JLabel("Reservation de vehicule");
        Font f = new Font("Calibri", Font.PLAIN, 36);
        reservationLabel.setFont(f);

        JPanel identifiantPanel =new JPanel();
        identifiantPanel.setBackground(Color.ORANGE);
        identifiantPanel.setLayout(new BorderLayout());
        JLabel nomLabel= new JLabel("Nom et prenom:");
        JTextField nomTexte = new JTextField("saisir votre nom");
        JTextField prenomTexte =new JTextField("saisir votre prenom");
        identifiantPanel.add(nomLabel,BorderLayout.WEST);
        identifiantPanel.add(nomTexte, BorderLayout.CENTER);
        identifiantPanel.add(prenomTexte, BorderLayout.EAST);

        JPanel adressePanel = new JPanel();
        adressePanel.setBackground(Color.ORANGE);
        adressePanel.setLayout(new BorderLayout());


        JPanel choixPanel =new JPanel();
        choixPanel.setBackground(Color.ORANGE);
        choixPanel.setLayout(new FlowLayout());
        ButtonGroup autoMotoGroupe = new ButtonGroup();
        JRadioButton autoButton =new JRadioButton("louer une auto",false);
        autoButton.setBackground(Color.ORANGE);

        JRadioButton motoButton =new JRadioButton("louer une moto",false);
        motoButton.setBackground(Color.ORANGE);
        autoMotoGroupe.add(autoButton);
        autoMotoGroupe.add(motoButton);
        choixPanel.add(autoButton);
        choixPanel.add(motoButton);


        JPanel departPanel =new JPanel();
        departPanel.setBackground(Color.ORANGE);
        departPanel.setLayout(new BorderLayout());
        JLabel departLabel = new JLabel("Depart :");
        Font fontDepart = new Font("Arial", Font.BOLD, 14);
        departLabel.setFont(fontDepart);
        JLabel constructeurModelLabel =new JLabel("constructeur et le model :");

        Auto auto = new Auto("Ford", "Fiesta", 200,0,false);
        System.out.println(auto);
        Auto auto2 = new Auto("Dacia", "Sandero", 200,0,true);
        System.out.println(auto2);
        Auto auto3 = new Auto("Audi", "A1", 500,0,false);
        Moto moto = new Moto("Harley Davidson", 300, 200);
        System.out.println(auto3);

        JComboBox liste1 = new JComboBox();
        ArrayList<String> marques = new ArrayList<>();
        autoButton.addActionListener(new ActionListener() {
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
        motoButton.addActionListener(new ActionListener() {
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
        /*calendrier*/
        departPanel.add(departLabel,BorderLayout.NORTH);
        departPanel.add(liste1,BorderLayout.CENTER);
        departPanel.add(constructeurModelLabel,BorderLayout.WEST);

        JPanel retourPanel =new JPanel();
        retourPanel.setBackground(Color.ORANGE);
        retourPanel.setLayout(new BorderLayout());
        JLabel retourLabel = new JLabel("Retour :");
        Font fontRetour = new Font("Arial", Font.BOLD, 14);
        retourLabel.setFont(fontRetour);
        JCheckBox retourBox = new JCheckBox("Retour a la station de depart");
        retourBox.setBackground(Color.ORANGE);
        /*calendier*/
        retourPanel.add(retourLabel,BorderLayout.NORTH);
        retourPanel.add(retourBox,BorderLayout.EAST);

        JButton calculButton =new JButton("calculer le devis");
        calculButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        fenetrePanel.add(reservationLabel);
        fenetrePanel.add(identifiantPanel);
        fenetrePanel.add(choixPanel);
        fenetrePanel.add(departPanel);
        fenetrePanel.add(retourPanel);
        fenetrePanel.add(calculButton);

        locationFrame.add(fenetrePanel);

        locationFrame.setVisible(true);
    }
}
