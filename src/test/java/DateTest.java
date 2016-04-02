import location.models.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Test de date
 */
public class DateTest {

    private Date date1;
    private Date date2;


    @Before
    public void testInit(){
        date1 = new Date(1, 1, 2016);
        date2 = new Date(1, "Février", 2016);
    }


    @Test
    public void daysBetweenShouldReturn31(){
        assertEquals("Nombre de jours entre " + date1 + " et " + date2 + " doit être 31", -31, date1.daysBetween(date2));
    }
}
