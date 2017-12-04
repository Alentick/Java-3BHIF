package schoolclass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import schoolclass.Pupil;

public class SchoolClass {

    //TODO: Beide Sets in ein TreeSet verändert.
    private Set<Pupil> schoolSet = new TreeSet<>();
    private final Set<City> citySet = new TreeSet<>();

    
    public SchoolClass() throws IOException, ParseException {
        schoolSet = (Set<Pupil>) readPupilsFromCsv("Pupils.csv");
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
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        TreeSet<Pupil> set = new TreeSet<>();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        for(int i = 1; i < lines.size();i++){
            String[] line = lines.get(i).split(";");
            String zipcode = line[5];
            String cityName = line[6];
            City city = new City(line[5],line[6]);
            String adress = line[7] + " " + line[8];
            Pupil pupil = new Pupil(line[1],line[2],sdf.parse(line[4]),city,adress);
            set.add(pupil);
        }
        return set;
    }

    /**
     * Liefert die Cities der Klasse 
     * City wird bestimmt durch ZipCode und Name
     * Sortiert nach Namen und innerhalb gleicher Namen nach ZipCode
     *
     * @return alle unterschiedlichen Cities
     */
    
    
    public Collection<City> getCities() {
        schoolSet.forEach((a) -> {
            citySet.add(a.getCity());
        });
        return (Collection) citySet;
    }

    /**
     * *
     * Liefert die Schüler der Stadt, sortiert nach Nachnamen und dann nach
     * Vornamen zurück.
     *
     * @param city
     * @return
     */
    //TODO: In ein TreeSet geschrieben.
    public Collection<Pupil> getPupilsByCity(City city) {
        Set<Pupil> set = new TreeSet<>();
        schoolSet.stream().filter((a) -> (a.getCity().equals(city))).forEachOrdered((a) -> {
            set.add(a);
        });
        return set;
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
    
    //TODO Ganze Methode Schreiben
    public Collection<Pupil> getFilteredAndSortedPupils(
            Predicate<Pupil> whereClause, Comparator<Pupil> comparator) {
        ArrayList<Pupil> filteredPupils = new ArrayList();
        this.schoolSet.stream().filter((pupil) -> (whereClause.where(pupil))).forEachOrdered((pupil) -> {
            filteredPupils.add(pupil);
        });
        filteredPupils.sort(comparator);
        return filteredPupils;
    }
}
