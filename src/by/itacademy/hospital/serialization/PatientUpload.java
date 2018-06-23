package by.itacademy.hospital.serialization;

import by.itacademy.hospital.domain.Patient;

import java.io.IOException;
import java.util.Set;

public interface PatientUpload {
    Set<Patient> execute() throws IOException;
}