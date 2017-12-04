package entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Verwaltet die Daten eines Schülers
 * @author java@htl-leonding
 */
public class Pupil {

    private int number;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String zipCode;
    private String city;
    private String address;

    public Pupil(String line){
        try {
            String[] elements = line.split(";");
            int code = elements[0].charAt(0);
            setNumber(Integer.parseInt(elements[0]));
            setLastName(elements[1]);
            setFirstName(elements[2]);
            SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            Date date = df.parse(elements[3]);
            setBirthDate(date);
            setZipCode(elements[4]);
            setCity(elements[5]);
            setAddress(elements[6]+" "+elements[7]);
        } catch (ParseException ex) {
            Logger.getLogger(Pupil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getNumber() {
        return number;
    }

    public final void setNumber(int number) {
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public final void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public final void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public final void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getZipCode() {
        return zipCode;
    }

    public final void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public final void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public final void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return String.format("%2d %-15s %-15s %s %-25s", getNumber(), getLastName(), getFirstName(), sdf.format(getBirthDate()), getCity());
    }
    
}