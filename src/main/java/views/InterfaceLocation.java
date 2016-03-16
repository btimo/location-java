package main.java.views;

import javax.swing.*;
import java.awt.*;


public class InterfaceLocation {
    public static void main(String[] args) {
        JFrame locationFrame = new JFrame();
        locationFrame.setTitle("Location de vehicule auto/moto");
        locationFrame.setSize(400,300);
        JPanel fenetrePanel =new JPanel();
        fenetrePanel.setLayout(new FlowLayout());
        fenetrePanel.setBackground(Color.ORANGE);

        locationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel reservationLabel = new JLabel("Reservation de vehicule");
        Font f = new Font("Calibri", Font.PLAIN, 36);
        reservationLabel.setFont(f);

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
        departPanel.setLayout(new BorderLayout(1,2));
        JLabel departLabel = new JLabel("Depart :");
        Font fontDepart = new Font("Arial", Font.BOLD, 14);
        departLabel.setFont(fontDepart);
        JLabel constructeurModelLabel =new JLabel("constructeur et le model :");
        Object[] elements = new Object[]{"Peugeot", "Renaud", "Opel", "Audi","Mercedes"};
        JComboBox liste1 = new JComboBox(elements);


        JTextField modelText = new JTextField("salisir le modele",10);
        /*calendrier*/
        departPanel.add(departLabel,BorderLayout.NORTH);
        departPanel.add(constructeurModelLabel,BorderLayout.WEST);
        departPanel.add(liste1,BorderLayout.CENTER);
        departPanel.add(modelText,BorderLayout.EAST);


        JPanel retourPanel =new JPanel();
        retourPanel.setBackground(Color.ORANGE);
        retourPanel.setLayout(new BorderLayout(1,2));
        JLabel retourLabel = new JLabel("Retour :");
        Font fontRetour = new Font("Arial", Font.BOLD, 14);
        retourLabel.setFont(fontRetour);
        JCheckBox retourBox = new JCheckBox("Retour a la station de depart");
        retourBox.setBackground(Color.ORANGE);
        /*calendier*/
        retourPanel.add(retourLabel,BorderLayout.NORTH);
        retourPanel.add(retourBox,BorderLayout.EAST);

        JButton calculButton =new JButton("calculer le devis");

        fenetrePanel.add(reservationLabel);
        fenetrePanel.add(choixPanel);
        fenetrePanel.add(departPanel);
        fenetrePanel.add(retourPanel);
        fenetrePanel.add(calculButton);

        locationFrame.add(fenetrePanel);



        locationFrame.setVisible(true);
    }
}
