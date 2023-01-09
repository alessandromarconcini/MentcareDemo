package modelTest;

import it.univr.mentcareDemo.model.*;
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
        Assertions.assertEquals(false, testVoid.isDangerous());
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
        String birthDate = "31/08/1998";
        String phoneNumber = "3456949888";
        String password = "pw";
        String birthplace = "UniVr";
        String pathology = "pat";
        Hospital hospital = new Hospital();

        Patient test0 = new Patient(al,presc,pathology,false,phoneNumber,hospital,name,surname,password,fiscalCode,birthplace,birthDate);

        Assertions.assertTrue(test0.isAPatient());
        Assertions.assertEquals(false, test0.isDangerous());
        Assertions.assertEquals(al,test0.getAppointmentList());
        Assertions.assertEquals(phoneNumber,test0.getPhoneNumber());
        Assertions.assertEquals(presc,test0.getPrescription());
        Assertions.assertEquals(pathology,test0.getPathology());
        Assertions.assertEquals(name, test0.getName());
        Assertions.assertEquals(surname, test0.getSurname());
        Assertions.assertEquals(password, test0.getPassword());
        Assertions.assertEquals(fiscalCode, test0.getFiscalCode());
        Assertions.assertEquals(birthplace, test0.getBirthplace());
        Assertions.assertEquals(birthDate, test0.getBirthday());


    }
}
