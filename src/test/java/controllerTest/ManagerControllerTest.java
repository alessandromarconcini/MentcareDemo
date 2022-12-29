package controllerTest;

import io.restassured.RestAssured;
import main.Main;
import org.hamcrest.Matchers;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDate;

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
        final LocalDate now = LocalDate.now();

        given()
                .contentType("application/json")
                .queryParam("name",name)
                .queryParam("surname",surname)
                .queryParam("password",password)
                .queryParam("fiscalCode",fiscalCode)
                .queryParam("birthplace",birthplace)
                .queryParam("birthday",now)
                .when()
                .post("~/createUser")
                .then()
                .statusCode(201)
                .body("id", Matchers.greaterThan(0))
                .body("name",Matchers.is(name))
                .body("surname",Matchers.is(surname))
                .body("password",Matchers.is(password))
                .body("fiscalCode",Matchers.is(fiscalCode))
                .body("birthplace",Matchers.is(birthplace))
                .body("birthday",Matchers.is(now));
    }
}
