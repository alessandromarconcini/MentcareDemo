package modelTest;

import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ClinicInitializationTest {


    // Testa una clinica sprovvista di campi
    @Test
    public void basicVoidClinicInitialization(){

        Clinic testVoid = new Clinic();

        Assertions.assertNull(testVoid.getName());
        Assertions.assertEquals(0,testVoid.getDoctorList().size());
        Assertions.assertEquals(0,testVoid.getPatientList().size());
        Assertions.assertEquals(0,testVoid.getNurseList().size());
        Assertions.assertNull(testVoid.getPhoneNumber());
    }

    // Testa una clinica standard
    @Test
    public void basicClinicInitializationTest(){

        List<Patient> pl = new ArrayList<>();
        List<Doctor> dl = new ArrayList<>();
        List<Nurse> nl = new ArrayList<>();

        Clinic test0 = new Clinic("name","3456949777",pl,dl,nl);

        Assertions.assertEquals("name",test0.getName());
        Assertions.assertEquals("3456949777",test0.getPhoneNumber());
        Assertions.assertEquals(pl,test0.getPatientList());
        Assertions.assertEquals(dl,test0.getDoctorList());
        Assertions.assertEquals(nl,test0.getNurseList());

    }
}
