package by.itacademy.hospital.serialization.io;

import by.itacademy.hospital.domain.Patient;
import by.itacademy.hospital.serialization.PatientsWrite;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class PatientsWriteIO implements PatientsWrite {
    private String filename;

    public PatientsWriteIO(String filename) {
        this.filename = filename;
    }

    public void execute(Set<Patient> patients) throws IOException {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(new File(filename)))) {
            for (Patient patient : patients) {
                out.writeUTF(patient.getName());
                out.writeUTF(patient.getSurname());
                out.writeLong(patient.getBirth().getTime());
                out.writeBoolean(patient.isHealth());
            }
        }
    }

}
