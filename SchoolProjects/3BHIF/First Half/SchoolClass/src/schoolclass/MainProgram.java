package schoolclass;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

public class MainProgram {

    public static void main(String[] args) throws IOException, ParseException {
        System.out.println("SchoolClass");
        System.out.println("===========");
        SchoolClass schoolClass = new SchoolClass();
        Collection<City> cities = schoolClass.getCities();
        for(City city : cities){
             System.out.printf("%s (%-4s)\n", city.getName(), city.getZipCode());
             Collection<Pupil> pupils = schoolClass.getPupilsByCity(city);
             for(Pupil pupil : pupils){
                 System.out.printf("    %-30s %tF \n", pupil.getLastName()+" "+pupil.getFirstName(), pupil.getBirthDate());
             }
        }
    }
}
