package main.java.views;


import main.java.models.*;

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

        JPanel fenetrePanel =new JPanel();
        Container container = locationFrame.getContentPane();
        fenetrePanel.setLayout(new BoxLayout(fenetrePanel, BoxLayout.Y_AXIS));


        fenetrePanel.setBackground(Color.ORANGE);

        locationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel titrePanel = new JPanel();
        titrePanel.setLayout(new FlowLayout());
        titrePanel.setBackground(Color.ORANGE);
        JLabel reservationLabel = new JLabel("Reservation de vehicule :");
        Font f = new Font("Calibri", Font.PLAIN, 25);
        reservationLabel.setFont(f);
        titrePanel.add(reservationLabel);

        JPanel identifiantPanel =new JPanel();
        identifiantPanel.setBackground(Color.ORANGE);
        identifiantPanel.setLayout(new FlowLayout());
        JLabel nomLabel= new JLabel("Nom et prenom:");
        JTextField nomTexte = new JTextField(" nom",10);
        JTextField prenomTexte =new JTextField(" prenom",10);
        identifiantPanel.add(nomLabel);
        identifiantPanel.add(nomTexte);
        identifiantPanel.add(prenomTexte);

        JPanel adressePanel = new JPanel();
        adressePanel.setBackground(Color.ORANGE);
        adressePanel.setLayout(new FlowLayout());
        JLabel adresseLabel = new JLabel("Adresse :");
        JTextField numeroTexte = new JTextField("5",3);
        JTextField rueTexte = new JTextField("rue",13);
        JTextField codeTexte = new JTextField("94800",5);
        JTextField villeTexte = new JTextField("ville",5);
        adressePanel.add(adresseLabel);
        adressePanel.add(numeroTexte);
        adressePanel.add(rueTexte);
        adressePanel.add(codeTexte);
        adressePanel.add(villeTexte);

        int num = Integer.parseInt(numeroTexte.getText());
        int cp =Integer.parseInt(codeTexte.getText());
        Adresse adresse =new Adresse(num,rueTexte.getText(),cp,villeTexte.getText());
        Emprunteur personne = new Emprunteur(adresse,prenomTexte.getText(),nomTexte.getText());


        JPanel choixPanel =new JPanel();
        choixPanel.setBackground(Color.ORANGE);
        choixPanel.setLayout(new FlowLayout());
        JLabel louerLabel =new JLabel("Louer :");
        ButtonGroup autoMotoGroupe = new ButtonGroup();
        JRadioButton autoButton =new JRadioButton(" une auto",false);
        autoButton.setBackground(Color.ORANGE);

        JRadioButton motoButton =new JRadioButton("une moto",false);
        motoButton.setBackground(Color.ORANGE);
        autoMotoGroupe.add(autoButton);
        autoMotoGroupe.add(motoButton);
        choixPanel.add(louerLabel);
        choixPanel.add(autoButton);
        choixPanel.add(motoButton);


        JPanel departPanel =new JPanel();
        departPanel.setBackground(Color.ORANGE);
        departPanel.setLayout(new FlowLayout());
        JLabel constructeurModelLabel = new JLabel("constructeur et le model :");
        Font fontDepart = new Font("Arial", Font.BOLD, 14);
        constructeurModelLabel.setFont(fontDepart);


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

        departPanel.add(constructeurModelLabel);
        departPanel.add(liste1);

        JPanel retourPanel =new JPanel();
        retourPanel.setBackground(Color.ORANGE);
        retourPanel.setLayout(new FlowLayout());
        JLabel assuranceLabel = new JLabel("Assurance :");
        Font fontRetour = new Font("Arial", Font.BOLD, 14);
        assuranceLabel.setFont(fontRetour);
        JLabel assurance =new JLabel("prendre une assurance:");
        ButtonGroup ouiNonAssurance = new ButtonGroup();
        JRadioButton ouiButton =new JRadioButton("oui");
        JRadioButton nonButton =new JRadioButton("non");
        ouiButton.setBackground(Color.ORANGE);
        nonButton.setBackground(Color.ORANGE);
        ouiNonAssurance.add(ouiButton);
        ouiNonAssurance.add(nonButton);


        /*calendier*/
        retourPanel.add(assuranceLabel);
        retourPanel.add(assurance);
        retourPanel.add(ouiButton);
        retourPanel.add(nonButton);

        JPanel devisPanel = new JPanel();
        devisPanel.setLayout(new FlowLayout());
        devisPanel.setBackground(Color.ORANGE);
        JButton calculButton =new JButton("calculer le devis");
        devisPanel.add(calculButton);
        calculButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });

        fenetrePanel.add(titrePanel);
        fenetrePanel.add(identifiantPanel);
        fenetrePanel.add(adressePanel);
        fenetrePanel.add(choixPanel);
        fenetrePanel.add(departPanel);
        fenetrePanel.add(retourPanel);
        fenetrePanel.add(devisPanel);

        locationFrame.add(fenetrePanel);

        locationFrame.setVisible(true);
    }
}
