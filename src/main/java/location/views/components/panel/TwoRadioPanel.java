package location.views.components.panel;

import location.views.components.misc.Bouton;

import javax.swing.*;
import java.awt.*;

public class TwoRadioPanel extends FlowPanel {

    private JLabel groupLabel;

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
        groupLabel = new JLabel(nom);

        btn1 = Bouton.radioBouton(btn1Text, true, bgColor);
        btn2 = Bouton.radioBouton(btn2Text, false, bgColor);

        btnGroup = new ButtonGroup();
        btnGroup.add(btn1);
        btnGroup.add(btn2);
        add(groupLabel);
        add(btn1);
        add(btn2);
    }

    public ButtonGroup getBtnGroup() {
        return btnGroup;
    }

    public void setBtnGroup(ButtonGroup btnGroup) {
        this.btnGroup = btnGroup;
    }

    public JRadioButton getBtn1() {
        return btn1;
    }

    public void setBtn1(JRadioButton btn1) {
        this.btn1 = btn1;
    }

    public JRadioButton getBtn2() {
        return btn2;
    }

    public void setBtn2(JRadioButton btn2) {
        this.btn2 = btn2;
    }
}
