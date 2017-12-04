package schoolclass;

import java.util.Date;
import java.util.Objects;

public class Pupil implements Comparable<Pupil> {
    
    private String lastName;
    private String firstName;
    private Date birthDate;
    private City city;
    private String address;

    public Pupil(String lastName, String firstName, Date birthDate, City city, String address) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.city = city;
        this.address = address;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public City getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.lastName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pupil other = (Pupil) obj;
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.birthDate, other.birthDate)) {
            return false;
        }
        return true;
    }

    
    /**
     * Vergleich nach dem Alter (Ältester zuerst)
     * @param other
     * @return 
     */
    @Override
    public int compareTo(Pupil other) {
        return birthDate.compareTo(other.birthDate);
    }

    @Override
    public String toString() {
        return "Pupil{" + "lastName=" + lastName + ", firstName=" + firstName + ", birthDate=" + birthDate + ", city=" + city + ", address=" + address + '}';
    }
    
    
    
    
    
}
