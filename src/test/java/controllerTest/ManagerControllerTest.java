package controllerTest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import it.univr.mentcareDemo.main.Main;
import it.univr.mentcareDemo.model.*;
import org.hamcrest.Matchers;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
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
public class ManagerControllerTest {

    @BeforeAll
    public static void setBaseUri(){

        RestAssured.baseURI= "http://localhost:8080";
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void createUserTest(){

        final String name = "Alessandro";
        final String surname = "Marconcini";
        final String password = "PsW";
        final String fiscalCode = "FFFFFF00O67G777F";
        final String birthplace = "Legnago";
        final String birthDate = "31/10/2000";

        given()
                .contentType("application/json")
                .queryParam("name",name)
                .queryParam("surname",surname)
                .queryParam("password",password)
                .queryParam("fiscalCode",fiscalCode)
                .queryParam("birthplace",birthplace)
                .queryParam("birthDate",birthDate)
                .when()
                .post("createUser")
                .then()
                .statusCode(200)
                .body("id", Matchers.greaterThan(0))
                .body("name",Matchers.is(name))
                .body("surname",Matchers.is(surname))
                .body("password",Matchers.is(password))
                .body("fiscalCode",Matchers.is(fiscalCode))
                .body("birthplace",Matchers.is(birthplace))
                .body("birthDate",Matchers.is(birthDate));
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void createNurseTest(){

        final String name = "Alessandro";
        final String surname = "Marconcini";
        final String password = "PsW";
        final String fiscalCode = "FFFFFF00O67G777F";
        final String birthplace = "Legnago";
        final String birthDate = "111";
        final List<Appointment> appointmentList = new ArrayList<>();
        final List<Patient> dailyPatientList = new ArrayList<>();

        given()
                .contentType("application/json")
                .queryParam("name",name)
                .queryParam("surname",surname)
                .queryParam("password",password)
                .queryParam("fiscalCode",fiscalCode)
                .queryParam("birthplace",birthplace)
                .queryParam("birthDate",birthDate)
                .queryParam("appointmentList",appointmentList)
                .queryParam("dailyPatientList",dailyPatientList)
                .when()
                .post("createNurse")
                .then()
                .statusCode(200)
                .body("id", Matchers.greaterThan(0))
                .body("name",Matchers.is(name))
                .body("surname",Matchers.is(surname))
                .body("password",Matchers.is(password))
                .body("fiscalCode",Matchers.is(fiscalCode))
                .body("birthplace",Matchers.is(birthplace))
                .body("birthDate",Matchers.is(birthDate));
                //.body(jsonBody,Matchers.is(appointmentList))
                //.body(,Matchers.is(dailyPatientList));

    }
}
