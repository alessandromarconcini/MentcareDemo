package controllerTest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import it.univr.mentcareDemo.main.Main;
import it.univr.mentcareDemo.model.Drug;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DoctorControllerTest {

    @BeforeAll
    public static void setBaseUri(){
        RestAssured.baseURI= "http://localhost:8080";
    }

    //TODO Non passa
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void createPrescriptionTest(){

        final List<Drug> drugList = new ArrayList<>();
        final String textReport = "ReportByDoctor";

        given()
            .contentType("application/json")
            .queryParam("drugList", drugList)
            .queryParam("textReport", textReport)
        .when()
            .post("createPrescription/117/119")
        .then()
            .statusCode(200)
            .body("drugList", Matchers.is(drugList))
            .body("textReport", Matchers.is(textReport));

    }

    //TODO Non passa
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void updatePrescriptionTest(){

        final List<Drug> drugList = new ArrayList<>();
        final String textReport = "ReportByDoctor";

        given()
            .contentType("application/json")
            .queryParam("drugList", drugList)
            .queryParam("textReport", textReport)
        .when()
            .put("updatePrescription/1/1/1")
        .then()
            .statusCode(200)
            .body("drugList", Matchers.is(drugList))
            .body("textReport", Matchers.is(textReport));
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void deleteDrugFromPrescriptionTest(){

        given()
            .contentType("application/json")
        .when()
            .put("deleteDrugFromPrescription/1/1/1")
        .then()
            .statusCode(200);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void getDoctorAppointmentListTest(){

        given()
            .contentType("application/json")
        .when()
            .get("getDoctorAppointmentList/1")
        .then()
                .statusCode(200);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void getDoctorPatientListTest(){

        given()
            .contentType("application/json")
        .when()
            .get("getDoctorPatientList/1")
        .then()
            .statusCode(200);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void getDoctorMessageListTest(){

        given()
            .contentType("application/json")
        .when()
            .get("getDoctorMessageList/1")
        .then()
                .statusCode(200);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void etDoctorPrescriptionListTest(){

        given()
            .contentType("application/json")
        .when()
            .get("getDoctorPrescriptionList/1")
        .then()
            .statusCode(200);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void getDoctorPhoneNumberTest(){

        given()
            .contentType("application/json")
        .when()
            .get("getDoctorPhoneNumber/1")
        .then()
            .statusCode(200);
    }
}
