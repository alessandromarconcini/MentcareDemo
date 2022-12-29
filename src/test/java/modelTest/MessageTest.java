package modelTest;

import it.univr.mentcareDemo.model.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MessageTest {


    // Testa un messaggio
    @Test
    public void basicVoidMessageInitialization(){

        Message testVoid = new Message();

        Assertions.assertNull(testVoid.getId());
        Assertions.assertNull(testVoid.getText());
    }

    // Testa un messaggio standard
    @Test
    public void basicMessageInitializationTest(){

        Message test0 = new Message("text");

        Assertions.assertEquals("text", test0.getText());

    }
}