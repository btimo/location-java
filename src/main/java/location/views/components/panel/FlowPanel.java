package location.views.components.panel;

import javax.swing.*;
import java.awt.*;

public class FlowPanel extends JPanel {

    public FlowPanel(){
        super();
        setLayout(new FlowLayout());
    }

    public FlowPanel(Color bgColor){
        super();
        setLayout(new FlowLayout());
        setBackground(bgColor);
    }
}
