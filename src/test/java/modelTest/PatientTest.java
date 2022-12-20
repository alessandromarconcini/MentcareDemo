package modelTest;

import com.vaadin.flow.component.html.Pre;
import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientTest {

    // Testa un paziente
    @Test
    public void basicVoidPatientInitialization(){

        Patient testVoid = new Patient();

        Assertions.assertTrue(testVoid.isAPatient());
        Assertions.assertNull(testVoid.getPathology());
        Assertions.assertNull(testVoid.getPrescription());
        Assertions.assertEquals(0,testVoid.getAppointmentList().size());
        Assertions.assertEquals(false, testVoid.isDangerous()); //TODO
        Assertions.assertNull(testVoid.getPhoneNumber());
        Assertions.assertNull(testVoid.getName());
        Assertions.assertNull(testVoid.getSurname());
        Assertions.assertNull(testVoid.getFiscalCode());
        Assertions.assertNull(testVoid.getBirthday());
        Assertions.assertNull(testVoid.getBirthplace());
        Assertions.assertNull(testVoid.getPassword());

    }

    // Testa un paziente standard
    @Test
    public void basicPatientInitializationTest(){

        List<Appointment> al = new ArrayList<>();
        String name = "name";
        String surname = "surname";
        Prescription presc = new Prescription();
        String fiscalCode = "CNNLSN56G98F566Y";
        LocalDate birthday = LocalDate.now();
        String phoneNumber = "3456949888";
        String password = "pw";
        String birthplace = "UniVr";
        String pathology = "pat";

        Patient test0 = new Patient(al, name, surname, presc, password, fiscalCode,phoneNumber, birthplace, birthday, pathology);

        Assertions.assertTrue(test0.isAPatient());
        Assertions.assertEquals(false, test0.isDangerous()); //TODO
        Assertions.assertEquals(al,test0.getAppointmentList());
        Assertions.assertEquals(phoneNumber,test0.getPhoneNumber());
        Assertions.assertEquals(presc,test0.getPrescription());
        Assertions.assertEquals(pathology,test0.getPathology());
        Assertions.assertEquals(name, test0.getName());
        Assertions.assertEquals(surname, test0.getSurname());
        Assertions.assertEquals(password, test0.getPassword());
        Assertions.assertEquals(fiscalCode, test0.getFiscalCode());
        Assertions.assertEquals(birthplace, test0.getBirthplace());
        Assertions.assertEquals(birthday, test0.getBirthday());


    }
}
