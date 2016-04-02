package location.views.components.panel;

import location.views.components.misc.CustomFontLabel;
import location.views.components.misc.DateLabelFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

/**
 * Panneau de la date
 * @author Timothée Barbot
 * @author Stéphane Gâteau
 */
public class DatePanel extends FlowPanel{

    /**
     * Constructeur par défaut
     */
    public DatePanel(){
        super();
    }

    /**
     * Constructeur complet
     * @param bgColor couleur de fond
     * @param nom nom de la date
     */
    public DatePanel(Color bgColor, String nom){
        super(bgColor);
        initDatePanel(nom);
    }

    /**
     * Initialisation
     * @param nom nom de la date
     */
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
