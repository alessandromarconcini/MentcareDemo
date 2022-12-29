package modelTest;

import it.univr.mentcareDemo.model.Hospital;
import it.univr.mentcareDemo.model.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class HospitalTest {


    // Testa un ospedale sprovvisto di campi
    @Test
    public void basicVoidHospitalInitialization(){

        Hospital testVoid = new Hospital();

        Assertions.assertNull(testVoid.getName());
        Assertions.assertEquals(0,testVoid.getPatientList().size());
        Assertions.assertNull(testVoid.getPhoneNumber());
        Assertions.assertNull(testVoid.getId());
        Assertions.assertNull(testVoid.getAddress());
        Assertions.assertNull(testVoid.getCountAvailability());
    }

    // Testa un ospedale standard
    @Test
    public void basicHospitalInitializationTest(){

        List<Patient> pl = new ArrayList<>();

        Hospital test0 = new Hospital("name","3456949777","Strade delle Grazie",pl,90);

        Assertions.assertEquals("name",test0.getName());
        Assertions.assertEquals("3456949777",test0.getPhoneNumber());
        Assertions.assertEquals("Strade delle Grazie",test0.getAddress());
        Assertions.assertEquals(90,test0.getCountAvailability());
        Assertions.assertEquals(pl,test0.getPatientList());
    }
}