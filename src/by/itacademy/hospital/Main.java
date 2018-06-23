package by.itacademy.hospital;

import by.itacademy.hospital.domain.Hospital;
import by.itacademy.hospital.domain.Patient;
import by.itacademy.hospital.domain.Secretary;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Hospital hospital = new Hospital();
    hospital.add(new Patient("qqq11", "wwwww11", "1999-01-01", true));
      hospital.add(new Patient("qqq22", "wwwww22", "1999-01-01", true));
        hospital.add(new Patient("qqq33", "wwwww33", "1999-01-01", true));

        try {
            Secretary secretary = new Secretary(hospital);
          //secretary.writeIO();
           secretary.readIO();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(hospital);

    }
}
