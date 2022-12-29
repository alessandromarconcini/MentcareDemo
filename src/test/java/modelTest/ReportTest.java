package modelTest;

import it.univr.mentcareDemo.model.Report;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;


public class ReportTest {


    // Testa un report sprovvisto di campi
    @Test
    public void basicVoidReportInitialization(){

        Report testVoid = new Report();

        Assertions.assertNull(testVoid.getId());
        Assertions.assertNull(testVoid.getText());
        Assertions.assertNull(testVoid.getDate());
        Assertions.assertNull(testVoid.getName());
    }

    // Testa un report standard
    @Test
    public void basicReportInitializationTest(){

        LocalDate now = LocalDate.now();

        Report test0 = new Report(now,"name","text");

        Assertions.assertEquals("name",test0.getName());
        Assertions.assertEquals("text",test0.getText());
        Assertions.assertEquals(now,test0.getDate());
    }
}