package location.views.components.panel;

import location.views.components.misc.CustomFontLabel;
import location.views.components.misc.DateLabelFormatter;
import org.jdatepicker.DateModel;
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

    private java.util.Date date;

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
     * @param d date au format java.util.Date
     */
    public DatePanel(Color bgColor, String nom, java.util.Date d){
        super(bgColor);
        date = d;

        initDatePanel(nom);
    }

    /**
     * Initialisation
     * @param nom nom de la date
     */
    private void initDatePanel(String nom) {
        JLabel departLabel = new CustomFontLabel(nom);

        /*
        LocalDate ld = LocalDate.now();
        Instant instant = ld.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        java.util.Date res = java.util.Date.from(instant);
        */

        UtilDateModel model = new UtilDateModel(date);
        Properties p = new Properties();
        p.put("text.today", "Auj.");
        p.put("text.month", "Mois");
        p.put("text.year", "Annee");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        add(departLabel);
        add(datePicker);

        datePicker.addActionListener(e -> {
            DateModel t = ((JDatePanelImpl)e.getSource()).getModel();
            date = new java.util.Date(t.getYear() - 1900, t.getMonth(), t.getDay());
            //System.out.println("changed: " + date);
        });
    }

    public java.util.Date getDate() {
        return date;
    }
}
