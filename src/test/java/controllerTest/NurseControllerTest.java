package controllerTest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import it.univr.mentcareDemo.main.Main;
//import org.junit.Test;
import it.univr.mentcareDemo.model.Message;
import it.univr.mentcareDemo.model.Prescription;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class NurseControllerTest {

    @BeforeAll
    public static void setBaseUri(){
        RestAssured.baseURI= "http://localhost:8080";
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void getNurseHospitalListTest(){

        given()
                .contentType("application/json")
                .when()
                .get("getNurseHospitalList/1")
                .then()
                .statusCode(200);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void searchPatientTest(){

        given()
                .contentType("application/json")
                .when()
                .get("searchPatient/1/Alessandro")
                .then()
                .statusCode(200);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void makeDosingTest(){

        given()
                .contentType("application/json")
                .when()
                .put("makeDosing/1/1/1")
                .then()
                .statusCode(200);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void getNurseAppointmentListTest(){

        given()
                .contentType("application/json")
                .when()
                .get("getNurseAppointmentList/1")
                .then()
                .statusCode(200);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void getNurseDailyPatientListTest(){

        given()
                .contentType("application/json")
                .when()
                .get("getNurseDailyPatientList/1")
                .then()
                .statusCode(200);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void postRegistrationMessageTest(){

        //TODO Da fare

        /*Gson g = new GsonBuilder().create();
        String jsonbody = g.toJson(new Message("MyText"));

        given()
                .contentType("application/json")
                .body(jsonbody)
                .when()
                .post("postRegistrationMessage/1")
                .then()
                .statusCode(200)
                .body("text",Matchers.is("MyText")); */
    }
}