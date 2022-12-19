package modelTest;

import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ManagerTest {


    // Testa un membro dello staff di amministrazione sprovvisto di campi
    @Test
    public void basicVoidManagerInitialization(){

        Manager testVoid = new Manager();

        Assertions.assertNull(testVoid.getName());
        Assertions.assertNull(testVoid.getBirthday());
        Assertions.assertNull(testVoid.getBirthplace());
        Assertions.assertNull(testVoid.getFiscalCode());
        Assertions.assertNull(testVoid.getPassword());
        Assertions.assertNull(testVoid.getSurname());
    }

    // Testa un membro dello staff di amministrazione standard
    @Test
    public void basicManagerInitializationTest(){

        LocalDate now = LocalDate.now();

        Manager test0 = new Manager("name","surname","password","CNNLSN56G98F566Y","Univr",now);

        Assertions.assertEquals("name",test0.getName());
        Assertions.assertEquals("surname",test0.getSurname());
        Assertions.assertEquals("password",test0.getPassword());
        Assertions.assertEquals("CNNLSN56G98F566Y",test0.getFiscalCode());
        Assertions.assertEquals("Univr",test0.getBirthplace());
        Assertions.assertEquals(now,test0.getBirthday());
    }
}