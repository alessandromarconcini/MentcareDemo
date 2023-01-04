package controllerTest;

import io.restassured.RestAssured;
import it.univr.mentcareDemo.main.Main;
//import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PatientControllerTest {

    @BeforeAll
    public static void setBaseUri(){
        RestAssured.baseURI= "http://localhost:8080";
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void getPatientAllAppointmentsTest(){

        given()
                .contentType("application/json")
                .when()
                .get("getPatientAllAppointments/1")
                .then()
                .statusCode(200);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void getPatientDoctorTest(){

        given()
                .contentType("application/json")
                .when()
                .get("getPatientDoctor/1/1")
                .then()
                .statusCode(200);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void getPatientAllDrugsTest(){

        given()
                .contentType("application/json")
                .when()
                .get("getPatientAllDrugs/1/")
                .then()
                .statusCode(200);
    }
}
