package by.itacademy.hospital.domain;

import by.itacademy.hospital.serialization.PatientUpload;
import by.itacademy.hospital.serialization.PatientsRead;
import by.itacademy.hospital.serialization.PatientsWrite;
import by.itacademy.hospital.serialization.io.PatientsReadIO;
import by.itacademy.hospital.serialization.io.PatientsUpload;
import by.itacademy.hospital.serialization.io.PatientsWriteIO;
import by.itacademy.hospital.serialization.xml.PatientsReadSax;
import by.itacademy.hospital.serialization.xml.PatientsUploadXml;
import by.itacademy.hospital.serialization.xml.PatientsWriteDOM;

import java.io.IOException;
import java.net.MalformedURLException;

public class Secretary {
    private Hospital hospital;
    private PatientsUpload upload = new PatientsUpload("https://raw.githubusercontent.com/AlexKhristoforov/lesson10/master/PatientList.txt");
    private PatientsWrite write = new PatientsWriteDOM("PatientsList.xml");
    private PatientsRead read = new PatientsReadSax("PatientsList.xml");
    private PatientUpload uploadSax = new PatientsUploadXml("https://raw.githubusercontent.com/AlexKhristoforov/lesson10/master/PatientsList.xml");
    private PatientsRead readIO = new PatientsReadIO("PatientList.dat");
    private PatientsWrite writeIO = new PatientsWriteIO("PatientList.dat");

    public Secretary(Hospital hospital) throws MalformedURLException {
        this.hospital = hospital;
    }

    public void remoteAdd() throws IOException {
        hospital.addAll(upload.execute());
    }

    public void localWrite() throws IOException {
        write.execute(hospital.getPatients());
    }

    public void localRead() throws IOException {
        hospital.addAll(read.execute());
    }

    public void urlReadSax() throws IOException {
        hospital.addAll(read.execute());
    }

    public void readIO() throws IOException {
        hospital.addAll(readIO.execute());
    }

    public void writeIO() throws IOException {
        writeIO.execute(hospital.getPatients());
    }

}