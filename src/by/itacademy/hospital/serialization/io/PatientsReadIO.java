package by.itacademy.hospital.serialization.io;

import by.itacademy.hospital.domain.Patient;
import by.itacademy.hospital.serialization.PatientsRead;

import java.io.*;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class PatientsReadIO implements PatientsRead {
    private String fileName;

    public PatientsReadIO(String fileName) throws MalformedURLException {
        this.fileName = fileName;
    }

    public Set<Patient> execute() throws IOException {
        Set<Patient> patients = new HashSet<>();
        try (DataInputStream in = new DataInputStream(new FileInputStream(new File(fileName)))) {
                String name = in.readUTF();
                String surname = in.readUTF();
                Long birth = in.readLong();
                Boolean health = in.readBoolean();
                Date date = new Date(birth);
                patients.add(new Patient(name,surname,date,health));
        }
        return patients;
    }
}
