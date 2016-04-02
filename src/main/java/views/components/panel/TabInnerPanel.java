package views.components.panel;

import javax.swing.*;
import java.awt.*;


public class TabInnerPanel extends JPanel {

    public TabInnerPanel(Color bgColor) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(bgColor);
    }

}
