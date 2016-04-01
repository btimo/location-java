package views.components.panel;

import views.Bouton;
import views.components.misc.Label;

import javax.swing.*;
import java.awt.*;

public class TwoRadioPanel extends FlowPanel {

    private Label label;

    private JRadioButton btn1;
    private JRadioButton btn2;
    private ButtonGroup btnGroup;

    public TwoRadioPanel(Color bgColor, String nom){
        super(bgColor);
        initTwoRadioPanel(bgColor, nom, "Oui", "Non");
    }

    public TwoRadioPanel(Color bgColor, String nom, String btn1Text, String btn2Text ){
        super(bgColor);
        initTwoRadioPanel(bgColor, nom, btn1Text, btn2Text);
    }

    private void initTwoRadioPanel(Color bgColor, String nom, String btn1Text, String btn2Text){
        label = new Label(nom);

        btn1 = Bouton.radioBouton(btn1Text, true, bgColor);
        btn2 = Bouton.radioBouton(btn2Text, false, bgColor);

        btnGroup = new ButtonGroup();
        btnGroup.add(btn1);
        btnGroup.add(btn2);
        add(label);
        add(btn1);
        add(btn2);
    }
}
