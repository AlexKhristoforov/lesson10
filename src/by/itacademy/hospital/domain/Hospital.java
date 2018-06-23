package by.itacademy.hospital.domain;

import java.util.HashSet;
import java.util.Set;

public class Hospital {
    private Set<Patient> patients = new HashSet<>();

    public void add(Patient patient) {
        patients.remove(patient);
        patients.add(patient);
    }

    public void addAll(Set<Patient> patients) {
        this.patients.removeAll(patients);
        this.patients.addAll(patients);
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    @Override
    public String toString() {
        return "patients=" + patients +
                '}';
    }
}