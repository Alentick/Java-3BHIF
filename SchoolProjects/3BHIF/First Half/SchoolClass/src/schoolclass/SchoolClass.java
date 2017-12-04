package schoolclass;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SchoolClass {

    TreeSet<Pupil> pupils;

    public SchoolClass() throws IOException, ParseException {
        pupils = (TreeSet)readPupilsFromCsv("Pupils.csv");
    }

    /**
     * *
     * Zum Programmstart wird die Schülerdatei in eine Collection (private field)
     * eingelesen und als Collection mit den zugehörigen Cities zurückgegeben
     *
     * @param fileName
     * @return Pulis mit ihren zugeordneten Cities
     * @throws IOException
     * @throws java.text.ParseException
     */
    public static Collection<Pupil> readPupilsFromCsv(String fileName) throws IOException, ParseException {
        List<String> lines = Files.readAllLines(Paths.get(fileName),
                Charset.forName("UTF-8"));
        TreeSet<City> cities = new TreeSet();
        TreeSet<Pupil> pupils = new TreeSet();
        for (int i = 1; i < lines.size(); i++) {
            String[] elements = lines.get(i).split(";");
            City city = new City(elements[5], elements[6]);
            if (!cities.add(city)) {  // city existiert bereits
                for (City c : cities) {
                    if (c.getName().equals(city.getName())
                            && c.getZipCode().equals(city.getZipCode())) {
                        city = c;
                        break;
                    }
                }
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyy");
            Date date = sdf.parse(elements[4]);
            Pupil pupil = new Pupil(elements[1], elements[2], date,
                    city, elements[7] + " " + elements[8]);
            pupils.add(pupil);
        }
        return pupils;
    }

    /**
     * Liefert die Cities der Klasse 
     * City wird bestimmt durch ZipCode und Name
     * Sortiert nach Namen und innerhalb gleicher Namen nach ZipCode
     *
     * @return alle unterschiedlichen Cities
     */
    public Collection<City> getCities() {
        TreeSet<City> cities = new TreeSet();
        pupils.forEach((pupil) -> {
            cities.add(pupil.getCity());
        });
        return cities;
    }

    /**
     * *
     * Liefert die Schüler der Stadt, sortiert nach Nachnamen und dann nach
     * Vornamen zurück.
     *
     * @param city
     * @return
     */
    public Collection<Pupil> getPupilsByCity(City city) {
        ArrayList<Pupil> filteredPupils = new ArrayList();
        for (Pupil pupil : this.pupils) {
            if (pupil.getCity().equals(city)) {
                filteredPupils.add(pupil);
            }
        }
        filteredPupils.sort(new Comparator<Pupil>() {
            @Override
            public int compare(Pupil p1, Pupil p2) {
                int compareResult = p1.getLastName().compareTo(p2.getLastName());
                if (compareResult != 0) {
                    return compareResult;
                }
                return p1.getFirstName().compareTo(p2.getFirstName());
            }
        });
        return filteredPupils;
        
      }

    /**
     * Filtert die Schüler auf Basis der whereClause, die übergeben wurde. Das
     * Ergebnis wird entsprechend dem ebenfalls übergebenen Comparator sortiert.
     *
     * @param whereClause FilterFunktion, die für jeden Pupil entscheidet, ob er
     * in der Ergebnismenge ist
     * @param comparator Vergleichsfunktion als Basis für die Sortierung
     * @return Gefilterte und sortierte Liste
     */
    public Collection<Pupil> getFilteredAndSortedPupils(
            Predicate<Pupil> whereClause, Comparator<Pupil> comparator) {
        ArrayList<Pupil> filteredPupils = new ArrayList();
        for (Pupil pupil : this.pupils) {
            if (whereClause.where(pupil)) {
                filteredPupils.add(pupil);
            }
        }
        filteredPupils.sort(comparator);
        return filteredPupils;
    }
}
