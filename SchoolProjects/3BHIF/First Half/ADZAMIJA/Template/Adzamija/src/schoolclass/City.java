package schoolclass;

import java.util.Objects;

/**
 * Verwaltet die Daten einer City.
 * Ist vergleichbar und auch per equals überprüfbar
 * Beim Vergleich wird zuerst nach dem Namen und bei gleichem
 * Namen nach der PLZ (beides ausfsteigend) sortiert.
 * Equals liefert true, wenn sowohl der Name der Stadt als auch
 * die PLZ übereinstimmen.
 */
public class City implements Comparable<City>{
    
    private final String zipCode;
    private final String name;

    public City(String zipCode, String name) {
        this.zipCode=zipCode;
        this.name=name;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.zipCode);
        hash = 89 * hash + Objects.hashCode(this.name);
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
        final City other = (City) obj;
        if (!Objects.equals(this.zipCode, other.zipCode)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "City{" + "zipCode=" + zipCode + ", name=" + name + '}';
    }

    //TODO compareTo überschrieben
    @Override
    public int compareTo(City o) {
        int result = getName().compareTo(o.getName());
        if (result==0) {  // Namen sind gleich
            return getZipCode().compareTo(o.getZipCode());
        }
        else{
            return result;
        }
    }
}
          
    
