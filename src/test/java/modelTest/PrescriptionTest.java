package modelTest;

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
        Assertions.assertEquals(0,testVoid.getDrugList().size());
        Assertions.assertNull(testVoid.getLastModify());

    }

    // Testa un prescrizione standard
    @Test
    public void basicPrescriptionInitializationTest(){

        List<Drug> drugList = new ArrayList<>();
        String textReport = "abc";
        LocalDate lastModify = LocalDate.now();

        Prescription test0 = new Prescription(textReport,drugList,lastModify);

        Assertions.assertEquals(drugList,test0.getDrugList());
        Assertions.assertEquals(textReport,test0.getTextReport());
        Assertions.assertEquals(lastModify,test0.getLastModify());



    }

    }
