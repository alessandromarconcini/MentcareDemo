package modelTest;

import model.*;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class DoctorTest {


    // Testa un dottore sprovvisto di campi
    @Test
    public void basicVoidDoctorInitializationTest(){

        Doctor testVoid = new Doctor();

        Assertions.assertEquals(0,testVoid.getAppointmentList().size());
        Assertions.assertEquals(0,testVoid.getMessageList().size());
        Assertions.assertEquals(0,testVoid.getPrescriptionList().size());
        Assertions.assertEquals(0,testVoid.getPatientList().size());
        Assertions.assertNull(testVoid.getName());
        Assertions.assertNull(testVoid.getPhoneNumber());
        Assertions.assertNull(testVoid.getSpecialization());
        Assertions.assertNull(testVoid.getBirthday());
        Assertions.assertNull(testVoid.getFiscalCode());
        Assertions.assertNull(testVoid.getPassword());
        Assertions.assertNull(testVoid.getSurname());
        Assertions.assertNull(testVoid.getBirthplace());

    }

    // Testa un dottore standard
    @Test
    public void basicDoctorInitializationTest(){

       List<Appointment> al = new ArrayList<>();
       List<Patient> pl = new ArrayList<>();
       List<Message> ml = new ArrayList<>();
       List<Prescription> prl = new ArrayList<>();
       LocalDate now = LocalDate.now();

       Doctor test0 = new Doctor(al,pl,ml,"3456949888",prl,"spec","name","surname","password","CNNLSN56G98F566Y","Univr",now);

       Assertions.assertEquals(al,test0.getAppointmentList());
       Assertions.assertEquals(pl,test0.getPatientList());
       Assertions.assertEquals(ml,test0.getMessageList());
       Assertions.assertEquals("3456949888",test0.getPhoneNumber());
       Assertions.assertEquals(prl,test0.getPrescriptionList());
       Assertions.assertEquals("spec",test0.getSpecialization());
    }
}