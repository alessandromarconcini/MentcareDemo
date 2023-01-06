package controllerTest;


import io.restassured.RestAssured;
import it.univr.mentcareDemo.main.Main;
import it.univr.mentcareDemo.model.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ReceptionistControllerTest {

    @BeforeAll
    public static void setBaseUri(){
        RestAssured.baseURI= "http://localhost:8080";
    }

    //TODO - è sbagliato l'input, cambiare controller
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void createAppointmentTest(){

        final Nurse nurse = new Nurse();
        final Patient patient = new Patient();
        final Doctor doctor = new Doctor();
        //final String nurse = "nur";
        //final String patient = "pat";
        //final String doctor = "doc";
        LocalDate date = LocalDate.now();

        // Da qui dovrebbere andare bene
        given()
                .contentType("application/json")
                .queryParam("nurse", nurse)
                .queryParam("patient", patient)
                .queryParam("doctor", doctor)
                .queryParam("date", date)

                .when()
                .post("/createAppointment/1/1/1")

                .then()
                .statusCode(200)
                .body("nurse", Matchers.is(nurse))
                .body("patient", Matchers.is(patient))
                .body("doctor",Matchers.is(doctor))
                .body("date",Matchers.is(date));


    }


    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void updateAppointmentTest(){


        given()
                .contentType("application/json")


                .when()
                .put("updateAppointment/1/1/1")


                .then()
                .statusCode(200);

    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void getReceptionistAppointmentListTest(){

        final List<Appointment> appointment = new ArrayList<>();

        given()
                .contentType("application/json")
                .pathParam("appointmentId", appointment)
                .when()
                .get("getReceptionistAppointmentList/{recptionistId}")
                .then()
                .statusCode(200)
                .body("appointment", Matchers.is(appointment));
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void deleteAppointmentTest(){

        final List<Appointment> appointment = new ArrayList<>();

        given()
                .contentType("application/json")
                .queryParam("appointment", appointment)
                .when()
                .put("deleteAppointment/1/1/1/1")
                .then()
                .statusCode(200)
                .body("appointment", Matchers.is(appointment));
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void searchPatientTest(){

        final Patient patient = new Patient();
        final Appointment appointment = new Appointment();

        given()
                .contentType("application/json")
                .queryParam("patient", patient)
                .pathParam("appointment", appointment)
                .when()
                .get("searchPatient/1/1/1")
                .then()
                .statusCode(200)
                .body("patient", Matchers.is(patient))
                .body("appointment", Matchers.is(appointment));
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void searchDoctorTest(){

        final Doctor doctor = new Doctor();

        given()
                .contentType("application/json")
                .queryParam("doctor", doctor)
                .when()
                .get("searchDoctor/1/1/1")
                .then()
                .statusCode(200)
                .body("doctor", Matchers.is(doctor));
    }

}
