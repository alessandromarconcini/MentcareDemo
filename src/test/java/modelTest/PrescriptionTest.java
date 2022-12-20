package modelTest;

import com.vaadin.flow.component.html.Pre;
import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionTest {

    // Testa una prescrizione
    @Test
    public void basicVoidPrescriptionInitialization() {

        Prescription testVoid = new Prescription();

        Assertions.assertNull(testVoid.getTextReport());
        Assertions.assertNull(testVoid.getDrugList());
        Assertions.assertNull(testVoid.getLastModify());

    }

    // Testa un prescrizione standard
    @Test
    public void basicPrescriptionInitializationTest(){

        List<Drug> drugList = new ArrayList<>();
        String textReport = "abc";
        LocalDate lastModify = LocalDate.now();

        Prescription test0 = new Prescription(drugList, textReport, lastModify);

        Assertions.assertEquals(drugList,test0.getDrugList());
        Assertions.assertEquals(textReport,test0.getTextReport());
        Assertions.assertEquals(lastModify,test0.getLastModify());



    }

    }
