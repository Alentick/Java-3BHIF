import org.junit.Test;
import static org.junit.Assert.*;
import schoolclass.City;

/**
 *  CityTests prüfen, ob equals und Comparable korrekt implementiert
 *  wurden.
 */
public class CityTest {
    
    @Test
    public void equals_identicalCities_ShouldBeEqual(){
        City city = new City("4060", "Leonding");
        City otherCity = city;
        assertEquals(city, otherCity);
    }
    
    @Test
    public void equals_equalCityNameAndEqualZipCode_ShouldBeEqual(){
        City city = new City("4060", "Leonding");
        City otherCity = new City("4060", "Leonding");
        assertEquals(city, otherCity);
    }
    
    @Test
    public void equals_differentCityNameAndEqualZipCode_ShouldNotBeEqual(){
        City city = new City("4060", "Leonding");
        City otherCity = new City("4060", "Linz");
        assertNotEquals(city, otherCity);
    }
    
        
    @Test
    public void equals_equalCityNameAndDifferentZipCode_ShouldNotBeEqual(){
        City city = new City("4060", "Leonding");
        City otherCity = new City("4020", "Leonding");
        assertNotEquals(city, otherCity);
    }

    @Test
    public void equals_differentCityNameAndDifferentZipCode_ShouldNotBeEqual(){
        City city = new City("4060", "Leonding");
        City otherCity = new City("4020", "Linz");
        assertNotEquals(city, otherCity);
    }

    @Test
    public void compareTo_equalCity_ShouldBe0(){
        City city = new City("4060", "Leonding");
        City otherCity = new City("4060", "Leonding");
        assertEquals(0, city.compareTo(otherCity));
    }
    
    @Test
    public void compareTo_equalCityNameLowerZipCode_ShouldBeNegative(){
        City city = new City("4020", "Linz");
        City otherCity = new City("4060", "Linz");
        assertTrue(city.compareTo(otherCity) <0);
    }
    
    @Test
    public void compareTo_equalCityNameHigherZipCode_ShouldBePositive(){
        City city = new City("4060", "Linz");
        City otherCity = new City("4020", "Linz");
        assertTrue(city.compareTo(otherCity) > 0);
    }
    
    @Test
    public void compareTo_lowerCityName_ShouldBeNegative(){
        City city = new City("4060", "Leonding");
        City otherCity = new City("4020", "Linz");
        assertTrue(city.compareTo(otherCity) <0);
    }
    
    @Test
    public void compareTo_higherCityName_ShouldBePositive(){
        City city = new City("4020", "Linz");
        City otherCity = new City("4060", "Leonding");
        assertTrue(city.compareTo(otherCity) > 0);
    }
    
}
