package modelTest;

import it.univr.mentcareDemo.model.Event;
import it.univr.mentcareDemo.model.User;

import it.univr.mentcareDemo.model.enumeration.Action;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;


public class EventTest {


    // Testa un evento sprovvisto di campi
    @Test
    public void basicVoidEventInitialization(){

        Event testVoid = new Event();

        Assertions.assertNull(testVoid.getDate());
        Assertions.assertNull(testVoid.getAction());
        Assertions.assertNull(testVoid.getActor());
        Assertions.assertNull(testVoid.getId());
    }

    // Testa un farmaco standard
    @Test
    public void basicEventInitializationTest(){

        User actor = new User();
        LocalDate now = LocalDate.now();

        Event test0 = new Event(actor,now,Action.ACTION_TEST);

        Assertions.assertEquals(actor,test0.getActor());
        Assertions.assertEquals(now,test0.getDate());
        Assertions.assertEquals(Action.ACTION_TEST,test0.getAction());
    }
}