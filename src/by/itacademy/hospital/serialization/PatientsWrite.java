package by.itacademy.hospital.serialization;

import by.itacademy.hospital.domain.Patient;

import java.io.IOException;
import java.util.Set;

public interface PatientsWrite {
    void execute(Set<Patient> patients) throws IOException;
}
