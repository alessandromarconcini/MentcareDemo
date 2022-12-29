package modelTest;

import it.univr.mentcareDemo.model.Message;
import it.univr.mentcareDemo.model.Receptionist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ReceptionistTest {


    // Testa un receptionist sprovvisto di campi
    @Test
    public void basicVoidDoctorInitializationTest(){

        Receptionist testVoid = new Receptionist();

        Assertions.assertEquals(0,testVoid.getMessageList().size());
        /*Assertions.assertNull(testVoid.getName());
        Assertions.assertNull(testVoid.getBirthday());
        Assertions.assertNull(testVoid.getFiscalCode());
        Assertions.assertNull(testVoid.getPassword());
        Assertions.assertNull(testVoid.getSurname());
        Assertions.assertNull(testVoid.getBirthplace());
        Assertions.assertTrue(testVoid.isAReceptionist());*/
    }

    // Testa un receptionist standard
    @Test
    public void basicReceptionistInitializationTest(){

        List<Message> ml = new ArrayList<>();
        LocalDate now = LocalDate.now();

        Receptionist test0 = new Receptionist(ml,"name","surname","password","CNNLSN56G98F566Y","Univr",now);

        Assertions.assertEquals(ml,test0.getMessageList());
        /*Assertions.assertEquals("name",test0.getName());
        Assertions.assertEquals("surname",test0.getSurname());
        Assertions.assertEquals("password",test0.getPassword());
        Assertions.assertEquals("CNNLSN56G98F566Y",test0.getFiscalCode());
        Assertions.assertEquals("Univr",test0.getBirthplace());
        Assertions.assertEquals(now,test0.getBirthday());*/
        Assertions.assertTrue(test0.isAReceptionist());
    }
}
