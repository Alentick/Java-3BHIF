
import java.text.DateFormat;
import java.util.*;

/**
 * @author java@htl-leonding
 */
public class Patient implements Comparable<Patient>{

    private final String name;
    private final Date termin;
    private final boolean emergency;

    Patient(String name, Date termin, boolean emergency) {
        this.name = name;
        this .termin = termin;
        this.emergency = emergency;
    }

    public String getName() {
        return name;
    }

    public Date getTermin() {
        return termin;
    }

    public boolean isEmergency() {
        return emergency;
    }

    @Override
    public String toString() {
        if(emergency){
            return "** Notfall! ** " + this.name;
        } else {
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,Locale.GERMANY);
            DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT,Locale.GERMANY);
            return df.format(this.termin) + " " + tf.format(this.termin) + " " + this.name;
        }
            
            
    }

    @Override
    public int compareTo(Patient other) {
        if(this.emergency && other.emergency){
            return this.getTermin().compareTo(other.getTermin()); 
        }
        if(this.emergency)
            return -1;
        if(other.emergency)
            return 1;
        
        return this.getTermin().compareTo(other.getTermin());    
    }
}


