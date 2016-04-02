package location.views.components.panel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import location.views.components.misc.DateLabelFormatter;
import location.views.components.misc.CustomFontLabel;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

public class DatePanel extends FlowPanel{

    public DatePanel(){
        super();
    }

    public DatePanel(Color bgColor, String nom){
        super(bgColor);
        initDatePanel(nom);
    }

    private void initDatePanel(String nom) {
        JLabel departLabel = new CustomFontLabel(nom);

        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        JDatePanelImpl dateDepart = new JDatePanelImpl(model, p);
        JDatePickerImpl dateDepartPicker = new JDatePickerImpl(dateDepart, new DateLabelFormatter());

        add(departLabel);
        add(dateDepartPicker);
        //Date date = (Date) dateDepartPicker.getModel().getValue();
    }
}
