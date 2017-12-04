/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gerald
 */
public class WaitingRoomTest {

    public WaitingRoomTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSimple() {
        WaitingRoom wz = new WaitingRoom();
        Calendar c = Calendar.getInstance(Locale.GERMANY);
        c.set(2009, Calendar.OCTOBER, 21, 9, 15);
        wz.comesIn(new Patient("Antonia Adam", c.getTime(), false));
        c.set(2009, Calendar.OCTOBER, 21, 9, 30);
        wz.comesIn(new Patient("Bert Bauer", c.getTime(), false));
        Patient patient = wz.getNextPatient();
        assertEquals("Antonia Adam", patient.getName());
    }

    @Test
    public void testNormal() {
        WaitingRoom wz = new WaitingRoom();
        Calendar c = Calendar.getInstance(Locale.GERMANY);
        c.set(2009, Calendar.OCTOBER, 21, 9, 15);
        wz.comesIn(new Patient("Antonia Adam", c.getTime(), false));
        c.set(2009, Calendar.OCTOBER, 21, 9, 30);
        wz.comesIn(new Patient("Bert Bauer", c.getTime(), false));
        c.set(2009, Calendar.OCTOBER, 21, 8, 30);
        wz.comesIn(new Patient("Cäcilia Chlum", c.getTime(), false));
        Patient patient = wz.getNextPatient();
        assertEquals("Cäcilia Chlum", patient.getName());
    }


    @Test
    public void testWithEmergency() {
        WaitingRoom wz = new WaitingRoom();
        Calendar c = Calendar.getInstance(Locale.GERMANY);
        c.set(2009, Calendar.OCTOBER, 21, 9, 15);
        wz.comesIn(new Patient("Antonia Adam", c.getTime(), false));
        c.set(2009, Calendar.OCTOBER, 21, 9, 30);
        wz.comesIn(new Patient("Bert Bauer", c.getTime(), false));
        wz.comesIn(new Patient("anonym", new Date(), true));
        c.set(2009, Calendar.OCTOBER, 21, 8, 30);
        wz.comesIn(new Patient("Cäcilia Chlum", c.getTime(), false));
        Patient patient = wz.getNextPatient();
        assertEquals("anonym", patient.getName());
    }

    @Test
    public void testWith2ndEmergency() {
        WaitingRoom wz = new WaitingRoom();
        Calendar c = Calendar.getInstance(Locale.GERMANY);
        c.set(2009, Calendar.OCTOBER, 21, 9, 15);
        wz.comesIn(new Patient("Erster Notfall", c.getTime(), true));
        c.set(2009, Calendar.OCTOBER, 21, 9, 30);
        wz.comesIn(new Patient("Bert Bauer", c.getTime(), false));
        wz.comesIn(new Patient("anonym", new Date(), true));
        c.set(2009, Calendar.OCTOBER, 21, 8, 30);
        wz.comesIn(new Patient("Cäcilia Chlum", c.getTime(), false));
        Patient patient = wz.getNextPatient();
        assertEquals("Erster Notfall", patient.getName());
    }

    @Test
    public void testWithEmptyWaitingRoom() {
        WaitingRoom wz = new WaitingRoom();
        Patient patient = wz.getNextPatient();
        assertNull(patient);
    }

}