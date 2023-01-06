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

        given()
                .contentType("application/json")
                .when()
                .get("getReceptionistAppointmentList/1")
                .then()
                .statusCode(200);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void deleteAppointmentTest(){

        given()
                .contentType("application/json")
                .when()
                .put("deleteAppointment/1/1/1/1")
                .then()
                .statusCode(200);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void searchPatientTest(){

        given()
                .contentType("application/json")
                .when()
                .get("searchPatient/1/1/1")
                .then()
                .statusCode(200);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void searchDoctorTest(){

        given()
                .contentType("application/json")
                .when()
                .get("searchDoctor/1/1/1")
                .then()
                .statusCode(200);
    }

}
