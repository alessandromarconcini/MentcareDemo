package modelTest;

import it.univr.mentcareDemo.model.Drug;
import it.univr.mentcareDemo.model.enumeration.DrugCost;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class DrugTest {


    // Testa un farmaco sprovvisto di campi
    @Test
    public void basicVoidDrugInitialization(){

        Drug testVoid = new Drug();

        Assertions.assertNull(testVoid.getName());
        Assertions.assertNull(testVoid.getAssignedDose());
        Assertions.assertNull(testVoid.getCost());
        Assertions.assertNull(testVoid.getFrequency());
        Assertions.assertNull(testVoid.getId());
        Assertions.assertNull(testVoid.getMaximumDose());
        Assertions.assertNull(testVoid.getMinimumDose());
    }

    // Testa un farmaco standard
    @Test
    public void basicDrugInitializationTest(){

        Drug test0 = new Drug("name",13.5F,14.5F,14.0F,"Quattro al volte al giorno", DrugCost.COST_TEST);

        Assertions.assertEquals("name",test0.getName());
        Assertions.assertEquals(13.5F,test0.getMinimumDose().floatValue());
        Assertions.assertEquals(14.5F,test0.getMaximumDose().floatValue());
        Assertions.assertEquals(14.0F,test0.getAssignedDose().floatValue());
        Assertions.assertEquals("Quattro al volte al giorno",test0.getFrequency());
        Assertions.assertEquals(DrugCost.COST_TEST,test0.getCost());

    }
}