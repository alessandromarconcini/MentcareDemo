package modelTest;

import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class NurseTest {


    // Testa un infermiere
    @Test
    public void basicVoidMessageInitialization(){

        Nurse testVoid = new Nurse();

        Assertions.assertEquals(true, testVoid.isANurse());
        Assertions.assertNull(testVoid.getName());
        Assertions.assertNull(testVoid.getSurname());
        Assertions.assertNull(testVoid.getFiscalCode());
        Assertions.assertEquals(0, testVoid.getAppointmentList().size());
        Assertions.assertNull(testVoid.getBirthday());
        Assertions.assertNull(testVoid.getBirthplace());
        Assertions.assertNull(testVoid.getPassword());
        Assertions.assertEquals(0, testVoid.getDailyPatientList().size());

    }

    // Testa un infermiere standard
    @Test
    public void basicMessageInitializationTest(){

        List<Appointment> appointmentList = new ArrayList<>();
        List<Patient> dailyPatientList = new ArrayList<>();
        String name = "name";
        String surname = "surname";
        String fiscalCode = "CNNLSN56G98F566Y";
        LocalDate birthday = LocalDate.now();
        String password = "pw";
        String birthplace = "UniVr";

        Nurse test0 = new Nurse(appointmentList, dailyPatientList, name, surname,
                password, fiscalCode, birthplace, birthday);

        Assertions.assertEquals(appointmentList, test0.getAppointmentList());
        Assertions.assertEquals(dailyPatientList, test0.getDailyPatientList());
        Assertions.assertEquals(name, test0.getName());
        Assertions.assertEquals(surname, test0.getSurname());
        Assertions.assertEquals(password, test0.getPassword());
        Assertions.assertEquals(fiscalCode, test0.getFiscalCode());
        Assertions.assertEquals(birthplace, test0.getBirthplace());
        Assertions.assertEquals(birthday, test0.getBirthday());
    }
}