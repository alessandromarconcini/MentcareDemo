package modelTest;

import it.univr.mentcareDemo.model.Appointment;
import it.univr.mentcareDemo.model.Nurse;
import it.univr.mentcareDemo.model.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class NurseTest {

    // Testa un infermiere
    @Test
    public void basicVoidNurseInitialization(){

        Nurse testVoid = new Nurse();

        Assertions.assertEquals(true, testVoid.isANurse());
        //Assertions.assertNull(testVoid.getName());
        //Assertions.assertNull(testVoid.getSurname());
        //Assertions.assertNull(testVoid.getFiscalCode());
        Assertions.assertEquals(0, testVoid.getAppointmentList().size());
        //Assertions.assertNull(testVoid.getBirthday());
        //Assertions.assertNull(testVoid.getBirthplace());
        //Assertions.assertNull(testVoid.getPassword());
        Assertions.assertEquals(0, testVoid.getDailyPatientList().size());
        Assertions.assertTrue(testVoid.isANurse());

    }

    // Testa un infermiere standard
    @Test
    public void basicNurseInitializationTest(){

        List<Appointment> appointmentList = new ArrayList<>();
        List<Patient> dailyPatientList = new ArrayList<>();
        String name = "name";
        String surname = "surname";
        String fiscalCode = "CNNLSN56G98F566Y";
        String birthDate = "1/1/2001";
        String password = "pw";
        String birthplace = "UniVr";

        Nurse test0 = new Nurse(appointmentList, dailyPatientList, name, surname,
                password, fiscalCode, birthplace, birthDate);

        Assertions.assertEquals(appointmentList, test0.getAppointmentList());
        Assertions.assertEquals(dailyPatientList, test0.getDailyPatientList());
        //Assertions.assertEquals(name, test0.getName());
        //Assertions.assertEquals(surname, test0.getSurname());
        //Assertions.assertEquals(password, test0.getPassword());
        //Assertions.assertEquals(fiscalCode, test0.getFiscalCode());
        //Assertions.assertEquals(birthplace, test0.getBirthplace());
        //Assertions.assertEquals(birthday, test0.getBirthday());
        Assertions.assertTrue(test0.isANurse());
    }
}