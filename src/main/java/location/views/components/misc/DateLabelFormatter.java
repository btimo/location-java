package location.views.components.misc;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Formattage du label de Date
 * @author Timothée Barbot
 */
public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {

    private String datePattern = "yyyy-MM-dd";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    /**
     * Surcharge de stringToValue
     * Conversion de string en valeur valide
     * @param text texte à parser
     * @return objet correctement parsé
     * @throws ParseException si erreur sur le texte à parser
     */
    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }

    /**
     * Surcharge de valueToString
     * @param value valeur à convertire
     * @return valeur convertie en texte
     * @throws ParseException si erreur sur l'objet à convertir
     */
    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }

        return "";
    }

}