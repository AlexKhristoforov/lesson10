package by.itacademy.hospital.serialization.xml;

import by.itacademy.hospital.domain.Patient;
import by.itacademy.hospital.serialization.PatientUpload;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Set;

public class PatientsUploadXml implements PatientUpload {
    private URL source;
    private final SAXParserFactory factory = SAXParserFactory.newInstance();

    public PatientsUploadXml(String source) throws MalformedURLException {
        this.source = new URL(source);
    }

    public Set<Patient> execute() throws IOException {
        SAXParser saxParser;
        try {
            saxParser = factory.newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            throw new IOException(e);
        }
        PatientsHandler patientsHandler = new PatientsHandler();
        try {
            URLConnection connection = source.openConnection();
            InputStream inputStream = connection.getInputStream();
            saxParser.parse(inputStream, patientsHandler);
        } catch (SAXException e) {
            throw new IOException(e);
        }
        return patientsHandler.getPatients();
    }

}
