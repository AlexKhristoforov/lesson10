package by.itacademy.hospital.serialization.io;

import by.itacademy.hospital.domain.Patient;
import by.itacademy.hospital.serialization.PatientUpload;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Set;

public class PatientsUpload implements PatientUpload {
    private URL source;

    public PatientsUpload(String source) throws MalformedURLException {
        this.source = new URL(source);
    }

    public Set<Patient> execute() throws IOException {
        Set<Patient> patients = new HashSet<>();
        URLConnection connection = source.openConnection();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                patients.add(new Patient(line));
            }
        }
        return patients;
    }
}