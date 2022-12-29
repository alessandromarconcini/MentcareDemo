package modelTest;

import it.univr.mentcareDemo.model.Appointment;
import it.univr.mentcareDemo.model.Doctor;
import it.univr.mentcareDemo.model.Nurse;
import it.univr.mentcareDemo.model.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;


public class AppointmentTest {


    // Testa un appuntamento sprovvisto di campi
    @Test
    public void basicVoidAppointmentInitialization(){

        Appointment testVoid = new Appointment();

        Assertions.assertNull(testVoid.getDate());
        Assertions.assertNull(testVoid.getDoctor());
        Assertions.assertNull(testVoid.getNurse());
        Assertions.assertNull(testVoid.getPatient());
    }

    // Testa un appuntamento standard
    @Test
    public void basicAppointmentInitializationTest(){

        LocalDate now = LocalDate.now();
        Nurse nurse = new Nurse();
        Patient patient = new Patient();
        Doctor doctor = new Doctor();

        Appointment test0 = new Appointment(nurse,now,patient,doctor);

        Assertions.assertEquals(nurse,test0.getNurse());
        Assertions.assertEquals(now,test0.getDate());
        Assertions.assertEquals(doctor,test0.getDoctor());
        Assertions.assertEquals(patient,test0.getPatient());

    }
}