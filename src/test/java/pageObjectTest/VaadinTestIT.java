package pageObjectTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import it.univr.mentcareDemo.main.Main;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class VaadinTestIT {
    @Test
    public void firstTest(){

        WebDriverManager.firefoxdriver().setup();
        var driver = new FirefoxDriver();
        MainViewPageObject mpo = new MainViewPageObject(driver);

        try{

            new WebDriverWait(driver,ofSeconds(30),ofSeconds(1)).until(titleIs("Ciao"));

            driver.get("localhost:8080/home");

            Assertions.assertEquals("Ciao", mpo.getLabelText());
        } finally {
            driver.quit();
        }
    }
}
