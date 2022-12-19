package modelTest;

import model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;


public class UserInitializationTest {


    // Testa un utente sprovvisto di campi
    @Test
    public void basicVoidUserInitialization(){

        User testVoid = new User();

        Assertions.assertNull(testVoid.getName());
        Assertions.assertNull(testVoid.getSurname());
        Assertions.assertNull(testVoid.getPassword());
        Assertions.assertNull(testVoid.getFiscalCode());
        Assertions.assertNull(testVoid.getBirthplace());
        Assertions.assertNull(testVoid.getBirthday());
    }

    // Testa un utente standard
    @Test
    public void basicUserInitializationTest(){

        LocalDate now = LocalDate.now();
        User  test0 = new User("name","surname","1234","ADFSML51T48L676N","Borgo Roma",now);

        Assertions.assertEquals("name", test0.getName());
        Assertions.assertEquals("surname", test0.getSurname());
        Assertions.assertEquals("1234", test0.getPassword());
        Assertions.assertEquals("ADFSML51T48L676N", test0.getFiscalCode());
        Assertions.assertEquals("Borgo Roma", test0.getBirthplace());
        Assertions.assertEquals(now, test0.getBirthday());
    }
}
