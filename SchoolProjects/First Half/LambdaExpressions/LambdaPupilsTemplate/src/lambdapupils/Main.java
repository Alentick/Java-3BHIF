package lambdapupils;

import entity.Pupil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * Eine Klassenliste ist aus einer csv-datei einzulesen, dann nach
 * zwei Bedingungen zu filtern, über einen generischen Comparer zu
 * sortieren und letztlich zu aggregieren und auszugeben.
 *
 * @author java@htl-leonding
 * ist aus einer csv-datei einzulesen, dann nach
 * zwei Bedingungen zu filtern, über einen generischen Comparer zu
 * sortieren und letztlich zu aggregieren und auszugeben.
 *
 * @author java@htl-leonding
 */
public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException, ParseException, FileNotFoundException, IOException {
        Stream<Pupil> pupilStream = Files.lines(Paths.get("pupils.csv"))
                .map(pupil -> new Pupil(pupil));
        System.out.println("Alle aus Linz nach Geburtsdatum");
        pupilStream
                .filter(linzPupil -> linzPupil.getCity().equalsIgnoreCase("Linz"))
                .sorted((p1,p2) -> p1.getBirthDate().compareTo(p2.getBirthDate()))
                .forEach(name -> System.out.println(name));
        pupilStream = Files.lines(Paths.get("pupils.csv"))
                .map(pupil -> new Pupil(pupil));
        System.out.println("Alle mit geradern Katalognummer");
        pupilStream
                .filter(p -> p.getNumber() % 2 == 0)
                .forEach(name -> System.out.println(name));
        pupilStream = Files.lines(Paths.get("pupils.csv"))
                .map(pupil -> new Pupil(pupil));
        System.out.println("Aus Leonding sind " + pupilStream
                .filter(leondingPupil -> leondingPupil.getCity().equalsIgnoreCase("Leonding"))
                .count() + " Schüler");
        pupilStream = Files.lines(Paths.get("pupils.csv"))
                .map(pupil -> new Pupil(pupil));
        long weeks = pupilStream.collect(Collectors.summarizingLong((Pupil p) -> {
            return Period.between(LocalDate.now(),LocalDate.parse((CharSequence) p.getBirthDate().toString()));
        }));
        System.out.println("Alle Schüler zusammen sind " + weeks + " Wochen alt");
        /*LinqArrayList<Pupil> schoolList = new LinqArrayList<>();
        
        List<String> lines = Files.readAllLines(Paths.get("pupils.csv"));
        lines.forEach(name -> {
            try {
                schoolList.add(new Pupil(name));
            } catch (ParseException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        System.out.println("Alle Schüler.");
        schoolList.forEach(name -> System.out.println(name));
        System.out.println("\nSchüler aus Linz und sotiert nach Geburtstag.");
        LinqArrayList<Pupil> linzPupils = (LinqArrayList<Pupil>) schoolList.select( student -> student.getCity().equals("Linz"));
        Collections.sort(linzPupils, (person1,person2) -> person1.getBirthDate().compareTo(person2.getBirthDate()));
        linzPupils.forEach(name -> System.out.println(name));
        System.out.println("\nSchüler mit gerader Katalognummer");
        LinqArrayList<Pupil> evenPupils = (LinqArrayList<Pupil>) schoolList.select(student -> student.getNumber() % 2 == 0);
        evenPupils.forEach(name -> System.out.println(name));
        LinqArrayList<Pupil> leondingPeople = (LinqArrayList<Pupil>) schoolList.select(student -> student.getCity().equals("Leonding"));
        System.out.println("\nAus Leonding sind " + leondingPeople.size() + " Schüler");
        LinqArrayList<Pupil> allAge = schoolList;
        int ageOfAllStudents = allAge.aggregate(0, new AggregateWeeks());
        System.out.println("\nAlle Schüler zusammen sind " + ageOfAllStudents + " Wochen alt");
        System.out.println("\n");
        LinqIterable<LinqIterable<Pupil>> groupedCityList = schoolList.groupBy((pupil1,pupil2)-> pupil1.getCity().compareTo(pupil2.getCity()));
        groupedCityList.orderBy((pupil1,pupil2) -> ((LinqArrayList<Pupil>) (pupil1)).get(0).getCity().compareTo(((LinqArrayList<Pupil>) (pupil2)).get(0).getCity()));
        groupedCityList.forEach(list -> {
            System.out.println("New City"); 
            list.forEach(name -> System.out.println(name));
                });
        */
    }
}
