/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class PatientTest {

    public PatientTest() {
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

    /**
     * Test of compareTo method, of class Patient. Equal.
     */
    @Test
    public void testCompareTo_Equal() {
        System.out.println("compareTo");
        Date date = new Date();
        Patient p = new Patient("Max Mustermann",date,false);
        Patient instance = new Patient("Max Mustermann",date,false);
        int expResult = 0;
        int result = instance.compareTo(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testCompareTo_otherEarlier() {
        System.out.println("compareTo");
        Date date = new Date();
        Patient other = new Patient("Max Mustermann",new Date(date.getTime()-100),false);
        Patient instance = new Patient("Max Mustermann",date,false);
        int expResult = 1;
        int result = instance.compareTo(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testCompareTo_otherLater() {
        System.out.println("compareTo");
        Date date = new Date();
        Patient other = new Patient("Max Mustermann",new Date(date.getTime()+100),false);
        Patient instance = new Patient("Max Mustermann",date,false);
        int expResult = -1;
        int result = instance.compareTo(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testCompareTo_otherIsEmergency() {
        System.out.println("compareTo");
        Date date = new Date();
        Patient other = new Patient("Max Mustermann",new Date(date.getTime()+100),true);
        Patient instance = new Patient("Max Mustermann",date,false);
        int expResult = 1;
        int result = instance.compareTo(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testCompareTo_weAreIsEmergency() {
        System.out.println("compareTo");
        Date date = new Date();
        Patient other = new Patient("Max Mustermann",new Date(date.getTime()-100),false);
        Patient instance = new Patient("Max Mustermann",date,true);
        int expResult = -1;
        int result = instance.compareTo(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testCompareTo_bothAreEmergency() {
        System.out.println("compareTo");
        Date date = new Date();
        Patient other = new Patient("Max Mustermann",new Date(date.getTime()+100),true);
        Patient instance = new Patient("Max Mustermann",date,true);
        int expResult = -1;
        int result = instance.compareTo(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    /**
     * Test of toString method, of class Patient.
     */
    @Test
    public void testToString() throws ParseException {
        System.out.println("toString");
        String strdate = "2017-10-09 16:57";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date = sdf.parse(strdate);
        Patient instance = new Patient("Max Mustermann",date,false);
        String expResult = "09.10.17 16:57 Max Mustermann";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    @Test
    public void testToString_anonym() throws ParseException {
        System.out.println("toString");
        String strdate = "2017-10-09 16:57";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date = sdf.parse(strdate);
        Patient instance = new Patient("Max Mustermann",date,true);
        String expResult = "** Notfall! ** Max Mustermann";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}