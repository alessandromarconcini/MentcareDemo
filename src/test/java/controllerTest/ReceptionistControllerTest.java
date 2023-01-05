package controllerTest;


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

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ReceptionistControllerTest {

    @BeforeAll
    public static void setBaseUri(){
        RestAssured.baseURI= "http://localhost:8080";
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void createAppointmentTest(){

        given()
                .contentType("application/json")

                .when()
                .post("createAppointment/1/1")

                .then()
                .statusCode(200);

    }






}
