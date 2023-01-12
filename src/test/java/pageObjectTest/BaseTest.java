package pageObjectTest;

import it.univr.mentcareDemo.main.Main;
import org.apache.commons.lang3.SystemUtils;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.file.Paths;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, properties = "spring.autoconfigure.exclude=com.vaadin.flow.spring.SpringBootAutoConfiguration")
public class BaseTest {

    private WebDriver driver;
    @BeforeEach
    public void setUp() throws InterruptedException {
        org.openqa.selenium.chrome.ChromeOptions chrome_options = new ChromeOptions();
        chrome_options.addArguments("--headless"); //non visualizzo le interazione grafiche
        if (SystemUtils.IS_OS_WINDOWS) {
            System.setProperty("webdriver.gecko.driver",
                    Paths.get("src/test/resources/chromedriver_win32_96/chromedriver.exe").toString());
        } else if (SystemUtils.IS_OS_MAC) {
            System.setProperty("webdriver.gecko.driver",
                    Paths.get("src/test/resources/chromedriver_mac64_m1_96/chromedriver").toString());
        } else if (SystemUtils.IS_OS_LINUX) {
            System.setProperty("webdriver.gecko.driver",
                    Paths.get("src/test/java/geckodriver").toString());
        }
        if (driver == null) {
            //driver = new ChromeDriver(chrome_options);
            sleep(30000);
            driver = new FirefoxDriver();
        }
    }

    @Test
    public void testAEmpty(){


        driver.get("localhost:8080/home");
        MainViewPageObject mpo = new MainViewPageObject(driver);

        assertEquals("Ciao",mpo.getLabelText());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
