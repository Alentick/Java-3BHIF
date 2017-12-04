import java.util.List;
import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;
import schoolclass.City;
import schoolclass.Pupil;
import schoolclass.Predicate;
import schoolclass.SchoolClass;

public class SchoolClassTest {
    
    @Test
    public void readPupilsFromCsv_readWithDoubles_checkCorrectCount() throws IOException, ParseException{
        Collection<Pupil> pupils = SchoolClass.readPupilsFromCsv("Pupils.csv");
        assertEquals(22, pupils.size());
    }
    
    @Test
    public void readPupilsFromCsv_readWithDoubles_checkCorrectOrderByBirthDate() throws IOException, ParseException{
        Collection<Pupil> pupils = SchoolClass.readPupilsFromCsv("Pupils.csv");
        Pupil[] pupilsArray = pupils.toArray(new Pupil[pupils.size()]);
        assertEquals("Urbanides", pupilsArray[21].getLastName());
        assertEquals("Midžic", pupilsArray[0].getLastName());
    }

    @Test
    public void readPupilsFromCsv_readWithDoubleCities_checkCorrectSizeOfCities() throws IOException, ParseException{
        SchoolClass schoolClass = new SchoolClass();
        assertEquals(16, schoolClass.getCities().size());
    }

    @Test
    public void readPupilsFromCsv_readWithDoubleCities_checkCorrectOrderOfCities() throws IOException, ParseException{
        SchoolClass schoolClass = new SchoolClass();
        City[] cities = schoolClass.getCities().toArray(new City[schoolClass.getCities().size()]);
        assertEquals("4861", cities[0].getZipCode());
        assertEquals("4060", cities[5].getZipCode());
        assertEquals("4224", cities[15].getZipCode());
    }

    @Test
    public void getPupilsByCity_Traun_shouldReturnHiebl() throws IOException, ParseException{
        SchoolClass schoolClass = new SchoolClass();
        City city = new City("4050", "Traun");
        List<Pupil> pupils = new LinkedList<>(schoolClass.getPupilsByCity(city));
        assertEquals(1, pupils.size());
        assertEquals("Hiebl", pupils.get(0).getLastName());
    }
    
    @Test
    public void getFilteredAndSortedPupils_LinzBirthDate_ShouldReturn() throws IOException, ParseException{
        SchoolClass schoolClass = new SchoolClass();
        Comparator<Pupil> birthDateComparator = new Comparator<Pupil>() {
            @Override
            public int compare(Pupil p1, Pupil p2) {
                int compareResult = p1.getBirthDate().compareTo(p2.getBirthDate());
                if (compareResult !=0) {
                    return compareResult;
                }
                return p1.getFirstName().compareTo(p2.getFirstName());
            }
        };
        Predicate<Pupil> cityPredicate = new Predicate<Pupil>() {
            @Override
            public boolean where(Pupil pupil) {
                return pupil.getCity().getName().equalsIgnoreCase("Linz");
            }
        };
        List<Pupil> pupils;
        pupils = new LinkedList<>(schoolClass.getFilteredAndSortedPupils(cityPredicate, birthDateComparator));
        assertEquals(5, pupils.size());
        assertEquals("Midžic", pupils.get(0).getLastName());
        assertEquals("Hofmann", pupils.get(4).getLastName());
    }
    

}
