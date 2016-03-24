package views;

import javax.swing.*;

/**
 * Created by sgate on 23/03/2016.
 */
public class Texte {
    public static JTextField nvTextField(String texte, int longeur){
        JTextField textField =new JTextField(texte,longeur);
        return textField;
    }
}
