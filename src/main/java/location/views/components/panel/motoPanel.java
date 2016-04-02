package location.views.components.panel;


import javax.swing.*;
import java.awt.*;

public class MotoPanel extends FlowPanel {

    private JTextField cylindreeTexte;

    public MotoPanel(){
        super();
        initMotoPanel();
    }

    public MotoPanel(Color bgColor){
        super(bgColor);
        initMotoPanel();
    }

    private void initMotoPanel(){
        JLabel cylindreeLabel = new JLabel("cylindree : ");
        cylindreeTexte = new JTextField("cylindree", 10);

        add(cylindreeLabel);
        add(cylindreeTexte);
    }

    public JTextField getCylindreeTexte() {
        return cylindreeTexte;
    }

    public void setCylindreeTexte(JTextField cylindreeTexte) {
        this.cylindreeTexte = cylindreeTexte;
    }
}
