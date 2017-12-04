import org.junit.Test;
import static org.junit.Assert.*;
import schoolclass.City;

/**
 *  CityTests prüfen, ob equals und Comparable korrekt implementiert
 * wurden.
 */
public class CityTest {
    
    @Test
    public void equals_identicalCities_ShouldBeEqual(){
        City city = new City("1234","Leonding");
        City city2 = city;
        assertEquals(true,city.equals(city2));
    }
    
    @Test
    public void equals_equalCitiyNameAndEqualZipCode_ShouldBeEqual(){
        City city1 = new City("1234","Leonding");
        City city2 = new City("1234","Leonding");
        assertEquals(true,city1.equals(city2));
    }
    
    @Test
    public void equals_differentCitiyNameAndEqualZipCode_ShouldNotBeEqual(){
        City city1 = new City("1234","Leonding");
        City city2 = new City("1234","Wien");
        assertEquals(false,city1.equals(city2));
    }
    
        
    @Test
    public void equals_equalCitiyNameAndDifferentZipCode_ShouldNotBeEqual(){
        City city1 = new City("1234","Leonding");
        City city2 = new City("2345","Leonding");
        assertEquals(false,city1.equals(city2));
    }

    @Test
    public void equals_differentCitiyNameAndDifferentZipCode_ShouldNotBeEqual(){
        City city1 = new City("1234","Leonding");
        City city2 = new City("2345","Wien");
        assertEquals(false,city1.equals(city2));
    }

    @Test
    public void compareTo_equalCity_ShouldBe0(){
        City city1 = new City("1234","Leonding");
        City city2 = new City("1234","Leonding");
        assertEquals(0,city1.compareTo(city2));
    }
    
    @Test
    public void compareTo_equalCityNameLowerZipCode_ShouldBeNegative(){
        City city1 = new City("1234","Leonding");
        City city2 = new City("2345","Leonding");
        assertEquals(-1,city1.compareTo(city2));
    }
    //TODO TestFall umgeschrieben.
    @Test
    public void compareTo_lowerCityNameHigherZipCode_ShouldBePositive(){
        City city1 = new City("2345","Wien");
        City city2 = new City("1234","Leonding");
        assertTrue(city1.compareTo(city2) > 0);
    }
    //TODO TestFall umgeschrieben.
    @Test
    public void compareTo_lowerCityName_ShouldBeNegative(){
        City city1 = new City("1234","Leonding");
        City city2 = new City("1234","Wien");
        assertTrue(city1.compareTo(city2) < 0);
    }
    //TODO TestFall umgeschrieben.
    @Test
    public void compareTo_higherCityName_ShouldBePositive(){
        City city1 = new City("1234","Linz");
        City city2 = new City("5555","Leonding");
        assertTrue(city1.compareTo(city2) > 0);
    }
    
}
